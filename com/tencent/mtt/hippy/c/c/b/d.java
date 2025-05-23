package com.tencent.mtt.hippy.c.c.b;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class d extends a {

    /* renamed from: c, reason: collision with root package name */
    public byte[] f337138c;

    /* renamed from: d, reason: collision with root package name */
    private int f337139d;

    public d() {
        this(64, 16384);
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public int a(int i3) {
        if (i3 < 0 && (i3 = i3 + this.f337139d) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 > this.f337138c.length) {
            b(i3);
        }
        this.f337139d = i3;
        return i3;
    }

    public b b() {
        if (this.f337139d >= this.f337136b) {
            this.f337138c = new byte[this.f337135a];
        }
        this.f337139d = 0;
        return this;
    }

    public d(int i3, int i16) {
        super(i3, i16);
        this.f337139d = 0;
        this.f337138c = new byte[i3];
    }

    private void b(int i3) {
        byte[] bArr = this.f337138c;
        int length = (bArr.length << 1) + 2;
        if (i3 <= length) {
            i3 = length;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, this.f337139d);
        this.f337138c = bArr2;
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public int a(long j3) {
        byte b16;
        byte[] bArr;
        int i3;
        int i16 = this.f337139d;
        if (i16 + 10 > this.f337138c.length) {
            b(i16 + 10);
        }
        int i17 = 0;
        do {
            b16 = (byte) (((byte) j3) | 128);
            bArr = this.f337138c;
            int i18 = this.f337139d;
            i3 = i18 + 1;
            this.f337139d = i3;
            bArr[i18] = b16;
            j3 >>>= 7;
            i17++;
        } while (j3 != 0);
        bArr[i3 - 1] = (byte) (b16 & Byte.MAX_VALUE);
        return i17;
    }

    public ByteBuffer a() {
        ByteBuffer wrap = ByteBuffer.wrap(this.f337138c, 0, this.f337139d);
        b();
        return wrap;
    }

    public void b(long j3) {
        int i3 = this.f337139d;
        if (i3 + 8 > this.f337138c.length) {
            b(i3 + 8);
        }
        byte[] bArr = this.f337138c;
        int i16 = this.f337139d;
        int i17 = i16 + 1;
        bArr[i16] = (byte) j3;
        int i18 = i17 + 1;
        bArr[i17] = (byte) (j3 >> 8);
        int i19 = i18 + 1;
        bArr[i18] = (byte) (j3 >> 16);
        int i26 = i19 + 1;
        bArr[i19] = (byte) (j3 >> 24);
        int i27 = i26 + 1;
        bArr[i26] = (byte) (j3 >> 32);
        int i28 = i27 + 1;
        bArr[i27] = (byte) (j3 >> 40);
        int i29 = i28 + 1;
        bArr[i28] = (byte) (j3 >> 48);
        this.f337139d = i29 + 1;
        bArr[i29] = (byte) (j3 >> 56);
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public void a(byte b16) {
        int i3 = this.f337139d;
        if (i3 == this.f337138c.length) {
            b(i3 + 1);
        }
        byte[] bArr = this.f337138c;
        int i16 = this.f337139d;
        this.f337139d = i16 + 1;
        bArr[i16] = b16;
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public void a(char c16) {
        int i3 = this.f337139d;
        if (i3 + 2 > this.f337138c.length) {
            b(i3 + 2);
        }
        byte[] bArr = this.f337138c;
        int i16 = this.f337139d;
        int i17 = i16 + 1;
        bArr[i16] = (byte) c16;
        this.f337139d = i17 + 1;
        bArr[i17] = (byte) (c16 >> '\b');
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public void a(double d16) {
        b(Double.doubleToRawLongBits(d16));
    }
}
