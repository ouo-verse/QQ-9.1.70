package com.tencent.mobileqq.app.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f195676a;

    /* renamed from: b, reason: collision with root package name */
    public long f195677b;

    /* renamed from: c, reason: collision with root package name */
    public String f195678c;

    /* renamed from: d, reason: collision with root package name */
    public String f195679d;

    /* renamed from: e, reason: collision with root package name */
    public String f195680e;

    /* renamed from: f, reason: collision with root package name */
    public int f195681f;

    /* renamed from: g, reason: collision with root package name */
    public int f195682g;

    /* renamed from: h, reason: collision with root package name */
    public long f195683h;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
