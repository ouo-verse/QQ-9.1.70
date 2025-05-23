package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class rtmp_report_basic_info extends JceStruct {
    public long dns_parse_delay;
    public long lTime;
    public long play_succ_delay;
    public long rtmp_addr_delay;

    public rtmp_report_basic_info() {
        this.dns_parse_delay = 0L;
        this.rtmp_addr_delay = 0L;
        this.play_succ_delay = 0L;
        this.lTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dns_parse_delay = jceInputStream.read(this.dns_parse_delay, 0, false);
        this.rtmp_addr_delay = jceInputStream.read(this.rtmp_addr_delay, 1, false);
        this.play_succ_delay = jceInputStream.read(this.play_succ_delay, 2, false);
        this.lTime = jceInputStream.read(this.lTime, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dns_parse_delay, 0);
        jceOutputStream.write(this.rtmp_addr_delay, 1);
        jceOutputStream.write(this.play_succ_delay, 2);
        jceOutputStream.write(this.lTime, 3);
    }

    public rtmp_report_basic_info(long j3, long j16, long j17, long j18) {
        this.dns_parse_delay = j3;
        this.rtmp_addr_delay = j16;
        this.play_succ_delay = j17;
        this.lTime = j18;
    }
}
