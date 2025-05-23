package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GPS extends JceStruct {
    static int cache_eType;
    public int eType;
    public int iAlt;
    public int iLat;
    public int iLon;

    public GPS() {
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.iAlt = -10000000;
        this.eType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iLat = jceInputStream.read(this.iLat, 0, true);
        this.iLon = jceInputStream.read(this.iLon, 1, true);
        this.iAlt = jceInputStream.read(this.iAlt, 2, true);
        this.eType = jceInputStream.read(this.eType, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iLat, 0);
        jceOutputStream.write(this.iLon, 1);
        jceOutputStream.write(this.iAlt, 2);
        jceOutputStream.write(this.eType, 3);
    }

    public GPS(int i3, int i16, int i17, int i18) {
        this.iLat = i3;
        this.iLon = i16;
        this.iAlt = i17;
        this.eType = i18;
    }
}
