package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ClientMsg extends JceStruct {
    static ReqHeader cache_stHeader;
    static Msg cache_stMsg;
    public ReqHeader stHeader;
    public Msg stMsg;

    public ClientMsg() {
        this.stHeader = null;
        this.stMsg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stMsg == null) {
            cache_stMsg = new Msg();
        }
        this.stMsg = (Msg) jceInputStream.read((JceStruct) cache_stMsg, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stMsg, 1);
    }

    public ClientMsg(ReqHeader reqHeader, Msg msg2) {
        this.stHeader = reqHeader;
        this.stMsg = msg2;
    }
}
