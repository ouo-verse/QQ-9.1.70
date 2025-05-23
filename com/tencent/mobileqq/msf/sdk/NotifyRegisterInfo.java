package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class NotifyRegisterInfo extends JceStruct {
    static ArrayList<Long> cache_notifyIds;
    static Map<Long, String> cache_notifyProperties;
    public ArrayList<Long> notifyIds;
    public Map<Long, String> notifyProperties;
    public String uin;

    public NotifyRegisterInfo() {
        this.uin = "";
        this.notifyIds = null;
        this.notifyProperties = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(1, true);
        if (cache_notifyIds == null) {
            cache_notifyIds = new ArrayList<>();
            cache_notifyIds.add(0L);
        }
        this.notifyIds = (ArrayList) jceInputStream.read((JceInputStream) cache_notifyIds, 2, true);
        if (cache_notifyProperties == null) {
            cache_notifyProperties = new HashMap();
            cache_notifyProperties.put(0L, "");
        }
        this.notifyProperties = (Map) jceInputStream.read((JceInputStream) cache_notifyProperties, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write((Collection) this.notifyIds, 2);
        jceOutputStream.write((Map) this.notifyProperties, 3);
    }

    public NotifyRegisterInfo(String str, ArrayList<Long> arrayList, Map<Long, String> map) {
        this.uin = str;
        this.notifyIds = arrayList;
        this.notifyProperties = map;
    }
}
