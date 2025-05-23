package com.tencent.mobileqq.guild.client.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.client.GuildClientParams;

/* loaded from: classes12.dex */
public class GuildClientAuthDialogParams implements Parcelable {
    public static final Parcelable.Creator<GuildClientAuthDialogParams> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final GuildClientParams f215369d;

    /* renamed from: e, reason: collision with root package name */
    private String f215370e;

    /* renamed from: f, reason: collision with root package name */
    private String f215371f;

    /* renamed from: h, reason: collision with root package name */
    private String f215372h;

    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<GuildClientAuthDialogParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildClientAuthDialogParams createFromParcel(Parcel parcel) {
            return new GuildClientAuthDialogParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildClientAuthDialogParams[] newArray(int i3) {
            return new GuildClientAuthDialogParams[i3];
        }
    }

    public GuildClientAuthDialogParams(GuildClientParams guildClientParams) {
        this.f215370e = "";
        this.f215371f = "";
        this.f215372h = "";
        this.f215369d = guildClientParams;
    }

    public GuildClientAuthDialogParams a(String str) {
        this.f215370e = str;
        return this;
    }

    public GuildClientAuthDialogParams b(String str) {
        this.f215371f = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f215370e;
    }

    public String f() {
        return this.f215371f;
    }

    public GuildClientParams g() {
        return this.f215369d;
    }

    public String j() {
        return this.f215372h;
    }

    public GuildClientAuthDialogParams k(String str) {
        this.f215372h = str;
        return this;
    }

    public String toString() {
        return "GuildClientAuthDialogParams{, baseParams=" + this.f215369d.toString() + ", authAgreement=" + this.f215370e + ", authTips=" + this.f215371f + ", picUrl=" + this.f215372h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f215369d, i3);
        parcel.writeString(this.f215370e);
        parcel.writeString(this.f215371f);
        parcel.writeString(this.f215372h);
    }

    protected GuildClientAuthDialogParams(Parcel parcel) {
        this.f215370e = "";
        this.f215371f = "";
        this.f215372h = "";
        this.f215369d = (GuildClientParams) parcel.readParcelable(GuildClientParams.class.getClassLoader());
        this.f215370e = parcel.readString();
        this.f215371f = parcel.readString();
        this.f215372h = parcel.readString();
    }

    public GuildClientAuthDialogParams c() {
        return this;
    }
}
