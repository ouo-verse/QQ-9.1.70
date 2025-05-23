package com.tencent.mobileqq.mini.out.webPlugins;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.utils.MiniAppWnsConfig;
import com.tencent.mobileqq.mini.widget.LaunchConfirmDialogWrapper;
import com.tencent.mobileqq.minigame.ui.PayForFriendView;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.util.UiThreadUtil;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniAppPlugin extends WebViewPlugin {
    public static final String ACTION_RETURN_ADDRESS_TO_MINIAPP = "action_return_address_to_miniapp";
    public static final String ATTR_PAGE_TYPE = "page_type";
    public static final String DESKTOP_PAGE = "desktop";
    private static final String KEY_AIO_MSG_TYPE = "curtype";
    private static final String KEY_FROM_AIO = "fromAio";
    private static final String KEY_FROM_QZONE = "fromQZone";
    public static final String KEY_MINIAPP_ADDRESS_INFO = "key_miniapp_address_info";
    private static final String KEY_URL = "url";
    public static final String MINI_APP_HOST = "sou.qq.com";
    public static final String PLUGIN_NAMESPACE = "miniApp";
    public static final String SCHEME = "miniApp";
    public static final int SHARE_TARGET_QQ = 0;
    public static final String TAG = "MiniAppPlugin";
    private static final String URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1 = "https://www.mqqapi.com//microapp/open?";
    private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL = "https://mqqapi//microapp/open?";
    public static final String URL_PREFIX_MINIGAME_PAY_BY_H5 = "https://h5.qzone.qq.com/miniapp/act/midasPay";
    private static final int canOpenApp = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_CAN_OPEN_APP, 1);
    private static final int canOpenWxApp = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.WX_MINIAPP_EABLE, 1);
    private t remoteRespObserver = new t() { // from class: com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.6
        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            if (bundle != null && bundle.getInt("respkey") == MiniAppPlugin.this.remoteRespObserver.key && "ipc_start_miniapp".equals(bundle.getString("cmd"))) {
                String string = bundle.getString("callbackid");
                String string2 = bundle.getBundle("response").getString("result");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    return;
                }
                QLog.e(MiniAppPlugin.TAG, 2, "ipc_start_miniapp result : " + string2);
                MiniAppPlugin.this.callJs(string, string2);
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }
    };

    private static MiniAppConfig buildMiniAppConfig(Activity activity, MiniAppInfo miniAppInfo) {
        int i3;
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        LaunchParam launchParam = miniAppConfig.launchParam;
        if (launchParam == null) {
            launchParam = new LaunchParam();
        }
        Intent intent = activity.getIntent();
        if (intent.getBooleanExtra(KEY_FROM_AIO, false)) {
            i3 = intent.getIntExtra(KEY_AIO_MSG_TYPE, 0) == 0 ? 1007 : 1008;
        } else {
            i3 = 2009;
        }
        launchParam.scene = i3;
        launchParam.miniAppId = miniAppInfo.appId;
        launchParam.reportData = miniAppInfo.reportData;
        miniAppConfig.launchParam = launchParam;
        return miniAppConfig;
    }

    private void closePage(String str) {
        QLog.d(TAG, 1, "handleSchemaRequest: else uri ");
        Uri parse = Uri.parse(str);
        if (parse.isHierarchical() && parse.getBooleanQueryParameter("closePage", true)) {
            this.mRuntime.a().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartMiniApp(final Activity activity, MiniAppConfig miniAppConfig, String str) {
        MiniAppLauncher.launchAppByAppConfig(activity, miniAppConfig, new ResultReceiver(new Handler()) { // from class: com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.5
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                if (i3 == 0) {
                    activity.finish();
                }
            }
        });
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, MiniProgramLpReportDC04239.NORMAL_URL_ACTION_TYPE, "bottom", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, str);
    }

    private static String getFakeUrlFromShareUrl(String str) {
        HashMap<String, String> urlParam;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL;
        if (!str.startsWith(URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL)) {
            str2 = URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1;
            if (!str.startsWith(URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1)) {
                str2 = null;
            }
        }
        if (TextUtils.isEmpty(str2) || (urlParam = getUrlParam(str, str2)) == null) {
            return str;
        }
        for (Map.Entry<String, String> entry : urlParam.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && key.equals("fakeUrl")) {
                return entry.getValue();
            }
        }
        return str;
    }

    private static HashMap<String, String> getUrlParam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.substring(str2.length()).split(ContainerUtils.FIELD_DELIMITER);
        if (split != null) {
            for (String str3 : split) {
                String[] split2 = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    private void handleJumpOrLaunchFail(String str) {
        this.mRuntime.a().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(MiniAppPlugin.this.mRuntime.a(), 1, R.string.f171176cx2, 0).show();
            }
        });
        QLog.e(TAG, 1, "handleSchemaRequest: launch failed with url " + str);
    }

    private static boolean isMiniAppShareUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL) || str.startsWith(URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMiniApp(final String str, MiniAppInfo miniAppInfo) {
        WebViewPlugin.b bVar = this.mRuntime;
        final Activity a16 = bVar != null ? bVar.a() : null;
        if (a16 == null || a16.isFinishing() || a16.isDestroyed()) {
            return;
        }
        final MiniAppConfig buildMiniAppConfig = buildMiniAppConfig(a16, miniAppInfo);
        if (MiniAppWnsConfig.urlDirectOpenMiniAppWhiteList().contains(miniAppInfo.appId)) {
            doStartMiniApp(a16, buildMiniAppConfig, str);
        } else {
            new LaunchConfirmDialogWrapper.Builder().setIconUrl(miniAppInfo.iconUrl).setConfirmListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MiniAppPlugin.this.doStartMiniApp(a16, buildMiniAppConfig, str);
                }
            }).setCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MiniProgramLpReportDC04239.reportAsync(buildMiniAppConfig, MiniProgramLpReportDC04239.NORMAL_URL_ACTION_TYPE, "bottom", "cancel", str);
                }
            }).build(a16).show();
        }
    }

    private void queryMiniAppInfoIfNeeded() {
        WebViewPlugin.b bVar = this.mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        if (a16 == null) {
            return;
        }
        Intent intent = a16.getIntent();
        if (intent.getBooleanExtra(KEY_FROM_AIO, false) || intent.getBooleanExtra(KEY_FROM_QZONE, false)) {
            String stringExtra = intent.getStringExtra("url");
            if (!URLUtil.isNetworkUrl(stringExtra) || MiniAppLauncher.isMiniAppUrl(getFakeUrlFromShareUrl(stringExtra)) || isMiniAppShareUrl(stringExtra)) {
                return;
            }
            requestMiniAppInfoForNormalUrl(stringExtra);
        }
    }

    private void requestMiniAppInfoForNormalUrl(final String str) {
        MiniAppCmdUtil.getInstance().getAppInfoByLink(str, 3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                long optLong = jSONObject.optLong("retCode");
                if (z16 && optLong == 0) {
                    final MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("appInfo");
                    if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                MiniAppPlugin.this.openMiniApp(str, miniAppInfo);
                            }
                        });
                        return;
                    } else {
                        QLog.e(MiniAppPlugin.TAG, 2, "requestMiniApp invalid appInfo");
                        return;
                    }
                }
                QLog.e(MiniAppPlugin.TAG, 2, "requestMiniApp failed, retCode=" + optLong + ",errMsg=" + jSONObject.optString("errMsg"));
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "miniApp";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        WebResourceRequest webResourceRequest;
        String str2;
        try {
            if (TextUtils.isEmpty(str) || !str.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay") || map == null || j3 != 8589934612L || !map.containsKey("errorCode")) {
                return false;
            }
            int intValue = ((Integer) map.get("errorCode")).intValue();
            QLog.i(TAG, 1, "paybyh5 handleEvent EVENT_RECEIVER_HTTP_ERROR errorCode:" + intValue);
            Object obj = map.get(WebViewPlugin.KEY_REQUEST);
            if (!(obj instanceof WebResourceRequest) || (webResourceRequest = (WebResourceRequest) obj) == null) {
                return false;
            }
            Uri url = webResourceRequest.getUrl();
            if (url != null) {
                str2 = url.toString();
            } else {
                str2 = "";
            }
            QLog.i(TAG, 1, "paybyh5 handleEvent realUrlStr:" + str2);
            if (TextUtils.isEmpty(str2) || !str2.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("errCode", -3);
            intent.putExtra("errMsg", "EVENT_RECEIVER_HTTP_ERROR\uff1a" + intValue);
            intent.putExtra(ImageTaskConst.ERROR_TYPE, 8589934612L);
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar == null || bVar.a() == null) {
                return false;
            }
            this.mRuntime.a().setResult(-1, intent);
            this.mRuntime.a().finish();
            return false;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "handleEvent error.", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin.b bVar;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        String optString5;
        String optString6;
        String optString7;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str2 != null && str2.equalsIgnoreCase("miniApp") && str3 != null && (bVar = this.mRuntime) != null && bVar.a() != null) {
            if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication());
            }
            if (str3.equals("openApp")) {
                try {
                    JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
                    if (jsonFromJSBridge == null) {
                        jsonFromJSBridge = new JSONObject(strArr[0]);
                    }
                    optString = jsonFromJSBridge.optString("appid");
                    optString2 = jsonFromJSBridge.optString("apptype");
                    optString3 = jsonFromJSBridge.optString("via");
                    optString4 = jsonFromJSBridge.optString("callback");
                    optString5 = jsonFromJSBridge.optString("path");
                    optString6 = jsonFromJSBridge.optString("type");
                    optString7 = jsonFromJSBridge.optString("enVersion");
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "openApp error.", th5);
                }
                if (canOpenApp != 1) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ret", -1);
                    jSONObject.put("msg", "canOpenApp false.");
                    callJs(optString4, jSONObject.toString());
                    return true;
                }
                openApp(optString, optString2, optString3, optString4, optString5, optString6, optString7);
                return true;
            }
            if (str3.equals("canOpenApp")) {
                try {
                    JSONObject jsonFromJSBridge2 = WebViewPlugin.getJsonFromJSBridge(str);
                    if (jsonFromJSBridge2 == null) {
                        if (strArr != null && strArr.length > 0) {
                            jsonFromJSBridge2 = new JSONObject(strArr[0]);
                        } else {
                            jsonFromJSBridge2 = new JSONObject();
                        }
                    }
                    "wechat".equals(jsonFromJSBridge2.has("type") ? jsonFromJSBridge2.optString("type") : null);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("canOpenApp", canOpenApp == 1);
                    jsBridgeListener.c(jSONObject2);
                } catch (Throwable th6) {
                    QLog.e(TAG, 1, "canOpenApp error.", th6);
                }
                return true;
            }
            if (str3.equals("chooseAddress")) {
                if (strArr != null) {
                    try {
                        if (strArr.length > 0) {
                            JSONObject jSONObject3 = new JSONObject(strArr[0]);
                            String optString8 = jSONObject3.has("callback") ? jSONObject3.optString("callback") : null;
                            if (strArr[0] != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 1, "address_info" + strArr[0]);
                                }
                                Intent intent = new Intent(ACTION_RETURN_ADDRESS_TO_MINIAPP);
                                intent.putExtra(KEY_MINIAPP_ADDRESS_INFO, strArr[0]);
                                BaseApplicationImpl.getApplication().sendBroadcast(intent);
                            }
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("ret", 0);
                            jSONObject4.put("msg", "get addressResult suc.");
                            callJs(optString8, jSONObject4.toString());
                        }
                    } catch (Throwable th7) {
                        QLog.e(TAG, 1, "chooseAddress error.", th7);
                    }
                }
                return true;
            }
            if (str3.equals("payCallback")) {
                try {
                    JSONObject jsonFromJSBridge3 = WebViewPlugin.getJsonFromJSBridge(str);
                    QLog.w(TAG, 1, "payCallback: json=" + jsonFromJSBridge3);
                    Intent intent2 = new Intent();
                    if (jsonFromJSBridge3 == null) {
                        intent2.putExtra("errCode", -1);
                        intent2.putExtra("errMsg", "\u652f\u4ed8\u5931\u8d25\uff1a\u65e0\u652f\u4ed8\u4fe1\u606f\u3002");
                        QLog.e(TAG, 1, "payCallback: error json is null. url=" + str);
                    } else {
                        intent2.putExtra("errCode", jsonFromJSBridge3.optInt("errCode"));
                        intent2.putExtra("errMsg", jsonFromJSBridge3.optString("errMsg"));
                        intent2.putExtra("tipMsg", jsonFromJSBridge3.optString("tipMsg"));
                    }
                    WebViewPlugin.b bVar2 = this.mRuntime;
                    if (bVar2 != null && bVar2.a() != null) {
                        this.mRuntime.a().setResult(-1, intent2);
                        this.mRuntime.a().finish();
                    }
                } catch (Throwable th8) {
                    QLog.e(TAG, 1, "payCallback error.", th8);
                }
                return true;
            }
            if (str3.equals("closeFriendPaymentH5")) {
                WebViewPlugin.b bVar3 = this.mRuntime;
                if (bVar3 != null && bVar3.e() != null) {
                    this.mRuntime.e().setVisibility(8);
                }
                return true;
            }
            if (str3.equals("shareFriendPayment")) {
                JSONObject jsonFromJSBridge4 = WebViewPlugin.getJsonFromJSBridge(str);
                if (jsonFromJSBridge4 == null) {
                    return false;
                }
                try {
                    String string = jsonFromJSBridge4.getString("prepayId");
                    int optInt = jsonFromJSBridge4.optInt("setEnv", 0);
                    String optString9 = jsonFromJSBridge4.optString("title");
                    String optString10 = jsonFromJSBridge4.optString("imageUrl");
                    if (TextUtils.isEmpty(optString9)) {
                        optString9 = GameWnsUtils.defaultPayShareTitle();
                    }
                    if (TextUtils.isEmpty(optString10)) {
                        optString10 = GameWnsUtils.defaultPayShareImg();
                    }
                    COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
                    COMM.Entry entry = new COMM.Entry();
                    entry.key.set("prepay_id");
                    entry.value.set(string);
                    stCommonExt.mapInfo.get().add(entry);
                    COMM.Entry entry2 = new COMM.Entry();
                    entry2.key.set("set_env");
                    entry2.value.set(optInt + "");
                    stCommonExt.mapInfo.get().add(entry2);
                    WebViewPlugin.b bVar4 = this.mRuntime;
                    if (bVar4 != null && (bVar4.e() instanceof PayForFriendView)) {
                        PayForFriendView payForFriendView = (PayForFriendView) this.mRuntime.e();
                        ShareQQArkHelper.s(this.mRuntime.a(), new MiniArkShareModelBuilder().setAppId(payForFriendView.getAppId()).setTitle(payForFriendView.getAppName()).setDescription(optString9).setShareScene(4).setShareTemplateType(1).setShareBusinessType(1).setPicUrl(optString10).setVidUrl(null).setJumpUrl("").setIconUrl(payForFriendView.getAppIconUrl()).setVersionType(payForFriendView.getAppVerType()).setVersionId(payForFriendView.getAppVersionId()).setWebURL("").setTemplateId("").setTemplateData("").setEntryModel(null).setShareChatModel(null).setShareTarget(0).setRcvOpenId("").setWithShareTicket(false).setMiniAppShareFrom(13).setExtInfo(stCommonExt).createMiniArkShareModel(), null);
                    }
                    return true;
                } catch (Throwable th9) {
                    QLog.e(TAG, 1, "shareFriendPayment error.", th9);
                }
            } else {
                if (str3.equals("closeWebview")) {
                    try {
                        JSONObject jsonFromJSBridge5 = WebViewPlugin.getJsonFromJSBridge(str);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("closeWebview");
                        sb5.append(jsonFromJSBridge5);
                        QLog.i(TAG, 1, sb5.toString() != null ? jsonFromJSBridge5.toString() : "");
                        Intent intent3 = new Intent();
                        int optInt2 = jsonFromJSBridge5.optInt("allClose", -1);
                        if (optInt2 == -1) {
                            QLog.e(TAG, 1, "no allClose back from h5");
                        }
                        intent3.putExtra("allCloseState", optInt2);
                        WebViewPlugin.b bVar5 = this.mRuntime;
                        if (bVar5 != null && bVar5.a() != null) {
                            this.mRuntime.a().setResult(-1, intent3);
                            this.mRuntime.a().finish();
                        }
                    } catch (Throwable th10) {
                        QLog.e(TAG, 1, "closeWebview error.", th10);
                    }
                    return true;
                }
                if (str3.equals("bindwx")) {
                    try {
                        JSONObject jsonFromJSBridge6 = WebViewPlugin.getJsonFromJSBridge(str);
                        if (jsonFromJSBridge6 != null && jsonFromJSBridge6.has(ATTR_PAGE_TYPE) && jsonFromJSBridge6.getString(ATTR_PAGE_TYPE).equals("desktop")) {
                            ((IMiniAppService) QRoute.api(IMiniAppService.class)).openDesktopWxAuthFragment();
                        } else {
                            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).openWxBindingPage();
                        }
                    } catch (Throwable th11) {
                        QLog.e(TAG, 1, "bindwx error!", th11);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        WebViewPlugin.b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.mRuntime) == null || bVar.a() == null) {
            return false;
        }
        String fakeUrlFromShareUrl = getFakeUrlFromShareUrl(str);
        String d16 = QLog.isColorLevel() ? fakeUrlFromShareUrl : s.d(fakeUrlFromShareUrl, new String[0]);
        QLog.d(TAG, 1, "handleSchemaRequest: launch url " + (QLog.isColorLevel() ? str : s.d(str, new String[0])) + " scheme = " + str2 + " fakeUrl = " + d16);
        if (!MiniAppLauncher.isMiniAppUrl(fakeUrlFromShareUrl) && !isMiniAppShareUrl(str)) {
            if (((IWxMiniManager) QRoute.api(IWxMiniManager.class)).isWxMiniApp(str)) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByWxRawData(this.mRuntime.a().getApplicationContext(), str, 2014);
                closePage(str);
                return true;
            }
            return super.handleSchemaRequest(str, str2);
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(fakeUrlFromShareUrl)) {
            QLog.d(TAG, 1, "handleSchemaRequest: isMiniAppUrl url " + fakeUrlFromShareUrl);
            if (!((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniApp(this.mRuntime.a().getApplicationContext(), fakeUrlFromShareUrl, 2014, null)) {
                handleJumpOrLaunchFail(fakeUrlFromShareUrl);
                return false;
            }
            closePage(str);
            return true;
        }
        QLog.d(TAG, 1, "handleSchemaRequest: else uri ");
        closePage(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        super.onActivityReady();
        queryMiniAppInfoIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.remoteRespObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.remoteRespObserver);
    }

    protected void sendRemoteReq(Bundle bundle, boolean z16, boolean z17) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            QQToast.makeText(this.mRuntime.a().getApplicationContext(), HardCodeUtil.qqStr(R.string.f172194o83), 0).show();
            QLog.e(TAG, 2, "sendRemoteReq: service not binded, bind service again.");
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication());
        } else if (z16) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openApp$0(String str, boolean z16, Bundle bundle) {
        if (bundle != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ret", bundle.getLong("retCode", 0L));
                if (!z16) {
                    jSONObject.put("msg", bundle.getString("errMsg"));
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                QLog.e(TAG, 2, "ipc_start_miniapp result : " + jSONObject);
                callJs(str, jSONObject.toString());
            } catch (Throwable th5) {
                QLog.e("launchMiniAppById", 1, "launchMiniAppById error,", th5);
            }
        }
    }

    private void openApp(String str, String str2, String str3, final String str4, String str5, String str6, String str7) {
        if (MobileQQ.sProcessId != 1) {
            Bundle bundle = new Bundle();
            bundle.putString("miniapp_appid", str);
            bundle.putString("miniapp_type", str2);
            bundle.putString("miniapp_via", str3);
            bundle.putString("miniapp_path", str5);
            bundle.putString("miniapp_platform_type", str6);
            bundle.putString("miniapp_en_version", str7);
            sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_start_miniapp", str4, this.remoteRespObserver.key, bundle), false, false);
            return;
        }
        if ("wechat".equals(str6)) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(BaseApplication.getContext(), str, str5, 1005);
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(BaseApplication.getContext(), str, str5, null, str7, "via=" + str3, 1005, new MiniAppLaunchListener() { // from class: com.tencent.mobileqq.mini.out.webPlugins.a
            @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
            public final void onLaunchResult(boolean z16, Bundle bundle2) {
                MiniAppPlugin.this.lambda$openApp$0(str4, z16, bundle2);
            }
        });
    }
}
