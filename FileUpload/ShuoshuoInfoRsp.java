package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShuoshuoInfoRsp extends JceStruct {
    static byte[] cache_vBusiNessDataRsp;
    public byte[] vBusiNessDataRsp;

    static {
        cache_vBusiNessDataRsp = r0;
        byte[] bArr = {0};
    }

    public ShuoshuoInfoRsp() {
        this.vBusiNessDataRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vBusiNessDataRsp = jceInputStream.read(cache_vBusiNessDataRsp, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vBusiNessDataRsp, 1);
    }

    public ShuoshuoInfoRsp(byte[] bArr) {
        this.vBusiNessDataRsp = bArr;
    }
}
