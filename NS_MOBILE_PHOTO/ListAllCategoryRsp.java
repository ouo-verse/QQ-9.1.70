package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ListAllCategoryRsp extends JceStruct {
    static Map<Integer, ListAllCategoryRspItem> cache_rsp_item_map = new HashMap();
    public long host;
    public Map<Integer, ListAllCategoryRspItem> rsp_item_map;

    static {
        cache_rsp_item_map.put(0, new ListAllCategoryRspItem());
    }

    public ListAllCategoryRsp() {
        this.host = 0L;
        this.rsp_item_map = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.host = jceInputStream.read(this.host, 0, false);
        this.rsp_item_map = (Map) jceInputStream.read((JceInputStream) cache_rsp_item_map, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.host, 0);
        Map<Integer, ListAllCategoryRspItem> map = this.rsp_item_map;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public ListAllCategoryRsp(long j3, Map<Integer, ListAllCategoryRspItem> map) {
        this.host = j3;
        this.rsp_item_map = map;
    }
}
