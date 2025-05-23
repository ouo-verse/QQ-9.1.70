package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_item_get_rsp extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static MaterialItem cache_stItem = new MaterialItem();
    public int iCode;
    public Map<String, String> mapExtInfo;
    public MaterialItem stItem;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public material_item_get_rsp() {
        this.iCode = 0;
        this.stItem = null;
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, true);
        this.stItem = (MaterialItem) jceInputStream.read((JceStruct) cache_stItem, 1, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        MaterialItem materialItem = this.stItem;
        if (materialItem != null) {
            jceOutputStream.write((JceStruct) materialItem, 1);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public material_item_get_rsp(int i3, MaterialItem materialItem, Map<String, String> map) {
        this.iCode = i3;
        this.stItem = materialItem;
        this.mapExtInfo = map;
    }
}
