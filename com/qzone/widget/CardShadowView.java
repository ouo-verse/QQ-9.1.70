package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.util.ar;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CardShadowView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f60191d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f60192e;

    /* renamed from: f, reason: collision with root package name */
    private int f60193f;

    /* renamed from: h, reason: collision with root package name */
    private int f60194h;

    /* renamed from: i, reason: collision with root package name */
    private int f60195i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f60196m;

    public CardShadowView(Context context) {
        super(context);
        b(null, 0, 0);
    }

    private void b(AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.R, i3, i16);
        this.f60193f = obtainStyledAttributes.getDimensionPixelSize(1, ar.d(8.0f));
        this.f60194h = obtainStyledAttributes.getDimensionPixelSize(2, ar.d(8.0f));
        this.f60195i = obtainStyledAttributes.getColor(0, 335544320);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f60191d = paint;
        paint.setStrokeWidth(1.0f);
        this.f60191d.setStyle(Paint.Style.STROKE);
        this.f60191d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        Paint paint2 = new Paint();
        this.f60192e = paint2;
        paint2.setStrokeWidth(1.0f);
        this.f60192e.setStyle(Paint.Style.STROKE);
        this.f60192e.setAntiAlias(true);
        this.f60192e.setColor(-1052689);
        int i17 = this.f60194h;
        this.f60196m = new RectF(i17, i17, i17, i17);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas, this.f60196m, this.f60193f, this.f60195i, this.f60194h);
        RectF rectF = this.f60196m;
        int i3 = this.f60193f;
        canvas.drawRoundRect(rectF, i3, i3, this.f60192e);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f60196m.right = getWidth() - this.f60194h;
        this.f60196m.bottom = getHeight() - this.f60194h;
    }

    public CardShadowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet, 0, 0);
    }

    private void a(Canvas canvas, RectF rectF, int i3, int i16, int i17) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        RectF rectF2 = new RectF();
        for (int i18 = i17 - 1; i18 > -1; i18--) {
            float f16 = i18;
            this.f60191d.setColor(com.qzone.widget.util.a.a(c(f16 / i17), i16, com.qzone.widget.util.a.b(i16)));
            float f17 = 0.6f * f16;
            rectF2.left = (rectF.left - 1.0f) - f17;
            rectF2.top = (rectF.top - 1.0f) - (0.1f * f16);
            rectF2.right = rectF.right + 1.0f + f17;
            rectF2.bottom = rectF.bottom + 1.0f + f16;
            float f18 = i3;
            canvas.drawRoundRect(rectF2, f18, f18, this.f60191d);
        }
        canvas.restoreToCount(saveLayer);
    }

    public CardShadowView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(attributeSet, i3, 0);
    }

    private float c(float f16) {
        return f16;
    }
}
