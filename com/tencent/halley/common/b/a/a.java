package com.tencent.halley.common.b.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a implements com.tencent.halley.common.a.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f113285a;

    /* renamed from: b, reason: collision with root package name */
    public String f113286b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f113287c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f113288d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f113289e;

    /* renamed from: f, reason: collision with root package name */
    public int f113290f;

    /* renamed from: g, reason: collision with root package name */
    public int f113291g;

    /* renamed from: h, reason: collision with root package name */
    public String f113292h;

    /* renamed from: i, reason: collision with root package name */
    public String f113293i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f113294j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f113295k;

    /* renamed from: l, reason: collision with root package name */
    public long f113296l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f113297m;

    /* renamed from: n, reason: collision with root package name */
    public AtomicInteger f113298n;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113287c = false;
        this.f113294j = false;
        this.f113295k = false;
        this.f113297m = false;
        this.f113298n = new AtomicInteger(0);
    }
}
