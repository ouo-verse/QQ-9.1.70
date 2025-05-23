package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MovGroupMemReq extends JceStruct {
    static byte[] cache_vecBody;
    public byte reqtype;
    public long uin;
    public byte[] vecBody;

    public MovGroupMemReq() {
        this.uin = 0L;
        this.reqtype = (byte) 0;
        this.vecBody = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.reqtype = jceInputStream.read(this.reqtype, 1, true);
        if (cache_vecBody == null) {
            cache_vecBody = r0;
            byte[] bArr = {0};
        }
        this.vecBody = jceInputStream.read(cache_vecBody, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.reqtype, 1);
        jceOutputStream.write(this.vecBody, 2);
    }

    public MovGroupMemReq(long j3, byte b16, byte[] bArr) {
        this.uin = j3;
        this.reqtype = b16;
        this.vecBody = bArr;
    }
}
