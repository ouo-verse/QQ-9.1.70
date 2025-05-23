package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CheckVerifyCode extends JceStruct {
    static byte[] cache_vEncryptUsrInfo;
    public String strVerifyCode;
    public byte[] vEncryptUsrInfo;

    public CheckVerifyCode() {
        this.vEncryptUsrInfo = null;
        this.strVerifyCode = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vEncryptUsrInfo == null) {
            cache_vEncryptUsrInfo = r0;
            byte[] bArr = {0};
        }
        this.vEncryptUsrInfo = jceInputStream.read(cache_vEncryptUsrInfo, 0, true);
        this.strVerifyCode = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vEncryptUsrInfo, 0);
        jceOutputStream.write(this.strVerifyCode, 1);
    }

    public CheckVerifyCode(byte[] bArr, String str) {
        this.vEncryptUsrInfo = bArr;
        this.strVerifyCode = str;
    }
}
