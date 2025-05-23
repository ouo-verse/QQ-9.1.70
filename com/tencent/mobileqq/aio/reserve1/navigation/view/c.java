package com.tencent.mobileqq.aio.reserve1.navigation.view;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.reserve1.navigation.AIONavCorrelation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rlottie.AXrLottieDrawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    AIONavCorrelation f193362a;

    /* renamed from: b, reason: collision with root package name */
    Object f193363b;

    /* renamed from: c, reason: collision with root package name */
    int f193364c;

    /* renamed from: d, reason: collision with root package name */
    int f193365d;

    /* renamed from: e, reason: collision with root package name */
    int f193366e;

    /* renamed from: f, reason: collision with root package name */
    int f193367f;

    /* renamed from: g, reason: collision with root package name */
    int f193368g;

    /* renamed from: h, reason: collision with root package name */
    String f193369h;

    /* renamed from: i, reason: collision with root package name */
    int f193370i;

    /* renamed from: j, reason: collision with root package name */
    int f193371j;

    /* renamed from: k, reason: collision with root package name */
    int f193372k;

    /* renamed from: l, reason: collision with root package name */
    int f193373l;

    /* renamed from: m, reason: collision with root package name */
    int f193374m;

    /* renamed from: n, reason: collision with root package name */
    Path f193375n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f193376o;

    /* renamed from: p, reason: collision with root package name */
    Rect f193377p;

    /* renamed from: q, reason: collision with root package name */
    RectF f193378q;

    /* renamed from: r, reason: collision with root package name */
    AXrLottieDrawable f193379r;

    /* renamed from: s, reason: collision with root package name */
    Rect f193380s;

    /* renamed from: t, reason: collision with root package name */
    RectF f193381t;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f193377p = new Rect();
        this.f193378q = new RectF();
        this.f193380s = new Rect();
        this.f193381t = new RectF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        this.f193362a = cVar.f193362a;
        this.f193364c = cVar.f193364c;
        this.f193365d = cVar.f193365d;
        this.f193366e = cVar.f193366e;
        this.f193367f = cVar.f193367f;
        this.f193368g = cVar.f193368g;
        this.f193369h = cVar.f193369h;
        this.f193373l = cVar.f193373l;
        this.f193374m = cVar.f193374m;
        this.f193363b = cVar.f193363b;
        this.f193372k = cVar.f193372k;
        this.f193376o = cVar.f193376o;
        this.f193375n = new Path(cVar.f193375n);
        this.f193377p = new Rect(cVar.f193377p);
        this.f193378q = new RectF(cVar.f193378q);
        this.f193380s = new Rect(cVar.f193380s);
        this.f193381t = new RectF(cVar.f193381t);
    }
}
