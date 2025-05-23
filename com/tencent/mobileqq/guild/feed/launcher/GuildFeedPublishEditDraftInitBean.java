package com.tencent.mobileqq.guild.feed.launcher;

import java.io.Serializable;

/* loaded from: classes13.dex */
public class GuildFeedPublishEditDraftInitBean implements Serializable {
    private String mFeedJson;
    private String mTaskId;

    public String getFeedJson() {
        return this.mFeedJson;
    }

    public String getTaskId() {
        return this.mTaskId;
    }

    public void setFeedJson(String str) {
        this.mFeedJson = str;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }
}
