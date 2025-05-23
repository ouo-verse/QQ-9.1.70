package org.light;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WatermarkReplacement implements Parcelable, Serializable {
    public static final Parcelable.Creator<WatermarkReplacement> CREATOR = new Parcelable.Creator<WatermarkReplacement>() { // from class: org.light.WatermarkReplacement.1
        @Override // android.os.Parcelable.Creator
        public WatermarkReplacement createFromParcel(Parcel parcel) {
            return new WatermarkReplacement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WatermarkReplacement[] newArray(int i3) {
            return new WatermarkReplacement[i3];
        }
    };
    public static final int WatermarkReplaceTypeImage = 1;
    public static final int WatermarkReplaceTypeText = 0;
    public int index;
    public int type;
    public String value;

    public WatermarkReplacement() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.index);
        parcel.writeInt(this.type);
        parcel.writeString(this.value);
    }

    public WatermarkReplacement(int i3, int i16, String str) {
        this.index = i3;
        this.type = i16;
        this.value = str;
    }

    protected WatermarkReplacement(Parcel parcel) {
        this.index = parcel.readInt();
        this.type = parcel.readInt();
        this.value = parcel.readString();
    }
}
