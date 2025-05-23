package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ErrorDetail {
    public ErrorNeedVerifyNewDevice msgNeedVerifyNewDevice = new ErrorNeedVerifyNewDevice();
    public ErrorUnregistered msgUnregistered = new ErrorUnregistered();
    public ErrorBeenForbiden msgBeenForbiden = new ErrorBeenForbiden();
    public ErrorNiceAccountExpire msgNiceAccountExpire = new ErrorNiceAccountExpire();

    public ErrorBeenForbiden getMsgBeenForbiden() {
        return this.msgBeenForbiden;
    }

    public ErrorNeedVerifyNewDevice getMsgNeedVerifyNewDevice() {
        return this.msgNeedVerifyNewDevice;
    }

    public ErrorNiceAccountExpire getMsgNiceAccountExpire() {
        return this.msgNiceAccountExpire;
    }

    public ErrorUnregistered getMsgUnregistered() {
        return this.msgUnregistered;
    }

    public String toString() {
        return "ErrorDetail{msgNeedVerifyNewDevice=" + this.msgNeedVerifyNewDevice + ",msgUnregistered=" + this.msgUnregistered + ",msgBeenForbiden=" + this.msgBeenForbiden + ",msgNiceAccountExpire=" + this.msgNiceAccountExpire + ",}";
    }
}
