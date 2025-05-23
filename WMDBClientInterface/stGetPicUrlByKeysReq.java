package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stGetPicUrlByKeysReq extends JceStruct {
    static Map<String, String> cache_keys;
    public Map<String, String> keys;

    public stGetPicUrlByKeysReq() {
        this.keys = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_keys == null) {
            HashMap hashMap = new HashMap();
            cache_keys = hashMap;
            hashMap.put("", "");
        }
        this.keys = (Map) jceInputStream.read((JceInputStream) cache_keys, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.keys, 0);
    }

    public stGetPicUrlByKeysReq(Map<String, String> map) {
        this.keys = map;
    }
}
