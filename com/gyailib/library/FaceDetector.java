package com.gyailib.library;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FaceDetector {
    public FaceDetectorFeature[] faces;

    public void initStruct(int i3) {
        this.faces = new FaceDetectorFeature[i3];
    }

    public void setFaceDetectFeature(int i3, FaceDetectorFeature faceDetectorFeature) {
        if (faceDetectorFeature == null) {
            return;
        }
        this.faces[i3] = faceDetectorFeature;
    }
}
