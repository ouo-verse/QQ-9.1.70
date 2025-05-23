package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommSetReq extends JceStruct {
    public String strReq;

    public CommSetReq() {
        this.strReq = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strReq = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strReq;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public CommSetReq(String str) {
        this.strReq = str;
    }
}
