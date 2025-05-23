package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AutoLoginInfo {
    public AutoLoginSwitchState autoLoginSwitchState;
    public boolean isShowAutoLoginSwitch;
    public String tipsContent;
    public String tipsTitle;

    public AutoLoginInfo() {
        this.autoLoginSwitchState = AutoLoginSwitchState.values()[0];
        this.tipsTitle = "";
        this.tipsContent = "";
    }

    public AutoLoginSwitchState getAutoLoginSwitchState() {
        return this.autoLoginSwitchState;
    }

    public boolean getIsShowAutoLoginSwitch() {
        return this.isShowAutoLoginSwitch;
    }

    public String getTipsContent() {
        return this.tipsContent;
    }

    public String getTipsTitle() {
        return this.tipsTitle;
    }

    public String toString() {
        return "AutoLoginInfo{isShowAutoLoginSwitch=" + this.isShowAutoLoginSwitch + ",autoLoginSwitchState=" + this.autoLoginSwitchState + ",tipsTitle=" + this.tipsTitle + ",tipsContent=" + this.tipsContent + ",}";
    }

    public AutoLoginInfo(boolean z16, AutoLoginSwitchState autoLoginSwitchState, String str, String str2) {
        AutoLoginSwitchState autoLoginSwitchState2 = AutoLoginSwitchState.values()[0];
        this.isShowAutoLoginSwitch = z16;
        this.autoLoginSwitchState = autoLoginSwitchState;
        this.tipsTitle = str;
        this.tipsContent = str2;
    }
}
