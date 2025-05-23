package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class StatItem extends JceStruct {
    static ArrayList<String> cache_records;
    public ArrayList<String> records;
    public int type;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_records = arrayList;
        arrayList.add("");
    }

    public StatItem() {
        this.type = 0;
        this.records = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.records = (ArrayList) jceInputStream.read((JceInputStream) cache_records, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write((Collection) this.records, 1);
    }

    public StatItem(int i3, ArrayList<String> arrayList) {
        this.type = i3;
        this.records = arrayList;
    }
}
