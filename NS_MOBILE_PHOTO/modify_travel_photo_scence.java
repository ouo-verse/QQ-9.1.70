package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class modify_travel_photo_scence extends JceStruct {
    static int cache_opetype;
    static stPhotoPoiArea cache_poi = new stPhotoPoiArea();
    public int opetype;
    public stPhotoPoiArea poi;
    public long poi_area_start_time;

    public modify_travel_photo_scence() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.opetype = jceInputStream.read(this.opetype, 0, true);
        this.poi = (stPhotoPoiArea) jceInputStream.read((JceStruct) cache_poi, 1, true);
        this.poi_area_start_time = jceInputStream.read(this.poi_area_start_time, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.opetype, 0);
        jceOutputStream.write((JceStruct) this.poi, 1);
        jceOutputStream.write(this.poi_area_start_time, 2);
    }

    public modify_travel_photo_scence(int i3, stPhotoPoiArea stphotopoiarea, long j3) {
        this.opetype = i3;
        this.poi = stphotopoiarea;
        this.poi_area_start_time = j3;
    }
}
