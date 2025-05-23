package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SuixintieCheckItem extends JceStruct {
    public int appid;
    public int fontType;
    public int itemId;

    public SuixintieCheckItem() {
        this.appid = 0;
        this.itemId = 0;
        this.fontType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.itemId = jceInputStream.read(this.itemId, 1, false);
        this.fontType = jceInputStream.read(this.fontType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.itemId, 1);
        jceOutputStream.write(this.fontType, 2);
    }

    public SuixintieCheckItem(int i3, int i16, int i17) {
        this.appid = i3;
        this.itemId = i16;
        this.fontType = i17;
    }
}
