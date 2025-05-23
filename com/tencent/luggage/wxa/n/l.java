package com.tencent.luggage.wxa.n;

import com.tencent.luggage.wxa.n.d;
import com.tencent.luggage.wxa.n0.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements d {

    /* renamed from: d, reason: collision with root package name */
    public k f135039d;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f135042g;

    /* renamed from: h, reason: collision with root package name */
    public ShortBuffer f135043h;

    /* renamed from: i, reason: collision with root package name */
    public ByteBuffer f135044i;

    /* renamed from: j, reason: collision with root package name */
    public long f135045j;

    /* renamed from: k, reason: collision with root package name */
    public long f135046k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f135047l;

    /* renamed from: e, reason: collision with root package name */
    public float f135040e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f135041f = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f135037b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f135038c = -1;

    public l() {
        ByteBuffer byteBuffer = d.f134912a;
        this.f135042g = byteBuffer;
        this.f135043h = byteBuffer.asShortBuffer();
        this.f135044i = byteBuffer;
    }

    public float a(float f16) {
        this.f135041f = v.a(f16, 0.1f, 8.0f);
        return f16;
    }

    public float b(float f16) {
        float a16 = v.a(f16, 0.1f, 8.0f);
        this.f135040e = a16;
        return a16;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public int c() {
        return this.f135037b;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public int d() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void e() {
        this.f135039d.c();
        this.f135047l = true;
    }

    public long f() {
        return this.f135045j;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void flush() {
        k kVar = new k(this.f135038c, this.f135037b);
        this.f135039d = kVar;
        kVar.c(this.f135040e);
        this.f135039d.b(this.f135041f);
        this.f135044i = d.f134912a;
        this.f135045j = 0L;
        this.f135046k = 0L;
        this.f135047l = false;
    }

    public long g() {
        return this.f135046k;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean isActive() {
        if (Math.abs(this.f135040e - 1.0f) < 0.01f && Math.abs(this.f135041f - 1.0f) < 0.01f) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void reset() {
        this.f135039d = null;
        ByteBuffer byteBuffer = d.f134912a;
        this.f135042g = byteBuffer;
        this.f135043h = byteBuffer.asShortBuffer();
        this.f135044i = byteBuffer;
        this.f135037b = -1;
        this.f135038c = -1;
        this.f135045j = 0L;
        this.f135046k = 0L;
        this.f135047l = false;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean a(int i3, int i16, int i17) {
        if (i17 == 2) {
            if (this.f135038c == i3 && this.f135037b == i16) {
                return false;
            }
            this.f135038c = i3;
            this.f135037b = i16;
            return true;
        }
        throw new d.a(i3, i16, i17);
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean b() {
        k kVar;
        return this.f135047l && ((kVar = this.f135039d) == null || kVar.a() == 0);
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f135045j += remaining;
            this.f135039d.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int a16 = this.f135039d.a() * this.f135037b * 2;
        if (a16 > 0) {
            if (this.f135042g.capacity() < a16) {
                ByteBuffer order = ByteBuffer.allocateDirect(a16).order(ByteOrder.nativeOrder());
                this.f135042g = order;
                this.f135043h = order.asShortBuffer();
            } else {
                this.f135042g.clear();
                this.f135043h.clear();
            }
            this.f135039d.a(this.f135043h);
            this.f135046k += a16;
            this.f135042g.limit(a16);
            this.f135044i = this.f135042g;
        }
    }

    @Override // com.tencent.luggage.wxa.n.d
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f135044i;
        this.f135044i = d.f134912a;
        return byteBuffer;
    }
}
