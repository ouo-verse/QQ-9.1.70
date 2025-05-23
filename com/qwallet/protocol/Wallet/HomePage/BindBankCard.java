package com.qwallet.protocol.Wallet.HomePage;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class BindBankCard extends JceStruct implements Cloneable {
    public short type = 0;
    public String text = "";
    public String URL = "";
    public String uinRules = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.text = jceInputStream.readString(1, false);
        this.URL = jceInputStream.readString(2, false);
        this.uinRules = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.URL;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.uinRules;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }
}
