package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_upper_banner extends JceStruct {
    static Map<String, String> cache_extendInfo;
    static s_picdata cache_picdata = new s_picdata();
    public int actionType;
    public String action_url;
    public int banner_type;
    public String button_title;
    public Map<String, String> extendInfo;
    public s_picdata picdata;
    public String summary;
    public String title;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
    }

    public cell_upper_banner() {
        this.picdata = null;
        this.title = "";
        this.summary = "";
        this.button_title = "";
        this.actionType = 0;
        this.action_url = "";
        this.banner_type = 0;
        this.extendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picdata = (s_picdata) jceInputStream.read((JceStruct) cache_picdata, 0, false);
        this.title = jceInputStream.readString(1, false);
        this.summary = jceInputStream.readString(2, false);
        this.button_title = jceInputStream.readString(3, false);
        this.actionType = jceInputStream.read(this.actionType, 4, false);
        this.action_url = jceInputStream.readString(5, false);
        this.banner_type = jceInputStream.read(this.banner_type, 6, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_picdata s_picdataVar = this.picdata;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 0);
        }
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.button_title;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.actionType, 4);
        String str4 = this.action_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.banner_type, 6);
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
    }

    public cell_upper_banner(s_picdata s_picdataVar, String str, String str2, String str3, int i3, String str4, int i16, Map<String, String> map) {
        this.picdata = s_picdataVar;
        this.title = str;
        this.summary = str2;
        this.button_title = str3;
        this.actionType = i3;
        this.action_url = str4;
        this.banner_type = i16;
        this.extendInfo = map;
    }
}
