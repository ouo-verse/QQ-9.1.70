package com.tencent.mobileqq.qmcf;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QMCF {
    static IPatchRedirector $redirector_;

    public QMCF() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native String getDefaultSign();

    public static native byte[] nDrink(byte[] bArr, int i3, String str);

    public native void ArtDestroy(long j3);

    public native long ArtInit(int i3, int i16, int i17, String str, String str2, String str3);

    public native String ArtProcess(long j3, int i3, int i16);

    public native String ArtSwitchModel(long j3, String str, String str2, String str3);

    public native void BigHeadDestroy(long j3);

    public native long BigHeadInit(int i3, int i16, int i17, String str, String str2, String str3, boolean z16);

    public native String BigHeadProcess(long j3, int i3, int i16);

    public native void PoseDestroy(long j3);

    public native long PoseInit(int i3, int i16, int i17, int i18, int i19, int i26, String str, String str2, String str3);

    public native String PoseProcess(long j3, int i3, int i16);

    public native void getSkeletonPose(long j3, float[] fArr);

    public native int snpeAvaliableType();

    public native String snpeBigHeadDestroy(long j3);

    public native long snpeBigHeadInit(int i3, int i16, String str, String str2, int i17, String str3);

    public native String snpeBigHeadProcess(long j3, int i3, int i16);

    public native String snpePoseInit(int i3, int i16, String str, String str2, int i17, int i18);

    public native String snpePoseProcess(int i3, int i16);

    public native void snpeSkeletonPose(float[] fArr);
}
