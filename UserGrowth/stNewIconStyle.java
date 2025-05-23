package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNewIconStyle extends JceStruct {
    static Map<String, String> cache_exp;
    public Map<String, String> exp;
    public String h5_url;
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    public int f25122id;
    public String img_url;
    public String schema_url;
    public int tag_type;
    public String title;

    static {
        HashMap hashMap = new HashMap();
        cache_exp = hashMap;
        hashMap.put("", "");
    }

    public stNewIconStyle() {
        this.title = "";
        this.tag_type = 0;
        this.iconUrl = "";
        this.img_url = "";
        this.h5_url = "";
        this.schema_url = "";
        this.f25122id = 0;
        this.exp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.tag_type = jceInputStream.read(this.tag_type, 1, false);
        this.iconUrl = jceInputStream.readString(2, false);
        this.img_url = jceInputStream.readString(3, false);
        this.h5_url = jceInputStream.readString(4, false);
        this.schema_url = jceInputStream.readString(5, false);
        this.f25122id = jceInputStream.read(this.f25122id, 6, false);
        this.exp = (Map) jceInputStream.read((JceInputStream) cache_exp, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.tag_type, 1);
        String str2 = this.iconUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.img_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.h5_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.schema_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.f25122id, 6);
        Map<String, String> map = this.exp;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
    }

    public stNewIconStyle(String str, int i3, String str2, String str3, String str4, String str5, int i16, Map<String, String> map) {
        this.title = str;
        this.tag_type = i3;
        this.iconUrl = str2;
        this.img_url = str3;
        this.h5_url = str4;
        this.schema_url = str5;
        this.f25122id = i16;
        this.exp = map;
    }
}
