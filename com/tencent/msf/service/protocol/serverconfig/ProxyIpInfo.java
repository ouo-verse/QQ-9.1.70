package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes21.dex */
public final class ProxyIpInfo extends JceStruct {
    public int uIp;
    public int uPort;
    public int uType;

    public ProxyIpInfo() {
        this.uType = 0;
        this.uIp = 0;
        this.uPort = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uType = jceInputStream.read(this.uType, 0, true);
        this.uIp = jceInputStream.read(this.uIp, 1, true);
        this.uPort = jceInputStream.read(this.uPort, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uType, 0);
        jceOutputStream.write(this.uIp, 1);
        jceOutputStream.write(this.uPort, 2);
    }

    public ProxyIpInfo(int i3, int i16, int i17) {
        this.uType = i3;
        this.uIp = i16;
        this.uPort = i17;
    }
}
