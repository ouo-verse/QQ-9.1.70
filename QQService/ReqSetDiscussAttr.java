package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSetDiscussAttr extends JceStruct {
    static Map<Integer, MemberAttrInfo> cache_Attr;
    public Map<Integer, MemberAttrInfo> Attr;
    public long DiscussUin;

    public ReqSetDiscussAttr() {
        this.DiscussUin = 0L;
        this.Attr = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        if (cache_Attr == null) {
            cache_Attr = new HashMap();
            cache_Attr.put(0, new MemberAttrInfo());
        }
        this.Attr = (Map) jceInputStream.read((JceInputStream) cache_Attr, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write((Map) this.Attr, 1);
    }

    public ReqSetDiscussAttr(long j3, Map<Integer, MemberAttrInfo> map) {
        this.DiscussUin = j3;
        this.Attr = map;
    }
}
