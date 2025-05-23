package com.xiaomi.push;

import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class eb {

    /* renamed from: g, reason: collision with root package name */
    private static String f388647g = fm.a(5) + "-";

    /* renamed from: h, reason: collision with root package name */
    private static long f388648h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f388649i = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private co f388650a;

    /* renamed from: b, reason: collision with root package name */
    private short f388651b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f388652c;

    /* renamed from: d, reason: collision with root package name */
    String f388653d;

    /* renamed from: e, reason: collision with root package name */
    int f388654e;

    /* renamed from: f, reason: collision with root package name */
    private final long f388655f;

    public eb() {
        this.f388651b = (short) 2;
        this.f388652c = f388649i;
        this.f388653d = null;
        this.f388655f = System.currentTimeMillis();
        this.f388650a = new co();
        this.f388654e = 1;
    }

    public static synchronized String C() {
        String sb5;
        synchronized (eb.class) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(f388647g);
            long j3 = f388648h;
            f388648h = 1 + j3;
            sb6.append(Long.toString(j3));
            sb5 = sb6.toString();
        }
        return sb5;
    }

    @Deprecated
    public static eb c(fc fcVar, String str) {
        int i3;
        eb ebVar = new eb();
        try {
            i3 = Integer.parseInt(fcVar.m());
        } catch (Exception e16) {
            jz4.c.m("Blob parse chid err " + e16.getMessage());
            i3 = 1;
        }
        ebVar.h(i3);
        ebVar.k(fcVar.l());
        ebVar.B(fcVar.q());
        ebVar.v(fcVar.s());
        ebVar.l("XMLMSG", null);
        try {
            ebVar.n(fcVar.f().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                ebVar.m((short) 3);
            } else {
                ebVar.m((short) 2);
                ebVar.l("SECMSG", null);
            }
        } catch (UnsupportedEncodingException e17) {
            jz4.c.m("Blob setPayload err\uff1a " + e17.getMessage());
        }
        return ebVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static eb d(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s16 = slice.getShort(0);
            short s17 = slice.getShort(2);
            int i3 = slice.getInt(4);
            co coVar = new co();
            coVar.d(slice.array(), slice.arrayOffset() + 8, s17);
            byte[] bArr = new byte[i3];
            slice.position(s17 + 8);
            slice.get(bArr, 0, i3);
            return new eb(coVar, s16, bArr);
        } catch (Exception e16) {
            jz4.c.m("read Blob err :" + e16.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public void A(long j3) {
        this.f388650a.A(j3);
    }

    public void B(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f388650a.m(parseLong);
                this.f388650a.o(substring);
                this.f388650a.u(substring2);
            } catch (Exception e16) {
                jz4.c.m("Blob parse user err " + e16.getMessage());
            }
        }
    }

    public String D() {
        String L = this.f388650a.L();
        if ("ID_NOT_AVAILABLE".equals(L)) {
            return null;
        }
        if (!this.f388650a.R()) {
            String C = C();
            this.f388650a.K(C);
            return C;
        }
        return L;
    }

    public String E() {
        return this.f388653d;
    }

    public String F() {
        if (this.f388650a.w()) {
            return Long.toString(this.f388650a.j()) + "@" + this.f388650a.p() + "/" + this.f388650a.v();
        }
        return null;
    }

    public int a() {
        return this.f388650a.x();
    }

    public long b() {
        return this.f388655f;
    }

    public String e() {
        return this.f388650a.C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer f(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(x());
        }
        byteBuffer.putShort(this.f388651b);
        byteBuffer.putShort((short) this.f388650a.a());
        byteBuffer.putInt(this.f388652c.length);
        int position = byteBuffer.position();
        this.f388650a.f(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f388650a.a());
        byteBuffer.position(position + this.f388650a.a());
        byteBuffer.put(this.f388652c);
        return byteBuffer;
    }

    public short g() {
        return this.f388651b;
    }

    public void h(int i3) {
        this.f388650a.l(i3);
    }

    public void i(long j3) {
        this.f388650a.m(j3);
    }

    public void j(long j3, String str, String str2) {
        if (j3 != 0) {
            this.f388650a.m(j3);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f388650a.o(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f388650a.u(str2);
        }
    }

    public void k(String str) {
        this.f388650a.K(str);
    }

    public void l(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f388650a.B(str);
            this.f388650a.k();
            if (!TextUtils.isEmpty(str2)) {
                this.f388650a.G(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    public void m(short s16) {
        this.f388651b = s16;
    }

    public void n(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f388650a.z(1);
            this.f388652c = com.xiaomi.push.service.aa.i(com.xiaomi.push.service.aa.g(str, D()), bArr);
        } else {
            this.f388650a.z(0);
            this.f388652c = bArr;
        }
    }

    public boolean o() {
        return this.f388650a.U();
    }

    public byte[] p() {
        return ec.a(this, this.f388652c);
    }

    public byte[] q(String str) {
        if (this.f388650a.J() == 1) {
            return ec.a(this, com.xiaomi.push.service.aa.i(com.xiaomi.push.service.aa.g(str, D()), this.f388652c));
        }
        if (this.f388650a.J() == 0) {
            return ec.a(this, this.f388652c);
        }
        jz4.c.m("unknow cipher = " + this.f388650a.J());
        return ec.a(this, this.f388652c);
    }

    public int r() {
        return this.f388650a.N();
    }

    public long s() {
        return this.f388650a.r();
    }

    public String t() {
        return this.f388650a.H();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.m.b(D()) + "; cmd=" + e() + "; type=" + ((int) g()) + "; from=" + F() + " ]";
    }

    public void u(long j3) {
        this.f388650a.t(j3);
    }

    public void v(String str) {
        this.f388653d = str;
    }

    public boolean w() {
        return this.f388650a.W();
    }

    public int x() {
        return this.f388650a.i() + 8 + this.f388652c.length;
    }

    public long y() {
        return this.f388650a.j();
    }

    public String z() {
        return this.f388650a.P();
    }

    eb(co coVar, short s16, byte[] bArr) {
        this.f388651b = (short) 2;
        this.f388652c = f388649i;
        this.f388653d = null;
        this.f388655f = System.currentTimeMillis();
        this.f388650a = coVar;
        this.f388651b = s16;
        this.f388652c = bArr;
        this.f388654e = 2;
    }
}
