package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetHalleyUrlReq extends JceStruct {
    static ArrayList<String> cache_origins;
    public ArrayList<String> origins;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_origins = arrayList;
        arrayList.add("");
    }

    public GetHalleyUrlReq() {
        this.origins = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.origins = (ArrayList) jceInputStream.read((JceInputStream) cache_origins, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.origins, 0);
    }

    public GetHalleyUrlReq(ArrayList<String> arrayList) {
        this.origins = arrayList;
    }
}
