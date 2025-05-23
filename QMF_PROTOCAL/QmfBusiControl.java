package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QmfBusiControl extends JceStruct {
    public int compFlag;
    public long lenBeforeComp;
    public int rspCompFlag;

    public QmfBusiControl() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.compFlag = jceInputStream.read(this.compFlag, 0, true);
        this.lenBeforeComp = jceInputStream.read(this.lenBeforeComp, 1, true);
        this.rspCompFlag = jceInputStream.read(this.rspCompFlag, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.compFlag, 0);
        jceOutputStream.write(this.lenBeforeComp, 1);
        jceOutputStream.write(this.rspCompFlag, 2);
    }

    public QmfBusiControl(int i3, long j3, int i16) {
        this.compFlag = i3;
        this.lenBeforeComp = j3;
        this.rspCompFlag = i16;
    }
}
