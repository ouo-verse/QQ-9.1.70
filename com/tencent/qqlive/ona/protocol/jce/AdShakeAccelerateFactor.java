package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdShakeAccelerateFactor extends JceStruct {
    public float factoryX;
    public float factoryY;
    public float factoryZ;

    public AdShakeAccelerateFactor() {
        this.factoryX = 0.0f;
        this.factoryY = 0.0f;
        this.factoryZ = 0.0f;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.factoryX = jceInputStream.read(this.factoryX, 0, false);
        this.factoryY = jceInputStream.read(this.factoryY, 1, false);
        this.factoryZ = jceInputStream.read(this.factoryZ, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.factoryX, 0);
        jceOutputStream.write(this.factoryY, 1);
        jceOutputStream.write(this.factoryZ, 2);
    }

    public AdShakeAccelerateFactor(float f16, float f17, float f18) {
        this.factoryX = f16;
        this.factoryY = f17;
        this.factoryZ = f18;
    }
}
