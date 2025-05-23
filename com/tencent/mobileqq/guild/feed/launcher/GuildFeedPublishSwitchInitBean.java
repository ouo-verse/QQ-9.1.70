package com.tencent.mobileqq.guild.feed.launcher;

/* loaded from: classes13.dex */
public class GuildFeedPublishSwitchInitBean extends GuildFeedPublishInitBean {
    private String mFeedJson;
    private Boolean mIsEditPublish;

    public String getFeedJson() {
        return this.mFeedJson;
    }

    public Boolean isEditNativePublish() {
        return this.mIsEditPublish;
    }

    public void setEditPublish(Boolean bool) {
        this.mIsEditPublish = bool;
    }

    public void setFeedJson(String str) {
        this.mFeedJson = str;
    }
}
