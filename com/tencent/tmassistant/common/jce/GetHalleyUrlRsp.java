package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetHalleyUrlRsp extends JceStruct {
    static Map<String, ArrayList<String>> cache_resultMap = new HashMap();
    public Map<String, ArrayList<String>> resultMap;
    public int ret;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        cache_resultMap.put("", arrayList);
    }

    public GetHalleyUrlRsp() {
        this.ret = 0;
        this.resultMap = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.resultMap = (Map) jceInputStream.read((JceInputStream) cache_resultMap, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write((Map) this.resultMap, 1);
    }

    public GetHalleyUrlRsp(int i3, Map<String, ArrayList<String>> map) {
        this.ret = i3;
        this.resultMap = map;
    }
}
