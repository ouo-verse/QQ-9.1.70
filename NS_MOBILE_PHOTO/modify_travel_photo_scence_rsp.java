package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class modify_travel_photo_scence_rsp extends JceStruct {
    static Map<String, Integer> cache_photo_result;
    static Map<String, Integer> cache_poi_result;
    static Map<Long, Long> cache_time_range = new HashMap();
    public Map<String, Integer> photo_result;
    public Map<String, Integer> poi_result;
    public String poiid;
    public Map<Long, Long> time_range;

    static {
        cache_time_range.put(0L, 0L);
        cache_poi_result = new HashMap();
        cache_poi_result.put("", 0);
        cache_photo_result = new HashMap();
        cache_photo_result.put("", 0);
    }

    public modify_travel_photo_scence_rsp() {
        this.poiid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.poiid = jceInputStream.readString(0, true);
        this.time_range = (Map) jceInputStream.read((JceInputStream) cache_time_range, 1, false);
        this.poi_result = (Map) jceInputStream.read((JceInputStream) cache_poi_result, 2, false);
        this.photo_result = (Map) jceInputStream.read((JceInputStream) cache_photo_result, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.poiid, 0);
        Map<Long, Long> map = this.time_range;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<String, Integer> map2 = this.poi_result;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
        Map<String, Integer> map3 = this.photo_result;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 3);
        }
    }

    public modify_travel_photo_scence_rsp(String str, Map<Long, Long> map, Map<String, Integer> map2, Map<String, Integer> map3) {
        this.poiid = str;
        this.time_range = map;
        this.poi_result = map2;
        this.photo_result = map3;
    }
}
