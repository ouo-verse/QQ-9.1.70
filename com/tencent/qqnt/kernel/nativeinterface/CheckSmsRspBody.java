package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckSmsRspBody {
    public LoginRspInfo loginRspInfo = new LoginRspInfo();
    public BindUinInfo bindUinInfo = new BindUinInfo();

    public BindUinInfo getBindUinInfo() {
        return this.bindUinInfo;
    }

    public LoginRspInfo getLoginRspInfo() {
        return this.loginRspInfo;
    }

    public String toString() {
        return "CheckSmsRspBody{loginRspInfo=" + this.loginRspInfo + ",bindUinInfo=" + this.bindUinInfo + ",}";
    }
}
