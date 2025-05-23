package com.tencent.mobileqq.activity.recent.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.d;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f185676a;

    /* renamed from: b, reason: collision with root package name */
    public long f185677b;

    /* renamed from: c, reason: collision with root package name */
    public int f185678c;

    /* renamed from: d, reason: collision with root package name */
    public d f185679d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f185676a = -1L;
        this.f185677b = -1L;
        this.f185678c = -35072;
        this.f185679d = new d();
    }
}
