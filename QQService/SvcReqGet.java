package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcReqGet extends JceStruct {
    static byte[] cache_vecGuid;
    public byte bIsShowOnline;
    public byte bOnlinePush;
    public byte cConnType;
    public int iClientId;
    public int iClientIp;
    public int iClientPort;
    public int iSSOIp;
    public int iSSOPort;
    public int iStatus;
    public long lBid;
    public long lUin;
    public String sOther;
    public byte[] vecGuid;

    public SvcReqGet() {
        this.lUin = 0L;
        this.lBid = 0L;
        this.sOther = "";
        this.iStatus = 11;
        this.bOnlinePush = (byte) 0;
        this.cConnType = (byte) 0;
        this.bIsShowOnline = (byte) 0;
        this.iSSOIp = 0;
        this.iSSOPort = 0;
        this.iClientIp = 0;
        this.iClientPort = 0;
        this.iClientId = 0;
        this.vecGuid = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.lBid = jceInputStream.read(this.lBid, 1, true);
        this.sOther = jceInputStream.readString(2, true);
        this.iStatus = jceInputStream.read(this.iStatus, 3, false);
        this.bOnlinePush = jceInputStream.read(this.bOnlinePush, 4, false);
        this.cConnType = jceInputStream.read(this.cConnType, 5, false);
        this.bIsShowOnline = jceInputStream.read(this.bIsShowOnline, 6, false);
        this.iSSOIp = jceInputStream.read(this.iSSOIp, 7, false);
        this.iSSOPort = jceInputStream.read(this.iSSOPort, 8, false);
        this.iClientIp = jceInputStream.read(this.iClientIp, 9, false);
        this.iClientPort = jceInputStream.read(this.iClientPort, 10, false);
        this.iClientId = jceInputStream.read(this.iClientId, 11, false);
        if (cache_vecGuid == null) {
            cache_vecGuid = r0;
            byte[] bArr = {0};
        }
        this.vecGuid = jceInputStream.read(cache_vecGuid, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.lBid, 1);
        jceOutputStream.write(this.sOther, 2);
        jceOutputStream.write(this.iStatus, 3);
        jceOutputStream.write(this.bOnlinePush, 4);
        jceOutputStream.write(this.cConnType, 5);
        jceOutputStream.write(this.bIsShowOnline, 6);
        jceOutputStream.write(this.iSSOIp, 7);
        jceOutputStream.write(this.iSSOPort, 8);
        jceOutputStream.write(this.iClientIp, 9);
        jceOutputStream.write(this.iClientPort, 10);
        jceOutputStream.write(this.iClientId, 11);
        byte[] bArr = this.vecGuid;
        if (bArr != null) {
            jceOutputStream.write(bArr, 12);
        }
    }

    public SvcReqGet(long j3, long j16, String str, int i3, byte b16, byte b17, byte b18, int i16, int i17, int i18, int i19, int i26, byte[] bArr) {
        this.lUin = j3;
        this.lBid = j16;
        this.sOther = str;
        this.iStatus = i3;
        this.bOnlinePush = b16;
        this.cConnType = b17;
        this.bIsShowOnline = b18;
        this.iSSOIp = i16;
        this.iSSOPort = i17;
        this.iClientIp = i18;
        this.iClientPort = i19;
        this.iClientId = i26;
        this.vecGuid = bArr;
    }
}
