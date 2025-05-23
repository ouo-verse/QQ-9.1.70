package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GROUP_RIGHT_INFO extends JceStruct {
    public int flag;
    public byte groupId;
    public String groupName;
    public byte seqId;

    public GROUP_RIGHT_INFO() {
        this.groupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.groupId = jceInputStream.read(this.groupId, 0, true);
        this.seqId = jceInputStream.read(this.seqId, 1, true);
        this.groupName = jceInputStream.readString(2, true);
        this.flag = jceInputStream.read(this.flag, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.groupId, 0);
        jceOutputStream.write(this.seqId, 1);
        jceOutputStream.write(this.groupName, 2);
        jceOutputStream.write(this.flag, 3);
    }

    public GROUP_RIGHT_INFO(byte b16, byte b17, String str, int i3) {
        this.groupId = b16;
        this.seqId = b17;
        this.groupName = str;
        this.flag = i3;
    }
}
