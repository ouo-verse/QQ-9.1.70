package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildGetDraftTaskOperationEvent extends SimpleBaseEvent {
    private String mChannelId;
    private String mGuildId;
    private boolean mIpcFlag;
    private String mPublisherType;
    private String mRequestId;
    private int mScope = 0;

    public String getChannelId() {
        return this.mChannelId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public String getPublisherType() {
        return this.mPublisherType;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public int getScope() {
        return this.mScope;
    }

    public boolean isIpcEvent() {
        return this.mIpcFlag;
    }

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setGuildId(String str) {
        this.mGuildId = str;
    }

    public void setIpcEvent(boolean z16) {
        this.mIpcFlag = z16;
    }

    public void setPublisherType(String str) {
        this.mPublisherType = str;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public void setScope(int i3) {
        this.mScope = i3;
    }

    public String toString() {
        return "GuildGetDraftTaskOperationEvent{ mRequestId=" + this.mRequestId + "mGuildId='" + this.mGuildId + "', mChannelId='" + this.mChannelId + "', mPublisherType='" + this.mPublisherType + "', mScope='" + this.mScope + "', mIpcFlag=" + this.mIpcFlag + '}';
    }
}
