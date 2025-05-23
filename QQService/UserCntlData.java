package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserCntlData extends JceStruct {
    static byte[] cache_strCookie;
    public long lNextMid;
    public byte[] strCookie;

    public UserCntlData() {
        this.lNextMid = 0L;
        this.strCookie = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lNextMid = jceInputStream.read(this.lNextMid, 0, true);
        if (cache_strCookie == null) {
            cache_strCookie = r0;
            byte[] bArr = {0};
        }
        this.strCookie = jceInputStream.read(cache_strCookie, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lNextMid, 0);
        byte[] bArr = this.strCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public UserCntlData(long j3, byte[] bArr) {
        this.lNextMid = j3;
        this.strCookie = bArr;
    }
}
