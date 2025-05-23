package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPersonalUserMedalRefreshEvent extends SimpleBaseEvent {
    private final String mJson;

    public QFSPersonalUserMedalRefreshEvent(String str) {
        this.mJson = str;
    }

    public String getJson() {
        return this.mJson;
    }
}
