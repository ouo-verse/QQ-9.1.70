package com.tencent.mobileqq.leba.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f240486a;

    /* renamed from: b, reason: collision with root package name */
    public String f240487b;

    /* renamed from: c, reason: collision with root package name */
    public n f240488c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f240489d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f240490e;

    /* renamed from: f, reason: collision with root package name */
    public int f240491f;

    /* renamed from: g, reason: collision with root package name */
    public int f240492g;

    /* renamed from: h, reason: collision with root package name */
    public String f240493h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f240494i;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
