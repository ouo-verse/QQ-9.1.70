package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FriendUinInfo extends JceStruct {
    public byte cType;
    public long uFriendTime;
    public long uFriendUin;

    public FriendUinInfo() {
        this.cType = (byte) 0;
        this.uFriendUin = 0L;
        this.uFriendTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cType = jceInputStream.read(this.cType, 1, true);
        this.uFriendUin = jceInputStream.read(this.uFriendUin, 2, true);
        this.uFriendTime = jceInputStream.read(this.uFriendTime, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cType, 1);
        jceOutputStream.write(this.uFriendUin, 2);
        jceOutputStream.write(this.uFriendTime, 3);
    }

    public FriendUinInfo(byte b16, long j3, long j16) {
        this.cType = b16;
        this.uFriendUin = j3;
        this.uFriendTime = j16;
    }
}
