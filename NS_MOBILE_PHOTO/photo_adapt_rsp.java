package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class photo_adapt_rsp extends JceStruct {
    static Map<String, st_adapt_result> cache_urlStatus = new HashMap();
    public Map<String, st_adapt_result> urlStatus;

    static {
        cache_urlStatus.put("", new st_adapt_result());
    }

    public photo_adapt_rsp() {
        this.urlStatus = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.urlStatus = (Map) jceInputStream.read((JceInputStream) cache_urlStatus, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.urlStatus, 0);
    }

    public photo_adapt_rsp(Map<String, st_adapt_result> map) {
        this.urlStatus = map;
    }
}
