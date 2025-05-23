package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DiscussInfo extends JceStruct {
    public long DiscussUin;
    public long InfoSeq;

    public DiscussInfo() {
        this.DiscussUin = 0L;
        this.InfoSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        this.InfoSeq = jceInputStream.read(this.InfoSeq, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write(this.InfoSeq, 1);
    }

    public DiscussInfo(long j3, long j16) {
        this.DiscussUin = j3;
        this.InfoSeq = j16;
    }
}
