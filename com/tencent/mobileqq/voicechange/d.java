package com.tencent.mobileqq.voicechange;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    boolean f313156a;

    /* renamed from: b, reason: collision with root package name */
    boolean f313157b;

    /* renamed from: c, reason: collision with root package name */
    boolean f313158c;

    /* renamed from: d, reason: collision with root package name */
    boolean f313159d;

    /* renamed from: e, reason: collision with root package name */
    boolean f313160e;

    /* renamed from: f, reason: collision with root package name */
    String f313161f;

    public d(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), str);
            return;
        }
        this.f313156a = z16;
        this.f313157b = z17;
        this.f313158c = z18;
        this.f313159d = z19;
        this.f313160e = z26;
        this.f313161f = str;
    }

    public static d a() {
        return new d(true, false, true, true, true, null);
    }

    public static d b(String str) {
        return new d(false, true, true, false, true, str);
    }
}
