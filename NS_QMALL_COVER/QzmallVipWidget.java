package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallVipWidget extends JceStruct {
    public String strRedpointTrace;

    public QzmallVipWidget() {
        this.strRedpointTrace = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strRedpointTrace = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strRedpointTrace;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public QzmallVipWidget(String str) {
        this.strRedpointTrace = str;
    }
}
