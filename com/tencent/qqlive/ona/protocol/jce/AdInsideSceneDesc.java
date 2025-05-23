package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideSceneDesc extends JceStruct {
    static AdPasterSceneDesc cache_pasterSceneDesc = new AdPasterSceneDesc();
    public AdPasterSceneDesc pasterSceneDesc;

    public AdInsideSceneDesc() {
        this.pasterSceneDesc = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pasterSceneDesc = (AdPasterSceneDesc) jceInputStream.read((JceStruct) cache_pasterSceneDesc, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AdPasterSceneDesc adPasterSceneDesc = this.pasterSceneDesc;
        if (adPasterSceneDesc != null) {
            jceOutputStream.write((JceStruct) adPasterSceneDesc, 0);
        }
    }

    public AdInsideSceneDesc(AdPasterSceneDesc adPasterSceneDesc) {
        this.pasterSceneDesc = adPasterSceneDesc;
    }
}
