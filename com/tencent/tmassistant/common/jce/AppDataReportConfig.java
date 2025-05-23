package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class AppDataReportConfig extends JceStruct {
    static Map<String, AppExtInfoParam> cache_mapSpecialPkgs = new HashMap();
    public int frequency;
    public Map<String, AppExtInfoParam> mapSpecialPkgs;

    static {
        cache_mapSpecialPkgs.put("", new AppExtInfoParam());
    }

    public AppDataReportConfig() {
        this.frequency = 0;
        this.mapSpecialPkgs = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.frequency = jceInputStream.read(this.frequency, 0, false);
        this.mapSpecialPkgs = (Map) jceInputStream.read((JceInputStream) cache_mapSpecialPkgs, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.frequency, 0);
        Map<String, AppExtInfoParam> map = this.mapSpecialPkgs;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public AppDataReportConfig(int i3, Map<String, AppExtInfoParam> map) {
        this.frequency = i3;
        this.mapSpecialPkgs = map;
    }
}
