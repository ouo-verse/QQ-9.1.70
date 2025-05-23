package com.tencent.aelight.camera.ae.play;

import android.graphics.Rect;

/* loaded from: classes32.dex */
public class FaceParam {
    public float[] angles;
    public Rect mFace;

    public FaceParam(int i3, int i16, int i17, int i18) {
        this.mFace = new Rect(i3, i16, i17, i18);
    }

    public int getArea() {
        Rect rect = this.mFace;
        int abs = Math.abs(rect.left - rect.right);
        Rect rect2 = this.mFace;
        return abs * Math.abs(rect2.top - rect2.bottom);
    }
}
