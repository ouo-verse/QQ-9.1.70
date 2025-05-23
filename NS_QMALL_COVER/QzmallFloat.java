package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.FloatItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallFloat extends JceStruct {
    static FloatItem cache_stFloatItem = new FloatItem();
    public FloatItem stFloatItem;

    public QzmallFloat() {
        this.stFloatItem = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFloatItem = (FloatItem) jceInputStream.read((JceStruct) cache_stFloatItem, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        FloatItem floatItem = this.stFloatItem;
        if (floatItem != null) {
            jceOutputStream.write((JceStruct) floatItem, 0);
        }
    }

    public QzmallFloat(FloatItem floatItem) {
        this.stFloatItem = floatItem;
    }
}
