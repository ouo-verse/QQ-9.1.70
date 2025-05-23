package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class RequestMSFForceOffline extends JceStruct {
    static byte[] cache_vecSigKickData;
    public byte bKickType;
    public byte bSameDevice;
    public byte bSigKick;
    public long iSeqno;
    public long lUin;
    public String strInfo;
    public String strTitle;
    public byte[] vecSigKickData;

    public RequestMSFForceOffline() {
        this.lUin = 0L;
        this.iSeqno = 0L;
        this.bKickType = (byte) 0;
        this.strInfo = "";
        this.strTitle = "";
        this.bSigKick = (byte) 0;
        this.vecSigKickData = null;
        this.bSameDevice = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.iSeqno = jceInputStream.read(this.iSeqno, 1, true);
        this.bKickType = jceInputStream.read(this.bKickType, 2, true);
        this.strInfo = jceInputStream.readString(3, true);
        this.strTitle = jceInputStream.readString(4, false);
        this.bSigKick = jceInputStream.read(this.bSigKick, 5, false);
        if (cache_vecSigKickData == null) {
            cache_vecSigKickData = r0;
            byte[] bArr = {0};
        }
        this.vecSigKickData = jceInputStream.read(cache_vecSigKickData, 6, false);
        this.bSameDevice = jceInputStream.read(this.bSameDevice, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iSeqno, 1);
        jceOutputStream.write(this.bKickType, 2);
        jceOutputStream.write(this.strInfo, 3);
        String str = this.strTitle;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.bSigKick, 5);
        byte[] bArr = this.vecSigKickData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        jceOutputStream.write(this.bSameDevice, 7);
    }

    public RequestMSFForceOffline(long j3, long j16, byte b16, String str, String str2, byte b17, byte[] bArr, byte b18) {
        this.lUin = j3;
        this.iSeqno = j16;
        this.bKickType = b16;
        this.strInfo = str;
        this.strTitle = str2;
        this.bSigKick = b17;
        this.vecSigKickData = bArr;
        this.bSameDevice = b18;
    }
}
