package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class GetBatchPoiReq_V2 extends JceStruct {
    static Map<String, String> cache_map_ext;
    static ReqCommon_V2 cache_stCommon = new ReqCommon_V2();
    static ArrayList<GPS_V2> cache_vecGpsInfo = new ArrayList<>();
    public Map<String, String> map_ext;
    public int opMask;
    public ReqCommon_V2 stCommon;
    public ArrayList<GPS_V2> vecGpsInfo;

    static {
        cache_vecGpsInfo.add(new GPS_V2());
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
    }

    public GetBatchPoiReq_V2() {
        this.stCommon = null;
        this.vecGpsInfo = null;
        this.opMask = 0;
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stCommon = (ReqCommon_V2) jceInputStream.read((JceStruct) cache_stCommon, 0, true);
        this.vecGpsInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGpsInfo, 1, false);
        this.opMask = jceInputStream.read(this.opMask, 2, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stCommon, 0);
        ArrayList<GPS_V2> arrayList = this.vecGpsInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.opMask, 2);
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public GetBatchPoiReq_V2(ReqCommon_V2 reqCommon_V2, ArrayList<GPS_V2> arrayList, int i3, Map<String, String> map) {
        this.stCommon = reqCommon_V2;
        this.vecGpsInfo = arrayList;
        this.opMask = i3;
        this.map_ext = map;
    }
}
