package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSimpleGetFeedDetailReq extends JceStruct {
    static Map<String, Integer> cache_feedsVideoType = new HashMap();
    public String feedid;
    public Map<String, Integer> feedsVideoType;
    public int scene;

    static {
        cache_feedsVideoType.put("", 0);
    }

    public stSimpleGetFeedDetailReq() {
        this.feedid = "";
        this.scene = 0;
        this.feedsVideoType = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feedid = jceInputStream.readString(0, false);
        this.scene = jceInputStream.read(this.scene, 1, false);
        this.feedsVideoType = (Map) jceInputStream.read((JceInputStream) cache_feedsVideoType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.feedid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.scene, 1);
        Map<String, Integer> map = this.feedsVideoType;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public stSimpleGetFeedDetailReq(String str, int i3, Map<String, Integer> map) {
        this.feedid = str;
        this.scene = i3;
        this.feedsVideoType = map;
    }
}
