package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdVRReportItem extends JceStruct {
    static Map<String, String> cache_vrReportMap;
    public Map<String, String> vrReportMap;

    static {
        HashMap hashMap = new HashMap();
        cache_vrReportMap = hashMap;
        hashMap.put("", "");
    }

    public AdVRReportItem() {
        this.vrReportMap = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vrReportMap = (Map) jceInputStream.read((JceInputStream) cache_vrReportMap, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, String> map = this.vrReportMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public AdVRReportItem(Map<String, String> map) {
        this.vrReportMap = map;
    }
}
