package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GuestGetLikeReq extends JceStruct {
    public long fromUin;
    public long toUin;

    public GuestGetLikeReq() {
        this.fromUin = 0L;
        this.toUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fromUin = jceInputStream.read(this.fromUin, 0, false);
        this.toUin = jceInputStream.read(this.toUin, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fromUin, 0);
        jceOutputStream.write(this.toUin, 1);
    }

    public GuestGetLikeReq(long j3, long j16) {
        this.fromUin = j3;
        this.toUin = j16;
    }
}
