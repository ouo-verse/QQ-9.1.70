package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picurl;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ChangePicURLRsp extends JceStruct {
    static Map<String, Map<Integer, s_picurl>> cache_urls = new HashMap();
    public Map<String, Map<Integer, s_picurl>> urls;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(0, new s_picurl());
        cache_urls.put("", hashMap);
    }

    public ChangePicURLRsp() {
        this.urls = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.urls = (Map) jceInputStream.read((JceInputStream) cache_urls, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, Map<Integer, s_picurl>> map = this.urls;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public ChangePicURLRsp(Map<String, Map<Integer, s_picurl>> map) {
        this.urls = map;
    }
}
