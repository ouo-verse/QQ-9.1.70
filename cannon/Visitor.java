package cannon;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Visitor extends JceStruct {
    public String lastmood;
    public String name;
    public String portrait;
    public int sqqlevel;
    public long uin;
    public int viplevle;
    public int visittime;
    public int weight;

    public Visitor() {
        this.uin = 0L;
        this.name = "";
        this.visittime = 0;
        this.portrait = "";
        this.lastmood = "";
        this.viplevle = 0;
        this.sqqlevel = 0;
        this.weight = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.name = jceInputStream.readString(2, true);
        this.visittime = jceInputStream.read(this.visittime, 3, false);
        this.portrait = jceInputStream.readString(4, false);
        this.lastmood = jceInputStream.readString(5, false);
        this.viplevle = jceInputStream.read(this.viplevle, 6, false);
        this.sqqlevel = jceInputStream.read(this.sqqlevel, 7, false);
        this.weight = jceInputStream.read(this.weight, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.name, 2);
        jceOutputStream.write(this.visittime, 3);
        String str = this.portrait;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.lastmood;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.viplevle, 6);
        jceOutputStream.write(this.sqqlevel, 7);
        jceOutputStream.write(this.weight, 8);
    }

    public Visitor(long j3, String str, int i3, String str2, String str3, int i16, int i17, int i18) {
        this.uin = j3;
        this.name = str;
        this.visittime = i3;
        this.portrait = str2;
        this.lastmood = str3;
        this.viplevle = i16;
        this.sqqlevel = i17;
        this.weight = i18;
    }
}
