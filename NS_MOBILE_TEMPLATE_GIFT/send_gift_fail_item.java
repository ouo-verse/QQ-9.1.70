package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class send_gift_fail_item extends JceStruct {
    public String name;
    public String reason;
    public long uin;

    public send_gift_fail_item() {
        this.name = "";
        this.reason = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.name = jceInputStream.readString(1, true);
        this.reason = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.name, 1);
        jceOutputStream.write(this.reason, 2);
    }

    public send_gift_fail_item(long j3, String str, String str2) {
        this.uin = j3;
        this.name = str;
        this.reason = str2;
    }
}
