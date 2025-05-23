package com.tencent.youtu.ytposedetect.data;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class PoseDetectData {
    static IPatchRedirector $redirector_;
    public int faceDetectStatus;
    public int faceQualityStatus;
    public Rect faceRect;
    public float[] faceShape;
    public float[] faceVisible;
    public int frameH;
    public int frameW;
    public byte[] imgData;
    public boolean isFaceShaking;
    public float pitch;
    public int postType;
    public float roll;
    public float yaw;

    public PoseDetectData(float[] fArr, float[] fArr2, int i3, byte[] bArr, float f16, float f17, float f18, int i16, int i17, Rect rect, int i18, int i19, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fArr, fArr2, Integer.valueOf(i3), bArr, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Integer.valueOf(i16), Integer.valueOf(i17), rect, Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16));
            return;
        }
        this.faceShape = fArr;
        this.faceVisible = fArr2;
        this.postType = i3;
        this.imgData = bArr;
        this.pitch = f16;
        this.yaw = f17;
        this.roll = f18;
        this.faceDetectStatus = i16;
        this.faceQualityStatus = i17;
        this.faceRect = rect;
        this.frameW = i18;
        this.frameH = i19;
        this.isFaceShaking = z16;
    }
}
