package com.tencent.ttpic.openapi.facedetect;

import android.graphics.PointF;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceInfo {
    public int age;
    public int curGender;
    public float[] denseFaceModel;
    public float[] expressionWeights;
    public float[] eyeEulerAngle;
    public long faceId;
    public int gender;
    public List<PointF> irisPoints;
    public float[] orig256FacePoints;
    public float pitch;
    public List<PointF> point94;
    public List<PointF> points;
    public Float[] pointsVis;
    public float roll;
    public float scale;
    public float[] transform;

    /* renamed from: tx, reason: collision with root package name */
    public float f381699tx;

    /* renamed from: ty, reason: collision with root package name */
    public float f381700ty;
    public float yaw;
    public float[] origFacePoints = new float[188];
    public float[] origPointsVis = new float[94];
    public float[] rect = new float[4];
    public float[] angles = new float[3];
    public float[] eyeRollWeights = new float[3];
}
