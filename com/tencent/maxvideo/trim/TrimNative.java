package com.tencent.maxvideo.trim;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TrimNative {
    static IPatchRedirector $redirector_;

    public TrimNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native int detect(String str);

    public static native int getFrame(long j3, long j16, Bitmap bitmap);

    public static native String getRealProperties(String str, int i3, int i16);

    public static native int getThumbnail(long j3, long j16, Bitmap bitmap);

    public static native int initGetFrame(String str, int i3, int i16);

    public static native boolean isGetFrameReady();

    public static native boolean isGetThumbnailReady();

    public static native int prepare(String str, int i3, int i16, int i17, int i18, int i19, int i26);

    public static native void release();

    public static native int trim(String[] strArr);
}
