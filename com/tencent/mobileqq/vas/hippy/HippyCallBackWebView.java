package com.tencent.mobileqq.vas.hippy;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyCallBackWebView extends CustomWebView implements com.tencent.comic.api.a {
    private final n13.b C;
    private com.tencent.share.a D;

    public HippyCallBackWebView(Context context) {
        super(context);
        this.C = n13.b.f();
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView
    public void callJs(String str, String... strArr) {
        this.C.e().onCallJs(strArr);
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView
    public void callJs4OpenApi(JsBridgeListener jsBridgeListener, int i3, String... strArr) {
        this.C.e().onCallJs(strArr);
    }

    @Override // com.tencent.comic.api.a
    public Object getShareHelper() {
        com.tencent.share.a aVar = this.D;
        if (aVar != null) {
            return aVar;
        }
        com.tencent.share.a aVar2 = (com.tencent.share.a) this.C.e().onGetShareHelper();
        this.D = aVar2;
        return aVar2;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public String getUrl() {
        return this.C.e().onGetWebViewUrl();
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView
    public void callJs(String str) {
        this.C.e().onCallJs(str);
    }

    public HippyCallBackWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = n13.b.f();
    }

    public HippyCallBackWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = n13.b.f();
    }
}
