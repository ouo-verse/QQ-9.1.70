package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class QStarInfoItem extends JceStruct {
    public String headurl;
    public int level;
    public String levelurl;
    public String name;
    public long starid;
    public int totalexp;

    public QStarInfoItem() {
        this.starid = 0L;
        this.name = "";
        this.level = 0;
        this.totalexp = 0;
        this.headurl = "";
        this.levelurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.starid = jceInputStream.read(this.starid, 0, false);
        this.name = jceInputStream.readString(1, false);
        this.level = jceInputStream.read(this.level, 2, false);
        this.totalexp = jceInputStream.read(this.totalexp, 3, false);
        this.headurl = jceInputStream.readString(4, false);
        this.levelurl = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.starid, 0);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.level, 2);
        jceOutputStream.write(this.totalexp, 3);
        String str2 = this.headurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.levelurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public QStarInfoItem(long j3, String str, int i3, int i16, String str2, String str3) {
        this.starid = j3;
        this.name = str;
        this.level = i3;
        this.totalexp = i16;
        this.headurl = str2;
        this.levelurl = str3;
    }
}
