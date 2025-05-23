package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserData extends JceStruct {
    public int iLat;
    public int iLon;
    public long lNextMid;
    public int lTime;
    public String strProvince;

    public UserData() {
        this.lTime = 0;
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.lNextMid = 0L;
        this.strProvince = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lTime = jceInputStream.read(this.lTime, 0, true);
        this.iLat = jceInputStream.read(this.iLat, 1, true);
        this.iLon = jceInputStream.read(this.iLon, 2, true);
        this.lNextMid = jceInputStream.read(this.lNextMid, 3, true);
        this.strProvince = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lTime, 0);
        jceOutputStream.write(this.iLat, 1);
        jceOutputStream.write(this.iLon, 2);
        jceOutputStream.write(this.lNextMid, 3);
        String str = this.strProvince;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public UserData(int i3, int i16, int i17, long j3, String str) {
        this.lTime = i3;
        this.iLat = i16;
        this.iLon = i17;
        this.lNextMid = j3;
        this.strProvince = str;
    }
}
