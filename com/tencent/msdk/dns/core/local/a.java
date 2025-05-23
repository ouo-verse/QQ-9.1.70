package com.tencent.msdk.dns.core.local;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.base.log.c;
import com.tencent.msdk.dns.core.d;
import com.tencent.msdk.dns.core.e;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.n;
import com.tencent.msdk.dns.core.o;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a implements i<i.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final f f336271a;

    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.core.local.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C9216a extends com.tencent.msdk.dns.core.stat.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        public static final C9216a f336272e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17551);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f336272e = new C9216a();
            }
        }

        public C9216a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "Statistics{ips=" + Arrays.toString(this.f336376a) + ", costTimeMills=" + this.f336378c + '}';
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f336271a = new f("Local", 3);
        }
    }

    private String[] d(String str) {
        int i3;
        if (!TextUtils.isEmpty(str)) {
            String[] strArr = e.f336253a;
            String[] split = str.split(",");
            int i16 = 1;
            if (split.length > 1) {
                ArrayList arrayList = new ArrayList();
                int length = split.length;
                int i17 = 0;
                while (i17 < length) {
                    String str2 = split[i17];
                    try {
                        InetAddress[] allByName = InetAddress.getAllByName(str2);
                        String[] strArr2 = new String[allByName.length];
                        int i18 = 0;
                        while (i18 < allByName.length) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str2);
                            try {
                                sb5.append(":");
                                sb5.append(allByName[i18].getHostAddress());
                                arrayList.add(sb5.toString());
                                i18++;
                                i16 = 1;
                            } catch (UnknownHostException e16) {
                                e = e16;
                                i16 = 1;
                                Object[] objArr = new Object[i16];
                                objArr[0] = str;
                                c.d(e, "LocalDns lookup %s failed", objArr);
                                i17++;
                                i16 = 1;
                            }
                        }
                        if (c.e(3)) {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = str;
                            try {
                                objArr2[1] = Arrays.toString(strArr2);
                                c.c("LocalDns lookup for %s result: %s", objArr2);
                            } catch (UnknownHostException e17) {
                                e = e17;
                                i16 = 1;
                                Object[] objArr3 = new Object[i16];
                                objArr3[0] = str;
                                c.d(e, "LocalDns lookup %s failed", objArr3);
                                i17++;
                                i16 = 1;
                            }
                        }
                    } catch (UnknownHostException e18) {
                        e = e18;
                    }
                    i17++;
                    i16 = 1;
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            try {
                InetAddress[] allByName2 = InetAddress.getAllByName(str);
                strArr = new String[allByName2.length];
                for (int i19 = 0; i19 < allByName2.length; i19++) {
                    strArr[i19] = allByName2[i19].getHostAddress();
                }
                if (c.e(3)) {
                    Object[] objArr4 = new Object[2];
                    objArr4[0] = str;
                    try {
                        objArr4[1] = Arrays.toString(strArr);
                        c.c("LocalDns lookup for %s result: %s", objArr4);
                    } catch (UnknownHostException e19) {
                        e = e19;
                        i3 = 1;
                        Object[] objArr5 = new Object[i3];
                        objArr5[0] = str;
                        c.d(e, "LocalDns lookup %s failed", objArr5);
                        return strArr;
                    }
                }
            } catch (UnknownHostException e26) {
                e = e26;
                i3 = 1;
            }
            return strArr;
        }
        throw new IllegalArgumentException("hostname".concat(" can not be empty"));
    }

    @Override // com.tencent.msdk.dns.core.i
    public i.b a(n<i.a> nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return null;
        }
        return (i.b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) nVar);
    }

    @Override // com.tencent.msdk.dns.core.i
    public d b(o<i.a> oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oVar);
        }
        if (oVar != null) {
            C9216a c9216a = new C9216a();
            c9216a.h();
            String[] d16 = d(oVar.f336287b);
            c9216a.g();
            c9216a.f336376a = d16;
            return new d(d16, c9216a);
        }
        throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.i
    public d c(o<i.a> oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) oVar);
        }
        C9216a c9216a = new C9216a();
        c9216a.h();
        c9216a.g();
        return new d(c9216a.f336376a, c9216a);
    }

    @Override // com.tencent.msdk.dns.core.i
    public f a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f336271a : (f) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
