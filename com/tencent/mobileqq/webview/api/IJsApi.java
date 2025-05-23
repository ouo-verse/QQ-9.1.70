package com.tencent.mobileqq.webview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b \bg\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H&J\u0013\u0010\b\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\n\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u000b\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\f\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\r\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u000e\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u000f\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0010\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0007H&J\u0013\u0010\u0013\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0014\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0015\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0016\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0017\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0018\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0019\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u001a\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u001b\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u001c\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u001d\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u001e\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u001f\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010 \u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010!\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\"\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010#\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010$\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020\u0007H&J\u0013\u0010&\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003H&\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/webview/api/IJsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAntiphingHandlerPlugin", "T", "()Ljava/lang/Object;", "getConfessPlugin", "getConfessPluginNameSpace", "", "getDataApiPlugin", "getDocxApiPlugin", "getEventApiPlugin", "getHippyCallBackListenerWebViewPlugin", "getMediaApiPlugin", "getOfflinePlugin", "getOpenCenterPlugin", "getPayJsPlugin", "getPtloginPlugin", "getQQApiPlugin", "getQQApiPluginNameSpace", "getQQIliveJsPlugin", "getQWalletBluetoothJsPlugin", "getQWalletCommonHbJsPlugin", "getQWalletCommonJsPlugin", "getQWalletMixJsPlugin", "getQWalletPayJsPlugin", "getReportPlugin", "getSSOWebviewPlugin", "getSensorAPIJavaScript", "getShareApiPlugin", "getTogetherBusinessForWebPlugin", "getUIApiPlugin", "getVasCommonJsPlugin", "getVasWebReportPlugin", "getWebForceHttpsPlugin", "getWebSecurityPluginV2Plugin", "getWebSoPlugin", "getWebViewJumpPlugin", "getWebViewJumpPluginNameSpace", "getWeizhengquanJsPlugin", "webview_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IJsApi extends QRouteApi {
    <T> T getAntiphingHandlerPlugin();

    <T> T getConfessPlugin();

    @NotNull
    String getConfessPluginNameSpace();

    <T> T getDataApiPlugin();

    <T> T getDocxApiPlugin();

    <T> T getEventApiPlugin();

    <T> T getHippyCallBackListenerWebViewPlugin();

    <T> T getMediaApiPlugin();

    <T> T getOfflinePlugin();

    <T> T getOpenCenterPlugin();

    <T> T getPayJsPlugin();

    <T> T getPtloginPlugin();

    <T> T getQQApiPlugin();

    @NotNull
    String getQQApiPluginNameSpace();

    <T> T getQQIliveJsPlugin();

    <T> T getQWalletBluetoothJsPlugin();

    <T> T getQWalletCommonHbJsPlugin();

    <T> T getQWalletCommonJsPlugin();

    <T> T getQWalletMixJsPlugin();

    <T> T getQWalletPayJsPlugin();

    <T> T getReportPlugin();

    <T> T getSSOWebviewPlugin();

    <T> T getSensorAPIJavaScript();

    <T> T getShareApiPlugin();

    <T> T getTogetherBusinessForWebPlugin();

    <T> T getUIApiPlugin();

    <T> T getVasCommonJsPlugin();

    <T> T getVasWebReportPlugin();

    <T> T getWebForceHttpsPlugin();

    <T> T getWebSecurityPluginV2Plugin();

    <T> T getWebSoPlugin();

    <T> T getWebViewJumpPlugin();

    @NotNull
    String getWebViewJumpPluginNameSpace();

    <T> T getWeizhengquanJsPlugin();
}
