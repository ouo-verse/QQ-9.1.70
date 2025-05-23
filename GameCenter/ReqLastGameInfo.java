package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqLastGameInfo extends JceStruct {
    public byte iVersion;
    public long lUin;

    public ReqLastGameInfo() {
        this.iVersion = (byte) 1;
        this.lUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iVersion = jceInputStream.read(this.iVersion, 0, true);
        this.lUin = jceInputStream.read(this.lUin, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iVersion, 0);
        jceOutputStream.write(this.lUin, 1);
    }

    public ReqLastGameInfo(byte b16, long j3) {
        this.iVersion = b16;
        this.lUin = j3;
    }
}
