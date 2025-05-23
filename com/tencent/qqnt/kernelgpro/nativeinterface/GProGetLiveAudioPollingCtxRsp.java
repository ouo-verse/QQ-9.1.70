package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class GProGetLiveAudioPollingCtxRsp {
    public HashMap<Integer, GProRealTimeChannels> stateMap = new HashMap<>();

    public HashMap<Integer, GProRealTimeChannels> getStateMap() {
        return this.stateMap;
    }

    public String toString() {
        return "GProGetLiveAudioPollingCtxRsp{stateMap=" + this.stateMap + ",}";
    }
}
