package com.tencent.hippy.qq.obj;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyEngineReportData {
    public HashMap<String, Long> loadHippyCosts;
    public int moduleVersion;
    public HashMap<String, Object> reportResult;
    public HashMap<String, String> updateJSCosts;

    public HippyEngineReportData(int i3, HashMap<String, Object> hashMap, HashMap<String, Long> hashMap2, HashMap<String, String> hashMap3) {
        this.moduleVersion = i3;
        this.reportResult = hashMap;
        this.loadHippyCosts = hashMap2;
        this.updateJSCosts = hashMap3;
    }
}
