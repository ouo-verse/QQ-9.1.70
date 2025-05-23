package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQValueInfoItem extends JceStruct {
    static Map<String, String> cache_qqvalue_ext_info;
    public int level;
    public String material_id;
    public int on_off;
    public Map<String, String> qqvalue_ext_info;
    public int score;
    public int trend;
    public String url;

    static {
        HashMap hashMap = new HashMap();
        cache_qqvalue_ext_info = hashMap;
        hashMap.put("", "");
    }

    public QQValueInfoItem() {
        this.score = 0;
        this.level = 0;
        this.trend = 0;
        this.url = "";
        this.on_off = 0;
        this.material_id = "";
        this.qqvalue_ext_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.score = jceInputStream.read(this.score, 0, false);
        this.level = jceInputStream.read(this.level, 1, false);
        this.trend = jceInputStream.read(this.trend, 2, false);
        this.url = jceInputStream.readString(4, false);
        this.on_off = jceInputStream.read(this.on_off, 5, false);
        this.material_id = jceInputStream.readString(6, false);
        this.qqvalue_ext_info = (Map) jceInputStream.read((JceInputStream) cache_qqvalue_ext_info, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.score, 0);
        jceOutputStream.write(this.level, 1);
        jceOutputStream.write(this.trend, 2);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.on_off, 5);
        String str2 = this.material_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        Map<String, String> map = this.qqvalue_ext_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
    }

    public QQValueInfoItem(int i3, int i16, int i17, String str, int i18, String str2, Map<String, String> map) {
        this.score = i3;
        this.level = i16;
        this.trend = i17;
        this.url = str;
        this.on_off = i18;
        this.material_id = str2;
        this.qqvalue_ext_info = map;
    }
}
