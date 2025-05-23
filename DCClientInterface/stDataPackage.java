package DCClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stDataPackage extends JceStruct {
    static Map<String, String> cache_numData;
    static Map<String, String> cache_strData;
    public Map<String, String> numData;
    public Map<String, String> strData;

    public stDataPackage() {
        this.numData = null;
        this.strData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_numData == null) {
            HashMap hashMap = new HashMap();
            cache_numData = hashMap;
            hashMap.put("", "");
        }
        this.numData = (Map) jceInputStream.read((JceInputStream) cache_numData, 0, true);
        if (cache_strData == null) {
            HashMap hashMap2 = new HashMap();
            cache_strData = hashMap2;
            hashMap2.put("", "");
        }
        this.strData = (Map) jceInputStream.read((JceInputStream) cache_strData, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.numData, 0);
        jceOutputStream.write((Map) this.strData, 1);
    }

    public stDataPackage(Map<String, String> map, Map<String, String> map2) {
        this.numData = map;
        this.strData = map2;
    }
}
