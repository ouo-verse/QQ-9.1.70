package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public String f254932h;

    /* renamed from: i, reason: collision with root package name */
    public String f254933i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f254934j;

    /* renamed from: k, reason: collision with root package name */
    public float f254935k;

    /* renamed from: l, reason: collision with root package name */
    public float f254936l;

    /* renamed from: m, reason: collision with root package name */
    public float f254937m;

    /* renamed from: n, reason: collision with root package name */
    public int f254938n;

    /* renamed from: o, reason: collision with root package name */
    public int f254939o;

    /* renamed from: p, reason: collision with root package name */
    public int f254940p;

    /* renamed from: q, reason: collision with root package name */
    public int f254941q;

    /* renamed from: r, reason: collision with root package name */
    public int f254942r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f254943s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f254944t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f254945u;

    /* renamed from: v, reason: collision with root package name */
    public Point f254946v;

    /* renamed from: w, reason: collision with root package name */
    public Bitmap f254947w;

    public b(com.tencent.mobileqq.gallery.picocr.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f254939o = -1;
        this.f254940p = -1;
        this.f254941q = 10;
        this.f254942r = 0;
        this.f254943s = false;
        this.f254944t = false;
        this.f254945u = false;
        this.f254933i = bVar.f211807a;
        this.f254927c = bVar.b();
        this.f254938n = bVar.f211810d;
        this.f254934j = new Rect();
        this.f254925a.clear();
        Iterator<Point> it = bVar.f211809c.iterator();
        while (it.hasNext()) {
            this.f254925a.add(new Point(it.next()));
        }
        if (this.f254925a.get(0).x > this.f254925a.get(1).x) {
            this.f254943s = true;
        }
        this.f254935k = 0.0f;
        this.f254940p = -16777216;
    }

    private void c(com.tencent.mobileqq.gallery.picocr.b bVar) {
        f(3, bVar.f211809c.get(3));
        f(2, com.tencent.mobileqq.ocr.e.h(this.f254925a.get(1), this.f254925a.get(2), bVar.f211809c.get(2), bVar.f211809c.get(3)));
        f(0, com.tencent.mobileqq.ocr.e.h(bVar.f211809c.get(3), bVar.f211809c.get(0), this.f254925a.get(1), this.f254925a.get(0)));
    }

    private void f(int i3, Point point) {
        if (point != null) {
            this.f254925a.get(i3).set(point.x, point.y);
        }
    }

    public void a(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textPaint);
            return;
        }
        if (!TextUtils.isEmpty(this.f254933i) && !TextUtils.isEmpty(this.f254932h) && !d() && this.f254936l > 0.0f) {
            float sqrt = (float) (this.f254936l * Math.sqrt(textPaint.measureText(this.f254933i) / textPaint.measureText(this.f254932h)));
            this.f254935k = sqrt;
            if (sqrt > 30.0f) {
                this.f254935k = 30.0f;
            }
            if (this.f254935k < 5.0f) {
                this.f254935k = 5.0f;
            }
        }
    }

    public void b(com.tencent.mobileqq.gallery.picocr.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        if (bVar != null && this.f254938n == bVar.f211810d) {
            ArrayList<Point> arrayList = bVar.f211809c;
            if (arrayList != null && arrayList.size() == 4) {
                c(bVar);
            }
            if (!TextUtils.isEmpty(bVar.f211807a)) {
                this.f254933i += bVar.f211807a;
            }
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Rect g16 = g();
        int width = g16.width() - (this.f254942r * 2);
        int height = g16.height() - (this.f254941q * 2);
        if (width >= 10 && height >= 10) {
            return false;
        }
        return true;
    }

    public void e(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        for (int i3 = 0; i3 < this.f254925a.size(); i3++) {
            Point point = this.f254925a.get(i3);
            Point point2 = new Point((int) (point.x * f16), (int) (point.y * f17));
            this.f254928d = Math.max(this.f254928d, point2.x);
            this.f254929e = Math.max(this.f254929e, point2.y);
            this.f254930f = Math.min(this.f254930f, point2.x);
            this.f254931g = Math.min(this.f254931g, point2.y);
            if (point2.x < 0) {
                point2.x = 0;
            }
            if (point2.y < 0) {
                point2.y = 0;
            }
            this.f254925a.set(i3, point2);
        }
    }

    public Rect g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Rect) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Point point = this.f254925a.get(0);
        Point point2 = this.f254925a.get(1);
        Point point3 = this.f254925a.get(2);
        Point point4 = this.f254925a.get(3);
        this.f254934j.set(0, 0, Math.max(com.tencent.mobileqq.ocr.d.s(point, point2), com.tencent.mobileqq.ocr.d.s(point4, point3)), Math.max(com.tencent.mobileqq.ocr.d.s(point, point4), com.tencent.mobileqq.ocr.d.s(point2, point3)));
        return this.f254934j;
    }

    public Point h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Point) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Point point = this.f254925a.get(0);
        this.f254946v = point;
        return point;
    }
}
