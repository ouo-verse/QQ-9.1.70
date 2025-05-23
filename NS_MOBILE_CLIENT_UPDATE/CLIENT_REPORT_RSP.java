package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class CLIENT_REPORT_RSP extends JceStruct {
    static Map<String, String> cache_msg;
    public int code;

    /* renamed from: msg, reason: collision with root package name */
    public Map<String, String> f24970msg;

    static {
        HashMap hashMap = new HashMap();
        cache_msg = hashMap;
        hashMap.put("", "");
    }

    public CLIENT_REPORT_RSP() {
        this.code = 0;
        this.f24970msg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.f24970msg = (Map) jceInputStream.read((JceInputStream) cache_msg, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        Map<String, String> map = this.f24970msg;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public CLIENT_REPORT_RSP(int i3, Map<String, String> map) {
        this.code = i3;
        this.f24970msg = map;
    }
}
