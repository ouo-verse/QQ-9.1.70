package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DelFriendResp extends JceStruct {
    static int cache_result;
    public long deluin;
    public short errorCode;
    public int result;
    public long uin;

    public DelFriendResp() {
        this.uin = 0L;
        this.deluin = 0L;
        this.result = 0;
        this.errorCode = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.deluin = jceInputStream.read(this.deluin, 1, true);
        this.result = jceInputStream.read(this.result, 2, true);
        this.errorCode = jceInputStream.read(this.errorCode, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.deluin, 1);
        jceOutputStream.write(this.result, 2);
        jceOutputStream.write(this.errorCode, 3);
    }

    public DelFriendResp(long j3, long j16, int i3, short s16) {
        this.uin = j3;
        this.deluin = j16;
        this.result = i3;
        this.errorCode = s16;
    }
}
