package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.model.weight.WeightBodyFat;

@Keep
/* loaded from: classes2.dex */
public class WeightBodyFatProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<WeightBodyFatProxy> CREATOR = new Parcelable.Creator<WeightBodyFatProxy>() { // from class: com.heytap.databaseengine.model.proxy.WeightBodyFatProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeightBodyFatProxy createFromParcel(Parcel parcel) {
            return new WeightBodyFatProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeightBodyFatProxy[] newArray(int i3) {
            return new WeightBodyFatProxy[i3];
        }
    };
    private String bmi;
    private long measurementTime;
    private String weight;

    public WeightBodyFatProxy(WeightBodyFat weightBodyFat) {
        this.weight = weightBodyFat.getWeight();
        this.bmi = weightBodyFat.getBmi();
        this.measurementTime = weightBodyFat.getMeasurementTime();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBmi() {
        return this.bmi;
    }

    public long getMeasurementTime() {
        return this.measurementTime;
    }

    public String getWeight() {
        return this.weight;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "WeightBodyFatProxy:\nweight=" + getWeight() + "\nBMI=" + getBmi() + "\nmeasurementTime=" + getMeasurementTime() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.weight);
        parcel.writeString(this.bmi);
        parcel.writeLong(this.measurementTime);
    }

    protected WeightBodyFatProxy(Parcel parcel) {
        this.weight = parcel.readString();
        this.bmi = parcel.readString();
        this.measurementTime = parcel.readLong();
    }
}
