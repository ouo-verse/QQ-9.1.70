package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetVoiceRsp {
    public ArrayList<VoiceItem> voiceList = new ArrayList<>();

    public ArrayList<VoiceItem> getVoiceList() {
        return this.voiceList;
    }

    public String toString() {
        return "GetVoiceRsp{voiceList=" + this.voiceList + ",}";
    }
}
