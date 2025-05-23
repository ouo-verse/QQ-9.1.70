package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdFreeFlowItem extends JceStruct {
    public int flowSubType;
    public int flowType;
    public String userMob;

    public AdFreeFlowItem() {
        this.flowType = 0;
        this.flowSubType = -1;
        this.userMob = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.flowType = jceInputStream.read(this.flowType, 0, false);
        this.flowSubType = jceInputStream.read(this.flowSubType, 1, false);
        this.userMob = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.flowType, 0);
        jceOutputStream.write(this.flowSubType, 1);
        String str = this.userMob;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public AdFreeFlowItem(int i3, int i16, String str) {
        this.flowType = i3;
        this.flowSubType = i16;
        this.userMob = str;
    }
}
