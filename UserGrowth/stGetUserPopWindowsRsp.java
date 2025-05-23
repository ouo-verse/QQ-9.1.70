package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stGetUserPopWindowsRsp extends JceStruct {
    static Map<Integer, stPopWindowItem> cache_data = new HashMap();
    public Map<Integer, stPopWindowItem> data;

    static {
        cache_data.put(0, new stPopWindowItem());
    }

    public stGetUserPopWindowsRsp() {
        this.data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.data = (Map) jceInputStream.read((JceInputStream) cache_data, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, stPopWindowItem> map = this.data;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public stGetUserPopWindowsRsp(Map<Integer, stPopWindowItem> map) {
        this.data = map;
    }
}
