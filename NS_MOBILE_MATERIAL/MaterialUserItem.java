package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MaterialUserItem extends JceStruct {
    static MaterialItem cache_stItem = new MaterialItem();
    public long lExpireTime;
    public long lSettleTime;
    public MaterialItem stItem;

    public MaterialUserItem() {
        this.stItem = null;
        this.lExpireTime = -1L;
        this.lSettleTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stItem = (MaterialItem) jceInputStream.read((JceStruct) cache_stItem, 0, true);
        this.lExpireTime = jceInputStream.read(this.lExpireTime, 1, false);
        this.lSettleTime = jceInputStream.read(this.lSettleTime, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stItem, 0);
        jceOutputStream.write(this.lExpireTime, 1);
        jceOutputStream.write(this.lSettleTime, 2);
    }

    public MaterialUserItem(MaterialItem materialItem, long j3, long j16) {
        this.stItem = materialItem;
        this.lExpireTime = j3;
        this.lSettleTime = j16;
    }
}
