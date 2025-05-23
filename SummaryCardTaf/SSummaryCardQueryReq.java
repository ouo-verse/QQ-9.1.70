package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardQueryReq extends JceStruct {
    static int cache_cmd;
    static int cache_src;
    public int cmd;
    public long platform;
    public long queryuin;
    public int src;
    public long uin;
    public String version;

    public SSummaryCardQueryReq() {
        this.cmd = 1;
        this.uin = 0L;
        this.queryuin = 0L;
        this.version = "4.7.0";
        this.src = 0;
        this.platform = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.read(this.cmd, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.queryuin = jceInputStream.read(this.queryuin, 2, true);
        this.version = jceInputStream.readString(3, false);
        this.src = jceInputStream.read(this.src, 4, false);
        this.platform = jceInputStream.read(this.platform, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmd, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.queryuin, 2);
        String str = this.version;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.src, 4);
        jceOutputStream.write(this.platform, 5);
    }

    public SSummaryCardQueryReq(int i3, long j3, long j16, String str, int i16, long j17) {
        this.cmd = i3;
        this.uin = j3;
        this.queryuin = j16;
        this.version = str;
        this.src = i16;
        this.platform = j17;
    }
}
