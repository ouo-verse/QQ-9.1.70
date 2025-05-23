package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class SDKDataReportRequest extends JceStruct {
    public String appData;
    public String qadid;
    public String qimei;
    public long timeCost;
    public long uin;

    public SDKDataReportRequest() {
        this.appData = "";
        this.timeCost = 0L;
        this.uin = 0L;
        this.qimei = "";
        this.qadid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appData = jceInputStream.readString(0, false);
        this.timeCost = jceInputStream.read(this.timeCost, 1, false);
        this.uin = jceInputStream.read(this.uin, 2, false);
        this.qimei = jceInputStream.readString(3, false);
        this.qadid = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.appData;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.timeCost, 1);
        jceOutputStream.write(this.uin, 2);
        String str2 = this.qimei;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.qadid;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public SDKDataReportRequest(String str, long j3, long j16, String str2, String str3) {
        this.appData = str;
        this.timeCost = j3;
        this.uin = j16;
        this.qimei = str2;
        this.qadid = str3;
    }
}
