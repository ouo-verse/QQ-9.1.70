package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VerifyCode extends JceStruct {
    static byte[] cache_vVerifyCode;
    public byte bType;
    public String strPrompt;
    public byte[] vVerifyCode;

    public VerifyCode() {
        this.bType = (byte) 0;
        this.vVerifyCode = null;
        this.strPrompt = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bType = jceInputStream.read(this.bType, 0, true);
        if (cache_vVerifyCode == null) {
            cache_vVerifyCode = r0;
            byte[] bArr = {0};
        }
        this.vVerifyCode = jceInputStream.read(cache_vVerifyCode, 1, true);
        this.strPrompt = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bType, 0);
        jceOutputStream.write(this.vVerifyCode, 1);
        String str = this.strPrompt;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public VerifyCode(byte b16, byte[] bArr, String str) {
        this.bType = b16;
        this.vVerifyCode = bArr;
        this.strPrompt = str;
    }
}
