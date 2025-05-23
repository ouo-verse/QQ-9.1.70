package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RequestPushFStatus extends JceStruct {
    public byte cStatus;
    public long lUin;
    public int uClientType;

    public RequestPushFStatus() {
        this.lUin = 0L;
        this.cStatus = (byte) 0;
        this.uClientType = 99;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.cStatus = jceInputStream.read(this.cStatus, 1, true);
        this.uClientType = jceInputStream.read(this.uClientType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.cStatus, 1);
        jceOutputStream.write(this.uClientType, 2);
    }

    public RequestPushFStatus(long j3, byte b16, int i3) {
        this.lUin = j3;
        this.cStatus = b16;
        this.uClientType = i3;
    }
}
