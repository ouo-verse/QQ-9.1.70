package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_lbs extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static s_gps cache_gps = new s_gps();
    public Map<String, String> extendinfo;
    public s_gps gps;
    public String icon_token;
    public String location;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public cell_lbs() {
        this.gps = null;
        this.location = "";
        this.extendinfo = null;
        this.icon_token = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.gps = (s_gps) jceInputStream.read((JceStruct) cache_gps, 0, false);
        this.location = jceInputStream.readString(1, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 2, false);
        this.icon_token = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_gps s_gpsVar = this.gps;
        if (s_gpsVar != null) {
            jceOutputStream.write((JceStruct) s_gpsVar, 0);
        }
        String str = this.location;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        String str2 = this.icon_token;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public cell_lbs(s_gps s_gpsVar, String str, Map<String, String> map, String str2) {
        this.gps = s_gpsVar;
        this.location = str;
        this.extendinfo = map;
        this.icon_token = str2;
    }
}
