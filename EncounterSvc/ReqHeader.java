package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqHeader extends JceStruct {
    static int cache_eBusiType;
    static int cache_eMqqSysType;
    public int eBusiType;
    public int eMqqSysType;
    public long iAppID;
    public long lMID;
    public short shVersion;
    public long uClientIp;
    public long uClientPort;

    public ReqHeader() {
        this.shVersion = (short) 0;
        this.lMID = 0L;
        this.iAppID = 0L;
        this.eBusiType = 0;
        this.uClientIp = 0L;
        this.uClientPort = 0L;
        this.eMqqSysType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.lMID = jceInputStream.read(this.lMID, 1, true);
        this.iAppID = jceInputStream.read(this.iAppID, 2, true);
        this.eBusiType = jceInputStream.read(this.eBusiType, 3, false);
        this.uClientIp = jceInputStream.read(this.uClientIp, 4, false);
        this.uClientPort = jceInputStream.read(this.uClientPort, 5, false);
        this.eMqqSysType = jceInputStream.read(this.eMqqSysType, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.lMID, 1);
        jceOutputStream.write(this.iAppID, 2);
        jceOutputStream.write(this.eBusiType, 3);
        jceOutputStream.write(this.uClientIp, 4);
        jceOutputStream.write(this.uClientPort, 5);
        jceOutputStream.write(this.eMqqSysType, 6);
    }

    public ReqHeader(short s16, long j3, long j16, int i3, long j17, long j18, int i16) {
        this.shVersion = s16;
        this.lMID = j3;
        this.iAppID = j16;
        this.eBusiType = i3;
        this.uClientIp = j17;
        this.uClientPort = j18;
        this.eMqqSysType = i16;
    }
}
