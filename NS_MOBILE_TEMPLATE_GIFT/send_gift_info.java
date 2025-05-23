package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class send_gift_info extends JceStruct {
    public boolean isTiming;
    public long receiver;
    public String sendTime;

    public send_gift_info() {
        this.isTiming = true;
        this.sendTime = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.receiver = jceInputStream.read(this.receiver, 0, true);
        this.isTiming = jceInputStream.read(this.isTiming, 1, true);
        this.sendTime = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.receiver, 0);
        jceOutputStream.write(this.isTiming, 1);
        String str = this.sendTime;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public send_gift_info(long j3, boolean z16, String str) {
        this.receiver = j3;
        this.isTiming = z16;
        this.sendTime = str;
    }
}
