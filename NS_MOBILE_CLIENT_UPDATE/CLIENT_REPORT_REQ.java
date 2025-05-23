package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class CLIENT_REPORT_REQ extends JceStruct {
    static Map<String, String> cache_extra_info;
    static ArrayList<Map<String, String>> cache_info = new ArrayList<>();
    static ArrayList<REPORT_INFO> cache_multi_info;
    public Map<String, String> extra_info;
    public ArrayList<Map<String, String>> info;
    public ArrayList<REPORT_INFO> multi_info;
    public long type;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("", "");
        cache_info.add(hashMap);
        HashMap hashMap2 = new HashMap();
        cache_extra_info = hashMap2;
        hashMap2.put("", "");
        cache_multi_info = new ArrayList<>();
        cache_multi_info.add(new REPORT_INFO());
    }

    public CLIENT_REPORT_REQ() {
        this.type = 0L;
        this.info = null;
        this.extra_info = null;
        this.multi_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.info = (ArrayList) jceInputStream.read((JceInputStream) cache_info, 1, false);
        this.extra_info = (Map) jceInputStream.read((JceInputStream) cache_extra_info, 2, false);
        this.multi_info = (ArrayList) jceInputStream.read((JceInputStream) cache_multi_info, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        ArrayList<Map<String, String>> arrayList = this.info;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map = this.extra_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        ArrayList<REPORT_INFO> arrayList2 = this.multi_info;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
    }

    public CLIENT_REPORT_REQ(long j3, ArrayList<Map<String, String>> arrayList, Map<String, String> map, ArrayList<REPORT_INFO> arrayList2) {
        this.type = j3;
        this.info = arrayList;
        this.extra_info = map;
        this.multi_info = arrayList2;
    }
}
