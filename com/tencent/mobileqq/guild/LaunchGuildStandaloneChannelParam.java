package com.tencent.mobileqq.guild;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes12.dex */
public class LaunchGuildStandaloneChannelParam implements Parcelable {
    public static final Parcelable.Creator<LaunchGuildStandaloneChannelParam> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f213870d;

    /* renamed from: e, reason: collision with root package name */
    public String f213871e;

    /* renamed from: f, reason: collision with root package name */
    public int f213872f;

    /* renamed from: h, reason: collision with root package name */
    public long f213873h;

    /* renamed from: i, reason: collision with root package name */
    public int f213874i;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f213875m;

    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<LaunchGuildStandaloneChannelParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LaunchGuildStandaloneChannelParam createFromParcel(Parcel parcel) {
            return new LaunchGuildStandaloneChannelParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LaunchGuildStandaloneChannelParam[] newArray(int i3) {
            return new LaunchGuildStandaloneChannelParam[i3];
        }
    }

    public LaunchGuildStandaloneChannelParam() {
        this.f213875m = new Bundle();
        this.f213872f = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LaunchGuildStandaloneChannelParam{guildId='" + this.f213870d + "', channelId='" + this.f213871e + "', channelType=" + this.f213872f + ", from=" + this.f213874i + ", extra=" + this.f213875m + ", applicationId=" + this.f213873h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f213870d);
        parcel.writeString(this.f213871e);
        parcel.writeInt(this.f213872f);
        parcel.writeInt(this.f213874i);
        parcel.writeBundle(this.f213875m);
        parcel.writeLong(this.f213873h);
    }

    protected LaunchGuildStandaloneChannelParam(Parcel parcel) {
        this.f213875m = new Bundle();
        this.f213870d = parcel.readString();
        this.f213871e = parcel.readString();
        this.f213872f = parcel.readInt();
        this.f213874i = parcel.readInt();
        this.f213875m = parcel.readBundle(getClass().getClassLoader());
        this.f213873h = parcel.readLong();
    }
}
