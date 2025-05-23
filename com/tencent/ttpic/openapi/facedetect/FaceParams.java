package com.tencent.ttpic.openapi.facedetect;

import android.graphics.PointF;
import com.tencent.facebeauty.FaceParam;
import java.util.List;

/* loaded from: classes27.dex */
public class FaceParams {
    private float[] faceAngles;
    private FaceParam faceParam;
    private List<PointF> facePoints;

    public float[] getFaceAngles() {
        return this.faceAngles;
    }

    public FaceParam getFaceParam() {
        return this.faceParam;
    }

    public List<PointF> getFacePoints() {
        return this.facePoints;
    }

    public void setFaceAngles(float[] fArr) {
        this.faceAngles = fArr;
    }

    public void setFaceParam(FaceParam faceParam) {
        this.faceParam = faceParam;
    }

    public void setFacePoints(List<PointF> list) {
        this.facePoints = list;
    }
}
