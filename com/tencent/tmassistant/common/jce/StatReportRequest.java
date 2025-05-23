package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class StatReportRequest extends JceStruct {
    static ArrayList<StatItem> cache_data = new ArrayList<>();
    public ArrayList<StatItem> data;

    static {
        cache_data.add(new StatItem());
    }

    public StatReportRequest() {
        this.data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.data = (ArrayList) jceInputStream.read((JceInputStream) cache_data, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.data, 0);
    }

    public StatReportRequest(ArrayList<StatItem> arrayList) {
        this.data = arrayList;
    }
}
