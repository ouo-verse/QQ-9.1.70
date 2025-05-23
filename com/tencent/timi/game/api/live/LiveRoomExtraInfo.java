package com.tencent.timi.game.api.live;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LiveRoomExtraInfo implements Parcelable {
    public static final Parcelable.Creator<LiveRoomExtraInfo> CREATOR = new a();
    public String C;
    public String D;
    public Bundle E;
    public String F;

    /* renamed from: d, reason: collision with root package name */
    public long f376291d;

    /* renamed from: e, reason: collision with root package name */
    public int f376292e;

    /* renamed from: f, reason: collision with root package name */
    public int f376293f;

    /* renamed from: h, reason: collision with root package name */
    public int f376294h;

    /* renamed from: i, reason: collision with root package name */
    public int f376295i;

    /* renamed from: m, reason: collision with root package name */
    public long f376296m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<LiveRoomExtraInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LiveRoomExtraInfo createFromParcel(Parcel parcel) {
            return new LiveRoomExtraInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LiveRoomExtraInfo[] newArray(int i3) {
            return new LiveRoomExtraInfo[i3];
        }
    }

    public LiveRoomExtraInfo() {
        this.F = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LiveRoomExtraInfo{roomId=" + this.f376291d + ", roomIndex=" + this.f376292e + ", roomType=" + this.f376293f + ", gameId=" + this.f376294h + ", gameTagId=" + this.f376295i + ", videoSource=" + this.f376296m + ", comingWay='" + this.C + "', traceDetail='" + this.D + "', extra=" + this.E + ", jumpSource='" + this.F + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f376291d);
        parcel.writeInt(this.f376292e);
        parcel.writeInt(this.f376293f);
        parcel.writeInt(this.f376294h);
        parcel.writeInt(this.f376295i);
        parcel.writeLong(this.f376296m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeBundle(this.E);
        parcel.writeString(this.F);
    }

    protected LiveRoomExtraInfo(Parcel parcel) {
        this.F = "";
        this.f376291d = parcel.readLong();
        this.f376292e = parcel.readInt();
        this.f376293f = parcel.readInt();
        this.f376294h = parcel.readInt();
        this.f376295i = parcel.readInt();
        this.f376296m = parcel.readLong();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readBundle();
        this.F = parcel.readString();
    }
}
