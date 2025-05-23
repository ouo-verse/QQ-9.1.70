package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSetDiscussFlag extends JceStruct {
    public long DiscussUin;
    public byte Flag;

    public ReqSetDiscussFlag() {
        this.DiscussUin = 0L;
        this.Flag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        this.Flag = jceInputStream.read(this.Flag, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write(this.Flag, 1);
    }

    public ReqSetDiscussFlag(long j3, byte b16) {
        this.DiscussUin = j3;
        this.Flag = b16;
    }
}
