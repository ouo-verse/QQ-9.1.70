package com.tencent.mobileqq.guild.jump.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes13.dex */
public class JumpGuildParam implements Serializable, Cloneable, Parcelable {
    public static final String ARK_ADD_FRIENDS_MAIN_SOURCE_ID = "channel_addfriend";
    public static final String ARK_ADD_FRIENDS_SUB_SOURCE_ID = "channel_addfriend_invite";
    public static final Parcelable.Creator<JumpGuildParam> CREATOR = new a();
    public static final String EXTRA_BACK_TO_THIRD_APP = "extra_back_to_third_app";
    public static final String EXTRA_CLEAR_OTHER_FRAGMENT = "extra_clear_other_fragment";
    public static final String EXTRA_FEED_HOME_CATEGORY_LOCATE_TYPE = "extra_feed_home_category_locate_type";
    public static final String EXTRA_FEED_HOME_SELECTED_HOT_TAB = "extra_feed_hot_selected_hot_tab";
    public static final String EXTRA_FORCE_OPEN_GUILD_HOME = "extra_force_open_guild_home";
    public static final String EXTRA_JOIN_GUILD_SOURCE = "extra_join_guild_source";
    public static final String EXTRA_JOIN_GUILD_TINY_ID = "extra_join_guild_tiny_id";
    public static final String EXTRA_JUMP_NOTICE_MSG = "extra_jump_notice_msg";
    public static final String EXTRA_JUMP_REPORT_TASK = "extra_jump_report_task";
    public static final String EXTRA_KEY_CHANNEL_LOAD_FROM = "channelLoadFrom";
    public static final String EXTRA_KEY_CHANNEL_OPEN_SOURCE = "channelOpenSource";
    public static final String EXTRA_KEY_IS_FROM_STANDALONE_PAGE = "isFromStandalonePage";
    public static final String EXTRA_KEY_OPEN_FROM = "openFrom";
    public static final String EXTRA_KEY_TRACE_ID = "sgrp_query_trace_id";
    public static final String EXTRA_LAUNCH_MODE = "extra_launch_mode";
    public static final String EXTRA_NEED_OPEN_PUBLISHER = "extra_need_open_publisher";
    public static final String EXTRA_OPEN_STANDALONE = "extra_open_standalone";
    public static final String EXTRA_PERSON_CARD_SCENE_TYPE = "extra_person_card_scene_type";
    public static final String EXTRA_SETTING_ENTRANCE_VISIBLE = "extra_setting_entrance_visible";
    public static final String KEY_CHANNEL_ID = "channelId";
    public static final String KEY_DETAIL_PAGE_JUMP_INFO = "detailPageJumpInfo";
    public static final String KEY_JOIN_INFO_PARAM = "keyJoinInfoParam";
    public static final String KEY_JUMP_GUILD_PARAM = "keyJumpGuildParam";
    public int businessType;
    private long categoryId;
    private String channelId;

    @Nullable
    private ChannelDetailPageJumpInfo detailPageJumpInfo;
    public Bundle extras;
    private GuildFeedReportSourceInfo feedReportSourceInfo;
    public String guildId;
    public String guildNumber;
    public String inviteCode;
    private boolean isDirectMessage;

    @NonNull
    private JoinInfoParam joinInfoParam;

    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<JumpGuildParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JumpGuildParam createFromParcel(Parcel parcel) {
            return new JumpGuildParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JumpGuildParam[] newArray(int i3) {
            return new JumpGuildParam[i3];
        }
    }

