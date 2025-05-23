package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LbsInfo extends JceStruct {
    static Map<String, String> cache_extend_info;
    public Map<String, String> extend_info;
    public int i_poi_num;
    public int i_poi_order_type;
    public int i_poi_type;
    public String lbs_frd;
    public int lbs_id;
    public String lbs_idnm;
    public String lbs_nm;
    public int lbs_type;
    public String lbs_x;
    public String lbs_y;
    public String s_lbs_id;

    static {
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public LbsInfo() {
        this.lbs_x = "";
        this.lbs_y = "";
        this.lbs_nm = "";
        this.lbs_idnm = "";
        this.lbs_frd = "";
        this.s_lbs_id = "";
        this.extend_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lbs_x = jceInputStream.readString(0, false);
        this.lbs_y = jceInputStream.readString(1, false);
        this.lbs_nm = jceInputStream.readString(2, false);
        this.lbs_id = jceInputStream.read(this.lbs_id, 3, false);
        this.lbs_idnm = jceInputStream.readString(4, false);
        this.lbs_frd = jceInputStream.readString(5, false);
        this.lbs_type = jceInputStream.read(this.lbs_type, 6, false);
        this.s_lbs_id = jceInputStream.readString(7, false);
        this.i_poi_num = jceInputStream.read(this.i_poi_num, 8, false);
        this.i_poi_type = jceInputStream.read(this.i_poi_type, 9, false);
        this.i_poi_order_type = jceInputStream.read(this.i_poi_order_type, 10, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.lbs_x;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.lbs_y;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.lbs_nm;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.lbs_id, 3);
        String str4 = this.lbs_idnm;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.lbs_frd;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.lbs_type, 6);
        String str6 = this.s_lbs_id;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        jceOutputStream.write(this.i_poi_num, 8);
        jceOutputStream.write(this.i_poi_type, 9);
        jceOutputStream.write(this.i_poi_order_type, 10);
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
    }

    public LbsInfo(String str, String str2, String str3, int i3, String str4, String str5, int i16, String str6, int i17, int i18, int i19, Map<String, String> map) {
        this.lbs_x = str;
        this.lbs_y = str2;
        this.lbs_nm = str3;
        this.lbs_id = i3;
        this.lbs_idnm = str4;
        this.lbs_frd = str5;
        this.lbs_type = i16;
        this.s_lbs_id = str6;
        this.i_poi_num = i17;
        this.i_poi_type = i18;
        this.i_poi_order_type = i19;
        this.extend_info = map;
    }
}
