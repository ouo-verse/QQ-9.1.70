package org.light;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WatermarkConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<WatermarkConfig> CREATOR = new Parcelable.Creator<WatermarkConfig>() { // from class: org.light.WatermarkConfig.1
        @Override // android.os.Parcelable.Creator
        public WatermarkConfig createFromParcel(Parcel parcel) {
            return new WatermarkConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WatermarkConfig[] newArray(int i3) {
            return new WatermarkConfig[i3];
        }
    };
    public RectF bounds;
    public String materialPath;
    public WatermarkReplacement[] replacements;

    public WatermarkConfig() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.materialPath);
        parcel.writeTypedArray(this.replacements, i3);
        parcel.writeParcelable(this.bounds, i3);
    }

    public WatermarkConfig(String str) {
        this.replacements = new WatermarkReplacement[]{new WatermarkReplacement(0, 0, str)};
    }

    protected WatermarkConfig(Parcel parcel) {
        this.materialPath = parcel.readString();
        this.replacements = (WatermarkReplacement[]) parcel.createTypedArray(WatermarkReplacement.CREATOR);
        this.bounds = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }
}
