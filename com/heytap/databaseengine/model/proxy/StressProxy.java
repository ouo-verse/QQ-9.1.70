package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.model.stress.Stress;

@Keep
/* loaded from: classes2.dex */
public class StressProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<StressProxy> CREATOR = new Parcelable.Creator<StressProxy>() { // from class: com.heytap.databaseengine.model.proxy.StressProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StressProxy createFromParcel(Parcel parcel) {
            return new StressProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StressProxy[] newArray(int i3) {
            return new StressProxy[i3];
        }
    };
    private long dataCreatedTimestamp;
    private int stressValue;

    public StressProxy(@NonNull Stress stress) {
        this.dataCreatedTimestamp = stress.getDataCreatedTimestamp();
        this.stressValue = stress.getStressValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDataCreatedTime() {
        return this.dataCreatedTimestamp;
    }

    public int getStressValue() {
        return this.stressValue;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "StressProxy:\ndataCreatedTime=" + getDataCreatedTime() + "\nstressValue=" + getStressValue() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.dataCreatedTimestamp);
        parcel.writeInt(this.stressValue);
    }

    protected StressProxy(Parcel parcel) {
        this.dataCreatedTimestamp = parcel.readLong();
        this.stressValue = parcel.readInt();
    }
}
