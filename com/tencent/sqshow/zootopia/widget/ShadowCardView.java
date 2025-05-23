package com.tencent.sqshow.zootopia.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import hd0.c;
import jj2.b;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ShadowCardView extends FrameLayout {
    private static final int G = 2131105112;
    private static final int H = 2131105839;
    private int C;
    private int D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private int f373395d;

    /* renamed from: e, reason: collision with root package name */
    private int f373396e;

    /* renamed from: f, reason: collision with root package name */
    private int f373397f;

    /* renamed from: h, reason: collision with root package name */
    private int f373398h;

    /* renamed from: i, reason: collision with root package name */
    private int f373399i;

    /* renamed from: m, reason: collision with root package name */
    private int f373400m;

    public ShadowCardView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(this.f373397f);
        paint.setShadowLayer(this.f373398h, this.f373400m, this.f373399i, this.f373396e);
        RectF rectF = new RectF(paddingLeft, paddingTop, width, height);
        int i3 = this.f373395d;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setShadowBlur(int i3) {
        this.f373398h = i3;
    }

    public void setShadowCardColor(int i3) {
        this.f373397f = i3;
    }

    public void setShadowColor(int i3) {
        this.f373396e = i3;
    }

    public ShadowCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        try {
            int color = getResources().getColor(H);
            int color2 = getResources().getColor(G);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f410017ca);
            this.f373395d = obtainStyledAttributes.getDimensionPixelSize(b.f410121la, 0);
            this.f373396e = obtainStyledAttributes.getColor(b.f410088ia, color2);
            this.f373397f = obtainStyledAttributes.getColor(b.f410053fa, color);
            this.C = obtainStyledAttributes.getDimensionPixelSize(b.f410132ma, 5);
            this.E = obtainStyledAttributes.getDimensionPixelSize(b.f410110ka, 5);
            this.D = obtainStyledAttributes.getDimensionPixelSize(b.f410099ja, 5);
            this.F = obtainStyledAttributes.getDimensionPixelSize(b.f410041ea, 5);
            this.f373399i = obtainStyledAttributes.getDimensionPixelSize(b.f410077ha, 0);
            this.f373400m = obtainStyledAttributes.getDimensionPixelSize(b.f410065ga, 0);
            this.f373398h = obtainStyledAttributes.getDimensionPixelSize(b.f410029da, 10);
            obtainStyledAttributes.recycle();
        } catch (Exception unused) {
            c.g("ShadowCardView", "init ShadowCardView catch exception");
        }
        setPadding(this.D, this.C, this.E, this.F);
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    public ShadowCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet);
    }
}
