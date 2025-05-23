package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_shoot_info extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static s_gps cache_shoot_gps = new s_gps();
    public Map<String, String> extendinfo;
    public String icon_token;
    public s_gps shoot_gps;
    public String shoot_location;
    public long shoot_time;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public s_shoot_info() {
        this.shoot_gps = null;
        this.shoot_location = "";
        this.shoot_time = 0L;
        this.extendinfo = null;
        this.icon_token = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shoot_gps = (s_gps) jceInputStream.read((JceStruct) cache_shoot_gps, 0, false);
        this.shoot_location = jceInputStream.readString(1, false);
        this.shoot_time = jceInputStream.read(this.shoot_time, 2, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 3, false);
        this.icon_token = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_gps s_gpsVar = this.shoot_gps;
        if (s_gpsVar != null) {
            jceOutputStream.write((JceStruct) s_gpsVar, 0);
        }
        String str = this.shoot_location;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.shoot_time, 2);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        String str2 = this.icon_token;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public s_shoot_info(s_gps s_gpsVar, String str, long j3, Map<String, String> map, String str2) {
        this.shoot_gps = s_gpsVar;
        this.shoot_location = str;
        this.shoot_time = j3;
        this.extendinfo = map;
        this.icon_token = str2;
    }
}
