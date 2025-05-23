package com.tencent.biz.pubaccount.weishi.event;

/* loaded from: classes32.dex */
public class WSPlayerMuteEvent extends WSSimpleBaseEvent {
    private boolean mIsPlayerMute;

    public WSPlayerMuteEvent(boolean z16) {
        this.mIsPlayerMute = z16;
    }

    public boolean isPlayerMute() {
        return this.mIsPlayerMute;
    }
}
