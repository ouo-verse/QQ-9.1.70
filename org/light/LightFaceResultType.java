package org.light;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum LightFaceResultType {
    LightFaceDetectQualified(0),
    LightFaceDetectFailed(1),
    LightFaceDetectNoFace(2),
    LightFaceDetectSensitivePersonError(3),
    LightFaceDetectPositionError(4),
    LightFaceDetectDirectionError(5),
    LightFaceDetectMinFaceSizeError(6),
    LightFaceDetectMinFaceCountError(7),
    LightFaceDetectMaxFaceCountError(8);

    private int value;

    LightFaceResultType(int i3) {
        this.value = i3;
    }

    private int getValue() {
        return this.value;
    }
}
