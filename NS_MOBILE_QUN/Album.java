package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Album extends JceStruct {
    public String albumid;
    public long createUin;
    public int createtime;
    public String desc;
    public int lastuploadtime;
    public int moditytime;
    public String name;
    public int priv;
    public String qunid;
    public int total;

    public Album() {
        this.qunid = "";
        this.albumid = "";
        this.name = "";
        this.desc = "";
        this.createtime = 0;
        this.moditytime = 0;
        this.lastuploadtime = 0;
        this.priv = 0;
        this.total = 0;
        this.createUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qunid = jceInputStream.readString(0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.name = jceInputStream.readString(2, true);
        this.desc = jceInputStream.readString(3, true);
        this.createtime = jceInputStream.read(this.createtime, 4, true);
        this.moditytime = jceInputStream.read(this.moditytime, 5, true);
        this.lastuploadtime = jceInputStream.read(this.lastuploadtime, 6, true);
        this.priv = jceInputStream.read(this.priv, 7, true);
        this.total = jceInputStream.read(this.total, 8, true);
        this.createUin = jceInputStream.read(this.createUin, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qunid, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.name, 2);
        jceOutputStream.write(this.desc, 3);
        jceOutputStream.write(this.createtime, 4);
        jceOutputStream.write(this.moditytime, 5);
        jceOutputStream.write(this.lastuploadtime, 6);
        jceOutputStream.write(this.priv, 7);
        jceOutputStream.write(this.total, 8);
        jceOutputStream.write(this.createUin, 9);
    }

    public Album(String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18, int i19, long j3) {
        this.qunid = str;
        this.albumid = str2;
        this.name = str3;
        this.desc = str4;
        this.createtime = i3;
        this.moditytime = i16;
        this.lastuploadtime = i17;
        this.priv = i18;
        this.total = i19;
        this.createUin = j3;
    }
}
