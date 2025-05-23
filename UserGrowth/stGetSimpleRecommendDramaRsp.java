package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetSimpleRecommendDramaRsp extends JceStruct {
    static Map<String, ArrayList<String>> cache_dramaFeedsMap;
    static ArrayList<stDrama> cache_dramas = new ArrayList<>();
    static Map<String, stDramaFeed> cache_feedInfoMap;
    public Map<String, ArrayList<String>> dramaFeedsMap;
    public ArrayList<stDrama> dramas;
    public Map<String, stDramaFeed> feedInfoMap;

    static {
        cache_dramas.add(new stDrama());
        cache_dramaFeedsMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        cache_dramaFeedsMap.put("", arrayList);
        cache_feedInfoMap = new HashMap();
        cache_feedInfoMap.put("", new stDramaFeed());
    }

    public stGetSimpleRecommendDramaRsp() {
        this.dramas = null;
        this.dramaFeedsMap = null;
        this.feedInfoMap = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dramas = (ArrayList) jceInputStream.read((JceInputStream) cache_dramas, 0, false);
        this.dramaFeedsMap = (Map) jceInputStream.read((JceInputStream) cache_dramaFeedsMap, 1, false);
        this.feedInfoMap = (Map) jceInputStream.read((JceInputStream) cache_feedInfoMap, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stDrama> arrayList = this.dramas;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<String, ArrayList<String>> map = this.dramaFeedsMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<String, stDramaFeed> map2 = this.feedInfoMap;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
    }

    public stGetSimpleRecommendDramaRsp(ArrayList<stDrama> arrayList, Map<String, ArrayList<String>> map, Map<String, stDramaFeed> map2) {
        this.dramas = arrayList;
        this.dramaFeedsMap = map;
        this.feedInfoMap = map2;
    }
}
