package com.tencent.luggage.wxa.s8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.tencent.luggage.wxa.s8.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public g f140148a;

    /* renamed from: b, reason: collision with root package name */
    public e f140149b;

    /* renamed from: c, reason: collision with root package name */
    public Canvas f140150c;

    /* renamed from: d, reason: collision with root package name */
    public j f140151d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f140152e;

    /* renamed from: f, reason: collision with root package name */
    public char[] f140153f = new char[1];

    /* renamed from: g, reason: collision with root package name */
    public Rect f140154g = new Rect();

    /* renamed from: h, reason: collision with root package name */
    public Rect f140155h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    public List f140156i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public Paint.FontMetrics f140157j = new Paint.FontMetrics();

    public h(e eVar, g gVar) {
        a(eVar, gVar);
    }

    public void a(c cVar) {
    }

    public final void b() {
        Paint paint = new Paint(1);
        this.f140152e = paint;
        paint.setTextAlign(Paint.Align.LEFT);
        this.f140152e.setColor(-1);
    }

    public final boolean c() {
        j jVar = this.f140151d;
        if (jVar == null) {
            return false;
        }
        return jVar.f140169f.b();
    }

    public final boolean d() {
        j jVar = this.f140151d;
        if (jVar == null) {
            return false;
        }
        return jVar.f140169f.c();
    }

    public final boolean e() {
        j jVar = this.f140151d;
        if (jVar == null) {
            return false;
        }
        return jVar.f140167d;
    }

    public final void a(e eVar, g gVar) {
        this.f140149b = eVar;
        this.f140150c = new Canvas(this.f140149b.c());
        this.f140148a = gVar;
        b();
    }

    public void a(j jVar) {
        this.f140151d = jVar;
        this.f140152e.setTypeface(jVar.f140164a);
        this.f140152e.setTextSize(jVar.f140166c);
        if (jVar.f140167d) {
            this.f140152e.setStyle(Paint.Style.STROKE);
            this.f140152e.setStrokeWidth(jVar.f140168e);
        } else {
            this.f140152e.setStyle(Paint.Style.FILL);
        }
        this.f140152e.setTextSkewX(0.0f);
        this.f140152e.setFakeBoldText(false);
        if (jVar.f140169f != null) {
            Typeface typeface = jVar.f140164a;
            if (typeface == null || typeface.getStyle() != jVar.f140169f.f140175a) {
                j.a aVar = jVar.f140169f;
                if (aVar == j.a.ITALIC || aVar == j.a.BOLD_ITALIC) {
                    this.f140152e.setTextSkewX(-0.25f);
                }
                j.a aVar2 = jVar.f140169f;
                if (aVar2 == j.a.BOLD || aVar2 == j.a.BOLD_ITALIC) {
                    this.f140152e.setFakeBoldText(true);
                }
            }
            if (jVar.f140169f.b()) {
                this.f140152e.setFakeBoldText(true);
            }
        }
        this.f140152e.getFontMetrics(this.f140157j);
    }

    public void f() {
    }

    public k a(char c16, int i3) {
        k a16 = this.f140148a.f140142c.a();
        a16.a(false);
        Paint.FontMetrics fontMetrics = this.f140157j;
        a(a16, (int) Math.ceil(a(c16)), (int) Math.ceil(fontMetrics.bottom - fontMetrics.ascent));
        if (!this.f140149b.a((int) Math.ceil(a16.f140179c), (int) Math.ceil(a16.f140180d), this.f140154g)) {
            return null;
        }
        a(a16, this.f140154g);
        a(c16, this.f140154g, a16, this.f140152e);
        return a16;
    }

    public final float a(char c16) {
        char[] cArr = this.f140153f;
        cArr[0] = c16;
        this.f140152e.getTextBounds(cArr, 0, 1, this.f140154g);
        return Math.max(this.f140154g.width(), this.f140152e.measureText(this.f140153f, 0, 1)) + 1.0f;
    }

    public final void a(k kVar, int i3, int i16) {
        if (kVar == null) {
            return;
        }
        float f16 = i3;
        kVar.f140177a = f16;
        kVar.f140178b = 0.0f;
        kVar.a(f16, i16);
        if (d()) {
            float ceil = (float) Math.ceil(f16 * 0.5f);
            kVar.f140178b -= ceil / 2.0f;
            kVar.f140179c += ceil;
        }
        if (e()) {
            float f17 = kVar.f140178b;
            float f18 = this.f140151d.f140168e;
            kVar.f140178b = f17 - (f18 / 2.0f);
            kVar.f140179c += f18;
        }
        if (c()) {
            kVar.f140178b -= 1.0f;
            kVar.f140179c += 2.0f;
        }
    }

    public final void a(k kVar, Rect rect) {
        kVar.a(rect.left / this.f140149b.f(), rect.top / this.f140149b.d(), rect.right / this.f140149b.f(), rect.bottom / this.f140149b.d());
    }

    public final void a(char c16, Rect rect, k kVar, Paint paint) {
        if (paint == null || kVar == null || rect == null) {
            return;
        }
        this.f140153f[0] = c16;
        this.f140150c.save();
        this.f140150c.clipRect(rect);
        this.f140150c.drawText(this.f140153f, 0, 1, rect.left - kVar.f140178b, ((rect.top + kVar.f140180d) - this.f140157j.bottom) - 1.0f, paint);
        this.f140150c.restore();
    }

    public k a(Drawable drawable, int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            k a16 = this.f140148a.f140142c.a();
            float f16 = i3;
            a16.f140177a = f16;
            a16.f140178b = 0.0f;
            this.f140149b.a(i3, i16, this.f140154g);
            Rect rect = this.f140154g;
            if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
                return null;
            }
            a16.a(f16, i16);
            a16.a(rect.left / this.f140149b.f(), rect.top / this.f140149b.d(), rect.right / this.f140149b.f(), rect.bottom / this.f140149b.d());
            a16.a(true);
            this.f140150c.save();
            this.f140150c.clipRect(rect);
            drawable.setBounds(rect);
            drawable.draw(this.f140150c);
            this.f140150c.restore();
            return a16;
        }
        throw new IllegalArgumentException("width or height unexpected");
    }

    public float a(List list) {
        float f16 = 0.0f;
        if (list != null && list.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar != null) {
                    f16 += kVar.f140177a;
                }
            }
        }
        return f16;
    }

    public float a(String str) {
        Paint.FontMetrics fontMetrics = this.f140157j;
        if (fontMetrics == null) {
            return 0.0f;
        }
        return (fontMetrics.bottom - fontMetrics.ascent) + 1.0f;
    }

    public Paint.FontMetrics a() {
        return this.f140157j;
    }
}
