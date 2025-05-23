package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetNewestFeedRspInner extends JceStruct {
    static Map<String, String> cache_mapItemInfo;
    static stRspComm cache_rspComm = new stRspComm();
    public Map<String, String> mapItemInfo;
    public stRspComm rspComm;

    static {
        HashMap hashMap = new HashMap();
        cache_mapItemInfo = hashMap;
        hashMap.put("", "");
    }

    public stGetNewestFeedRspInner() {
        this.rspComm = null;
        this.mapItemInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rspComm = (stRspComm) jceInputStream.read((JceStruct) cache_rspComm, 0, false);
        this.mapItemInfo = (Map) jceInputStream.read((JceInputStream) cache_mapItemInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stRspComm strspcomm = this.rspComm;
        if (strspcomm != null) {
            jceOutputStream.write((JceStruct) strspcomm, 0);
        }
        Map<String, String> map = this.mapItemInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public stGetNewestFeedRspInner(stRspComm strspcomm, Map<String, String> map) {
        this.rspComm = strspcomm;
        this.mapItemInfo = map;
    }
}
