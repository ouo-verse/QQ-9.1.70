package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VConsoleView extends LinearLayout {
    public ImageView vConsoleGap;
    public WebView vConsoleWebView;

    public VConsoleView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.f168287sc, this);
        this.vConsoleGap = (ImageView) findViewById(R.id.ewz);
        WebView webView = (WebView) findViewById(R.id.ewv);
        this.vConsoleWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.vConsoleWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.vConsoleWebView.removeJavascriptInterface("accessibility");
        this.vConsoleWebView.removeJavascriptInterface("accessibilityTraversal");
    }

    public VConsoleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public VConsoleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initUI();
    }
}
