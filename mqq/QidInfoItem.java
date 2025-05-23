package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QidInfoItem extends JceStruct {
    public int has_qid;
    public String qid;

    public QidInfoItem() {
        this.has_qid = 0;
        this.qid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.has_qid = jceInputStream.read(this.has_qid, 0, false);
        this.qid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.has_qid, 0);
        String str = this.qid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public QidInfoItem(int i3, String str) {
        this.has_qid = i3;
        this.qid = str;
    }
}
