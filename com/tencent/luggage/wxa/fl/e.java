package com.tencent.luggage.wxa.fl;

import com.tencent.luggage.wxa.fl.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements c {

    /* renamed from: e, reason: collision with root package name */
    public static byte[] f126250e = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public boolean f126251a;

    /* renamed from: b, reason: collision with root package name */
    public d.a f126252b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f126253c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f126254d;

    public e() {
    }

    @Override // com.tencent.luggage.wxa.fl.c
    public void a(boolean z16) {
        this.f126251a = z16;
    }

    @Override // com.tencent.luggage.wxa.fl.d
    public boolean b() {
        return this.f126254d;
    }

    @Override // com.tencent.luggage.wxa.fl.d
    public d.a c() {
        return this.f126252b;
    }

    @Override // com.tencent.luggage.wxa.fl.d
    public boolean d() {
        return this.f126251a;
    }

    @Override // com.tencent.luggage.wxa.fl.d
    public ByteBuffer f() {
        return this.f126253c;
    }

    public String toString() {
        return "Framedata{ optcode:" + c() + ", fin:" + d() + ", payloadlength:[pos:" + this.f126253c.position() + ", len:" + this.f126253c.remaining() + "], payload:" + Arrays.toString(com.tencent.luggage.wxa.hl.b.b(new String(this.f126253c.array()))) + "}";
    }

    public e(d.a aVar) {
        this.f126252b = aVar;
        this.f126253c = ByteBuffer.wrap(f126250e);
    }

    @Override // com.tencent.luggage.wxa.fl.c
    public void a(d.a aVar) {
        this.f126252b = aVar;
    }

    @Override // com.tencent.luggage.wxa.fl.c
    public void b(boolean z16) {
        this.f126254d = z16;
    }

    @Override // com.tencent.luggage.wxa.fl.c
    public void a(ByteBuffer byteBuffer) {
        this.f126253c = byteBuffer;
    }

    @Override // com.tencent.luggage.wxa.fl.d
    public void a(d dVar) {
        ByteBuffer f16 = dVar.f();
        if (this.f126253c == null) {
            this.f126253c = ByteBuffer.allocate(f16.remaining());
            f16.mark();
            this.f126253c.put(f16);
            f16.reset();
        } else {
            f16.mark();
            ByteBuffer byteBuffer = this.f126253c;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f126253c;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (f16.remaining() > this.f126253c.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(f16.remaining() + this.f126253c.capacity());
                this.f126253c.flip();
                allocate.put(this.f126253c);
                allocate.put(f16);
                this.f126253c = allocate;
            } else {
                this.f126253c.put(f16);
            }
            this.f126253c.rewind();
            f16.reset();
        }
        this.f126251a = dVar.d();
    }

    public e(d dVar) {
        this.f126251a = dVar.d();
        this.f126252b = dVar.c();
        this.f126253c = dVar.f();
        this.f126254d = dVar.b();
    }
}
