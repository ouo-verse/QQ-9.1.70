package com.tencent.luggage.wxa.n;

import com.tencent.luggage.wxa.n.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements d {

    /* renamed from: b, reason: collision with root package name */
    public int f135007b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f135008c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f135009d = 0;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f135010e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f135011f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f135012g;

    public j() {
        ByteBuffer byteBuffer = d.f134912a;
        this.f135010e = byteBuffer;
        this.f135011f = byteBuffer;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean a(int i3, int i16, int i17) {
        if (i17 != 3 && i17 != 2 && i17 != Integer.MIN_VALUE && i17 != 1073741824) {
            throw new d.a(i3, i16, i17);
        }
        if (this.f135007b == i3 && this.f135008c == i16 && this.f135009d == i17) {
            return false;
        }
        this.f135007b = i3;
        this.f135008c = i16;
        this.f135009d = i17;
        if (i17 != 2) {
            return true;
        }
        this.f135010e = d.f134912a;
        return true;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean b() {
        if (this.f135012g && this.f135011f == d.f134912a) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public int c() {
        return this.f135008c;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public int d() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void e() {
        this.f135012g = true;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void flush() {
        this.f135011f = d.f134912a;
        this.f135012g = false;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean isActive() {
        int i3 = this.f135009d;
        if (i3 != 0 && i3 != 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void reset() {
        flush();
        this.f135010e = d.f134912a;
        this.f135007b = -1;
        this.f135008c = -1;
        this.f135009d = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[ADDED_TO_REGION, LOOP:2: B:24:0x0081->B:25:0x0083, LOOP_START, PHI: r0
  0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:10:0x0041, B:25:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.tencent.luggage.wxa.n.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ByteBuffer byteBuffer) {
        int i3;
        int i16;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i17 = limit - position;
        int i18 = this.f135009d;
        if (i18 == Integer.MIN_VALUE) {
            i17 /= 3;
        } else if (i18 != 3) {
            if (i18 == 1073741824) {
                i3 = i17 / 2;
                if (this.f135010e.capacity() >= i3) {
                    this.f135010e = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
                } else {
                    this.f135010e.clear();
                }
                i16 = this.f135009d;
                if (i16 != Integer.MIN_VALUE) {
                    while (position < limit) {
                        this.f135010e.put(byteBuffer.get(position + 1));
                        this.f135010e.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else if (i16 == 3) {
                    while (position < limit) {
                        this.f135010e.put((byte) 0);
                        this.f135010e.put((byte) ((byteBuffer.get(position) & 255) - 128));
                        position++;
                    }
                } else {
                    if (i16 != 1073741824) {
                        throw new IllegalStateException();
                    }
                    while (position < limit) {
                        this.f135010e.put(byteBuffer.get(position + 2));
                        this.f135010e.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                this.f135010e.flip();
                this.f135011f = this.f135010e;
            }
            throw new IllegalStateException();
        }
        i3 = i17 * 2;
        if (this.f135010e.capacity() >= i3) {
        }
        i16 = this.f135009d;
        if (i16 != Integer.MIN_VALUE) {
        }
        byteBuffer.position(byteBuffer.limit());
        this.f135010e.flip();
        this.f135011f = this.f135010e;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f135011f;
        this.f135011f = d.f134912a;
        return byteBuffer;
    }
}
