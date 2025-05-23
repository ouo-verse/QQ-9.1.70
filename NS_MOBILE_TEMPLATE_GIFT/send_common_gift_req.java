package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class send_common_gift_req extends JceStruct {
    static s_send_gift_item cache_giftItem = new s_send_gift_item();
    static Map<String, String> cache_mapExt;
    public s_send_gift_item giftItem;
    public Map<String, String> mapExt;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public send_common_gift_req() {
        this.giftItem = null;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.giftItem = (s_send_gift_item) jceInputStream.read((JceStruct) cache_giftItem, 0, true);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.giftItem, 0);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public send_common_gift_req(s_send_gift_item s_send_gift_itemVar, Map<String, String> map) {
        this.giftItem = s_send_gift_itemVar;
        this.mapExt = map;
    }
}
