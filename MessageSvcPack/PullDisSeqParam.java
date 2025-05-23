package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PullDisSeqParam extends JceStruct {
    public long lDisCode;
    public long lLastSeqId;

    public PullDisSeqParam() {
        this.lDisCode = 0L;
        this.lLastSeqId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lDisCode = jceInputStream.read(this.lDisCode, 0, true);
        this.lLastSeqId = jceInputStream.read(this.lLastSeqId, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lDisCode, 0);
        jceOutputStream.write(this.lLastSeqId, 1);
    }

    public PullDisSeqParam(long j3, long j16) {
        this.lDisCode = j3;
        this.lLastSeqId = j16;
    }
}
