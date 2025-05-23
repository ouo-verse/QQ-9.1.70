package com.tencent.smtt.export.external.interfaces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IX5WebChromeClient {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public static Uri[] parseResult(int i3, Intent intent) {
            return null;
        }

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    Bitmap getDefaultVideoPoster();

    void getVisitedHistory(ValueCallback<String[]> valueCallback);

    void onCloseWindow(IX5WebViewBase iX5WebViewBase);

    @Deprecated
    void onConsoleMessage(String str, int i3, String str2);

    boolean onConsoleMessage(ConsoleMessage consoleMessage);

    boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z16, boolean z17, Message message);

    void onExceededDatabaseQuota(String str, String str2, long j3, long j16, long j17, QuotaUpdater quotaUpdater);

    void onGeolocationPermissionsHidePrompt();

    void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback);

    void onGeolocationStartUpdating(ValueCallback<Location> valueCallback, ValueCallback<Bundle> valueCallback2);

    void onGeolocationStopUpdating();

    void onHideCustomView();

    boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult);

    boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult);

    boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult);

    boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult);

    boolean onJsTimeout();

    void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i3);

    void onReachedMaxAppCacheSize(long j3, long j16, QuotaUpdater quotaUpdater);

    void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap);

    void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str);

    void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z16);

    void onRequestFocus(IX5WebViewBase iX5WebViewBase);

    void onShowCustomView(View view, int i3, CustomViewCallback customViewCallback);

    void onShowCustomView(View view, CustomViewCallback customViewCallback);

    boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams);

    void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z16);
}
