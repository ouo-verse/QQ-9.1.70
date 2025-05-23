package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfRecentReq extends JceStruct {
    public long uTimeStamp;

    public ProfRecentReq() {
        this.uTimeStamp = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uTimeStamp = jceInputStream.read(this.uTimeStamp, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uTimeStamp, 1);
    }

    public ProfRecentReq(long j3) {
        this.uTimeStamp = j3;
    }
}
