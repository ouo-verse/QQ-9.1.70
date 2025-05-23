package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqItem extends JceStruct {
    static int cache_eServiceID;
    static byte[] cache_vecParam;
    public byte cOperType;
    public int eServiceID;
    public byte[] vecParam;

    public ReqItem() {
        this.cOperType = (byte) 1;
        this.eServiceID = 0;
        this.vecParam = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cOperType = jceInputStream.read(this.cOperType, 0, true);
        this.eServiceID = jceInputStream.read(this.eServiceID, 1, true);
        if (cache_vecParam == null) {
            cache_vecParam = r0;
            byte[] bArr = {0};
        }
        this.vecParam = jceInputStream.read(cache_vecParam, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cOperType, 0);
        jceOutputStream.write(this.eServiceID, 1);
        byte[] bArr = this.vecParam;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public ReqItem(byte b16, int i3, byte[] bArr) {
        this.cOperType = b16;
        this.eServiceID = i3;
        this.vecParam = bArr;
    }
}
