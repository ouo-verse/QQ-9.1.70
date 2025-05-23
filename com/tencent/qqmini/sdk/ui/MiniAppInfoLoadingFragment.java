package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import org.json.JSONObject;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniAppInfoLoadingFragment extends MiniBaseFragment {
    private static final String TAG = "MiniAppInfoLoadingFragment";
    private static final boolean mEnableDBCache = WnsConfig.getConfig("qqminiapp", "mini_app_enable_db_cache", true);
    private LinearLayout mLoadingView;
    private ResultReceiver mResultReceiver;
    private View mRootView;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void onGetMiniAppInfo(JSONObject jSONObject, byte[] bArr, MiniAppInfo miniAppInfo, String str, long j3, String str2);
    }

    private boolean checkEnvVersionForCache(String str) {
        if (!TextUtils.isEmpty(str) && !"release".equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHandlePreloadPkg(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniGame()) {
            AppLoaderFactory.g().getMiniServer().preDownloadPkg(miniAppInfo, null);
        }
    }

    private void doRequestByAppId(final String str, String str2, String str3, final LaunchParam launchParam, final String str4) {
        String str5;
        String str6;
        byte[] idInfo;
        showLoading();
        if (str2 == null) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if (str3 == null) {
            str6 = "";
        } else {
            str6 = str3;
        }
        final MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
        if (miniAppCacheProxy != null && miniAppCacheProxy.enableMiniAppCache() && checkEnvVersionForCache(str6) && (idInfo = miniAppCacheProxy.getIdInfo(str, str5)) != null) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            try {
                iNTERFACE$StApiAppInfo.mergeFrom(idInfo);
            } catch (InvalidProtocolBufferMicroException e16) {
                QMLog.e(TAG, "StApiAppInfo error,", e16);
            }
            MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
            QMLog.d(TAG, "start by Id cache.");
            startByIdMiniAppInfo(0L, "", from, launchParam, str4);
            MiniReportManager.reportEventType(from, 1028, "id_cache", MiniReportManager.getAppType(from));
            final String str7 = str6;
            final String str8 = str5;
            getAppInfoById(str, str5, str6, new a() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.1
                @Override // com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.a
                public void onGetMiniAppInfo(JSONObject jSONObject, byte[] bArr, MiniAppInfo miniAppInfo, String str9, long j3, String str10) {
                    MiniAppInfoLoadingFragment.this.saveIdInfo(jSONObject, bArr, str7, miniAppCacheProxy, str, str8);
                }
            });
            quit();
            return;
        }
        final String str9 = str6;
        final String str10 = str5;
        getAppInfoById(str, str5, str6, new a() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.2
            @Override // com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.a
            public void onGetMiniAppInfo(JSONObject jSONObject, byte[] bArr, MiniAppInfo miniAppInfo, String str11, long j3, String str12) {
                MiniAppInfoLoadingFragment.this.startByIdMiniAppInfo(j3, str12, miniAppInfo, launchParam, str4);
                MiniAppInfoLoadingFragment.this.saveIdInfo(jSONObject, bArr, str9, miniAppCacheProxy, str, str10);
                MiniReportManager.reportEventType(miniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(miniAppInfo));
                MiniAppInfoLoadingFragment.this.checkHandlePreloadPkg(miniAppInfo);
                MiniAppInfoLoadingFragment.this.quit();
            }
        });
    }

    private void doRequestByLink(final String str, final int i3, final LaunchParam launchParam, final String str2) {
        MiniAppCacheProxy.LinkData linkInfo;
        showLoading();
        final MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
        if (miniAppCacheProxy != null && miniAppCacheProxy.enableMiniAppCache() && (linkInfo = miniAppCacheProxy.getLinkInfo(str, i3)) != null) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            try {
                iNTERFACE$StApiAppInfo.mergeFrom(linkInfo.appInfo);
            } catch (InvalidProtocolBufferMicroException e16) {
                QMLog.e(TAG, "StApiAppInfo error,", e16);
            }
            MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
            String str3 = linkInfo.shareTicket;
            QMLog.d(TAG, "start by Link cache.");
            startByLinkMiniInfo(0L, "", from, str3, launchParam, str2);
            MiniReportManager.reportEventType(from, 1028, "link_cache", MiniReportManager.getAppType(from));
            getAppInfoByLink(str, i3, new a() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.6
                @Override // com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.a
                public void onGetMiniAppInfo(JSONObject jSONObject, byte[] bArr, MiniAppInfo miniAppInfo, String str4, long j3, String str5) {
                    MiniAppInfoLoadingFragment.this.saveLinkInfo(jSONObject, bArr, str4, miniAppCacheProxy, str, i3);
                }
            });
            quit();
            return;
        }
        getAppInfoByLink(str, i3, new a() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.7
            @Override // com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.a
            public void onGetMiniAppInfo(JSONObject jSONObject, byte[] bArr, MiniAppInfo miniAppInfo, String str4, long j3, String str5) {
                MiniAppInfoLoadingFragment.this.startByLinkMiniInfo(j3, str5, miniAppInfo, str4, launchParam, str2);
                MiniAppInfoLoadingFragment.this.saveLinkInfo(jSONObject, bArr, str4, miniAppCacheProxy, str, i3);
                MiniReportManager.reportEventType(miniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(miniAppInfo));
                MiniAppInfoLoadingFragment.this.quit();
            }
        });
    }

    private void doStartMiniApp(MiniAppInfo miniAppInfo) {
        try {
            if (!isMiniAppInfoValid(miniAppInfo)) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniToast.makeText(MiniAppInfoLoadingFragment.this.getActivity(), 1, "\u542f\u52a8\u5931\u8d25\uff0c\u5c0f\u7a0b\u5e8f\u5305\u914d\u7f6e\u9519\u8bef", 1).show();
                    }
                });
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isReported", true);
            MiniSDK.startMiniApp(getActivity(), miniAppInfo, bundle, this.mResultReceiver);
        } catch (Throwable th5) {
            QMLog.e(TAG, "startAppByAppid exception! ", th5);
        }
    }

    private void getAppInfoById(String str, String str2, String str3, final a aVar) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoById(str, str2, str3, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                QMLog.i(MiniAppInfoLoadingFragment.TAG, "getAppInfoById result: " + jSONObject);
                if (jSONObject == null) {
                    aVar.onGetMiniAppInfo(null, null, null, null, -1L, "result is null");
                    return;
                }
                final long optLong = jSONObject.optLong("retCode");
                final String optString = jSONObject.optString("errMsg");
                QMLog.i(MiniAppInfoLoadingFragment.TAG, "getAppInfoById, retCode = " + optLong + ",errMsg = " + optString);
                if (z16) {
                    aVar.onGetMiniAppInfo(jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON), (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB), (MiniAppInfo) jSONObject.opt("mini_app_info_data"), null, optLong, optString);
                    return;
                }
                aVar.onGetMiniAppInfo(null, null, null, null, optLong, optString);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str4;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getAppInfoById failed. retCode=");
                        sb5.append(optLong);
                        sb5.append(" errMsg=");
                        if (TextUtils.isEmpty(optString)) {
                            str4 = "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef\uff0c\u65e0\u6cd5\u52a0\u8f7d";
                        } else {
                            str4 = optString;
                        }
                        sb5.append(str4);
                        QMLog.e(MiniAppInfoLoadingFragment.TAG, sb5.toString());
                        MiniAppInfoLoadingFragment.this.showErrorToast(optString, optLong);
                    }
                });
            }
        });
    }

    private void getAppInfoByLink(String str, int i3, final a aVar) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(str, i3, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.5
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (jSONObject == null) {
                    aVar.onGetMiniAppInfo(null, null, null, null, -1L, "result is null");
                    return;
                }
                final long optLong = jSONObject.optLong("retCode");
                final String optString = jSONObject.optString("errMsg");
                QMLog.i(MiniAppInfoLoadingFragment.TAG, "getAppInfoByLink, retCode = " + optLong + ",errMsg = " + optString);
                if (z16) {
                    aVar.onGetMiniAppInfo(jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON), (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB), (MiniAppInfo) jSONObject.opt("mini_app_info_data"), jSONObject.optString("shareTicket", ""), optLong, optString);
                    return;
                }
                aVar.onGetMiniAppInfo(null, null, null, null, optLong, optString);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getAppInfoByLink failed. retCode=");
                        sb5.append(optLong);
                        sb5.append(" errMsg=");
                        if (TextUtils.isEmpty(optString)) {
                            str2 = "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef\uff0c\u65e0\u6cd5\u52a0\u8f7d";
                        } else {
                            str2 = optString;
                        }
                        sb5.append(str2);
                        QMLog.e(MiniAppInfoLoadingFragment.TAG, sb5.toString());
                        MiniAppInfoLoadingFragment.this.showErrorToast(optString, optLong);
                    }
                });
            }
        });
    }

    private static boolean isMiniAppInfoValid(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && !TextUtils.isEmpty(miniAppInfo.downloadUrl)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quit() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveIdInfo(JSONObject jSONObject, byte[] bArr, String str, MiniAppCacheProxy miniAppCacheProxy, String str2, String str3) {
        if (checkEnvVersionForCache(str)) {
            if (jSONObject != null) {
                INTERFACE$StApiAppInfo pbFromJSON = MiniAppInfo.pbFromJSON(jSONObject);
                if (pbFromJSON != null) {
                    QMLog.d(TAG, "saveIdInfo cache.");
                    if (miniAppCacheProxy.saveIdInfo(str2, str3, pbFromJSON.get().toByteArray(), System.currentTimeMillis())) {
                        QMLog.d(TAG, "saveIdInfo cache success.");
                        return;
                    }
                    return;
                }
                return;
            }
            if (bArr != null) {
                QMLog.d(TAG, "saveIdInfo cache.");
                if (miniAppCacheProxy.saveIdInfo(str2, str3, bArr, System.currentTimeMillis())) {
                    QMLog.d(TAG, "saveIdInfo cache success.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLinkInfo(JSONObject jSONObject, byte[] bArr, String str, MiniAppCacheProxy miniAppCacheProxy, String str2, int i3) {
        if (jSONObject != null) {
            INTERFACE$StApiAppInfo pbFromJSON = MiniAppInfo.pbFromJSON(jSONObject);
            if (pbFromJSON != null) {
                QMLog.d(TAG, "saveLinkInfo cache.");
                if (miniAppCacheProxy.saveLinkInfo(str2, i3, str, pbFromJSON.get().toByteArray(), System.currentTimeMillis())) {
                    QMLog.d(TAG, "saveLinkInfo cache success.");
                    return;
                }
                return;
            }
            return;
        }
        if (bArr != null) {
            QMLog.d(TAG, "saveLinkInfo cache.");
            if (miniAppCacheProxy.saveLinkInfo(str2, i3, str, bArr, System.currentTimeMillis())) {
                QMLog.d(TAG, "saveLinkInfo cache success.");
            }
        }
    }

    private void setEntryPath(MiniAppInfo miniAppInfo) {
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        if (firstPageInfo != null && miniAppInfo.launchParam != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
            if (miniAppInfo.firstPage.pagePath.startsWith("/")) {
                FirstPageInfo firstPageInfo2 = miniAppInfo.firstPage;
                firstPageInfo2.pagePath = firstPageInfo2.pagePath.substring(1);
            }
            if (miniAppInfo.firstPage.pagePath.contains(".html")) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath;
            } else {
                if (miniAppInfo.firstPage.pagePath.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
                    return;
                }
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath + ".html";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorToast(String str, long j3) {
        try {
            if (getActivity() != null) {
                if (DebugUtil.isDebugVersion()) {
                    MiniToast.makeText(getActivity(), 1, "" + str + j3, 1).show();
                } else if (j3 == -100070016) {
                    MiniToast.makeText(getActivity(), 0, "" + str, 1).show();
                } else {
                    MiniToast.makeText(getActivity(), 1, "" + str, 1).show();
                }
            }
        } catch (Exception e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
        }
    }

    private void showLoading() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniAppInfoLoadingFragment.this.mLoadingView != null) {
                        MiniAppInfoLoadingFragment.this.mLoadingView.setVisibility(0);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startByIdMiniAppInfo(final long j3, final String str, MiniAppInfo miniAppInfo, LaunchParam launchParam, String str2) {
        if (miniAppInfo != null) {
            if (launchParam != null) {
                miniAppInfo.launchParam.miniAppId = miniAppInfo.appId;
                if (!TextUtils.isEmpty(launchParam.extendData)) {
                    miniAppInfo.extendData = launchParam.extendData;
                }
                LaunchParam launchParam2 = miniAppInfo.launchParam;
                launchParam2.scene = launchParam.scene;
                launchParam2.isCloseGameBox = launchParam.isCloseGameBox;
            }
            if (miniAppInfo.verType != 3) {
                miniAppInfo.launchParam.forceReload = 3;
            }
            setEntryPath(miniAppInfo);
            if (str2 != null) {
                miniAppInfo.customInfo = str2;
            }
            doStartMiniApp(miniAppInfo);
            if (this.mResultReceiver != null) {
                Bundle bundle = new Bundle();
                bundle.putLong("retCode", j3);
                bundle.putString("errMsg", str);
                this.mResultReceiver.send(0, bundle);
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.3
            @Override // java.lang.Runnable
            public void run() {
                String str3;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getAppInfoById failed. retCode=");
                sb5.append(j3);
                sb5.append(" errMsg=");
                String str4 = "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef\uff0c\u65e0\u6cd5\u52a0\u8f7d";
                if (TextUtils.isEmpty(str)) {
                    str3 = "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef\uff0c\u65e0\u6cd5\u52a0\u8f7d";
                } else {
                    str3 = str;
                }
                sb5.append(str3);
                QMLog.e(MiniAppInfoLoadingFragment.TAG, sb5.toString());
                MiniAppInfoLoadingFragment miniAppInfoLoadingFragment = MiniAppInfoLoadingFragment.this;
                if (!TextUtils.isEmpty(str)) {
                    str4 = str;
                }
                miniAppInfoLoadingFragment.showErrorToast(str4, j3);
            }
        });
        if (this.mResultReceiver != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("retCode", j3);
            bundle2.putString("errMsg", str);
            this.mResultReceiver.send(1, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startByLinkMiniInfo(final long j3, final String str, MiniAppInfo miniAppInfo, String str2, LaunchParam launchParam, String str3) {
        if (miniAppInfo != null) {
            LaunchParam launchParam2 = miniAppInfo.launchParam;
            launchParam2.miniAppId = miniAppInfo.appId;
            launchParam2.shareTicket = str2;
            launchParam2.navigateExtData = miniAppInfo.extraData;
            updateLaunchParam(miniAppInfo, launchParam);
            if (miniAppInfo.verType != 3) {
                miniAppInfo.launchParam.forceReload = 3;
            }
            setEntryPath(miniAppInfo);
            if (miniAppInfo.clearAuths == 1) {
                try {
                    if (Long.valueOf(Long.parseLong(LoginManager.getInstance().getAccount())).longValue() > 0) {
                        MiniAppEnv.g().getAuthSate(miniAppInfo.appId).clearAll();
                        miniAppInfo.clearAuths = 0;
                    }
                } catch (Exception unused) {
                }
            }
            if (str3 != null) {
                miniAppInfo.customInfo = str3;
            }
            doStartMiniApp(miniAppInfo);
            if (this.mResultReceiver != null) {
                Bundle bundle = new Bundle();
                bundle.putLong("retCode", j3);
                bundle.putString("errMsg", str);
                this.mResultReceiver.send(0, bundle);
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.8
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getAppInfoByLink failed. retCode=");
                sb5.append(j3);
                sb5.append(" errMsg=");
                String str5 = "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef\uff0c\u65e0\u6cd5\u52a0\u8f7d";
                if (TextUtils.isEmpty(str)) {
                    str4 = "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef\uff0c\u65e0\u6cd5\u52a0\u8f7d";
                } else {
                    str4 = str;
                }
                sb5.append(str4);
                QMLog.e(MiniAppInfoLoadingFragment.TAG, sb5.toString());
                MiniAppInfoLoadingFragment miniAppInfoLoadingFragment = MiniAppInfoLoadingFragment.this;
                if (!TextUtils.isEmpty(str)) {
                    str5 = str;
                }
                miniAppInfoLoadingFragment.showErrorToast(str5, j3);
            }
        });
        if (this.mResultReceiver != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("retCode", j3);
            bundle2.putString("errMsg", str);
            this.mResultReceiver.send(1, bundle2);
        }
    }

    private void updateLaunchParam(MiniAppInfo miniAppInfo, LaunchParam launchParam) {
        if (launchParam != null) {
            miniAppInfo.launchParam.scene = launchParam.scene;
        }
        if (!TextUtils.isEmpty(miniAppInfo.launchParam.shareTicket)) {
            miniAppInfo.launchParam.scene = 1044;
        }
        if (TextUtils.isEmpty(miniAppInfo.launchParam.reportData)) {
            miniAppInfo.launchParam.reportData = miniAppInfo.reportData;
        } else if (!TextUtils.isEmpty(miniAppInfo.reportData)) {
            miniAppInfo.launchParam.reportData = miniAppInfo.launchParam.reportData + ContainerUtils.FIELD_DELIMITER + miniAppInfo.reportData;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        QMLog.i(TAG, "LoadingFragment onCreateView");
        if (this.mRootView == null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_appinfo_loading_layout, (ViewGroup) null);
            this.mRootView = inflate;
            this.mLoadingView = (LinearLayout) inflate.findViewById(R.id.loading_layout);
        }
        View view = this.mRootView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QMLog.i(TAG, "LoadingFragment doTask");
        Bundle arguments = getArguments();
        if (arguments == null) {
            quit();
            return;
        }
        arguments.setClassLoader(getClass().getClassLoader());
        this.mResultReceiver = (ResultReceiver) arguments.getParcelable("mini_receiver");
        String string = arguments.getString("key_appid");
        LaunchParam launchParam = (LaunchParam) arguments.getParcelable("mini_launch_param");
        String string2 = arguments.getString("mini_envVersion");
        String string3 = arguments.getString("mini_link");
        int i3 = arguments.getInt("mini_link_type");
        String string4 = arguments.getString("mini_entryPath");
        String string5 = arguments.getString(IPCConst.KEY_CUSTOM_INFO);
        if (!TextUtils.isEmpty(string)) {
            doRequestByAppId(string, string4, string2, launchParam, string5);
        } else if (!TextUtils.isEmpty(string3)) {
            doRequestByLink(string3, i3, launchParam, string5);
        } else {
            quit();
        }
    }
}
