package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_button extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static Map<Integer, Integer> cache_stMapABTest = new HashMap();
    public int actiontype;
    public String actionurl;
    public int animation_duration;
    public String animation_url;
    public int appear_time;
    public String button_background_img;
    public String button_icon;
    public String button_img;
    public int duration_time;
    public Map<String, String> extendinfo;
    public Map<Integer, Integer> stMapABTest;
    public String text;

    static {
        cache_stMapABTest.put(0, 0);
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public s_button() {
        this.text = "";
        this.actiontype = 0;
        this.actionurl = "";
        this.button_img = "";
        this.button_background_img = "";
        this.button_icon = "";
        this.stMapABTest = null;
        this.appear_time = 0;
        this.duration_time = 0;
        this.animation_url = "";
        this.animation_duration = 0;
        this.extendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.text = jceInputStream.readString(0, false);
        this.actiontype = jceInputStream.read(this.actiontype, 1, false);
        this.actionurl = jceInputStream.readString(2, false);
        this.button_img = jceInputStream.readString(3, false);
        this.button_background_img = jceInputStream.readString(4, false);
        this.button_icon = jceInputStream.readString(5, false);
        this.stMapABTest = (Map) jceInputStream.read((JceInputStream) cache_stMapABTest, 6, false);
        this.appear_time = jceInputStream.read(this.appear_time, 7, false);
        this.duration_time = jceInputStream.read(this.duration_time, 8, false);
        this.animation_url = jceInputStream.readString(9, false);
        this.animation_duration = jceInputStream.read(this.animation_duration, 10, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.actiontype, 1);
        String str2 = this.actionurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.button_img;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.button_background_img;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.button_icon;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        Map<Integer, Integer> map = this.stMapABTest;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        jceOutputStream.write(this.appear_time, 7);
        jceOutputStream.write(this.duration_time, 8);
        String str6 = this.animation_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        jceOutputStream.write(this.animation_duration, 10);
        Map<String, String> map2 = this.extendinfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 11);
        }
    }

    public s_button(String str, int i3, String str2, String str3, String str4, String str5, Map<Integer, Integer> map, int i16, int i17, String str6, int i18, Map<String, String> map2) {
        this.text = str;
        this.actiontype = i3;
        this.actionurl = str2;
        this.button_img = str3;
        this.button_background_img = str4;
        this.button_icon = str5;
        this.stMapABTest = map;
        this.appear_time = i16;
        this.duration_time = i17;
        this.animation_url = str6;
        this.animation_duration = i18;
        this.extendinfo = map2;
    }
}
