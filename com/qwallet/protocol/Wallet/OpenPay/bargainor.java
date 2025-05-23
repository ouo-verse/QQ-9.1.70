package com.qwallet.protocol.Wallet.OpenPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class bargainor extends JceStruct {
    public String bargainorId = "";
    public String subbargainorId = "";
    public String bussId = "";
    public long defaultSelected = 0;
    public long switchbit = 0;
    public long paytypebit = 0;
    public int weightIndex = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bargainorId = jceInputStream.readString(0, false);
        this.subbargainorId = jceInputStream.readString(1, false);
        this.bussId = jceInputStream.readString(2, false);
        this.defaultSelected = jceInputStream.read(this.defaultSelected, 3, false);
        this.switchbit = jceInputStream.read(this.switchbit, 4, false);
        this.paytypebit = jceInputStream.read(this.paytypebit, 5, false);
        this.weightIndex = jceInputStream.read(this.weightIndex, 6, false);
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
        jceOutputStream.write(this.defaultSelected, 3);
        jceOutputStream.write(this.switchbit, 4);
        jceOutputStream.write(this.paytypebit, 5);
        jceOutputStream.write(this.weightIndex, 6);
    }
}
