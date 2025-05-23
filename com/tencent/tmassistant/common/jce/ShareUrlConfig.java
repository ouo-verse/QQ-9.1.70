package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ShareUrlConfig extends JceStruct {
    static ArrayList<String> cache_blackList;
    public ArrayList<String> blackList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_blackList = arrayList;
        arrayList.add("");
    }

    public ShareUrlConfig() {
        this.blackList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.blackList = (ArrayList) jceInputStream.read((JceInputStream) cache_blackList, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.blackList, 0);
    }

    public ShareUrlConfig(ArrayList<String> arrayList) {
        this.blackList = arrayList;
    }
}
