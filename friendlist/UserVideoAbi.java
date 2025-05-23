package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UserVideoAbi extends JceStruct {
    public byte bStatus;
    public long uin;

    public UserVideoAbi() {
        this.uin = 0L;
        this.bStatus = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.bStatus = jceInputStream.read(this.bStatus, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.bStatus, 1);
    }

    public UserVideoAbi(long j3, byte b16) {
        this.uin = j3;
        this.bStatus = b16;
    }
}
