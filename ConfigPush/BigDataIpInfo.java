package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BigDataIpInfo extends JceStruct {
    public String sIp;
    public long uPort;
    public long uType;

    public BigDataIpInfo() {
        this.uType = 0L;
        this.sIp = "";
        this.uPort = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uType = jceInputStream.read(this.uType, 0, true);
        this.sIp = jceInputStream.readString(1, true);
        this.uPort = jceInputStream.read(this.uPort, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uType, 0);
        jceOutputStream.write(this.sIp, 1);
        jceOutputStream.write(this.uPort, 2);
    }

    public BigDataIpInfo(long j3, String str, long j16) {
        this.uType = j3;
        this.sIp = str;
        this.uPort = j16;
    }
}
