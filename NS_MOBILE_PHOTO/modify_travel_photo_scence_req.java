package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class modify_travel_photo_scence_req extends JceStruct {
    static int cache_opetype;
    static Map<String, EditPhoto> cache_picid_time_list;
    static stPhotoPoiArea cache_poi = new stPhotoPoiArea();
    static ArrayList<modify_travel_photo_scence> cache_scence = new ArrayList<>();
    public String albumid;
    public int opetype;
    public Map<String, EditPhoto> picid_time_list;
    public stPhotoPoiArea poi;
    public long poi_area_start_time;
    public ArrayList<modify_travel_photo_scence> scence;

    static {
        cache_scence.add(new modify_travel_photo_scence());
        cache_picid_time_list = new HashMap();
        cache_picid_time_list.put("", new EditPhoto());
    }

    public modify_travel_photo_scence_req() {
        this.albumid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albumid = jceInputStream.readString(0, true);
        this.opetype = jceInputStream.read(this.opetype, 1, true);
        this.poi = (stPhotoPoiArea) jceInputStream.read((JceStruct) cache_poi, 2, true);
        this.poi_area_start_time = jceInputStream.read(this.poi_area_start_time, 3, false);
        this.scence = (ArrayList) jceInputStream.read((JceInputStream) cache_scence, 4, false);
        this.picid_time_list = (Map) jceInputStream.read((JceInputStream) cache_picid_time_list, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.albumid, 0);
        jceOutputStream.write(this.opetype, 1);
        jceOutputStream.write((JceStruct) this.poi, 2);
        jceOutputStream.write(this.poi_area_start_time, 3);
        ArrayList<modify_travel_photo_scence> arrayList = this.scence;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        Map<String, EditPhoto> map = this.picid_time_list;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public modify_travel_photo_scence_req(String str, int i3, stPhotoPoiArea stphotopoiarea, long j3, ArrayList<modify_travel_photo_scence> arrayList, Map<String, EditPhoto> map) {
        this.albumid = str;
        this.opetype = i3;
        this.poi = stphotopoiarea;
        this.poi_area_start_time = j3;
        this.scence = arrayList;
        this.picid_time_list = map;
    }
}
