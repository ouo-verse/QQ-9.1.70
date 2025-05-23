package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_cate_get_rsp extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static MaterialCate cache_stCate = new MaterialCate();
    public int iCode;
    public int iHasMore;
    public Map<String, String> mapExtInfo;
    public MaterialCate stCate;
    public String strAttachInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public material_cate_get_rsp() {
        this.iCode = 0;
        this.stCate = null;
        this.strAttachInfo = "";
        this.iHasMore = 0;
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, true);
        this.stCate = (MaterialCate) jceInputStream.read((JceStruct) cache_stCate, 1, false);
        this.strAttachInfo = jceInputStream.readString(2, false);
        this.iHasMore = jceInputStream.read(this.iHasMore, 3, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        MaterialCate materialCate = this.stCate;
        if (materialCate != null) {
            jceOutputStream.write((JceStruct) materialCate, 1);
        }
        String str = this.strAttachInfo;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iHasMore, 3);
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public material_cate_get_rsp(int i3, MaterialCate materialCate, String str, int i16, Map<String, String> map) {
        this.iCode = i3;
        this.stCate = materialCate;
        this.strAttachInfo = str;
        this.iHasMore = i16;
        this.mapExtInfo = map;
    }
}
