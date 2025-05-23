package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoSummary extends JceStruct {
    static Map<Integer, String> cache_cover = new HashMap();
    public Map<Integer, String> cover;
    public int num;

    static {
        cache_cover.put(0, "");
    }

    public VideoSummary() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.cover = (Map) jceInputStream.read((JceInputStream) cache_cover, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        Map<Integer, String> map = this.cover;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public VideoSummary(int i3, Map<Integer, String> map) {
        this.num = i3;
        this.cover = map;
    }
}
