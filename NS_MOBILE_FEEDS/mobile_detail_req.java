package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_detail_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_mapExt;
    public int appid;
    public String attach_info;
    public String attach_info_essence;
    public Map<Integer, String> busi_param;
    public String cellid;
    public String clientkey;
    public int count;
    public String likekey;
    public Map<String, String> mapExt;
    public int refresh_type;
    public String subid;
    public long uin;

    static {
        cache_busi_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public mobile_detail_req() {
        this.uin = 0L;
        this.appid = 0;
        this.likekey = "";
        this.cellid = "";
        this.subid = "";
        this.busi_param = null;
        this.refresh_type = 0;
        this.count = 0;
        this.attach_info = "";
        this.clientkey = "";
        this.mapExt = null;
        this.attach_info_essence = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.likekey = jceInputStream.readString(2, false);
        this.cellid = jceInputStream.readString(3, false);
        this.subid = jceInputStream.readString(4, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 5, false);
        this.refresh_type = jceInputStream.read(this.refresh_type, 6, false);
        this.count = jceInputStream.read(this.count, 7, false);
        this.attach_info = jceInputStream.readString(8, false);
        this.clientkey = jceInputStream.readString(9, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 10, false);
        this.attach_info_essence = jceInputStream.readString(11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        String str = this.likekey;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.cellid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.subid;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        jceOutputStream.write(this.refresh_type, 6);
        jceOutputStream.write(this.count, 7);
        String str4 = this.attach_info;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.clientkey;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        Map<String, String> map2 = this.mapExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 10);
        }
        String str6 = this.attach_info_essence;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
    }

    public mobile_detail_req(long j3, int i3, String str, String str2, String str3, Map<Integer, String> map, int i16, int i17, String str4, String str5, Map<String, String> map2, String str6) {
        this.uin = j3;
        this.appid = i3;
        this.likekey = str;
        this.cellid = str2;
        this.subid = str3;
        this.busi_param = map;
        this.refresh_type = i16;
        this.count = i17;
        this.attach_info = str4;
        this.clientkey = str5;
        this.mapExt = map2;
        this.attach_info_essence = str6;
    }
}
