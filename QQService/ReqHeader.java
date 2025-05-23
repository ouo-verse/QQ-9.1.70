package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqHeader extends JceStruct {
    public int iSeq;
    public long lMID;
    public short shVersion;

    public ReqHeader() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.lMID = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.iSeq = jceInputStream.read(this.iSeq, 1, true);
        this.lMID = jceInputStream.read(this.lMID, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write(this.lMID, 2);
    }

    public ReqHeader(short s16, int i3, long j3) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.lMID = j3;
    }
}
