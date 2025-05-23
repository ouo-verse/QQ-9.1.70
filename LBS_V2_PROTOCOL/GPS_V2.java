package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GPS_V2 extends JceStruct {
    public int eType;
    public int iAlt;
    public int iLat;
    public int iLon;

    public GPS_V2() {
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.eType = 0;
        this.iAlt = -10000000;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.iLat, "iLat");
        jceDisplayer.display(this.iLon, "iLon");
        jceDisplayer.display(this.eType, "eType");
        jceDisplayer.display(this.iAlt, "iAlt");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iLat = jceInputStream.read(this.iLat, 0, true);
        this.iLon = jceInputStream.read(this.iLon, 1, true);
        this.eType = jceInputStream.read(this.eType, 2, true);
        this.iAlt = jceInputStream.read(this.iAlt, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iLat, 0);
        jceOutputStream.write(this.iLon, 1);
        jceOutputStream.write(this.eType, 2);
        jceOutputStream.write(this.iAlt, 3);
    }

    public GPS_V2(int i3, int i16, int i17, int i18) {
        this.iLat = i3;
        this.iLon = i16;
        this.eType = i17;
        this.iAlt = i18;
    }
}
