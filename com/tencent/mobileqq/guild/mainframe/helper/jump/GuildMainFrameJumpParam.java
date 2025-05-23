package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;

/* loaded from: classes14.dex */
public class GuildMainFrameJumpParam {

    /* renamed from: a, reason: collision with root package name */
    public int f227437a;

    /* renamed from: e, reason: collision with root package name */
    public GuildAppReportSourceInfo f227441e;

    /* renamed from: b, reason: collision with root package name */
    public String f227438b = "";

    /* renamed from: c, reason: collision with root package name */
    public boolean f227439c = true;

    /* renamed from: d, reason: collision with root package name */
    public GuildCenterPanelJumpExtra f227440d = new GuildCenterPanelJumpExtra();

    /* renamed from: f, reason: collision with root package name */
    public Bundle f227442f = new Bundle();

    /* loaded from: classes14.dex */
    public static class GuildCenterPanelJumpExtra implements Parcelable {
        public static final Parcelable.Creator<GuildCenterPanelJumpExtra> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public GuildInboxJumpExtra f227443d;

        /* renamed from: e, reason: collision with root package name */
        public LaunchGuildChatPieParam f227444e;

        /* renamed from: f, reason: collision with root package name */
        public JumpGuildParam.ChannelDetailPageJumpInfo f227445f;

        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<GuildCenterPanelJumpExtra> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public GuildCenterPanelJumpExtra createFromParcel(Parcel parcel) {
                return new GuildCenterPanelJumpExtra(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public GuildCenterPanelJumpExtra[] newArray(int i3) {
                return new GuildCenterPanelJumpExtra[i3];
            }
        }

        public GuildCenterPanelJumpExtra() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "GuildCenterPanelJumpExtra{inboxJumpExtra=" + this.f227443d + ", launchGuildChatPieParam=" + this.f227444e + ", detailPageJumpInfo=" + this.f227445f + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f227443d, i3);
            parcel.writeParcelable(this.f227444e, i3);
            parcel.writeParcelable(this.f227445f, i3);
        }

        protected GuildCenterPanelJumpExtra(Parcel parcel) {
            this.f227443d = (GuildInboxJumpExtra) parcel.readParcelable(GuildInboxJumpExtra.class.getClassLoader());
            this.f227444e = (LaunchGuildChatPieParam) parcel.readParcelable(LaunchGuildChatPieParam.class.getClassLoader());
            this.f227445f = (JumpGuildParam.ChannelDetailPageJumpInfo) parcel.readParcelable(JumpGuildParam.ChannelDetailPageJumpInfo.class.getClassLoader());
        }
    }

    /* loaded from: classes14.dex */
    public static class GuildInboxJumpExtra implements Parcelable {
        public static final Parcelable.Creator<GuildInboxJumpExtra> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public int f227446d;

        /* renamed from: e, reason: collision with root package name */
        public String f227447e;

        /* loaded from: classes14.dex */
        class a implements Parcelable.Creator<GuildInboxJumpExtra> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public GuildInboxJumpExtra createFromParcel(Parcel parcel) {
                return new GuildInboxJumpExtra(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public GuildInboxJumpExtra[] newArray(int i3) {
                return new GuildInboxJumpExtra[i3];
            }
        }

        public GuildInboxJumpExtra() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "GuildInboxJumpExtra{inboxType=" + this.f227446d + ", inboxKey='" + this.f227447e + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f227446d);
            parcel.writeString(this.f227447e);
        }

        protected GuildInboxJumpExtra(Parcel parcel) {
            this.f227446d = parcel.readInt();
            this.f227447e = parcel.readString();
        }
    }

    public String toString() {
        return "GuildJumpParam{itemType=" + this.f227437a + ", itemKey='" + this.f227438b + "', needOpenCenterPanel=" + this.f227439c + ", centerPanelJumpExtra=" + this.f227440d + ", jumpSourceExtra=" + this.f227441e + ", extraInfo=" + this.f227442f + '}';
    }
}
