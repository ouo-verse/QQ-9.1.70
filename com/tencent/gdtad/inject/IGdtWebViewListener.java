package com.tencent.gdtad.inject;

import android.graphics.Bitmap;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class IGdtWebViewListener {
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onProgressChanged(WebView webView, int i3) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onReceivedError(WebView webView, int i3, String str, String str2) {
    }
}
