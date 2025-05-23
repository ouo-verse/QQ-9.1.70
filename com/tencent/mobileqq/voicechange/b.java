package com.tencent.mobileqq.voicechange;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f313138a;

    /* renamed from: b, reason: collision with root package name */
    int f313139b;

    /* renamed from: c, reason: collision with root package name */
    int f313140c;

    /* renamed from: d, reason: collision with root package name */
    int f313141d;

    /* renamed from: e, reason: collision with root package name */
    int f313142e;

    /* renamed from: f, reason: collision with root package name */
    public int f313143f;

    /* renamed from: g, reason: collision with root package name */
    public int f313144g;

    public b(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f313139b = 2;
        this.f313141d = 2;
        this.f313138a = str;
        this.f313140c = i3;
        this.f313142e = i16;
        this.f313143f = i17;
        this.f313144g = i18;
    }
}
