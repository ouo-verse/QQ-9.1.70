package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QmfUpstream extends JceStruct {
    static byte[] cache_BusiBuff;
    static byte[] cache_Extra;
    static QmfClientIpInfo cache_IpInfo;
    static QmfTokenInfo cache_Token;
    static RetryInfo cache_retryinfo;
    public int Appid;
    public byte[] BusiBuff;
    public String DeviceInfo;
    public byte[] Extra;
    public QmfClientIpInfo IpInfo;
    public String Qua;
    public int Seq;
    public String ServiceCmd;
    public QmfTokenInfo Token;
    public long Uin;
    public long flag;
    public RetryInfo retryinfo;
    public long sessionID;

    public QmfUpstream() {
        this.Qua = "";
        this.ServiceCmd = "";
        this.DeviceInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Seq = jceInputStream.read(this.Seq, 0, true);
        this.Appid = jceInputStream.read(this.Appid, 1, true);
        this.Uin = jceInputStream.read(this.Uin, 2, true);
        this.Qua = jceInputStream.readString(3, true);
        this.ServiceCmd = jceInputStream.readString(4, true);
        this.DeviceInfo = jceInputStream.readString(5, true);
        if (cache_Token == null) {
            cache_Token = new QmfTokenInfo();
        }
        this.Token = (QmfTokenInfo) jceInputStream.read((JceStruct) cache_Token, 6, true);
        if (cache_IpInfo == null) {
            cache_IpInfo = new QmfClientIpInfo();
        }
        this.IpInfo = (QmfClientIpInfo) jceInputStream.read((JceStruct) cache_IpInfo, 7, true);
        if (cache_BusiBuff == null) {
            cache_BusiBuff = r0;
            byte[] bArr = {0};
        }
        this.BusiBuff = jceInputStream.read(cache_BusiBuff, 8, true);
        if (cache_Extra == null) {
            cache_Extra = r0;
            byte[] bArr2 = {0};
        }
        this.Extra = jceInputStream.read(cache_Extra, 9, true);
        this.flag = jceInputStream.read(this.flag, 10, false);
        this.sessionID = jceInputStream.read(this.sessionID, 11, false);
        if (cache_retryinfo == null) {
            cache_retryinfo = new RetryInfo();
        }
        this.retryinfo = (RetryInfo) jceInputStream.read((JceStruct) cache_retryinfo, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Seq, 0);
        jceOutputStream.write(this.Appid, 1);
        jceOutputStream.write(this.Uin, 2);
        jceOutputStream.write(this.Qua, 3);
        jceOutputStream.write(this.ServiceCmd, 4);
        jceOutputStream.write(this.DeviceInfo, 5);
        jceOutputStream.write((JceStruct) this.Token, 6);
        jceOutputStream.write((JceStruct) this.IpInfo, 7);
        jceOutputStream.write(this.BusiBuff, 8);
        jceOutputStream.write(this.Extra, 9);
        jceOutputStream.write(this.flag, 10);
        jceOutputStream.write(this.sessionID, 11);
        RetryInfo retryInfo = this.retryinfo;
        if (retryInfo != null) {
            jceOutputStream.write((JceStruct) retryInfo, 12);
        }
    }

    public QmfUpstream(int i3, int i16, long j3, String str, String str2, String str3, QmfTokenInfo qmfTokenInfo, QmfClientIpInfo qmfClientIpInfo, byte[] bArr, byte[] bArr2, long j16, long j17, RetryInfo retryInfo) {
        this.Seq = i3;
        this.Appid = i16;
        this.Uin = j3;
        this.Qua = str;
        this.ServiceCmd = str2;
        this.DeviceInfo = str3;
        this.Token = qmfTokenInfo;
        this.IpInfo = qmfClientIpInfo;
        this.BusiBuff = bArr;
        this.Extra = bArr2;
        this.flag = j16;
        this.sessionID = j17;
        this.retryinfo = retryInfo;
    }
}
