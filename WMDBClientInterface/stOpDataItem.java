package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stOpDataItem extends JceStruct {
    public String bgtime;
    public String edtime;
    public int mask;
    public String sceneId;
    public String wmId;

    public stOpDataItem() {
        this.wmId = "";
        this.sceneId = "";
        this.mask = 0;
        this.bgtime = "";
        this.edtime = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wmId = jceInputStream.readString(0, true);
        this.sceneId = jceInputStream.readString(1, true);
        this.mask = jceInputStream.read(this.mask, 2, true);
        this.bgtime = jceInputStream.readString(3, true);
        this.edtime = jceInputStream.readString(4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wmId, 0);
        jceOutputStream.write(this.sceneId, 1);
        jceOutputStream.write(this.mask, 2);
        jceOutputStream.write(this.bgtime, 3);
        jceOutputStream.write(this.edtime, 4);
    }

    public stOpDataItem(String str, String str2, int i3, String str3, String str4) {
        this.wmId = str;
        this.sceneId = str2;
        this.mask = i3;
        this.bgtime = str3;
        this.edtime = str4;
    }
}
