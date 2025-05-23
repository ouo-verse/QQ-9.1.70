package IPwdPxyMQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespondHeader extends JceStruct {
    static byte[] cache_tips;
    public int cmd;
    public long requestID;
    public int result;
    public long svrSeqNo;
    public byte[] tips;
    public String uin;
    public int ver;

    public RespondHeader() {
        this.ver = 0;
        this.cmd = 0;
        this.requestID = 0L;
        this.uin = "";
        this.svrSeqNo = 0L;
        this.result = 0;
        this.tips = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ver = jceInputStream.read(this.ver, 0, true);
        this.cmd = jceInputStream.read(this.cmd, 1, true);
        this.requestID = jceInputStream.read(this.requestID, 2, true);
        this.uin = jceInputStream.readString(3, true);
        this.svrSeqNo = jceInputStream.read(this.svrSeqNo, 4, true);
        this.result = jceInputStream.read(this.result, 5, true);
        if (cache_tips == null) {
            cache_tips = r0;
            byte[] bArr = {0};
        }
        this.tips = jceInputStream.read(cache_tips, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ver, 0);
        jceOutputStream.write(this.cmd, 1);
        jceOutputStream.write(this.requestID, 2);
        jceOutputStream.write(this.uin, 3);
        jceOutputStream.write(this.svrSeqNo, 4);
        jceOutputStream.write(this.result, 5);
        byte[] bArr = this.tips;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
    }

    public RespondHeader(int i3, int i16, long j3, String str, long j16, int i17, byte[] bArr) {
        this.ver = i3;
        this.cmd = i16;
        this.requestID = j3;
        this.uin = str;
        this.svrSeqNo = j16;
        this.result = i17;
        this.tips = bArr;
    }
}
