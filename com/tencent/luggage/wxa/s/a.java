package com.tencent.luggage.wxa.s;

import com.tencent.luggage.wxa.m.o;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.s.b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f139912a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final Stack f139913b = new Stack();

    /* renamed from: c, reason: collision with root package name */
    public final f f139914c = new f();

    /* renamed from: d, reason: collision with root package name */
    public c f139915d;

    /* renamed from: e, reason: collision with root package name */
    public int f139916e;

    /* renamed from: f, reason: collision with root package name */
    public int f139917f;

    /* renamed from: g, reason: collision with root package name */
    public long f139918g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f139919a;

        /* renamed from: b, reason: collision with root package name */
        public final long f139920b;

        public b(int i3, long j3) {
            this.f139919a = i3;
            this.f139920b = j3;
        }
    }

    @Override // com.tencent.luggage.wxa.s.b
    public void a(c cVar) {
        this.f139915d = cVar;
    }

    public final long b(com.tencent.luggage.wxa.q.e eVar) {
        eVar.a();
        while (true) {
            eVar.b(this.f139912a, 0, 4);
            int a16 = f.a(this.f139912a[0]);
            if (a16 != -1 && a16 <= 4) {
                int a17 = (int) f.a(this.f139912a, a16, false);
                if (this.f139915d.c(a17)) {
                    eVar.c(a16);
                    return a17;
                }
            }
            eVar.c(1);
        }
    }

    public final String c(com.tencent.luggage.wxa.q.e eVar, int i3) {
        if (i3 == 0) {
            return "";
        }
        byte[] bArr = new byte[i3];
        eVar.a(bArr, 0, i3);
        return new String(bArr);
    }

    @Override // com.tencent.luggage.wxa.s.b
    public void reset() {
        this.f139916e = 0;
        this.f139913b.clear();
        this.f139914c.b();
    }

    @Override // com.tencent.luggage.wxa.s.b
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        com.tencent.luggage.wxa.n0.a.b(this.f139915d != null);
        while (true) {
            if (!this.f139913b.isEmpty() && eVar.getPosition() >= ((b) this.f139913b.peek()).f139920b) {
                this.f139915d.a(((b) this.f139913b.pop()).f139919a);
                return true;
            }
            if (this.f139916e == 0) {
                long a16 = this.f139914c.a(eVar, true, false, 4);
                if (a16 == -2) {
                    a16 = b(eVar);
                }
                if (a16 == -1) {
                    return false;
                }
                this.f139917f = (int) a16;
                this.f139916e = 1;
            }
            if (this.f139916e == 1) {
                this.f139918g = this.f139914c.a(eVar, false, true, 8);
                this.f139916e = 2;
            }
            int b16 = this.f139915d.b(this.f139917f);
            if (b16 != 0) {
                if (b16 == 1) {
                    long position = eVar.getPosition();
                    this.f139913b.add(new b(this.f139917f, this.f139918g + position));
                    this.f139915d.a(this.f139917f, position, this.f139918g);
                    this.f139916e = 0;
                    return true;
                }
                if (b16 == 2) {
                    long j3 = this.f139918g;
                    if (j3 <= 8) {
                        this.f139915d.a(this.f139917f, b(eVar, (int) j3));
                        this.f139916e = 0;
                        return true;
                    }
                    throw new o("Invalid integer size: " + this.f139918g);
                }
                if (b16 == 3) {
                    long j16 = this.f139918g;
                    if (j16 <= TTL.MAX_VALUE) {
                        this.f139915d.a(this.f139917f, c(eVar, (int) j16));
                        this.f139916e = 0;
                        return true;
                    }
                    throw new o("String element size: " + this.f139918g);
                }
                if (b16 == 4) {
                    this.f139915d.a(this.f139917f, (int) this.f139918g, eVar);
                    this.f139916e = 0;
                    return true;
                }
                if (b16 == 5) {
                    long j17 = this.f139918g;
                    if (j17 != 4 && j17 != 8) {
                        throw new o("Invalid float size: " + this.f139918g);
                    }
                    this.f139915d.a(this.f139917f, a(eVar, (int) j17));
                    this.f139916e = 0;
                    return true;
                }
                throw new o("Invalid element type " + b16);
            }
            eVar.c((int) this.f139918g);
            this.f139916e = 0;
        }
    }

    public final long b(com.tencent.luggage.wxa.q.e eVar, int i3) {
        eVar.a(this.f139912a, 0, i3);
        long j3 = 0;
        for (int i16 = 0; i16 < i3; i16++) {
            j3 = (j3 << 8) | (this.f139912a[i16] & 255);
        }
        return j3;
    }

    public final double a(com.tencent.luggage.wxa.q.e eVar, int i3) {
        long b16 = b(eVar, i3);
        if (i3 == 4) {
            return Float.intBitsToFloat((int) b16);
        }
        return Double.longBitsToDouble(b16);
    }
}
