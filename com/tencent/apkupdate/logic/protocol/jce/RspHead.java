package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class RspHead extends JceStruct {
    public int requestId = 0;
    public int cmdId = 0;
    public int ret = 0;
    public byte encryptWithPack = 0;
    public String phoneGuid = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.ret = jceInputStream.read(this.ret, 2, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 3, false);
        this.phoneGuid = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.ret, 2);
        jceOutputStream.write(this.encryptWithPack, 3);
        String str = this.phoneGuid;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }
}
