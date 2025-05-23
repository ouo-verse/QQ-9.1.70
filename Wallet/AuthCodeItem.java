package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AuthCodeItem extends JceStruct {
    public long appid = 0;
    public long expireTime = 0;
    public String urlDomain = "";
    public String authCode = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.expireTime = jceInputStream.read(this.expireTime, 1, false);
        this.urlDomain = jceInputStream.readString(2, false);
        this.authCode = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.expireTime, 1);
        String str = this.urlDomain;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.authCode;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }
}
