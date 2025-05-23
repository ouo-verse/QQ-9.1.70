package NS_MOBILE_QBOSS_PROTO;

import BOSSStrategyCenter.tAdvDesc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileQbossAdvRsp extends JceStruct {
    static Map<Integer, ArrayList<tAdvDesc>> cache_mapAdv = new HashMap();
    static Map<Integer, Long> cache_map_next_query_ts;
    public int iRet;
    public Map<Integer, ArrayList<tAdvDesc>> mapAdv;
    public Map<Integer, Long> map_next_query_ts;
    public String sMsg;

    static {
        ArrayList<tAdvDesc> arrayList = new ArrayList<>();
        arrayList.add(new tAdvDesc());
        cache_mapAdv.put(0, arrayList);
        cache_map_next_query_ts = new HashMap();
        cache_map_next_query_ts.put(0, 0L);
    }

    public MobileQbossAdvRsp() {
        this.iRet = 0;
        this.sMsg = "";
        this.mapAdv = null;
        this.map_next_query_ts = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
        this.sMsg = jceInputStream.readString(1, true);
        this.mapAdv = (Map) jceInputStream.read((JceInputStream) cache_mapAdv, 2, true);
        this.map_next_query_ts = (Map) jceInputStream.read((JceInputStream) cache_map_next_query_ts, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        jceOutputStream.write(this.sMsg, 1);
        jceOutputStream.write((Map) this.mapAdv, 2);
        Map<Integer, Long> map = this.map_next_query_ts;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public MobileQbossAdvRsp(int i3, String str, Map<Integer, ArrayList<tAdvDesc>> map, Map<Integer, Long> map2) {
        this.iRet = i3;
        this.sMsg = str;
        this.mapAdv = map;
        this.map_next_query_ts = map2;
    }
}
