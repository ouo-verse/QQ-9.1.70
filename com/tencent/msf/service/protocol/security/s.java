package com.tencent.msf.service.protocol.security;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class s implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static s[] f336723c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final int f336724d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final s f336725e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f336726f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final s f336727g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f336728h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static final s f336729i;

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f336730j;

    /* renamed from: a, reason: collision with root package name */
    private int f336731a;

    /* renamed from: b, reason: collision with root package name */
    private String f336732b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15101);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f336730j = true;
        f336723c = new s[3];
        f336725e = new s(0, 0, "VPIC_FORMAT_JPG");
        f336727g = new s(1, 1, "VPIC_FORMAT_PNG");
        f336729i = new s(2, 2, "VPIC_FORMAT_BMP");
    }

    s(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        new String();
        this.f336732b = str;
        this.f336731a = i16;
        f336723c[i3] = this;
    }

    public static s a(int i3) {
        int i16 = 0;
        while (true) {
            s[] sVarArr = f336723c;
            if (i16 < sVarArr.length) {
                if (sVarArr[i16].a() == i3) {
                    return f336723c[i16];
                }
                i16++;
            } else {
                if (f336730j) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f336732b;
    }

    public static s a(String str) {
        int i3 = 0;
        while (true) {
            s[] sVarArr = f336723c;
            if (i3 < sVarArr.length) {
                if (sVarArr[i3].toString().equals(str)) {
                    return f336723c[i3];
                }
                i3++;
            } else {
                if (f336730j) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f336731a : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
