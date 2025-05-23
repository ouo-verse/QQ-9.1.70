package com.tencent.hippy.qq.update;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.update.patch.PatchUtil;
import com.tencent.hippy.qq.update.sign.MD5;
import com.tencent.hippy.qq.update.sso.BundleInfo;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyNetworkUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.IFlowControlService;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyUpdateManager {
    private static final String KEY_DOWNLOAD_WAIT_TIME = "downloadWaitTime";
    public static final String PREFIX = "hippyUpdateAction-";
    public static final int SERVER_STATUS_CODE_NO_UPDATE = 2;
    public static final int SERVER_STATUS_CODE_SUCCESS = 1;
    public static final String TAG = "hippyUpdateAction-HippyUpdateManager";
    public static final int UPDATE_JS_BUNDLE_TYPE_PRELODAD = 1;
    public static final int UPDATE_JS_BUNDLE_TYPE_SINGLE = 2;
    private static final int UPDATE_TYPE_DIFF_PKG = 2;
    private static final int UPDATE_TYPE_FULL_PKG = 1;
    private static final int UPDATE_TYPE_FULL_PKG_AFTER_DIFF_ERR = 3;
    private static volatile HippyUpdateManager sHippyUpdateManager;
    private final HashMap<String, Long> mJsBundleLastUpdateTimes = new HashMap<>();
    private final HashMap<String, ArrayList<IUpdateListener>> mJsBundleUpdateListeners = new HashMap<>();

    HippyUpdateManager() {
        HippyNetworkUtils.registerWeakNetworkObserver();
    }

    private void downloadJsBundleImmediately(Intent intent, BundleInfo bundleInfo, boolean z16) {
        String str;
        if (((IHippySetting) QRoute.api(IHippySetting.class)).isClearingCache()) {
            notifyJsBundleUpdate(intent, bundleInfo.bundleName, -4, "clearing cache");
            return;
        }
        if (z16) {
            str = bundleInfo.diffPkgUrl;
        } else {
            str = bundleInfo.downloadUrl;
        }
        File downloadFile = bundleInfo.getDownloadFile(z16);
        g gVar = new g(str, downloadFile);
        gVar.U = true;
        gVar.Q = true;
        gVar.f313008f = 2;
        gVar.W = true;
        gVar.X = true;
        gVar.D = true;
        long currentTimeMillis = System.currentTimeMillis();
        int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.waitAppRuntime(null));
        intent.putExtra(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, System.currentTimeMillis() - currentTimeMillis);
        if (download == 0 && downloadFile.exists() && downloadFile.length() > 0) {
            if (!bundleInfo.checkMd5(MD5.getFileMd5(downloadFile.getAbsolutePath()), z16)) {
                notifyJsBundleUpdate(intent, bundleInfo.bundleName, -3, null);
                return;
            } else if (z16) {
                onDiffFileDownloaded(intent, bundleInfo, downloadFile);
                return;
            } else {
                onFullJsBundleDownloaded(intent, bundleInfo, downloadFile);
                return;
            }
        }
        notifyJsBundleUpdate(intent, bundleInfo.bundleName, -4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadJsBundleInSubThread(final Intent intent, final BundleInfo bundleInfo) {
        intent.putExtra("bundleSize", bundleInfo.bundleSize);
        intent.putExtra("diffSize", bundleInfo.diffPkgSize);
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.update.d
            @Override // java.lang.Runnable
            public final void run() {
                HippyUpdateManager.this.lambda$downloadJsBundleInSubThread$0(intent, currentTimeMillis, bundleInfo);
            }
        }, 128, null, true);
    }

    private HashMap<String, String> generateUpdateJSCosts(Intent intent, int i3) {
        int i16;
        long longExtra = intent.getLongExtra(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, 0L);
        long longExtra2 = intent.getLongExtra("unzipTime", 0L);
        long longExtra3 = intent.getLongExtra("requestTime", 0L);
        long longExtra4 = intent.getLongExtra("diffTime", 0L);
        long longExtra5 = intent.getLongExtra("diffErrCode", 0L);
        long longExtra6 = intent.getLongExtra("bundleSize", 0L);
        long longExtra7 = intent.getLongExtra("diffSize", 0L);
        long longExtra8 = intent.getLongExtra(KEY_DOWNLOAD_WAIT_TIME, 0L);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reportFrom", intent.getStringExtra("reportFrom"));
        hashMap.put(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, String.valueOf(longExtra));
        hashMap.put("unzipTime", String.valueOf(longExtra2));
        hashMap.put("requestTime", String.valueOf(longExtra3));
        hashMap.put("diffTime", String.valueOf(longExtra4));
        hashMap.put("diffErrCode", String.valueOf(longExtra5));
        hashMap.put("bundleSize", String.valueOf(longExtra6));
        hashMap.put("diffSize", String.valueOf(longExtra7));
        hashMap.put(KEY_DOWNLOAD_WAIT_TIME, String.valueOf(longExtra8));
        if (i3 == 0) {
            if (longExtra4 > 0) {
                if (longExtra5 == 0) {
                    i16 = 2;
                } else {
                    i16 = 3;
                }
            } else {
                i16 = 1;
            }
            hashMap.put("updateResult", String.valueOf(i16));
        }
        return hashMap;
    }

    public static HippyUpdateManager getInstance() {
        if (sHippyUpdateManager == null) {
            synchronized (HippyUpdateManager.class) {
                if (sHippyUpdateManager == null) {
                    sHippyUpdateManager = new HippyUpdateManager();
                }
            }
        }
        return sHippyUpdateManager;
    }

    private void handleUpdateConfigResponse(final Intent intent, final String str, int i3, String str2) {
        final BundleInfo bundleInfo;
        intent.putExtra("requestTime", NetConnInfoCenter.getServerTimeMillis() - intent.getLongExtra("requestStartTime", 0L));
        if (i3 != 1 && i3 != 2) {
            notifyJsBundleUpdate(intent, str, -5, "ret " + i3);
            return;
        }
        ArrayList<BundleInfo> parseBundleList = BundleInfo.parseBundleList(str2);
        if (parseBundleList != null) {
            Iterator<BundleInfo> it = parseBundleList.iterator();
            bundleInfo = null;
            while (it.hasNext()) {
                BundleInfo next = it.next();
                if (str.equals(next.bundleName)) {
                    bundleInfo = next;
                }
            }
        } else {
            bundleInfo = null;
        }
        if (bundleInfo == null) {
            notifyJsBundleUpdate(intent, str, 1, null);
            return;
        }
        if (UpdateSetting.getInstance().isModuleVersionFileExists(bundleInfo.bundleName, bundleInfo.bundleVersion)) {
            UpdateSetting.getInstance().setModuleVersion(bundleInfo.bundleName, bundleInfo.bundleVersion);
            notifyJsBundleUpdate(intent, bundleInfo.bundleName, 101, "js bundle exists");
        } else if (TextUtils.isEmpty(bundleInfo.downloadUrl)) {
            notifyJsBundleUpdate(intent, str, -5, "download url is empty");
        } else if (!intent.getBooleanExtra(IHippyUpdate.EXTRA_KEY_IS_CONTROL_FLOW, false)) {
            downloadJsBundleInSubThread(intent, bundleInfo);
        } else {
            ((IFlowControlService) QRoute.api(IFlowControlService.class)).reqHippyFlowControl(bundleInfo.downloadUrl, new IFlowControlService.OnFlowControlListener() { // from class: com.tencent.hippy.qq.update.HippyUpdateManager.2
                @Override // com.tencent.mobileqq.soload.api.IFlowControlService.OnFlowControlListener
                public void onLimited(int i16, long j3) {
                    HippyUpdateManager.this.notifyJsBundleUpdate(intent, str, -14, "Flow Control code:" + i16);
                }

                @Override // com.tencent.mobileqq.soload.api.IFlowControlService.OnFlowControlListener
                public void onSuccess(int i16) {
                    HippyUpdateManager.this.downloadJsBundleInSubThread(intent, bundleInfo);
                }
            });
        }
    }

    private void handleUpdateJsBundle(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp, String str) {
        String stringExtra = intent.getStringExtra("jsBundleName");
        CommonMobileConfQueryRsp parseUpdateJsBundleRsp = parseUpdateJsBundleRsp(intent, j3, trpcInovkeRsp, stringExtra);
        if (parseUpdateJsBundleRsp == null) {
            return;
        }
        boolean isCheckPreloadSuccess = isCheckPreloadSuccess(intent, parseUpdateJsBundleRsp.confList.get());
        boolean z16 = false;
        for (MobileConfRsp mobileConfRsp : parseUpdateJsBundleRsp.confList.get()) {
            int i3 = mobileConfRsp.ret.get();
            String str2 = mobileConfRsp.conf.get();
            int i16 = mobileConfRsp.configType.get();
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        HippyTabConfigManager.handleTabConfigResponse(i3, str2, str);
                    }
                } else {
                    if (isCheckPreloadSuccess) {
                        handleUpdateConfigResponse(intent, stringExtra, i3, str2);
                    } else {
                        notifyJsBundleUpdate(intent, stringExtra, 2, "preload not allowed");
                    }
                    z16 = true;
                }
            } else {
                HippyPredownloadManager.getInstance().handleHippyConfigResponse(i3, str2, str);
            }
        }
        if (!z16) {
            notifyJsBundleUpdate(intent, stringExtra, -5, "no update config");
        }
    }

    private boolean isCheckPreloadSuccess(Intent intent, List<MobileConfRsp> list) {
        String str;
        if (!intent.getBooleanExtra(IHippyUpdate.EXTRA_KEY_IS_CHECK_PRELOAD, false)) {
            return true;
        }
        Iterator<MobileConfRsp> it = list.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            MobileConfRsp next = it.next();
            if (next.configType.has() && next.configType.get() == 6) {
                if (next.conf.has()) {
                    str = next.conf.get();
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                int optInt = new JSONObject(str).optInt("needPreload");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "isCheckPreloadSuccess needPreload:" + optInt);
                }
                if (optInt != 1) {
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "isCheckPreloadSuccess e:" + th5);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadJsBundleInSubThread$0(Intent intent, long j3, BundleInfo bundleInfo) {
        intent.putExtra(KEY_DOWNLOAD_WAIT_TIME, System.currentTimeMillis() - j3);
        downloadJsBundleImmediately(intent, bundleInfo, bundleInfo.canDiffUpdate(intent.getIntExtra("curVersion", -1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJsBundleUpdate(Intent intent, String str, int i3, String str2) {
        HashMap<String, ArrayList<IUpdateListener>> hashMap;
        HashMap<String, ArrayList<IUpdateListener>> hashMap2;
        if (!TextUtils.isEmpty(str) && intent != null) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - intent.getLongExtra("requestStartTime", 0L);
            if (QLog.isColorLevel() || i3 != 0) {
                QLog.i(TAG, 2, "notifyJsBundleUpdate bundleName:" + str + " retCode:" + i3 + " retMsg:" + str2 + " cost:" + serverTimeMillis);
            }
            HashMap<String, String> hashMap3 = new HashMap<>();
            if (i3 != -5 && i3 != 2) {
                hashMap3 = generateUpdateJSCosts(intent, i3);
            }
            HashMap<String, String> hashMap4 = hashMap3;
            HashMap<String, ArrayList<IUpdateListener>> hashMap5 = this.mJsBundleUpdateListeners;
            synchronized (hashMap5) {
                try {
                    ArrayList<IUpdateListener> arrayList = this.mJsBundleUpdateListeners.get(str);
                    if (arrayList != null) {
                        Iterator<IUpdateListener> it = arrayList.iterator();
                        while (it.hasNext()) {
                            IUpdateListener next = it.next();
                            if (i3 == 0) {
                                next.onUpdateSuccess(0, str, hashMap4);
                                hashMap = hashMap5;
                            } else {
                                hashMap = hashMap5;
                                try {
                                    next.onUpdateFailed(0, i3, str2, str, hashMap4);
                                } catch (Throwable th5) {
                                    th = th5;
                                    throw th;
                                }
                            }
                            hashMap5 = hashMap;
                        }
                        hashMap2 = hashMap5;
                        arrayList.clear();
                    } else {
                        hashMap2 = hashMap5;
                    }
                    if (i3 != 1 && i3 != 2) {
                        reportJsUpdateEvent(intent, str, i3, str2, serverTimeMillis);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    hashMap = hashMap5;
                }
            }
        } else {
            QLog.i(TAG, 1, "notifyJsBundleUpdate bundleName or request is null");
        }
    }

    private void onDiffFileDownloaded(Intent intent, BundleInfo bundleInfo, File file) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int intExtra = intent.getIntExtra("curVersion", -1);
            File jsBundleZipFile = HippyQQFileUtil.getJsBundleZipFile(bundleInfo.bundleName, intExtra);
            File jsBundleZipFile2 = HippyQQFileUtil.getJsBundleZipFile(bundleInfo.bundleName, bundleInfo.bundleVersion);
            PatchUtil.DiffResultCodes patch = PatchUtil.patch(jsBundleZipFile.getAbsolutePath(), jsBundleZipFile2.getAbsolutePath(), file.getAbsolutePath(), bundleInfo.diffQarFileMd5);
            intent.putExtra("diffTime", System.currentTimeMillis() - currentTimeMillis);
            if (patch != PatchUtil.DiffResultCodes.SUCCESS) {
                onDiffPkgError(intent, bundleInfo, file, patch);
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean unzipModulePackage = HippyQQFileUtil.unzipModulePackage(jsBundleZipFile2, bundleInfo.bundleName, bundleInfo.bundleVersion);
            intent.putExtra("unzipTime", System.currentTimeMillis() - currentTimeMillis2);
            if (!unzipModulePackage) {
                onDiffPkgError(intent, bundleInfo, file, PatchUtil.DiffResultCodes.UNZIP_FULL_PKG_FAILED);
                return;
            }
            UpdateSetting.getInstance().setModuleVersion(bundleInfo.bundleName, bundleInfo.bundleVersion);
            notifyJsBundleUpdate(intent, bundleInfo.bundleName, 0, null);
            if (intExtra > 0) {
                HippyQQFileUtil.cleanHistoryVersion(bundleInfo.bundleName, intExtra);
                HippyQQFileUtil.cleanHistoryPkg(bundleInfo.bundleName, intExtra);
            }
            file.delete();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "diff error:" + th5);
            onDiffPkgError(intent, bundleInfo, file, PatchUtil.DiffResultCodes.UNKNOWN);
        }
    }

    private void onDiffPkgError(Intent intent, BundleInfo bundleInfo, File file, PatchUtil.DiffResultCodes diffResultCodes) {
        QLog.e(TAG, 1, "onDiffPkgError errorCode:" + diffResultCodes.ordinal());
        intent.putExtra("diffErrCode", diffResultCodes.ordinal());
        file.delete();
        downloadJsBundleImmediately(intent, bundleInfo, false);
    }

    private void onFullJsBundleDownloaded(Intent intent, BundleInfo bundleInfo, File file) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            boolean unzipModulePackage = HippyQQFileUtil.unzipModulePackage(file, bundleInfo.bundleName, bundleInfo.bundleVersion);
            intent.putExtra("unzipTime", System.currentTimeMillis() - currentTimeMillis);
            if (unzipModulePackage) {
                UpdateSetting.getInstance().setModuleVersion(bundleInfo.bundleName, bundleInfo.bundleVersion);
                notifyJsBundleUpdate(intent, bundleInfo.bundleName, 0, null);
                int intExtra = intent.getIntExtra("curVersion", 0);
                if (intExtra > 0) {
                    HippyQQFileUtil.cleanHistoryVersion(bundleInfo.bundleName, intExtra);
                    HippyQQFileUtil.cleanHistoryPkg(bundleInfo.bundleName, intExtra);
                }
            } else {
                notifyJsBundleUpdate(intent, bundleInfo.bundleName, -1, null);
            }
        } catch (Throwable th5) {
            notifyJsBundleUpdate(intent, bundleInfo.bundleName, -1, "unZipFile file error:" + th5);
        }
    }

    private CommonMobileConfQueryRsp parseUpdateJsBundleRsp(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp, String str) {
        QLog.i(TAG, 1, "handleUpdateJsBundle retCode:" + j3 + " bundle:" + str);
        if (intent != null && !TextUtils.isEmpty(str)) {
            if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.has()) {
                try {
                    CommonMobileConfQueryRsp commonMobileConfQueryRsp = new CommonMobileConfQueryRsp();
                    commonMobileConfQueryRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    if (!commonMobileConfQueryRsp.confList.has()) {
                        notifyJsBundleUpdate(intent, str, -5, "configRsp is empty");
                        return null;
                    }
                    return commonMobileConfQueryRsp;
                } catch (Throwable th5) {
                    notifyJsBundleUpdate(intent, str, -5, "handleUpdateJsBundle e:" + th5);
                    return null;
                }
            }
            notifyJsBundleUpdate(intent, str, -5, "net error code:" + j3);
            return null;
        }
        QLog.e(TAG, 1, "handleUpdateJsBundle request is null or bundleName is empty");
        return null;
    }

    private void reportJsUpdateEvent(Intent intent, String str, int i3, String str2, long j3) {
        int i16;
        HashMap<String, String> generateUpdateJSCosts = generateUpdateJSCosts(intent, i3);
        if (intent.getBooleanExtra("isUseHttpRequest", false)) {
            i16 = 5;
        } else {
            i16 = 11;
        }
        HippyReporter.getInstance().reportCheckUpdate(str, i16, i3, str2, j3, generateUpdateJSCosts);
    }

    private void updateJsBundleByHttp(final String str, int i3, final Bundle bundle, IUpdateListener iUpdateListener) {
        new HippyQQUpdateManager().checkUpdate(str, new PackageUpdateListener() { // from class: com.tencent.hippy.qq.update.HippyUpdateManager.1
            @Override // com.tencent.hippy.qq.api.PackageUpdateListener
            public void onUpdateComplete(int i16, String str2, String str3) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                HippyUpdateManager.this.notifyJsBundleUpdate(intent, str, i16, str2);
            }
        });
    }

    private void updateJsBundleBySSO(String str, int i3, Bundle bundle, int i16, IUpdateListener iUpdateListener) {
        long j3;
        boolean z16;
        if (this.mJsBundleLastUpdateTimes.containsKey(str)) {
            j3 = this.mJsBundleLastUpdateTimes.get(str).longValue();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        HippyUnissoHandler hippyUnissoHandler = HippyUnissoHandler.getInstance();
        if (hippyUnissoHandler != null) {
            hippyUnissoHandler.requestHippyConfig(i16, str, i3, j16, bundle);
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (iUpdateListener != null) {
                removeJsBundleUpdateListener(str, iUpdateListener);
                iUpdateListener.onUpdateFailed(0, -5, "gcHandler is null", str, null);
            }
            QLog.e(TAG, 1, "updateJsBundle gcHandler is null.");
        }
    }

    public boolean checkUpdateJsBundleInterval(String str) {
        return checkUpdateJsBundleInterval(str, HippyPredownloadManager.getInstance().getHippyConfig().checkUpdateGap);
    }

    public void handleAllResponses(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        Intent intent2 = new Intent(intent);
        int intExtra = intent2.getIntExtra("source", 0);
        String stringExtra = intent2.getStringExtra("uin");
        if (stringExtra != null && !stringExtra.equals(HippyAccessHelper.getCurrentUin())) {
            QLog.e(TAG, 1, "[handleResponse] current uin change. return.");
            return;
        }
        if (intExtra != 1 && intExtra != 2) {
            if (intExtra == 3 || intExtra == 4) {
                handleUpdateJsBundle(intent2, j3, trpcInovkeRsp, stringExtra);
                return;
            }
            return;
        }
        HippyPredownloadManager.getInstance().handleAllConfigResponses(intent2, j3, trpcInovkeRsp, stringExtra);
    }

    public void removeJsBundleUpdateListener(String str, IUpdateListener iUpdateListener) {
        if (!TextUtils.isEmpty(str) && iUpdateListener != null) {
            synchronized (this.mJsBundleUpdateListeners) {
                ArrayList<IUpdateListener> arrayList = this.mJsBundleUpdateListeners.get(str);
                if (arrayList != null) {
                    arrayList.remove(iUpdateListener);
                }
            }
        }
    }

    public void updateJsBundle(String str, boolean z16, int i3, Bundle bundle, IUpdateListener iUpdateListener) {
        String str2;
        int i16;
        boolean z17;
        int i17;
        boolean z18;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            if (iUpdateListener != null) {
                iUpdateListener.onUpdateFailed(0, -5, "Net unavailable", str, null);
                return;
            }
            return;
        }
        int moduleVersion = UpdateSetting.getInstance().getModuleVersion(str);
        boolean z19 = false;
        if (moduleVersion < 0) {
            moduleVersion = 0;
        }
        if (bundle != null) {
            z17 = bundle.getBoolean(IHippyUpdate.EXTRA_KEY_IS_CHECK_PRELOAD);
            i17 = bundle.getInt(IHippyUpdate.EXTRA_KEY_PRELOAD_SCENE_TYPE);
            z18 = bundle.getBoolean(IHippyUpdate.EXTRA_KEY_IS_SKIP_INTERVAL);
            str2 = bundle.getString("reportFrom");
            i16 = bundle.getInt(OpenHippyInfo.EXTRA_KEY_MIN_JS_BUNDLE_VERSION);
        } else {
            str2 = null;
            i16 = 0;
            z17 = false;
            i17 = 0;
            z18 = false;
        }
        if (moduleVersion < i16) {
            z18 = true;
        }
        if (!z18 && moduleVersion > 0 && !checkUpdateJsBundleInterval(str)) {
            if (iUpdateListener != null) {
                iUpdateListener.onUpdateFailed(0, -5, "Check update interval", str, null);
                return;
            }
            return;
        }
        synchronized (this.mJsBundleUpdateListeners) {
            ArrayList<IUpdateListener> arrayList = this.mJsBundleUpdateListeners.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mJsBundleUpdateListeners.put(str, arrayList);
            }
            if (arrayList.size() >= 1) {
                z19 = true;
            }
            if (iUpdateListener != null && !arrayList.contains(iUpdateListener)) {
                arrayList.add(iUpdateListener);
            }
            if (z19) {
                QLog.i(TAG, 1, "updateJsBundle bundle:" + str + " is downloading");
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("source", 4);
            bundle2.putBoolean("isUseHttpRequest", z16);
            bundle2.putBoolean(IHippyUpdate.EXTRA_KEY_IS_CHECK_PRELOAD, z17);
            bundle2.putInt(IHippyUpdate.EXTRA_KEY_PRELOAD_SCENE_TYPE, i17);
            bundle2.putString("jsBundleName", str);
            bundle2.putLong("requestStartTime", NetConnInfoCenter.getServerTimeMillis());
            bundle2.putInt("curVersion", moduleVersion);
            bundle2.putString("uin", HippyAccessHelper.getCurrentUin());
            bundle2.putString("reportFrom", str2);
            if (z16) {
                updateJsBundleByHttp(str, moduleVersion, bundle2, iUpdateListener);
            } else {
                updateJsBundleBySSO(str, moduleVersion, bundle2, i3, iUpdateListener);
            }
            this.mJsBundleLastUpdateTimes.put(str, Long.valueOf(NetConnInfoCenter.getServerTime()));
        }
    }

    public boolean checkUpdateJsBundleInterval(String str, long j3) {
        if (!this.mJsBundleLastUpdateTimes.containsKey(str)) {
            return true;
        }
        long longValue = this.mJsBundleLastUpdateTimes.get(str).longValue();
        long serverTime = NetConnInfoCenter.getServerTime();
        return serverTime > longValue && serverTime - longValue > j3;
    }
}
