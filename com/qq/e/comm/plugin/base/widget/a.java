package com.qq.e.comm.plugin.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f39298a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f39299b;

    /* renamed from: c, reason: collision with root package name */
    private int f39300c;

    /* renamed from: d, reason: collision with root package name */
    private int f39301d;

    /* renamed from: e, reason: collision with root package name */
    private int f39302e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f39303f;

    public a(Context context) {
        super(context);
        this.f39301d = ak.a(getContext().getApplicationContext(), 4);
        this.f39302e = 100;
        try {
            setLayerType(1, null);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f39298a = paint;
        paint.setAntiAlias(true);
        this.f39298a.setColor(Color.parseColor("#C3C4C5"));
        this.f39298a.setStyle(Paint.Style.STROKE);
        this.f39298a.setStrokeWidth(this.f39301d);
        Paint paint2 = new Paint();
        this.f39299b = paint2;
        paint2.setAntiAlias(true);
        this.f39299b.setStyle(Paint.Style.STROKE);
        this.f39299b.setColor(-1);
        this.f39299b.setStrokeWidth(this.f39301d);
        this.f39303f = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, r2 - this.f39301d, this.f39298a);
        int i3 = this.f39300c;
        if (i3 > 0) {
            RectF rectF = this.f39303f;
            int i16 = this.f39301d;
            rectF.left = i16;
            rectF.top = i16;
            rectF.right = r0 - i16;
            rectF.bottom = r0 - i16;
            canvas.drawArc(rectF, -90.0f, (i3 / this.f39302e) * 360.0f, false, this.f39299b);
        }
    }

    public void a(int i3) {
        if (i3 <= 0) {
            this.f39300c = 0;
        } else if (i3 >= 100) {
            this.f39300c = 100;
        } else {
            this.f39300c = i3;
        }
        postInvalidate();
    }
}
