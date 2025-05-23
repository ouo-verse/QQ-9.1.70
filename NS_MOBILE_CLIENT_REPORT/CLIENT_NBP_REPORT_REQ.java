package NS_MOBILE_CLIENT_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class CLIENT_NBP_REPORT_REQ extends JceStruct {
    static Map<String, String> cache_extra_info;
    static ArrayList<String> cache_report_info;
    public Map<String, String> extra_info;
    public ArrayList<String> report_info;
    public String strABTestId;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_report_info = arrayList;
        arrayList.add("");
        HashMap hashMap = new HashMap();
        cache_extra_info = hashMap;
        hashMap.put("", "");
    }

    public CLIENT_NBP_REPORT_REQ() {
        this.strABTestId = "";
        this.report_info = null;
        this.extra_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strABTestId = jceInputStream.readString(0, false);
        this.report_info = (ArrayList) jceInputStream.read((JceInputStream) cache_report_info, 1, false);
        this.extra_info = (Map) jceInputStream.read((JceInputStream) cache_extra_info, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strABTestId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<String> arrayList = this.report_info;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map = this.extra_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public CLIENT_NBP_REPORT_REQ(String str, ArrayList<String> arrayList, Map<String, String> map) {
        this.strABTestId = str;
        this.report_info = arrayList;
        this.extra_info = map;
    }
}
