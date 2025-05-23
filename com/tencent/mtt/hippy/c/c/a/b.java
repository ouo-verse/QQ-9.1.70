package com.tencent.mtt.hippy.c.c.a;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f337128a;

    /* renamed from: b, reason: collision with root package name */
    private int f337129b;

    /* renamed from: c, reason: collision with root package name */
    private int f337130c;

    public b() {
        this(null);
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public byte a() {
        return this.f337128a.get();
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public double b() {
        return this.f337128a.getDouble();
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public long c() {
        byte b16;
        long j3 = 0;
        int i3 = 0;
        do {
            b16 = this.f337128a.get();
            j3 |= (b16 & 127) << i3;
            i3 += 7;
        } while ((b16 & 128) != 0);
        return j3;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public int d() {
        return this.f337130c;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public int e() {
        return this.f337128a.position() - this.f337129b;
    }

    public b(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            a(byteBuffer);
        }
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public int b(int i3) {
        if (i3 < 0) {
            i3 += this.f337128a.position();
        }
        if (i3 < 0 || i3 > this.f337130c) {
            throw new IndexOutOfBoundsException();
        }
        this.f337128a.position(this.f337129b + i3);
        return i3;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    public ByteBuffer a(int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        this.f337128a.get(allocate.array());
        return allocate;
    }

    @Override // com.tencent.mtt.hippy.c.c.a.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(@NonNull ByteBuffer byteBuffer) {
        this.f337128a = byteBuffer;
        this.f337129b = byteBuffer.position();
        this.f337130c = byteBuffer.limit() - byteBuffer.position();
        return this;
    }
}
