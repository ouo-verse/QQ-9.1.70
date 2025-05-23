package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiGetOneItemWithCheckReq extends JceStruct {
    static LoginInfo cache_stLogin = new LoginInfo();
    public int appid;
    public int itemid;
    public LoginInfo stLogin;

    public UniBusiGetOneItemWithCheckReq() {
        this.stLogin = null;
        this.appid = 0;
        this.itemid = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.itemid = jceInputStream.read(this.itemid, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.itemid, 2);
    }

    public UniBusiGetOneItemWithCheckReq(LoginInfo loginInfo, int i3, int i16) {
        this.stLogin = loginInfo;
        this.appid = i3;
        this.itemid = i16;
    }
}
