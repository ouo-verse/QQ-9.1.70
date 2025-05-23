package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UgcDecoQualReq extends JceStruct {
    static Map<Integer, Integer> cache_mapItemId = new HashMap();
    public Map<Integer, Integer> mapItemId;

    static {
        cache_mapItemId.put(0, 0);
    }

    public UgcDecoQualReq() {
        this.mapItemId = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapItemId = (Map) jceInputStream.read((JceInputStream) cache_mapItemId, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, Integer> map = this.mapItemId;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public UgcDecoQualReq(Map<Integer, Integer> map) {
        this.mapItemId = map;
    }
}
