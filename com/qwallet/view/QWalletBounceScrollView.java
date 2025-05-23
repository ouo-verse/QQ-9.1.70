package com.qwallet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.widget.PagingScrollView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletBounceScrollView extends PagingScrollView {

    /* renamed from: d, reason: collision with root package name */
    public boolean f41792d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f41793e;

    /* renamed from: f, reason: collision with root package name */
    public int f41794f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f41795h;

    /* renamed from: i, reason: collision with root package name */
    private TouchWebView f41796i;

    /* renamed from: m, reason: collision with root package name */
    private int f41797m;

    public QWalletBounceScrollView(Context context) {
        super(context);
        this.f41794f = Integer.MAX_VALUE;
        this.f41795h = true;
        this.f41797m = 0;
        setFillViewport(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f41792d || this.f41793e) {
            return true;
        }
        if (motionEvent.getAction() == 1) {
            getScrollY();
            int i3 = -this.f41794f;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.widget.PagingScrollView, com.tencent.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchWebView touchWebView = this.f41796i;
        if (touchWebView != null && touchWebView.getVisibility() == 0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.PagingScrollView, com.tencent.widget.ScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        if (i16 == 0) {
            this.f41795h = true;
        }
        if (this.f41795h && i16 < -200) {
            com.tencent.mobileqq.qwallet.c.e("index.layila.200pixel", "", "", "", "");
            this.f41795h = false;
        }
    }

    public void setHeight(int i3) {
        this.f41797m = i3;
    }

    public void setTouchWebView(TouchWebView touchWebView) {
        this.f41796i = touchWebView;
    }

    public void setWebViewHelper(com.tencent.biz.ui.e eVar) {
        throw null;
    }

    public QWalletBounceScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41794f = Integer.MAX_VALUE;
        this.f41795h = true;
        this.f41797m = 0;
        setFillViewport(true);
    }
}
