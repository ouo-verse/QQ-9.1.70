package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetUsrKeyWordInfoReq extends JceStruct {
    public long uGroupNum;

    public GetUsrKeyWordInfoReq() {
        this.uGroupNum = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uGroupNum = jceInputStream.read(this.uGroupNum, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uGroupNum, 0);
    }

    public GetUsrKeyWordInfoReq(long j3) {
        this.uGroupNum = j3;
    }
}
