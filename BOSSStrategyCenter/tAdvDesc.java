package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tAdvDesc extends JceStruct {
    static Map<String, String> cache_adv_config_info;
    static Map<String, String> cache_adv_user_feed;
    public Map<String, String> adv_config_info;
    public Map<String, String> adv_user_feed;
    public long expose_time;
    public String name;
    public int parent_id;
    public String pattern_data;
    public int pattern_id;
    public String pattern_logic;
    public String res_data;
    public String res_preprocess;
    public String res_traceinfo;
    public int resource_id;
    public int ret;
    public String s_cmd_info;
    public String s_ret_msg;
    public int task_id;
    public int type;

    public tAdvDesc() {
        this.name = "";
        this.res_data = "";
        this.res_preprocess = "";
        this.pattern_logic = "";
        this.pattern_data = "";
        this.res_traceinfo = "";
        this.s_ret_msg = "";
        this.s_cmd_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.task_id = jceInputStream.read(this.task_id, 0, true);
        this.type = jceInputStream.read(this.type, 1, true);
        this.name = jceInputStream.readString(2, true);
        this.resource_id = jceInputStream.read(this.resource_id, 3, true);
        this.res_data = jceInputStream.readString(4, false);
        this.res_preprocess = jceInputStream.readString(5, false);
        this.pattern_id = jceInputStream.read(this.pattern_id, 6, false);
        this.pattern_logic = jceInputStream.readString(7, false);
        this.pattern_data = jceInputStream.readString(8, false);
        this.parent_id = jceInputStream.read(this.parent_id, 9, false);
        this.res_traceinfo = jceInputStream.readString(10, false);
        this.ret = jceInputStream.read(this.ret, 11, false);
        this.s_ret_msg = jceInputStream.readString(12, false);
        this.s_cmd_info = jceInputStream.readString(13, false);
        this.expose_time = jceInputStream.read(this.expose_time, 14, false);
        if (cache_adv_config_info == null) {
            HashMap hashMap = new HashMap();
            cache_adv_config_info = hashMap;
            hashMap.put("", "");
        }
        this.adv_config_info = (Map) jceInputStream.read((JceInputStream) cache_adv_config_info, 15, false);
        if (cache_adv_user_feed == null) {
            HashMap hashMap2 = new HashMap();
            cache_adv_user_feed = hashMap2;
            hashMap2.put("", "");
        }
        this.adv_user_feed = (Map) jceInputStream.read((JceInputStream) cache_adv_user_feed, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.task_id, 0);
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.name, 2);
        jceOutputStream.write(this.resource_id, 3);
        String str = this.res_data;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.res_preprocess;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.pattern_id, 6);
        String str3 = this.pattern_logic;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.pattern_data;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        jceOutputStream.write(this.parent_id, 9);
        String str5 = this.res_traceinfo;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        jceOutputStream.write(this.ret, 11);
        String str6 = this.s_ret_msg;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        String str7 = this.s_cmd_info;
        if (str7 != null) {
            jceOutputStream.write(str7, 13);
        }
        jceOutputStream.write(this.expose_time, 14);
        Map<String, String> map = this.adv_config_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 15);
        }
        Map<String, String> map2 = this.adv_user_feed;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 16);
        }
    }

    public tAdvDesc(int i3, int i16, String str, int i17, String str2, String str3, int i18, String str4, String str5, int i19, String str6, int i26, String str7, String str8, long j3, Map<String, String> map, Map<String, String> map2) {
        this.task_id = i3;
        this.type = i16;
        this.name = str;
        this.resource_id = i17;
        this.res_data = str2;
        this.res_preprocess = str3;
        this.pattern_id = i18;
        this.pattern_logic = str4;
        this.pattern_data = str5;
        this.parent_id = i19;
        this.res_traceinfo = str6;
        this.ret = i26;
        this.s_ret_msg = str7;
        this.s_cmd_info = str8;
        this.expose_time = j3;
        this.adv_config_info = map;
        this.adv_user_feed = map2;
    }
}
