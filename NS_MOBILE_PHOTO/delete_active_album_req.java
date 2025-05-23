package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class delete_active_album_req extends JceStruct {
    static Map<String, String> cache_map_params;
    public Map<String, String> map_params;
    public String mgz_id;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_map_params = hashMap;
        hashMap.put("", "");
    }

    public delete_active_album_req() {
        this.uin = 0L;
        this.mgz_id = "";
        this.map_params = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.mgz_id = jceInputStream.readString(1, true);
        this.map_params = (Map) jceInputStream.read((JceInputStream) cache_map_params, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.mgz_id, 1);
        Map<String, String> map = this.map_params;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public delete_active_album_req(long j3, String str, Map<String, String> map) {
        this.uin = j3;
        this.mgz_id = str;
        this.map_params = map;
    }
}
