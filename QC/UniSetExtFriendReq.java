package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniSetExtFriendReq extends JceStruct {
    public ExtendFriend stExtendFriend;
    public LoginInfo stLogin;
    public UniBusinessItem stUniBusinessItem;
    static LoginInfo cache_stLogin = new LoginInfo();
    static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
    static ExtendFriend cache_stExtendFriend = new ExtendFriend();

    public UniSetExtFriendReq() {
        this.stLogin = null;
        this.stUniBusinessItem = null;
        this.stExtendFriend = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, true);
        this.stUniBusinessItem = (UniBusinessItem) jceInputStream.read((JceStruct) cache_stUniBusinessItem, 1, true);
        this.stExtendFriend = (ExtendFriend) jceInputStream.read((JceStruct) cache_stExtendFriend, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stLogin, 0);
        jceOutputStream.write((JceStruct) this.stUniBusinessItem, 1);
        ExtendFriend extendFriend = this.stExtendFriend;
        if (extendFriend != null) {
            jceOutputStream.write((JceStruct) extendFriend, 2);
        }
    }

    public UniSetExtFriendReq(LoginInfo loginInfo, UniBusinessItem uniBusinessItem, ExtendFriend extendFriend) {
        this.stLogin = loginInfo;
        this.stUniBusinessItem = uniBusinessItem;
        this.stExtendFriend = extendFriend;
    }
}
