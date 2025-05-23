package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetGroupInArea extends JceStruct {
    static byte[] cache_vClientVersion;
    public long dwGroupStartIdx;
    public int iCount;
    public int iFilterId;
    public int iLat;
    public int iLon;
    public String strAreaName;
    public long uiClientType;
    public long uiLabelStyle;
    public byte[] vClientVersion;

    static {
        cache_vClientVersion = r0;
        byte[] bArr = {0};
    }

    public ReqGetGroupInArea() {
        this.strAreaName = "";
        this.iLat = 0;
        this.iLon = 0;
        this.dwGroupStartIdx = 0L;
        this.iCount = 0;
        this.iFilterId = 0;
        this.uiLabelStyle = 0L;
        this.vClientVersion = null;
        this.uiClientType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strAreaName = jceInputStream.readString(0, true);
        this.iLat = jceInputStream.read(this.iLat, 1, true);
        this.iLon = jceInputStream.read(this.iLon, 2, true);
        this.dwGroupStartIdx = jceInputStream.read(this.dwGroupStartIdx, 3, false);
        this.iCount = jceInputStream.read(this.iCount, 4, true);
        this.iFilterId = jceInputStream.read(this.iFilterId, 5, false);
        this.uiLabelStyle = jceInputStream.read(this.uiLabelStyle, 6, false);
        this.vClientVersion = jceInputStream.read(cache_vClientVersion, 7, false);
        this.uiClientType = jceInputStream.read(this.uiClientType, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strAreaName, 0);
        jceOutputStream.write(this.iLat, 1);
        jceOutputStream.write(this.iLon, 2);
        jceOutputStream.write(this.dwGroupStartIdx, 3);
        jceOutputStream.write(this.iCount, 4);
        jceOutputStream.write(this.iFilterId, 5);
        jceOutputStream.write(this.uiLabelStyle, 6);
        byte[] bArr = this.vClientVersion;
        if (bArr != null) {
            jceOutputStream.write(bArr, 7);
        }
        jceOutputStream.write(this.uiClientType, 8);
    }

    public ReqGetGroupInArea(String str, int i3, int i16, long j3, int i17, int i18, long j16, byte[] bArr, long j17) {
        this.strAreaName = str;
        this.iLat = i3;
        this.iLon = i16;
        this.dwGroupStartIdx = j3;
        this.iCount = i17;
        this.iFilterId = i18;
        this.uiLabelStyle = j16;
        this.vClientVersion = bArr;
        this.uiClientType = j17;
    }
}
