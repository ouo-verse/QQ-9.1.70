package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stVerifyBlackListRsp extends JceStruct {
    public int iValue;

    public stVerifyBlackListRsp() {
        this.iValue = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iValue = jceInputStream.read(this.iValue, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iValue, 0);
    }

    public stVerifyBlackListRsp(int i3) {
        this.iValue = i3;
    }
}
