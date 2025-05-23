package com.qwallet.protocol.Wallet.PatternLock;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes3.dex */
public final class SetPasswordReq extends JceStruct {
    public String MQOS;
    public String deviceId;
    public String password;
    public int passwordType;
    public String qpwd_token;

    public SetPasswordReq() {
        this.MQOS = "";
        this.password = "";
        this.qpwd_token = "";
        this.passwordType = 0;
        this.deviceId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MQOS = jceInputStream.readString(0, true);
        this.password = jceInputStream.readString(1, true);
        this.qpwd_token = jceInputStream.readString(2, false);
        this.passwordType = jceInputStream.read(this.passwordType, 3, false);
        this.deviceId = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.MQOS, 0);
        jceOutputStream.write(this.password, 1);
        String str = this.qpwd_token;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.passwordType, 3);
        String str2 = this.deviceId;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public SetPasswordReq(String str, String str2, String str3, int i3, String str4) {
        this.MQOS = str;
        this.password = str2;
        this.qpwd_token = str3;
        this.passwordType = i3;
        this.deviceId = str4;
    }
}
