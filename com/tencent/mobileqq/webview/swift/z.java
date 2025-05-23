package com.tencent.mobileqq.webview.swift;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface z {
    boolean afterWebViewEngineHandleOverrideUrl(WebView webView, String str);

    boolean beforeWebViewEngineHandleOverrideUrl(WebView webView, String str);

    DownloadListener getDownloadListener(CustomWebView customWebView);

    String getUAMark();

    String getUserAgent(String str, String str2, Boolean bool);

    View getVideoLoadingProgressView();

    void handlePreloadCallback(int i3, String str);

    Object handlerMiscCallback(String str, Bundle bundle);

    boolean interceptUserAgentGenerate();

    boolean isFinishing();

    void onDetectedBlankScreen(String str, int i3);

    void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback);

    void onHideCustomView();

    boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult);

    boolean onLongClick(View view);

    void onPageCommitVisible(WebView webView, String str);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onPermissionRequest(PermissionRequest permissionRequest);

    void onProgressChanged(WebView webView, int i3);

    void onReceivedError(WebView webView, int i3, String str, String str2);

    boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void onReceivedTitle(WebView webView, String str);

    boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

    void onUrlChange(String str, String str2);

    void onWebViewClientImplPageStarted(WebView webView, String str, Bitmap bitmap);

    void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2);

    boolean shouldOverrideUrlLoading(WebView webView, String str);

    void showCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback);
}
