package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetAreaList extends JceStruct {
    static byte[] cache_vClientVersion;
    public int iLat;
    public int iLon;
    public int iRadius;
    public long uiClientType;
    public byte[] vClientVersion;

    static {
        cache_vClientVersion = r0;
        byte[] bArr = {0};
    }

    public ReqGetAreaList() {
        this.iLat = 0;
        this.iLon = 0;
        this.iRadius = 0;
        this.vClientVersion = null;
        this.uiClientType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iLat = jceInputStream.read(this.iLat, 0, true);
        this.iLon = jceInputStream.read(this.iLon, 1, true);
        this.iRadius = jceInputStream.read(this.iRadius, 2, true);
        this.vClientVersion = jceInputStream.read(cache_vClientVersion, 3, false);
        this.uiClientType = jceInputStream.read(this.uiClientType, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iLat, 0);
        jceOutputStream.write(this.iLon, 1);
        jceOutputStream.write(this.iRadius, 2);
        byte[] bArr = this.vClientVersion;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.uiClientType, 4);
    }

    public ReqGetAreaList(int i3, int i16, int i17, byte[] bArr, long j3) {
        this.iLat = i3;
        this.iLon = i16;
        this.iRadius = i17;
        this.vClientVersion = bArr;
        this.uiClientType = j3;
    }
}
