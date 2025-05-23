package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetImgInfoFromSOSOReq extends JceStruct {
    static byte[] cache_vecReqBody;
    public byte[] vecReqBody;

    public GetImgInfoFromSOSOReq() {
        this.vecReqBody = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecReqBody == null) {
            cache_vecReqBody = r0;
            byte[] bArr = {0};
        }
        this.vecReqBody = jceInputStream.read(cache_vecReqBody, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vecReqBody, 0);
    }

    public GetImgInfoFromSOSOReq(byte[] bArr) {
        this.vecReqBody = bArr;
    }
}
