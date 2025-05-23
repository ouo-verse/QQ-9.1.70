package com.tencent.mobileqq.wink.intermediate.protocol.SHADOW_BACKEND_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class GetMaterialInfoByIdsRsp extends JceStruct {
    static Map<String, MetaMaterial> cache_MaterialInfo = new HashMap();
    public int Code;
    public Map<String, MetaMaterial> MaterialInfo;
    public String Msg;

    static {
        cache_MaterialInfo.put("", new MetaMaterial());
    }

    public GetMaterialInfoByIdsRsp() {
        this.Code = 0;
        this.Msg = "";
        this.MaterialInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Msg = jceInputStream.readString(1, false);
        this.MaterialInfo = (Map) jceInputStream.read((JceInputStream) cache_MaterialInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.Msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, MetaMaterial> map = this.MaterialInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public GetMaterialInfoByIdsRsp(int i3, String str, Map<String, MetaMaterial> map) {
        this.Code = i3;
        this.Msg = str;
        this.MaterialInfo = map;
    }
}
