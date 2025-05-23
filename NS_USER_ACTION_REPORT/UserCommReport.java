package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserCommReport extends JceStruct {
    static Map<String, String> cache_user_tag;
    public String app_version;
    public String city_code;
    public String client_type;
    public String guid;
    public String ip_addr;
    public double latitude;
    public double longitude;
    public String market;
    public String mobile_type;
    public String network_type;
    public String operators;
    public String os_version;
    public String platform;
    public String qimei;
    public String qua;
    public long to_uin;
    public long uin;
    public Map<String, String> user_tag;

    static {
        HashMap hashMap = new HashMap();
        cache_user_tag = hashMap;
        hashMap.put("", "");
    }

    public UserCommReport() {
        this.uin = 0L;
        this.to_uin = 0L;
        this.guid = "";
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.city_code = "";
        this.platform = "";
        this.client_type = "";
        this.app_version = "";
        this.market = "";
        this.qua = "";
        this.os_version = "";
        this.mobile_type = "";
        this.ip_addr = "";
        this.network_type = "";
        this.operators = "";
        this.qimei = "";
        this.user_tag = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.to_uin = jceInputStream.read(this.to_uin, 1, false);
        this.guid = jceInputStream.readString(2, false);
        this.longitude = jceInputStream.read(this.longitude, 3, false);
        this.latitude = jceInputStream.read(this.latitude, 4, false);
        this.city_code = jceInputStream.readString(5, false);
        this.platform = jceInputStream.readString(6, true);
        this.client_type = jceInputStream.readString(7, true);
        this.app_version = jceInputStream.readString(8, false);
        this.market = jceInputStream.readString(9, false);
        this.qua = jceInputStream.readString(10, false);
        this.os_version = jceInputStream.readString(11, false);
        this.mobile_type = jceInputStream.readString(12, false);
        this.ip_addr = jceInputStream.readString(13, false);
        this.network_type = jceInputStream.readString(14, true);
        this.operators = jceInputStream.readString(15, false);
        this.qimei = jceInputStream.readString(16, false);
        this.user_tag = (Map) jceInputStream.read((JceInputStream) cache_user_tag, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.to_uin, 1);
        String str = this.guid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.longitude, 3);
        jceOutputStream.write(this.latitude, 4);
        String str2 = this.city_code;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.platform, 6);
        jceOutputStream.write(this.client_type, 7);
        String str3 = this.app_version;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.market;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.qua;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        String str6 = this.os_version;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        String str7 = this.mobile_type;
        if (str7 != null) {
            jceOutputStream.write(str7, 12);
        }
        String str8 = this.ip_addr;
        if (str8 != null) {
            jceOutputStream.write(str8, 13);
        }
        jceOutputStream.write(this.network_type, 14);
        String str9 = this.operators;
        if (str9 != null) {
            jceOutputStream.write(str9, 15);
        }
        String str10 = this.qimei;
        if (str10 != null) {
            jceOutputStream.write(str10, 16);
        }
        Map<String, String> map = this.user_tag;
        if (map != null) {
            jceOutputStream.write((Map) map, 17);
        }
    }

    public UserCommReport(long j3, long j16, String str, double d16, double d17, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map<String, String> map) {
        this.uin = j3;
        this.to_uin = j16;
        this.guid = str;
        this.longitude = d16;
        this.latitude = d17;
        this.city_code = str2;
        this.platform = str3;
        this.client_type = str4;
        this.app_version = str5;
        this.market = str6;
        this.qua = str7;
        this.os_version = str8;
        this.mobile_type = str9;
        this.ip_addr = str10;
        this.network_type = str11;
        this.operators = str12;
        this.qimei = str13;
        this.user_tag = map;
    }
}
