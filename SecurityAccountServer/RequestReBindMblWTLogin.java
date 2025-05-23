package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestReBindMblWTLogin extends JceStruct {
    static byte[] cache_encryptBuffer;
    public byte[] encryptBuffer;

    public RequestReBindMblWTLogin() {
        this.encryptBuffer = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_encryptBuffer == null) {
            cache_encryptBuffer = r0;
            byte[] bArr = {0};
        }
        this.encryptBuffer = jceInputStream.read(cache_encryptBuffer, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.encryptBuffer, 0);
    }

    public RequestReBindMblWTLogin(byte[] bArr) {
        this.encryptBuffer = bArr;
    }
}
