package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class GdtAdWebPlugin extends WebViewPlugin {
    public static final String NAME_SPACE = "qq_gdt_ad";
    private static final String TAG = "GdtAdWebPlugin";

    public GdtAdWebPlugin() {
        Context context;
        if (getActivity() != null) {
            context = getActivity();
        } else {
            context = BaseApplication.getContext();
        }
        IGdtAdAPI iGdtAdAPI = (IGdtAdAPI) QRoute.api(IGdtAdAPI.class);
        if (iGdtAdAPI != null) {
            iGdtAdAPI.initGdtContext(context, new InitGdtContextParams());
        }
    }

    @Nullable
    public Activity getActivity() {
        Activity activity;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (activity instanceof BasePluginActivity) {
            return ((BasePluginActivity) BasePluginActivity.class.cast(activity)).getOutActivity();
        }
        return activity;
    }

    @Nullable
    public String getCurrentUrl() {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof QQBrowserActivity)) {
            return null;
        }
        return ((QQBrowserActivity) QQBrowserActivity.class.cast(activity)).getCurrentUrl();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NAME_SPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "method:" + str3);
        }
        GdtJsCallHandler gdtJsCallHandler = null;
        try {
            str4 = new JSONObject(strArr[0]).optString("callback");
        } catch (Exception e16) {
            GdtLog.e(TAG, "GdtAdWebPlugin handleJsCallRequest error ", e16);
            str4 = null;
        }
        if ("loadAdDemo".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(5);
        } else if ("handleClick".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(12);
        } else if ("showBanner".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(13);
        } else if ("showInterstitial".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(19);
        } else if ("showInterstitialForJS".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(20);
        } else if ("getDeviceInfo".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(14);
        } else if ("c2sReport".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(15);
        } else if ("openMotiveVideoAd".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(16);
        } else if ("getUserInfo".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(17);
        } else if ("preLoadAfterAdLoaded".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(18);
        } else if ("launchAppWithDeeplink".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(24);
        } else if ("showDeviceDemo".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(28);
        } else if ("showFeedback".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(32);
        } else if ("showMotiveVideoDemo".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(33);
        } else if ("reportAdEventToVas".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(34);
        } else if ("openWechatMiniApp".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(35);
        } else if ("launchAppMarket".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(36);
        } else if ("openWeChatCanvas".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(37);
        } else if ("showButtonDemo".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(38);
        } else if ("openMotiveAd".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(39);
        } else if ("openVideoCelling".equals(str3)) {
            gdtJsCallHandler = GdtAdPluginFactory.getInstance().findJsCallHandler(40);
        }
        if (gdtJsCallHandler == null) {
            return true;
        }
        gdtJsCallHandler.handleJsCallRequest(this, str4, strArr);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        GdtLog.i(TAG, String.format("onActivityResult requestCode:%d resultCode:%d", Byte.valueOf(b16), Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }
}
