package com.tencent.rlottie;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AXrLottieNative {
    static IPatchRedirector $redirector_;

    public AXrLottieNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native void clearDir(String str, long j3, boolean z16);

    public static native void configureModelCacheSize(int i3);

    public static native long create(String str, int i3, int i16, int[] iArr, boolean z16, boolean z17, String str2);

    public static native void createCache(long j3, int i3, int i16);

    public static native long createWithJson(String str, String str2, int[] iArr);

    public static native void destroy(long j3);

    public static native long getDirSize(String str, boolean z16);

    public static native long getFileCount(String str, boolean z16);

    public static native int getFrame(long j3, int i3, Bitmap bitmap, int i16, int i17, int i18);
}
