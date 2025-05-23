package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DcStandardReportReq extends JceStruct {
    static ArrayList<Map<String, String>> cache_report_infos = new ArrayList<>();
    public String dc_name;
    public ArrayList<Map<String, String>> report_infos;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("", "");
        cache_report_infos.add(hashMap);
    }

    public DcStandardReportReq() {
        this.dc_name = "";
        this.report_infos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dc_name = jceInputStream.readString(0, false);
        this.report_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_report_infos, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.dc_name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<Map<String, String>> arrayList = this.report_infos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public DcStandardReportReq(String str, ArrayList<Map<String, String>> arrayList) {
        this.dc_name = str;
        this.report_infos = arrayList;
    }
}
