package com.tencent.mobileqq.wink.pb;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class MediaMatRecInfo extends JceStruct {
    static MetaMaterial cache_MaterialInfo = new MetaMaterial();
    public int confidence;
    public MetaMaterial materialInfo;
    public String reason;

    public MediaMatRecInfo() {
        this.materialInfo = null;
        this.reason = "";
        this.confidence = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.materialInfo = (MetaMaterial) jceInputStream.read((JceStruct) cache_MaterialInfo, 0, false);
        this.reason = jceInputStream.readString(1, false);
        this.confidence = jceInputStream.read(this.confidence, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        MetaMaterial metaMaterial = this.materialInfo;
        if (metaMaterial != null) {
            jceOutputStream.write((JceStruct) metaMaterial, 0);
        }
        String str = this.reason;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.confidence, 2);
    }

    public MediaMatRecInfo(MetaMaterial metaMaterial, String str, int i3) {
        this.materialInfo = metaMaterial;
        this.reason = str;
        this.confidence = i3;
    }
}
