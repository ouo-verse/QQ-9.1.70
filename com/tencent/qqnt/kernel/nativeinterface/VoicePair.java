package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class VoicePair {
    public String categoryName = "";
    public ArrayList<VoiceItem> voiceList = new ArrayList<>();

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<VoiceItem> getVoiceList() {
        return this.voiceList;
    }

    public String toString() {
        return "VoicePair{categoryName=" + this.categoryName + ",voiceList=" + this.voiceList + ",}";
    }
}
