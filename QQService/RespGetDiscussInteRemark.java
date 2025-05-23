package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetDiscussInteRemark extends JceStruct {
    static Map<Long, InteRemarkInfo> cache_InteRemarks;
    public String DiscussName;
    public long DiscussUin;
    public Map<Long, InteRemarkInfo> InteRemarks;

    public RespGetDiscussInteRemark() {
        this.DiscussUin = 0L;
        this.InteRemarks = null;
        this.DiscussName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        if (cache_InteRemarks == null) {
            cache_InteRemarks = new HashMap();
            cache_InteRemarks.put(0L, new InteRemarkInfo());
        }
        this.InteRemarks = (Map) jceInputStream.read((JceInputStream) cache_InteRemarks, 1, true);
        this.DiscussName = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write((Map) this.InteRemarks, 1);
        String str = this.DiscussName;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public RespGetDiscussInteRemark(long j3, Map<Long, InteRemarkInfo> map, String str) {
        this.DiscussUin = j3;
        this.InteRemarks = map;
        this.DiscussName = str;
    }
}
