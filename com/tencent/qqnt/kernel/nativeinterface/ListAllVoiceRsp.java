package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ListAllVoiceRsp {
    public ArrayList<VoicePair> voiceMap = new ArrayList<>();

    public ArrayList<VoicePair> getVoiceMap() {
        return this.voiceMap;
    }

    public String toString() {
        return "ListAllVoiceRsp{voiceMap=" + this.voiceMap + ",}";
    }
}
