package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes21.dex */
public final class VendorPushInfo extends JceStruct {
    public long uVendorType;

    public VendorPushInfo() {
        this.uVendorType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uVendorType = jceInputStream.read(this.uVendorType, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uVendorType, 0);
    }

    public VendorPushInfo(long j3) {
        this.uVendorType = j3;
    }
}
