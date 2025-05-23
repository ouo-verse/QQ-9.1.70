package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes29.dex */
public class LightAIKeyPoint implements Parcelable {
    public static final Parcelable.Creator<LightAIKeyPoint> CREATOR = new Parcelable.Creator<LightAIKeyPoint>() { // from class: org.light.bean.LightAIKeyPoint.1
        @Override // android.os.Parcelable.Creator
        public LightAIKeyPoint createFromParcel(Parcel parcel) {
            return new LightAIKeyPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightAIKeyPoint[] newArray(int i3) {
            return new LightAIKeyPoint[i3];
        }
    };
    float[] aiPoints;
    int traceId;

    public LightAIKeyPoint(int i3, float[] fArr) {
        this.traceId = i3;
        this.aiPoints = fArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float[] getAiPoints() {
        return this.aiPoints;
    }

    public int getTraceId() {
        return this.traceId;
    }

    public void readFromParcel(Parcel parcel) {
        this.traceId = parcel.readInt();
        this.aiPoints = parcel.createFloatArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.traceId);
        parcel.writeFloatArray(this.aiPoints);
    }

    protected LightAIKeyPoint(Parcel parcel) {
        this.aiPoints = new float[80];
        this.traceId = parcel.readInt();
        this.aiPoints = parcel.createFloatArray();
    }
}
