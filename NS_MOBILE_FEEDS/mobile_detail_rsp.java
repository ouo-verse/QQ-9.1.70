package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_detail_rsp extends JceStruct {
    static single_detail cache_detail_data = new single_detail();
    static Map<String, String> cache_extend_info;
    static s_life_moment cache_life_moment_info;
    static single_feed cache_ugc_detail_adv;
    public String attach_info;
    public String attach_info_essence;
    public single_detail detail_data;
    public Map<String, String> extend_info;
    public int hasmore;
    public int hasmore_essence;
    public s_life_moment life_moment_info;
    public int refresh_type;
    public int type_info;
    public single_feed ugc_detail_adv;
    public int wait_time;

    static {
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
        cache_life_moment_info = new s_life_moment();
        cache_ugc_detail_adv = new single_feed();
    }

    public mobile_detail_rsp() {
        this.detail_data = null;
        this.hasmore = 0;
        this.attach_info = "";
        this.type_info = 0;
        this.wait_time = 0;
        this.extend_info = null;
        this.hasmore_essence = 0;
        this.attach_info_essence = "";
        this.life_moment_info = null;
        this.ugc_detail_adv = null;
        this.refresh_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.detail_data = (single_detail) jceInputStream.read((JceStruct) cache_detail_data, 0, false);
        this.hasmore = jceInputStream.read(this.hasmore, 1, false);
        this.attach_info = jceInputStream.readString(2, false);
        this.type_info = jceInputStream.read(this.type_info, 3, false);
        this.wait_time = jceInputStream.read(this.wait_time, 4, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 5, false);
        this.hasmore_essence = jceInputStream.read(this.hasmore_essence, 6, false);
        this.attach_info_essence = jceInputStream.readString(7, false);
        this.life_moment_info = (s_life_moment) jceInputStream.read((JceStruct) cache_life_moment_info, 8, false);
        this.ugc_detail_adv = (single_feed) jceInputStream.read((JceStruct) cache_ugc_detail_adv, 9, false);
        this.refresh_type = jceInputStream.read(this.refresh_type, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        single_detail single_detailVar = this.detail_data;
        if (single_detailVar != null) {
            jceOutputStream.write((JceStruct) single_detailVar, 0);
        }
        jceOutputStream.write(this.hasmore, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.type_info, 3);
        jceOutputStream.write(this.wait_time, 4);
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        jceOutputStream.write(this.hasmore_essence, 6);
        String str2 = this.attach_info_essence;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        s_life_moment s_life_momentVar = this.life_moment_info;
        if (s_life_momentVar != null) {
            jceOutputStream.write((JceStruct) s_life_momentVar, 8);
        }
        single_feed single_feedVar = this.ugc_detail_adv;
        if (single_feedVar != null) {
            jceOutputStream.write((JceStruct) single_feedVar, 9);
        }
        jceOutputStream.write(this.refresh_type, 10);
    }

    public mobile_detail_rsp(single_detail single_detailVar, int i3, String str, int i16, int i17, Map<String, String> map, int i18, String str2, s_life_moment s_life_momentVar, single_feed single_feedVar, int i19) {
        this.detail_data = single_detailVar;
        this.hasmore = i3;
        this.attach_info = str;
        this.type_info = i16;
        this.wait_time = i17;
        this.extend_info = map;
        this.hasmore_essence = i18;
        this.attach_info_essence = str2;
        this.life_moment_info = s_life_momentVar;
        this.ugc_detail_adv = single_feedVar;
        this.refresh_type = i19;
    }
}
