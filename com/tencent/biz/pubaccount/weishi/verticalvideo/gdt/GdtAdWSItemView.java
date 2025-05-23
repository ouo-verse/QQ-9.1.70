package com.tencent.biz.pubaccount.weishi.verticalvideo.gdt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GdtAdWSItemView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f82049d;

    /* renamed from: e, reason: collision with root package name */
    private float f82050e;

    public GdtAdWSItemView(Context context) {
        super(context);
        this.f82049d = Float.NEGATIVE_INFINITY;
        this.f82050e = Float.NEGATIVE_INFINITY;
    }

    public float a() {
        return this.f82050e;
    }

    public GdtAdWSItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82049d = Float.NEGATIVE_INFINITY;
        this.f82050e = Float.NEGATIVE_INFINITY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            this.f82049d = motionEvent.getX();
            this.f82050e = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
