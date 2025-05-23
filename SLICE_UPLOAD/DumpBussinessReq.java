package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DumpBussinessReq extends JceStruct {
    static byte[] cache_biz_req;
    public String IMEI;
    public byte[] biz_req;

    static {
        cache_biz_req = r0;
        byte[] bArr = {0};
    }

    public DumpBussinessReq() {
        this.biz_req = null;
        this.IMEI = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.biz_req = jceInputStream.read(cache_biz_req, 0, false);
        this.IMEI = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.biz_req;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        String str = this.IMEI;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public DumpBussinessReq(byte[] bArr, String str) {
        this.biz_req = bArr;
        this.IMEI = str;
    }
}
