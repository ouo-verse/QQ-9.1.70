package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdTimeRange extends JceStruct {
    public long timeBegin;
    public long timeEnd;

    public AdTimeRange() {
        this.timeBegin = 0L;
        this.timeEnd = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.timeBegin = jceInputStream.read(this.timeBegin, 0, false);
        this.timeEnd = jceInputStream.read(this.timeEnd, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.timeBegin, 0);
        jceOutputStream.write(this.timeEnd, 1);
    }

    public AdTimeRange(long j3, long j16) {
        this.timeBegin = j3;
        this.timeEnd = j16;
    }
}
