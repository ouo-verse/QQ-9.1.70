package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetImgInfoFromSOSOResp extends JceStruct {
    static byte[] cache_vecRespBody;
    public byte[] vecRespBody;

    public GetImgInfoFromSOSOResp() {
        this.vecRespBody = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecRespBody == null) {
            cache_vecRespBody = r0;
            byte[] bArr = {0};
        }
        this.vecRespBody = jceInputStream.read(cache_vecRespBody, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vecRespBody, 0);
    }

    public GetImgInfoFromSOSOResp(byte[] bArr) {
        this.vecRespBody = bArr;
    }
}
