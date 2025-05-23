package com.tencent.mobileqq.miniapp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends com.tencent.biz.qqstory.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public d f246787e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f246788f;

    /* renamed from: h, reason: collision with root package name */
    public int f246789h;

    /* renamed from: i, reason: collision with root package name */
    public String f246790i;

    /* renamed from: m, reason: collision with root package name */
    public Object[] f246791m;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.qqstory.base.a
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MiniAppEvent {, isSuccess=" + this.f246788f + ", type=" + this.f246789h + ", src=" + this.f246790i + " }";
    }
}
