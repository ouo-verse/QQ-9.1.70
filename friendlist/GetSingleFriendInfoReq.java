package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetSingleFriendInfoReq extends JceStruct {
    public long frienduin;
    public byte ifReflush;
    public long uin;

    public GetSingleFriendInfoReq() {
        this.ifReflush = (byte) 0;
        this.uin = 0L;
        this.frienduin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ifReflush = jceInputStream.read(this.ifReflush, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.frienduin = jceInputStream.read(this.frienduin, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ifReflush, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.frienduin, 2);
    }

    public GetSingleFriendInfoReq(byte b16, long j3, long j16) {
        this.ifReflush = b16;
        this.uin = j3;
        this.frienduin = j16;
    }
}
