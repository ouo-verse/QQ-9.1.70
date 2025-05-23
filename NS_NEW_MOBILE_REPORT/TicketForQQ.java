package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TicketForQQ extends JceStruct {
    static byte[] cache_A2;
    public byte[] A2;
    public long appId;
    public long uin;

    static {
        cache_A2 = r0;
        byte[] bArr = {0};
    }

    public TicketForQQ() {
        this.appId = 0L;
        this.A2 = null;
        this.uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.A2 = jceInputStream.read(cache_A2, 1, false);
        this.uin = jceInputStream.read(this.uin, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appId, 0);
        byte[] bArr = this.A2;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        jceOutputStream.write(this.uin, 2);
    }

    public TicketForQQ(long j3, byte[] bArr, long j16) {
        this.appId = j3;
        this.A2 = bArr;
        this.uin = j16;
    }
}
