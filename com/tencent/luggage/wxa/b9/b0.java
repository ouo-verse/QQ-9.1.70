package com.tencent.luggage.wxa.b9;

import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f122152a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f122153b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f122154c = new SparseArray();

    @Override // com.tencent.luggage.wxa.b9.h
    public ByteBuffer a(int i3, boolean z16) {
        ByteBuffer byteBuffer;
        synchronized (this) {
            byteBuffer = (ByteBuffer) this.f122154c.get(i3);
            this.f122154c.remove(i3);
        }
        if (byteBuffer == null) {
            com.tencent.luggage.wxa.tn.w.b("V8EngineBufferStore", "getBuffer:%d not contains", Integer.valueOf(i3));
            return null;
        }
        com.tencent.luggage.wxa.tn.w.d("V8EngineBufferStore", "getBuffer:%d remains[%d]", Integer.valueOf(i3), Integer.valueOf(this.f122153b.addAndGet(-byteBuffer.capacity())));
        return byteBuffer;
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public boolean e() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public int f() {
        int addAndGet;
        synchronized (this) {
            addAndGet = this.f122152a.addAndGet(1);
            this.f122154c.put(addAndGet, null);
        }
        com.tencent.luggage.wxa.tn.w.d("V8EngineBufferStore", "generateId:%d", Integer.valueOf(addAndGet));
        return addAndGet;
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public void a(int i3, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return;
        }
        ByteBuffer a16 = com.tencent.luggage.wxa.uk.c0.a(byteBuffer);
        if (!a16.isDirect()) {
            com.tencent.luggage.wxa.tn.w.d("V8EngineBufferStore", "setBuffer:%d cannot convert to direct buffer", Integer.valueOf(i3));
            return;
        }
        synchronized (this) {
            if (this.f122154c.indexOfKey(i3) < 0) {
                com.tencent.luggage.wxa.tn.w.d("V8EngineBufferStore", "setBuffer:%d not contains", Integer.valueOf(i3));
            } else {
                this.f122154c.put(i3, a16);
                com.tencent.luggage.wxa.tn.w.d("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", Integer.valueOf(i3), Boolean.valueOf(byteBuffer.isDirect()), Integer.valueOf(this.f122153b.addAndGet(byteBuffer.capacity())));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public void a(long j3, long j16) {
        com.tencent.luggage.wxa.tn.w.b("V8EngineBufferStore", "no bind to here");
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            throw new IllegalStateException("[bufferStoreBindTo] must check support in advance.");
        }
    }
}
