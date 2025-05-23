package NS_MOBILE_CLIENT_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class CLIENT_NBP_REPORT_RSP extends JceStruct {
    static Map<String, String> cache_extra_info;
    public int code;
    public Map<String, String> extra_info;

    static {
        HashMap hashMap = new HashMap();
        cache_extra_info = hashMap;
        hashMap.put("", "");
    }

    public CLIENT_NBP_REPORT_RSP() {
        this.code = 0;
        this.extra_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.extra_info = (Map) jceInputStream.read((JceInputStream) cache_extra_info, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        Map<String, String> map = this.extra_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public CLIENT_NBP_REPORT_RSP(int i3, Map<String, String> map) {
        this.code = i3;
        this.extra_info = map;
    }
}
