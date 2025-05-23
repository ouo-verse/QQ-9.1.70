package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes28.dex */
public final class LastLoginPageInfo extends JceStruct {
    public long dwCurrentReqIndex;
    public long dwCurrentReqUin;
    public long dwTotalReqTimes;

    public LastLoginPageInfo() {
        this.dwTotalReqTimes = 0L;
        this.dwCurrentReqIndex = 0L;
        this.dwCurrentReqUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwTotalReqTimes = jceInputStream.read(this.dwTotalReqTimes, 0, true);
        this.dwCurrentReqIndex = jceInputStream.read(this.dwCurrentReqIndex, 1, true);
        this.dwCurrentReqUin = jceInputStream.read(this.dwCurrentReqUin, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwTotalReqTimes, 0);
        jceOutputStream.write(this.dwCurrentReqIndex, 1);
        jceOutputStream.write(this.dwCurrentReqUin, 2);
    }

    public LastLoginPageInfo(long j3, long j16, long j17) {
        this.dwTotalReqTimes = j3;
        this.dwCurrentReqIndex = j16;
        this.dwCurrentReqUin = j17;
    }
}
