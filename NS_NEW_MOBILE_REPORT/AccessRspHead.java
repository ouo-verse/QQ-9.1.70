package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AccessRspHead extends JceStruct {
    public int err_code;
    public String err_msg;

    public AccessRspHead() {
        this.err_code = 0;
        this.err_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.err_code = jceInputStream.read(this.err_code, 0, false);
        this.err_msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.err_code, 0);
        String str = this.err_msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public AccessRspHead(int i3, String str) {
        this.err_code = i3;
        this.err_msg = str;
    }
}
