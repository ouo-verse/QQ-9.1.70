package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class AppidList extends JceStruct {
    static ArrayList<Long> cache_AppidVector;
    public ArrayList<Long> AppidVector;
    public long nReserved;

    public AppidList() {
        this.nReserved = 0L;
        this.AppidVector = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nReserved = jceInputStream.read(this.nReserved, 0, true);
        if (cache_AppidVector == null) {
            cache_AppidVector = new ArrayList<>();
            cache_AppidVector.add(0L);
        }
        this.AppidVector = (ArrayList) jceInputStream.read((JceInputStream) cache_AppidVector, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nReserved, 0);
        jceOutputStream.write((Collection) this.AppidVector, 1);
    }

    public AppidList(long j3, ArrayList<Long> arrayList) {
        this.nReserved = j3;
        this.AppidVector = arrayList;
    }
}
