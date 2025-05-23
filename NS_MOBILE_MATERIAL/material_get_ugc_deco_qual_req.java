package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_get_ugc_deco_qual_req extends JceStruct {
    static int cache_eType;
    static byte[] cache_vecBuf;
    public int eType;
    public long lUin;
    public byte[] vecBuf;

    static {
        cache_vecBuf = r0;
        byte[] bArr = {0};
    }

    public material_get_ugc_deco_qual_req() {
        this.lUin = 0L;
        this.eType = 0;
        this.vecBuf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.eType = jceInputStream.read(this.eType, 1, false);
        this.vecBuf = jceInputStream.read(cache_vecBuf, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.eType, 1);
        byte[] bArr = this.vecBuf;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public material_get_ugc_deco_qual_req(long j3, int i3, byte[] bArr) {
        this.lUin = j3;
        this.eType = i3;
        this.vecBuf = bArr;
    }
}
