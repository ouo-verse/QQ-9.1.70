package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqRichInfo extends JceStruct {
    public long dwTime;
    public long lUin;

    public ReqRichInfo() {
        this.lUin = 0L;
        this.dwTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 1, true);
        this.dwTime = jceInputStream.read(this.dwTime, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 1);
        jceOutputStream.write(this.dwTime, 2);
    }

    public ReqRichInfo(long j3, long j16) {
        this.lUin = j3;
        this.dwTime = j16;
    }
}
