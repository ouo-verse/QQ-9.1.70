package com.tencent.mobileqq.qqconnectface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f262371a;

    /* renamed from: b, reason: collision with root package name */
    public String f262372b;

    /* renamed from: c, reason: collision with root package name */
    public int f262373c;

    /* renamed from: d, reason: collision with root package name */
    public String f262374d;

    /* renamed from: e, reason: collision with root package name */
    public String f262375e;

    /* renamed from: f, reason: collision with root package name */
    public String f262376f;

    /* renamed from: g, reason: collision with root package name */
    public int f262377g;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
