package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TimeLine implements Parcelable {
    public static final Parcelable.Creator<TimeLine> CREATOR = new Parcelable.Creator<TimeLine>() { // from class: org.light.TimeLine.1
        @Override // android.os.Parcelable.Creator
        public TimeLine createFromParcel(Parcel parcel) {
            return new TimeLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TimeLine[] newArray(int i3) {
            return new TimeLine[i3];
        }
    };
    public int entityID;
    public String event;
    public TimeRange range;
    public long time;
    public String type;

    public TimeLine(String str, int i3, TimeRange timeRange, long j3, String str2) {
        this.type = str;
        this.entityID = i3;
        this.range = timeRange;
        this.time = j3;
        this.event = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.type);
        parcel.writeInt(this.entityID);
        parcel.writeParcelable(this.range, i3);
        parcel.writeLong(this.time);
        parcel.writeString(this.event);
    }

    protected TimeLine(Parcel parcel) {
        this.type = "";
        this.entityID = -1;
        this.time = -1L;
        this.event = "";
        this.type = parcel.readString();
        this.entityID = parcel.readInt();
        this.range = (TimeRange) parcel.readParcelable(TimeRange.class.getClassLoader());
        this.time = parcel.readLong();
        this.event = parcel.readString();
    }
}
