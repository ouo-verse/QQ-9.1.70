package com.tencent.mtt.hippy.c;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class c extends e {

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.mtt.hippy.c.c.a.a f337123a;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.mtt.hippy.c.e.c f337124f;

    /* renamed from: g, reason: collision with root package name */
    private int f337125g;

    /* renamed from: h, reason: collision with root package name */
    private int f337126h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<Integer, Object> f337127i = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public c(com.tencent.mtt.hippy.c.c.a.a aVar, com.tencent.mtt.hippy.c.e.c cVar) {
        this.f337123a = aVar;
        this.f337124f = cVar == null ? new com.tencent.mtt.hippy.c.e.a() : cVar;
    }

    private Number p() {
        double b16 = this.f337123a.b();
        long j3 = (long) b16;
        if (j3 == b16) {
            return Long.valueOf(j3);
        }
        return Double.valueOf(b16);
    }

    protected abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object a(byte b16, f fVar, Object obj) {
        if (b16 == 34) {
            return c(fVar, obj);
        }
        if (b16 == 45) {
            return this.f337162d;
        }
        if (b16 == 48) {
            return this.f337160b;
        }
        if (b16 == 68) {
            return j();
        }
        if (b16 == 70) {
            return Boolean.FALSE;
        }
        if (b16 == 73) {
            return Integer.valueOf(h());
        }
        if (b16 == 78) {
            return p();
        }
        if (b16 == 90) {
            return i();
        }
        if (b16 == 99) {
            return d(fVar, obj);
        }
        if (b16 == 94) {
            return k();
        }
        if (b16 == 95) {
            return this.f337161c;
        }
        switch (b16) {
            case 83:
                return e(fVar, obj);
            case 84:
                return Boolean.TRUE;
            case 85:
                return Long.valueOf(this.f337123a.c());
            default:
                return e.f337159e;
        }
    }

    public com.tencent.mtt.hippy.c.e.c b() {
        return this.f337124f;
    }

    protected String c(f fVar, Object obj) {
        return a("ISO-8859-1", fVar, obj);
    }

    protected String d(f fVar, Object obj) {
        return a(CharEncoding.UTF_16LE, fVar, obj);
    }

    public Object e() {
        return a(f.TOP_LEVEL, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte f() {
        byte a16;
        do {
            a16 = this.f337123a.a();
        } while (a16 == 0);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte g() {
        if (this.f337123a.e() < this.f337123a.d()) {
            byte a16 = this.f337123a.a();
            this.f337123a.b(-1);
            return a16;
        }
        return (byte) 0;
    }

    protected int h() {
        long c16 = this.f337123a.c();
        return (int) ((-(c16 & 1)) ^ (c16 >> 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BigInteger i() {
        boolean z16;
        int i3;
        int c16 = (int) this.f337123a.c();
        int i16 = 0;
        if ((c16 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i17 = c16 >> 1;
        BigInteger bigInteger = BigInteger.ZERO;
        while (i16 < i17) {
            byte a16 = this.f337123a.a();
            int i18 = i16 * 8;
            while (true) {
                i3 = i16 + 1;
                if (i18 < i3 * 8) {
                    if ((a16 & 1) != 0) {
                        bigInteger = bigInteger.setBit(i18);
                    }
                    a16 = (byte) (a16 >>> 1);
                    i18++;
                }
            }
            i16 = i3;
        }
        if (z16) {
            return bigInteger.negate();
        }
        return bigInteger;
    }

    protected Date j() {
        return (Date) a((c) new Date((long) this.f337123a.b()));
    }

    protected Object k() {
        int c16 = (int) this.f337123a.c();
        if (c16 >= 0) {
            Object obj = this.f337127i.get(Integer.valueOf(c16));
            if (obj != null) {
                return obj;
            }
            throw new AssertionError(String.format("invalid object reference(@%d)", Integer.valueOf(c16)));
        }
        throw new com.tencent.mtt.hippy.c.b.c(c16);
    }

    public int l() {
        return this.f337125g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object a(f fVar, Object obj) {
        return a(f(), fVar, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(f fVar, Object obj) {
        byte f16 = f();
        if (f16 == 34) {
            return c(fVar, obj);
        }
        if (f16 == 83) {
            return e(fVar, obj);
        }
        if (f16 == 99) {
            return d(fVar, obj);
        }
        throw new com.tencent.mtt.hippy.b.b();
    }

    public void c() {
        this.f337127i.clear();
        this.f337126h = 0;
    }

    public void d() {
        if (f() == -1) {
            this.f337125g = (int) this.f337123a.c();
            int a16 = a();
            if (a16 > 0 && this.f337125g > a16) {
                throw new UnsupportedOperationException("Unable to deserialize cloned data due to invalid or unsupported version.");
            }
        }
    }

    protected String e(f fVar, Object obj) {
        return a("UTF-8", fVar, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T a(T t16) {
        Map<Integer, Object> map = this.f337127i;
        int i3 = this.f337126h;
        this.f337126h = i3 + 1;
        map.put(Integer.valueOf(i3), t16);
        return t16;
    }

    protected String a(String str, f fVar, Object obj) {
        int c16 = (int) this.f337123a.c();
        if (c16 < 0) {
            throw new com.tencent.mtt.hippy.c.b.c(c16);
        }
        try {
            return this.f337124f.a(this.f337123a.a(c16), str, fVar, obj);
        } catch (UnsupportedEncodingException e16) {
            throw new com.tencent.mtt.hippy.b.b(e16);
        }
    }

    public void a(com.tencent.mtt.hippy.c.c.a.a aVar) {
        this.f337123a = aVar;
    }
}
