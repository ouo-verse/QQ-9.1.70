package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CommonLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f315556d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315557e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onFirstDraw();
    }

    public CommonLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315557e = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f315557e) {
            this.f315557e = false;
            a aVar = this.f315556d;
            if (aVar != null) {
                aVar.onFirstDraw();
            }
        }
    }

    public void setOnFirstDrawListener(a aVar) {
        this.f315556d = aVar;
    }

    public CommonLoadingView(Context context) {
        super(context);
        this.f315557e = true;
    }

    public CommonLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315557e = true;
    }
}
