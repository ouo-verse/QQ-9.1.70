package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ShadowCardView extends FrameLayout {
    private static final int G = 2131105112;
    private static final int H = 2131105839;
    private int C;
    private int D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private int f96397d;

    /* renamed from: e, reason: collision with root package name */
    private int f96398e;

    /* renamed from: f, reason: collision with root package name */
    private int f96399f;

    /* renamed from: h, reason: collision with root package name */
    private int f96400h;

    /* renamed from: i, reason: collision with root package name */
    private int f96401i;

    /* renamed from: m, reason: collision with root package name */
    private int f96402m;

    public ShadowCardView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        try {
            int color = getResources().getColor(H);
            int color2 = getResources().getColor(G);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.shadowCardView);
            this.f96397d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowRound, 0);
            this.f96398e = obtainStyledAttributes.getColor(R.styleable.shadowCardView_shadowHeightColor, color2);
            this.f96399f = obtainStyledAttributes.getColor(R.styleable.shadowCardView_shadowCardColor, color);
            this.C = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowTopHeight, 5);
            this.E = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowRightHeight, 5);
            this.D = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowLeftHeight, 5);
            this.F = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowBottomHeight, 5);
            this.f96401i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowCardOffsetY, 0);
            this.f96402m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowCardOffsetX, 0);
            this.f96400h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.shadowCardView_shadowBlur, 10);
            obtainStyledAttributes.recycle();
        } catch (Exception unused) {
            c.g("ShadowCardView", "init ShadowCardView catch exception");
        }
        setPadding(this.D, this.C, this.E, this.F);
        setWillNotDraw(false);
        setLayerType(1, null);
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
        paint.setColor(this.f96399f);
        paint.setShadowLayer(this.f96400h, this.f96402m, this.f96401i, this.f96398e);
        RectF rectF = new RectF(paddingLeft, paddingTop, width, height);
        int i3 = this.f96397d;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setShadowBlur(int i3) {
        this.f96400h = i3;
    }

    public void setShadowCardColor(int i3) {
        this.f96399f = i3;
    }

    public void setShadowColor(int i3) {
        this.f96398e = i3;
    }

    public ShadowCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet);
    }
}
