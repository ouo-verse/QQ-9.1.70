package com.tencent.luggage.wxa.ug;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements d {

    /* renamed from: m, reason: collision with root package name */
    public static int f142366m;

    /* renamed from: n, reason: collision with root package name */
    public static int f142367n;

    /* renamed from: a, reason: collision with root package name */
    public Context f142368a;

    /* renamed from: b, reason: collision with root package name */
    public SpannableString f142369b;

    /* renamed from: c, reason: collision with root package name */
    public int f142370c;

    /* renamed from: d, reason: collision with root package name */
    public int f142371d;

    /* renamed from: e, reason: collision with root package name */
    public StaticLayout f142372e;

    /* renamed from: f, reason: collision with root package name */
    public int f142373f;

    /* renamed from: g, reason: collision with root package name */
    public int f142374g;

    /* renamed from: i, reason: collision with root package name */
    public int f142376i;

    /* renamed from: j, reason: collision with root package name */
    public int f142377j;

    /* renamed from: l, reason: collision with root package name */
    public float f142379l;

    /* renamed from: h, reason: collision with root package name */
    public int f142375h = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f142378k = -1;

    public a(Context context, SpannableString spannableString, int i3, int i16, float f16, int i17) {
        this.f142368a = context;
        this.f142369b = spannableString;
        d(i16);
        c(i3);
        this.f142379l = f16;
        this.f142377j = i17;
        e();
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public void a(Canvas canvas, boolean z16) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (width != f142366m || height != f142367n) {
            f142366m = width;
            f142367n = height;
        }
        canvas.save();
        canvas.translate(this.f142370c, this.f142371d);
        this.f142372e.draw(canvas);
        canvas.restore();
        if (z16) {
            return;
        }
        this.f142370c = (int) (this.f142370c - (b.a() * this.f142379l));
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public int b() {
        return this.f142377j;
    }

    public final void c(int i3) {
        this.f142378k = i3;
    }

    public final void d(int i3) {
        if (i3 > 0) {
            this.f142376i = b.a(this.f142368a, i3);
        } else {
            this.f142376i = b.a(this.f142368a, b.f142380a);
        }
    }

    public final void e() {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.f142378k);
        textPaint.setTextSize(this.f142376i);
        this.f142374g = a(textPaint);
        SpannableString spannableString = this.f142369b;
        StaticLayout staticLayout = new StaticLayout(spannableString, textPaint, ((int) Layout.getDesiredWidth(spannableString, 0, spannableString.length(), textPaint)) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f142372e = staticLayout;
        this.f142373f = staticLayout.getWidth();
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public int getWidth() {
        return this.f142373f;
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public boolean b(int i3) {
        return i3 - this.f142377j > b.f142381b;
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public boolean c() {
        int i3 = this.f142370c;
        return i3 < 0 && Math.abs(i3) > this.f142373f;
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public int d() {
        return this.f142370c;
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public void a(int i3, int i16) {
        this.f142370c = i3;
        this.f142371d = i16;
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public float a() {
        return this.f142379l;
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public boolean a(int i3) {
        int i16 = this.f142377j;
        return i3 >= i16 && i3 - i16 <= b.f142381b;
    }

    @Override // com.tencent.luggage.wxa.ug.d
    public boolean a(d dVar) {
        if (dVar.getWidth() + dVar.d() > f142366m) {
            return true;
        }
        if (this.f142375h < 0) {
            this.f142375h = b.a(this.f142368a, 20);
        }
        return dVar.a() >= this.f142379l ? dVar.a() == this.f142379l && ((float) (f142366m - (dVar.d() + dVar.getWidth()))) < ((float) this.f142375h) : ((double) (((((float) (dVar.d() + dVar.getWidth())) / (dVar.a() * ((float) b.a()))) * this.f142379l) * ((float) b.a()))) > ((double) f142366m) - (((double) this.f142375h) * 1.5d);
    }

    public static int a(TextPaint textPaint) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
    }
}
