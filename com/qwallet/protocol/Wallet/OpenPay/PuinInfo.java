package com.qwallet.protocol.Wallet.OpenPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes3.dex */
public final class PuinInfo extends JceStruct {
    public String bargainorId = "";
    public String subbargainorId = "";
    public String bussId = "";
    public long uin = 0;
    public String logo = "";
    public String attentionTips = "";
    public int defaultSelected = 0;
    public long switchbit = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bargainorId = jceInputStream.readString(0, false);
        this.subbargainorId = jceInputStream.readString(1, false);
        this.bussId = jceInputStream.readString(2, false);
        this.uin = jceInputStream.read(this.uin, 3, false);
        this.logo = jceInputStream.readString(4, false);
        this.attentionTips = jceInputStream.readString(5, false);
        this.defaultSelected = jceInputStream.read(this.defaultSelected, 6, false);
        this.switchbit = jceInputStream.read(this.switchbit, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.bargainorId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.subbargainorId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.bussId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.uin, 3);
        String str4 = this.logo;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.attentionTips;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.defaultSelected, 6);
        jceOutputStream.write(this.switchbit, 7);
    }
}
