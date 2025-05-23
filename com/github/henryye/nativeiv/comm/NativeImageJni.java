package com.github.henryye.nativeiv.comm;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.h.b;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NativeImageJni {

    /* renamed from: a, reason: collision with root package name */
    public long f32885a = 0;

    static {
        b.a("NativeImageJni", "load library", new Object[0]);
        com.tencent.luggage.wxa.h.a.a("native-iv");
    }

    @Keep
    private native CommNativeBitmapStruct nativeDecodeNative(long j3, ByteBuffer byteBuffer, int i3, boolean z16);

    @Keep
    private native void nativeDestroy(long j3);

    @Keep
    private native long nativeInit();

    @Keep
    private native void nativeRecycleNative(long j3, long j16);

    public void a() {
        long j3 = this.f32885a;
        if (j3 != 0) {
            nativeDestroy(j3);
        }
    }

    public void b() {
        if (this.f32885a == 0) {
            this.f32885a = nativeInit();
            return;
        }
        throw new IllegalStateException("NativeImageJni not released last time");
    }

    public void a(long j3) {
        long j16 = this.f32885a;
        if (j16 != 0) {
            nativeRecycleNative(j16, j3);
        }
    }

    public CommNativeBitmapStruct a(ByteBuffer byteBuffer, int i3, boolean z16) {
        long j3 = this.f32885a;
        if (j3 != 0) {
            return nativeDecodeNative(j3, byteBuffer, i3, z16);
        }
        return null;
    }
}
