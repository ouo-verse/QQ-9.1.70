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
public final class mobile_facade_pre_get_req extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static ArrayList<Long> cache_vecReqUin;
    public long lLastFetchTimestamp;
    public Map<String, String> mapExtInfo;
    public ArrayList<Long> vecReqUin;

    public mobile_facade_pre_get_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecReqUin == null) {
            cache_vecReqUin = new ArrayList<>();
            cache_vecReqUin.add(0L);
        }
        this.vecReqUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vecReqUin, 0, false);
        this.lLastFetchTimestamp = jceInputStream.read(this.lLastFetchTimestamp, 1, false);
        if (cache_mapExtInfo == null) {
            HashMap hashMap = new HashMap();
            cache_mapExtInfo = hashMap;
            hashMap.put("", "");
        }
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<Long> arrayList = this.vecReqUin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.lLastFetchTimestamp, 1);
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public mobile_facade_pre_get_req(ArrayList<Long> arrayList, long j3, Map<String, String> map) {
        this.vecReqUin = arrayList;
        this.lLastFetchTimestamp = j3;
        this.mapExtInfo = map;
    }
}
