package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileBatchControlReq extends JceStruct {
    static Map<String, FileControlReq> cache_control_req = new HashMap();
    public Map<String, FileControlReq> control_req;

    static {
        cache_control_req.put("", new FileControlReq());
    }

    public FileBatchControlReq() {
        this.control_req = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.control_req = (Map) jceInputStream.read((JceInputStream) cache_control_req, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.control_req, 0);
    }

    public FileBatchControlReq(Map<String, FileControlReq> map) {
        this.control_req = map;
    }
}
