package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GSMCell extends JceStruct {
    public int cellid;
    public int lac;
    public short mcc;
    public short mnc;

    public GSMCell() {
        this.mcc = (short) -1;
        this.mnc = (short) -1;
        this.lac = -1;
        this.cellid = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mcc = jceInputStream.read(this.mcc, 0, true);
        this.mnc = jceInputStream.read(this.mnc, 1, true);
        this.lac = jceInputStream.read(this.lac, 2, true);
        this.cellid = jceInputStream.read(this.cellid, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mcc, 0);
        jceOutputStream.write(this.mnc, 1);
        jceOutputStream.write(this.lac, 2);
        jceOutputStream.write(this.cellid, 3);
    }

    public GSMCell(short s16, short s17, int i3, int i16) {
        this.mcc = s16;
        this.mnc = s17;
        this.lac = i3;
        this.cellid = i16;
    }
}
