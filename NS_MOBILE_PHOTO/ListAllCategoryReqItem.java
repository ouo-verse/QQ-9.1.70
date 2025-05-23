package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ListAllCategoryReqItem extends JceStruct {
    static CategoryPoiMap cache_poi_map_req = new CategoryPoiMap();
    public String page_str;
    public CategoryPoiMap poi_map_req;

    public ListAllCategoryReqItem() {
        this.page_str = "";
        this.poi_map_req = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.page_str = jceInputStream.readString(0, false);
        this.poi_map_req = (CategoryPoiMap) jceInputStream.read((JceStruct) cache_poi_map_req, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.page_str;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        CategoryPoiMap categoryPoiMap = this.poi_map_req;
        if (categoryPoiMap != null) {
            jceOutputStream.write((JceStruct) categoryPoiMap, 1);
        }
    }

    public ListAllCategoryReqItem(String str, CategoryPoiMap categoryPoiMap) {
        this.page_str = str;
        this.poi_map_req = categoryPoiMap;
    }
}
