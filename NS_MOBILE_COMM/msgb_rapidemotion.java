package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class msgb_rapidemotion extends JceStruct {
    static Map<String, String> cache_extend_info;
    public int emotion_height_b;
    public int emotion_height_s;
    public int emotion_id;
    public String emotion_text;
    public int emotion_width_b;
    public int emotion_width_s;
    public Map<String, String> extend_info;
    public String rapid_emotion_url_b;
    public String rapid_emotion_url_s;

    static {
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public msgb_rapidemotion() {
        this.rapid_emotion_url_s = "";
        this.rapid_emotion_url_b = "";
        this.emotion_text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.emotion_id = jceInputStream.read(this.emotion_id, 0, false);
        this.rapid_emotion_url_s = jceInputStream.readString(1, false);
        this.rapid_emotion_url_b = jceInputStream.readString(2, false);
        this.emotion_width_s = jceInputStream.read(this.emotion_width_s, 3, false);
        this.emotion_height_s = jceInputStream.read(this.emotion_height_s, 4, false);
        this.emotion_width_b = jceInputStream.read(this.emotion_width_b, 5, false);
        this.emotion_height_b = jceInputStream.read(this.emotion_height_b, 6, false);
        this.emotion_text = jceInputStream.readString(7, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.emotion_id, 0);
        String str = this.rapid_emotion_url_s;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.rapid_emotion_url_b;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.emotion_width_s, 3);
        jceOutputStream.write(this.emotion_height_s, 4);
        jceOutputStream.write(this.emotion_width_b, 5);
        jceOutputStream.write(this.emotion_height_b, 6);
        String str3 = this.emotion_text;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
    }

    public msgb_rapidemotion(int i3, String str, String str2, int i16, int i17, int i18, int i19, String str3, Map<String, String> map) {
        this.emotion_id = i3;
        this.rapid_emotion_url_s = str;
        this.rapid_emotion_url_b = str2;
        this.emotion_width_s = i16;
        this.emotion_height_s = i17;
        this.emotion_width_b = i18;
        this.emotion_height_b = i19;
        this.emotion_text = str3;
        this.extend_info = map;
    }
}
