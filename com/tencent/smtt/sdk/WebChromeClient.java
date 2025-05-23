package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.utils.TbsLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebChromeClient {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public static Uri[] parseResult(int i3, Intent intent) {
            try {
                p a16 = p.a();
                if (a16 != null && a16.b()) {
                    return a16.c().a(i3, intent);
                }
                return WebChromeClient.FileChooserParams.parseResult(i3, intent);
            } catch (Exception e16) {
                TbsLog.i("WebChromeClient", "parseResult:" + e16.toString());
                return null;
            }
        }

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public boolean onCreateWindow(WebView webView, boolean z16, boolean z17, Message message) {
        return false;
    }

    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j3, long j16, long j17, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j16);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        geolocationPermissionsCallback.invoke(str, true, true);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    @Deprecated
    public boolean onJsTimeout() {
        return true;
    }

    @Deprecated
    public void onReachedMaxAppCacheSize(long j3, long j16, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j16);
    }

    @Deprecated
    public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return false;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        valueCallback.onReceiveValue(null);
    }

    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onHideCustomView() {
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(WebView webView) {
    }

    public void onPermissionRequest(PermissionRequest permissionRequest) {
    }

    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
    }

    public void onRequestFocus(WebView webView) {
    }

    public void onProgressChanged(WebView webView, int i3) {
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z16) {
    }
}
