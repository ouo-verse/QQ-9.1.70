package com.tencent.mtt.hippy.c.c.b;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class c extends a {

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f337137c;

    public c() {
        this(1024, 16384);
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public int a(int i3) {
        if (i3 < 0) {
            i3 += this.f337137c.position();
        }
        this.f337137c.position(i3);
        return i3;
    }

    public b b() {
        if (this.f337137c.capacity() >= this.f337136b) {
            this.f337137c = ByteBuffer.allocateDirect(this.f337135a);
        }
        return this;
    }

    public c(int i3, int i16) {
        super(i3, i16);
        this.f337137c = ByteBuffer.allocateDirect(i3);
    }

    private void b(int i3) {
        int position = (this.f337137c.position() << 1) + 2;
        if (i3 <= position) {
            i3 = position;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
        this.f337137c.flip();
        allocateDirect.put(this.f337137c);
        this.f337137c = allocateDirect;
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public int a(long j3) {
        byte b16;
        if (this.f337137c.position() + 10 > this.f337137c.capacity()) {
            b(this.f337137c.position() + 10);
        }
        int i3 = 0;
        do {
            b16 = (byte) (((byte) j3) | 128);
            this.f337137c.put(b16);
            j3 >>>= 7;
            i3++;
        } while (j3 != 0);
        this.f337137c.position(r5.position() - 1);
        this.f337137c.put((byte) (b16 & Byte.MAX_VALUE));
        return i3;
    }

    public ByteBuffer a() {
        this.f337137c.flip();
        ByteBuffer duplicate = this.f337137c.duplicate();
        b();
        return duplicate;
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public void a(byte b16) {
        if (this.f337137c.position() == this.f337137c.capacity()) {
            b(this.f337137c.position() + 1);
        }
        this.f337137c.put(b16);
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public void a(char c16) {
        if (this.f337137c.position() + 2 > this.f337137c.capacity()) {
            b(this.f337137c.position() + 2);
        }
        this.f337137c.putChar(c16);
    }

    @Override // com.tencent.mtt.hippy.c.c.b.b
    public void a(double d16) {
        this.f337137c.putDouble(d16);
    }
}
