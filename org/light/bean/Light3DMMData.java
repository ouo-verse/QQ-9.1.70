package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Light3DMMData implements Parcelable {
    public static final Parcelable.Creator<Light3DMMData> CREATOR = new Parcelable.Creator<Light3DMMData>() { // from class: org.light.bean.Light3DMMData.1
        @Override // android.os.Parcelable.Creator
        public Light3DMMData createFromParcel(Parcel parcel) {
            return new Light3DMMData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Light3DMMData[] newArray(int i3) {
            return new Light3DMMData[i3];
        }
    };
    List<Light3DMMFeature> light3DMMFeatures;

    public Light3DMMData(List<Light3DMMFeature> list) {
        this.light3DMMFeatures = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Light3DMMFeature> getLight3dmmFeatures() {
        return this.light3DMMFeatures;
    }

    public void readFromParcel(Parcel parcel) {
        this.light3DMMFeatures = parcel.createTypedArrayList(Light3DMMFeature.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.light3DMMFeatures);
    }

    protected Light3DMMData(Parcel parcel) {
        this.light3DMMFeatures = parcel.createTypedArrayList(Light3DMMFeature.CREATOR);
    }
}
