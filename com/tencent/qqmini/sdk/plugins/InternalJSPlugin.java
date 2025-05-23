package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.luggage.wxa.v6.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.InnerAppReportDc4239;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class InternalJSPlugin extends BaseJsPlugin {
    private static final String CONFIG_SPLIT = ",";
    private static final String TAG = "InternalJSPlugin";
    private ArrayList<String> openUrlDomainWhiteList;
    private String privateOpenUrlDomainWhiteList;

    /* loaded from: classes23.dex */
    public interface OpenUrlCallback {
        void openResult(boolean z16, String str);
    }

    private void callbackOpenResult(OpenUrlCallback openUrlCallback, boolean z16, String str) {
        if (openUrlCallback != null) {
            openUrlCallback.openResult(z16, str);
        }
    }

    private void confirmOpenAppDetailPage(final Activity activity, final String str, final String str2, final String str3, final String str4, final RequestEvent requestEvent) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.8
            @Override // java.lang.Runnable
            public void run() {
                DialogUtil.createCustomDialog(activity, 230, "\u63d0\u793a", String.format("\u5373\u5c06\u4e0b\u8f7d\u300c%s\u300d\u5230\u624b\u673a", str3), "\u53d6\u6d88", "\u5141\u8bb8", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.8.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        QMLog.d(InternalJSPlugin.TAG, "confirmOpenAppDetailPage downloadUrl : " + str4);
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        InternalJSPlugin.this.openAppDetailPage(activity, str, str2, str3, str4);
                        requestEvent.fail(InternalJSPlugin.this.getLaunchAppRetJsonObject(4), "");
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.8.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        QMLog.e(InternalJSPlugin.TAG, "cancel");
                        requestEvent.fail(InternalJSPlugin.this.getLaunchAppRetJsonObject(5), "click download cancel");
                    }
                }).show();
            }
        });
    }

    private void downloadApp(Activity activity, String str, String str2, String str3, String str4, int i3, RequestEvent requestEvent) {
        boolean z16;
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && channelProxy.isGooglePlayVersion()) {
            z16 = false;
            if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_GOOGLE_PLAY_DOWNLOAD_SWITCH, 0) == 1) {
                z16 = true;
            }
            if (!z16) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.6
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniToast.makeText(((BaseJsPlugin) InternalJSPlugin.this).mContext, "\u5f53\u524d\u7248\u672c\u4e0b\u8f7d\u80fd\u529b\u6682\u4e0d\u53ef\u7528", 0).show();
                    }
                });
            }
        } else {
            z16 = true;
        }
        if (i3 != 1 && z16) {
            confirmOpenAppDetailPage(activity, str, str2, str3, str4, requestEvent);
        } else {
            QMLog.d(TAG, "only open");
            requestEvent.fail(getLaunchAppRetJsonObject(3), "app not installed");
        }
    }

    @Nullable
    private Intent getIntent(String str, PackageManager packageManager, String str2) {
        Intent launchIntentForPackage;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("path") && !TextUtils.isEmpty(jSONObject.optString("path"))) {
                    launchIntentForPackage = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(jSONObject.optString("path")));
                } else {
                    launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str2);
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.putExtra("appParameter", str);
                    }
                }
                return launchIntentForPackage;
            } catch (Throwable th5) {
                QMLog.e(TAG, "parameter error,", th5);
                Intent launchIntentForPackage2 = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str2);
                if (launchIntentForPackage2 != null) {
                    launchIntentForPackage2.putExtra("appParameter", str);
                    return launchIntentForPackage2;
                }
                return launchIntentForPackage2;
            }
        }
        return InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public JSONObject getLaunchAppRetJsonObject(int i3) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            jSONObject.put("errCode", i3);
            return jSONObject;
        } catch (JSONException e17) {
            e = e17;
            jSONObject2 = jSONObject;
            QMLog.e(TAG, "startExistedApp error, ", e);
            return jSONObject2;
        }
    }

    private void getOpenUrlDomainWhiteList() {
        String config;
        if (this.openUrlDomainWhiteList == null && (config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_OPENURL_DOMAIN_WHITELIST, WnsConfig.DEFAULT_OPENURL_DOMAIN_WHITELIST)) != null && !config.equals(this.privateOpenUrlDomainWhiteList)) {
            QMLog.i(TAG, "getOpenUrlDomainWhiteList:" + config);
            this.openUrlDomainWhiteList = new ArrayList<>();
            try {
                String[] split = config.split(",");
                if (split != null) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            this.openUrlDomainWhiteList.add(str);
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            this.privateOpenUrlDomainWhiteList = config;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getValidIntentToStartActivity(Activity activity, String str, String str2, PackageManager packageManager) {
        Intent intent = getIntent(str2, packageManager, str);
        if (intent != null) {
            intent.setPackage(str);
            intent.addFlags(268435456);
            intent.putExtra("big_brother_source_key", "biz_src_miniapp");
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                return intent;
            }
            if (!TextUtils.isEmpty(str2)) {
                return getValidIntentToStartActivity(activity, str, "", packageManager);
            }
            return null;
        }
        return null;
    }

    private boolean isParamError(JSONObject jSONObject) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && !this.mMiniAppContext.getAttachActivity().isFinishing() && jSONObject != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpenThirdApp(Activity activity, String str, String str2, String str3, String str4, int i3, String str5, RequestEvent requestEvent) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            PackageManager packageManager = activity.getPackageManager();
            try {
                if (InstalledAppListMonitor.getPackageInfo(packageManager, str2, 1) != null) {
                    startExistedApp(activity, str2, str3, str5, requestEvent, packageManager);
                } else {
                    downloadApp(activity, str, str2, str3, str4, i3, requestEvent);
                }
                return;
            } catch (PackageManager.NameNotFoundException unused) {
                downloadApp(activity, str, str2, str3, str4, i3, requestEvent);
                return;
            } catch (Exception e16) {
                QMLog.d(TAG, "open app err", e16);
                requestEvent.fail("open app err");
                return;
            }
        }
        QMLog.d(TAG, "onOpenThridApp - appid : " + str + "; packageName : " + str2 + "; appName : " + str3);
        requestEvent.fail("invalid parameter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAppDetailPage(Context context, String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && context != null && !((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).downloadApp(context, this.mMiniAppInfo, str, str2, str3, str4)) {
            MiniToast.makeText(context, 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(context) + "\u4e2d\u4e0b\u8f7d\u5e94\u7528", 1);
        }
    }

    private boolean openUrlForStyle(Bundle bundle, JSONObject jSONObject, OpenUrlCallback openUrlCallback) {
        if (jSONObject.has("style")) {
            int optInt = jSONObject.optInt("style");
            if (optInt >= 0 && optInt <= 2) {
                if (optInt != 0) {
                    if (optInt != 1) {
                        if (optInt != 2) {
                            if (optInt != 3) {
                                if (optInt == 4) {
                                    bundle.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                                    bundle.putBoolean("show_right_close_button", true);
                                }
                            } else {
                                bundle.putBoolean("hide_more_button", true);
                                bundle.putBoolean("hide_operation_bar", false);
                                bundle.putString("webStyle", "");
                            }
                        } else {
                            bundle.putBoolean("hide_more_button", false);
                            bundle.putBoolean("hide_operation_bar", false);
                            bundle.putString("webStyle", "");
                        }
                    } else {
                        bundle.putBoolean("hide_more_button", true);
                        bundle.putBoolean("hide_operation_bar", true);
                    }
                } else {
                    bundle.putBoolean("hide_more_button", false);
                    bundle.putBoolean("hide_operation_bar", true);
                }
                if (jSONObject.optInt("navigationBarStyle") == 1) {
                    bundle.putBoolean("isTransparentTitleAndClickable", true);
                }
                bundle.putBoolean("hide_title_left_arrow", jSONObject.optBoolean("hideLeftArrow", false));
            } else {
                QMLog.e(TAG, "style error, return.");
                callbackOpenResult(openUrlCallback, false, "style error");
                return true;
            }
        }
        return false;
    }

    private boolean openUrlForTarget(String str, JSONObject jSONObject, OpenUrlCallback openUrlCallback) {
        if (jSONObject.has("target")) {
            int optInt = jSONObject.optInt("target");
            if (optInt >= 0 && optInt <= 1) {
                if (optInt == 1) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
                    intent.putExtra("big_brother_source_key", "biz_src_miniapp");
                    if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
                        QMLog.d(TAG, "openUrl by system webview.");
                        this.mMiniAppContext.getAttachActivity().startActivity(intent);
                    } else {
                        QMLog.d(TAG, "openUrl by system webview error.");
                    }
                    int optInt2 = jSONObject.optInt("animation");
                    if (optInt2 != 1) {
                        if (optInt2 == 2) {
                            this.mMiniAppContext.getAttachActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
                        }
                    } else {
                        this.mMiniAppContext.getAttachActivity().overridePendingTransition(0, 0);
                    }
                    callbackOpenResult(openUrlCallback, true, null);
                    return true;
                }
            } else {
                callbackOpenResult(openUrlCallback, false, "target error");
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveToMiniAppStorage(final Context context, final String str, final String str2, final String str3) {
        if (!TextUtils.isEmpty(str) && context != null && str3 != null) {
            ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    Storage storage = null;
                    try {
                        try {
                            storage = Storage.open(context, String.valueOf(LoginManager.getInstance().getAccount()), str);
                            storage.writeSync(str2, Entry.DATA_TYPE_OBJ, str3);
                        } catch (Exception e16) {
                            QMLog.e(InternalJSPlugin.TAG, "saveToMiniAppStorage ", e16);
                            if (storage == null) {
                                return;
                            }
                        }
                        storage.close();
                    } catch (Throwable th5) {
                        if (storage != null) {
                            storage.close();
                        }
                        throw th5;
                    }
                }
            });
        }
    }

    private void startBrowserActivity(OpenUrlCallback openUrlCallback, Intent intent, MiniAppProxy miniAppProxy, int i3) {
        miniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachActivity(), intent);
        callbackOpenResult(openUrlCallback, true, null);
        if (i3 != 1) {
            if (i3 == 2) {
                this.mMiniAppContext.getAttachActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
                return;
            }
            return;
        }
        this.mMiniAppContext.getAttachActivity().overridePendingTransition(0, 0);
    }

    private void startExistedApp(final Activity activity, final String str, final String str2, final String str3, final RequestEvent requestEvent, final PackageManager packageManager) {
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.7
            @Override // java.lang.Runnable
            public void run() {
                MiniCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, String.format("\u5373\u5c06\u79bb\u5f00QQ\uff0c\u6253\u5f00\u300c%s\u300d", str2), "\u53d6\u6d88", "\u5141\u8bb8", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        Intent validIntentToStartActivity = InternalJSPlugin.this.getValidIntentToStartActivity(activity, str, str3, packageManager);
                        if (validIntentToStartActivity == null) {
                            requestEvent.fail(InternalJSPlugin.this.getLaunchAppRetJsonObject(-1), "");
                        } else {
                            activity.startActivity(validIntentToStartActivity);
                            requestEvent.ok(InternalJSPlugin.this.getLaunchAppRetJsonObject(0));
                            InnerAppReportDc4239.innerAppReport(((BaseJsPlugin) InternalJSPlugin.this).mMiniAppInfo, null, "launchapp", "openapp", null);
                        }
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.7.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        QMLog.e(InternalJSPlugin.TAG, "cancel");
                        requestEvent.fail(InternalJSPlugin.this.getLaunchAppRetJsonObject(1), "click cancel");
                    }
                });
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    createCustomDialog.show();
                }
            }
        });
    }

    @JsEvent({"getQua"})
    public void getQua(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qua", QUAUtil.getPlatformQUA());
        } catch (JSONException e16) {
            QMLog.e(TAG, "getQua", e16);
        }
        requestEvent.ok(jSONObject);
    }

    @JsEvent({"getStoreAppList"})
    public void getStoreAppList(final RequestEvent requestEvent) {
        if (TextUtils.isEmpty("")) {
            requestEvent.fail("no dataCacheKey at app.json");
        } else {
            ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    String[] strArr;
                    Storage open = Storage.open(((BaseJsPlugin) InternalJSPlugin.this).mContext, String.valueOf(LoginManager.getInstance().getAccount()), ((BaseJsPlugin) InternalJSPlugin.this).mMiniAppContext.getMiniAppInfo().appId);
                    if (open != null) {
                        strArr = open.read("");
                        open.close();
                    } else {
                        strArr = null;
                    }
                    if (strArr != null && strArr.length == 2 && TextUtils.isEmpty(strArr[1])) {
                        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getMiniAppStoreAppList(1, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.2.1
                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                                if (z16) {
                                    InternalJSPlugin.saveToMiniAppStorage(((BaseJsPlugin) InternalJSPlugin.this).mContext, ((BaseJsPlugin) InternalJSPlugin.this).mMiniAppInfo.appId, "", jSONObject.optString("data"));
                                    requestEvent.ok(jSONObject);
                                }
                            }
                        });
                    }
                    if (strArr != null && strArr.length == 2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("data", strArr[0]);
                            jSONObject.put("dataType", strArr[1]);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                        requestEvent.ok(jSONObject);
                        return;
                    }
                    requestEvent.fail();
                }
            });
        }
    }

    public void handleTuCaoUrl(RequestEvent requestEvent, String str, MiniAppProxy miniAppProxy) {
        String str2;
        String str3 = "";
        try {
            str2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QMLog.e(TAG, "startComplainAndCallback, url = ");
            e16.printStackTrace();
            str2 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            String account = LoginManager.getInstance().getAccount();
            if (account == null) {
                account = "";
            }
            String replace = str.replace("{openid}", account).replace("{clientVersion}", miniAppProxy.getAppVersion()).replace("{platform}", "android").replace("{osVersion}", String.valueOf(Build.VERSION.SDK_INT)).replace("{netType}", NetworkUtil.getNetWorkTypeByStr(this.mContext)).replace("{avatar}", str2);
            String nickName = LoginManager.getInstance().getNickName();
            if (!TextUtils.isEmpty(nickName)) {
                str3 = nickName;
            }
            String replace2 = replace.replace("{nickname}", str3);
            QMLog.d(TAG, "API_PRIVATE_OPENURL url : " + replace2);
            Intent intent = new Intent();
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, "\u8fd4\u56de");
            intent.putExtra("hide_more_button", true);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("url", replace2);
            miniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachActivity(), intent);
            requestEvent.ok();
            if (replace2.startsWith("https://tucao.qq.com/qq_miniprogram")) {
                QMLog.d(TAG, "feedback, prepare to upload log ");
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).uploadUserLog(this.mMiniAppInfo.appId);
                return;
            }
            return;
        }
        requestEvent.fail("url error");
    }

    @JsEvent({"launchApplication"})
    public void launchApplication(final RequestEvent requestEvent) {
        int i3;
        int i16;
        IMiniAppContext iMiniAppContext;
        QMLog.e(TAG, "openapp");
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("extInfo");
            final String optString = optJSONObject.optString("appConnectId");
            final String optString2 = optJSONObject.optString("appPackagename");
            final String optString3 = optJSONObject.optString("appParameter", "");
            IMiniAppContext iMiniAppContext2 = this.mMiniAppContext;
            if (iMiniAppContext2 != null && iMiniAppContext2.getMiniAppInfo() != null && this.mMiniAppContext.getMiniAppInfo().launchParam != null) {
                i3 = this.mMiniAppContext.getMiniAppInfo().launchParam.scene;
                if (this.mMiniAppContext.canLaunchApp()) {
                    i16 = this.mMiniAppContext.getLaunchAppScene();
                    QMLog.d(TAG, "API_LAUNCH_APP  realscene : " + i3 + "   scene:" + i16);
                    iMiniAppContext = this.mMiniAppContext;
                    if (iMiniAppContext == null && iMiniAppContext.getMiniAppInfo() != null) {
                        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.getMiniAppInfo().appId, optString, optString2, i16, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.5
                            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                                if (z16) {
                                    String optString4 = jSONObject.optString("appName");
                                    String optString5 = jSONObject.optString("packageName");
                                    String optString6 = jSONObject.optString("nativeAppId");
                                    String optString7 = jSONObject.optString("downloadUrl");
                                    int optInt = jSONObject.optInt("onlyOpen");
                                    InternalJSPlugin internalJSPlugin = InternalJSPlugin.this;
                                    internalJSPlugin.onOpenThirdApp(((BaseJsPlugin) internalJSPlugin).mMiniAppContext.getAttachActivity(), optString6, optString5, optString4, optString7, optInt, optString3, requestEvent);
                                    return;
                                }
                                requestEvent.fail(InternalJSPlugin.this.getLaunchAppRetJsonObject(2), "jump check failed.");
                                QMLog.w(InternalJSPlugin.TAG, String.format("jump native app check failed, appid:%s, packageName:%s", optString, optString2));
                            }
                        });
                        return;
                    } else {
                        QMLog.e(TAG, "launchApplication error, appBrandRuntime or getApkgInfo is null.");
                        requestEvent.fail(getLaunchAppRetJsonObject(-1), "appBrandRuntime or getApkgInfo is null.");
                    }
                }
            } else {
                i3 = -1;
            }
            i16 = i3;
            QMLog.d(TAG, "API_LAUNCH_APP  realscene : " + i3 + "   scene:" + i16);
            iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext == null) {
            }
            QMLog.e(TAG, "launchApplication error, appBrandRuntime or getApkgInfo is null.");
            requestEvent.fail(getLaunchAppRetJsonObject(-1), "appBrandRuntime or getApkgInfo is null.");
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error,", e16);
            requestEvent.fail(getLaunchAppRetJsonObject(-1), "exception");
        }
    }

    @JsEvent({"notifyNative"})
    public void notifyNative(RequestEvent requestEvent) {
        try {
            if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateEntryList(requestEvent.jsonParams)) {
                MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u66f4\u65b0\u4e0b\u62c9\u5217\u8868", 1);
                requestEvent.fail();
            } else {
                requestEvent.ok();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "notifyNative", e16);
            e16.printStackTrace();
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        getOpenUrlDomainWhiteList();
    }

    @JsEvent({"openUrl"})
    public void openUrl(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
                openUrl(jSONObject, new OpenUrlCallback() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.3
                    @Override // com.tencent.qqmini.sdk.plugins.InternalJSPlugin.OpenUrlCallback
                    public void openResult(boolean z16, String str) {
                        if (z16) {
                            requestEvent.ok();
                        } else {
                            requestEvent.fail(str);
                        }
                    }
                });
                return;
            }
            requestEvent.fail("url error");
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error,", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({g.NAME})
    public void private_openUrl(final RequestEvent requestEvent) {
        ArrayList<String> arrayList;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            QMLog.d(TAG, "API_PRIVATE_OPENURL " + jSONObject);
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                requestEvent.fail("url is empty");
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("__skipDomainCheck__", false);
            String lowerCase = optString.toLowerCase();
            DomainConfig domainConfig = DomainConfig.getDomainConfig(lowerCase);
            if (!optBoolean) {
                if (!this.mApkgInfo.isValidPrefix(lowerCase, false)) {
                    requestEvent.fail("url is not https");
                    return;
                } else if (domainConfig != null && (arrayList = this.openUrlDomainWhiteList) != null && !arrayList.contains(domainConfig.host)) {
                    requestEvent.fail("url domain not configured.");
                    return;
                }
            }
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            if ("tucao.qq.com".equals(domainConfig.host)) {
                handleTuCaoUrl(requestEvent, optString, miniAppProxy);
            } else {
                openUrl(jSONObject, new OpenUrlCallback() { // from class: com.tencent.qqmini.sdk.plugins.InternalJSPlugin.4
                    @Override // com.tencent.qqmini.sdk.plugins.InternalJSPlugin.OpenUrlCallback
                    public void openResult(boolean z16, String str) {
                        if (z16) {
                            requestEvent.ok();
                        } else {
                            requestEvent.fail(str);
                        }
                    }
                });
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, g.NAME, th5);
        }
    }

    public synchronized void openUrl(JSONObject jSONObject, OpenUrlCallback openUrlCallback) {
        String optString;
        if (isParamError(jSONObject)) {
            callbackOpenResult(openUrlCallback, false, "activity or json error.");
            QMLog.e(TAG, "openurl error, return.");
            return;
        }
        try {
            optString = jSONObject.optString("url");
        } catch (Exception e16) {
            QMLog.e(TAG, "openUrl error; ", e16);
            callbackOpenResult(openUrlCallback, false, "openUrl error");
        }
        if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
            if (AppBrandUtil.isOpenUrlFilter(optString)) {
                callbackOpenResult(openUrlCallback, false, "url is not support, hit filter");
                return;
            }
            if (openUrlForTarget(optString, jSONObject, openUrlCallback)) {
                return;
            }
            Bundle bundle = new Bundle();
            if (openUrlForStyle(bundle, jSONObject, openUrlCallback)) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("articalChannelId", 0);
            if (!this.mMiniAppContext.getMiniAppInfo().isInternalApp()) {
                intent.setFlags(402653184);
            }
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("big_brother_source_key", "biz_src_miniapp");
            intent.putExtras(bundle);
            intent.putExtra("url", optString);
            intent.putStringArrayListExtra(MiniAppWebviewFragment.KEY_URL_BLACK_LIST, AppBrandUtil.getConfigFilter());
            int optInt = jSONObject.optInt("animation");
            if (optInt >= 0 && optInt <= 2) {
                startBrowserActivity(openUrlCallback, intent, (MiniAppProxy) ProxyManager.get(MiniAppProxy.class), optInt);
                return;
            }
            QMLog.e(TAG, "animation error, return.");
            callbackOpenResult(openUrlCallback, false, "animation error");
            return;
        }
        callbackOpenResult(openUrlCallback, false, "url is null.");
    }
}
