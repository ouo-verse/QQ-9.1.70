package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.utils.StringUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSInteractActionEvent extends SimpleBaseEvent {
    private final int mInteractActionType;
    private boolean mIsTriggeredInteract;
    private final String mRelationId;

    public QFSInteractActionEvent(String str, int i3) {
        this.mRelationId = StringUtil.isEmpty(str) ? "null" : str;
        this.mInteractActionType = i3;
        this.mIsTriggeredInteract = true;
    }

    public int getInteractActionType() {
        return this.mInteractActionType;
    }

    public String getRelationId() {
        return this.mRelationId;
    }

    public boolean isTriggered() {
        return this.mIsTriggeredInteract;
    }
}
