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
public final class mobile_single_feeds_rsp extends JceStruct {
    static ArrayList<single_feed> cache_all_feeds_data = new ArrayList<>();
    static Map<String, String> cache_stMapExtendinfo;
    public ArrayList<single_feed> all_feeds_data;
    public long next_keep_alive_time;
    public Map<String, String> stMapExtendinfo;

    static {
        cache_all_feeds_data.add(new single_feed());
        HashMap hashMap = new HashMap();
        cache_stMapExtendinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_single_feeds_rsp() {
        this.all_feeds_data = null;
        this.next_keep_alive_time = 0L;
        this.stMapExtendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.all_feeds_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_feeds_data, 0, false);
        this.next_keep_alive_time = jceInputStream.read(this.next_keep_alive_time, 1, false);
        this.stMapExtendinfo = (Map) jceInputStream.read((JceInputStream) cache_stMapExtendinfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<single_feed> arrayList = this.all_feeds_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.next_keep_alive_time, 1);
        Map<String, String> map = this.stMapExtendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public mobile_single_feeds_rsp(ArrayList<single_feed> arrayList, long j3, Map<String, String> map) {
        this.all_feeds_data = arrayList;
        this.next_keep_alive_time = j3;
        this.stMapExtendinfo = map;
    }
}
