package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileCommitRsp extends JceStruct {
    static byte[] cache_biz_rsp;
    static stOffset cache_overwrite_range;
    public byte[] biz_rsp;
    public Map<Integer, DumpBussinessRsp> dumpRsp;
    public stOffset overwrite_range;
    public stResult result;
    public String session;
    static stResult cache_result = new stResult();
    static Map<Integer, DumpBussinessRsp> cache_dumpRsp = new HashMap();

    static {
        cache_biz_rsp = r0;
        byte[] bArr = {0};
        cache_dumpRsp.put(0, new DumpBussinessRsp());
        cache_overwrite_range = new stOffset();
    }

    public FileCommitRsp() {
        this.result = null;
        this.session = "";
        this.biz_rsp = null;
        this.dumpRsp = null;
        this.overwrite_range = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = (stResult) jceInputStream.read((JceStruct) cache_result, 1, true);
        this.session = jceInputStream.readString(2, false);
        this.biz_rsp = jceInputStream.read(cache_biz_rsp, 3, false);
        this.dumpRsp = (Map) jceInputStream.read((JceInputStream) cache_dumpRsp, 4, false);
        this.overwrite_range = (stOffset) jceInputStream.read((JceStruct) cache_overwrite_range, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.result, 1);
        String str = this.session;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        byte[] bArr = this.biz_rsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        Map<Integer, DumpBussinessRsp> map = this.dumpRsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        stOffset stoffset = this.overwrite_range;
        if (stoffset != null) {
            jceOutputStream.write((JceStruct) stoffset, 5);
        }
    }

    public FileCommitRsp(stResult stresult, String str, byte[] bArr, Map<Integer, DumpBussinessRsp> map, stOffset stoffset) {
        this.result = stresult;
        this.session = str;
        this.biz_rsp = bArr;
        this.dumpRsp = map;
        this.overwrite_range = stoffset;
    }
}
