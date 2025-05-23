package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ReSortGroupResp extends JceStruct {
    public long dwSequence;
    public long dwToUin;

    public ReSortGroupResp() {
        this.dwToUin = 0L;
        this.dwSequence = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwToUin = jceInputStream.read(this.dwToUin, 0, true);
        this.dwSequence = jceInputStream.read(this.dwSequence, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwToUin, 0);
        jceOutputStream.write(this.dwSequence, 1);
    }

    public ReSortGroupResp(long j3, long j16) {
        this.dwToUin = j3;
        this.dwSequence = j16;
    }
}
