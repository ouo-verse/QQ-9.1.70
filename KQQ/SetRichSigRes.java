package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetRichSigRes extends JceStruct {
    public byte cResult;
    public long dwTime;

    public SetRichSigRes() {
        this.cResult = (byte) -1;
        this.dwTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cResult = jceInputStream.read(this.cResult, 1, true);
        this.dwTime = jceInputStream.read(this.dwTime, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cResult, 1);
        jceOutputStream.write(this.dwTime, 2);
    }

    public SetRichSigRes(byte b16, long j3) {
        this.cResult = b16;
        this.dwTime = j3;
    }
}
