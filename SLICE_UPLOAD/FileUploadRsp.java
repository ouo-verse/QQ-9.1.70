package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileUploadRsp extends JceStruct {
    static byte[] cache_biz_rsp;
    static int cache_data_type;
    public byte[] biz_rsp;
    public long confirm_offset;
    public int data_type;
    public Map<Integer, DumpBussinessRsp> dumpRsp;
    public long offset;
    public long receive_time;
    public long response_time;
    public stResult result;
    public String session;
    static stResult cache_result = new stResult();
    static Map<Integer, DumpBussinessRsp> cache_dumpRsp = new HashMap();

    static {
        cache_biz_rsp = r0;
        byte[] bArr = {0};
        cache_dumpRsp.put(0, new DumpBussinessRsp());
        cache_data_type = 0;
    }

    public FileUploadRsp() {
        this.result = null;
        this.session = "";
        this.offset = 0L;
        this.biz_rsp = null;
        this.receive_time = 0L;
        this.response_time = 0L;
        this.dumpRsp = null;
        this.data_type = 0;
        this.confirm_offset = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = (stResult) jceInputStream.read((JceStruct) cache_result, 1, true);
        this.session = jceInputStream.readString(2, false);
        this.offset = jceInputStream.read(this.offset, 3, false);
        this.biz_rsp = jceInputStream.read(cache_biz_rsp, 4, false);
        this.receive_time = jceInputStream.read(this.receive_time, 5, false);
        this.response_time = jceInputStream.read(this.response_time, 6, false);
        this.dumpRsp = (Map) jceInputStream.read((JceInputStream) cache_dumpRsp, 7, false);
        this.data_type = jceInputStream.read(this.data_type, 8, false);
        this.confirm_offset = jceInputStream.read(this.confirm_offset, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.result, 1);
        String str = this.session;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.offset, 3);
        byte[] bArr = this.biz_rsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        jceOutputStream.write(this.receive_time, 5);
        jceOutputStream.write(this.response_time, 6);
        Map<Integer, DumpBussinessRsp> map = this.dumpRsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        jceOutputStream.write(this.data_type, 8);
        jceOutputStream.write(this.confirm_offset, 9);
    }

    public FileUploadRsp(stResult stresult, String str, long j3, byte[] bArr, long j16, long j17, Map<Integer, DumpBussinessRsp> map, int i3, long j18) {
        this.result = stresult;
        this.session = str;
        this.offset = j3;
        this.biz_rsp = bArr;
        this.receive_time = j16;
        this.response_time = j17;
        this.dumpRsp = map;
        this.data_type = i3;
        this.confirm_offset = j18;
    }
}
