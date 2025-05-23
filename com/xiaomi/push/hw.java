package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hw extends hn {

    /* renamed from: n, reason: collision with root package name */
    private static final hs f389381n = new hs();

    /* renamed from: b, reason: collision with root package name */
    protected boolean f389382b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f389383c;

    /* renamed from: d, reason: collision with root package name */
    protected int f389384d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f389385e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f389386f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f389387g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f389388h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f389389i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f389390j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f389391k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f389392l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f389393m;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements ic {

        /* renamed from: a, reason: collision with root package name */
        protected int f389394a;

        /* renamed from: a, reason: collision with other field name */
        protected boolean f24862a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f389395b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.ic
        public hn a(hy hyVar) {
            hw hwVar = new hw(hyVar, this.f24862a, this.f389395b);
            int i3 = this.f389394a;
            if (i3 != 0) {
                hwVar.L(i3);
            }
            return hwVar;
        }

        public a(boolean z16, boolean z17) {
            this(z16, z17, 0);
        }

        public a(boolean z16, boolean z17, int i3) {
            this.f24862a = z16;
            this.f389395b = z17;
            this.f389394a = i3;
        }
    }

    public hw(hy hyVar, boolean z16, boolean z17) {
        super(hyVar);
        this.f389385e = false;
        this.f389386f = new byte[1];
        this.f389387g = new byte[2];
        this.f389388h = new byte[4];
        this.f389389i = new byte[8];
        this.f389390j = new byte[1];
        this.f389391k = new byte[2];
        this.f389392l = new byte[4];
        this.f389393m = new byte[8];
        this.f389382b = z16;
        this.f389383c = z17;
    }

    private int J(byte[] bArr, int i3, int i16) {
        M(i16);
        return this.f389362a.g(bArr, i3, i16);
    }

    @Override // com.xiaomi.push.hn
    public void A() {
        n((byte) 0);
    }

    public String K(int i3) {
        try {
            M(i3);
            byte[] bArr = new byte[i3];
            this.f389362a.g(bArr, 0, i3);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void L(int i3) {
        this.f389384d = i3;
        this.f389385e = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i3) {
        if (i3 >= 0) {
            if (this.f389385e) {
                int i16 = this.f389384d - i3;
                this.f389384d = i16;
                if (i16 < 0) {
                    throw new hu("Message length exceeded: " + i3);
                }
                return;
            }
            return;
        }
        throw new hu("Negative length: " + i3);
    }

    @Override // com.xiaomi.push.hn
    public byte a() {
        if (this.f389362a.f() >= 1) {
            byte b16 = this.f389362a.d()[this.f389362a.e()];
            this.f389362a.b(1);
            return b16;
        }
        J(this.f389390j, 0, 1);
        return this.f389390j[0];
    }

    @Override // com.xiaomi.push.hn
    public double b() {
        return Double.longBitsToDouble(d());
    }

    @Override // com.xiaomi.push.hn
    public int c() {
        int i3;
        byte[] bArr = this.f389392l;
        if (this.f389362a.f() >= 4) {
            bArr = this.f389362a.d();
            i3 = this.f389362a.e();
            this.f389362a.b(4);
        } else {
            J(this.f389392l, 0, 4);
            i3 = 0;
        }
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.hn
    public long d() {
        int i3;
        byte[] bArr = this.f389393m;
        if (this.f389362a.f() >= 8) {
            bArr = this.f389362a.d();
            i3 = this.f389362a.e();
            this.f389362a.b(8);
        } else {
            J(this.f389393m, 0, 8);
            i3 = 0;
        }
        return (bArr[i3 + 7] & 255) | ((bArr[i3] & 255) << 56) | ((bArr[i3 + 1] & 255) << 48) | ((bArr[i3 + 2] & 255) << 40) | ((bArr[i3 + 3] & 255) << 32) | ((bArr[i3 + 4] & 255) << 24) | ((bArr[i3 + 5] & 255) << 16) | ((bArr[i3 + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.hn
    public ga e() {
        short l3;
        byte a16 = a();
        if (a16 == 0) {
            l3 = 0;
        } else {
            l3 = l();
        }
        return new ga("", a16, l3);
    }

    @Override // com.xiaomi.push.hn
    public gc f() {
        return new gc(a(), c());
    }

    @Override // com.xiaomi.push.hn
    public gd g() {
        return new gd(a(), a(), c());
    }

    @Override // com.xiaomi.push.hn
    public hr h() {
        return new hr(a(), c());
    }

    @Override // com.xiaomi.push.hn
    public hs i() {
        return f389381n;
    }

    @Override // com.xiaomi.push.hn
    public String j() {
        int c16 = c();
        if (this.f389362a.f() >= c16) {
            try {
                String str = new String(this.f389362a.d(), this.f389362a.e(), c16, "UTF-8");
                this.f389362a.b(c16);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new hu("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return K(c16);
    }

    @Override // com.xiaomi.push.hn
    public ByteBuffer k() {
        int c16 = c();
        M(c16);
        if (this.f389362a.f() >= c16) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f389362a.d(), this.f389362a.e(), c16);
            this.f389362a.b(c16);
            return wrap;
        }
        byte[] bArr = new byte[c16];
        this.f389362a.g(bArr, 0, c16);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.xiaomi.push.hn
    public short l() {
        int i3;
        byte[] bArr = this.f389391k;
        if (this.f389362a.f() >= 2) {
            bArr = this.f389362a.d();
            i3 = this.f389362a.e();
            this.f389362a.b(2);
        } else {
            J(this.f389391k, 0, 2);
            i3 = 0;
        }
        return (short) ((bArr[i3 + 1] & 255) | ((bArr[i3] & 255) << 8));
    }

    @Override // com.xiaomi.push.hn
    public void n(byte b16) {
        byte[] bArr = this.f389386f;
        bArr[0] = b16;
        this.f389362a.c(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.hn
    public void o(int i3) {
        byte[] bArr = this.f389388h;
        bArr[0] = (byte) ((i3 >> 24) & 255);
        bArr[1] = (byte) ((i3 >> 16) & 255);
        bArr[2] = (byte) ((i3 >> 8) & 255);
        bArr[3] = (byte) (i3 & 255);
        this.f389362a.c(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.hn
    public void p(long j3) {
        byte[] bArr = this.f389389i;
        bArr[0] = (byte) ((j3 >> 56) & 255);
        bArr[1] = (byte) ((j3 >> 48) & 255);
        bArr[2] = (byte) ((j3 >> 40) & 255);
        bArr[3] = (byte) ((j3 >> 32) & 255);
        bArr[4] = (byte) ((j3 >> 24) & 255);
        bArr[5] = (byte) ((j3 >> 16) & 255);
        bArr[6] = (byte) ((j3 >> 8) & 255);
        bArr[7] = (byte) (j3 & 255);
        this.f389362a.c(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.hn
    public void q(ga gaVar) {
        n(gaVar.f388941b);
        w(gaVar.f388942c);
    }

    @Override // com.xiaomi.push.hn
    public void r(gc gcVar) {
        n(gcVar.f388946a);
        o(gcVar.f388947b);
    }

    @Override // com.xiaomi.push.hn
    public void s(gd gdVar) {
        n(gdVar.f388948a);
        n(gdVar.f388949b);
        o(gdVar.f388950c);
    }

    @Override // com.xiaomi.push.hn
    public void u(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            o(bytes.length);
            this.f389362a.c(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.hn
    public void v(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        o(limit);
        this.f389362a.c(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.hn
    public void w(short s16) {
        byte[] bArr = this.f389387g;
        bArr[0] = (byte) ((s16 >> 8) & 255);
        bArr[1] = (byte) (s16 & 255);
        this.f389362a.c(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.hn
    public void x(boolean z16) {
        n(z16 ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.hn
    public boolean y() {
        if (a() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.hn
    public void B() {
    }

    @Override // com.xiaomi.push.hn
    public void C() {
    }

    @Override // com.xiaomi.push.hn
    public void D() {
    }

    @Override // com.xiaomi.push.hn
    public void E() {
    }

    @Override // com.xiaomi.push.hn
    public void F() {
    }

    @Override // com.xiaomi.push.hn
    public void G() {
    }

    @Override // com.xiaomi.push.hn
    public void H() {
    }

    @Override // com.xiaomi.push.hn
    public void m() {
    }

    @Override // com.xiaomi.push.hn
    public void z() {
    }

    @Override // com.xiaomi.push.hn
    public void t(hs hsVar) {
    }
}
