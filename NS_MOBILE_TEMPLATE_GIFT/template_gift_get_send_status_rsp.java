package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class template_gift_get_send_status_rsp extends JceStruct {
    static Map<String, String> cache_mapExt;
    static Map<Long, Integer> cache_map_birth_friend_list_state = new HashMap();
    public Map<String, String> mapExt;
    public Map<Long, Integer> map_birth_friend_list_state;
    public long uin;

    static {
        cache_map_birth_friend_list_state.put(0L, 0);
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public template_gift_get_send_status_rsp() {
        this.uin = 0L;
        this.map_birth_friend_list_state = null;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.map_birth_friend_list_state = (Map) jceInputStream.read((JceInputStream) cache_map_birth_friend_list_state, 1, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        Map<Long, Integer> map = this.map_birth_friend_list_state;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<String, String> map2 = this.mapExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
    }

    public template_gift_get_send_status_rsp(long j3, Map<Long, Integer> map, Map<String, String> map2) {
        this.uin = j3;
        this.map_birth_friend_list_state = map;
        this.mapExt = map2;
    }
}
