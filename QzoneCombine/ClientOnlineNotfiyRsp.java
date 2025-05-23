package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ClientOnlineNotfiyRsp extends JceStruct {
    static byte[] cache_AttachInfo;
    public byte[] AttachInfo;

    static {
        cache_AttachInfo = r0;
        byte[] bArr = {0};
    }

    public ClientOnlineNotfiyRsp() {
        this.AttachInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.AttachInfo = jceInputStream.read(cache_AttachInfo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.AttachInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }

    public ClientOnlineNotfiyRsp(byte[] bArr) {
        this.AttachInfo = bArr;
    }
}
