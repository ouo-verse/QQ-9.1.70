package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRespKikOut extends JceStruct {
    public long appid;
    public long lUin;
    public byte result;

    public SvcRespKikOut() {
        this.lUin = 0L;
        this.appid = 0L;
        this.result = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.result = jceInputStream.read(this.result, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.result, 2);
    }

    public SvcRespKikOut(long j3, long j16, byte b16) {
        this.lUin = j3;
        this.appid = j16;
        this.result = b16;
    }
}
