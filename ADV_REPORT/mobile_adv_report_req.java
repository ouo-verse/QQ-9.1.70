package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_adv_report_req extends JceStruct {
    static s_anti_cheat cache_anti_cheat;
    static Map<Integer, String> cache_busi_param;
    static Map<Integer, String> cache_cookie = new HashMap();
    public int action_expectation;
    public int action_type;
    public s_anti_cheat anti_cheat;
    public String antispam_info;
    public Map<Integer, String> busi_param;
    public long client_time;
    public Map<Integer, String> cookie;
    public long cost_time;
    public long error_code;
    public long feed_index;
    public String feeds_click_attachinfo;
    public boolean is_filter;
    public boolean is_impression;
    public boolean is_installed;
    public boolean is_repeated;
    public boolean is_report_gdt;
    public boolean is_trace;
    public int report_posi;
    public long stay_time;
    public String video_playinfo;
    public int write_return_code;

    static {
        cache_cookie.put(0, "");
        cache_anti_cheat = new s_anti_cheat();
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
    }

    public mobile_adv_report_req() {
        this.cookie = null;
        this.report_posi = 0;
        this.write_return_code = 0;
        this.client_time = 0L;
        this.feed_index = 0L;
        this.anti_cheat = null;
        this.action_type = 0;
        this.action_expectation = 0;
        this.is_impression = true;
        this.is_installed = false;
        this.antispam_info = "";
        this.video_playinfo = "";
        this.stay_time = 0L;
        this.is_repeated = false;
        this.is_trace = false;
        this.cost_time = 0L;
        this.is_filter = false;
        this.feeds_click_attachinfo = "";
        this.busi_param = null;
        this.error_code = 0L;
        this.is_report_gdt = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cookie = (Map) jceInputStream.read((JceInputStream) cache_cookie, 0, false);
        this.report_posi = jceInputStream.read(this.report_posi, 1, false);
        this.write_return_code = jceInputStream.read(this.write_return_code, 2, false);
        this.client_time = jceInputStream.read(this.client_time, 3, false);
        this.feed_index = jceInputStream.read(this.feed_index, 4, false);
        this.anti_cheat = (s_anti_cheat) jceInputStream.read((JceStruct) cache_anti_cheat, 5, false);
        this.action_type = jceInputStream.read(this.action_type, 6, false);
        this.action_expectation = jceInputStream.read(this.action_expectation, 7, false);
        this.is_impression = jceInputStream.read(this.is_impression, 8, false);
        this.is_installed = jceInputStream.read(this.is_installed, 9, false);
        this.antispam_info = jceInputStream.readString(10, false);
        this.video_playinfo = jceInputStream.readString(11, false);
        this.stay_time = jceInputStream.read(this.stay_time, 12, false);
        this.is_repeated = jceInputStream.read(this.is_repeated, 13, false);
        this.is_trace = jceInputStream.read(this.is_trace, 14, false);
        this.cost_time = jceInputStream.read(this.cost_time, 15, false);
        this.is_filter = jceInputStream.read(this.is_filter, 16, false);
        this.feeds_click_attachinfo = jceInputStream.readString(17, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 18, false);
        this.error_code = jceInputStream.read(this.error_code, 19, false);
        this.is_report_gdt = jceInputStream.read(this.is_report_gdt, 20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, String> map = this.cookie;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        jceOutputStream.write(this.report_posi, 1);
        jceOutputStream.write(this.write_return_code, 2);
        jceOutputStream.write(this.client_time, 3);
        jceOutputStream.write(this.feed_index, 4);
        s_anti_cheat s_anti_cheatVar = this.anti_cheat;
        if (s_anti_cheatVar != null) {
            jceOutputStream.write((JceStruct) s_anti_cheatVar, 5);
        }
        jceOutputStream.write(this.action_type, 6);
        jceOutputStream.write(this.action_expectation, 7);
        jceOutputStream.write(this.is_impression, 8);
        jceOutputStream.write(this.is_installed, 9);
        String str = this.antispam_info;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        String str2 = this.video_playinfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        jceOutputStream.write(this.stay_time, 12);
        jceOutputStream.write(this.is_repeated, 13);
        jceOutputStream.write(this.is_trace, 14);
        jceOutputStream.write(this.cost_time, 15);
        jceOutputStream.write(this.is_filter, 16);
        String str3 = this.feeds_click_attachinfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 17);
        }
        Map<Integer, String> map2 = this.busi_param;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 18);
        }
        jceOutputStream.write(this.error_code, 19);
        jceOutputStream.write(this.is_report_gdt, 20);
    }

    public mobile_adv_report_req(Map<Integer, String> map, int i3, int i16, long j3, long j16, s_anti_cheat s_anti_cheatVar, int i17, int i18, boolean z16, boolean z17, String str, String str2, long j17, boolean z18, boolean z19, long j18, boolean z26, String str3, Map<Integer, String> map2, long j19, boolean z27) {
        this.cookie = map;
        this.report_posi = i3;
        this.write_return_code = i16;
        this.client_time = j3;
        this.feed_index = j16;
        this.anti_cheat = s_anti_cheatVar;
        this.action_type = i17;
        this.action_expectation = i18;
        this.is_impression = z16;
        this.is_installed = z17;
        this.antispam_info = str;
        this.video_playinfo = str2;
        this.stay_time = j17;
        this.is_repeated = z18;
        this.is_trace = z19;
        this.cost_time = j18;
        this.is_filter = z26;
        this.feeds_click_attachinfo = str3;
        this.busi_param = map2;
        this.error_code = j19;
        this.is_report_gdt = z27;
    }
}
