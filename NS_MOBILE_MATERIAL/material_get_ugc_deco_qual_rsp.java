package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_get_ugc_deco_qual_rsp extends JceStruct {
    static byte[] cache_vecBuf;
    public int iCode;
    public byte[] vecBuf;

    static {
        cache_vecBuf = r0;
        byte[] bArr = {0};
    }

    public material_get_ugc_deco_qual_rsp() {
        this.iCode = 0;
        this.vecBuf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, false);
        this.vecBuf = jceInputStream.read(cache_vecBuf, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        byte[] bArr = this.vecBuf;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public material_get_ugc_deco_qual_rsp(int i3, byte[] bArr) {
        this.iCode = i3;
        this.vecBuf = bArr;
    }
}
