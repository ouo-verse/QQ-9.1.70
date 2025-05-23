package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildSaveDraftTaskOperationEvent extends GuildIPCCompatEvent {
    private String mFeedJson;
    private String mFeedPublishJson;
    private String mMainTaskId;
    private int mScope;

    public GuildSaveDraftTaskOperationEvent(String str) {
        super("GuildSaveDraftTaskOperationEvent" + str);
        this.mScope = 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent
    protected void afterSaveInFile() {
        this.mFeedPublishJson = "";
        this.mFeedJson = "";
    }

    public String getFeedJson() {
        return this.mFeedJson;
    }

    public String getFeedPublishJson() {
        return this.mFeedPublishJson;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public int getScope() {
        return this.mScope;
    }

    public boolean isOverIpcThresholdLength() {
        int i3;
        int i16;
        String str = this.mFeedJson;
        if (str != null) {
            i3 = str.length();
        } else {
            i3 = 0;
        }
        String str2 = this.mFeedPublishJson;
        if (str2 != null) {
            i16 = str2.length();
        } else {
            i16 = 0;
        }
        if (i3 + i16 <= 188184) {
            return false;
        }
        return true;
    }

    public void setFeedJson(String str) {
        this.mFeedJson = str;
    }

    public void setFeedPublishJson(String str) {
        this.mFeedPublishJson = str;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setScope(int i3) {
        this.mScope = i3;
    }

    @Override // com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent
    public String toString() {
        return "GuildSaveDraftTaskOperationEvent{ super: " + super.toString() + "mMainTaskId='" + this.mMainTaskId + "', mFeedJson='" + this.mFeedJson + "', mFeedPublishJson='" + this.mFeedPublishJson + "', mScope='" + this.mScope + "'} " + super.toString();
    }
}
