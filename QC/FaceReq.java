package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FaceReq extends JceStruct {
    static LoginInfo cache_stLogin = new LoginInfo();
    public int faceID;
    public LoginInfo stLogin;

    public FaceReq() {
        this.stLogin = null;
        this.faceID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, true);
        this.faceID = jceInputStream.read(this.faceID, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stLogin, 0);
        jceOutputStream.write(this.faceID, 1);
    }

    public FaceReq(LoginInfo loginInfo, int i3) {
        this.stLogin = loginInfo;
        this.faceID = i3;
    }
}
