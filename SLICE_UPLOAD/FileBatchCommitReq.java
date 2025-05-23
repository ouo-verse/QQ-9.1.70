package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileBatchCommitReq extends JceStruct {
    static Map<String, FileCommitReq> cache_commit_req = new HashMap();
    public Map<String, FileCommitReq> commit_req;

    static {
        cache_commit_req.put("", new FileCommitReq());
    }

    public FileBatchCommitReq() {
        this.commit_req = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commit_req = (Map) jceInputStream.read((JceInputStream) cache_commit_req, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.commit_req, 0);
    }

    public FileBatchCommitReq(Map<String, FileCommitReq> map) {
        this.commit_req = map;
    }
}
