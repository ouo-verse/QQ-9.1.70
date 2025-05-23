package com.tencent.mobileqq.troop.memberlevel.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f297788a;

    /* renamed from: b, reason: collision with root package name */
    public int f297789b;

    /* renamed from: c, reason: collision with root package name */
    public int f297790c;

    /* renamed from: d, reason: collision with root package name */
    public String f297791d;

    public c(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        this.f297788a = i3;
        this.f297789b = i16;
        this.f297790c = i17;
        this.f297791d = str;
    }
}
