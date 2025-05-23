package com.qzone.album.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TimeEvent implements Parcelable {
    public static final Parcelable.Creator<TimeEvent> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f43879d;

    /* renamed from: e, reason: collision with root package name */
    public long f43880e;

    /* renamed from: f, reason: collision with root package name */
    public String f43881f;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Parcelable.Creator<TimeEvent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeEvent createFromParcel(Parcel parcel) {
            return new TimeEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeEvent[] newArray(int i3) {
            return new TimeEvent[i3];
        }
    }

    public TimeEvent() {
        this.f43879d = 0L;
        this.f43880e = 1L;
        this.f43881f = "";
    }

    public static TimeEvent a(LoveAlbumTimeEvent loveAlbumTimeEvent) {
        TimeEvent timeEvent = new TimeEvent();
        timeEvent.f43881f = loveAlbumTimeEvent.content;
        timeEvent.f43880e = loveAlbumTimeEvent.type;
        timeEvent.f43879d = loveAlbumTimeEvent.time;
        return timeEvent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "(time, " + this.f43879d + ")\n(type, " + this.f43880e + ")\n(content, " + this.f43881f + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f43879d);
        parcel.writeLong(this.f43880e);
        parcel.writeString(this.f43881f);
    }

    TimeEvent(Parcel parcel) {
        this.f43879d = 0L;
        this.f43880e = 1L;
        this.f43881f = "";
        this.f43879d = parcel.readLong();
        this.f43880e = parcel.readLong();
        this.f43881f = parcel.readString();
    }
}
