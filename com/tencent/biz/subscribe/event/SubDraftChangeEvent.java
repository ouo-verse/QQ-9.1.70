package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubDraftChangeEvent extends SimpleBaseEvent {
    private String draftID;
    private boolean mIsSave;

    public String getDraftID() {
        return this.draftID;
    }

    public boolean getIsSave() {
        return this.mIsSave;
    }

    public void setDraftID(String str) {
        this.draftID = str;
    }

    public void setIsSave(boolean z16) {
        this.mIsSave = z16;
    }
}
