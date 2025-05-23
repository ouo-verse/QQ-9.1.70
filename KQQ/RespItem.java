package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespItem extends JceStruct {
    static int cache_eServiceID;
    static byte[] cache_vecUpdate;
    public byte cResult;
    public int eServiceID;
    public byte[] vecUpdate;

    public RespItem() {
        this.cResult = (byte) 0;
        this.eServiceID = 0;
        this.vecUpdate = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cResult = jceInputStream.read(this.cResult, 0, true);
        this.eServiceID = jceInputStream.read(this.eServiceID, 1, true);
        if (cache_vecUpdate == null) {
            cache_vecUpdate = r0;
            byte[] bArr = {0};
        }
        this.vecUpdate = jceInputStream.read(cache_vecUpdate, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cResult, 0);
        jceOutputStream.write(this.eServiceID, 1);
        byte[] bArr = this.vecUpdate;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public RespItem(byte b16, int i3, byte[] bArr) {
        this.cResult = b16;
        this.eServiceID = i3;
        this.vecUpdate = bArr;
    }
}
