package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_online_report_item extends JceStruct {
    public long downtime;
    public long loginuin;
    public long uptime;

    public mobile_online_report_item() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.loginuin = jceInputStream.read(this.loginuin, 0, true);
        this.uptime = jceInputStream.read(this.uptime, 1, true);
        this.downtime = jceInputStream.read(this.downtime, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.loginuin, 0);
        jceOutputStream.write(this.uptime, 1);
        jceOutputStream.write(this.downtime, 2);
    }

    public mobile_online_report_item(long j3, long j16, long j17) {
        this.loginuin = j3;
        this.uptime = j16;
        this.downtime = j17;
    }
}
