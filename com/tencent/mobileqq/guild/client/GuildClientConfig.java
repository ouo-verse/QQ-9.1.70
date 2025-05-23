package com.tencent.mobileqq.guild.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qqguildsdk.data.dn;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientConfig implements Parcelable {
    public static final Parcelable.Creator<GuildClientConfig> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private int f215357d;

    /* renamed from: e, reason: collision with root package name */
    private int f215358e;

    /* renamed from: f, reason: collision with root package name */
    private String f215359f;

    /* renamed from: h, reason: collision with root package name */
    private String f215360h;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<GuildClientConfig> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildClientConfig createFromParcel(Parcel parcel) {
            return new GuildClientConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildClientConfig[] newArray(int i3) {
            return new GuildClientConfig[i3];
        }
    }

    public GuildClientConfig() {
        this.f215357d = 0;
        this.f215358e = 1;
        this.f215359f = "";
        this.f215360h = "";
    }

    public GuildClientConfig a(int i3) {
        this.f215358e = i3;
        return this;
    }

    public String b() {
        return this.f215359f;
    }

    public int c() {
        return this.f215357d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        if (this.f215358e == 2) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f215360h;
    }

    public String toString() {
        return "GuildClientConfig{configId='" + this.f215357d + "', configStatus=" + this.f215358e + ", configDesc='" + this.f215359f + "', jumpUrl='" + this.f215360h + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f215357d);
        parcel.writeInt(this.f215358e);
        parcel.writeString(this.f215359f);
        parcel.writeString(this.f215360h);
    }

    public GuildClientConfig(dn dnVar) {
        this.f215357d = 0;
        this.f215358e = 1;
        this.f215359f = "";
        this.f215360h = "";
        this.f215357d = dnVar.b();
        this.f215358e = dnVar.a();
        this.f215359f = dnVar.getDesc();
        this.f215360h = dnVar.getJumpUrl();
    }

    protected GuildClientConfig(Parcel parcel) {
        this.f215357d = 0;
        this.f215358e = 1;
        this.f215359f = "";
        this.f215360h = "";
        this.f215357d = parcel.readInt();
        this.f215358e = parcel.readInt();
        this.f215359f = parcel.readString();
        this.f215360h = parcel.readString();
    }
}
