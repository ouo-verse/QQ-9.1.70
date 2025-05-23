package com.tencent.mobileqq.guild.jump.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes13.dex */
public class GuildShareUrlParam extends BaseGuildShareParam {
    public static final Parcelable.Creator<GuildShareUrlParam> CREATOR = new a();

    /* renamed from: h, reason: collision with root package name */
    private String f226419h;

    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildShareUrlParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildShareUrlParam createFromParcel(Parcel parcel) {
            return new GuildShareUrlParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildShareUrlParam[] newArray(int i3) {
            return new GuildShareUrlParam[i3];
        }
    }

    public GuildShareUrlParam(String str) {
        super("", "");
        this.f226419h = str;
    }

    public String c() {
        return this.f226419h;
    }

    @Override // com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam
    public String toString() {
        return "GuildShareUrlParam{jumpUrl='" + this.f226419h + "'} " + super.toString();
    }

    @Override // com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f226419h);
    }

    protected GuildShareUrlParam(Parcel parcel) {
        super(parcel);
        this.f226419h = parcel.readString();
    }
}
