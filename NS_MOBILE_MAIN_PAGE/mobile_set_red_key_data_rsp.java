package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_set_red_key_data_rsp extends JceStruct {
    public int rsp_code;
    public String rsp_msg;

    public mobile_set_red_key_data_rsp() {
        this.rsp_code = 0;
        this.rsp_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp_code = jceInputStream.read(this.rsp_code, 0, true);
        this.rsp_msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.rsp_code, 0);
        String str = this.rsp_msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_set_red_key_data_rsp(int i3, String str) {
        this.rsp_code = i3;
        this.rsp_msg = str;
    }
}
