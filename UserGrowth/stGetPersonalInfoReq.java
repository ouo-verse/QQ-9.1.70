package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stGetPersonalInfoReq extends JceStruct {
    public String reqPid;

    public stGetPersonalInfoReq() {
        this.reqPid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqPid = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.reqPid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public stGetPersonalInfoReq(String str) {
        this.reqPid = str;
    }
}
