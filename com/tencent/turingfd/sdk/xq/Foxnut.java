package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Foxnut extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static byte[] f382767k;

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, String> f382768l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ boolean f382769m;

    /* renamed from: a, reason: collision with root package name */
    public short f382770a;

    /* renamed from: b, reason: collision with root package name */
    public byte f382771b;

    /* renamed from: c, reason: collision with root package name */
    public int f382772c;

    /* renamed from: d, reason: collision with root package name */
    public int f382773d;

    /* renamed from: e, reason: collision with root package name */
    public String f382774e;

    /* renamed from: f, reason: collision with root package name */
    public String f382775f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f382776g;

    /* renamed from: h, reason: collision with root package name */
    public int f382777h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f382778i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f382779j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382769m = true;
        f382767k = null;
        f382768l = null;
    }

    public Foxnut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382770a = (short) 0;
        this.f382771b = (byte) 0;
        this.f382772c = 0;
        this.f382773d = 0;
        this.f382774e = null;
        this.f382775f = null;
        this.f382777h = 0;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382770a, 1);
        solar.a(this.f382771b, 2);
        solar.a(this.f382772c, 3);
        solar.a(this.f382773d, 4);
        solar.a(this.f382774e, 5);
        solar.a(this.f382775f, 6);
        solar.a(this.f382776g, 7);
        solar.a(this.f382777h, 8);
        solar.a((Map) this.f382778i, 9);
        solar.a((Map) this.f382779j, 10);
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f382769m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        Foxnut foxnut = (Foxnut) obj;
        if (Triangulum.a(1, (int) foxnut.f382770a) && Triangulum.a(1, (int) foxnut.f382771b) && Triangulum.a(1, foxnut.f382772c) && Triangulum.a(1, foxnut.f382773d)) {
            Integer num = 1;
            if (num.equals(foxnut.f382774e)) {
                Integer num2 = 1;
                if (num2.equals(foxnut.f382775f)) {
                    Integer num3 = 1;
                    if (num3.equals(foxnut.f382776g) && Triangulum.a(1, foxnut.f382777h)) {
                        Integer num4 = 1;
                        if (num4.equals(foxnut.f382778i)) {
                            Integer num5 = 1;
                            if (num5.equals(foxnut.f382779j)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) serpens);
            return;
        }
        try {
            this.f382770a = serpens.a(this.f382770a, 1, true);
            this.f382771b = serpens.a(this.f382771b, 2, true);
            this.f382772c = serpens.a(this.f382772c, 3, true);
            this.f382773d = serpens.a(this.f382773d, 4, true);
            this.f382774e = serpens.b(5, true);
            this.f382775f = serpens.b(6, true);
            if (f382767k == null) {
                f382767k = new byte[]{0};
            }
            this.f382776g = serpens.a(7, true);
            this.f382777h = serpens.a(this.f382777h, 8, true);
            if (f382768l == null) {
                HashMap hashMap = new HashMap();
                f382768l = hashMap;
                hashMap.put("", "");
            }
            this.f382778i = (Map) serpens.a((Serpens) f382768l, 9, true);
            if (f382768l == null) {
                HashMap hashMap2 = new HashMap();
                f382768l = hashMap2;
                hashMap2.put("", "");
            }
            this.f382779j = (Map) serpens.a((Serpens) f382768l, 10, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder a16 = Flat.a("RequestPacket decode error ");
            byte[] bArr = this.f382776g;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = o.f383408a;
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
