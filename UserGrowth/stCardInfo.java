package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCardInfo extends JceStruct {
    static stCollectionCardInfo cache_collectionCardInfo = new stCollectionCardInfo();
    public int cardType;
    public stCollectionCardInfo collectionCardInfo;

    public stCardInfo() {
        this.cardType = 0;
        this.collectionCardInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cardType = jceInputStream.read(this.cardType, 0, false);
        this.collectionCardInfo = (stCollectionCardInfo) jceInputStream.read((JceStruct) cache_collectionCardInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cardType, 0);
        stCollectionCardInfo stcollectioncardinfo = this.collectionCardInfo;
        if (stcollectioncardinfo != null) {
            jceOutputStream.write((JceStruct) stcollectioncardinfo, 1);
        }
    }

    public stCardInfo(int i3, stCollectionCardInfo stcollectioncardinfo) {
        this.cardType = i3;
        this.collectionCardInfo = stcollectioncardinfo;
    }
}
