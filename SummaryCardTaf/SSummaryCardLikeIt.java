package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardLikeIt extends JceStruct {
    static int cache_cmd;
    public int cmd;
    public long label;
    public long likeuin;
    public long platform;
    public long uin;
    public String version;

    public SSummaryCardLikeIt() {
        this.cmd = 3;
        this.uin = 0L;
        this.likeuin = 0L;
        this.version = "4.7.0";
        this.platform = 0L;
        this.label = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.read(this.cmd, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.likeuin = jceInputStream.read(this.likeuin, 2, true);
        this.version = jceInputStream.readString(3, false);
        this.platform = jceInputStream.read(this.platform, 4, false);
        this.label = jceInputStream.read(this.label, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmd, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.likeuin, 2);
        String str = this.version;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.platform, 4);
        jceOutputStream.write(this.label, 5);
    }

    public SSummaryCardLikeIt(int i3, long j3, long j16, String str, long j17, long j18) {
        this.cmd = i3;
        this.uin = j3;
        this.likeuin = j16;
        this.version = str;
        this.platform = j17;
        this.label = j18;
    }
}
