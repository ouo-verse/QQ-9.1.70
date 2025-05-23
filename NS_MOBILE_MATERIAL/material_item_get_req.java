package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_item_get_req extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    public int iAppid;
    public long lUin;
    public Map<String, String> mapExtInfo;
    public String strItemId;
    public String strTraceInfo;
    public long uiSettleTime;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public material_item_get_req() {
        this.lUin = 0L;
        this.iAppid = 0;
        this.strItemId = "";
        this.uiSettleTime = 0L;
        this.strTraceInfo = "";
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.iAppid = jceInputStream.read(this.iAppid, 1, false);
        this.strItemId = jceInputStream.readString(2, false);
        this.uiSettleTime = jceInputStream.read(this.uiSettleTime, 3, false);
        this.strTraceInfo = jceInputStream.readString(4, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iAppid, 1);
        String str = this.strItemId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.uiSettleTime, 3);
        String str2 = this.strTraceInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public material_item_get_req(long j3, int i3, String str, long j16, String str2, Map<String, String> map) {
        this.lUin = j3;
        this.iAppid = i3;
        this.strItemId = str;
        this.uiSettleTime = j16;
        this.strTraceInfo = str2;
        this.mapExtInfo = map;
    }
}
