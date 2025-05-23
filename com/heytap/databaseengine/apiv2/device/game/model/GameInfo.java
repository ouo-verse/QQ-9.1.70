package com.heytap.databaseengine.apiv2.device.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class GameInfo implements Parcelable {
    public static final Parcelable.Creator<GameInfo> CREATOR = new Parcelable.Creator<GameInfo>() { // from class: com.heytap.databaseengine.apiv2.device.game.model.GameInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameInfo createFromParcel(Parcel parcel) {
            return new GameInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameInfo[] newArray(int i3) {
            return new GameInfo[i3];
        }
    };
    private Record mRecord;
    private String packageName;
    private long startTime;
    private int status;

    public GameInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Record getRecord() {
        return this.mRecord;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRecord(Record record) {
        this.mRecord = record;
    }

    public void setStartTime(long j3) {
        this.startTime = j3;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public String toString() {
        return "GameInfo{packageName='" + this.packageName + "', startTime=" + this.startTime + ", mRecord=" + this.mRecord + ", status=" + this.status + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.packageName);
        parcel.writeLong(this.startTime);
        parcel.writeParcelable(this.mRecord, i3);
        parcel.writeInt(this.status);
    }

    protected GameInfo(Parcel parcel) {
        this.packageName = parcel.readString();
        this.startTime = parcel.readLong();
        this.mRecord = (Record) parcel.readParcelable(Record.class.getClassLoader());
        this.status = parcel.readInt();
    }
}
