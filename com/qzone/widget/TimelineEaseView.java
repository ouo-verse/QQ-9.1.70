package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.util.ar;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;

/* compiled from: P */
/* loaded from: classes37.dex */
public class TimelineEaseView extends View {
    private float C;
    private long D;
    private long E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    private String f60681d;

    /* renamed from: e, reason: collision with root package name */
    private String f60682e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f60683f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f60684h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f60685i;

    /* renamed from: m, reason: collision with root package name */
    private float f60686m;

    public TimelineEaseView(Context context) {
        super(context);
        this.f60681d = null;
        this.f60682e = null;
        this.f60683f = false;
        this.f60684h = new Paint();
        this.f60685i = new Paint();
        this.f60686m = ar.m(18.0f);
        this.C = ar.e(44.0f);
        this.D = 0L;
        this.E = 100L;
        this.F = 0L;
        b(context);
    }

    private void b(Context context) {
        this.f60685i.setColor(com.tencent.mobileqq.simpleui.b.c() ? SimpleUIUtil.getSimpleUiTextColor() : -1);
        this.f60685i.setTextSize(this.f60686m);
        this.f60684h.setColor(com.tencent.mobileqq.simpleui.b.c() ? SimpleUIUtil.getSimpleUiTextColor() : -1);
        this.f60684h.setTextSize(this.f60686m);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f60681d)) {
            return;
        }
        int q16 = ar.q(this.f60686m, this.f60681d);
        int o16 = ar.o(this.f60686m, this.f60681d);
        int width = (getWidth() - q16) / 2;
        if (this.f60683f) {
            long j3 = this.F + 1;
            this.F = j3;
            float f16 = o16 / 2;
            float a16 = (float) a((float) j3, 0.0f, (this.C / 2.0f) + f16, (float) this.E);
            float f17 = this.C;
            int i3 = (int) ((255.0f * a16) / ((f17 / 2.0f) + f16));
            if (a16 < (f17 / 2.0f) + f16) {
                this.f60685i.setAlpha(i3);
                float f18 = width;
                float f19 = o16;
                canvas.drawText(this.f60681d, f18, (this.C + f19) - a16, this.f60685i);
                if (!TextUtils.isEmpty(this.f60682e)) {
                    this.f60684h.setAlpha(255 - i3);
                    canvas.drawText(this.f60682e, f18, (((this.C / 2.0f) + f19) - f16) - a16, this.f60684h);
                }
                invalidate();
                return;
            }
            this.f60683f = false;
            this.f60685i.setAlpha(255);
            this.f60684h.setAlpha(255);
            canvas.drawText(this.f60681d, width, ((this.C / 2.0f) + o16) - f16, this.f60685i);
            return;
        }
        this.f60685i.setAlpha(255);
        this.f60684h.setAlpha(255);
        if (TextUtils.isEmpty(this.f60681d)) {
            return;
        }
        canvas.drawText(this.f60681d, width, ((this.C / 2.0f) + o16) - (o16 / 2), this.f60685i);
    }

    public void setCurrentText(String str, long j3) {
        if (TextUtils.equals(this.f60681d, str)) {
            return;
        }
        if (TextUtils.isEmpty(this.f60681d)) {
            this.f60681d = str;
            this.f60683f = false;
        } else {
            this.f60682e = this.f60681d;
            this.f60681d = str;
            this.f60683f = true;
        }
        this.D = j3;
        this.F = 0L;
        invalidate();
    }

    public TimelineEaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60681d = null;
        this.f60682e = null;
        this.f60683f = false;
        this.f60684h = new Paint();
        this.f60685i = new Paint();
        this.f60686m = ar.m(18.0f);
        this.C = ar.e(44.0f);
        this.D = 0L;
        this.E = 100L;
        this.F = 0L;
        b(context);
    }

    public TimelineEaseView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60681d = null;
        this.f60682e = null;
        this.f60683f = false;
        this.f60684h = new Paint();
        this.f60685i = new Paint();
        this.f60686m = ar.m(18.0f);
        this.C = ar.e(44.0f);
        this.D = 0L;
        this.E = 100L;
        this.F = 0L;
        b(context);
    }

    private double a(float f16, float f17, float f18, float f19) {
        if (f16 == 0.0f) {
            return f17;
        }
        if (f16 / f19 == 1.0f) {
            return f17 + f18;
        }
        double d16 = f18;
        return (Math.pow(2.0d, (-10.0f) * r9) * d16 * Math.sin((((r9 * f19) - (r0 / 4.0f)) * 6.283185307179586d) / (0.3f * f19))) + d16 + f17;
    }
}
