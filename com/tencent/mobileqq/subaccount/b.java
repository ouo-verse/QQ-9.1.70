package com.tencent.mobileqq.subaccount;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f291092a;

    /* renamed from: b, reason: collision with root package name */
    public String f291093b;

    /* renamed from: c, reason: collision with root package name */
    public String f291094c;

    /* renamed from: d, reason: collision with root package name */
    public int f291095d;

    /* renamed from: e, reason: collision with root package name */
    public String f291096e;

    /* renamed from: f, reason: collision with root package name */
    public int f291097f;

    /* renamed from: g, reason: collision with root package name */
    public int f291098g;

    /* renamed from: h, reason: collision with root package name */
    public String f291099h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f291100i;

    /* renamed from: j, reason: collision with root package name */
    public int f291101j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f291102k;

    /* renamed from: l, reason: collision with root package name */
    public Object f291103l;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f291100i = true;
        this.f291102k = false;
        this.f291092a = 0;
        this.f291095d = 0;
        this.f291097f = 0;
        this.f291101j = 0;
    }
}
