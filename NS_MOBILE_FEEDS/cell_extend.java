package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_extend extends JceStruct {
    static Map<String, String> cache_mapEx;
    public Map<String, String> mapEx;

    static {
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public cell_extend() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public cell_extend(Map<String, String> map) {
        this.mapEx = map;
    }
}
