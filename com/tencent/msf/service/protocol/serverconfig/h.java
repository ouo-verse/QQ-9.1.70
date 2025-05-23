package com.tencent.msf.service.protocol.serverconfig;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class h implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static h[] f336810c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final int f336811d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final h f336812e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f336813f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final h f336814g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f336815h = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final h f336816i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f336817j = 4;

    /* renamed from: k, reason: collision with root package name */
    public static final h f336818k;

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ boolean f336819l;

    /* renamed from: a, reason: collision with root package name */
    private int f336820a;

    /* renamed from: b, reason: collision with root package name */
    private String f336821b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11904);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f336819l = true;
        f336810c = new h[4];
        f336812e = new h(0, 1, "PUSH_SERVER_LIST");
        f336814g = new h(1, 2, "PUSH_FMT_SERVER_LIST");
        f336816i = new h(2, 3, "PUSH_CLILOG_CONFIG");
        f336818k = new h(3, 4, "PUSH_PROXY_LIST");
    }

    h(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        new String();
        this.f336821b = str;
        this.f336820a = i16;
        f336810c[i3] = this;
    }

    public static h a(int i3) {
        int i16 = 0;
        while (true) {
            h[] hVarArr = f336810c;
            if (i16 < hVarArr.length) {
                if (hVarArr[i16].a() == i3) {
                    return f336810c[i16];
                }
                i16++;
            } else {
                if (f336819l) {
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
        return this.f336821b;
    }

    public static h a(String str) {
        int i3 = 0;
        while (true) {
            h[] hVarArr = f336810c;
            if (i3 < hVarArr.length) {
                if (hVarArr[i3].toString().equals(str)) {
                    return f336810c[i3];
                }
                i3++;
            } else {
                if (f336819l) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f336820a : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
