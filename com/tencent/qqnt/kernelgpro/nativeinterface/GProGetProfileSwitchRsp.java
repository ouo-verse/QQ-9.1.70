package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetProfileSwitchRsp {
    public ArrayList<Integer> openSwitch = new ArrayList<>();
    public ArrayList<Integer> closeSwitch = new ArrayList<>();

    public ArrayList<Integer> getCloseSwitch() {
        return this.closeSwitch;
    }

    public ArrayList<Integer> getOpenSwitch() {
        return this.openSwitch;
    }

    public String toString() {
        return "GProGetProfileSwitchRsp{openSwitch=" + this.openSwitch + ",closeSwitch=" + this.closeSwitch + ",}";
    }
}
