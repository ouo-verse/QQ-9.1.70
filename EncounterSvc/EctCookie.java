package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EctCookie extends JceStruct {
    static int cache_eNextGridListType;
    static byte[] cache_vCookie;
    public byte cNextGridSIndex;
    public byte cResetIdentity;
    public int eNextGridListType;
    public long lCurrentGrid;
    public long lNextMid;
    public long lOriginGridS;
    public int last_max_distance;
    public byte[] vCookie;

    static {
        cache_vCookie = r0;
        byte[] bArr = {0};
    }

    public EctCookie() {
        this.vCookie = null;
        this.lCurrentGrid = 0L;
        this.lOriginGridS = 0L;
        this.cNextGridSIndex = (byte) 0;
        this.eNextGridListType = 0;
        this.lNextMid = 0L;
        this.last_max_distance = 0;
        this.cResetIdentity = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vCookie = jceInputStream.read(cache_vCookie, 0, false);
        this.lCurrentGrid = jceInputStream.read(this.lCurrentGrid, 1, false);
        this.lOriginGridS = jceInputStream.read(this.lOriginGridS, 2, false);
        this.cNextGridSIndex = jceInputStream.read(this.cNextGridSIndex, 3, false);
        this.eNextGridListType = jceInputStream.read(this.eNextGridListType, 4, false);
        this.lNextMid = jceInputStream.read(this.lNextMid, 5, false);
        this.last_max_distance = jceInputStream.read(this.last_max_distance, 6, false);
        this.cResetIdentity = jceInputStream.read(this.cResetIdentity, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        jceOutputStream.write(this.lCurrentGrid, 1);
        jceOutputStream.write(this.lOriginGridS, 2);
        jceOutputStream.write(this.cNextGridSIndex, 3);
        jceOutputStream.write(this.eNextGridListType, 4);
        jceOutputStream.write(this.lNextMid, 5);
        jceOutputStream.write(this.last_max_distance, 6);
        jceOutputStream.write(this.cResetIdentity, 7);
    }

    public EctCookie(byte[] bArr, long j3, long j16, byte b16, int i3, long j17, int i16, byte b17) {
        this.vCookie = bArr;
        this.lCurrentGrid = j3;
        this.lOriginGridS = j16;
        this.cNextGridSIndex = b16;
        this.eNextGridListType = i3;
        this.lNextMid = j17;
        this.last_max_distance = i16;
        this.cResetIdentity = b17;
    }
}
