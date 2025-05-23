package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class rtmp_report_timed_info_req extends JceStruct {
    static Map<String, String> cache_ext_info;
    public rtmp_report_comm_info comm_info;
    public Map<String, String> ext_info;
    public ArrayList<rtmp_report_timed_info> timed_infos;
    static rtmp_report_comm_info cache_comm_info = new rtmp_report_comm_info();
    static ArrayList<rtmp_report_timed_info> cache_timed_infos = new ArrayList<>();

    static {
        cache_timed_infos.add(new rtmp_report_timed_info());
        HashMap hashMap = new HashMap();
        cache_ext_info = hashMap;
        hashMap.put("", "");
    }

    public rtmp_report_timed_info_req() {
        this.comm_info = null;
        this.timed_infos = null;
        this.ext_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.comm_info = (rtmp_report_comm_info) jceInputStream.read((JceStruct) cache_comm_info, 0, false);
        this.timed_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_timed_infos, 1, false);
        this.ext_info = (Map) jceInputStream.read((JceInputStream) cache_ext_info, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        rtmp_report_comm_info rtmp_report_comm_infoVar = this.comm_info;
        if (rtmp_report_comm_infoVar != null) {
            jceOutputStream.write((JceStruct) rtmp_report_comm_infoVar, 0);
        }
        ArrayList<rtmp_report_timed_info> arrayList = this.timed_infos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map = this.ext_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public rtmp_report_timed_info_req(rtmp_report_comm_info rtmp_report_comm_infoVar, ArrayList<rtmp_report_timed_info> arrayList, Map<String, String> map) {
        this.comm_info = rtmp_report_comm_infoVar;
        this.timed_infos = arrayList;
        this.ext_info = map;
    }
}
