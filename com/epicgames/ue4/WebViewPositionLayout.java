package com.epicgames.ue4;

import android.content.Context;
import android.view.ViewGroup;
import com.epicgames.ue4.WebViewControl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class WebViewPositionLayout extends ViewGroup {
    private WebViewControl webViewControl;

    public WebViewPositionLayout(Context context, WebViewControl webViewControl) {
        super(context);
        this.webViewControl = webViewControl;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        WebViewControl webViewControl = this.webViewControl;
        WebViewControl.GLWebView gLWebView = webViewControl.webView;
        int i19 = webViewControl.curX;
        int i26 = webViewControl.curY;
        gLWebView.layout(i19, i26, webViewControl.curW + i19, webViewControl.curH + i26);
    }
}
