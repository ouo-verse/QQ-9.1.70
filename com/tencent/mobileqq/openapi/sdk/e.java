package com.tencent.mobileqq.openapi.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f256969a;

    /* renamed from: b, reason: collision with root package name */
    public long f256970b;

    /* renamed from: c, reason: collision with root package name */
    public String f256971c;

    public e(int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), str);
            return;
        }
        this.f256969a = i3;
        this.f256970b = j3;
        this.f256971c = str;
    }
}
