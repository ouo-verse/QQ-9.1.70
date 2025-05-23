package com.tencent.tar.jni;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TARMarkerNative {
    static IPatchRedirector $redirector_;

    public TARMarkerNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native int odDetect(int i3, int i16, byte[] bArr, boolean z16, int[] iArr);

    private static native int odInit(String str);

    private static native int odRelease();

    private static native int odResetCfd();

    private static native int tarAddCloudMarker(int i3, String str, String str2, String str3, byte[] bArr, int i16, float[] fArr, int i17, String str4, int[] iArr, boolean z16);

    private static native int tarAddMarker(int i3, String str, String str2, String str3, int[] iArr);

    private static native int tarAddMarkerBinary(int i3, String str, String str2, String str3, byte[] bArr, int i16, int[] iArr);

    private static native int tarAddMarkerBinaryRegen(int i3, String str, String str2, String str3, byte[] bArr, int i16, int[] iArr, boolean z16);

    private static native int tarAddMarkerRegen(int i3, String str, String str2, String str3, int[] iArr, boolean z16);

    private static native int tarDelMarker(int i3, int[] iArr);

    private static native int tarDetectFace(int i3, int i16, byte[] bArr, boolean z16, float[] fArr, int[] iArr);

    private static native void tarFaceRelease();

    private static native void tarFaceSetMin(float f16);

    private static native void tarFaceSetThreadNum(int i3);

    private static native void tarFaceSetup(String str);

    private static native int tarGenerateFeature(String str, String str2, byte[] bArr, int i3);

    private static native int tarGetAction(int i3, int[] iArr, int i16, float[] fArr, boolean z16, float[] fArr2);

    private static native int tarGetFacialPoint(int i3, float[] fArr, float[] fArr2, int[] iArr);

    private static native int tarGetMarkerTransform(int i3, float[] fArr);

    private static native int tarGetMarkerTransformAndScreenV(int i3, float[] fArr, float[] fArr2);

    private static native int tarGetProjectionMatrix(int i3, int i16, float f16, float f17, float[] fArr);

    private static native int tarGetProjectionMatrixEx(int i3, int i16, int i17, float f16, float f17, float[] fArr);

    private static native int tarGetSDKRunStatusInfo(int i3, int[] iArr);

    private static native String tarGetVersion();

    private static native int tarInitialize(String str, int i3, int i16, int[] iArr);

    private static native int tarObjectFeatureDetect(int i3, int i16, byte[] bArr, boolean z16, int[] iArr, int[] iArr2);

    private static native int tarObjectMotionDetect(int i3, int i16, byte[] bArr, boolean z16, int[] iArr);

    private static native int tarOnFrame(int i3, int i16, byte[] bArr, boolean z16);

    private static native boolean tarProfilerSupported();

    private static native int tarRelease();

    private static native int tarReset(String str, int i3, int i16, boolean z16, int[] iArr);

    private static native int tarScanFilter(int i3, int i16, byte[] bArr, boolean z16, String str, byte[] bArr2);

    private static native void tarSetCfgKeyValue(String str, String str2);

    private static native void tarSetConfig(int i3, int i16);

    private static native void tarSetFrameMode(int i3);

    private static native void tarSetLogCallback();

    private static native int tarSetMarkerStatus(int i3, boolean z16, int[] iArr, int[] iArr2);

    private static native int tarSmartMotionDetect(int i3, int i16, byte[] bArr, boolean z16, int[] iArr, int[] iArr2);

    private static native void tarStartProfiler();

    private static native void tarStopProfiler();

    private static native int tarTrackFace(int i3, int i16, byte[] bArr, boolean z16, float[] fArr, int[] iArr);
}
