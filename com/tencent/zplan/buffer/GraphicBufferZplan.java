package com.tencent.zplan.buffer;

import android.hardware.HardwareBuffer;
import com.epicgames.ue4.Logger;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GraphicBufferZplan {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f385231a;

    /* renamed from: b, reason: collision with root package name */
    public static Logger f385232b;

    static {
        System.loadLibrary("zplan-android");
        f385231a = true;
        f385232b = new Logger("UE4", "UE4");
    }

    private static native boolean nativeBindGLTexture(long j3, int i3);

    private static native int nativeCreateFence();

    private static native long nativeFromHardwareBuffer(HardwareBuffer hardwareBuffer);

    private static native long nativeFromTexture(int i3, int i16, int i17);

    private static native HardwareBuffer nativeGetHardwareBuffer(long j3);

    private static native void nativeRelease(long j3);

    private static native void nativeSavePng(long j3, String str);

    private static native void nativeSetFenceEnable(boolean z16);

    private static native boolean nativeSupport();

    private static native boolean nativeWaitFence(int i3);
}
