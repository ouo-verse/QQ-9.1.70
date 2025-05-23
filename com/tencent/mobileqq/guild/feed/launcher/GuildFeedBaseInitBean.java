package com.tencent.mobileqq.guild.feed.launcher;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedBaseInitBean implements Serializable {
    private static final long serialVersionUID = 496032981804748794L;
    private GuildFeedReportSourceInfo feedReportSourceInfo;
    private String mBannerId;
    private String mChannelId;
    private String mChannelName;
    private String mGuildId;
    private String mGuildUrl;
    private boolean mIsMember;
    private JumpGuildParam.JoinInfoParam mJoinInfoParam;
    private GuildAppReportSourceInfo mJumpExtraInfo;
    private int mShareSource;
    private int mTroopRole;
    private String mUserType;
    protected HashMap<String, Serializable> mAttrs = new HashMap<>();
    private int mBusinessType = 0;
    private String mTroopUin = "";
    private int mOpenFrom = 0;
    private int mDiscoverTab = -1;
    private long mTopicId = 0;
    private Boolean isVisitor = Boolean.FALSE;
    private int mImmersiveSource = 6;

    public HashMap<String, Serializable> getAttrs() {
        return this.mAttrs;
    }

    public String getBannerId() {
        return this.mBannerId;
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public int getDiscoverTab() {
        return this.mDiscoverTab;
    }

    public GuildFeedReportSourceInfo getFeedReportSourceInfo() {
        if (this.feedReportSourceInfo == null) {
            GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
            this.feedReportSourceInfo = guildFeedReportSourceInfo;
            guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", "ark_link_share");
        }
        return this.feedReportSourceInfo;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public String getGuildUrl() {
        return this.mGuildUrl;
    }

    public int getImmersiveSource() {
        return this.mImmersiveSource;
    }

    public Boolean getIsVisitor() {
        return this.isVisitor;
    }

    public JumpGuildParam.JoinInfoParam getJoinInfoParam() {
        return this.mJoinInfoParam;
    }

    public String getJoinSin() {
        JumpGuildParam.JoinInfoParam joinInfoParam = this.mJoinInfoParam;
        if (joinInfoParam == null) {
            return "";
        }
        return joinInfoParam.getJoinSignature();
    }

    public GuildAppReportSourceInfo getJumpExtraInfo() {
        if (this.mJumpExtraInfo == null) {
            this.mJumpExtraInfo = new GuildAppReportSourceInfo();
        }
        return this.mJumpExtraInfo;
    }

    public int getOpenFrom() {
        return this.mOpenFrom;
    }

    public String getPageForumType(String str) {
        if (TextUtils.equals(str, "pg_sgrp_forum")) {
            return getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_page_forum_type");
        }
        return "";
    }

    public String getPageId() {
        String str = getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_page_id");
        if (TextUtils.isEmpty(str)) {
            return "other";
        }
        return str;
    }

    public String getPrePageForumType(String str) {
        if (TextUtils.equals(str, "pg_sgrp_forum")) {
            return getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_pre_page_forum_type");
        }
        return "";
    }

    public String getPrePageId() {
        String str = getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_pre_page_id");
        if (TextUtils.isEmpty(str)) {
            return "other";
        }
        return str;
    }

    public int getShareSource() {
        return this.mShareSource;
    }

    public long getTopicId() {
        return this.mTopicId;
    }

    public int getTroopRole() {
        return this.mTroopRole;
    }

    public String getTroopUin() {
        return this.mTroopUin;
    }

    public String getUserType() {
        return this.mUserType;
    }

    public boolean isMember() {
        return this.mIsMember;
    }

    public GuildFeedBaseInitBean setAttrs(HashMap<String, Serializable> hashMap) {
        this.mAttrs = hashMap;
        return this;
    }

    public void setBannerId(String str) {
        this.mBannerId = str;
    }

    public void setBusinessType(int i3) {
        this.mBusinessType = i3;
    }

    public GuildFeedBaseInitBean setChannelId(String str) {
        this.mChannelId = str;
        return this;
    }

    public GuildFeedBaseInitBean setChannelName(String str) {
        this.mChannelName = str;
        return this;
    }

    public void setDiscoverTab(int i3) {
        this.mDiscoverTab = i3;
    }

    public GuildFeedBaseInitBean setFeedReportSourceInfo(GuildFeedReportSourceInfo guildFeedReportSourceInfo) {
        this.feedReportSourceInfo = guildFeedReportSourceInfo;
        return this;
    }

    public GuildFeedBaseInitBean setGuildId(String str) {
        this.mGuildId = str;
        return this;
    }

    public GuildFeedBaseInitBean setGuildUrl(String str) {
        this.mGuildUrl = str;
        return this;
    }

    public GuildFeedBaseInitBean setImmersiveSource(int i3) {
        this.mImmersiveSource = i3;
        return this;
    }

    public GuildFeedBaseInitBean setIsMember(boolean z16) {
        this.mIsMember = z16;
        return this;
    }

    public void setIsVisitor(Boolean bool) {
        this.isVisitor = bool;
    }

    public GuildFeedBaseInitBean setJoinInfoParam(JumpGuildParam.JoinInfoParam joinInfoParam) {
        this.mJoinInfoParam = joinInfoParam;
        return this;
    }

    public GuildFeedBaseInitBean setJumpExtraInfo(GuildAppReportSourceInfo guildAppReportSourceInfo) {
        this.mJumpExtraInfo = guildAppReportSourceInfo;
        return this;
    }

    public GuildFeedBaseInitBean setOpenFrom(int i3) {
        this.mOpenFrom = i3;
        return this;
    }

    public GuildFeedBaseInitBean setShareSource(int i3) {
        this.mShareSource = i3;
        return this;
    }

    public void setTopicId(long j3) {
        this.mTopicId = j3;
    }

    public void setTroopRole(int i3) {
        this.mTroopRole = i3;
    }

    public void setTroopUin(String str) {
        this.mTroopUin = str;
    }

    public GuildFeedBaseInitBean setUserType(String str) {
        this.mUserType = str;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GuildFeedBaseInitBean{");
        stringBuffer.append("mAttrs=");
        stringBuffer.append(this.mAttrs);
        stringBuffer.append(", mIsMember=");
        stringBuffer.append(this.mIsMember);
        stringBuffer.append(", mGuildId='");
        stringBuffer.append(this.mGuildId);
        stringBuffer.append('\'');
        stringBuffer.append(", mChannelId='");
        stringBuffer.append(this.mChannelId);
        stringBuffer.append('\'');
        stringBuffer.append(", mGuildUrl='");
        stringBuffer.append(this.mGuildUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mChannelName='");
        stringBuffer.append(this.mChannelName);
        stringBuffer.append('\'');
        stringBuffer.append(", mJoinInfoParam='");
        stringBuffer.append(this.mJoinInfoParam);
        stringBuffer.append('\'');
        stringBuffer.append(", mShareSource=");
        stringBuffer.append(this.mShareSource);
        stringBuffer.append('\'');
        stringBuffer.append(", mBannerId=");
        stringBuffer.append(this.mBannerId);
        stringBuffer.append('\'');
        stringBuffer.append(", mBusinessType=");
        stringBuffer.append(this.mBusinessType);
        stringBuffer.append('\'');
        stringBuffer.append(", mDiscoverTab=");
        stringBuffer.append(this.mDiscoverTab);
        stringBuffer.append('\'');
        stringBuffer.append(", mImmersiveSource=");
        stringBuffer.append(this.mImmersiveSource);
        stringBuffer.append('\'');
        stringBuffer.append(", mTroopUin=");
        stringBuffer.append(this.mTroopUin);
        stringBuffer.append('\'');
        stringBuffer.append(", mTroopRole=");
        stringBuffer.append(this.mTroopRole);
        stringBuffer.append('\'');
        if (this.mJumpExtraInfo != null) {
            stringBuffer.append(", mJumpExtraInfo.hashcode=");
            stringBuffer.append(this.mJumpExtraInfo.hashCode());
            stringBuffer.append(", mJumpExtraInfo=");
            stringBuffer.append(this.mJumpExtraInfo);
        } else {
            stringBuffer.append(", mJumpExtraInfo=null");
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
