package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class IsUinFocusMpIdReq extends JceStruct {
    public String appid;
    public String uin;

    public IsUinFocusMpIdReq() {
        this.uin = "";
        this.appid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, false);
        this.appid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uin;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.appid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public IsUinFocusMpIdReq(String str, String str2) {
        this.uin = str;
        this.appid = str2;
    }
}
