package com.tencent.qqlive.module.videoreport;

/* compiled from: P */
/* loaded from: classes22.dex */
public enum SessionChangeReason {
    APP_START_UP(0),
    CALL_UP_FROM_OUTER(1),
    REENTER_FOREGROUND_AND_TIMEOUT(2),
    ADDITIONAL_SESSION_REENTER_FOREGROUND(3);

    public final int reason;

    SessionChangeReason(int i3) {
        this.reason = i3;
    }
}
