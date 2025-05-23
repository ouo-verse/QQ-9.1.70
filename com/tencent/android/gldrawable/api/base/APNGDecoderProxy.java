package com.tencent.android.gldrawable.api.base;

import android.graphics.Bitmap;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.image.ApngImage;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class APNGDecoderProxy {
    public static final int NOT_VALID_FRAME = -1;
    private static Method nativeFreeFrame;
    private static Method nativeFreeImage;
    private static Method nativeGetNextFrame;
    private static Method nativeStartDecode;

    static {
        try {
            System.loadLibrary("APNG");
        } catch (Throwable th5) {
            GLDrawableApi.config().log("can not find libAPNG.so", th5);
        }
        try {
            int i3 = ApngImage.DENSITY_NONE;
            Class cls = Long.TYPE;
            Method declaredMethod = ApngImage.class.getDeclaredMethod("nativeGetNextFrame", cls, cls, Bitmap.class, int[].class);
            nativeGetNextFrame = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = ApngImage.class.getDeclaredMethod("nativeStartDecode", String.class, int[].class, Integer.TYPE);
            nativeStartDecode = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = ApngImage.class.getDeclaredMethod("nativeFreeImage", cls);
            nativeFreeImage = declaredMethod3;
            declaredMethod3.setAccessible(true);
            Method declaredMethod4 = ApngImage.class.getDeclaredMethod("nativeFreeFrame", cls);
            nativeFreeFrame = declaredMethod4;
            declaredMethod4.setAccessible(true);
        } catch (Throwable th6) {
            GLDrawableApi.config().log("can not find method", th6);
        }
    }

    public static void freeFrame(long j3) {
        try {
            nativeFreeFrame.invoke(null, Long.valueOf(j3));
        } catch (Throwable th5) {
            GLDrawableApi.config().log("freeFrame", th5);
        }
    }

    public static void freeImage(long j3) {
        try {
            nativeFreeImage.invoke(null, Long.valueOf(j3));
        } catch (Throwable th5) {
            GLDrawableApi.config().log("freeImage", th5);
        }
    }

    public static long getNextFrame(long j3, long j16, Bitmap bitmap, int[] iArr) {
        try {
            return ((Long) nativeGetNextFrame.invoke(null, Long.valueOf(j3), Long.valueOf(j16), bitmap, iArr)).longValue();
        } catch (Throwable th5) {
            GLDrawableApi.config().log("getNextFrame", th5);
            return -1L;
        }
    }

    public static long startDecode(String str, int[] iArr, int i3) {
        try {
            return ((Long) nativeStartDecode.invoke(null, str, iArr, Integer.valueOf(i3))).longValue();
        } catch (Throwable th5) {
            GLDrawableApi.config().log("startDecode", th5);
            return -1L;
        }
    }
}
