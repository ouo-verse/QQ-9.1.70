package com.tencent.mm.appbrand.v8;

import com.tencent.luggage.wxa.b9.e0;
import com.tencent.luggage.wxa.b9.h;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NativeBufferJNI implements h {

    /* renamed from: a, reason: collision with root package name */
    public long f151686a = nativeCreate();

    static {
        e0.a();
    }

    private native void nativeBindTo(long j3, long j16, long j17);

    private native long nativeCreate();

    private native void nativeDestroy(long j3);

    private native int nativeGenerateId(long j3);

    private native byte[] nativeGetBuffer(long j3, int i3);

    private native ByteBuffer nativeGetDirectBuffer(long j3, int i3);

    private native void nativeSetBuffer(long j3, int i3, ByteBuffer byteBuffer);

    private native void nativeSetBufferForLegacyArray(long j3, int i3, byte[] bArr, int i16);

    @Override // com.tencent.luggage.wxa.b9.h
    public ByteBuffer a(int i3, boolean z16) {
        if (z16) {
            return nativeGetDirectBuffer(this.f151686a, i3);
        }
        byte[] nativeGetBuffer = nativeGetBuffer(this.f151686a, i3);
        if (nativeGetBuffer == null) {
            return null;
        }
        return ByteBuffer.wrap(nativeGetBuffer);
    }

    public void b(long j3, long j16) {
        nativeBindTo(this.f151686a, j3, j16);
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public boolean e() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public int f() {
        return nativeGenerateId(this.f151686a);
    }

    public void finalize() {
        super.finalize();
        long j3 = this.f151686a;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.f151686a = 0L;
        }
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public void a(long j3, long j16) {
        b(j3, j16);
    }

    @Override // com.tencent.luggage.wxa.b9.h
    public void a(int i3, ByteBuffer byteBuffer) {
        if (byteBuffer == null || byteBuffer.capacity() == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            nativeSetBuffer(this.f151686a, i3, byteBuffer);
        } else {
            byte[] array = byteBuffer.array();
            nativeSetBufferForLegacyArray(this.f151686a, i3, array, array.length);
        }
    }
}
