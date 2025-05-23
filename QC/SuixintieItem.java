package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SuixintieItem extends JceStruct {
    public int appid;
    public int feeType;
    public String image;
    public int itemid;
    public String name;

    public SuixintieItem() {
        this.appid = 0;
        this.itemid = 0;
        this.name = "";
        this.feeType = 0;
        this.image = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.itemid = jceInputStream.read(this.itemid, 1, false);
        this.name = jceInputStream.readString(2, false);
        this.feeType = jceInputStream.read(this.feeType, 3, false);
        this.image = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.itemid, 1);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.feeType, 3);
        String str2 = this.image;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public SuixintieItem(int i3, int i16, String str, int i17, String str2) {
        this.appid = i3;
        this.itemid = i16;
        this.name = str;
        this.feeType = i17;
        this.image = str2;
    }
}
