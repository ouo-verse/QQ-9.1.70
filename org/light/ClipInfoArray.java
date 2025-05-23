package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClipInfoArray implements Parcelable {
    public static final Parcelable.Creator<ClipInfoArray> CREATOR = new Parcelable.Creator<ClipInfoArray>() { // from class: org.light.ClipInfoArray.1
        @Override // android.os.Parcelable.Creator
        public ClipInfoArray createFromParcel(Parcel parcel) {
            return new ClipInfoArray(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ClipInfoArray[] newArray(int i3) {
            return new ClipInfoArray[i3];
        }
    };
    public ClipInfo[] infoArray;

    public ClipInfoArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedArray(this.infoArray, i3);
    }

    protected ClipInfoArray(Parcel parcel) {
        this.infoArray = (ClipInfo[]) parcel.createTypedArray(ClipInfo.CREATOR);
    }
}
