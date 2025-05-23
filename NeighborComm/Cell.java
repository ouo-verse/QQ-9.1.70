package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Cell extends JceStruct {
    public int iCellId;
    public int iLac;
    public short shMcc;
    public short shMnc;

    public Cell() {
        this.shMcc = (short) -1;
        this.shMnc = (short) -1;
        this.iLac = -1;
        this.iCellId = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shMcc = jceInputStream.read(this.shMcc, 0, true);
        this.shMnc = jceInputStream.read(this.shMnc, 1, true);
        this.iLac = jceInputStream.read(this.iLac, 2, true);
        this.iCellId = jceInputStream.read(this.iCellId, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shMcc, 0);
        jceOutputStream.write(this.shMnc, 1);
        jceOutputStream.write(this.iLac, 2);
        jceOutputStream.write(this.iCellId, 3);
    }

    public Cell(short s16, short s17, int i3, int i16) {
        this.shMcc = s16;
        this.shMnc = s17;
        this.iLac = i3;
        this.iCellId = i16;
    }
}
