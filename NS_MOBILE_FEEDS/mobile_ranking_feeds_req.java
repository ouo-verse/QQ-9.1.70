package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_ranking_feeds_req extends JceStruct {
    static Map<String, String> cache_mapEx;
    static Map<Integer, byte[]> cache_stMapRanking;
    public int iOperaType;
    public Map<String, String> mapEx;
    public Map<Integer, byte[]> stMapRanking;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
        cache_stMapRanking = new HashMap();
        cache_stMapRanking.put(0, new byte[]{0});
    }

    public mobile_ranking_feeds_req() {
        this.uin = 0L;
        this.iOperaType = 1;
        this.mapEx = null;
        this.stMapRanking = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.iOperaType = jceInputStream.read(this.iOperaType, 1, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 2, false);
        this.stMapRanking = (Map) jceInputStream.read((JceInputStream) cache_stMapRanking, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.iOperaType, 1);
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        Map<Integer, byte[]> map2 = this.stMapRanking;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 3);
        }
    }

    public mobile_ranking_feeds_req(long j3, int i3, Map<String, String> map, Map<Integer, byte[]> map2) {
        this.uin = j3;
        this.iOperaType = i3;
        this.mapEx = map;
        this.stMapRanking = map2;
    }
}
