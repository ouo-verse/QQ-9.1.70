package com.tencent.mobileqq.guild.feed.publish.event;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildCreateTaskOperationEvent extends SimpleBaseEvent {
    private int mBusinessType;
    private String mChannelId;
    private boolean mEdit;
    private String mGuildId;
    private String mMainTaskId;
    private GuildFeedReportSourceInfo mReportMap;
    private final int mScope;
    private Boolean mEnablePreUpload = null;
    private boolean mPreUploadGuardByNetworkCondition = true;

    public GuildCreateTaskOperationEvent(String str, String str2, String str3, boolean z16, int i3, GuildFeedReportSourceInfo guildFeedReportSourceInfo, int i16) {
        this.mMainTaskId = str;
        this.mGuildId = str2;
        this.mChannelId = str3;
        this.mEdit = z16;
        this.mBusinessType = i3;
        this.mReportMap = guildFeedReportSourceInfo;
        this.mScope = i16;
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    @Nullable
    public Boolean getEnablePreUpload() {
        return this.mEnablePreUpload;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public GuildFeedReportSourceInfo getReportMap() {
        return this.mReportMap;
    }

    public int getScope() {
        return this.mScope;
    }

    public boolean isEdit() {
        return this.mEdit;
    }

    public boolean isPreUploadGuardByNetworkCondition() {
        return this.mPreUploadGuardByNetworkCondition;
    }

    public void setBusinessType(int i3) {
        this.mBusinessType = i3;
    }

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setEdit(boolean z16) {
        this.mEdit = z16;
    }

    public void setEnablePreUpload(@Nullable Boolean bool) {
        this.mEnablePreUpload = bool;
    }

    public void setGuildId(String str) {
        this.mGuildId = str;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setPreUploadGuardByNetworkCondition(boolean z16) {
        this.mPreUploadGuardByNetworkCondition = z16;
    }

    public String toString() {
        return "GuildCreateTaskOperationEvent{mMainTaskId='" + this.mMainTaskId + "', mGuildId='" + this.mGuildId + "', mChannelId='" + this.mChannelId + "', mEdit=" + this.mEdit + "} " + super.toString();
    }
}
