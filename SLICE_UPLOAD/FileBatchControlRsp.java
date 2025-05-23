package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileBatchControlRsp extends JceStruct {
    static Map<String, FileControlRsp> cache_control_rsp = new HashMap();
    public Map<String, FileControlRsp> control_rsp;

    static {
        cache_control_rsp.put("", new FileControlRsp());
    }

    public FileBatchControlRsp() {
        this.control_rsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.control_rsp = (Map) jceInputStream.read((JceInputStream) cache_control_rsp, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.control_rsp, 0);
    }

    public FileBatchControlRsp(Map<String, FileControlRsp> map) {
        this.control_rsp = map;
    }
}
