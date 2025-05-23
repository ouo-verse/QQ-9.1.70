package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operat_data extends JceStruct {
    static Map<String, String> cache_mapExt;
    public int cmd;
    public String desc;
    public Map<String, String> mapExt;

    public operat_data() {
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.read(this.cmd, 0, false);
        this.desc = jceInputStream.readString(1, false);
        if (cache_mapExt == null) {
            HashMap hashMap = new HashMap();
            cache_mapExt = hashMap;
            hashMap.put("", "");
        }
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmd, 0);
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public operat_data(int i3, String str, Map<String, String> map) {
        this.cmd = i3;
        this.desc = str;
        this.mapExt = map;
    }
}
