package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_delfavour_rsp extends JceStruct {
    public String error_msg;
    public int ret;

    public operation_delfavour_rsp() {
        this.error_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.error_msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.error_msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public operation_delfavour_rsp(int i3, String str) {
        this.ret = i3;
        this.error_msg = str;
    }
}
