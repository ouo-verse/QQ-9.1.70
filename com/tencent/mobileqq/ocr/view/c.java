package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap f254948h;

    /* renamed from: i, reason: collision with root package name */
    public String f254949i;

    /* renamed from: j, reason: collision with root package name */
    public int f254950j;

    /* renamed from: k, reason: collision with root package name */
    public int f254951k;

    /* renamed from: l, reason: collision with root package name */
    public float f254952l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f254953m;

    /* renamed from: n, reason: collision with root package name */
    public int f254954n;

    /* renamed from: o, reason: collision with root package name */
    public int f254955o;

    /* renamed from: p, reason: collision with root package name */
    public int f254956p;

    /* renamed from: q, reason: collision with root package name */
    public Rect f254957q;

    /* renamed from: r, reason: collision with root package name */
    public int f254958r;

    /* renamed from: s, reason: collision with root package name */
    public int f254959s;

    /* renamed from: t, reason: collision with root package name */
    public int f254960t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f254961u;

    /* renamed from: v, reason: collision with root package name */
    public int f254962v;

    /* renamed from: w, reason: collision with root package name */
    public int f254963w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f254964x;

    /* renamed from: y, reason: collision with root package name */
    public float f254965y;

    public c(com.tencent.mobileqq.gallery.picocr.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f254952l = -1.0f;
        this.f254954n = -1;
        this.f254955o = -1;
        this.f254956p = -1;
        this.f254958r = -1;
        this.f254959s = -1;
        this.f254960t = -1;
        this.f254961u = false;
        this.f254962v = -1;
        this.f254963w = -1;
        this.f254964x = false;
        this.f254965y = -1.0f;
        this.f254949i = bVar.f211807a;
        this.f254957q = new Rect();
        this.f254927c = bVar.b();
        this.f254954n = bVar.f211810d;
        this.f254956p = 0;
        this.f254960t = bVar.f211808b;
        this.f254925a.clear();
        if (!bVar.f211809c.isEmpty()) {
            this.f254925a.addAll(bVar.f211809c);
        }
        this.f254961u = this.f254925a.get(0).x > this.f254925a.get(1).x;
    }

    public Point a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Point) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f254925a.get(0);
    }

    public void b(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17));
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
}
