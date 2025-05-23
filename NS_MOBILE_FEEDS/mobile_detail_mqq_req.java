package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_detail_mqq_req extends JceStruct {
    static Map<String, String> cache_mqqinfo;
    public Map<String, String> mqqinfo;

    static {
        HashMap hashMap = new HashMap();
        cache_mqqinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_detail_mqq_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mqqinfo = (Map) jceInputStream.read((JceInputStream) cache_mqqinfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.mqqinfo, 1);
    }

    public mobile_detail_mqq_req(Map<String, String> map) {
        this.mqqinfo = map;
    }
}
