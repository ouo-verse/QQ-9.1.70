package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_original extends JceStruct {
    static Map<Integer, byte[]> cache_original_data = new HashMap();
    public Map<Integer, byte[]> original_data;

    static {
        cache_original_data.put(0, new byte[]{0});
    }

    public cell_original() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.original_data = (Map) jceInputStream.read((JceInputStream) cache_original_data, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, byte[]> map = this.original_data;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public cell_original(Map<Integer, byte[]> map) {
        this.original_data = map;
    }
}
