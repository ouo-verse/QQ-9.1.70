package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetImgValidStatusReq extends JceStruct {
    static byte[] cache_Rawdata;
    public byte[] Rawdata;

    static {
        cache_Rawdata = r0;
        byte[] bArr = {0};
    }

    public GetImgValidStatusReq() {
        this.Rawdata = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Rawdata = jceInputStream.read(cache_Rawdata, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.Rawdata;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }

    public GetImgValidStatusReq(byte[] bArr) {
        this.Rawdata = bArr;
    }
}
