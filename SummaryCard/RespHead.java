package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespHead extends JceStruct {
    static byte[] cache_vCookies;
    public int iResult;
    public int iVersion;
    public String strErrorMsg;
    public byte[] vCookies;

    public RespHead() {
        this.iVersion = 0;
        this.iResult = 0;
        this.strErrorMsg = "";
        this.vCookies = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iVersion = jceInputStream.read(this.iVersion, 0, true);
        this.iResult = jceInputStream.read(this.iResult, 1, true);
        this.strErrorMsg = jceInputStream.readString(2, true);
        if (cache_vCookies == null) {
            cache_vCookies = r0;
            byte[] bArr = {0};
        }
        this.vCookies = jceInputStream.read(cache_vCookies, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iVersion, 0);
        jceOutputStream.write(this.iResult, 1);
        jceOutputStream.write(this.strErrorMsg, 2);
        byte[] bArr = this.vCookies;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public RespHead(int i3, int i16, String str, byte[] bArr) {
        this.iVersion = i3;
        this.iResult = i16;
        this.strErrorMsg = str;
        this.vCookies = bArr;
    }
}
