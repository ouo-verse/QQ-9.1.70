package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;

/* loaded from: classes13.dex */
public class GuildPublishSuccessGetFeedEvent extends SimpleBaseEvent {
    private String mChannelId;
    private String mGuildId;
    private boolean mIsEdit;
    private boolean mIsFullDetail;
    private String mMainTaskId;
    private GProStFeed mStFeed;
    private boolean showSuccessToast = true;

    public String getChannelId() {
        return this.mChannelId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public GProStFeed getStFeed() {
        return this.mStFeed;
    }

    public boolean isEdit() {
        return this.mIsEdit;
    }

    public boolean isFeedFullDetail() {
        return this.mIsFullDetail;
    }

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setEdit(boolean z16) {
        this.mIsEdit = z16;
    }

    public void setFeedFullDetail(boolean z16) {
        this.mIsFullDetail = z16;
    }

    public void setGuildId(String str) {
        this.mGuildId = str;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setShowSuccessToast(boolean z16) {
        this.showSuccessToast = z16;
    }

    public void setStFeed(GProStFeed gProStFeed) {
        this.mStFeed = gProStFeed;
    }

    public boolean showSuccessToast() {
        return this.showSuccessToast;
    }
}
