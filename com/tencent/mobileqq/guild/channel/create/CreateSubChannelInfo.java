package com.tencent.mobileqq.guild.channel.create;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CreateSubChannelInfo implements Parcelable {
    public static final Parcelable.Creator<CreateSubChannelInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f214821d;

    /* renamed from: e, reason: collision with root package name */
    public final long f214822e;

    /* renamed from: f, reason: collision with root package name */
    public final String f214823f;

    /* renamed from: h, reason: collision with root package name */
    public int f214824h;

    /* renamed from: i, reason: collision with root package name */
    public Bundle f214825i;

    /* renamed from: m, reason: collision with root package name */
    public String f214826m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<CreateSubChannelInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CreateSubChannelInfo createFromParcel(Parcel parcel) {
            return new CreateSubChannelInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CreateSubChannelInfo[] newArray(int i3) {
            return new CreateSubChannelInfo[i3];
        }
    }

    public CreateSubChannelInfo(String str, long j3, String str2, String str3) {
        this.f214821d = str;
        this.f214822e = j3;
        this.f214823f = str2;
        this.f214826m = str3;
    }

    public void a(Bundle bundle) {
        this.f214825i = bundle;
    }

    public void b(int i3) {
        this.f214824h = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f214821d);
        parcel.writeLong(this.f214822e);
        parcel.writeString(this.f214823f);
        parcel.writeInt(this.f214824h);
        parcel.writeBundle(this.f214825i);
        parcel.writeString(this.f214826m);
    }

    public CreateSubChannelInfo(String str, long j3, String str2) {
        this(str, j3, str2, "\u8fd4\u56de");
    }

    protected CreateSubChannelInfo(Parcel parcel) {
        this.f214826m = "\u8fd4\u56de";
        this.f214821d = parcel.readString();
        this.f214822e = parcel.readLong();
        this.f214823f = parcel.readString();
        this.f214824h = parcel.readInt();
        this.f214825i = parcel.readBundle();
        this.f214826m = parcel.readString();
    }
}
