package com.tencent.oskplayer.contrib;

import android.graphics.Bitmap;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.support.log.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ImageHash {
    public static final int HASH_ERROR = 0;
    public static final String LOG_TAG = "ImageHash";
    public static final int MSE = 3;
    public static final int OHASH = 2;
    public static final int PHASH = 1;
    private static final NativeLibLoader sLocalLibLoader = new DefaultNativeLibLoader();
    private static Object sIsNativeLibReady = null;
    public static volatile boolean sIsLibLoadSuccess = false;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes34.dex */
    public @interface HashAlgorithm {
    }

    public static native int findClass(String str);

    public static native long getHammingDistance(long j3, long j16);

    public static native long getHash(Bitmap bitmap, int i3);

    public static long getPHash(Bitmap bitmap) {
        if (sIsLibLoadSuccess) {
            return getHash(bitmap, 1);
        }
        return 0L;
    }

    public static boolean isNativeLibReady(NativeLibLoader nativeLibLoader) {
        synchronized (ImageHash.class) {
            if (nativeLibLoader == null) {
                nativeLibLoader = sLocalLibLoader;
            }
            Object obj = sIsNativeLibReady;
            if (obj != null) {
                return ((Boolean) obj).booleanValue();
            }
            boolean z16 = false;
            if (nativeLibLoader == null) {
                return false;
            }
            NativeLibLoader.State isLibReadyToLoad = nativeLibLoader.isLibReadyToLoad("c++_shared");
            NativeLibLoader.State state = NativeLibLoader.State.WAIT;
            if (isLibReadyToLoad != state && nativeLibLoader.isLibReadyToLoad("oskcontrib") != state) {
                NativeLibLoader.State isLibReadyToLoad2 = nativeLibLoader.isLibReadyToLoad("c++_shared");
                NativeLibLoader.State state2 = NativeLibLoader.State.TRUE;
                if (isLibReadyToLoad2 == state2 && nativeLibLoader.isLibReadyToLoad("oskcontrib") == state2) {
                    z16 = true;
                }
                Boolean valueOf = Boolean.valueOf(z16);
                sIsNativeLibReady = valueOf;
                return valueOf.booleanValue();
            }
            return false;
        }
    }

    public static void loadLibrariesOnce(NativeLibLoader nativeLibLoader) {
        synchronized (ImageHash.class) {
            if (!sIsLibLoadSuccess) {
                if (nativeLibLoader == null) {
                    nativeLibLoader = sLocalLibLoader;
                }
                try {
                    nativeLibLoader.loadLibrary("c++_shared");
                    nativeLibLoader.loadLibrary("oskcontrib");
                    sIsLibLoadSuccess = true;
                } catch (Throwable th5) {
                    Logger.g().w(LOG_TAG, "failed to load library mIsLibLoaded=" + sIsLibLoadSuccess);
                    th5.printStackTrace();
                }
                Logger.g().i(LOG_TAG, "library loaded result " + sIsLibLoadSuccess);
            }
        }
    }
}
