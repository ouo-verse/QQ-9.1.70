package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes16.dex */
public class QFSShortVideoPositionEvent extends SimpleBaseEvent {
    private Long mChatSeq;

    public QFSShortVideoPositionEvent(Long l3) {
        this.mChatSeq = l3;
    }

    public Long getChatSeq() {
        return this.mChatSeq;
    }
}
