package com.tencent.map.sdk.utilities.heatmap;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeightedLatLng extends com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng {
    public static final Parcelable.Creator<WeightedLatLng> CREATOR = new Parcelable.Creator<WeightedLatLng>() { // from class: com.tencent.map.sdk.utilities.heatmap.WeightedLatLng.1
        private static WeightedLatLng a(@NonNull Parcel parcel) {
            return new WeightedLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WeightedLatLng createFromParcel(@NonNull Parcel parcel) {
            return new WeightedLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WeightedLatLng[] newArray(int i3) {
            return new WeightedLatLng[i3];
        }

        private static WeightedLatLng[] a(int i3) {
            return new WeightedLatLng[i3];
        }
    };

    protected WeightedLatLng(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof WeightedLatLng)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        LatLng point = getPoint();
        double intensity = getIntensity();
        if (point != null) {
            WeightedLatLng weightedLatLng = (WeightedLatLng) obj;
            if (!point.equals(weightedLatLng.getPoint()) || intensity != weightedLatLng.getIntensity()) {
                return false;
            }
            return true;
        }
        WeightedLatLng weightedLatLng2 = (WeightedLatLng) obj;
        if (weightedLatLng2.getPoint() != null || intensity != weightedLatLng2.getIntensity()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
    }

    public WeightedLatLng(LatLng latLng, double d16) {
        super(latLng, d16);
    }

    public WeightedLatLng(LatLng latLng) {
        super(latLng);
    }
}
