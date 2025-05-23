package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdHalfPageItem extends JceStruct {
    public int delayCloseTime;
    public int delayShowTime;
    public int displayType;

    public AdHalfPageItem() {
        this.delayCloseTime = 0;
        this.displayType = 0;
        this.delayShowTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.delayCloseTime = jceInputStream.read(this.delayCloseTime, 0, false);
        this.displayType = jceInputStream.read(this.displayType, 1, false);
        this.delayShowTime = jceInputStream.read(this.delayShowTime, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.delayCloseTime, 0);
        jceOutputStream.write(this.displayType, 1);
        jceOutputStream.write(this.delayShowTime, 2);
    }

    public AdHalfPageItem(int i3, int i16, int i17) {
        this.delayCloseTime = i3;
        this.displayType = i16;
        this.delayShowTime = i17;
    }
}
