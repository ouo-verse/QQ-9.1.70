package com.tencent.mobileqq.troop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f293499a;

    /* renamed from: b, reason: collision with root package name */
    public String f293500b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f293501c;

    /* renamed from: d, reason: collision with root package name */
    public int f293502d;

    /* renamed from: e, reason: collision with root package name */
    public int f293503e;

    /* renamed from: f, reason: collision with root package name */
    public int f293504f;

    /* renamed from: g, reason: collision with root package name */
    public long f293505g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
