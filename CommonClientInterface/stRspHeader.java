package CommonClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRspHeader extends JceStruct {
    public int iRet;
    public String sErrmsg;

    public stRspHeader() {
        this.iRet = 0;
        this.sErrmsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
        this.sErrmsg = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        jceOutputStream.write(this.sErrmsg, 1);
    }

    public stRspHeader(int i3, String str) {
        this.iRet = i3;
        this.sErrmsg = str;
    }
}
