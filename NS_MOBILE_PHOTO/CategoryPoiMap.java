package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CategoryPoiMap extends JceStruct {
    public String poi_map_key;

    public CategoryPoiMap() {
        this.poi_map_key = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.poi_map_key = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.poi_map_key;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public CategoryPoiMap(String str) {
        this.poi_map_key = str;
    }
}
