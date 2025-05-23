package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NeedConfirmSwitchInfo {
    public NeedConfirmState needConfirmState;
    public TrustedDeviceState trustedDeviceState;

    public NeedConfirmSwitchInfo() {
        this.trustedDeviceState = TrustedDeviceState.values()[0];
        this.needConfirmState = NeedConfirmState.values()[0];
    }

    public NeedConfirmState getNeedConfirmState() {
        return this.needConfirmState;
    }

    public TrustedDeviceState getTrustedDeviceState() {
        return this.trustedDeviceState;
    }

    public NeedConfirmSwitchInfo(TrustedDeviceState trustedDeviceState, NeedConfirmState needConfirmState) {
        this.trustedDeviceState = TrustedDeviceState.values()[0];
        NeedConfirmState needConfirmState2 = NeedConfirmState.values()[0];
        this.trustedDeviceState = trustedDeviceState;
        this.needConfirmState = needConfirmState;
    }
}
