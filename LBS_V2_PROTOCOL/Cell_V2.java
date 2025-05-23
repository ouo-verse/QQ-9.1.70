package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Cell_V2 extends JceStruct {
    public double dStationLat;
    public double dStationLon;
    public int iCellId;
    public int iLac;
    public int iRssi;
    public short shMcc;
    public short shMnc;

    public Cell_V2() {
        this.shMcc = (short) -1;
        this.shMnc = (short) -1;
        this.iLac = -1;
        this.iCellId = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.shMcc, "shMcc");
        jceDisplayer.display(this.shMnc, "shMnc");
        jceDisplayer.display(this.iLac, "iLac");
        jceDisplayer.display(this.iCellId, "iCellId");
        jceDisplayer.display(this.iRssi, "iRssi");
        jceDisplayer.display(this.dStationLat, "dStationLat");
        jceDisplayer.display(this.dStationLon, "dStationLon");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shMcc = jceInputStream.read(this.shMcc, 0, true);
        this.shMnc = jceInputStream.read(this.shMnc, 1, true);
        this.iLac = jceInputStream.read(this.iLac, 2, true);
        this.iCellId = jceInputStream.read(this.iCellId, 3, true);
        this.iRssi = jceInputStream.read(this.iRssi, 4, false);
        this.dStationLat = jceInputStream.read(this.dStationLat, 5, false);
        this.dStationLon = jceInputStream.read(this.dStationLon, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shMcc, 0);
        jceOutputStream.write(this.shMnc, 1);
        jceOutputStream.write(this.iLac, 2);
        jceOutputStream.write(this.iCellId, 3);
        jceOutputStream.write(this.iRssi, 4);
        jceOutputStream.write(this.dStationLat, 5);
        jceOutputStream.write(this.dStationLon, 6);
    }

    public Cell_V2(short s16, short s17, int i3, int i16, int i17, double d16, double d17) {
        this.shMcc = s16;
        this.shMnc = s17;
        this.iLac = i3;
        this.iCellId = i16;
        this.iRssi = i17;
        this.dStationLat = d16;
        this.dStationLon = d17;
    }
}
