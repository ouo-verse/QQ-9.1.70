package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiGetUserInfoReq extends JceStruct {
    public int appid;
    public int pageSize;
    public UniBusiUsingUid relateUIDInfo;
    public LoginInfo stLogin;
    public int startIndex;
    static LoginInfo cache_stLogin = new LoginInfo();
    static UniBusiUsingUid cache_relateUIDInfo = new UniBusiUsingUid();

    public UniBusiGetUserInfoReq() {
        this.stLogin = null;
        this.appid = 0;
        this.pageSize = 0;
        this.startIndex = 0;
        this.relateUIDInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.pageSize = jceInputStream.read(this.pageSize, 2, false);
        this.startIndex = jceInputStream.read(this.startIndex, 3, false);
        this.relateUIDInfo = (UniBusiUsingUid) jceInputStream.read((JceStruct) cache_relateUIDInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.pageSize, 2);
        jceOutputStream.write(this.startIndex, 3);
        UniBusiUsingUid uniBusiUsingUid = this.relateUIDInfo;
        if (uniBusiUsingUid != null) {
            jceOutputStream.write((JceStruct) uniBusiUsingUid, 4);
        }
    }

    public UniBusiGetUserInfoReq(LoginInfo loginInfo, int i3, int i16, int i17, UniBusiUsingUid uniBusiUsingUid) {
        this.stLogin = loginInfo;
        this.appid = i3;
        this.pageSize = i16;
        this.startIndex = i17;
        this.relateUIDInfo = uniBusiUsingUid;
    }
}
