package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupMemberFlag extends JceStruct {
    public byte cUinFlag;
    public long dwUin;

    public GroupMemberFlag() {
        this.dwUin = 0L;
        this.cUinFlag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwUin = jceInputStream.read(this.dwUin, 0, true);
        this.cUinFlag = jceInputStream.read(this.cUinFlag, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwUin, 0);
        jceOutputStream.write(this.cUinFlag, 1);
    }

    public GroupMemberFlag(long j3, byte b16) {
        this.dwUin = j3;
        this.cUinFlag = b16;
    }
}
