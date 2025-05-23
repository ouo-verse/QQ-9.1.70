package com.qwallet.protocol.Wallet.OpenPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes3.dex */
public final class ReqGetPuinInfo extends JceStruct {
    public String bargainorId = "";
    public String subbargainorId = "";
    public String bussId = "";

    /* renamed from: st, reason: collision with root package name */
    public long f41684st = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bargainorId = jceInputStream.readString(0, false);
        this.subbargainorId = jceInputStream.readString(1, false);
        this.bussId = jceInputStream.readString(2, false);
        this.f41684st = jceInputStream.read(this.f41684st, 3, false);
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
        jceOutputStream.write(this.f41684st, 3);
    }
}
