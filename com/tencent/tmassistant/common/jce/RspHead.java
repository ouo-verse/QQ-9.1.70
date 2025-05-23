package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class RspHead extends JceStruct {
    public int cmdId;
    public byte encryptWithPack;
    public String phoneGuid;
    public int requestId;
    public int ret;

    public RspHead() {
        this.requestId = 0;
        this.cmdId = 0;
        this.ret = 0;
        this.encryptWithPack = (byte) 0;
        this.phoneGuid = "";
    }

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

    public RspHead(int i3, int i16, int i17, byte b16, String str) {
        this.requestId = i3;
        this.cmdId = i16;
        this.ret = i17;
        this.encryptWithPack = b16;
        this.phoneGuid = str;
    }
}
