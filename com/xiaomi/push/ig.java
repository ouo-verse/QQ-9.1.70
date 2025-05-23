package com.xiaomi.push;

import com.xiaomi.push.hw;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ig extends hw {

    /* renamed from: o, reason: collision with root package name */
    private static int f389408o = 10000;

    /* renamed from: p, reason: collision with root package name */
    private static int f389409p = 10000;

    /* renamed from: q, reason: collision with root package name */
    private static int f389410q = 10000;

    /* renamed from: r, reason: collision with root package name */
    private static int f389411r = 10485760;

    /* renamed from: s, reason: collision with root package name */
    private static int f389412s = 104857600;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends hw.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.hw.a, com.xiaomi.push.ic
        public hn a(hy hyVar) {
            ig igVar = new ig(hyVar, ((hw.a) this).f24862a, this.f389395b);
            int i3 = ((hw.a) this).f389394a;
            if (i3 != 0) {
                igVar.L(i3);
            }
            return igVar;
        }

        public a(boolean z16, boolean z17, int i3) {
            super(z16, z17, i3);
        }
    }

    public ig(hy hyVar, boolean z16, boolean z17) {
        super(hyVar, z16, z17);
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.hn
    public gc f() {
        byte a16 = a();
        int c16 = c();
        if (c16 <= f389409p) {
            return new gc(a16, c16);
        }
        throw new ib(3, "Thrift list size " + c16 + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.hn
    public gd g() {
        byte a16 = a();
        byte a17 = a();
        int c16 = c();
        if (c16 <= f389408o) {
            return new gd(a16, a17, c16);
        }
        throw new ib(3, "Thrift map size " + c16 + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.hn
    public hr h() {
        byte a16 = a();
        int c16 = c();
        if (c16 <= f389410q) {
            return new hr(a16, c16);
        }
        throw new ib(3, "Thrift set size " + c16 + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.hn
    public String j() {
        int c16 = c();
        if (c16 <= f389411r) {
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
        throw new ib(3, "Thrift string size " + c16 + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.hn
    public ByteBuffer k() {
        int c16 = c();
        if (c16 <= f389412s) {
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
        throw new ib(3, "Thrift binary size " + c16 + " out of range!");
    }
}