    public JumpGuildParam(String str, String str2) {
        this.isDirectMessage = false;
        this.businessType = 0;
        this.inviteCode = "";
        this.guildNumber = "";
        this.feedReportSourceInfo = new GuildFeedReportSourceInfo();
        this.extras = new Bundle();
        this.guildId = str;
        this.channelId = str2 == null ? "" : str2;
        this.joinInfoParam = new JoinInfoParam("", "", "", "");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JumpGuildParam)) {
            return false;
        }
        JumpGuildParam jumpGuildParam = (JumpGuildParam) obj;
        if (Objects.equals(this.guildId, jumpGuildParam.guildId) && Objects.equals(Long.valueOf(this.categoryId), Long.valueOf(jumpGuildParam.categoryId)) && Objects.equals(this.channelId, jumpGuildParam.channelId) && Objects.equals(Boolean.valueOf(this.isDirectMessage), Boolean.valueOf(jumpGuildParam.isDirectMessage)) && Objects.equals(this.joinInfoParam, jumpGuildParam.joinInfoParam)) {
            return true;
        }
        return false;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    @NonNull
    public String getChannelId() {
        String str = this.channelId;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int getChannelLoadFrom() {
        return this.extras.getInt(EXTRA_KEY_CHANNEL_LOAD_FROM);
    }

    @Nullable
    public ChannelDetailPageJumpInfo getDetailPageJumpInfo() {
        return this.detailPageJumpInfo;
    }

    public int getExtraJoinGuildSource() {
        return this.extras.getInt(EXTRA_JOIN_GUILD_SOURCE);
    }

    public String getExtraJoinGuildTinyId() {
        return this.extras.getString(EXTRA_JOIN_GUILD_TINY_ID);
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public GuildFeedReportSourceInfo getFeedReportSourceInfo() {
        return this.feedReportSourceInfo;
    }

    public String getGuildId() {
        return this.guildId;
    }

    @NonNull
    public JoinInfoParam getJoinInfoParam() {
        return this.joinInfoParam;
    }

    public String getJoinSignature() {
        JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam == null) {
            return "";
        }
        return joinInfoParam.getJoinSignature();
    }

    public String getMainSource() {
        JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam == null) {
            return "";
        }
        return joinInfoParam.getMainSource();
    }

    @Deprecated
    public GuildAppReportSourceInfo getReportSourceInfo() {
        return new GuildAppReportSourceInfo();
    }

    public String getSourceChannelId() {
        return this.extras.getString("keySourceChannelId", "");
    }

    public String getSubSource() {
        JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam == null) {
            return "";
        }
        return joinInfoParam.getSubSource();
    }

    public int hashCode() {
        return Objects.hash(this.guildId, Long.valueOf(this.categoryId), this.channelId, this.joinInfoParam);
    }

    public boolean isDirectMessage() {
        return this.isDirectMessage;
    }

    public boolean isGuest() {
        return ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isGuest(this.guildId);
    }

    public void setArkJumpId(@Nullable String str, @Nullable String str2) {
        this.joinInfoParam.setArkJumpId(str, str2);
    }

    public void setCategoryId(long j3) {
        this.categoryId = j3;
    }

    public void setChannelId(String str) {
        if (str == null) {
            str = "";
        }
        this.channelId = str;
    }

    public void setChannelLoadFrom(int i3) {
        this.extras.putInt(EXTRA_KEY_CHANNEL_LOAD_FROM, i3);
    }

    public void setChannelOpenSource(int i3) {
        this.extras.putInt(EXTRA_KEY_CHANNEL_OPEN_SOURCE, i3);
    }

    public void setDetailPageJumpInfo(@Nullable ChannelDetailPageJumpInfo channelDetailPageJumpInfo) {
        this.detailPageJumpInfo = channelDetailPageJumpInfo;
    }

    public void setDirectMessage(boolean z16) {
        this.isDirectMessage = z16;
    }

    public void setExtraJoinGuildSource(int i3) {
        this.extras.putInt(EXTRA_JOIN_GUILD_SOURCE, i3);
    }

    public void setExtraJoinGuildTinyId(String str) {
        this.extras.putString(EXTRA_JOIN_GUILD_TINY_ID, str);
    }

    public void setFeedReportSourceInfo(GuildFeedReportSourceInfo guildFeedReportSourceInfo) {
        this.feedReportSourceInfo = guildFeedReportSourceInfo;
    }

    public void setGuildId(String str) {
        this.guildId = str;
    }

    public void setJoinInfoParam(@NonNull JoinInfoParam joinInfoParam) {
        this.joinInfoParam = joinInfoParam;
    }

    public void setJoinSignature(String str) {
        JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam != null) {
            joinInfoParam.setJoinSignature(str);
        }
    }

    public void setMainAndSubSource(String str, String str2) {
        JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam != null) {
            joinInfoParam.setMainAndSubSource(str, str2);
        }
    }

    public void setSourceChannelId(String str) {
        this.extras.putString("keySourceChannelId", str);
    }

    public String toString() {
        return "JumpGuildParam{guildId='" + this.guildId + "', categoryId=" + this.categoryId + ", channelId='" + this.channelId + "', joinInfoParam=" + this.joinInfoParam + ", detailPageJumpInfo=" + this.detailPageJumpInfo + ", isDirectMessage=" + this.isDirectMessage + ", businessType=" + this.businessType + ", inviteCode='" + this.inviteCode + "', guildNumber='" + this.guildNumber + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.guildId);
        parcel.writeLong(this.categoryId);
        parcel.writeString(this.channelId);
        parcel.writeByte(this.isDirectMessage ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.businessType);
        parcel.writeString(this.inviteCode);
        parcel.writeString(this.guildNumber);
        parcel.writeBundle(this.extras);
        parcel.writeParcelable(this.joinInfoParam, i3);
        parcel.writeParcelable(this.detailPageJumpInfo, i3);
        parcel.writeParcelable(this.feedReportSourceInfo, i3);
    }

    /* loaded from: classes13.dex */
    public static class ChannelDetailPageJumpInfo implements Parcelable, Serializable {
        public static final Parcelable.Creator<ChannelDetailPageJumpInfo> CREATOR = new a();
        private String detailId;

        /* loaded from: classes13.dex */
        class a implements Parcelable.Creator<ChannelDetailPageJumpInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ChannelDetailPageJumpInfo createFromParcel(Parcel parcel) {
                return new ChannelDetailPageJumpInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ChannelDetailPageJumpInfo[] newArray(int i3) {
                return new ChannelDetailPageJumpInfo[i3];
            }
        }

        public ChannelDetailPageJumpInfo(String str) {
            this.detailId = str;
        }

        @Nullable
        public static ChannelDetailPageJumpInfo loadFrom(Bundle bundle) {
            return (ChannelDetailPageJumpInfo) bundle.getParcelable(ChannelDetailPageJumpInfo.class.getCanonicalName());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDetailId() {
            return this.detailId;
        }

        public void saveTo(Bundle bundle) {
            bundle.putParcelable(ChannelDetailPageJumpInfo.class.getCanonicalName(), this);
        }

        public String toString() {
            return "ChannelDetailPageJumpInfo{detailId='" + this.detailId + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.detailId);
        }

        protected ChannelDetailPageJumpInfo(Parcel parcel) {
            this.detailId = parcel.readString();
        }
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public JumpGuildParam m187clone() throws CloneNotSupportedException {
        JumpGuildParam jumpGuildParam = (JumpGuildParam) super.clone();
        jumpGuildParam.guildId = this.guildId;
        jumpGuildParam.categoryId = this.categoryId;
        jumpGuildParam.channelId = this.channelId;
        jumpGuildParam.isDirectMessage = this.isDirectMessage;
        jumpGuildParam.extras = this.extras;
        jumpGuildParam.feedReportSourceInfo = this.feedReportSourceInfo;
        jumpGuildParam.joinInfoParam = this.joinInfoParam;
        jumpGuildParam.detailPageJumpInfo = this.detailPageJumpInfo;
        return jumpGuildParam;
    }

    /* loaded from: classes13.dex */
    public static class JoinInfoParam implements Parcelable, Serializable {
        public static final Parcelable.Creator<JoinInfoParam> CREATOR = new a();

        @Nullable
        private String afterJoinJumpChannelId;

        @Nullable
        private String arkContentId;

        @Nullable
        private String arkInviteCode;
        private int entranceId;
        private String inviteUUID;
        private String joinSignature;
        private String mainSource;
        private String subSource;

        /* loaded from: classes13.dex */
        class a implements Parcelable.Creator<JoinInfoParam> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public JoinInfoParam createFromParcel(Parcel parcel) {
                return new JoinInfoParam(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public JoinInfoParam[] newArray(int i3) {
                return new JoinInfoParam[i3];
            }
        }

        public JoinInfoParam(String str, String str2, String str3) {
            this.entranceId = Integer.MIN_VALUE;
            this.afterJoinJumpChannelId = "";
            this.arkInviteCode = "";
            this.arkContentId = "";
            this.inviteUUID = "";
            this.joinSignature = str;
            this.mainSource = str2;
            this.subSource = str3;
        }

        @Nullable
        public static JoinInfoParam loadFrom(Bundle bundle) {
            return (JoinInfoParam) bundle.getParcelable(JoinInfoParam.class.getCanonicalName());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public String getAfterJoinJumpChannelId() {
            return this.afterJoinJumpChannelId;
        }

        @Nullable
        public String getArkContentId() {
            return this.arkContentId;
        }

        @Nullable
        public String getArkInviteCode() {
            return this.arkInviteCode;
        }

        public String getInviteUUID() {
            return this.inviteUUID;
        }

        public String getJoinSignature() {
            return this.joinSignature;
        }

        public String getMainSource() {
            return this.mainSource;
        }

        public int getPageEntranceId() {
            return this.entranceId;
        }

        public String getSubSource() {
            return this.subSource;
        }

        public boolean isValid() {
            if (!TextUtils.isEmpty(this.joinSignature) && !TextUtils.isEmpty(this.mainSource) && !TextUtils.isEmpty(this.subSource)) {
                return true;
            }
            return false;
        }

        public void saveTo(Bundle bundle) {
            bundle.putParcelable(JoinInfoParam.class.getCanonicalName(), this);
        }

        public void setAfterJoinJumpChannelId(@Nullable String str) {
            this.afterJoinJumpChannelId = str;
        }

        public void setArkJumpId(@Nullable String str, @Nullable String str2) {
            this.arkInviteCode = str;
            this.arkContentId = str2;
        }

        public void setInviteUUID(String str) {
            this.inviteUUID = str;
        }

        public void setJoinSignature(String str) {
            this.joinSignature = str;
        }

        public void setMainAndSubSource(String str, String str2) {
            this.mainSource = str;
            this.subSource = str2;
        }

        public void setMainSource(String str) {
            this.mainSource = str;
        }

        public void setPageEntranceId(int i3) {
            this.entranceId = i3;
        }

        public void setSubSource(String str) {
            this.subSource = str;
        }

        public String toString() {
            return "JoinInfoParam{channelId='" + this.afterJoinJumpChannelId + "', joinSignature='" + this.joinSignature + "', mainSource='" + this.mainSource + "', subSource='" + this.subSource + "', arkInviteCode='" + this.arkInviteCode + "', arkContentId='" + this.arkContentId + "', inviteUUID='" + this.inviteUUID + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.afterJoinJumpChannelId);
            parcel.writeString(this.joinSignature);
            parcel.writeString(this.mainSource);
            parcel.writeString(this.subSource);
            parcel.writeString(this.arkInviteCode);
            parcel.writeString(this.arkContentId);
            parcel.writeString(this.inviteUUID);
        }

        public JoinInfoParam(@Nullable String str, String str2, String str3, String str4) {
            this.entranceId = Integer.MIN_VALUE;
            this.arkInviteCode = "";
            this.arkContentId = "";
            this.inviteUUID = "";
            this.afterJoinJumpChannelId = str;
            this.joinSignature = str2;
            this.mainSource = str3;
            this.subSource = str4;
        }

        protected JoinInfoParam(Parcel parcel) {
            this.joinSignature = "";
            this.mainSource = "";
            this.subSource = "";
            this.entranceId = Integer.MIN_VALUE;
            this.afterJoinJumpChannelId = "";
            this.arkInviteCode = "";
            this.arkContentId = "";
            this.inviteUUID = "";
            this.afterJoinJumpChannelId = parcel.readString();
            this.joinSignature = parcel.readString();
            this.mainSource = parcel.readString();
            this.subSource = parcel.readString();
            this.arkInviteCode = parcel.readString();
            this.arkContentId = parcel.readString();
            this.inviteUUID = parcel.readString();
        }

        public JoinInfoParam() {
            this.joinSignature = "";
            this.mainSource = "";
            this.subSource = "";
            this.entranceId = Integer.MIN_VALUE;
            this.afterJoinJumpChannelId = "";
            this.arkInviteCode = "";
            this.arkContentId = "";
            this.inviteUUID = "";
        }
    }

    public JumpGuildParam(String str, String str2, String str3, String str4, String str5) {
        this.isDirectMessage = false;
        this.businessType = 0;
        this.inviteCode = "";
        this.guildNumber = "";
        this.feedReportSourceInfo = new GuildFeedReportSourceInfo();
        this.extras = new Bundle();
        this.guildId = str;
        this.channelId = str2 == null ? "" : str2;
        this.joinInfoParam = new JoinInfoParam("", str3, str4, str5);
    }

    public JumpGuildParam(String str, @Nullable String str2, JoinInfoParam joinInfoParam) {
        this.isDirectMessage = false;
        this.businessType = 0;
        this.inviteCode = "";
        this.guildNumber = "";
        this.feedReportSourceInfo = new GuildFeedReportSourceInfo();
        this.extras = new Bundle();
        this.guildId = str;
        this.channelId = str2 == null ? "" : str2;
        this.joinInfoParam = joinInfoParam;
        if (joinInfoParam == null) {
            this.joinInfoParam = new JoinInfoParam("", "", "", "");
        }
    }

    public void setReportSourceInfo(GuildAppReportSourceInfo guildAppReportSourceInfo) {
    }

    public JumpGuildParam(String str) {
        this.isDirectMessage = false;
        this.businessType = 0;
        this.inviteCode = "";
        this.guildNumber = "";
        this.feedReportSourceInfo = new GuildFeedReportSourceInfo();
        this.extras = new Bundle();
        this.guildNumber = str;
        this.joinInfoParam = new JoinInfoParam("", "", "", "");
    }

    protected JumpGuildParam(Parcel parcel) {
        this.isDirectMessage = false;
        this.businessType = 0;
        this.inviteCode = "";
        this.guildNumber = "";
        this.feedReportSourceInfo = new GuildFeedReportSourceInfo();
        this.extras = new Bundle();
        this.guildId = parcel.readString();
        this.categoryId = parcel.readLong();
        this.channelId = parcel.readString();
        this.isDirectMessage = parcel.readByte() != 0;
        this.businessType = parcel.readInt();
        this.inviteCode = parcel.readString();
        this.guildNumber = parcel.readString();
        this.extras = parcel.readBundle(getClass().getClassLoader());
        this.joinInfoParam = (JoinInfoParam) parcel.readParcelable(JoinInfoParam.class.getClassLoader());
        this.detailPageJumpInfo = (ChannelDetailPageJumpInfo) parcel.readParcelable(ChannelDetailPageJumpInfo.class.getClassLoader());
        this.feedReportSourceInfo = (GuildFeedReportSourceInfo) parcel.readParcelable(GuildFeedReportSourceInfo.class.getClassLoader());
    }
}
