package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stText extends JceStruct {
    static byte[] cache_strUrl;
    static byte[] cache_vMsg;
    public byte[] strUrl;
    public byte[] vMsg;

    public stText() {
        this.vMsg = null;
        this.strUrl = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vMsg == null) {
            cache_vMsg = r0;
            byte[] bArr = {0};
        }
        this.vMsg = jceInputStream.read(cache_vMsg, 0, false);
        if (cache_strUrl == null) {
            cache_strUrl = r0;
            byte[] bArr2 = {0};
        }
        this.strUrl = jceInputStream.read(cache_strUrl, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vMsg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        byte[] bArr2 = this.strUrl;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 1);
        }
    }

    public stText(byte[] bArr, byte[] bArr2) {
        this.vMsg = bArr;
        this.strUrl = bArr2;
    }
}
