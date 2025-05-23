package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetNewestFeedReq extends JceStruct {
    static Map<Long, stGetNewestFeedReqInner> cache_mapReq = new HashMap();
    public Map<Long, stGetNewestFeedReqInner> mapReq;

    static {
        cache_mapReq.put(0L, new stGetNewestFeedReqInner());
    }

    public stGetNewestFeedReq() {
        this.mapReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapReq = (Map) jceInputStream.read((JceInputStream) cache_mapReq, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, stGetNewestFeedReqInner> map = this.mapReq;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public stGetNewestFeedReq(Map<Long, stGetNewestFeedReqInner> map) {
        this.mapReq = map;
    }
}
