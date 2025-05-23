package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class HalleyConfig extends JceStruct {
    public int halleySwitch;

    public HalleyConfig() {
        this.halleySwitch = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.halleySwitch = jceInputStream.read(this.halleySwitch, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.halleySwitch, 0);
    }

    public HalleyConfig(int i3) {
        this.halleySwitch = i3;
    }
}
