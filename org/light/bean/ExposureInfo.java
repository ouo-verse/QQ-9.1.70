package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExposureInfo implements Parcelable {
    public static final Parcelable.Creator<ExposureInfo> CREATOR = new Parcelable.Creator<ExposureInfo>() { // from class: org.light.bean.ExposureInfo.1
        @Override // android.os.Parcelable.Creator
        public ExposureInfo createFromParcel(Parcel parcel) {
            return new ExposureInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ExposureInfo[] newArray(int i3) {
            return new ExposureInfo[i3];
        }
    };
    public long exposureTime;
    public int iso;

    public ExposureInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.iso = parcel.readInt();
        this.exposureTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.iso);
        parcel.writeLong(this.exposureTime);
    }

    protected ExposureInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
