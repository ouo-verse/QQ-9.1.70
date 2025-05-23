package com.tencent.qqmini.sdk.task;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.utils.DebugHelper;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import org.json.JSONObject;

/* compiled from: P */
@ClassTag(tag = MiniAppInfoLoadTask.TAG)
/* loaded from: classes23.dex */
public class MiniAppInfoLoadTask extends AsyncTask {
    private static final String TAG = "MiniAppInfoLoadTask";
    private volatile MiniAppInfo mMiniAppInfo;

    public MiniAppInfoLoadTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    private boolean checkEnvVersionForCache(String str) {
        if (!TextUtils.isEmpty(str) && !"release".equals(str)) {
            return false;
        }
        return true;
    }

    private void doRequestByAppId() {
        final String str;
        byte[] idInfo;
        final String str2 = "";
        if (this.mMiniAppInfo.firstPath != null) {
            str = this.mMiniAppInfo.firstPath;
        } else if (this.mMiniAppInfo.launchParam.entryPath == null) {
            str = "";
        } else {
            str = this.mMiniAppInfo.launchParam.entryPath;
        }
        if (this.mMiniAppInfo.launchParam.envVersion != null) {
            str2 = this.mMiniAppInfo.launchParam.envVersion;
        }
        final MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
        if (miniAppCacheProxy != null && miniAppCacheProxy.enableMiniAppCache() && checkEnvVersionForCache(str2) && (idInfo = miniAppCacheProxy.getIdInfo(this.mMiniAppInfo.appId, str)) != null) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            try {
                iNTERFACE$StApiAppInfo.mergeFrom(idInfo);
                MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
                QMLog.d(TAG, "start by Id cache.");
                replaceByIdInfo(from);
                onTaskSucceed();
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.mMiniAppInfo.appId, str, str2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        if (z16 && jSONObject != null) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON);
                            byte[] bArr = (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB);
                            MiniAppInfoLoadTask miniAppInfoLoadTask = MiniAppInfoLoadTask.this;
                            miniAppInfoLoadTask.saveIdInfo(optJSONObject, bArr, str2, miniAppCacheProxy, miniAppInfoLoadTask.mMiniAppInfo.appId, str);
                        }
                    }
                });
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "StApiAppInfo error,", th5);
            }
        }
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.mMiniAppInfo.appId, str, str2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    QMLog.i(MiniAppInfoLoadTask.TAG, "getAppInfoById, retCode = " + jSONObject.optLong("retCode") + ",errMsg = " + jSONObject.optString("errMsg"));
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                    if (miniAppInfo != null) {
                        MiniAppInfoLoadTask.this.replaceByIdInfo(miniAppInfo);
                        MiniReportManager.reportEventType(miniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(miniAppInfo));
                        MiniAppInfoLoadTask.this.onTaskSucceed();
                    } else {
                        SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.this.mMiniAppInfo, MiniReportManager.getAppType(MiniAppInfoLoadTask.this.mMiniAppInfo), null, "load_fail", "shortcut_request_fail");
                        MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.this.mMiniAppInfo);
                        MiniAppInfoLoadTask.this.onTaskFailed();
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON);
                    byte[] bArr = (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB);
                    MiniAppInfoLoadTask miniAppInfoLoadTask = MiniAppInfoLoadTask.this;
                    miniAppInfoLoadTask.saveIdInfo(optJSONObject, bArr, str2, miniAppCacheProxy, miniAppInfoLoadTask.mMiniAppInfo.appId, str);
                    return;
                }
                SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.this.mMiniAppInfo, MiniReportManager.getAppType(MiniAppInfoLoadTask.this.mMiniAppInfo), null, "load_fail", "shortcut_request_fail");
                MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.this.mMiniAppInfo);
                MiniAppInfoLoadTask.this.onTaskFailed();
            }
        });
    }

    private void doRequestByLink() {
        MiniAppCacheProxy.LinkData linkInfo;
        final MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
        if (miniAppCacheProxy != null && miniAppCacheProxy.enableMiniAppCache() && (linkInfo = miniAppCacheProxy.getLinkInfo(this.mMiniAppInfo.link, this.mMiniAppInfo.linkType)) != null) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            try {
                iNTERFACE$StApiAppInfo.mergeFrom(linkInfo.appInfo);
                MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
                String str = linkInfo.shareTicket;
                QMLog.d(TAG, "start by Link cache.");
                replaceByLinkInfo(from, str);
                onTaskSucceed();
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.mMiniAppInfo.link, this.mMiniAppInfo.linkType, new AsyncResult() { // from class: com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.3
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        if (z16 && jSONObject != null) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON);
                            byte[] bArr = (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB);
                            String optString = jSONObject.optString("shareTicket", "");
                            MiniAppInfoLoadTask miniAppInfoLoadTask = MiniAppInfoLoadTask.this;
                            miniAppInfoLoadTask.saveLinkInfo(optJSONObject, bArr, optString, miniAppCacheProxy, miniAppInfoLoadTask.mMiniAppInfo.link, MiniAppInfoLoadTask.this.mMiniAppInfo.linkType);
                        }
                    }
                });
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "StApiAppInfo error,", th5);
            }
        }
        getAppInfoByLink(miniAppCacheProxy);
    }

    private void getAppInfoByLink(final MiniAppCacheProxy miniAppCacheProxy) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.mMiniAppInfo.link, this.mMiniAppInfo.linkType, new AsyncResult() { // from class: com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                try {
                    if (z16 && jSONObject != null) {
                        long optLong = jSONObject.optLong("retCode");
                        String optString = jSONObject.optString("errMsg");
                        QMLog.d(MiniAppInfoLoadTask.TAG, "getAppInfoByLink, retCode = " + optLong + ",errMsg = " + optString);
                        if (optLong != 0) {
                            if (TextUtils.isEmpty(optString)) {
                                DebugUtil.isDebugVersion();
                            }
                            MiniAppInfoLoadTask.this.onTaskFailed();
                        }
                        MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                        String optString2 = jSONObject.optString("shareTicket", "");
                        if (optLong == 0 && miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
                            MiniAppInfoLoadTask.this.replaceByLinkInfo(miniAppInfo, optString2);
                            MiniReportManager.reportEventType(miniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(miniAppInfo));
                            MiniAppInfoLoadTask.this.onTaskSucceed();
                        } else {
                            SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.this.mMiniAppInfo, MiniReportManager.getAppType(MiniAppInfoLoadTask.this.mMiniAppInfo), null, "load_fail", "shortcut_request_fail");
                            MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.this.mMiniAppInfo);
                            if (miniAppInfo == null) {
                                QMLog.e(MiniAppInfoLoadTask.TAG, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + optLong);
                            } else {
                                QMLog.e(MiniAppInfoLoadTask.TAG, "getAppInfoByLink  onCmdListener retCode= " + optLong + " appid=" + miniAppInfo.appId);
                            }
                            MiniAppInfoLoadTask.this.onTaskFailed();
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON);
                        byte[] bArr = (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB);
                        MiniAppInfoLoadTask miniAppInfoLoadTask = MiniAppInfoLoadTask.this;
                        miniAppInfoLoadTask.saveLinkInfo(optJSONObject, bArr, optString2, miniAppCacheProxy, miniAppInfoLoadTask.mMiniAppInfo.link, MiniAppInfoLoadTask.this.mMiniAppInfo.linkType);
                        return;
                    }
                    SDKMiniProgramLpReportDC04239.reportPageView(MiniAppInfoLoadTask.this.mMiniAppInfo, MiniReportManager.getAppType(MiniAppInfoLoadTask.this.mMiniAppInfo), null, "load_fail", "shortcut_request_fail");
                    MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, MiniAppInfoLoadTask.this.mMiniAppInfo);
                    MiniAppInfoLoadTask.this.onTaskFailed();
                } catch (Throwable th5) {
                    QMLog.e(MiniAppInfoLoadTask.TAG, "", th5);
                    MiniAppInfoLoadTask.this.onTaskFailed();
                }
            }
        });
    }

    private void preloadDebugEnableInfo(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null) {
            DebugHelper.d().e(miniAppInfo.appId);
        }
    }

    private void reloadMiniAppInfoIfNeeded(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "error: miniAppInfo == null");
            onTaskFailed();
            return;
        }
        boolean z16 = false;
        if (miniAppInfo.isFakeAppInfo()) {
            if (miniAppInfo.link != null) {
                z16 = true;
            }
            requestMiniAppInfo(z16);
        } else {
            if (miniAppInfo.isShortcutFakeApp()) {
                requestMiniAppInfo(false);
                return;
            }
            preloadDebugEnableInfo(miniAppInfo);
            onTaskSucceed();
            QMLog.i(TAG, "[reloadMiniAppInfoIfNeeded] succeed:" + miniAppInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceByIdInfo(final MiniAppInfo miniAppInfo) {
        miniAppInfo.launchParam.clone(this.mMiniAppInfo.launchParam);
        miniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
        miniAppInfo.launchParam.miniAppId = miniAppInfo.appId;
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.5
            @Override // java.lang.Runnable
            public void run() {
                SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
                if (specialProxy != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MiniAppConst.MINI_KEY_APPINFO, miniAppInfo);
                    specialProxy.sendEventToHost(1, bundle, null);
                }
            }
        });
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        if (firstPageInfo != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
            if (miniAppInfo.firstPage.pagePath.startsWith("/")) {
                FirstPageInfo firstPageInfo2 = miniAppInfo.firstPage;
                firstPageInfo2.pagePath = firstPageInfo2.pagePath.substring(1);
            }
            if (miniAppInfo.firstPage.pagePath.contains(".html")) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath;
            } else if (miniAppInfo.firstPage.pagePath.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
            } else {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath + ".html";
            }
        }
        if (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.extendData)) {
            miniAppInfo.extendData = this.mMiniAppInfo.launchParam.extendData;
        }
        if (miniAppInfo.verType != 3) {
            miniAppInfo.launchParam.forceReload = 3;
        }
        this.mMiniAppInfo = miniAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceByLinkInfo(final MiniAppInfo miniAppInfo, String str) {
        miniAppInfo.launchParam.clone(this.mMiniAppInfo.launchParam);
        miniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
                if (specialProxy != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MiniAppConst.MINI_KEY_APPINFO, miniAppInfo);
                    specialProxy.sendEventToHost(1, bundle, null);
                }
            }
        });
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        if (firstPageInfo != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
            if (miniAppInfo.firstPage.pagePath.startsWith("/")) {
                FirstPageInfo firstPageInfo2 = miniAppInfo.firstPage;
                firstPageInfo2.pagePath = firstPageInfo2.pagePath.substring(1);
            }
            if (miniAppInfo.firstPage.pagePath.contains(".html")) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath;
            } else if (miniAppInfo.firstPage.pagePath.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
            } else {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath + ".html";
            }
        }
        LaunchParam launchParam = miniAppInfo.launchParam;
        launchParam.miniAppId = miniAppInfo.appId;
        launchParam.shareTicket = str;
        launchParam.navigateExtData = miniAppInfo.extraData;
        if (!TextUtils.isEmpty(str)) {
            miniAppInfo.launchParam.scene = 1044;
        }
        if (TextUtils.isEmpty(miniAppInfo.launchParam.reportData)) {
            miniAppInfo.launchParam.reportData = miniAppInfo.reportData;
        } else if (!TextUtils.isEmpty(miniAppInfo.reportData)) {
            miniAppInfo.launchParam.reportData = miniAppInfo.launchParam.reportData + ContainerUtils.FIELD_DELIMITER + miniAppInfo.reportData;
        }
        if (miniAppInfo.verType != 3) {
            miniAppInfo.launchParam.forceReload = 3;
        }
        this.mMiniAppInfo = miniAppInfo;
    }

    private void requestMiniAppInfo(boolean z16) {
        QMLog.i(TAG, "[requestMiniAppInfo] isRequestByLink=" + z16);
        if (z16) {
            doRequestByLink();
        } else {
            doRequestByAppId();
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

    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        this.mMiniAppInfo = miniAppInfo;
        reloadMiniAppInfoIfNeeded(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
    }
}
