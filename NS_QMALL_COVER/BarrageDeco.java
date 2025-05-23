package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BarrageDeco extends JceStruct {
    static QzmallCustomVip cache_stCustomVip = new QzmallCustomVip();
    public QzmallCustomVip stCustomVip;

    public BarrageDeco() {
        this.stCustomVip = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stCustomVip = (QzmallCustomVip) jceInputStream.read((JceStruct) cache_stCustomVip, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        QzmallCustomVip qzmallCustomVip = this.stCustomVip;
        if (qzmallCustomVip != null) {
            jceOutputStream.write((JceStruct) qzmallCustomVip, 0);
        }
    }

    public BarrageDeco(QzmallCustomVip qzmallCustomVip) {
        this.stCustomVip = qzmallCustomVip;
    }
}
