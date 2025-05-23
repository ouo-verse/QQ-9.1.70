package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildPublishReEditEvent extends SimpleBaseEvent {
    private long code;
    private String feedId;

    /* renamed from: msg, reason: collision with root package name */
    private String f218568msg;

    public GuildPublishReEditEvent(long j3, String str, String str2) {
        this.code = j3;
        this.f218568msg = str;
        this.feedId = str2;
    }

    public long getCode() {
        return this.code;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getMsg() {
        return this.f218568msg;
    }

    public void setCode(long j3) {
        this.code = j3;
    }

    public void setMsg(String str) {
        this.f218568msg = str;
    }
}
