package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class GrayUinCheckReq extends JceStruct {
    public int appid;
    public String info_machine;
    public String info_mem;
    public String uin;

    public GrayUinCheckReq() {
        this.appid = 0;
        this.uin = "";
        this.info_mem = "";
        this.info_machine = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.uin = jceInputStream.readString(2, true);
        this.info_mem = jceInputStream.readString(3, false);
        this.info_machine = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.uin, 2);
        String str = this.info_mem;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.info_machine;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public GrayUinCheckReq(int i3, String str, String str2, String str3) {
        this.appid = i3;
        this.uin = str;
        this.info_mem = str2;
        this.info_machine = str3;
    }
}
