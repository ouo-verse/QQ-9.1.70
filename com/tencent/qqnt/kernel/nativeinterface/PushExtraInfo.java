package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class PushExtraInfo {
    public HashMap<String, byte[]> transInfoMap;

    public PushExtraInfo() {
        this.transInfoMap = new HashMap<>();
    }

    public HashMap<String, byte[]> getTransInfoMap() {
        return this.transInfoMap;
    }

    public String toString() {
        return "PushExtraInfo{transInfoMap=" + this.transInfoMap + ",}";
    }

    public PushExtraInfo(HashMap<String, byte[]> hashMap) {
        new HashMap();
        this.transInfoMap = hashMap;
    }
}
