package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_facade_pre_get_rsp extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static Map<Long, Facade> cache_mapUinFacade;
    static ArrayList<Long> cache_vecUinNoVisitRight;
    public Map<String, String> mapExtInfo;
    public Map<Long, Facade> mapUinFacade;
    public ArrayList<Long> vecUinNoVisitRight;

    public mobile_facade_pre_get_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_mapUinFacade == null) {
            cache_mapUinFacade = new HashMap();
            cache_mapUinFacade.put(0L, new Facade());
        }
        this.mapUinFacade = (Map) jceInputStream.read((JceInputStream) cache_mapUinFacade, 0, false);
        if (cache_vecUinNoVisitRight == null) {
            cache_vecUinNoVisitRight = new ArrayList<>();
            cache_vecUinNoVisitRight.add(0L);
        }
        this.vecUinNoVisitRight = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUinNoVisitRight, 1, false);
        if (cache_mapExtInfo == null) {
            HashMap hashMap = new HashMap();
            cache_mapExtInfo = hashMap;
            hashMap.put("", "");
        }
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, Facade> map = this.mapUinFacade;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        ArrayList<Long> arrayList = this.vecUinNoVisitRight;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map2 = this.mapExtInfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
    }

    public mobile_facade_pre_get_rsp(Map<Long, Facade> map, ArrayList<Long> arrayList, Map<String, String> map2) {
        this.mapUinFacade = map;
        this.vecUinNoVisitRight = arrayList;
        this.mapExtInfo = map2;
    }
}
