package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespondHeader extends JceStruct {
    public String account;
    public int cmd;
    public String ksid;
    public int requestID;
    public int result;
    public int svrSeqNo;
    public String tips;
    public int ver;

    public RespondHeader() {
        this.ver = 0;
        this.cmd = 0;
        this.requestID = 0;
        this.account = "";
        this.svrSeqNo = 0;
        this.result = 0;
        this.ksid = "";
        this.tips = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ver = jceInputStream.read(this.ver, 0, true);
        this.cmd = jceInputStream.read(this.cmd, 1, true);
        this.requestID = jceInputStream.read(this.requestID, 2, true);
        this.account = jceInputStream.readString(3, true);
        this.svrSeqNo = jceInputStream.read(this.svrSeqNo, 4, true);
        this.result = jceInputStream.read(this.result, 5, true);
        this.ksid = jceInputStream.readString(6, true);
        this.tips = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ver, 0);
        jceOutputStream.write(this.cmd, 1);
        jceOutputStream.write(this.requestID, 2);
        jceOutputStream.write(this.account, 3);
        jceOutputStream.write(this.svrSeqNo, 4);
        jceOutputStream.write(this.result, 5);
        jceOutputStream.write(this.ksid, 6);
        String str = this.tips;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
    }

    public RespondHeader(int i3, int i16, int i17, String str, int i18, int i19, String str2, String str3) {
        this.ver = i3;
        this.cmd = i16;
        this.requestID = i17;
        this.account = str;
        this.svrSeqNo = i18;
        this.result = i19;
        this.ksid = str2;
        this.tips = str3;
    }
}
