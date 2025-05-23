package com.tencent.mobileqq.troop.memberlevel.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f297775a;

    /* renamed from: b, reason: collision with root package name */
    public String f297776b;

    /* renamed from: c, reason: collision with root package name */
    public String f297777c;

    /* renamed from: d, reason: collision with root package name */
    public String f297778d;

    /* renamed from: e, reason: collision with root package name */
    public String f297779e;

    /* renamed from: f, reason: collision with root package name */
    public String f297780f;

    /* renamed from: g, reason: collision with root package name */
    public String f297781g;

    public a(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, str4, str5, str6);
            return;
        }
        this.f297775a = i3;
        this.f297776b = str;
        this.f297777c = str2;
        this.f297779e = str3;
        this.f297780f = str4;
        this.f297778d = str5;
        this.f297781g = str6;
    }
}
