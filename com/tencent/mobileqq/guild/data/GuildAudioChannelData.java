package com.tencent.mobileqq.guild.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildAudioChannelData implements Parcelable {
    public static final Parcelable.Creator<GuildAudioChannelData> CREATOR = new a();
    private boolean C;
    private boolean D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private String f216387d;

    /* renamed from: e, reason: collision with root package name */
    private int f216388e;

    /* renamed from: f, reason: collision with root package name */
    private String f216389f;

    /* renamed from: h, reason: collision with root package name */
    private int f216390h;

    /* renamed from: i, reason: collision with root package name */
    private String f216391i;

    /* renamed from: m, reason: collision with root package name */
    private int f216392m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildAudioChannelData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildAudioChannelData createFromParcel(Parcel parcel) {
            return new GuildAudioChannelData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildAudioChannelData[] newArray(int i3) {
            return new GuildAudioChannelData[i3];
        }
    }

    public GuildAudioChannelData() {
    }

    public String a() {
        return this.f216387d;
    }

    public String b() {
        return this.f216391i;
    }

    public int c() {
        return this.f216392m;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.E;
    }

    public boolean f() {
        return this.D;
    }

    public boolean g() {
        return this.C;
    }

    public String j() {
        return this.f216389f;
    }

    public int k() {
        return this.f216390h;
    }

    public void l(String str) {
        this.f216391i = str;
    }

    public void m(int i3) {
        this.f216392m = i3;
    }

    public void n(int i3) {
        this.E = i3;
    }

    public void o(boolean z16) {
        this.D = z16;
    }

    public void p(boolean z16) {
        this.C = z16;
    }

    public void q(String str) {
        this.f216389f = str;
    }

    public void r(int i3) {
        this.f216390h = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f216387d);
        parcel.writeInt(this.f216388e);
        parcel.writeString(this.f216389f);
        parcel.writeInt(this.f216390h);
        parcel.writeString(this.f216391i);
        parcel.writeInt(this.f216392m);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
    }

    public GuildAudioChannelData(String str, int i3, String str2, int i16, String str3, int i17, boolean z16, boolean z17, int i18) {
        this.f216387d = str;
        this.f216388e = i3;
        this.f216389f = str2;
        this.f216390h = i16;
        this.f216391i = str3;
        this.f216392m = i17;
        this.C = z16;
        this.D = z17;
        this.F = z17 ? 2 : 1;
    }

    protected GuildAudioChannelData(Parcel parcel) {
        this.f216387d = parcel.readString();
        this.f216388e = parcel.readInt();
        this.f216389f = parcel.readString();
        this.f216390h = parcel.readInt();
        this.f216391i = parcel.readString();
        this.f216392m = parcel.readInt();
        this.C = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = parcel.readInt();
        this.F = parcel.readInt();
    }
}
