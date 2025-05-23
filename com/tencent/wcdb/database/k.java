package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f384427a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f384428b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f384429c;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
