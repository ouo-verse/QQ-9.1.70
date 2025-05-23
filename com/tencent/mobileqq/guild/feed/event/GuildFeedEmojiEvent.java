package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedEmojiEvent extends SimpleBaseEvent {
    public int mEmojiId;
    public int mEmojiType;
    public String mUrl;

    public GuildFeedEmojiEvent(int i3, int i16, String str) {
        this.mEmojiType = i3;
        this.mEmojiId = i16;
        this.mUrl = str;
    }

    public int getEmojiId() {
        return this.mEmojiId;
    }

    public int getEmojiType() {
        return this.mEmojiType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String toString() {
        return "GuildFeedEmojiEvent{mEmojiType=" + this.mEmojiType + ", mEmojiId='" + this.mEmojiId + "', mUrl='" + this.mUrl + "'} " + super.toString();
    }
}
