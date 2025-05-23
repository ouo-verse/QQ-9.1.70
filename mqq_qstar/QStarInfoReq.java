package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class QStarInfoReq extends JceStruct {
    public int cmd;
    public String mqqver;
    public String osver;
    public int platform;
    public int seq;
    public long touin;
    public long uin;
    public int ver;

    public QStarInfoReq() {
        this.ver = 0;
        this.seq = 0;
        this.cmd = 0;
        this.platform = 0;
        this.osver = "";
        this.mqqver = "";
        this.uin = 0L;
        this.touin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ver = jceInputStream.read(this.ver, 0, false);
        this.seq = jceInputStream.read(this.seq, 1, false);
        this.cmd = jceInputStream.read(this.cmd, 2, false);
        this.platform = jceInputStream.read(this.platform, 3, false);
        this.osver = jceInputStream.readString(4, false);
        this.mqqver = jceInputStream.readString(5, false);
        this.uin = jceInputStream.read(this.uin, 6, false);
        this.touin = jceInputStream.read(this.touin, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ver, 0);
        jceOutputStream.write(this.seq, 1);
        jceOutputStream.write(this.cmd, 2);
        jceOutputStream.write(this.platform, 3);
        String str = this.osver;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.mqqver;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.uin, 6);
        jceOutputStream.write(this.touin, 7);
    }

    public QStarInfoReq(int i3, int i16, int i17, int i18, String str, String str2, long j3, long j16) {
        this.ver = i3;
        this.seq = i16;
        this.cmd = i17;
        this.platform = i18;
        this.osver = str;
        this.mqqver = str2;
        this.uin = j3;
        this.touin = j16;
    }
}
