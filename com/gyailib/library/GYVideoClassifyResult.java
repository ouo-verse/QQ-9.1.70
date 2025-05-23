package com.gyailib.library;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYVideoClassifyResult {
    public String classifyName;
    public String classifyType;
    public Map<String, String> output = new HashMap();
    public String kVideoClassifyOutputKeyHistoMin = "histo_min";
    public String kVideoClassifyOutputKeyHistoMax = "histo_max";
    public String kVideoClassifyOutputKeyEnableSmooth = "enable_smooth";

    public void initStruct(String str, String str2, String str3, String str4, String str5) {
        this.classifyType = str;
        this.classifyName = str2;
        this.output.put(this.kVideoClassifyOutputKeyHistoMin, str3);
        this.output.put(this.kVideoClassifyOutputKeyHistoMax, str4);
        this.output.put(this.kVideoClassifyOutputKeyEnableSmooth, str5);
    }
}
