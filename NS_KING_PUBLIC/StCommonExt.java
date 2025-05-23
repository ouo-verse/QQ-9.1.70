package NS_KING_PUBLIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class StCommonExt extends JceStruct {
    static Map<String, String> cache_mapInfo;
    public String attachInfo;
    public Map<String, String> mapInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_mapInfo = hashMap;
        hashMap.put("", "");
    }

    public StCommonExt() {
        this.mapInfo = null;
        this.attachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapInfo = (Map) jceInputStream.read((JceInputStream) cache_mapInfo, 0, false);
        this.attachInfo = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, String> map = this.mapInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public StCommonExt(Map<String, String> map, String str) {
        this.mapInfo = map;
        this.attachInfo = str;
    }
}
