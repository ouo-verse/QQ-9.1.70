package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetNewestFeedRsp extends JceStruct {
    static Map<Long, stGetNewestFeedRspInner> cache_mapRsp = new HashMap();
    public Map<Long, stGetNewestFeedRspInner> mapRsp;

    static {
        cache_mapRsp.put(0L, new stGetNewestFeedRspInner());
    }

    public stGetNewestFeedRsp() {
        this.mapRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapRsp = (Map) jceInputStream.read((JceInputStream) cache_mapRsp, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, stGetNewestFeedRspInner> map = this.mapRsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public stGetNewestFeedRsp(Map<Long, stGetNewestFeedRspInner> map) {
        this.mapRsp = map;
    }
}
