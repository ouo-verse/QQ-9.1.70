package com.tencent.guild.aio.input.at.quickAt.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    public static int f111023i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static int f111024j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static int f111025k = 3;

    /* renamed from: l, reason: collision with root package name */
    public static final int f111026l;

    /* renamed from: m, reason: collision with root package name */
    public static final ColorFilter f111027m;

    /* renamed from: a, reason: collision with root package name */
    Paint f111028a;

    /* renamed from: b, reason: collision with root package name */
    boolean f111029b = true;

    /* renamed from: c, reason: collision with root package name */
    RectF f111030c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    private int f111031d = f111023i;

    /* renamed from: e, reason: collision with root package name */
    private int f111032e = Color.parseColor("#4d000000");

    /* renamed from: f, reason: collision with root package name */
    private ColorFilter f111033f = new PorterDuffColorFilter(this.f111032e, PorterDuff.Mode.SRC_ATOP);

    /* renamed from: g, reason: collision with root package name */
    boolean f111034g = false;

    /* renamed from: h, reason: collision with root package name */
    int f111035h;

    /* compiled from: P */
    /* renamed from: com.tencent.guild.aio.input.at.quickAt.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1191a {
        int getHeight();

        int getWidth();

        void superOnDraw(Canvas canvas);
    }

    static {
        int parseColor = Color.parseColor("#1E000000");
        f111026l = parseColor;
        f111027m = new PorterDuffColorFilter(parseColor, PorterDuff.Mode.SRC_ATOP);
    }

    public a() {
        Paint paint = new Paint();
        this.f111028a = paint;
        paint.setAntiAlias(true);
        this.f111028a.setColorFilter(this.f111033f);
        this.f111035h = this.f111028a.getColor();
    }

    public static boolean a() {
        return false;
    }

    public static boolean b() {
        return false;
    }

    public void c(Canvas canvas, InterfaceC1191a interfaceC1191a) {
        if (canvas != null && interfaceC1191a != null) {
            if (this.f111029b && a()) {
                this.f111030c.set(0.0f, 0.0f, interfaceC1191a.getWidth(), interfaceC1191a.getHeight());
                int i3 = this.f111031d;
                if (b()) {
                    i3 = f111025k;
                }
                if (i3 == f111023i) {
                    interfaceC1191a.superOnDraw(canvas);
                    this.f111028a.setColorFilter(null);
                    this.f111028a.setColor(this.f111032e);
                    RectF rectF = this.f111030c;
                    canvas.drawRoundRect(rectF, rectF.centerX(), this.f111030c.centerY(), this.f111028a);
                    return;
                }
                if (i3 == f111024j) {
                    interfaceC1191a.superOnDraw(canvas);
                    this.f111028a.setColorFilter(null);
                    this.f111028a.setColor(this.f111032e);
                    canvas.drawRect(this.f111030c, this.f111028a);
                    return;
                }
                if (this.f111028a.getColorFilter() == null) {
                    this.f111028a.setColorFilter(this.f111033f);
                }
                this.f111028a.setColor(this.f111035h);
                canvas.saveLayer(null, this.f111028a, 31);
                interfaceC1191a.superOnDraw(canvas);
                canvas.restore();
                return;
            }
            interfaceC1191a.superOnDraw(canvas);
        }
    }

    public void d(int i3) {
        this.f111031d = i3;
    }

    public void e(boolean z16) {
        this.f111029b = z16;
    }

    public void f() {
        this.f111032e = f111026l;
        this.f111033f = f111027m;
        Paint paint = new Paint();
        this.f111028a = paint;
        paint.setAntiAlias(true);
        this.f111028a.setColorFilter(this.f111033f);
        this.f111035h = this.f111028a.getColor();
    }
}
