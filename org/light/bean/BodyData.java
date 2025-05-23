package org.light.bean;

import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BodyData {
    public float[] points;

    public BodyData() {
    }

    public BodyData(Parcel parcel) {
        this.points = parcel.createFloatArray();
    }
}
