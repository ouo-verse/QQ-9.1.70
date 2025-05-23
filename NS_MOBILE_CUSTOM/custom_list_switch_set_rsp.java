package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class custom_list_switch_set_rsp extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    public int iCode;
    public Map<String, String> mapExtInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public custom_list_switch_set_rsp() {
        this.iCode = 0;
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public custom_list_switch_set_rsp(int i3, Map<String, String> map) {
        this.iCode = i3;
        this.mapExtInfo = map;
    }
}
