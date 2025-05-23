package com.qwallet.protocol.Wallet.HomePage;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class RspRealApplication extends JceStruct implements Cloneable {
    static BindBankCard cache_bindBankCard;
    public int ret = 0;

    /* renamed from: msg, reason: collision with root package name */
    public String f41683msg = "";
    public BindBankCard bindBankCard = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f41683msg = jceInputStream.readString(1, false);
        if (cache_bindBankCard == null) {
            cache_bindBankCard = new BindBankCard();
        }
        this.bindBankCard = (BindBankCard) jceInputStream.read((JceStruct) cache_bindBankCard, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f41683msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        BindBankCard bindBankCard = this.bindBankCard;
        if (bindBankCard != null) {
            jceOutputStream.write((JceStruct) bindBankCard, 2);
        }
    }
}
