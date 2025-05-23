package com.tencent.biz.richframework.video.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMediaFocusChangeEvent extends SimpleBaseEvent {
    private final String mConflictBusinessName;
    private final String mFocusBusinessName;
    private final boolean mHasFocusConflict;

    public RFWMediaFocusChangeEvent(boolean z16, String str, String str2) {
        this.mHasFocusConflict = z16;
        this.mFocusBusinessName = str;
        this.mConflictBusinessName = str2;
    }

    public String getConflictBusinessName() {
        return this.mConflictBusinessName;
    }

    public String getFocusBusinessName() {
        return this.mFocusBusinessName;
    }

    public boolean hasFocusConflict() {
        return this.mHasFocusConflict;
    }
}
