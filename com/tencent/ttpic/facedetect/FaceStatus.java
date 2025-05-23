package com.tencent.ttpic.facedetect;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceStatus {
    public int age;
    public float[] denseFaceModel;
    public float[] expressionWeights;
    public float[] eyeEulerAngle;
    public float[] eyeRollWeights;
    public long faceID;
    public int gender;
    public int illumination_score;
    public float pitch;
    public float roll;
    public float[] rotationMatrix;
    public float scale;
    public float[] transform;

    /* renamed from: tx, reason: collision with root package name */
    public float f381696tx;

    /* renamed from: ty, reason: collision with root package name */
    public float f381697ty;
    public float[] xys256;
    public float yaw;
    public float[] xys = new float[188];
    public float[] points86 = new float[172];
    public float[] pointVis = new float[94];
    public float[] faceRect = new float[4];
}
