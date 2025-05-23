package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_click_button_req extends JceStruct {
    static Map<String, String> cache_busi_param;
    public Map<String, String> busi_param;

    static {
        HashMap hashMap = new HashMap();
        cache_busi_param = hashMap;
        hashMap.put("", "");
    }

    public operation_click_button_req() {
        this.busi_param = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public operation_click_button_req(Map<String, String> map) {
        this.busi_param = map;
    }
}
