package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetConciseThemeReq extends JceStruct {
    static LoginInfo cache_stLogin = new LoginInfo();
    public LoginInfo stLogin;

    public GetConciseThemeReq() {
        this.stLogin = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stLogin, 0);
    }

    public GetConciseThemeReq(LoginInfo loginInfo) {
        this.stLogin = loginInfo;
    }
}
