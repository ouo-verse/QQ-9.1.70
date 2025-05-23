package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SUserLable extends JceStruct {
    static Map<Long, SLableInfo> cache_lable;
    public Map<Long, SLableInfo> lable;

    public SUserLable() {
        this.lable = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_lable == null) {
            cache_lable = new HashMap();
            cache_lable.put(0L, new SLableInfo());
        }
        this.lable = (Map) jceInputStream.read((JceInputStream) cache_lable, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.lable, 0);
    }

    public SUserLable(Map<Long, SLableInfo> map) {
        this.lable = map;
    }
}
