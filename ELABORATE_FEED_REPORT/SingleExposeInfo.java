package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SingleExposeInfo extends JceStruct {
    static Map<Integer, String> cache_mapFeedCookie = new HashMap();
    public long exposeTime;
    public int feedPos;
    public Map<Integer, String> mapFeedCookie;

    static {
        cache_mapFeedCookie.put(0, "");
    }

    public SingleExposeInfo() {
        this.mapFeedCookie = null;
        this.exposeTime = 0L;
        this.feedPos = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapFeedCookie = (Map) jceInputStream.read((JceInputStream) cache_mapFeedCookie, 0, false);
        this.exposeTime = jceInputStream.read(this.exposeTime, 1, false);
        this.feedPos = jceInputStream.read(this.feedPos, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, String> map = this.mapFeedCookie;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        jceOutputStream.write(this.exposeTime, 1);
        jceOutputStream.write(this.feedPos, 2);
    }

    public SingleExposeInfo(Map<Integer, String> map, long j3, int i3) {
        this.mapFeedCookie = map;
        this.exposeTime = j3;
        this.feedPos = i3;
    }
}
