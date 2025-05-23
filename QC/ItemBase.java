package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ItemBase extends JceStruct {
    public int bid;
    public int ext1;
    public int isSetUp;
    public int itemId;
    public int sourceId;

    public ItemBase() {
        this.bid = 0;
        this.itemId = 0;
        this.ext1 = 0;
        this.sourceId = 0;
        this.isSetUp = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bid = jceInputStream.read(this.bid, 0, false);
        this.itemId = jceInputStream.read(this.itemId, 1, false);
        this.ext1 = jceInputStream.read(this.ext1, 2, false);
        this.sourceId = jceInputStream.read(this.sourceId, 3, false);
        this.isSetUp = jceInputStream.read(this.isSetUp, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bid, 0);
        jceOutputStream.write(this.itemId, 1);
        jceOutputStream.write(this.ext1, 2);
        jceOutputStream.write(this.sourceId, 3);
        jceOutputStream.write(this.isSetUp, 4);
    }

    public ItemBase(int i3, int i16, int i17, int i18, int i19) {
        this.bid = i3;
        this.itemId = i16;
        this.ext1 = i17;
        this.sourceId = i18;
        this.isSetUp = i19;
    }
}
