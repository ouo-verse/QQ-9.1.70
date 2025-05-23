package org.light.bean;

import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FaceData {
    public float[] points;

    public FaceData() {
    }

    public FaceData(Parcel parcel) {
        this.points = parcel.createFloatArray();
    }
}
