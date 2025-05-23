package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqHeader extends JceStruct {
    static int cache_eBusiType;
    static int cache_eMqqSysType;
    public byte bNeedAck;
    public int eBusiType;
    public int eMqqSysType;
    public long iAppID;
    public long lMID;
    public short shVersion;

    public ReqHeader() {
        this.shVersion = (short) 0;
        this.lMID = 0L;
        this.iAppID = 0L;
        this.eBusiType = BusinessType.BusinessType_MQQ.value();
        this.eMqqSysType = MqqSysType.MqqSysType_default.value();
        this.bNeedAck = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.lMID = jceInputStream.read(this.lMID, 1, true);
        this.iAppID = jceInputStream.read(this.iAppID, 2, true);
        this.eBusiType = jceInputStream.read(this.eBusiType, 3, false);
        this.eMqqSysType = jceInputStream.read(this.eMqqSysType, 4, false);
        this.bNeedAck = jceInputStream.read(this.bNeedAck, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.lMID, 1);
        jceOutputStream.write(this.iAppID, 2);
        jceOutputStream.write(this.eBusiType, 3);
        jceOutputStream.write(this.eMqqSysType, 4);
        jceOutputStream.write(this.bNeedAck, 5);
    }

    public ReqHeader(short s16, long j3, long j16, int i3, int i16, byte b16) {
        this.shVersion = (short) 0;
        this.lMID = 0L;
        this.iAppID = 0L;
        this.eBusiType = BusinessType.BusinessType_MQQ.value();
        MqqSysType.MqqSysType_default.value();
        this.shVersion = s16;
        this.lMID = j3;
        this.iAppID = j16;
        this.eBusiType = i3;
        this.eMqqSysType = i16;
        this.bNeedAck = b16;
    }
}
