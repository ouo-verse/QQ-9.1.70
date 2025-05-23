package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetRichSigReq extends JceStruct {
    static int cache_eSourceID;
    static byte[] cache_vbSignature;
    public int eSourceID;
    public byte[] vbSignature;

    public SetRichSigReq() {
        this.vbSignature = null;
        this.eSourceID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vbSignature == null) {
            cache_vbSignature = r0;
            byte[] bArr = {0};
        }
        this.vbSignature = jceInputStream.read(cache_vbSignature, 1, false);
        this.eSourceID = jceInputStream.read(this.eSourceID, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vbSignature;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        jceOutputStream.write(this.eSourceID, 2);
    }

    public SetRichSigReq(byte[] bArr, int i3) {
        this.vbSignature = bArr;
        this.eSourceID = i3;
    }
}
