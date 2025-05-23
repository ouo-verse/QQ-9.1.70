package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdDeviceInfo extends JceStruct {
    public String idValue;
    public int mergeIdType;

    public AdDeviceInfo() {
        this.idValue = "";
        this.mergeIdType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.idValue = jceInputStream.readString(0, false);
        this.mergeIdType = jceInputStream.read(this.mergeIdType, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.idValue;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.mergeIdType, 1);
    }

    public AdDeviceInfo(String str, int i3) {
        this.idValue = str;
        this.mergeIdType = i3;
    }
}
