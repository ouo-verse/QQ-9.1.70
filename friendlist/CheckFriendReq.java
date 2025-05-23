package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CheckFriendReq extends JceStruct {
    public long fuin;
    public long uin;

    public CheckFriendReq() {
        this.uin = 0L;
        this.fuin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.fuin = jceInputStream.read(this.fuin, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.fuin, 1);
    }

    public CheckFriendReq(long j3, long j16) {
        this.uin = j3;
        this.fuin = j16;
    }
}
