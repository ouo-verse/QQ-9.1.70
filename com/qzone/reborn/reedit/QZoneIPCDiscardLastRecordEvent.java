package com.qzone.reborn.reedit;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes37.dex */
public class QZoneIPCDiscardLastRecordEvent extends SimpleBaseEvent {
    public String mClientKey;

    public QZoneIPCDiscardLastRecordEvent(String str) {
        this.mClientKey = str;
    }
}
