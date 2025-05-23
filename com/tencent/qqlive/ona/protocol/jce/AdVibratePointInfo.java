package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdVibratePointInfo extends JceStruct {
    static int cache_vibrateType;
    public long startTimeByMs;
    public int vibrateType;

    public AdVibratePointInfo() {
        this.startTimeByMs = 0L;
        this.vibrateType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.startTimeByMs = jceInputStream.read(this.startTimeByMs, 0, false);
        this.vibrateType = jceInputStream.read(this.vibrateType, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.startTimeByMs, 0);
        jceOutputStream.write(this.vibrateType, 1);
    }

    public AdVibratePointInfo(long j3, int i3) {
        this.startTimeByMs = j3;
        this.vibrateType = i3;
    }
}
