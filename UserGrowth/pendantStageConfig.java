package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class pendantStageConfig extends JceStruct {
    static Map<String, String> cache_exp;
    public int duration;
    public Map<String, String> exp;
    public String h5url;
    public String icon_url;
    public String scheme_url;
    public String text_button;
    public String text_description;
    public String text_title;
    public String url;

    static {
        HashMap hashMap = new HashMap();
        cache_exp = hashMap;
        hashMap.put("", "");
    }

    public pendantStageConfig() {
        this.text_title = "";
        this.text_description = "";
        this.text_button = "";
        this.icon_url = "";
        this.url = "";
        this.duration = 0;
        this.h5url = "";
        this.scheme_url = "";
        this.exp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.text_title = jceInputStream.readString(0, false);
        this.text_description = jceInputStream.readString(1, false);
        this.text_button = jceInputStream.readString(2, false);
        this.icon_url = jceInputStream.readString(3, false);
        this.url = jceInputStream.readString(4, false);
        this.duration = jceInputStream.read(this.duration, 5, false);
        this.h5url = jceInputStream.readString(6, false);
        this.scheme_url = jceInputStream.readString(7, false);
        this.exp = (Map) jceInputStream.read((JceInputStream) cache_exp, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.text_title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.text_description;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.text_button;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.icon_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.url;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        jceOutputStream.write(this.duration, 5);
        String str6 = this.h5url;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.scheme_url;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        Map<String, String> map = this.exp;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
    }

    public pendantStageConfig(String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, Map<String, String> map) {
        this.text_title = str;
        this.text_description = str2;
        this.text_button = str3;
        this.icon_url = str4;
        this.url = str5;
        this.duration = i3;
        this.h5url = str6;
        this.scheme_url = str7;
        this.exp = map;
    }
}
