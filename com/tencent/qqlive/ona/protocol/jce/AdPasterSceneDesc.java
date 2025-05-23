package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdPasterSceneDesc extends JceStruct {
    public int adExpCount;
    public int requestIndex;
    public int requestInterval;

    public AdPasterSceneDesc() {
        this.requestIndex = 0;
        this.requestInterval = 0;
        this.adExpCount = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.requestIndex = jceInputStream.read(this.requestIndex, 0, false);
        this.requestInterval = jceInputStream.read(this.requestInterval, 1, false);
        this.adExpCount = jceInputStream.read(this.adExpCount, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestIndex, 0);
        jceOutputStream.write(this.requestInterval, 1);
        jceOutputStream.write(this.adExpCount, 2);
    }

    public AdPasterSceneDesc(int i3, int i16, int i17) {
        this.requestIndex = i3;
        this.requestInterval = i16;
        this.adExpCount = i17;
    }
}
