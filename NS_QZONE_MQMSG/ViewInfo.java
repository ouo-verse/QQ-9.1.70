package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ViewInfo extends JceStruct {
    public int totalView;

    public ViewInfo() {
        this.totalView = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.totalView = jceInputStream.read(this.totalView, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.totalView, 0);
    }

    public ViewInfo(int i3) {
        this.totalView = i3;
    }
}
