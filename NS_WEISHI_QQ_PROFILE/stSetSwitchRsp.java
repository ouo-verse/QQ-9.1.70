package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSetSwitchRsp extends JceStruct {
    static stRspComm cache_rspComm = new stRspComm();
    public stRspComm rspComm;

    public stSetSwitchRsp() {
        this.rspComm = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rspComm = (stRspComm) jceInputStream.read((JceStruct) cache_rspComm, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stRspComm strspcomm = this.rspComm;
        if (strspcomm != null) {
            jceOutputStream.write((JceStruct) strspcomm, 0);
        }
    }

    public stSetSwitchRsp(stRspComm strspcomm) {
        this.rspComm = strspcomm;
    }
}
