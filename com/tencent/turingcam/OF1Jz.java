package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class OF1Jz extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static byte[] f381960k;

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, String> f381961l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ boolean f381962m;

    /* renamed from: a, reason: collision with root package name */
    public short f381963a;

    /* renamed from: b, reason: collision with root package name */
    public byte f381964b;

    /* renamed from: c, reason: collision with root package name */
    public int f381965c;

    /* renamed from: d, reason: collision with root package name */
    public int f381966d;

    /* renamed from: e, reason: collision with root package name */
    public String f381967e;

    /* renamed from: f, reason: collision with root package name */
    public String f381968f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f381969g;

    /* renamed from: h, reason: collision with root package name */
    public int f381970h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f381971i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f381972j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16090);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f381962m = true;
        f381960k = null;
        f381961l = null;
    }

    public OF1Jz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381963a = (short) 0;
        this.f381964b = (byte) 0;
        this.f381965c = 0;
        this.f381966d = 0;
        this.f381967e = null;
        this.f381968f = null;
        this.f381970h = 0;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f381963a, 1);
        xjpd8.a(this.f381964b, 2);
        xjpd8.a(this.f381965c, 3);
        xjpd8.a(this.f381966d, 4);
        xjpd8.a(this.f381967e, 5);
        xjpd8.a(this.f381968f, 6);
        xjpd8.a(this.f381969g, 7);
        xjpd8.a(this.f381970h, 8);
        xjpd8.a((Map) this.f381971i, 9);
        xjpd8.a((Map) this.f381972j, 10);
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f381962m) {
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
        OF1Jz oF1Jz = (OF1Jz) obj;
        if (vzMV2.a(1, (int) oF1Jz.f381963a) && vzMV2.a(1, (int) oF1Jz.f381964b) && vzMV2.a(1, oF1Jz.f381965c) && vzMV2.a(1, oF1Jz.f381966d)) {
            Integer num = 1;
            if (num.equals(oF1Jz.f381967e)) {
                Integer num2 = 1;
                if (num2.equals(oF1Jz.f381968f)) {
                    Integer num3 = 1;
                    if (num3.equals(oF1Jz.f381969g) && vzMV2.a(1, oF1Jz.f381970h)) {
                        Integer num4 = 1;
                        if (num4.equals(oF1Jz.f381971i)) {
                            Integer num5 = 1;
                            if (num5.equals(oF1Jz.f381972j)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) yunKQ);
            return;
        }
        try {
            this.f381963a = yunKQ.a(this.f381963a, 1, true);
            this.f381964b = yunKQ.a(this.f381964b, 2, true);
            this.f381965c = yunKQ.a(this.f381965c, 3, true);
            this.f381966d = yunKQ.a(this.f381966d, 4, true);
            this.f381967e = yunKQ.b(5, true);
            this.f381968f = yunKQ.b(6, true);
            if (f381960k == null) {
                f381960k = new byte[]{0};
            }
            this.f381969g = yunKQ.a(7, true);
            this.f381970h = yunKQ.a(this.f381970h, 8, true);
            if (f381961l == null) {
                HashMap hashMap = new HashMap();
                f381961l = hashMap;
                hashMap.put("", "");
            }
            this.f381971i = (Map) yunKQ.a((YunKQ) f381961l, 9, true);
            if (f381961l == null) {
                HashMap hashMap2 = new HashMap();
                f381961l = hashMap2;
                hashMap2.put("", "");
            }
            this.f381972j = (Map) yunKQ.a((YunKQ) f381961l, 10, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder a16 = tmnyR.a("RequestPacket decode error ");
            byte[] bArr = this.f381969g;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = WevD9.f382090a;
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
