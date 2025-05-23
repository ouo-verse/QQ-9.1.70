package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_qzone_public_msg_req extends JceStruct {
    static Map<String, String> cache_map_ext;
    public Map<String, String> map_ext;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
    }

    public mobile_get_qzone_public_msg_req() {
        this.uin = 0L;
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public mobile_get_qzone_public_msg_req(long j3, Map<String, String> map) {
        this.uin = j3;
        this.map_ext = map;
    }
}
