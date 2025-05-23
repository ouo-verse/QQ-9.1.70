package com.tencent.mobileqq.guild.jump.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes13.dex */
public class GuildShareInviteCodeParam extends BaseGuildShareParam {
    public static final Parcelable.Creator<GuildShareInviteCodeParam> CREATOR = new a();

    /* renamed from: h, reason: collision with root package name */
    private String f226417h;

    /* renamed from: i, reason: collision with root package name */
    private String f226418i;

    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildShareInviteCodeParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildShareInviteCodeParam createFromParcel(Parcel parcel) {
            return new GuildShareInviteCodeParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildShareInviteCodeParam[] newArray(int i3) {
            return new GuildShareInviteCodeParam[i3];
        }
    }

    public GuildShareInviteCodeParam(String str, String str2, String str3, String str4) {
        super(str3, str4);
        this.f226417h = str;
        this.f226418i = str2;
    }

    public String c() {
        return this.f226418i;
    }

    @Override // com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f226417h;
    }

    @Override // com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam
    public String toString() {
        return "GuildShareInviteCodeParam{inviteCode='" + this.f226417h + "', contentId='" + this.f226418i + "'} " + super.toString();
    }

    @Override // com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f226417h);
        parcel.writeString(this.f226418i);
    }

    protected GuildShareInviteCodeParam(Parcel parcel) {
        super(parcel);
        this.f226417h = parcel.readString();
        this.f226418i = parcel.readString();
    }
}
