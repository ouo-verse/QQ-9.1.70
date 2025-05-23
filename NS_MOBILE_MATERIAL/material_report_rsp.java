package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_report_rsp extends JceStruct {
    public int iCode;
    public String strErrMsg;

    public material_report_rsp() {
        this.iCode = 0;
        this.strErrMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, true);
        this.strErrMsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        String str = this.strErrMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public material_report_rsp(int i3, String str) {
        this.iCode = i3;
        this.strErrMsg = str;
    }
}
