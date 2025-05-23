package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.Sleep;
import com.heytap.databaseengine.model.SportHealthData;

@Keep
/* loaded from: classes2.dex */
public class SleepProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<SleepProxy> CREATOR = new Parcelable.Creator<SleepProxy>() { // from class: com.heytap.databaseengine.model.proxy.SleepProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepProxy createFromParcel(Parcel parcel) {
            return new SleepProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepProxy[] newArray(int i3) {
            return new SleepProxy[i3];
        }
    };
    private long endTimestamp;
    private int sleepState;
    private int sleepType;
    private long startTimestamp;

    public SleepProxy(@NonNull Sleep sleep) {
        this.startTimestamp = sleep.getStartTimestamp();
        this.endTimestamp = sleep.getEndTimestamp();
        this.sleepType = sleep.getSleepType();
        this.sleepState = sleep.getSleepState();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getEndTime() {
        return this.endTimestamp;
    }

    public int getSleepState() {
        return this.sleepState;
    }

    public int getSleepType() {
        return this.sleepType;
    }

    public long getStartTime() {
        return this.startTimestamp;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "SleepProxy:\nstartTime=" + getStartTime() + "\nendTime=" + getEndTime() + "\nsleepType=" + getSleepType() + "\nsleepState=" + getSleepState() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeInt(this.sleepType);
        parcel.writeInt(this.sleepState);
    }

    protected SleepProxy(Parcel parcel) {
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.sleepType = parcel.readInt();
        this.sleepState = parcel.readInt();
    }
}
