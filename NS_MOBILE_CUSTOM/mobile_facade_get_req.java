package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_facade_get_req extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    public long lUin;
    public Map<String, String> mapExtInfo;
    public String strId;

    public mobile_facade_get_req() {
        this.strId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.strId = jceInputStream.readString(1, false);
        if (cache_mapExtInfo == null) {
            HashMap hashMap = new HashMap();
            cache_mapExtInfo = hashMap;
            hashMap.put("", "");
        }
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        String str = this.strId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public mobile_facade_get_req(long j3, String str, Map<String, String> map) {
        this.lUin = j3;
        this.strId = str;
        this.mapExtInfo = map;
    }
}
