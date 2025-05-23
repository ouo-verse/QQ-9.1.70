package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetMsgRedDotRsp extends JceStruct {
    static Map<Integer, stMsgRedDotCount> cache_redDotCount = new HashMap();
    public Map<Integer, stMsgRedDotCount> redDotCount;

    static {
        cache_redDotCount.put(0, new stMsgRedDotCount());
    }

    public stGetMsgRedDotRsp() {
        this.redDotCount = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.redDotCount = (Map) jceInputStream.read((JceInputStream) cache_redDotCount, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, stMsgRedDotCount> map = this.redDotCount;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public stGetMsgRedDotRsp(Map<Integer, stMsgRedDotCount> map) {
        this.redDotCount = map;
    }
}
