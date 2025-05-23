package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_theme extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static Map<Integer, s_picurl> cache_photourl = new HashMap();
    public Map<String, String> extendinfo;
    public boolean is_deepcolor;
    public boolean is_optpalette;
    public String major_forecolor;
    public String minor_forecolor;
    public Map<Integer, s_picurl> photourl;

    static {
        cache_photourl.put(0, new s_picurl());
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public cell_theme() {
        this.major_forecolor = "";
        this.minor_forecolor = "";
        this.is_deepcolor = true;
        this.is_optpalette = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.major_forecolor = jceInputStream.readString(0, false);
        this.minor_forecolor = jceInputStream.readString(1, false);
        this.is_deepcolor = jceInputStream.read(this.is_deepcolor, 2, false);
        this.photourl = (Map) jceInputStream.read((JceInputStream) cache_photourl, 3, false);
        this.is_optpalette = jceInputStream.read(this.is_optpalette, 4, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.major_forecolor;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.minor_forecolor;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.is_deepcolor, 2);
        Map<Integer, s_picurl> map = this.photourl;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.is_optpalette, 4);
        Map<String, String> map2 = this.extendinfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 5);
        }
    }

    public cell_theme(String str, String str2, boolean z16, Map<Integer, s_picurl> map, boolean z17, Map<String, String> map2) {
        this.major_forecolor = str;
        this.minor_forecolor = str2;
        this.is_deepcolor = z16;
        this.photourl = map;
        this.is_optpalette = z17;
        this.extendinfo = map2;
    }
}
