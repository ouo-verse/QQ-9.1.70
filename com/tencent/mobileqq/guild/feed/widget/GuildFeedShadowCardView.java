package com.tencent.mobileqq.guild.feed.widget;

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
/* loaded from: classes13.dex */
public class GuildFeedShadowCardView extends FrameLayout {
    private static final int H = 2131105112;
    private static final int I = 2131105839;
    private int C;
    private int D;
    private int E;
    private int F;
    private Paint G;

    /* renamed from: d, reason: collision with root package name */
    private int f224199d;

    /* renamed from: e, reason: collision with root package name */
    private int f224200e;

    /* renamed from: f, reason: collision with root package name */
    private int f224201f;

    /* renamed from: h, reason: collision with root package name */
    private int f224202h;

    /* renamed from: i, reason: collision with root package name */
    private int f224203i;

    /* renamed from: m, reason: collision with root package name */
    private int f224204m;

    public GuildFeedShadowCardView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(QCircleSkinHelper.getInstance().getColor(getContext(), this.f224201f));
        paint.setShadowLayer(this.f224202h, this.f224204m, this.f224203i, QCircleSkinHelper.getInstance().getColor(getContext(), this.f224200e));
        this.G = paint;
    }

    private void b(Context context, AttributeSet attributeSet) {
        try {
            int color = getResources().getColor(I);
            int color2 = getResources().getColor(H);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410017ca);
            this.f224199d = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410121la, 0);
            this.f224200e = obtainStyledAttributes.getResourceId(jj2.b.f410088ia, color2);
            this.f224201f = obtainStyledAttributes.getResourceId(jj2.b.f410053fa, color);
            this.C = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410132ma, 5);
            this.E = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410110ka, 5);
            this.D = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410099ja, 5);
            this.F = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410041ea, 5);
            this.f224203i = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410077ha, 0);
            this.f224204m = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410065ga, 0);
            this.f224202h = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410029da, 10);
            obtainStyledAttributes.recycle();
        } catch (Exception unused) {
            QLog.e("GuildFeedShadowCardView", 1, "init ShadowCardView catch exception");
        }
        setPadding(this.D, this.C, this.E, this.F);
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        int i3 = this.f224199d;
        canvas.drawRoundRect(rectF, i3, i3, this.G);
        super.onDraw(canvas);
    }

    public GuildFeedShadowCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedShadowCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context, attributeSet);
        a();
    }
}
