package com.gyailib.library;

/* loaded from: classes2.dex */
public class ValidFacePhotoQuality {
    public int expressionValid;
    public int lightingOverExposure;
    public int lightingUnderExposure;
    public int poseValid;

    public void setValidFacePhotoQuality(int i3, int i16, int i17, int i18) {
        this.lightingUnderExposure = i3;
        this.lightingOverExposure = i16;
        this.poseValid = i17;
        this.expressionValid = i18;
    }
}
