package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetFontDataRsp extends JceStruct {
    static byte[] cache_FontData;
    public int Code;
    public byte[] FontData;

    static {
        cache_FontData = r0;
        byte[] bArr = {0};
    }

    public GetFontDataRsp() {
        this.Code = 0;
        this.FontData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.FontData = jceInputStream.read(cache_FontData, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        byte[] bArr = this.FontData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public GetFontDataRsp(int i3, byte[] bArr) {
        this.Code = i3;
        this.FontData = bArr;
    }
}
