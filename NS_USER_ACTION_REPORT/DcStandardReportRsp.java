package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DcStandardReportRsp extends JceStruct {
    public int ret_code;
    public String ret_msg;

    public DcStandardReportRsp() {
        this.ret_code = 0;
        this.ret_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.ret_msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.ret_msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public DcStandardReportRsp(int i3, String str) {
        this.ret_code = i3;
        this.ret_msg = str;
    }
}
