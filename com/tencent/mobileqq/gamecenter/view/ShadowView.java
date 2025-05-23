package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ShadowView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f213474d;

    /* renamed from: e, reason: collision with root package name */
    private int f213475e;

    public ShadowView(Context context) {
        super(context);
        this.f213474d = new Paint(1);
        this.f213475e = -1;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(1, null);
        this.f213474d.setColor(this.f213475e);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f213474d);
    }

    public void setOriginColor(int i3) {
        this.f213475e = i3;
    }

    public void setShadowProperties(float f16, float f17, float f18, int i3) {
        this.f213474d.setShadowLayer(f16, f17, f18, i3);
    }

    public ShadowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f213474d = new Paint(1);
        this.f213475e = -1;
    }

    public ShadowView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f213474d = new Paint(1);
        this.f213475e = -1;
    }
}
