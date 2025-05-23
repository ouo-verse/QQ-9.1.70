package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BindUinInfo {
    public ArrayList<UinInfo> uinInfoList = new ArrayList<>();
    public String unbindWording = "";

    public ArrayList<UinInfo> getUinInfoList() {
        return this.uinInfoList;
    }

    public String getUnbindWording() {
        return this.unbindWording;
    }

    public String toString() {
        return "BindUinInfo{uinInfoList=" + this.uinInfoList + ",unbindWording=" + this.unbindWording + ",}";
    }
}
