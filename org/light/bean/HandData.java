package org.light.bean;

import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HandData {
    public float[] points;

    public HandData() {
        this.points = new float[95];
    }

    public HandData(Parcel parcel) {
        this.points = new float[95];
        this.points = parcel.createFloatArray();
    }
}
