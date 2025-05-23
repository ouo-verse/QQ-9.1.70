package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcResponseSetRoamMsg extends JceStruct {
    public byte cReplyCode;
    public long lUin;
    public String strResult;

    public SvcResponseSetRoamMsg() {
        this.lUin = 0L;
        this.cReplyCode = (byte) 0;
        this.strResult = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 1, true);
        this.strResult = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.cReplyCode, 1);
        jceOutputStream.write(this.strResult, 2);
    }

    public SvcResponseSetRoamMsg(long j3, byte b16, String str) {
        this.lUin = j3;
        this.cReplyCode = b16;
        this.strResult = str;
    }
}
