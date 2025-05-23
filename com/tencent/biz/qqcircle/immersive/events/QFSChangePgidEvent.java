package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSChangePgidEvent extends SimpleBaseEvent {
    private final String dtPgId;

    public QFSChangePgidEvent(String str) {
        this.dtPgId = str;
    }

    public String getDtPgId() {
        return this.dtPgId;
    }
}
