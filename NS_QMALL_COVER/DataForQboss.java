package NS_QMALL_COVER;

import BOSSStrategyCenter.tAdvDesc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DataForQboss extends JceStruct {
    static Map<Integer, tAdvDesc> cache_map_adv_desc = new HashMap();
    public Map<Integer, tAdvDesc> map_adv_desc;

    static {
        cache_map_adv_desc.put(0, new tAdvDesc());
    }

    public DataForQboss() {
        this.map_adv_desc = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.map_adv_desc = (Map) jceInputStream.read((JceInputStream) cache_map_adv_desc, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, tAdvDesc> map = this.map_adv_desc;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public DataForQboss(Map<Integer, tAdvDesc> map) {
        this.map_adv_desc = map;
    }
}
