package com.tencent.mtt.hippy.c.c.a;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f337131a;

    /* renamed from: b, reason: collision with root package name */
    private int f337132b;

    /* renamed from: c, reason: collision with root package name */
    private int f337133c;

    /* renamed from: d, reason: collision with root package name */
    private int f337134d;

    public c() {
        this(null);
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public byte a() {
        int i3 = this.f337132b;
        if (i3 == this.f337133c) {
            throw new IndexOutOfBoundsException();
        }
        byte[] bArr = this.f337131a;
        int i16 = this.f337134d;
        this.f337132b = i3 + 1;
        return bArr[i16 + i3];
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public double b() {
        return Double.longBitsToDouble(f());
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public long c() {
        byte a16;
        long j3 = 0;
        int i3 = 0;
        do {
            a16 = a();
            j3 |= (a16 & 127) << i3;
            i3 += 7;
        } while ((a16 & 128) != 0);
        return j3;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public int d() {
        return this.f337133c;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public int e() {
        return this.f337132b;
    }

    public long f() {
        int i3 = this.f337132b;
        if (i3 + 8 <= this.f337133c) {
            int i16 = this.f337134d + i3;
            this.f337132b = i3 + 8;
            byte[] bArr = this.f337131a;
            return ((bArr[i16 + 7] & 255) << 56) | (bArr[i16] & 255) | ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16 + 2] & 255) << 16) | ((bArr[i16 + 3] & 255) << 24) | ((bArr[i16 + 4] & 255) << 32) | ((bArr[i16 + 5] & 255) << 40) | ((bArr[i16 + 6] & 255) << 48);
        }
        throw new IndexOutOfBoundsException();
    }

    public c(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            a(byteBuffer);
        }
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public int b(int i3) {
        if (i3 < 0) {
            i3 += this.f337132b;
        }
        if (i3 < 0 || i3 > this.f337133c) {
            throw new IndexOutOfBoundsException();
        }
        this.f337132b = i3;
        return i3;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public ByteBuffer a(int i3) {
        int i16 = this.f337132b;
        if (i16 + i3 > this.f337133c) {
            throw new IndexOutOfBoundsException();
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.f337131a, this.f337134d + i16, i3);
        this.f337132b += i3;
        return wrap;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(@NonNull ByteBuffer byteBuffer) {
        this.f337131a = byteBuffer.array();
        this.f337134d = byteBuffer.arrayOffset() + byteBuffer.position();
        this.f337133c = byteBuffer.limit() - byteBuffer.position();
        this.f337132b = 0;
        return this;
    }
}
