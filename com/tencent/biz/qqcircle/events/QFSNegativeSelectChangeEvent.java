package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNegativeSelectChangeEvent extends SimpleBaseEvent {
    private Boolean mIsSelected;
    private String mSelectedText;

    public QFSNegativeSelectChangeEvent(Boolean bool, String str) {
        this.mIsSelected = bool;
        this.mSelectedText = str;
    }

    public Boolean getSelected() {
        return this.mIsSelected;
    }

    public String getSelectedText() {
        return this.mSelectedText;
    }
}
