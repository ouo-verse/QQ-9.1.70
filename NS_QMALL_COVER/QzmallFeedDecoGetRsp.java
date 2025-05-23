package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallFeedDecoGetRsp extends JceStruct {
    static Map<Long, byte[]> cache_mapRsp = new HashMap();
    public Map<Long, byte[]> mapRsp;

    static {
        cache_mapRsp.put(0L, new byte[]{0});
    }

    public QzmallFeedDecoGetRsp() {
        this.mapRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapRsp = (Map) jceInputStream.read((JceInputStream) cache_mapRsp, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, byte[]> map = this.mapRsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public QzmallFeedDecoGetRsp(Map<Long, byte[]> map) {
        this.mapRsp = map;
    }
}
