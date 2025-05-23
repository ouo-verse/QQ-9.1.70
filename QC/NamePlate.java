package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class NamePlate extends JceStruct {
    public int isgray;
    public int issetpendant;
    public int pendantid;
    public int viptypeid;

    public NamePlate() {
        this.viptypeid = 0;
        this.isgray = 0;
        this.issetpendant = 0;
        this.pendantid = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.viptypeid = jceInputStream.read(this.viptypeid, 0, false);
        this.isgray = jceInputStream.read(this.isgray, 1, false);
        this.issetpendant = jceInputStream.read(this.issetpendant, 2, false);
        this.pendantid = jceInputStream.read(this.pendantid, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.viptypeid, 0);
        jceOutputStream.write(this.isgray, 1);
        jceOutputStream.write(this.issetpendant, 2);
        jceOutputStream.write(this.pendantid, 3);
    }

    public NamePlate(int i3, int i16, int i17, int i18) {
        this.viptypeid = i3;
        this.isgray = i16;
        this.issetpendant = i17;
        this.pendantid = i18;
    }
}
