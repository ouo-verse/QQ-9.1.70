package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProClientShowCfg {
    public ArrayList<GProConfigItem> configItem = new ArrayList<>();

    public ArrayList<GProConfigItem> getConfigItem() {
        return this.configItem;
    }

    public String toString() {
        return "GProClientShowCfg{configItem=" + this.configItem + ",}";
    }
}
