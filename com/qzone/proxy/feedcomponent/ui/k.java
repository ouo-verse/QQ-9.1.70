package com.qzone.proxy.feedcomponent.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k {

    /* renamed from: p, reason: collision with root package name */
    static final Object f50849p = new Object();

    /* renamed from: q, reason: collision with root package name */
    static k f50850q;

    /* renamed from: r, reason: collision with root package name */
    static int f50851r;

    /* renamed from: a, reason: collision with root package name */
    public long f50852a;

    /* renamed from: b, reason: collision with root package name */
    public long f50853b;

    /* renamed from: c, reason: collision with root package name */
    public long f50854c;

    /* renamed from: d, reason: collision with root package name */
    public Point f50855d;

    /* renamed from: e, reason: collision with root package name */
    public int f50856e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f50857f;

    /* renamed from: g, reason: collision with root package name */
    public long f50858g;

    /* renamed from: h, reason: collision with root package name */
    public float f50859h;

    /* renamed from: i, reason: collision with root package name */
    public double f50860i;

    /* renamed from: j, reason: collision with root package name */
    public float f50861j;

    /* renamed from: k, reason: collision with root package name */
    public int f50862k;

    /* renamed from: l, reason: collision with root package name */
    public int f50863l;

    /* renamed from: m, reason: collision with root package name */
    public int f50864m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f50865n;

    /* renamed from: o, reason: collision with root package name */
    k f50866o;

    public static void a(k kVar) {
        if (f50851r > 60) {
            return;
        }
        kVar.f50865n = null;
        kVar.f50866o = null;
        synchronized (f50849p) {
            k kVar2 = f50850q;
            if (kVar2 == null) {
                f50850q = kVar;
            } else {
                kVar.f50866o = kVar2;
                f50850q = kVar;
            }
            f50851r++;
        }
    }

    public static void c(String str) {
        com.qzone.proxy.feedcomponent.b.e("Particle", str);
    }

    public static k d() {
        c(e());
        synchronized (f50849p) {
            k kVar = f50850q;
            if (kVar != null) {
                f50850q = kVar.f50866o;
                kVar.f50866o = null;
                kVar.f50865n = null;
                f50851r--;
                c("recycled value:" + kVar.hashCode());
                return kVar;
            }
            k kVar2 = new k();
            c("new value:" + kVar2.hashCode());
            return kVar2;
        }
    }

    public static String e() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("=>");
        if (f50850q == null) {
            sb5.append("null");
        }
        for (k kVar = f50850q; kVar != null; kVar = kVar.f50866o) {
            sb5.append("->");
            sb5.append(kVar.hashCode());
        }
        return sb5.toString();
    }

    public Bitmap b() {
        Drawable drawable = this.f50865n;
        if (drawable instanceof BitmapRefDrawable) {
            return ((BitmapRefDrawable) drawable).getBitmap();
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public String toString() {
        return "Particle{startTime=" + this.f50852a + ", duration=" + this.f50853b + ", endTime=" + this.f50854c + ", currentTime=" + this.f50858g + ", currentProgress=" + this.f50859h + ", rotate=" + this.f50860i + ", scale=" + this.f50861j + ", alpha=" + this.f50862k + ", point=" + this.f50855d + ", centerX=" + this.f50863l + ", centerY=" + this.f50864m + ", drawable=" + this.f50865n + ", customPraisetype=" + this.f50856e + '}';
    }
}
