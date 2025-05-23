package com.tencent.qqlive.module.videoreport.inject.webview.dtwebview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v1.BridgeInterface;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v2.JsBridgeInterfaceV2;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DtWebView extends WebView {
    private boolean mIsJsInterfaceInject;
    private boolean mIsJsInterfaceV2Inject;

    public DtWebView(Context context) {
        super(context);
        this.mIsJsInterfaceInject = false;
        this.mIsJsInterfaceV2Inject = false;
    }

    private void onLoad() {
        if (!JsBinderHelper.allowInjectOnLoad()) {
            return;
        }
        if (!this.mIsJsInterfaceInject) {
            this.mIsJsInterfaceInject = true;
            addJavascriptInterface(new BridgeInterface(this), BridgeInterface.JS_OBJECT_NAME);
        }
        if (!this.mIsJsInterfaceV2Inject) {
            this.mIsJsInterfaceV2Inject = true;
            addJavascriptInterface(new JsBridgeInterfaceV2(this), JsBridgeInterfaceV2.JS_OBJECT_NAME);
        }
    }

    @Override // android.webkit.WebView
    public void loadData(String str, @Nullable String str2, @Nullable String str3) {
        super.loadData(str, str2, str3);
        onLoad();
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(@Nullable String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        onLoad();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
        onLoad();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
        onLoad();
    }

    public DtWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsJsInterfaceInject = false;
        this.mIsJsInterfaceV2Inject = false;
    }

    public DtWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsJsInterfaceInject = false;
        this.mIsJsInterfaceV2Inject = false;
    }

    public DtWebView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mIsJsInterfaceInject = false;
        this.mIsJsInterfaceV2Inject = false;
    }

    public DtWebView(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        this.mIsJsInterfaceInject = false;
        this.mIsJsInterfaceV2Inject = false;
    }
}
