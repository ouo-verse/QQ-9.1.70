package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stPopWindowsConfig extends JceStruct {
    static Map<String, String> cache_exp;
    public stAnnexation annexation;
    public String bg_img_url;
    public Map<String, String> exp;
    public String h5url;
    public int index;
    public stPopWindowsButton jp_button;
    public String remark;
    public int scene;
    public String schema_url;
    public String text;
    public String title;
    public String trace_id;
    public int type;
    public int windowsid;
    static stPopWindowsButton cache_jp_button = new stPopWindowsButton();
    static stAnnexation cache_annexation = new stAnnexation();

    static {
        HashMap hashMap = new HashMap();
        cache_exp = hashMap;
        hashMap.put("", "");
    }

    public stPopWindowsConfig() {
        this.windowsid = 0;
        this.index = 0;
        this.type = 0;
        this.title = "";
        this.text = "";
        this.remark = "";
        this.bg_img_url = "";
        this.jp_button = null;
        this.annexation = null;
        this.scene = 0;
        this.h5url = "";
        this.schema_url = "";
        this.exp = null;
        this.trace_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.windowsid = jceInputStream.read(this.windowsid, 0, false);
        this.index = jceInputStream.read(this.index, 1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        this.title = jceInputStream.readString(3, false);
        this.text = jceInputStream.readString(4, false);
        this.remark = jceInputStream.readString(5, false);
        this.bg_img_url = jceInputStream.readString(6, false);
        this.jp_button = (stPopWindowsButton) jceInputStream.read((JceStruct) cache_jp_button, 7, false);
        this.annexation = (stAnnexation) jceInputStream.read((JceStruct) cache_annexation, 8, false);
        this.scene = jceInputStream.read(this.scene, 9, false);
        this.h5url = jceInputStream.readString(11, false);
        this.schema_url = jceInputStream.readString(12, false);
        this.exp = (Map) jceInputStream.read((JceInputStream) cache_exp, 13, false);
        this.trace_id = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.windowsid, 0);
        jceOutputStream.write(this.index, 1);
        jceOutputStream.write(this.type, 2);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.text;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.remark;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.bg_img_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        stPopWindowsButton stpopwindowsbutton = this.jp_button;
        if (stpopwindowsbutton != null) {
            jceOutputStream.write((JceStruct) stpopwindowsbutton, 7);
        }
        stAnnexation stannexation = this.annexation;
        if (stannexation != null) {
            jceOutputStream.write((JceStruct) stannexation, 8);
        }
        jceOutputStream.write(this.scene, 9);
        String str5 = this.h5url;
        if (str5 != null) {
            jceOutputStream.write(str5, 11);
        }
        String str6 = this.schema_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        Map<String, String> map = this.exp;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
        String str7 = this.trace_id;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
    }

    public stPopWindowsConfig(int i3, int i16, int i17, String str, String str2, String str3, String str4, stPopWindowsButton stpopwindowsbutton, stAnnexation stannexation, int i18, String str5, String str6, Map<String, String> map, String str7) {
        this.windowsid = i3;
        this.index = i16;
        this.type = i17;
        this.title = str;
        this.text = str2;
        this.remark = str3;
        this.bg_img_url = str4;
        this.jp_button = stpopwindowsbutton;
        this.annexation = stannexation;
        this.scene = i18;
        this.h5url = str5;
        this.schema_url = str6;
        this.exp = map;
        this.trace_id = str7;
    }
}
