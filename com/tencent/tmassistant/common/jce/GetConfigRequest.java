package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetConfigRequest extends JceStruct {
    static ArrayList<Integer> cache_typeList = new ArrayList<>();
    public ArrayList<Integer> typeList;

    static {
        cache_typeList.add(0);
    }

    public GetConfigRequest() {
        this.typeList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.typeList = (ArrayList) jceInputStream.read((JceInputStream) cache_typeList, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.typeList, 0);
    }

    public GetConfigRequest(ArrayList<Integer> arrayList) {
        this.typeList = arrayList;
    }
}
