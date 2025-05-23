package com.qwallet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseNestScrollWebView extends TouchWebView {
    private a C;
    public int D;
    public boolean E;

    public BaseNestScrollWebView(Context context) {
        super(context);
        this.E = true;
    }

    private int q(Context context, float f16) {
        float density;
        try {
            if (GlobalDisplayMetricsManager.sOriginDisplayMetrics != null) {
                density = GlobalDisplayMetricsManager.sOriginDisplayMetrics.density;
            } else {
                density = FontSettingManager.systemMetrics.density;
            }
        } catch (Throwable unused) {
            density = ScreenUtil.getDensity();
        }
        return ((int) ((f16 / density) + 0.5f)) - 1;
    }

    public boolean handleBack() {
        if (canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (!str.startsWith("http://")) {
            str.startsWith("https://");
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        if (i3 == 4) {
            z16 = handleBack();
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        super.super_onScrollChanged(i3, i16, i17, i18);
        a aVar = this.C;
        if (aVar != null && !aVar.isPined()) {
            this.C.onScrollTo(i3, i16, i17, i18);
        }
        this.D = i16;
    }

    public void setLoadingView(b bVar) {
        if (bVar != null) {
            boolean z16 = this.E;
        }
        this.E = false;
    }

    public void setPaddingTop(int i3) {
        loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + ("if (document.body && document.body.style) {document.body.style.paddingTop='" + q(getContext(), i3) + "px';} void 0"));
    }

    public BaseNestScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = true;
    }
}
