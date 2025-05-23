package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.model.bloodoxygensaturation.BloodOxygenSaturation;

@Keep
/* loaded from: classes2.dex */
public class BloodOxygenSaturationProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<BloodOxygenSaturationProxy> CREATOR = new Parcelable.Creator<BloodOxygenSaturationProxy>() { // from class: com.heytap.databaseengine.model.proxy.BloodOxygenSaturationProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloodOxygenSaturationProxy createFromParcel(Parcel parcel) {
            return new BloodOxygenSaturationProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloodOxygenSaturationProxy[] newArray(int i3) {
            return new BloodOxygenSaturationProxy[i3];
        }
    };
    private int bloodOxygenSaturationValue;
    private long dataCreatedTimestamp;

    public BloodOxygenSaturationProxy(@NonNull BloodOxygenSaturation bloodOxygenSaturation) {
        this.dataCreatedTimestamp = bloodOxygenSaturation.getDataCreatedTimestamp();
        this.bloodOxygenSaturationValue = bloodOxygenSaturation.getBloodOxygenSaturationValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDataCreatedTime() {
        return this.dataCreatedTimestamp;
    }

    public int getSpO2() {
        return this.bloodOxygenSaturationValue;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "BloodOxygenSaturationProxy:\ndataCreatedTime=" + getDataCreatedTime() + "\nSpO2=" + getSpO2() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.dataCreatedTimestamp);
        parcel.writeInt(this.bloodOxygenSaturationValue);
    }

    protected BloodOxygenSaturationProxy(Parcel parcel) {
        this.dataCreatedTimestamp = parcel.readLong();
        this.bloodOxygenSaturationValue = parcel.readInt();
    }
}
