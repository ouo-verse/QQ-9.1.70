package NS_GROUP_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_batch_get_profile_count_req extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static ArrayList<Long> cache_vecUinList = new ArrayList<>();
    public Map<String, String> extendinfo;
    public ArrayList<Long> vecUinList;

    static {
        cache_vecUinList.add(0L);
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_batch_get_profile_count_req() {
        this.vecUinList = null;
        this.extendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecUinList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUinList, 0, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<Long> arrayList = this.vecUinList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public mobile_batch_get_profile_count_req(ArrayList<Long> arrayList, Map<String, String> map) {
        this.vecUinList = arrayList;
        this.extendinfo = map;
    }
}
