package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildUpdateOperationImgEvent extends SimpleBaseEvent {
    private String mGuildId;
    private String mPicUrl;

    public GuildUpdateOperationImgEvent(String str, String str2) {
        this.mPicUrl = str;
        this.mGuildId = str2;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public String getUrl() {
        return this.mPicUrl;
    }
}
