package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetItemWatchWordReq extends JceStruct {
    static LoginInfo cache_stLogin = new LoginInfo();
    static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
    public LoginInfo stLogin;
    public UniBusinessItem stUniBusinessItem;

    public GetItemWatchWordReq() {
        this.stLogin = null;
        this.stUniBusinessItem = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.stUniBusinessItem = (UniBusinessItem) jceInputStream.read((JceStruct) cache_stUniBusinessItem, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        UniBusinessItem uniBusinessItem = this.stUniBusinessItem;
        if (uniBusinessItem != null) {
            jceOutputStream.write((JceStruct) uniBusinessItem, 1);
        }
    }

    public GetItemWatchWordReq(LoginInfo loginInfo, UniBusinessItem uniBusinessItem) {
        this.stLogin = loginInfo;
        this.stUniBusinessItem = uniBusinessItem;
    }
}
