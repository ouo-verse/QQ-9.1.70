package com.tencent.mobileqq.troop.troopgag.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f300232a;

    /* renamed from: b, reason: collision with root package name */
    public long f300233b;

    public c(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3));
        } else {
            this.f300232a = z16;
            this.f300233b = j3;
        }
    }
}
