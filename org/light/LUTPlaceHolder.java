package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes29.dex */
public class LUTPlaceHolder implements Parcelable {
    public static final Parcelable.Creator<LUTPlaceHolder> CREATOR = new Parcelable.Creator<LUTPlaceHolder>() { // from class: org.light.LUTPlaceHolder.1
        @Override // android.os.Parcelable.Creator
        public LUTPlaceHolder createFromParcel(Parcel parcel) {
            return new LUTPlaceHolder(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LUTPlaceHolder[] newArray(int i3) {
            return new LUTPlaceHolder[i3];
        }
    };
    public float intensity;
    public String key;
    public String path;

    public LUTPlaceHolder(String str, String str2, float f16) {
        this.key = str;
        this.path = str2;
        this.intensity = f16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.key);
        parcel.writeString(this.path);
        parcel.writeFloat(this.intensity);
    }

    protected LUTPlaceHolder(Parcel parcel) {
        this.key = "";
        this.path = "";
        this.intensity = 1.0f;
        this.key = parcel.readString();
        this.path = parcel.readString();
        this.intensity = parcel.readFloat();
    }
}
