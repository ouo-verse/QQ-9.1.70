package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BusiReqHead extends JceStruct {
    public int iSeq;
    public short shVersion;

    public BusiReqHead() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.iSeq = jceInputStream.read(this.iSeq, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
    }

    public BusiReqHead(short s16, int i3) {
        this.shVersion = s16;
        this.iSeq = i3;
    }
}
