package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildInboxEmptyPartEvent extends SimpleBaseEvent {
    private String mErrorDesc;
    private String mErrorMsg;
    private boolean mShowPartView;

    public GuildInboxEmptyPartEvent(boolean z16) {
        this.mShowPartView = z16;
    }

    public String getErrorDesc() {
        return this.mErrorDesc;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public boolean isShowView() {
        return this.mShowPartView;
    }

    public void setErrorDesc(String str) {
        this.mErrorDesc = str;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }
}
