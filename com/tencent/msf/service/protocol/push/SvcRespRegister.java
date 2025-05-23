package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SvcRespRegister extends JceStruct {
    static byte[] cache_bytes_0x769_rspbody;
    static byte[] cache_vecCustomStatus;
    public byte bCrashFlag;
    public byte bLargeSeqUpdate;
    public byte bLogQQ;
    public byte bNeedKik;
    public byte bUpdateFlag;
    public byte[] bytes_0x769_rspbody;
    public byte cReplyCode;
    public int iClientPort;
    public int iHelloInterval;
    public long iLargeSeq;
    public int iStatus;
    public long lBid;
    public long lServerTime;
    public long lUin;
    public String strClientIP;
    public String strResult;
    public long timeStamp;
    public long uClientAutoStatusInterval;
    public long uClientBatteryGetInterval;
    public long uExtOnlineStatus;
    public byte[] vecCustomStatus;

    static {
        cache_bytes_0x769_rspbody = r1;
        byte[] bArr = {0};
        cache_vecCustomStatus = r0;
        byte[] bArr2 = {0};
    }

    public SvcRespRegister() {
        this.lUin = 0L;
        this.lBid = 0L;
        this.cReplyCode = (byte) 0;
        this.strResult = "";
        this.lServerTime = 0L;
        this.bLogQQ = (byte) 0;
        this.bNeedKik = (byte) 0;
        this.bUpdateFlag = (byte) 0;
        this.timeStamp = 0L;
        this.bCrashFlag = (byte) 0;
        this.strClientIP = "";
        this.iClientPort = 0;
        this.iHelloInterval = 300;
        this.iLargeSeq = 0L;
        this.bLargeSeqUpdate = (byte) 0;
        this.bytes_0x769_rspbody = null;
        this.iStatus = 0;
        this.uExtOnlineStatus = 0L;
        this.uClientBatteryGetInterval = 86400L;
        this.uClientAutoStatusInterval = 600L;
        this.vecCustomStatus = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.lBid = jceInputStream.read(this.lBid, 1, true);
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 2, true);
        this.strResult = jceInputStream.readString(3, true);
        this.lServerTime = jceInputStream.read(this.lServerTime, 4, false);
        this.bLogQQ = jceInputStream.read(this.bLogQQ, 5, false);
        this.bNeedKik = jceInputStream.read(this.bNeedKik, 6, false);
        this.bUpdateFlag = jceInputStream.read(this.bUpdateFlag, 7, false);
        this.timeStamp = jceInputStream.read(this.timeStamp, 8, false);
        this.bCrashFlag = jceInputStream.read(this.bCrashFlag, 9, false);
        this.strClientIP = jceInputStream.readString(10, false);
        this.iClientPort = jceInputStream.read(this.iClientPort, 11, false);
        this.iHelloInterval = jceInputStream.read(this.iHelloInterval, 12, false);
        this.iLargeSeq = jceInputStream.read(this.iLargeSeq, 13, false);
        this.bLargeSeqUpdate = jceInputStream.read(this.bLargeSeqUpdate, 14, false);
        this.bytes_0x769_rspbody = jceInputStream.read(cache_bytes_0x769_rspbody, 15, false);
        this.iStatus = jceInputStream.read(this.iStatus, 16, false);
        this.uExtOnlineStatus = jceInputStream.read(this.uExtOnlineStatus, 17, false);
        this.uClientBatteryGetInterval = jceInputStream.read(this.uClientBatteryGetInterval, 18, false);
        this.uClientAutoStatusInterval = jceInputStream.read(this.uClientAutoStatusInterval, 19, false);
        this.vecCustomStatus = jceInputStream.read(cache_vecCustomStatus, 21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.lBid, 1);
        jceOutputStream.write(this.cReplyCode, 2);
        jceOutputStream.write(this.strResult, 3);
        jceOutputStream.write(this.lServerTime, 4);
        jceOutputStream.write(this.bLogQQ, 5);
        jceOutputStream.write(this.bNeedKik, 6);
        jceOutputStream.write(this.bUpdateFlag, 7);
        jceOutputStream.write(this.timeStamp, 8);
        jceOutputStream.write(this.bCrashFlag, 9);
        String str = this.strClientIP;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        jceOutputStream.write(this.iClientPort, 11);
        jceOutputStream.write(this.iHelloInterval, 12);
        jceOutputStream.write(this.iLargeSeq, 13);
        jceOutputStream.write(this.bLargeSeqUpdate, 14);
        byte[] bArr = this.bytes_0x769_rspbody;
        if (bArr != null) {
            jceOutputStream.write(bArr, 15);
        }
        jceOutputStream.write(this.iStatus, 16);
        jceOutputStream.write(this.uExtOnlineStatus, 17);
        jceOutputStream.write(this.uClientBatteryGetInterval, 18);
        jceOutputStream.write(this.uClientAutoStatusInterval, 19);
        byte[] bArr2 = this.vecCustomStatus;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 21);
        }
    }

    public SvcRespRegister(long j3, long j16, byte b16, String str, long j17, byte b17, byte b18, byte b19, long j18, byte b26, String str2, int i3, int i16, long j19, byte b27, byte[] bArr, int i17, long j26, long j27, long j28, byte[] bArr2) {
        this.lUin = j3;
        this.lBid = j16;
        this.cReplyCode = b16;
        this.strResult = str;
        this.lServerTime = j17;
        this.bLogQQ = b17;
        this.bNeedKik = b18;
        this.bUpdateFlag = b19;
        this.timeStamp = j18;
        this.bCrashFlag = b26;
        this.strClientIP = str2;
        this.iClientPort = i3;
        this.iHelloInterval = i16;
        this.iLargeSeq = j19;
        this.bLargeSeqUpdate = b27;
        this.bytes_0x769_rspbody = bArr;
        this.iStatus = i17;
        this.uExtOnlineStatus = j26;
        this.uClientBatteryGetInterval = j27;
        this.uClientAutoStatusInterval = j28;
        this.vecCustomStatus = bArr2;
    }
}
