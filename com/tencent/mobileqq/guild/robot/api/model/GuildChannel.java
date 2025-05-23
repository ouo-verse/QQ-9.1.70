package com.tencent.mobileqq.guild.robot.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildChannel implements Parcelable {
    public static final Parcelable.Creator<GuildChannel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private long f232063d;

    /* renamed from: e, reason: collision with root package name */
    private long f232064e;

    /* renamed from: f, reason: collision with root package name */
    private int f232065f;

    /* renamed from: h, reason: collision with root package name */
    private int f232066h;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<GuildChannel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildChannel createFromParcel(Parcel parcel) {
            return new GuildChannel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildChannel[] newArray(int i3) {
            return new GuildChannel[i3];
        }
    }

    public GuildChannel() {
    }

    public long a() {
        return this.f232063d;
    }

    public long b() {
        return this.f232064e;
    }

    public void c(long j3) {
        this.f232063d = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(long j3) {
        this.f232064e = j3;
    }

    public String toString() {
        return "{guildId=" + this.f232064e + ",channelId=" + this.f232063d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f232063d);
        parcel.writeLong(this.f232064e);
        parcel.writeInt(this.f232065f);
        parcel.writeInt(this.f232066h);
    }

    protected GuildChannel(Parcel parcel) {
        this.f232063d = parcel.readLong();
        this.f232064e = parcel.readLong();
        this.f232065f = parcel.readInt();
        this.f232066h = parcel.readInt();
    }
}
