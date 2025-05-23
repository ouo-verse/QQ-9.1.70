package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GROUP_INFO extends JceStruct {
    public short friendCount;
    public String groupName;
    public byte seqId;

    public GROUP_INFO() {
        this.groupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.seqId = jceInputStream.read(this.seqId, 0, true);
        this.groupName = jceInputStream.readString(1, true);
        this.friendCount = jceInputStream.read(this.friendCount, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.seqId, 0);
        jceOutputStream.write(this.groupName, 1);
        jceOutputStream.write(this.friendCount, 2);
    }

    public GROUP_INFO(byte b16, String str, short s16) {
        this.seqId = b16;
        this.groupName = str;
        this.friendCount = s16;
    }
}
