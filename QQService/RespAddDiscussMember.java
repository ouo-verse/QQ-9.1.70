package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespAddDiscussMember extends JceStruct {
    static Map<Long, Integer> cache_AddResult;
    public Map<Long, Integer> AddResult;
    public long DiscussUin;

    public RespAddDiscussMember() {
        this.DiscussUin = 0L;
        this.AddResult = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        if (cache_AddResult == null) {
            cache_AddResult = new HashMap();
            cache_AddResult.put(0L, 0);
        }
        this.AddResult = (Map) jceInputStream.read((JceInputStream) cache_AddResult, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write((Map) this.AddResult, 1);
    }

    public RespAddDiscussMember(long j3, Map<Long, Integer> map) {
        this.DiscussUin = j3;
        this.AddResult = map;
    }
}
