package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_qzone_public_msg_rsp extends JceStruct {
    static Map<String, String> cache_map_ext;
    public int left_req_times;
    public Map<String, String> map_ext;
    public int next_req_tmstamp;
    public int stay_min_seconds_to_req;

    static {
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
    }

    public mobile_get_qzone_public_msg_rsp() {
        this.next_req_tmstamp = 0;
        this.left_req_times = 0;
        this.stay_min_seconds_to_req = 0;
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.next_req_tmstamp = jceInputStream.read(this.next_req_tmstamp, 0, false);
        this.left_req_times = jceInputStream.read(this.left_req_times, 1, false);
        this.stay_min_seconds_to_req = jceInputStream.read(this.stay_min_seconds_to_req, 2, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.next_req_tmstamp, 0);
        jceOutputStream.write(this.left_req_times, 1);
        jceOutputStream.write(this.stay_min_seconds_to_req, 2);
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public mobile_get_qzone_public_msg_rsp(int i3, int i16, int i17, Map<String, String> map) {
        this.next_req_tmstamp = i3;
        this.left_req_times = i16;
        this.stay_min_seconds_to_req = i17;
        this.map_ext = map;
    }
}
