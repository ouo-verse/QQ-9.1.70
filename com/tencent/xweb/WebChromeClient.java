package com.tencent.xweb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebChromeClient {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        @Nullable
        public static Uri[] parseResult(int i3, Intent intent) {
            return null;
        }

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        @Nullable
        public abstract String getFilenameHint();

        public abstract int getMode();

        @Nullable
        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    @Nullable
    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    @Nullable
    public View getVideoLoadingProgressView() {
        return null;
    }

    @Deprecated
    public void onConsoleMessage(String str, int i3, String str2) {
    }

    public boolean onCreateWindow(WebView webView, boolean z16, boolean z17, Message message) {
        return false;
    }

    public boolean onEnterFullscreen(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        return false;
    }

    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j3, long j16, long j17, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j3);
    }

    public boolean onExitFullscreen() {
        return false;
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, true);
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

    public void onPermissionRequest(PermissionRequest permissionRequest) {
        permissionRequest.deny();
    }

    @Deprecated
    public void onReachedMaxAppCacheSize(long j3, long j16, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j16);
    }

    public boolean onSearchWord(String str, String str2, String str3, String str4, String str5, String str6) {
        return true;
    }

    public boolean onSelectInfoChanged(long j3, String str, String str2, String str3) {
        return true;
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return false;
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        valueCallback.onReceiveValue(null);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onHideCustomView() {
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(WebView webView) {
    }

    public void onExitFullscreenVideo(Bitmap bitmap) {
    }

    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
    }

    public void onRequestFocus(WebView webView) {
    }

    public void onDidChangeThemeColor(WebView webView, int i3) {
    }

    public void onProgressChanged(WebView webView, int i3) {
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z16) {
    }
}
