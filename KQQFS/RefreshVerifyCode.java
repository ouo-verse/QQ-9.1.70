package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RefreshVerifyCode extends JceStruct {
    static byte[] cache_vEncryptUsrInfo;
    public byte bType;
    public byte[] vEncryptUsrInfo;

    public RefreshVerifyCode() {
        this.vEncryptUsrInfo = null;
        this.bType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vEncryptUsrInfo == null) {
            cache_vEncryptUsrInfo = r0;
            byte[] bArr = {0};
        }
        this.vEncryptUsrInfo = jceInputStream.read(cache_vEncryptUsrInfo, 0, true);
        this.bType = jceInputStream.read(this.bType, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vEncryptUsrInfo, 0);
        jceOutputStream.write(this.bType, 1);
    }

    public RefreshVerifyCode(byte[] bArr, byte b16) {
        this.vEncryptUsrInfo = bArr;
        this.bType = b16;
    }
}
