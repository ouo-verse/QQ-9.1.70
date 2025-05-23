package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ClientUinConfReq extends JceStruct {
    static ClientGetUinConfReq cache_clientGetUinConfReq;
    static ClientSetUinConfReq cache_clientSetUinConfReq;
    public ClientGetUinConfReq clientGetUinConfReq;
    public ClientSetUinConfReq clientSetUinConfReq;
    public int iUinCmdType;

    public ClientUinConfReq() {
        this.iUinCmdType = 0;
        this.clientSetUinConfReq = null;
        this.clientGetUinConfReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUinCmdType = jceInputStream.read(this.iUinCmdType, 1, true);
        if (cache_clientSetUinConfReq == null) {
            cache_clientSetUinConfReq = new ClientSetUinConfReq();
        }
        this.clientSetUinConfReq = (ClientSetUinConfReq) jceInputStream.read((JceStruct) cache_clientSetUinConfReq, 3, false);
        if (cache_clientGetUinConfReq == null) {
            cache_clientGetUinConfReq = new ClientGetUinConfReq();
        }
        this.clientGetUinConfReq = (ClientGetUinConfReq) jceInputStream.read((JceStruct) cache_clientGetUinConfReq, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUinCmdType, 1);
        ClientSetUinConfReq clientSetUinConfReq = this.clientSetUinConfReq;
        if (clientSetUinConfReq != null) {
            jceOutputStream.write((JceStruct) clientSetUinConfReq, 3);
        }
        ClientGetUinConfReq clientGetUinConfReq = this.clientGetUinConfReq;
        if (clientGetUinConfReq != null) {
            jceOutputStream.write((JceStruct) clientGetUinConfReq, 4);
        }
    }

    public ClientUinConfReq(int i3, ClientSetUinConfReq clientSetUinConfReq, ClientGetUinConfReq clientGetUinConfReq) {
        this.iUinCmdType = i3;
        this.clientSetUinConfReq = clientSetUinConfReq;
        this.clientGetUinConfReq = clientGetUinConfReq;
    }
}
