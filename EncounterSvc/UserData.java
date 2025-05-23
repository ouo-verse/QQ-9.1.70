package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserData extends JceStruct {
    static byte[] cache_strCookie;
    public int iLat;
    public int iLon;
    public long lNextGrid;
    public long lOriginGrid;
    public int lTime;
    public byte[] strCookie;
    public String strProvince;

    static {
        cache_strCookie = r0;
        byte[] bArr = {0};
    }

    public UserData() {
        this.lTime = 0;
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.lOriginGrid = 0L;
        this.lNextGrid = 0L;
        this.strProvince = "";
        this.strCookie = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lTime = jceInputStream.read(this.lTime, 0, true);
        this.iLat = jceInputStream.read(this.iLat, 1, true);
        this.iLon = jceInputStream.read(this.iLon, 2, true);
        this.lOriginGrid = jceInputStream.read(this.lOriginGrid, 3, true);
        this.lNextGrid = jceInputStream.read(this.lNextGrid, 4, true);
        this.strProvince = jceInputStream.readString(5, false);
        this.strCookie = jceInputStream.read(cache_strCookie, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lTime, 0);
        jceOutputStream.write(this.iLat, 1);
        jceOutputStream.write(this.iLon, 2);
        jceOutputStream.write(this.lOriginGrid, 3);
        jceOutputStream.write(this.lNextGrid, 4);
        String str = this.strProvince;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        byte[] bArr = this.strCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
    }

    public UserData(int i3, int i16, int i17, long j3, long j16, String str, byte[] bArr) {
        this.lTime = i3;
        this.iLat = i16;
        this.iLon = i17;
        this.lOriginGrid = j3;
        this.lNextGrid = j16;
        this.strProvince = str;
        this.strCookie = bArr;
    }
}
