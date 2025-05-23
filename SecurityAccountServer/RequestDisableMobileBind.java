package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestDisableMobileBind extends JceStruct {
    public String mobileNo;
    public String nationCode;

    public RequestDisableMobileBind() {
        this.nationCode = "";
        this.mobileNo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nationCode = jceInputStream.readString(0, true);
        this.mobileNo = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nationCode, 0);
        jceOutputStream.write(this.mobileNo, 1);
    }

    public RequestDisableMobileBind(String str, String str2) {
        this.nationCode = str;
        this.mobileNo = str2;
    }
}
