package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_msgb_festival extends JceStruct {
    static Map<String, String> cache_extendinfo;
    public String content;
    public Map<String, String> extendinfo;
    public boolean is_festival;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public s_msgb_festival() {
        this.content = "";
        this.is_festival = true;
        this.extendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.content = jceInputStream.readString(0, false);
        this.is_festival = jceInputStream.read(this.is_festival, 1, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.is_festival, 1);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public s_msgb_festival(String str, boolean z16, Map<String, String> map) {
        this.content = str;
        this.is_festival = z16;
        this.extendinfo = map;
    }
}
