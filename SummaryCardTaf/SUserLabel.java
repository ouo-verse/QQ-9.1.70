package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SUserLabel extends JceStruct {
    static Map<Long, SLabelInfo> cache_label;
    public Map<Long, SLabelInfo> label;

    public SUserLabel() {
        this.label = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_label == null) {
            cache_label = new HashMap();
            cache_label.put(0L, new SLabelInfo());
        }
        this.label = (Map) jceInputStream.read((JceInputStream) cache_label, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.label, 0);
    }

    public SUserLabel(Map<Long, SLabelInfo> map) {
        this.label = map;
    }
}
