package com.gyailib.library;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Face3DResult {
    public float[] euler;
    public float[] exp;
    public int facekitVertexNum;
    public float[] facekitVertices;
    public float pointScale;
    public float scale;
    public int traceId;
    public float[] transMatrix;
    public float[] translate;

    public Face3DResult(int i3, float[] fArr, float[] fArr2, float[] fArr3, float f16, float f17, float[] fArr4, int i16, float[] fArr5) {
        this.traceId = i3;
        this.transMatrix = fArr;
        this.euler = fArr2;
        this.translate = fArr3;
        this.scale = f16;
        this.pointScale = f17;
        this.exp = fArr4;
        this.facekitVertexNum = i16;
        this.facekitVertices = fArr5;
    }
}
