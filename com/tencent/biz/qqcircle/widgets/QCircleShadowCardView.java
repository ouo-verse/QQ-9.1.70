package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleShadowCardView extends FrameLayout {
    private static final int G = 2131105112;
    private static final int H = 2131105839;
    private int C;
    private int D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private int f93144d;

    /* renamed from: e, reason: collision with root package name */
    private int f93145e;

    /* renamed from: f, reason: collision with root package name */
    private int f93146f;

    /* renamed from: h, reason: collision with root package name */
    private int f93147h;

    /* renamed from: i, reason: collision with root package name */
    private int f93148i;

    /* renamed from: m, reason: collision with root package name */
    private int f93149m;

    public QCircleShadowCardView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        try {
            int color = getResources().getColor(H);
            int color2 = getResources().getColor(G);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449818sb);
            this.f93144d = obtainStyledAttributes.getDimensionPixelSize(y91.a.Bb, 0);
            this.f93145e = obtainStyledAttributes.getResourceId(y91.a.f449894yb, color2);
            this.f93146f = obtainStyledAttributes.getResourceId(y91.a.f449856vb, color);
            this.C = obtainStyledAttributes.getDimensionPixelSize(y91.a.Cb, 5);
            this.E = obtainStyledAttributes.getDimensionPixelSize(y91.a.Ab, 5);
            this.D = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449907zb, 5);
            this.F = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449844ub, 5);
            this.f93148i = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449881xb, 0);
            this.f93149m = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449868wb, 0);
            this.f93147h = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449831tb, 10);
            obtainStyledAttributes.recycle();
        } catch (Exception unused) {
            QLog.e("QCircleShadowCardView", 1, "init ShadowCardView catch exception");
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
        paint.setColor(QCircleSkinHelper.getInstance().getColor(this.f93146f));
        paint.setShadowLayer(this.f93147h, this.f93149m, this.f93148i, QCircleSkinHelper.getInstance().getColor(this.f93145e));
        RectF rectF = new RectF(paddingLeft, paddingTop, width, height);
        int i3 = this.f93144d;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public QCircleShadowCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleShadowCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet);
    }
}
