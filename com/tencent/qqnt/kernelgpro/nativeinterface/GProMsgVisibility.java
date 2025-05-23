package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMsgVisibility {
    public ArrayList<Long> excludeUins = new ArrayList<>();

    public ArrayList<Long> getExcludeUins() {
        return this.excludeUins;
    }

    public String toString() {
        return "GProMsgVisibility{excludeUins=" + this.excludeUins + ",}";
    }
}
