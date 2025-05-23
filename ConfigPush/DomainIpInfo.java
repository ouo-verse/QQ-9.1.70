package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DomainIpInfo extends JceStruct {
    public int uIp;
    public int uPort;

    public DomainIpInfo() {
        this.uIp = 0;
        this.uPort = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uIp = jceInputStream.read(this.uIp, 1, true);
        this.uPort = jceInputStream.read(this.uPort, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uIp, 1);
        jceOutputStream.write(this.uPort, 2);
    }

    public DomainIpInfo(int i3, int i16) {
        this.uIp = i3;
        this.uPort = i16;
    }
}
