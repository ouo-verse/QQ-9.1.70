package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FRIEND_INFO extends JceStruct {
    public byte groupId;
    public byte isVip;
    public String nick;
    public String remark;
    public byte vipLevel;

    public FRIEND_INFO() {
        this.remark = "";
        this.nick = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.groupId = jceInputStream.read(this.groupId, 0, true);
        this.remark = jceInputStream.readString(1, true);
        this.isVip = jceInputStream.read(this.isVip, 2, false);
        this.vipLevel = jceInputStream.read(this.vipLevel, 3, false);
        this.nick = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.groupId, 0);
        jceOutputStream.write(this.remark, 1);
        jceOutputStream.write(this.isVip, 2);
        jceOutputStream.write(this.vipLevel, 3);
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public FRIEND_INFO(byte b16, String str, byte b17, byte b18, String str2) {
        this.groupId = b16;
        this.remark = str;
        this.isVip = b17;
        this.vipLevel = b18;
        this.nick = str2;
    }
}
