package com.tencent.luggage.wxa.o;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends a {

    /* renamed from: b, reason: collision with root package name */
    public final b f135955b = new b();

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f135956c;

    /* renamed from: d, reason: collision with root package name */
    public long f135957d;

    /* renamed from: e, reason: collision with root package name */
    public final int f135958e;

    public d(int i3) {
        this.f135958e = i3;
    }

    public static d h() {
        return new d(0);
    }

    @Override // com.tencent.luggage.wxa.o.a
    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.f135956c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final ByteBuffer d(int i3) {
        int capacity;
        int i16 = this.f135958e;
        if (i16 == 1) {
            return ByteBuffer.allocate(i3);
        }
        if (i16 == 2) {
            return ByteBuffer.allocateDirect(i3);
        }
        ByteBuffer byteBuffer = this.f135956c;
        if (byteBuffer == null) {
            capacity = 0;
        } else {
            capacity = byteBuffer.capacity();
        }
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i3 + ")");
    }

    public void e(int i3) {
        ByteBuffer byteBuffer = this.f135956c;
        if (byteBuffer == null) {
            this.f135956c = d(i3);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f135956c.position();
        int i16 = i3 + position;
        if (capacity >= i16) {
            return;
        }
        ByteBuffer d16 = d(i16);
        if (position > 0) {
            this.f135956c.position(0);
            this.f135956c.limit(position);
            d16.put(this.f135956c);
        }
        this.f135956c = d16;
    }

    public final boolean f() {
        return b(1073741824);
    }

    public final boolean g() {
        if (this.f135956c == null && this.f135958e == 0) {
            return true;
        }
        return false;
    }

    public final void e() {
        this.f135956c.flip();
    }
}
