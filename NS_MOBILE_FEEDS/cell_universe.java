package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_universe extends JceStruct {
    static Map<Integer, byte[]> cache_BgReqData = new HashMap();
    static Map<String, String> cache_extendInfo;
    public Map<Integer, byte[]> BgReqData;
    public Map<String, String> extendInfo;
    public int iUniverseType;
    public String strTraceId;
    public String strUIJson;

    static {
        cache_BgReqData.put(0, new byte[]{0});
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
    }

    public cell_universe() {
        this.strTraceId = "";
        this.strUIJson = "";
        this.BgReqData = null;
        this.iUniverseType = 0;
        this.extendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strTraceId = jceInputStream.readString(0, false);
        this.strUIJson = jceInputStream.readString(1, false);
        this.BgReqData = (Map) jceInputStream.read((JceInputStream) cache_BgReqData, 2, false);
        this.iUniverseType = jceInputStream.read(this.iUniverseType, 3, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strTraceId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strUIJson;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        Map<Integer, byte[]> map = this.BgReqData;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        jceOutputStream.write(this.iUniverseType, 3);
        Map<String, String> map2 = this.extendInfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 4);
        }
    }

    public cell_universe(String str, String str2, Map<Integer, byte[]> map, int i3, Map<String, String> map2) {
        this.strTraceId = str;
        this.strUIJson = str2;
        this.BgReqData = map;
        this.iUniverseType = i3;
        this.extendInfo = map2;
    }
}
