package com.tencent.luggage.wxa.ok;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public Paint f136611a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f136612b;

    /* renamed from: c, reason: collision with root package name */
    public int f136613c;

    /* renamed from: d, reason: collision with root package name */
    public int f136614d;

    /* renamed from: e, reason: collision with root package name */
    public int f136615e;

    /* renamed from: f, reason: collision with root package name */
    public int f136616f;

    /* renamed from: g, reason: collision with root package name */
    public int f136617g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f136618h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f136619i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f136620a = 1;

        /* renamed from: b, reason: collision with root package name */
        public int f136621b = 12;

        /* renamed from: c, reason: collision with root package name */
        public int f136622c = Color.parseColor("#4d000000");

        /* renamed from: d, reason: collision with root package name */
        public int f136623d = 18;

        /* renamed from: e, reason: collision with root package name */
        public int f136624e;

        /* renamed from: f, reason: collision with root package name */
        public int f136625f;

        /* renamed from: g, reason: collision with root package name */
        public int[] f136626g;

        public b() {
            this.f136624e = 0;
            this.f136625f = 0;
            this.f136624e = 0;
            this.f136625f = 0;
            this.f136626g = r1;
            int[] iArr = {0};
        }

        public b a(int i3) {
            this.f136624e = i3;
            return this;
        }

        public b b(int i3) {
            this.f136625f = i3;
            return this;
        }

        public b c(int i3) {
            this.f136622c = i3;
            return this;
        }

        public b d(int i3) {
            this.f136623d = i3;
            return this;
        }

        public b e(int i3) {
            this.f136621b = i3;
            return this;
        }

        public p a() {
            return new p(this.f136620a, this.f136626g, this.f136621b, this.f136622c, this.f136623d, this.f136624e, this.f136625f);
        }
    }

    public static void a(View view, Drawable drawable) {
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int[] iArr = this.f136618h;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f136612b.setColor(iArr[0]);
            } else {
                Paint paint = this.f136612b;
                RectF rectF = this.f136619i;
                float f16 = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.f136619i;
                paint.setShader(new LinearGradient(f16, height, rectF2.right, rectF2.height() / 2.0f, this.f136618h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f136614d == 1) {
            RectF rectF3 = this.f136619i;
            float f17 = this.f136615e;
            canvas.drawRoundRect(rectF3, f17, f17, this.f136611a);
            RectF rectF4 = this.f136619i;
            float f18 = this.f136615e;
            canvas.drawRoundRect(rectF4, f18, f18, this.f136612b);
            return;
        }
        canvas.drawCircle(this.f136619i.centerX(), this.f136619i.centerY(), Math.min(this.f136619i.width(), this.f136619i.height()) / 2.0f, this.f136611a);
        canvas.drawCircle(this.f136619i.centerX(), this.f136619i.centerY(), Math.min(this.f136619i.width(), this.f136619i.height()) / 2.0f, this.f136612b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f136611a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
        int i19 = this.f136613c;
        int i26 = this.f136616f;
        int i27 = this.f136617g;
        this.f136619i = new RectF((i3 + i19) - i26, (i16 + i19) - i27, (i17 - i19) - i26, (i18 - i19) - i27);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f136611a.setColorFilter(colorFilter);
    }

    public p(int i3, int[] iArr, int i16, int i17, int i18, int i19, int i26) {
        this.f136614d = i3;
        this.f136618h = iArr;
        this.f136615e = i16;
        this.f136613c = i18;
        this.f136616f = i19;
        this.f136617g = i26;
        Paint paint = new Paint();
        this.f136611a = paint;
        paint.setColor(0);
        this.f136611a.setAntiAlias(true);
        this.f136611a.setShadowLayer(i18, i19, i26, i17);
        this.f136611a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f136612b = paint2;
        paint2.setAntiAlias(true);
    }
}
