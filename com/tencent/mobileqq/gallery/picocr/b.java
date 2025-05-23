package com.tencent.mobileqq.gallery.picocr;

import android.graphics.Point;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f211807a;

    /* renamed from: b, reason: collision with root package name */
    public int f211808b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Point> f211809c;

    /* renamed from: d, reason: collision with root package name */
    public int f211810d;

    /* renamed from: e, reason: collision with root package name */
    public int f211811e;

    /* renamed from: f, reason: collision with root package name */
    public int f211812f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f211813g;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211810d = -1;
            this.f211813g = false;
        }
    }

    public Point a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Point) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f211809c.get(3);
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ArrayList<Point> arrayList = this.f211809c;
        if (arrayList == null || arrayList.size() < 2) {
            return 0;
        }
        Point point = this.f211809c.get(0);
        Point point2 = this.f211809c.get(1);
        int i3 = point2.x - point.x;
        float asin = (float) ((Math.asin((point2.y - point.y) / Math.sqrt((i3 * i3) + (r3 * r3))) / 3.141592653589793d) * 180.0d);
        if (point2.x < point.x) {
            if (asin > 0.0f) {
                asin = 180.0f - asin;
            } else {
                asin = -(asin + 180.0f);
            }
        }
        return Math.round(asin);
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        ArrayList<Point> arrayList = this.f211809c;
        if (arrayList == null || arrayList.size() < 4) {
            return 0;
        }
        return ((IOCR) QRoute.api(IOCR.class)).takeDistance(this.f211809c.get(0), this.f211809c.get(3));
    }

    public Point d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Point) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f211809c.get(0);
    }

    public int e(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16))).intValue();
        }
        return (int) Math.ceil(c() * f16);
    }

    public int f(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16))).intValue();
        }
        return (int) Math.ceil(g() * f16);
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        ArrayList<Point> arrayList = this.f211809c;
        if (arrayList == null || arrayList.size() < 4) {
            return 0;
        }
        return ((IOCR) QRoute.api(IOCR.class)).takeDistance(this.f211809c.get(0), this.f211809c.get(1));
    }

    public void h(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        if (!this.f211813g) {
            for (int i3 = 0; i3 < this.f211809c.size(); i3++) {
                this.f211809c.get(i3).x = (int) (this.f211809c.get(i3).x * f16);
                this.f211809c.get(i3).y = (int) (this.f211809c.get(i3).y * f16);
            }
            this.f211813g = true;
        }
    }
}
