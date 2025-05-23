package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SceneExt extends JceStruct {
    static Map<String, String> cache_mapExtend;
    public Map<String, String> mapExtend;

    public SceneExt() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_mapExtend == null) {
            HashMap hashMap = new HashMap();
            cache_mapExtend = hashMap;
            hashMap.put("", "");
        }
        this.mapExtend = (Map) jceInputStream.read((JceInputStream) cache_mapExtend, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, String> map = this.mapExtend;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public SceneExt(Map<String, String> map) {
        this.mapExtend = map;
    }
}
