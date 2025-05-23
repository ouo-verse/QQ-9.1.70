package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DelMsgInfo extends JceStruct {
    static byte[] cache_vMsgCookies;
    public int clientIp;
    public long lFromUin;
    public long lSendTime;
    public short shMsgSeq;
    public int ssoIp;
    public int ssoSeq;
    public long uAppId;
    public long uMsgTime;
    public long uMsgType;
    public byte[] vMsgCookies;
    public short wCmd;

    public DelMsgInfo() {
        this.lFromUin = 0L;
        this.uMsgTime = 0L;
        this.shMsgSeq = (short) 0;
        this.vMsgCookies = null;
        this.wCmd = (short) 0;
        this.uMsgType = 0L;
        this.uAppId = 0L;
        this.lSendTime = 0L;
        this.ssoSeq = 0;
        this.ssoIp = 0;
        this.clientIp = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromUin = jceInputStream.read(this.lFromUin, 0, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 1, true);
        this.shMsgSeq = jceInputStream.read(this.shMsgSeq, 2, true);
        if (cache_vMsgCookies == null) {
            cache_vMsgCookies = r0;
            byte[] bArr = {0};
        }
        this.vMsgCookies = jceInputStream.read(cache_vMsgCookies, 3, false);
        this.wCmd = jceInputStream.read(this.wCmd, 4, false);
        this.uMsgType = jceInputStream.read(this.uMsgType, 5, false);
        this.uAppId = jceInputStream.read(this.uAppId, 6, false);
        this.lSendTime = jceInputStream.read(this.lSendTime, 7, false);
        this.ssoSeq = jceInputStream.read(this.ssoSeq, 8, false);
        this.ssoIp = jceInputStream.read(this.ssoIp, 9, false);
        this.clientIp = jceInputStream.read(this.clientIp, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromUin, 0);
        jceOutputStream.write(this.uMsgTime, 1);
        jceOutputStream.write(this.shMsgSeq, 2);
        byte[] bArr = this.vMsgCookies;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.wCmd, 4);
        jceOutputStream.write(this.uMsgType, 5);
        jceOutputStream.write(this.uAppId, 6);
        jceOutputStream.write(this.lSendTime, 7);
        jceOutputStream.write(this.ssoSeq, 8);
        jceOutputStream.write(this.ssoIp, 9);
        jceOutputStream.write(this.clientIp, 10);
    }

    public DelMsgInfo(long j3, long j16, short s16, byte[] bArr, short s17, long j17, long j18, long j19, int i3, int i16, int i17) {
        this.lFromUin = j3;
        this.uMsgTime = j16;
        this.shMsgSeq = s16;
        this.vMsgCookies = bArr;
        this.wCmd = s17;
        this.uMsgType = j17;
        this.uAppId = j18;
        this.lSendTime = j19;
        this.ssoSeq = i3;
        this.ssoIp = i16;
        this.clientIp = i17;
    }
}
