package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SetGroupReq extends JceStruct {
    static int cache_reqtype;
    static byte[] cache_vecBody;
    public int reqtype;
    public long uin;
    public byte[] vecBody;

    public SetGroupReq() {
        this.reqtype = 0;
        this.uin = 0L;
        this.vecBody = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqtype = jceInputStream.read(this.reqtype, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        if (cache_vecBody == null) {
            cache_vecBody = r0;
            byte[] bArr = {0};
        }
        this.vecBody = jceInputStream.read(cache_vecBody, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqtype, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.vecBody, 2);
    }

    public SetGroupReq(int i3, long j3, byte[] bArr) {
        this.reqtype = i3;
        this.uin = j3;
        this.vecBody = bArr;
    }
}
