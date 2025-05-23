package CommonClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stReqHeader extends JceStruct {
    static stReqComm cache_reqComm;
    public stReqComm reqComm;
    public String sApply;
    public String sCmd;

    public stReqHeader() {
        this.reqComm = null;
        this.sApply = "";
        this.sCmd = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_reqComm == null) {
            cache_reqComm = new stReqComm();
        }
        this.reqComm = (stReqComm) jceInputStream.read((JceStruct) cache_reqComm, 0, true);
        this.sApply = jceInputStream.readString(1, true);
        this.sCmd = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.reqComm, 0);
        jceOutputStream.write(this.sApply, 1);
        jceOutputStream.write(this.sCmd, 2);
    }

    public stReqHeader(stReqComm streqcomm, String str, String str2) {
        this.reqComm = streqcomm;
        this.sApply = str;
        this.sCmd = str2;
    }
}
