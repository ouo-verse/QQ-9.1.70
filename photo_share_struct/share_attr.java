package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class share_attr extends JceStruct {
    static Map<Long, uin_attr> cache_shares_attr = new HashMap();
    public long owner;
    public Map<Long, uin_attr> shares_attr;
    public String source;

    static {
        cache_shares_attr.put(0L, new uin_attr());
    }

    public share_attr() {
        this.shares_attr = null;
        this.source = "";
        this.owner = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shares_attr = (Map) jceInputStream.read((JceInputStream) cache_shares_attr, 0, false);
        this.source = jceInputStream.readString(1, false);
        this.owner = jceInputStream.read(this.owner, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, uin_attr> map = this.shares_attr;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        String str = this.source;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.owner, 2);
    }

    public share_attr(Map<Long, uin_attr> map, String str, long j3) {
        this.shares_attr = map;
        this.source = str;
        this.owner = j3;
    }
}
