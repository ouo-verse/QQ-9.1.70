package com.tencent.mobileqq.guild.profile.me.edit;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;

/* loaded from: classes14.dex */
public class GuildEditProfileModel implements Parcelable {
    public static final Parcelable.Creator<GuildEditProfileModel> CREATOR = new a();
    private GProLocationInfo C;

    /* renamed from: d, reason: collision with root package name */
    private String f231180d;

    /* renamed from: e, reason: collision with root package name */
    private String f231181e;

    /* renamed from: f, reason: collision with root package name */
    private int f231182f;

    /* renamed from: h, reason: collision with root package name */
    private int f231183h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private String f231184i;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private String f231185m;

    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<GuildEditProfileModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildEditProfileModel createFromParcel(Parcel parcel) {
            return new GuildEditProfileModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildEditProfileModel[] newArray(int i3) {
            return new GuildEditProfileModel[i3];
        }
    }

    public GuildEditProfileModel() {
        this.C = new GProLocationInfo();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "GuildEditProfileModel{mTinyId='" + this.f231180d + "', mNickname='" + this.f231181e + "', mGender=" + this.f231182f + ", mAge=" + this.f231183h + ", mConstellation='" + this.f231184i + "', mPersonalSignature='" + this.f231185m + "', mGProLocationInfo=" + this.C + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f231180d);
        parcel.writeString(this.f231181e);
        parcel.writeInt(this.f231182f);
        parcel.writeInt(this.f231183h);
        parcel.writeString(this.f231184i);
        parcel.writeString(this.f231185m);
        parcel.writeParcelable(this.C, i3);
    }

    protected GuildEditProfileModel(Parcel parcel) {
        this.C = new GProLocationInfo();
        this.f231180d = parcel.readString();
        this.f231181e = parcel.readString();
        this.f231182f = parcel.readInt();
        this.f231183h = parcel.readInt();
        this.f231184i = parcel.readString();
        this.f231185m = parcel.readString();
        this.C = (GProLocationInfo) parcel.readParcelable(GProLocationInfo.class.getClassLoader());
    }
}
