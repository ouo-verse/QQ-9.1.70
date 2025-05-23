package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileBatchCommitRsp extends JceStruct {
    static Map<String, FileCommitRsp> cache_commit_rsp = new HashMap();
    public Map<String, FileCommitRsp> commit_rsp;

    static {
        cache_commit_rsp.put("", new FileCommitRsp());
    }

    public FileBatchCommitRsp() {
        this.commit_rsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commit_rsp = (Map) jceInputStream.read((JceInputStream) cache_commit_rsp, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.commit_rsp, 0);
    }

    public FileBatchCommitRsp(Map<String, FileCommitRsp> map) {
        this.commit_rsp = map;
    }
}
