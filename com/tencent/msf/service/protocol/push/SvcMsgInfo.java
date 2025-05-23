package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SvcMsgInfo extends JceStruct {
    public int iMsgType;
    public long lFromUin;
    public String strOther;
    public int tTimeStamp;

    public SvcMsgInfo() {
        this.lFromUin = 0L;
        this.tTimeStamp = 0;
        this.iMsgType = 0;
        this.strOther = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromUin = jceInputStream.read(this.lFromUin, 0, true);
        this.tTimeStamp = jceInputStream.read(this.tTimeStamp, 1, true);
        this.iMsgType = jceInputStream.read(this.iMsgType, 2, true);
        this.strOther = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromUin, 0);
        jceOutputStream.write(this.tTimeStamp, 1);
        jceOutputStream.write(this.iMsgType, 2);
        jceOutputStream.write(this.strOther, 3);
    }

    public SvcMsgInfo(long j3, int i3, int i16, String str) {
        this.lFromUin = j3;
        this.tTimeStamp = i3;
        this.iMsgType = i16;
        this.strOther = str;
    }
}
