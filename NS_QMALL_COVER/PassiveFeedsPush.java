package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PassiveFeedsPush extends JceStruct {
    static QzmallCustomBubbleSkin cache_stBubbleSkin = new QzmallCustomBubbleSkin();
    public QzmallCustomBubbleSkin stBubbleSkin;

    public PassiveFeedsPush() {
        this.stBubbleSkin = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stBubbleSkin = (QzmallCustomBubbleSkin) jceInputStream.read((JceStruct) cache_stBubbleSkin, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin = this.stBubbleSkin;
        if (qzmallCustomBubbleSkin != null) {
            jceOutputStream.write((JceStruct) qzmallCustomBubbleSkin, 0);
        }
    }

    public PassiveFeedsPush(QzmallCustomBubbleSkin qzmallCustomBubbleSkin) {
        this.stBubbleSkin = qzmallCustomBubbleSkin;
    }
}
