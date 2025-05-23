package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class GProGetActiveLiveAudioChannelNumRsp {
    public HashMap<Integer, Integer> activeNumMap = new HashMap<>();

    public HashMap<Integer, Integer> getActiveNumMap() {
        return this.activeNumMap;
    }

    public String toString() {
        return "GProGetActiveLiveAudioChannelNumRsp{activeNumMap=" + this.activeNumMap + ",}";
    }
}
