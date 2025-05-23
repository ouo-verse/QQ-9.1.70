package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PushInfo extends JceStruct {
    public int totalPush;

    public PushInfo() {
        this.totalPush = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.totalPush = jceInputStream.read(this.totalPush, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.totalPush, 0);
    }

    public PushInfo(int i3) {
        this.totalPush = i3;
    }
}
