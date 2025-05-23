package com.tencent.biz.pubaccount.weishi.event;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSClearModeEvent extends WSSimpleBaseEvent {
    private boolean isClearMode;

    public WSClearModeEvent(boolean z16) {
        this.isClearMode = z16;
    }

    public boolean isClearMode() {
        return this.isClearMode;
    }
}
