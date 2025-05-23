package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;

/* compiled from: P */
@Deprecated(since = "Facade\u540e\u7eed\u4f1a\u53bb\u6389, \u540e\u7eed\u5e94\u8be5\u76f4\u63a5\u4f7f\u7528 com.tencent.mobileqq.guild.jump.model.JumpGuildParam")
/* loaded from: classes14.dex */
public class FacadeArgsData implements Parcelable {
    public static final Parcelable.Creator<FacadeArgsData> CREATOR = new a();
    public Bundle C;

    /* renamed from: d, reason: collision with root package name */
    public int f227655d;

    /* renamed from: e, reason: collision with root package name */
    public String f227656e;

    /* renamed from: f, reason: collision with root package name */
    public long f227657f;

    /* renamed from: h, reason: collision with root package name */
    public String f227658h;

    /* renamed from: i, reason: collision with root package name */
    public FacadeJoinInfo f227659i;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private JumpGuildParam.ChannelDetailPageJumpInfo f227660m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<FacadeArgsData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacadeArgsData createFromParcel(Parcel parcel) {
            return new FacadeArgsData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FacadeArgsData[] newArray(int i3) {
            return new FacadeArgsData[i3];
        }
    }

    public FacadeArgsData() {
        this.C = new Bundle();
    }

    public JumpGuildParam a() {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(this.f227656e, this.f227658h, this.f227659i.a());
        jumpGuildParam.setCategoryId(this.f227657f);
        jumpGuildParam.extras = this.C;
        return jumpGuildParam;
    }

    @Nullable
    public JumpGuildParam.ChannelDetailPageJumpInfo b() {
        return this.f227660m;
    }

    public void c(@Nullable JumpGuildParam.ChannelDetailPageJumpInfo channelDetailPageJumpInfo) {
        this.f227660m = channelDetailPageJumpInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FacadeArgsData{type=" + this.f227655d + ", guildId='" + this.f227656e + "', categoryId='" + this.f227657f + "', channelId='" + this.f227658h + "', joinInfo=" + this.f227659i + ", jumpInfoAfterSuccessParam=" + this.f227660m + ", extra=" + this.C + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f227655d);
        parcel.writeString(this.f227656e);
        parcel.writeLong(this.f227657f);
        parcel.writeString(this.f227658h);
        parcel.writeParcelable(this.f227659i, i3);
        parcel.writeParcelable(this.f227660m, i3);
        parcel.writeBundle(this.C);
    }

    protected FacadeArgsData(Parcel parcel) {
        this.C = new Bundle();
        this.f227655d = parcel.readInt();
        this.f227656e = parcel.readString();
        this.f227657f = parcel.readLong();
        this.f227658h = parcel.readString();
        this.f227659i = (FacadeJoinInfo) parcel.readParcelable(FacadeJoinInfo.class.getClassLoader());
        this.f227660m = (JumpGuildParam.ChannelDetailPageJumpInfo) parcel.readParcelable(JumpGuildParam.ChannelDetailPageJumpInfo.class.getClassLoader());
        this.C = parcel.readBundle(getClass().getClassLoader());
    }
}
