package com.tencent.msf.service.protocol.serverconfig;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static b[] f336749c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final int f336750d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final b f336751e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f336752f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final b f336753g;

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f336754h;

    /* renamed from: a, reason: collision with root package name */
    private int f336755a;

    /* renamed from: b, reason: collision with root package name */
    private String f336756b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14204);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f336754h = true;
        f336749c = new b[2];
        f336751e = new b(0, 1, "CliLogCfgByTime");
        f336753g = new b(1, 2, "CliLogCfgSetLevel");
    }

    b(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        new String();
        this.f336756b = str;
        this.f336755a = i16;
        f336749c[i3] = this;
    }

    public static b a(int i3) {
        int i16 = 0;
        while (true) {
            b[] bVarArr = f336749c;
            if (i16 < bVarArr.length) {
                if (bVarArr[i16].a() == i3) {
                    return f336749c[i16];
                }
                i16++;
            } else {
                if (f336754h) {
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
        return this.f336756b;
    }

    public static b a(String str) {
        int i3 = 0;
        while (true) {
            b[] bVarArr = f336749c;
            if (i3 < bVarArr.length) {
                if (bVarArr[i3].toString().equals(str)) {
                    return f336749c[i3];
                }
                i3++;
            } else {
                if (f336754h) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f336755a : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
