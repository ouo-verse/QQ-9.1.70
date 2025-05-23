package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_colorful_tail extends JceStruct {
    static s_tail_color cache_bright_style = new s_tail_color();
    static s_tail_color cache_dark_style = new s_tail_color();
    static Map<String, String> cache_report_param;
    public String action_url;
    public s_tail_color bright_style;
    public s_tail_color dark_style;
    public String desc;
    public String name;
    public Map<String, String> report_param;
    public int type;
    public String used_count;

    static {
        HashMap hashMap = new HashMap();
        cache_report_param = hashMap;
        hashMap.put("", "");
    }

    public cell_colorful_tail() {
        this.action_url = "";
        this.name = "";
        this.desc = "";
        this.bright_style = null;
        this.dark_style = null;
        this.type = 0;
        this.report_param = null;
        this.used_count = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.action_url = jceInputStream.readString(0, false);
        this.name = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
        this.bright_style = (s_tail_color) jceInputStream.read((JceStruct) cache_bright_style, 3, false);
        this.dark_style = (s_tail_color) jceInputStream.read((JceStruct) cache_dark_style, 4, false);
        this.type = jceInputStream.read(this.type, 5, false);
        this.report_param = (Map) jceInputStream.read((JceInputStream) cache_report_param, 6, false);
        this.used_count = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.action_url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.name;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        s_tail_color s_tail_colorVar = this.bright_style;
        if (s_tail_colorVar != null) {
            jceOutputStream.write((JceStruct) s_tail_colorVar, 3);
        }
        s_tail_color s_tail_colorVar2 = this.dark_style;
        if (s_tail_colorVar2 != null) {
            jceOutputStream.write((JceStruct) s_tail_colorVar2, 4);
        }
        jceOutputStream.write(this.type, 5);
        Map<String, String> map = this.report_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        String str4 = this.used_count;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
    }

    public cell_colorful_tail(String str, String str2, String str3, s_tail_color s_tail_colorVar, s_tail_color s_tail_colorVar2, int i3, Map<String, String> map, String str4) {
        this.action_url = str;
        this.name = str2;
        this.desc = str3;
        this.bright_style = s_tail_colorVar;
        this.dark_style = s_tail_colorVar2;
        this.type = i3;
        this.report_param = map;
        this.used_count = str4;
    }
}
