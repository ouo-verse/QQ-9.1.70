package com.heytap.databaseengine.apiv2.device.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class Record implements Parcelable {
    public static final Parcelable.Creator<Record> CREATOR = new Parcelable.Creator<Record>() { // from class: com.heytap.databaseengine.apiv2.device.game.model.Record.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Record createFromParcel(Parcel parcel) {
            return new Record(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Record[] newArray(int i3) {
            return new Record[i3];
        }
    };
    private int assist;
    private int dead;
    private long endTime;
    private String iconUrl;
    private int kill;
    private String mode;
    private String name;
    private int result;
    private long startTime;

    public Record() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAssist() {
        return this.assist;
    }

    public int getDead() {
        return this.dead;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getKill() {
        return this.kill;
    }

    public String getMode() {
        return this.mode;
    }

    public String getName() {
        return this.name;
    }

    public int getResult() {
        return this.result;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setAssist(int i3) {
        this.assist = i3;
    }

    public void setDead(int i3) {
        this.dead = i3;
    }

    public void setEndTime(long j3) {
        this.endTime = j3;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setKill(int i3) {
        this.kill = i3;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setResult(int i3) {
        this.result = i3;
    }

    public void setStartTime(long j3) {
        this.startTime = j3;
    }

    public String toString() {
        return "Record{name='" + this.name + "', iconUrl='" + this.iconUrl + "', result=" + this.result + ", mode='" + this.mode + "', kill=" + this.kill + ", dead=" + this.dead + ", assist=" + this.assist + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.name);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.result);
        parcel.writeString(this.mode);
        parcel.writeInt(this.kill);
        parcel.writeInt(this.dead);
        parcel.writeInt(this.assist);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
    }

    protected Record(Parcel parcel) {
        this.name = parcel.readString();
        this.iconUrl = parcel.readString();
        this.result = parcel.readInt();
        this.mode = parcel.readString();
        this.kill = parcel.readInt();
        this.dead = parcel.readInt();
        this.assist = parcel.readInt();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
    }
}
