package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class template_gift_get_send_status_req extends JceStruct {
    static ArrayList<Long> cache_birth_friend_list = new ArrayList<>();
    static Map<String, String> cache_mapExt;
    public ArrayList<Long> birth_friend_list;
    public Map<String, String> mapExt;
    public long uin;

    static {
        cache_birth_friend_list.add(0L);
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public template_gift_get_send_status_req() {
        this.uin = 0L;
        this.birth_friend_list = null;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.birth_friend_list = (ArrayList) jceInputStream.read((JceInputStream) cache_birth_friend_list, 1, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        ArrayList<Long> arrayList = this.birth_friend_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public template_gift_get_send_status_req(long j3, ArrayList<Long> arrayList, Map<String, String> map) {
        this.uin = j3;
        this.birth_friend_list = arrayList;
        this.mapExt = map;
    }
}
