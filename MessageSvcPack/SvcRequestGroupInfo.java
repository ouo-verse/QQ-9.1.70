package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestGroupInfo extends JceStruct {
    public long lGroupCode;
    public long lLastSeqId;

    public SvcRequestGroupInfo() {
        this.lGroupCode = 0L;
        this.lLastSeqId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 0, true);
        this.lLastSeqId = jceInputStream.read(this.lLastSeqId, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lGroupCode, 0);
        jceOutputStream.write(this.lLastSeqId, 1);
    }

    public SvcRequestGroupInfo(long j3, long j16) {
        this.lGroupCode = j3;
        this.lLastSeqId = j16;
    }
}
