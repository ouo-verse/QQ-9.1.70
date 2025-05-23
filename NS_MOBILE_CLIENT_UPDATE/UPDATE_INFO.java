package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class UPDATE_INFO extends JceStruct {
    static int cache_actype;
    static Map<String, String> cache_extra_info;
    static Map<Integer, String> cache_plugin_info;
    public int actype;
    public String app;
    public Map<String, String> extra_info;

    /* renamed from: id, reason: collision with root package name */
    public String f24971id;
    public String mainVersion;
    public String md5;
    public String name;
    public Map<Integer, String> plugin_info;
    public String ver;

    static {
        HashMap hashMap = new HashMap();
        cache_extra_info = hashMap;
        hashMap.put("", "");
        cache_plugin_info = new HashMap();
        cache_plugin_info.put(0, "");
        cache_actype = 0;
    }

    public UPDATE_INFO() {
        this.app = "";
        this.ver = "";
        this.name = "";
        this.extra_info = null;
        this.f24971id = "";
        this.mainVersion = "";
        this.md5 = "";
        this.plugin_info = null;
        this.actype = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.app = jceInputStream.readString(0, true);
        this.ver = jceInputStream.readString(1, true);
        this.name = jceInputStream.readString(2, false);
        this.extra_info = (Map) jceInputStream.read((JceInputStream) cache_extra_info, 3, false);
        this.f24971id = jceInputStream.readString(4, false);
        this.mainVersion = jceInputStream.readString(5, false);
        this.md5 = jceInputStream.readString(6, false);
        this.plugin_info = (Map) jceInputStream.read((JceInputStream) cache_plugin_info, 7, false);
        this.actype = jceInputStream.read(this.actype, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.app, 0);
        jceOutputStream.write(this.ver, 1);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<String, String> map = this.extra_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        String str2 = this.f24971id;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.mainVersion;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.md5;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        Map<Integer, String> map2 = this.plugin_info;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 7);
        }
        jceOutputStream.write(this.actype, 8);
    }

    public UPDATE_INFO(String str, String str2, String str3, Map<String, String> map, String str4, String str5, String str6, Map<Integer, String> map2, int i3) {
        this.app = str;
        this.ver = str2;
        this.name = str3;
        this.extra_info = map;
        this.f24971id = str4;
        this.mainVersion = str5;
        this.md5 = str6;
        this.plugin_info = map2;
        this.actype = i3;
    }
}
