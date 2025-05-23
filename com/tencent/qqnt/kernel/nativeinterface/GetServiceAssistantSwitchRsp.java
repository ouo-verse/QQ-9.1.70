package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetServiceAssistantSwitchRsp {
    public int appTypeSwitch;
    public int msgTypeSwitch;
    public byte[] rspBuf;
    public ArrayList<ServiceAssistantAppSwitch> appSwitch = new ArrayList<>();
    public ArrayList<ServiceAssistantTemplateSwitch> templateSwitch = new ArrayList<>();

    public ArrayList<ServiceAssistantAppSwitch> getAppSwitch() {
        return this.appSwitch;
    }

    public int getAppTypeSwitch() {
        return this.appTypeSwitch;
    }

    public int getMsgTypeSwitch() {
        return this.msgTypeSwitch;
    }

    public byte[] getRspBuf() {
        return this.rspBuf;
    }

    public ArrayList<ServiceAssistantTemplateSwitch> getTemplateSwitch() {
        return this.templateSwitch;
    }
}
