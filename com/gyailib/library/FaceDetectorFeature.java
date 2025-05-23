package com.gyailib.library;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FaceDetectorFeature {
    public int boundsH;
    public int boundsW;
    public int boundsX;
    public int boundsY;
    public float[] fFeatures;
    public float[] fFeatures256;
    public float[] fFeaturesYoutuOriginX;
    public float[] fFeaturesYoutuOriginY;
    Face3DResult facekit3DResult;
    FaceDetectorFeaturePerspective featurePerspective;
    public boolean hasOutline;
    public float imageHeight;
    public float imageWidth;
    public int leBoundsH;
    public int leBoundsW;
    public int leBoundsX;
    public int leBoundsY;
    public int mouthBoundsH;
    public int mouthBoundsW;
    public int mouthBoundsX;
    public int mouthBoundsY;
    public float pitch;
    public float[] points256Visibility;
    public float[] pointsVisibility;
    public int reBoundsH;
    public int reBoundsW;
    public int reBoundsX;
    public int reBoundsY;
    public float roll;
    public int traceId;
    public float yaw;
    public float[] youtuVisibility;

    public FaceDetectorFeature(int i3, float f16, float f17, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, boolean z16, float f18, float f19, float f26, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6, float[] fArr7, FaceDetectorFeaturePerspective faceDetectorFeaturePerspective, Face3DResult face3DResult) {
        this.traceId = i3;
        this.imageWidth = f16;
        this.imageHeight = f17;
        this.boundsX = i16;
        this.boundsY = i17;
        this.boundsW = i18;
        this.boundsH = i19;
        this.leBoundsX = i26;
        this.leBoundsY = i27;
        this.leBoundsW = i28;
        this.leBoundsH = i29;
        this.reBoundsX = i36;
        this.reBoundsY = i37;
        this.reBoundsW = i38;
        this.reBoundsH = i39;
        this.mouthBoundsX = i46;
        this.mouthBoundsY = i47;
        this.mouthBoundsW = i48;
        this.mouthBoundsH = i49;
        this.hasOutline = z16;
        this.pitch = f18;
        this.yaw = f19;
        this.roll = f26;
        this.fFeaturesYoutuOriginX = fArr;
        this.fFeaturesYoutuOriginY = fArr2;
        this.youtuVisibility = fArr3;
        this.pointsVisibility = fArr4;
        this.points256Visibility = fArr6;
        this.fFeatures = fArr5;
        this.fFeatures256 = fArr7;
        this.featurePerspective = faceDetectorFeaturePerspective;
        this.facekit3DResult = face3DResult;
    }
}
