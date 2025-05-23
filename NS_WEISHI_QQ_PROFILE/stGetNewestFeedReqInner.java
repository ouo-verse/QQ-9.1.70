package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetNewestFeedReqInner extends JceStruct {
    static Map<String, String> cache_mapExtern;
    public int cache_update_time;
    public Map<String, String> mapExtern;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtern = hashMap;
        hashMap.put("", "");
    }

    public stGetNewestFeedReqInner() {
        this.uin = 0L;
        this.cache_update_time = 0;
        this.mapExtern = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.cache_update_time = jceInputStream.read(this.cache_update_time, 1, false);
        this.mapExtern = (Map) jceInputStream.read((JceInputStream) cache_mapExtern, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.cache_update_time, 1);
        Map<String, String> map = this.mapExtern;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public stGetNewestFeedReqInner(long j3, int i3, Map<String, String> map) {
        this.uin = j3;
        this.cache_update_time = i3;
        this.mapExtern = map;
    }
}
