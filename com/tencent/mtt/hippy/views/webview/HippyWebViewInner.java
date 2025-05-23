package com.tencent.mtt.hippy.views.webview;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import com.tencent.qimei.webview.QmWebview;

/* compiled from: P */
/* loaded from: classes20.dex */
class HippyWebViewInner extends QmWebview {
    public HippyWebViewInner(Context context) {
        super(context);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setAllowFileAccess(true);
        settings.setGeolocationEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(false);
        settings.setSupportMultipleWindows(false);
        settings.setAppCachePath(context.getDir("hwebview_appcache", 0).getPath());
        settings.setDatabasePath(context.getDir("hwebview_databases", 0).getPath());
        settings.setGeolocationDatabasePath(context.getDir("hwebview_geolocation", 0).getPath());
        settings.setLoadsImagesAutomatically(true);
        settings.setAllowContentAccess(false);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 26) {
            settings.setSafeBrowsingEnabled(true);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }
}
