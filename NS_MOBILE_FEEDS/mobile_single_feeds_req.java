package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_single_feeds_req extends JceStruct {
    static ArrayList<single_feeds_req_info> cache_req_feeds_info = new ArrayList<>();
    static Map<String, String> cache_stMapExtendinfo;
    public int get_type;
    public ArrayList<single_feeds_req_info> req_feeds_info;
    public Map<String, String> stMapExtendinfo;

    static {
        cache_req_feeds_info.add(new single_feeds_req_info());
        HashMap hashMap = new HashMap();
        cache_stMapExtendinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_single_feeds_req() {
        this.get_type = 0;
        this.req_feeds_info = null;
        this.stMapExtendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.get_type = jceInputStream.read(this.get_type, 0, false);
        this.req_feeds_info = (ArrayList) jceInputStream.read((JceInputStream) cache_req_feeds_info, 1, false);
        this.stMapExtendinfo = (Map) jceInputStream.read((JceInputStream) cache_stMapExtendinfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.get_type, 0);
        ArrayList<single_feeds_req_info> arrayList = this.req_feeds_info;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map = this.stMapExtendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public mobile_single_feeds_req(int i3, ArrayList<single_feeds_req_info> arrayList, Map<String, String> map) {
        this.get_type = i3;
        this.req_feeds_info = arrayList;
        this.stMapExtendinfo = map;
    }
}
