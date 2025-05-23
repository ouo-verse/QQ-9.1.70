package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_adv_report_rsp extends JceStruct {
    public String error_msg;
    public int ret_code;

    public mobile_adv_report_rsp() {
        this.error_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.error_msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.error_msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_adv_report_rsp(int i3, String str) {
        this.ret_code = i3;
        this.error_msg = str;
    }
}
