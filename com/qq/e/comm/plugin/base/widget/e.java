package com.qq.e.comm.plugin.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f39319a;

    /* renamed from: b, reason: collision with root package name */
    private int f39320b;

    /* renamed from: c, reason: collision with root package name */
    private int f39321c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39322d;

    /* renamed from: e, reason: collision with root package name */
    private int f39323e;

    /* renamed from: f, reason: collision with root package name */
    private int f39324f;

    /* renamed from: g, reason: collision with root package name */
    private int f39325g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f39326h;

    /* renamed from: i, reason: collision with root package name */
    private Path f39327i;

    /* renamed from: j, reason: collision with root package name */
    private float[] f39328j;

    /* renamed from: k, reason: collision with root package name */
    private RectF f39329k;

    public e(Context context) {
        super(context);
        this.f39321c = 100;
        this.f39322d = false;
        this.f39323e = Color.parseColor("#3185FC");
        this.f39324f = Color.parseColor("#3185FC");
        this.f39325g = Color.parseColor("#d8d8d8");
        this.f39327i = new Path();
        this.f39328j = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        setLayerType(1, null);
        a();
    }

    private void a() {
        this.f39319a = new Paint();
        this.f39326h = new Paint();
        this.f39329k = new RectF();
    }

    public void b(int i3) {
        this.f39321c = i3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f39329k.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f39327i.addRoundRect(this.f39329k, this.f39328j, Path.Direction.CW);
        canvas.clipPath(this.f39327i);
        super.onDraw(canvas);
        if (this.f39320b >= 0) {
            int measuredWidth = getMeasuredWidth();
            float measuredHeight = getMeasuredHeight();
            float f16 = measuredHeight / 2.0f;
            int i3 = this.f39320b;
            float f17 = measuredWidth;
            float f18 = (i3 / this.f39321c) * f17;
            if (this.f39322d) {
                if (i3 > 0 && i3 < 100) {
                    this.f39326h.setColor(this.f39325g);
                    a(canvas, 0.0f, 0.0f, f17, measuredHeight, this.f39326h);
                    this.f39319a.setShader(new LinearGradient(0.0f, f16, f18, f16, this.f39323e, this.f39324f, Shader.TileMode.CLAMP));
                    this.f39319a.setStyle(Paint.Style.FILL);
                    a(canvas, 0.0f, 0.0f, f18, measuredHeight, this.f39319a);
                } else {
                    this.f39326h.setColor(this.f39324f);
                    this.f39319a.setStyle(Paint.Style.FILL);
                    a(canvas, 0.0f, 0.0f, f17, measuredHeight, this.f39326h);
                }
            } else {
                this.f39326h.setColor(Color.parseColor("#40000000"));
                a(canvas, 0.0f, 0.0f, f17, measuredHeight, this.f39326h);
                this.f39319a.setColor(Color.parseColor("#BFFFFFFF"));
                a(canvas, 0.0f, 0.0f, f18, measuredHeight, this.f39319a);
            }
        }
        this.f39327i.reset();
    }

    private void a(Canvas canvas, float f16, float f17, float f18, float f19, Paint paint) {
        this.f39329k.set(f16, f17, f18, f19);
        canvas.drawRect(this.f39329k, paint);
    }

    public void a(int i3) {
        if (i3 <= 0) {
            this.f39320b = 0;
        } else if (i3 >= 100) {
            this.f39320b = 100;
        } else {
            this.f39320b = i3;
        }
        postInvalidate();
    }
}
