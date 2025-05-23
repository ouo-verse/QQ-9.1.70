package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetPasswordReq extends JceStruct {
    public String MQOS;
    public String MQVersion;

    public GetPasswordReq() {
        this.MQOS = "";
        this.MQVersion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MQOS = jceInputStream.readString(0, true);
        this.MQVersion = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.MQOS, 0);
        String str = this.MQVersion;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GetPasswordReq(String str, String str2) {
        this.MQOS = str;
        this.MQVersion = str2;
    }
}
