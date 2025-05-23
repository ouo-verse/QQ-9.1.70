package com.tencent.mobileqq.webview.api.impl;

import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.biz.webviewplugin.WeizhengquanJsPlugin;
import com.tencent.biz.webviewplugin.ae;
import com.tencent.biz.webviewplugin.ah;
import com.tencent.biz.webviewplugin.x;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.h;
import com.tencent.mobileqq.jsp.w;
import com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.WebSecurityPluginV2;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.g;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0015\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0004J\u0015\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0004J\u0015\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\u0004J\u0015\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\f\u0010\u0004J\u0015\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\u0004J\u0015\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0004J\u0015\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0004J\u0015\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0004J\u0015\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0004J\u0015\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0004J\u0015\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0004J\u0015\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0004J\u0015\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0004J\u0015\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0004J\u0015\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0004J\u0015\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0004J\u0015\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0004J\u0015\u0010\u001a\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0004J\u0015\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u0004J\u0015\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u0004J\u0015\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u0004J\u0015\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u0004J\u0015\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\u001f\u0010\u0004J\u0015\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b \u0010\u0004J\u0015\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b!\u0010\u0004J\u0015\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002H\u0016\u00a2\u0006\u0004\b\"\u0010\u0004J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0016\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/webview/api/impl/JsApiImpl;", "Lcom/tencent/mobileqq/webview/api/IJsApi;", "T", "getQQApiPlugin", "()Ljava/lang/Object;", "getWebViewJumpPlugin", "getConfessPlugin", "getUIApiPlugin", "getShareApiPlugin", "getVasCommonJsPlugin", "getQQIliveJsPlugin", "getAntiphingHandlerPlugin", "getWebForceHttpsPlugin", "getWebSecurityPluginV2Plugin", "getVasWebReportPlugin", "getWebSoPlugin", "getReportPlugin", "getPtloginPlugin", "getEventApiPlugin", "getOpenCenterPlugin", "getQWalletPayJsPlugin", "getPayJsPlugin", "getQWalletCommonJsPlugin", "getQWalletBluetoothJsPlugin", "getDataApiPlugin", "getQWalletCommonHbJsPlugin", "getSSOWebviewPlugin", "getDocxApiPlugin", "getSensorAPIJavaScript", "getMediaApiPlugin", "getQWalletMixJsPlugin", "getWeizhengquanJsPlugin", "getTogetherBusinessForWebPlugin", "getHippyCallBackListenerWebViewPlugin", "getOfflinePlugin", "", "getQQApiPluginNameSpace", "getWebViewJumpPluginNameSpace", "getConfessPluginNameSpace", "<init>", "()V", "Companion", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class JsApiImpl implements IJsApi {
    public static final String TAG = "WebDataImpl";

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getAntiphingHandlerPlugin() {
        return (T) new com.tencent.mobileqq.antiphing.a();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getConfessPlugin() {
        return (T) new ConfessPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public String getConfessPluginNameSpace() {
        return "sayHonest";
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getDataApiPlugin() {
        return (T) new DataApiPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getDocxApiPlugin() {
        return (T) new DocxApiPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getEventApiPlugin() {
        return (T) new h();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getHippyCallBackListenerWebViewPlugin() {
        return (T) new com.tencent.mobileqq.vas.hippy.a();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getMediaApiPlugin() {
        return (T) new MediaApiPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getOfflinePlugin() {
        return (T) new OfflinePlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getOpenCenterPlugin() {
        return (T) new OpenCenterPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getPayJsPlugin() {
        return (T) new PayJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getPtloginPlugin() {
        return (T) new x();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getQQApiPlugin() {
        return (T) new w();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public String getQQApiPluginNameSpace() {
        return "QQApi";
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getQQIliveJsPlugin() {
        return (T) new QQIliveJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getQWalletBluetoothJsPlugin() {
        return (T) new QWalletBluetoothJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getQWalletCommonHbJsPlugin() {
        return (T) new QWalletCommonHbJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getQWalletCommonJsPlugin() {
        return (T) new QWalletCommonJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getQWalletMixJsPlugin() {
        return (T) new QWalletMixJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getQWalletPayJsPlugin() {
        return (T) new QWalletPayJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getReportPlugin() {
        return (T) new ae();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getSSOWebviewPlugin() {
        return (T) new SSOWebviewPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getSensorAPIJavaScript() {
        return (T) new SensorAPIJavaScript();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getShareApiPlugin() {
        return (T) new ah();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getTogetherBusinessForWebPlugin() {
        return (T) new TogetherBusinessForWebPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getUIApiPlugin() {
        return (T) new UiApiPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getVasCommonJsPlugin() {
        return (T) new VasCommonJsPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getVasWebReportPlugin() {
        return (T) new VasWebReport();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getWebForceHttpsPlugin() {
        return (T) new g();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getWebSecurityPluginV2Plugin() {
        return (T) new WebSecurityPluginV2();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getWebSoPlugin() {
        return (T) new WebSoPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getWebViewJumpPlugin() {
        return (T) new WebViewJumpPlugin();
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public String getWebViewJumpPluginNameSpace() {
        String PLUGIN_NAMESPACE = WebViewJumpPlugin.f315044m;
        Intrinsics.checkNotNullExpressionValue(PLUGIN_NAMESPACE, "PLUGIN_NAMESPACE");
        return PLUGIN_NAMESPACE;
    }

    @Override // com.tencent.mobileqq.webview.api.IJsApi
    public <T> T getWeizhengquanJsPlugin() {
        return (T) new WeizhengquanJsPlugin();
    }
}
