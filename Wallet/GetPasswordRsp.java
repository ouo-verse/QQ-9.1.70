package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetPasswordRsp extends JceStruct {
    public int checkInterval;
    public String deviceId;
    public int passInterval;
    public String password;
    public int passwordType;
    public int ret;

    public GetPasswordRsp() {
        this.ret = 0;
        this.password = "";
        this.checkInterval = 300;
        this.passInterval = 0;
        this.passwordType = 0;
        this.deviceId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.password = jceInputStream.readString(1, true);
        this.checkInterval = jceInputStream.read(this.checkInterval, 2, false);
        this.passInterval = jceInputStream.read(this.passInterval, 3, false);
        this.passwordType = jceInputStream.read(this.passwordType, 4, false);
        this.deviceId = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.password, 1);
        jceOutputStream.write(this.checkInterval, 2);
        jceOutputStream.write(this.passInterval, 3);
        jceOutputStream.write(this.passwordType, 4);
        String str = this.deviceId;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public GetPasswordRsp(int i3, String str, int i16, int i17, int i18, String str2) {
        this.ret = i3;
        this.password = str;
        this.checkInterval = i16;
        this.passInterval = i17;
        this.passwordType = i18;
        this.deviceId = str2;
    }
}
