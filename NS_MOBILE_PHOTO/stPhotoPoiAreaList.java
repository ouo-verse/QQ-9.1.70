package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stPhotoPoiAreaList extends JceStruct implements Cloneable {
    static stPhotoPoiArea cache_album_poi;
    static ArrayList<stPhotoPoiArea> cache_poi_areas;
    public stPhotoPoiArea album_poi;
    public String end_description;
    public ArrayList<stPhotoPoiArea> poi_areas;
    public String start_description;
    public long start_shoot_time;

    public stPhotoPoiAreaList() {
        this.start_description = "";
        this.end_description = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_album_poi == null) {
            cache_album_poi = new stPhotoPoiArea();
        }
        this.album_poi = (stPhotoPoiArea) jceInputStream.read((JceStruct) cache_album_poi, 0, true);
        this.start_description = jceInputStream.readString(1, true);
        this.end_description = jceInputStream.readString(2, true);
        if (cache_poi_areas == null) {
            cache_poi_areas = new ArrayList<>();
            cache_poi_areas.add(new stPhotoPoiArea());
        }
        this.poi_areas = (ArrayList) jceInputStream.read((JceInputStream) cache_poi_areas, 3, true);
        this.start_shoot_time = jceInputStream.read(this.start_shoot_time, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.album_poi, 0);
        jceOutputStream.write(this.start_description, 1);
        jceOutputStream.write(this.end_description, 2);
        jceOutputStream.write((Collection) this.poi_areas, 3);
        jceOutputStream.write(this.start_shoot_time, 4);
    }

    public stPhotoPoiAreaList(stPhotoPoiArea stphotopoiarea, String str, String str2, ArrayList<stPhotoPoiArea> arrayList, long j3) {
        this.album_poi = stphotopoiarea;
        this.start_description = str;
        this.end_description = str2;
        this.poi_areas = arrayList;
        this.start_shoot_time = j3;
    }
}
