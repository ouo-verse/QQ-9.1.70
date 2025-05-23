package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LUTAsset implements Parcelable {
    public static final Parcelable.Creator<LUTAsset> CREATOR = new Parcelable.Creator<LUTAsset>() { // from class: org.light.LUTAsset.1
        @Override // android.os.Parcelable.Creator
        public LUTAsset createFromParcel(Parcel parcel) {
            return new LUTAsset(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LUTAsset[] newArray(int i3) {
            return new LUTAsset[i3];
        }
    };
    float intensity;
    public String path;

    public LUTAsset(String str, float f16) {
        this.path = str;
        this.intensity = f16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.path);
        parcel.writeFloat(this.intensity);
    }

    protected LUTAsset(Parcel parcel) {
        this.path = parcel.readString();
        this.intensity = parcel.readFloat();
    }
}
