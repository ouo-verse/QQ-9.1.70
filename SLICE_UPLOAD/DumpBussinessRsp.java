package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DumpBussinessRsp extends JceStruct {
    static byte[] cache_biz_rsp;
    static stResult cache_result = new stResult();
    public byte[] biz_rsp;
    public stResult result;

    static {
        cache_biz_rsp = r0;
        byte[] bArr = {0};
    }

    public DumpBussinessRsp() {
        this.biz_rsp = null;
        this.result = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.biz_rsp = jceInputStream.read(cache_biz_rsp, 0, false);
        this.result = (stResult) jceInputStream.read((JceStruct) cache_result, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.biz_rsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        stResult stresult = this.result;
        if (stresult != null) {
            jceOutputStream.write((JceStruct) stresult, 1);
        }
    }

    public DumpBussinessRsp(byte[] bArr, stResult stresult) {
        this.biz_rsp = bArr;
        this.result = stresult;
    }
}
