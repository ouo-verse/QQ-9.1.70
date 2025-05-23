package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class NewQqCenterConfig extends JceStruct {
    static Map<String, String> cache_appNewsUrlMap;
    static ArrayList<String> cache_enterOldViaList;
    public Map<String, String> appNewsUrlMap;
    public int detailSwitch;
    public ArrayList<String> enterOldViaList;
    public int entranceSwitch;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_enterOldViaList = arrayList;
        arrayList.add("");
        HashMap hashMap = new HashMap();
        cache_appNewsUrlMap = hashMap;
        hashMap.put("", "");
    }

    public NewQqCenterConfig() {
        this.detailSwitch = 0;
        this.entranceSwitch = 0;
        this.enterOldViaList = null;
        this.appNewsUrlMap = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.detailSwitch = jceInputStream.read(this.detailSwitch, 0, true);
        this.entranceSwitch = jceInputStream.read(this.entranceSwitch, 1, true);
        this.enterOldViaList = (ArrayList) jceInputStream.read((JceInputStream) cache_enterOldViaList, 2, false);
        this.appNewsUrlMap = (Map) jceInputStream.read((JceInputStream) cache_appNewsUrlMap, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.detailSwitch, 0);
        jceOutputStream.write(this.entranceSwitch, 1);
        ArrayList<String> arrayList = this.enterOldViaList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        Map<String, String> map = this.appNewsUrlMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public NewQqCenterConfig(int i3, int i16, ArrayList<String> arrayList, Map<String, String> map) {
        this.detailSwitch = i3;
        this.entranceSwitch = i16;
        this.enterOldViaList = arrayList;
        this.appNewsUrlMap = map;
    }
}
