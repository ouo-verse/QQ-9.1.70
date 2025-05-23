package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvrMsg extends JceStruct {
    static ReqHeader cache_stHeader;
    static Msg cache_stMsg;
    public byte bNeedAckClientMsg;
    public byte bResend;
    public ReqHeader stHeader;
    public Msg stMsg;

    public SvrMsg() {
        this.stHeader = null;
        this.stMsg = null;
        this.bNeedAckClientMsg = (byte) 0;
        this.bResend = (byte) 0;
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
        this.bNeedAckClientMsg = jceInputStream.read(this.bNeedAckClientMsg, 2, false);
        this.bResend = jceInputStream.read(this.bResend, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stMsg, 1);
        jceOutputStream.write(this.bNeedAckClientMsg, 2);
        jceOutputStream.write(this.bResend, 3);
    }

    public SvrMsg(ReqHeader reqHeader, Msg msg2, byte b16, byte b17) {
        this.stHeader = reqHeader;
        this.stMsg = msg2;
        this.bNeedAckClientMsg = b16;
        this.bResend = b17;
    }
}
