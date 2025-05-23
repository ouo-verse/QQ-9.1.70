package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_profile_timeline extends JceStruct {
    static Map<Integer, ArrayList<s_profile_calendar>> cache_map_timeline = new HashMap();
    public Map<Integer, ArrayList<s_profile_calendar>> map_timeline;

    static {
        ArrayList<s_profile_calendar> arrayList = new ArrayList<>();
        arrayList.add(new s_profile_calendar());
        cache_map_timeline.put(0, arrayList);
    }

    public s_profile_timeline() {
        this.map_timeline = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.map_timeline = (Map) jceInputStream.read((JceInputStream) cache_map_timeline, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, ArrayList<s_profile_calendar>> map = this.map_timeline;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public s_profile_timeline(Map<Integer, ArrayList<s_profile_calendar>> map) {
        this.map_timeline = map;
    }
}
