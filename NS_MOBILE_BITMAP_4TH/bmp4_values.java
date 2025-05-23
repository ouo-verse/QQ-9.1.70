package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class bmp4_values extends JceStruct {
    static Map<String, Long> cache_map_kv = new HashMap();
    public Map<String, Long> map_kv;

    static {
        cache_map_kv.put("", 0L);
    }

    public bmp4_values() {
        this.map_kv = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.map_kv = (Map) jceInputStream.read((JceInputStream) cache_map_kv, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, Long> map = this.map_kv;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public bmp4_values(Map<String, Long> map) {
        this.map_kv = map;
    }
}
