package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SKAdNetworkInfo extends JceStruct {
    static Map<String, String> cache_appStoreDict;
    public Map<String, String> appStoreDict;

    static {
        HashMap hashMap = new HashMap();
        cache_appStoreDict = hashMap;
        hashMap.put("", "");
    }

    public SKAdNetworkInfo() {
        this.appStoreDict = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appStoreDict = (Map) jceInputStream.read((JceInputStream) cache_appStoreDict, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, String> map = this.appStoreDict;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public SKAdNetworkInfo(Map<String, String> map) {
        this.appStoreDict = map;
    }
}
