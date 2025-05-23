package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DelFriendReq extends JceStruct {
    public byte delType;
    public long deluin;
    public int notShieldTmpSession;
    public long uin;
    public int version;

    public DelFriendReq() {
        this.uin = 0L;
        this.deluin = 0L;
        this.delType = (byte) 0;
        this.version = 0;
        this.notShieldTmpSession = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.deluin = jceInputStream.read(this.deluin, 1, true);
        this.delType = jceInputStream.read(this.delType, 2, true);
        this.version = jceInputStream.read(this.version, 3, false);
        this.notShieldTmpSession = jceInputStream.read(this.notShieldTmpSession, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.deluin, 1);
        jceOutputStream.write(this.delType, 2);
        jceOutputStream.write(this.version, 3);
        jceOutputStream.write(this.notShieldTmpSession, 4);
    }

    public DelFriendReq(long j3, long j16, byte b16, int i3, int i16) {
        this.uin = j3;
        this.deluin = j16;
        this.delType = b16;
        this.version = i3;
        this.notShieldTmpSession = i16;
    }
}
