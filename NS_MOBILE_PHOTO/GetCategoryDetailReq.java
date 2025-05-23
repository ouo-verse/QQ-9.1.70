package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCategoryDetailReq extends JceStruct {
    static Map<Integer, GetCategoryDetailReqItem> cache_req_item_map = new HashMap();
    public long host;
    public Map<Integer, GetCategoryDetailReqItem> req_item_map;

    static {
        cache_req_item_map.put(0, new GetCategoryDetailReqItem());
    }

    public GetCategoryDetailReq() {
        this.host = 0L;
        this.req_item_map = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.host = jceInputStream.read(this.host, 0, false);
        this.req_item_map = (Map) jceInputStream.read((JceInputStream) cache_req_item_map, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.host, 0);
        Map<Integer, GetCategoryDetailReqItem> map = this.req_item_map;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public GetCategoryDetailReq(long j3, Map<Integer, GetCategoryDetailReqItem> map) {
        this.host = j3;
        this.req_item_map = map;
    }
}
