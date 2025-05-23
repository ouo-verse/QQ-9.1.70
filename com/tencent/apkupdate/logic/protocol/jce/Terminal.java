package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class Terminal extends JceStruct {
    public String imei = "";
    public String macAdress = "";
    public String androidId = "";
    public String androidIdSdCard = "";
    public String imsi = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, false);
        this.macAdress = jceInputStream.readString(1, false);
        this.androidId = jceInputStream.readString(2, false);
        this.androidIdSdCard = jceInputStream.readString(3, false);
        this.imsi = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.macAdress;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.androidId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.androidIdSdCard;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.imsi;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
    }
}
