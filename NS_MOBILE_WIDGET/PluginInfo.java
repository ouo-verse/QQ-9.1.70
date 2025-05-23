package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PluginInfo extends JceStruct {
    static Map<String, String> cache_extinfo;
    public Map<String, String> extinfo;
    public String iconurl;

    /* renamed from: id, reason: collision with root package name */
    public long f25061id;
    public String name;

    static {
        HashMap hashMap = new HashMap();
        cache_extinfo = hashMap;
        hashMap.put("", "");
    }

    public PluginInfo() {
        this.name = "";
        this.iconurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25061id = jceInputStream.read(this.f25061id, 0, false);
        this.name = jceInputStream.readString(1, false);
        this.iconurl = jceInputStream.readString(2, false);
        this.extinfo = (Map) jceInputStream.read((JceInputStream) cache_extinfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25061id, 0);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.iconurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        Map<String, String> map = this.extinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public PluginInfo(long j3, String str, String str2, Map<String, String> map) {
        this.f25061id = j3;
        this.name = str;
        this.iconurl = str2;
        this.extinfo = map;
    }
}
