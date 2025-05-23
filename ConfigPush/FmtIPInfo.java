package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class FmtIPInfo extends JceStruct {
    public long iGateIpOper;
    public String sGateIp;

    public FmtIPInfo() {
        this.sGateIp = "";
        this.iGateIpOper = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sGateIp = jceInputStream.readString(0, true);
        this.iGateIpOper = jceInputStream.read(this.iGateIpOper, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sGateIp, 0);
        jceOutputStream.write(this.iGateIpOper, 1);
    }

    public FmtIPInfo(String str, long j3) {
        this.sGateIp = str;
        this.iGateIpOper = j3;
    }
}
