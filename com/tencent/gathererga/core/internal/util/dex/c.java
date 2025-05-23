package com.tencent.gathererga.core.internal.util.dex;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f108280a;

    public c(ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) byteBuffer);
            return;
        }
        com.tencent.gathererga.core.internal.util.d.a("buffer:" + byteBuffer.toString());
        this.f108280a = byteBuffer;
        byteBuffer.position(0);
        this.f108280a.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static boolean a(byte[] bArr) {
        if (bArr.length < 5 || bArr[0] < 53) {
            return false;
        }
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (byte b16 : bArr) {
            if (b16 < 48 && b16 != 46) {
                return false;
            }
            if (b16 > 57 && b16 != 46) {
                return false;
            }
            if (i3 == 2 && b16 != 46) {
                i17++;
            }
            if (b16 == 46) {
                i3++;
            }
            if (i3 == 0) {
                i16 = (i16 * 10) + (b16 - 48);
            }
        }
        if (i3 < 3 || i16 < 50 || i17 != 4) {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        return a(str.getBytes());
    }

    private b d() {
        this.f108280a.getInt();
        a.c(this.f108280a, 20);
        b bVar = new b();
        bVar.j(a.e(this.f108280a));
        bVar.k(a.e(this.f108280a));
        a.e(this.f108280a);
        bVar.m(a.e(this.f108280a));
        bVar.l(a.e(this.f108280a));
        bVar.n(a.e(this.f108280a));
        bVar.t(this.f108280a.getInt());
        bVar.s(a.e(this.f108280a));
        bVar.v(this.f108280a.getInt());
        bVar.u(a.e(this.f108280a));
        bVar.r(this.f108280a.getInt());
        bVar.q(a.e(this.f108280a));
        bVar.i(this.f108280a.getInt());
        bVar.h(a.e(this.f108280a));
        bVar.p(this.f108280a.getInt());
        bVar.o(a.e(this.f108280a));
        bVar.e(this.f108280a.getInt());
        bVar.d(a.e(this.f108280a));
        bVar.g(this.f108280a.getInt());
        bVar.f(a.e(this.f108280a));
        a.b(this.f108280a, bVar.a());
        return bVar;
    }

    private String e() {
        return f(g());
    }

    private String f(int i3) {
        char[] cArr = new char[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            short d16 = a.d(this.f108280a);
            if ((d16 & 128) == 0) {
                cArr[i16] = (char) d16;
            } else if ((d16 & 224) == 192) {
                cArr[i16] = (char) (((d16 & 31) << 6) | (a.d(this.f108280a) & 63));
            } else if ((d16 & 240) == 224) {
                cArr[i16] = (char) (((d16 & 15) << 12) | ((a.d(this.f108280a) & 63) << 6) | (a.d(this.f108280a) & 63));
            }
            char c16 = cArr[i16];
        }
        return new String(cArr);
    }

    private int g() {
        short d16;
        int i3 = 0;
        int i16 = 0;
        do {
            if (i3 > 4) {
                com.tencent.gathererga.core.internal.util.d.a("readVarInts count error!");
            }
            d16 = a.d(this.f108280a);
            i16 |= (d16 & 127) << (i3 * 7);
            i3++;
        } while ((d16 & 128) != 0);
        return i16;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = new String(a.c(this.f108280a, 8));
        if (!str.startsWith("dex\n")) {
            com.tencent.gathererga.core.internal.util.d.a("dex magic error");
            return "";
        }
        if (Integer.parseInt(str.substring(4, 7)) < 35) {
            com.tencent.gathererga.core.internal.util.d.a("dex version error");
        }
        b d16 = d();
        long b16 = d16.b();
        long c16 = d16.c();
        if (c16 > 50000) {
            c16 = 50000;
        }
        com.tencent.gathererga.core.internal.util.d.b("stringIdsOff: " + b16 + ", size:" + c16);
        for (int i3 = 0; i3 < c16; i3++) {
            a.b(this.f108280a, (i3 * 4) + b16);
            a.b(this.f108280a, a.e(this.f108280a));
            String e16 = e();
            if (b(e16)) {
                com.tencent.gathererga.core.internal.util.d.b("check true: " + e16);
                return e16;
            }
        }
        com.tencent.gathererga.core.internal.util.d.b("not found chrome version");
        return "";
    }
}
