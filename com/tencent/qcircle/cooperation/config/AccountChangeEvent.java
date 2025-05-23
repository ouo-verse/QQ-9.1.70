package com.tencent.qcircle.cooperation.config;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AccountChangeEvent extends SimpleBaseEvent {
    private final boolean mIsSwitchAccount;

    public AccountChangeEvent(boolean z16) {
        this.mIsSwitchAccount = z16;
    }

    public boolean hasSwitchAccount() {
        return this.mIsSwitchAccount;
    }
}
