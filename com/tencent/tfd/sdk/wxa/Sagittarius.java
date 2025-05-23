package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Sagittarius extends CanisMinor {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static byte[] f375666k;

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, String> f375667l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ boolean f375668m;

    /* renamed from: a, reason: collision with root package name */
    public short f375669a;

    /* renamed from: b, reason: collision with root package name */
    public byte f375670b;

    /* renamed from: c, reason: collision with root package name */
    public int f375671c;

    /* renamed from: d, reason: collision with root package name */
    public int f375672d;

    /* renamed from: e, reason: collision with root package name */
    public String f375673e;

    /* renamed from: f, reason: collision with root package name */
    public String f375674f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f375675g;

    /* renamed from: h, reason: collision with root package name */
    public int f375676h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f375677i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f375678j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62710);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f375668m = true;
        f375666k = null;
        f375667l = null;
    }

    public Sagittarius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375669a = (short) 0;
        this.f375670b = (byte) 0;
        this.f375671c = 0;
        this.f375672d = 0;
        this.f375673e = null;
        this.f375674f = null;
        this.f375676h = 0;
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Canesatici canesatici) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canesatici);
            return;
        }
        canesatici.a(this.f375669a, 1);
        canesatici.a(this.f375670b, 2);
        canesatici.a(this.f375671c, 3);
        canesatici.a(this.f375672d, 4);
        canesatici.a(this.f375673e, 5);
        canesatici.a(this.f375674f, 6);
        canesatici.a(this.f375675g, 7);
        canesatici.a(this.f375676h, 8);
        canesatici.a((Map) this.f375677i, 9);
        canesatici.a((Map) this.f375678j, 10);
    }

    public final Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f375668m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        Sagittarius sagittarius = (Sagittarius) obj;
        if (CanisMajor.a(1, (int) sagittarius.f375669a) && CanisMajor.a(1, (int) sagittarius.f375670b) && CanisMajor.a(1, sagittarius.f375671c) && CanisMajor.a(1, sagittarius.f375672d)) {
            Integer num = 1;
            if (num.equals(sagittarius.f375673e)) {
                Integer num2 = 1;
                if (num2.equals(sagittarius.f375674f)) {
                    Integer num3 = 1;
                    if (num3.equals(sagittarius.f375675g) && CanisMajor.a(1, sagittarius.f375676h)) {
                        Integer num4 = 1;
                        if (num4.equals(sagittarius.f375677i)) {
                            Integer num5 = 1;
                            if (num5.equals(sagittarius.f375678j)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Caelum caelum) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) caelum);
            return;
        }
        try {
            this.f375669a = caelum.a(this.f375669a, 1, true);
            this.f375670b = caelum.a(this.f375670b, 2, true);
            this.f375671c = caelum.a(this.f375671c, 3, true);
            this.f375672d = caelum.a(this.f375672d, 4, true);
            this.f375673e = caelum.b(5, true);
            this.f375674f = caelum.b(6, true);
            if (f375666k == null) {
                f375666k = new byte[]{0};
            }
            this.f375675g = caelum.a(7, true);
            this.f375676h = caelum.a(this.f375676h, 8, true);
            if (f375667l == null) {
                HashMap hashMap = new HashMap();
                f375667l = hashMap;
                hashMap.put("", "");
            }
            this.f375677i = (Map) caelum.a((Caelum) f375667l, 9, true);
            if (f375667l == null) {
                HashMap hashMap2 = new HashMap();
                f375667l = hashMap2;
                hashMap2.put("", "");
            }
            this.f375678j = (Map) caelum.a((Caelum) f375667l, 10, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder a16 = Pyxis.a("RequestPacket decode error ");
            byte[] bArr = this.f375675g;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = Grape.f375635a;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                }
                str = new String(cArr);
            }
            a16.append(str);
            printStream.println(a16.toString());
            throw new RuntimeException(e16);
        }
    }
}
