package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSClearTroopRedDotEvent extends SimpleBaseEvent {
    private String mSenderUin;
    private String mTroopId;

    public QFSClearTroopRedDotEvent(String str, String str2) {
        this.mTroopId = str;
        this.mSenderUin = str2;
    }

    public String getSenderUin() {
        return this.mSenderUin;
    }

    public String getTroopId() {
        return this.mTroopId;
    }
}
