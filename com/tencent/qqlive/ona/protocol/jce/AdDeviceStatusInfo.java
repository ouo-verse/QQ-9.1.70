package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdDeviceStatusInfo extends JceStruct {
    public int autoPlay;
    public int muted;
    public int volume;

    public AdDeviceStatusInfo() {
        this.volume = 0;
        this.muted = 0;
        this.autoPlay = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.volume = jceInputStream.read(this.volume, 0, false);
        this.muted = jceInputStream.read(this.muted, 1, false);
        this.autoPlay = jceInputStream.read(this.autoPlay, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.volume, 0);
        jceOutputStream.write(this.muted, 1);
        jceOutputStream.write(this.autoPlay, 2);
    }

    public AdDeviceStatusInfo(int i3, int i16, int i17) {
        this.volume = i3;
        this.muted = i16;
        this.autoPlay = i17;
    }
}
