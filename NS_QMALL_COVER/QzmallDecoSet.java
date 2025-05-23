package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallDecoSet extends JceStruct {
    static QzmallCustomPraise cache_stCustomPraise = new QzmallCustomPraise();
    static PolymorphicPraise cache_stPolymorphicPraise = new PolymorphicPraise();
    public QzmallCustomPraise stCustomPraise;
    public PolymorphicPraise stPolymorphicPraise;

    public QzmallDecoSet() {
        this.stCustomPraise = null;
        this.stPolymorphicPraise = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stCustomPraise = (QzmallCustomPraise) jceInputStream.read((JceStruct) cache_stCustomPraise, 0, false);
        this.stPolymorphicPraise = (PolymorphicPraise) jceInputStream.read((JceStruct) cache_stPolymorphicPraise, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        QzmallCustomPraise qzmallCustomPraise = this.stCustomPraise;
        if (qzmallCustomPraise != null) {
            jceOutputStream.write((JceStruct) qzmallCustomPraise, 0);
        }
        PolymorphicPraise polymorphicPraise = this.stPolymorphicPraise;
        if (polymorphicPraise != null) {
            jceOutputStream.write((JceStruct) polymorphicPraise, 1);
        }
    }

    public QzmallDecoSet(QzmallCustomPraise qzmallCustomPraise, PolymorphicPraise polymorphicPraise) {
        this.stCustomPraise = qzmallCustomPraise;
        this.stPolymorphicPraise = polymorphicPraise;
    }
}
