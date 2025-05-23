package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetWatchWordShareReq extends JceStruct {
    static LoginInfo cache_stLogin = new LoginInfo();
    public LoginInfo stLogin;
    public String watchWord;

    public GetWatchWordShareReq() {
        this.stLogin = null;
        this.watchWord = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.watchWord = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        String str = this.watchWord;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GetWatchWordShareReq(LoginInfo loginInfo, String str) {
        this.stLogin = loginInfo;
        this.watchWord = str;
    }
}
