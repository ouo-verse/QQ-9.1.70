package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWeishiDengtaReportReq extends JceStruct {
    static Map<String, String> cache_params;
    public String eventName;
    public Map<String, String> params;

    static {
        HashMap hashMap = new HashMap();
        cache_params = hashMap;
        hashMap.put("", "");
    }

    public stWeishiDengtaReportReq() {
        this.eventName = "";
        this.params = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eventName = jceInputStream.readString(0, false);
        this.params = (Map) jceInputStream.read((JceInputStream) cache_params, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.eventName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Map<String, String> map = this.params;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public stWeishiDengtaReportReq(String str, Map<String, String> map) {
        this.eventName = str;
        this.params = map;
    }
}
