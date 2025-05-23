package com.tencent.qqmini.sdk.plugins;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.ui.a;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.tav.core.ExportErrorStatus;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class AppJsPlugin extends BaseJsPlugin {
    private static final String EVENT_APPLY_ADD_TO_MY_APPS = "applyAddToMyApps";
    private static final String EVENT_DOWNLOAD_APP = "startDownloadAppTask";
    private static final String EVENT_DOWNLOAD_APP_CANCEL = "cancelDownloadAppTask";
    private static final String EVENT_DOWNLOAD_APP_DELETE = "deleteDownloadAppTask";
    private static final String EVENT_DOWNLOAD_APP_RESUME = "resumeDownloadAppTask";
    private static final String EVENT_INSTALL_APP = "installApp";
    private static final String EVENT_IS_ADD_TO_MY_APPS = "isAddedToMyApps";
    private static final String EVENT_IS_MICROAPP_INSTALLED = "isMicroAppInstalled";
    private static final String EVENT_QUERY_APP_INFO = "queryAppInfo";
    private static final String EVENT_QUERY_DOWNLOAD_INFO = "queryDownloadAppTask";
    private static final String EVENT_SET_SPEED_BUFFER = "setSpeedBuffer";
    private static final String EVENT_START_APP = "startApp";
    private static final String TAG = "AppJsPlugin";
    private ThirdAppProxy mThirdAppProxy = (ThirdAppProxy) ProxyManager.get(ThirdAppProxy.class);

    /* loaded from: classes23.dex */
    class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348175a;

        a(RequestEvent requestEvent) {
            this.f348175a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            boolean z17;
            if (z16 && jSONObject != null) {
                try {
                    z17 = jSONObject.optBoolean("isAdded");
                } catch (Exception e16) {
                    QMLog.e(AppJsPlugin.TAG, "[isAddedToMyApps],ex:" + e16);
                    return;
                }
            } else {
                z17 = false;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("isAdded", z17);
            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(this.f348175a.event, jSONObject2);
            RequestEvent requestEvent = this.f348175a;
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, wrapCallbackOk.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo getInstalledPackage(String str) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getContext() != null) {
            try {
                return InstalledAppListMonitor.getPackageInfo(this.mMiniAppContext.getContext().getPackageManager(), str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                QMLog.e(TAG, "getInstalledPackage failed ");
                return null;
            }
        }
        QMLog.e(TAG, "getInstalledPackage error,context is NULL");
        return null;
    }

    @JsEvent({EVENT_APPLY_ADD_TO_MY_APPS})
    public void applyAddToMyApps(final RequestEvent requestEvent) {
        QMLog.i(TAG, "[applyAddToMyApps]");
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.AppJsPlugin.7

            /* renamed from: com.tencent.qqmini.sdk.plugins.AppJsPlugin$7$a */
            /* loaded from: classes23.dex */
            class a implements a.InterfaceC9438a {
                a() {
                }

                @Override // com.tencent.qqmini.sdk.ui.a.InterfaceC9438a
                public void onResult(boolean z16) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (z16) {
                            jSONObject.put(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, true);
                            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
                            if (qQCustomizedProxy != null) {
                                qQCustomizedProxy.add2MyApps(((BaseJsPlugin) AppJsPlugin.this).mMiniAppInfo);
                            }
                        } else {
                            jSONObject.put("cancel", true);
                        }
                        JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject);
                        RequestEvent requestEvent = requestEvent;
                        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, wrapCallbackOk.toString());
                    } catch (Exception e16) {
                        QMLog.e(AppJsPlugin.TAG, "[isAddedToMyApps],ex:" + e16);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((BaseJsPlugin) AppJsPlugin.this).mMiniAppContext.getAttachActivity() != null && !((BaseJsPlugin) AppJsPlugin.this).mMiniAppContext.getAttachActivity().isFinishing()) {
                    com.tencent.qqmini.sdk.ui.a aVar = new com.tencent.qqmini.sdk.ui.a(((BaseJsPlugin) AppJsPlugin.this).mMiniAppContext.getAttachActivity());
                    aVar.N(((BaseJsPlugin) AppJsPlugin.this).mMiniAppInfo);
                    aVar.O(new a());
                    aVar.show();
                    return;
                }
                QMLog.e(AppJsPlugin.TAG, "applyAddToMyApps getAttachedActivity is null or finish");
            }
        });
    }

    @JsEvent({EVENT_DOWNLOAD_APP_CANCEL})
    public String cancelDownloadAppTask(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("appid");
            jSONObject.put("appid", optString);
            if (this.mThirdAppProxy.stopDownloadTask(optString)) {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString());
            } else {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString());
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "cancelDownloadAppTask Throwable:", th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString());
            return "";
        }
    }

    @JsEvent({EVENT_DOWNLOAD_APP_DELETE})
    public String deleteDownloadAppTask(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("appid");
            jSONObject.put("appid", optString);
            if (this.mThirdAppProxy.deleteDownloadTask(optString)) {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString());
            } else {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString());
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "deleteDownloadAppTask Throwable:", th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString());
            return "";
        }
    }

    @JsEvent({EVENT_INSTALL_APP})
    public String installApp(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            jSONObject.optString("packagename");
            this.mThirdAppProxy.installApp(jSONObject.optString("appid"), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.AppJsPlugin.4
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    if (z16) {
                        JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(requestEvent.event, null);
                        RequestEvent requestEvent2 = requestEvent;
                        requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackOk.toString());
                    } else {
                        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, null);
                        RequestEvent requestEvent3 = requestEvent;
                        requestEvent3.jsService.evaluateCallbackJs(requestEvent3.callbackId, wrapCallbackFail.toString());
                    }
                }
            });
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, EVENT_INSTALL_APP, th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
            return "";
        }
    }

    @JsEvent({EVENT_IS_ADD_TO_MY_APPS})
    public boolean isAddedToMyApps(RequestEvent requestEvent) {
        try {
            QMLog.i(TAG, "[isAddedToMyApps]");
            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
            if (qQCustomizedProxy != null) {
                qQCustomizedProxy.isAdded2MyApps(this.mMiniAppInfo.appId, new a(requestEvent));
                return false;
            }
            return false;
        } catch (Exception e16) {
            QMLog.e(TAG, "[isAddedToMyApps],ex:" + e16);
            return false;
        }
    }

    @JsEvent({EVENT_IS_MICROAPP_INSTALLED})
    public void isMicroAppInstalled(final RequestEvent requestEvent) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.getMiniAppInfo().appId, "", "", 100, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.AppJsPlugin.5
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    String optString = jSONObject.optString("packageName");
                    if (TextUtils.isEmpty(optString)) {
                        requestEvent.fail("server error,packageName = null");
                        QMLog.w(AppJsPlugin.TAG, "check failed, server error");
                        return;
                    }
                    if (AppJsPlugin.this.getInstalledPackage(optString) == null) {
                        requestEvent.fail("getInstalledPackage error,packages is null");
                        QMLog.w(AppJsPlugin.TAG, "getInstalledPackage error, packages is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("installed", 1);
                        requestEvent.ok(jSONObject2);
                        return;
                    } catch (Exception e16) {
                        requestEvent.fail("isMicroAppInstalled exception");
                        QMLog.w(AppJsPlugin.TAG, "isMicroAppInstalled exception:", e16);
                        return;
                    }
                }
                requestEvent.fail("check failed, server error");
                QMLog.w(AppJsPlugin.TAG, "check failed, server error");
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        ThirdAppProxy thirdAppProxy = this.mThirdAppProxy;
        if (thirdAppProxy != null) {
            thirdAppProxy.init();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        ThirdAppProxy thirdAppProxy = this.mThirdAppProxy;
        if (thirdAppProxy != null) {
            thirdAppProxy.unInit();
        }
        super.onDestroy();
    }

    @JsEvent({"queryAppInfo"})
    public String queryAppInfo(RequestEvent requestEvent) {
        String optString;
        PackageManager packageManager;
        PackageInfo installedPackage;
        try {
            optString = new JSONObject(requestEvent.jsonParams).optString("packagename");
            packageManager = this.mMiniAppContext.getContext().getPackageManager();
            installedPackage = getInstalledPackage(optString);
        } catch (Throwable th5) {
            QMLog.e(TAG, "queryAppInfo throwable:", th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
        }
        if (installedPackage == null) {
            QMLog.e(TAG, "getInstalledPackage error, packages is null");
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packagename", optString);
        jSONObject.put("appName", installedPackage.applicationInfo.loadLabel(packageManager).toString());
        jSONObject.put("versionCode", installedPackage.versionCode);
        jSONObject.put("versionName", installedPackage.versionName);
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString());
        return "";
    }

    @JsEvent({EVENT_QUERY_DOWNLOAD_INFO})
    public String queryDownloadAppTask(final RequestEvent requestEvent) {
        try {
            this.mThirdAppProxy.queryDownloadTask(new JSONObject(requestEvent.jsonParams).optString("appid"), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.AppJsPlugin.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject);
                        RequestEvent requestEvent2 = requestEvent;
                        requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackOk.toString());
                    } else {
                        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
                        RequestEvent requestEvent3 = requestEvent;
                        requestEvent3.jsService.evaluateCallbackJs(requestEvent3.callbackId, wrapCallbackFail.toString());
                    }
                }
            });
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "queryDownloadAppTask Throwable:", th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
            return "";
        }
    }

    @JsEvent({EVENT_DOWNLOAD_APP_RESUME})
    public String resumeDownloadAppTask(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("appid");
            jSONObject.put("appid", optString);
            if (this.mThirdAppProxy.resumeDownloadTask(optString)) {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString());
            } else {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString());
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "resumeDownloadAppTask Throwable:", th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString());
            return "";
        }
    }

    @JsEvent({"setSpeedBuffer"})
    public void setSpeedBuffer(RequestEvent requestEvent) {
        String optString;
        int optInt;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            optString = jSONObject.optString("businessType");
            optInt = jSONObject.optInt(WadlProxyConsts.PARAM_SPEED_BUFFER);
            QMLog.i(TAG, "setSpeedBuffer businessType:" + optString + ", speedBuffer:" + optInt);
        } catch (JSONException e16) {
            QMLog.e(TAG, "setSetSpeedBuffer" + e16);
        }
        if (!optString.equals("app") && !optString.equals("va")) {
            requestEvent.fail("businessType error");
            return;
        }
        ThirdAppProxy thirdAppProxy = this.mThirdAppProxy;
        if (thirdAppProxy != null) {
            thirdAppProxy.setSpeedBuffer(optString, optInt);
        }
        requestEvent.ok();
    }

    @JsEvent({EVENT_START_APP})
    public String startApp(RequestEvent requestEvent) {
        String optString;
        String optString2;
        PackageManager packageManager;
        PackageInfo installedPackage;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            optString = jSONObject.optString("packagename");
            optString2 = jSONObject.optString("path");
            packageManager = this.mMiniAppContext.getContext().getPackageManager();
            installedPackage = getInstalledPackage(optString);
        } catch (Throwable th5) {
            QMLog.e(TAG, "startApp throwable:", th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
        }
        if (installedPackage == null) {
            QMLog.e(TAG, "getInstalledPackage error, packages is null");
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
            return "";
        }
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(optString2)) {
            Intent intent = new Intent();
            intent.putExtra("big_brother_source_key", "biz_src_miniapp");
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName(optString, optString2));
            if (intent.resolveActivityInfo(packageManager, 65536) != null) {
                this.mMiniAppContext.getAttachActivity().startActivity(intent);
            } else {
                QMLog.e(TAG, "\u627e\u4e0d\u5230\u6307\u5b9a\u7684 Activity");
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null, "can not find activity.").toString());
                return "";
            }
        } else {
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, installedPackage.packageName);
            launchIntentForPackage.putExtra("big_brother_source_key", "biz_src_miniapp");
            this.mMiniAppContext.getAttachActivity().startActivity(launchIntentForPackage);
        }
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject2).toString());
        return "";
    }

    @JsEvent({EVENT_DOWNLOAD_APP})
    public String startDownloadAppTask(final RequestEvent requestEvent) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && channelProxy.isGooglePlayVersion()) {
            boolean z16 = false;
            if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_GOOGLE_PLAY_DOWNLOAD_SWITCH, 0) == 1) {
                z16 = true;
            }
            if (!z16) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.AppJsPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniToast.makeText(((BaseJsPlugin) AppJsPlugin.this).mContext, "\u5f53\u524d\u7248\u672c\u4e0b\u8f7d\u80fd\u529b\u6682\u4e0d\u53ef\u7528", 0).show();
                    }
                });
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("retCode", ExportErrorStatus.END_WRITE_VIDEO_SAMPLE);
                    jSONObject.put("errMsg", "googlePlay download no supported!");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString());
                return "";
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject2.optString("packagename");
            final String optString2 = jSONObject2.optString("appid");
            final String optString3 = jSONObject2.optString("version");
            final String optString4 = jSONObject2.optString("md5");
            final boolean optBoolean = jSONObject2.optBoolean("autoInstall");
            if (!TextUtils.isEmpty(optString2)) {
                this.mThirdAppProxy.queryApkDownloadInfo(optString2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.AppJsPlugin.2
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z17, JSONObject jSONObject3) {
                        QMLog.i(AppJsPlugin.TAG, "queryApkDownloadInfo succ=" + z17 + " result=" + jSONObject3);
                        if (z17 && jSONObject3 != null) {
                            AppJsPlugin.this.mThirdAppProxy.startDownload(optString2, jSONObject3, optBoolean, new ThirdAppProxy.AppDownloadListener() { // from class: com.tencent.qqmini.sdk.plugins.AppJsPlugin.2.1
                                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener
                                public void onDownloadComplete() {
                                    JSONObject jSONObject4 = new JSONObject();
                                    try {
                                        jSONObject4.put("appid", optString2);
                                        jSONObject4.put("packagename", optString);
                                        jSONObject4.put("version", optString3);
                                        jSONObject4.put("md5", optString4);
                                        jSONObject4.put("state", "onDownloadAppSucceed");
                                        requestEvent.jsService.evaluateSubscribeJS("onAppDownloadStateChange", jSONObject4.toString(), 0);
                                    } catch (Exception e17) {
                                        QMLog.e(AppJsPlugin.TAG, "onDownloadComplete exception, appid: " + optString2, e17);
                                        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, null);
                                        RequestEvent requestEvent2 = requestEvent;
                                        requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackFail.toString());
                                    }
                                }

                                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener
                                public void onDownloadFailed(int i3, int i16, String str) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    try {
                                        jSONObject4.put("appid", optString2);
                                        jSONObject4.put("packagename", optString);
                                        jSONObject4.put("version", optString3);
                                        jSONObject4.put("md5", optString4);
                                        jSONObject4.put("retCode", i3);
                                        jSONObject4.put("errMsg", str);
                                        jSONObject4.put("state", "onDownloadAppFailed");
                                        requestEvent.jsService.evaluateSubscribeJS("onAppDownloadStateChange", jSONObject4.toString(), 0);
                                    } catch (Exception e17) {
                                        QMLog.e(AppJsPlugin.TAG, "onDownloadFailed exception, appid: " + optString2, e17);
                                        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, null);
                                        RequestEvent requestEvent2 = requestEvent;
                                        requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackFail.toString());
                                    }
                                }

                                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener
                                public void onDownloadProgress(long j3, long j16, int i3) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    try {
                                        jSONObject4.put("appid", optString2);
                                        jSONObject4.put("packagename", optString);
                                        jSONObject4.put("version", optString3);
                                        jSONObject4.put("md5", optString4);
                                        jSONObject4.put("downloadSize", j3);
                                        jSONObject4.put("totalSize", j16);
                                        jSONObject4.put("progress", i3);
                                        jSONObject4.put("state", "onDownloadAppProgress");
                                        requestEvent.jsService.evaluateSubscribeJS("onAppDownloadStateChange", jSONObject4.toString(), 0);
                                    } catch (Exception e17) {
                                        QMLog.e(AppJsPlugin.TAG, "onDownloadProgress exception, appid: " + optString2, e17);
                                        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, null);
                                        RequestEvent requestEvent2 = requestEvent;
                                        requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackFail.toString());
                                    }
                                }
                            });
                            return;
                        }
                        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, null);
                        RequestEvent requestEvent2 = requestEvent;
                        requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackFail.toString());
                    }
                });
            } else {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "startDownloadAppTask throwable:", th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
        }
        return "";
    }
}
