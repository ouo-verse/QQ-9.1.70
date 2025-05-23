package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ItemCfgInfo extends JceStruct {
    static Map<Long, String> cache_itemJumUrl = new HashMap();
    public Map<Long, String> itemJumUrl;
    public int vipType;

    static {
        cache_itemJumUrl.put(0L, "");
    }

    public ItemCfgInfo() {
        this.vipType = 0;
        this.itemJumUrl = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vipType = jceInputStream.read(this.vipType, 0, false);
        this.itemJumUrl = (Map) jceInputStream.read((JceInputStream) cache_itemJumUrl, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vipType, 0);
        Map<Long, String> map = this.itemJumUrl;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public ItemCfgInfo(int i3, Map<Long, String> map) {
        this.vipType = i3;
        this.itemJumUrl = map;
    }
}
