package com.tencent.mobileqq.leba.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f240477a;

    /* renamed from: b, reason: collision with root package name */
    public int f240478b;

    /* renamed from: c, reason: collision with root package name */
    public int f240479c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f240480d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f240481e;

    /* renamed from: f, reason: collision with root package name */
    public int f240482f;

    /* renamed from: g, reason: collision with root package name */
    public int f240483g;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240479c = 0;
        this.f240482f = 0;
        this.f240483g = 0;
    }
}
