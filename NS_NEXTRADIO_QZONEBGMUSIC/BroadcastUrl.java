package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BroadcastUrl extends JceStruct {
    static Map<Byte, String> cache_mapBroadcastUrl = new HashMap();
    public Map<Byte, String> mapBroadcastUrl;

    static {
        cache_mapBroadcastUrl.put((byte) 0, "");
    }

    public BroadcastUrl() {
        this.mapBroadcastUrl = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapBroadcastUrl = (Map) jceInputStream.read((JceInputStream) cache_mapBroadcastUrl, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Byte, String> map = this.mapBroadcastUrl;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public BroadcastUrl(Map<Byte, String> map) {
        this.mapBroadcastUrl = map;
    }
}
