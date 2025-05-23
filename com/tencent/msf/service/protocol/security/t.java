package com.tencent.msf.service.protocol.security;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class t implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static t[] f336733c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final int f336734d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final t f336735e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f336736f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final t f336737g;

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f336738h;

    /* renamed from: a, reason: collision with root package name */
    private int f336739a;

    /* renamed from: b, reason: collision with root package name */
    private String f336740b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f336738h = true;
        f336733c = new t[2];
        f336735e = new t(0, 0, "VPIC_TYPE_URL");
        f336737g = new t(1, 1, "VPIC_TYPE_BIN");
    }

    t(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        new String();
        this.f336740b = str;
        this.f336739a = i16;
        f336733c[i3] = this;
    }

    public static t a(int i3) {
        int i16 = 0;
        while (true) {
            t[] tVarArr = f336733c;
            if (i16 < tVarArr.length) {
                if (tVarArr[i16].a() == i3) {
                    return f336733c[i16];
                }
                i16++;
            } else {
                if (f336738h) {
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
        return this.f336740b;
    }

    public static t a(String str) {
        int i3 = 0;
        while (true) {
            t[] tVarArr = f336733c;
            if (i3 < tVarArr.length) {
                if (tVarArr[i3].toString().equals(str)) {
                    return f336733c[i3];
                }
                i3++;
            } else {
                if (f336738h) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f336739a : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
