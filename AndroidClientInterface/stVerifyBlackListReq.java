package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stVerifyBlackListReq extends JceStruct {
    public String strModelName;

    public stVerifyBlackListReq() {
        this.strModelName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strModelName = jceInputStream.readString(0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strModelName, 0);
    }

    public stVerifyBlackListReq(String str) {
        this.strModelName = str;
    }
}
