package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.HeartRate;
import com.heytap.databaseengine.model.SportHealthData;

@Keep
/* loaded from: classes2.dex */
public class HeartRateProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<HeartRateProxy> CREATOR = new Parcelable.Creator<HeartRateProxy>() { // from class: com.heytap.databaseengine.model.proxy.HeartRateProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateProxy createFromParcel(Parcel parcel) {
            return new HeartRateProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateProxy[] newArray(int i3) {
            return new HeartRateProxy[i3];
        }
    };
    private long dataCreatedTimestamp;
    private int heartRateValue;

    public HeartRateProxy(@NonNull HeartRate heartRate) {
        this.dataCreatedTimestamp = heartRate.getDataCreatedTimestamp();
        this.heartRateValue = heartRate.getHeartRateValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDataCreatedTime() {
        return this.dataCreatedTimestamp;
    }

    public int getHeartRateValue() {
        return this.heartRateValue;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "HeartRateProxy:\ndataCreatedTime=" + getDataCreatedTime() + "\nheartRateValue=" + getHeartRateValue() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.dataCreatedTimestamp);
        parcel.writeInt(this.heartRateValue);
    }

    protected HeartRateProxy(Parcel parcel) {
        this.dataCreatedTimestamp = parcel.readLong();
        this.heartRateValue = parcel.readInt();
    }
}
