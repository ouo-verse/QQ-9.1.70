package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stPoi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPhotoPoiArea extends JceStruct {
    static stPoi cache_poi_info = new stPoi();
    public String description;
    public long end_shoot_time;
    public long is_userconfirmed;
    public long photo_num;
    public stPoi poi_info;
    public long poi_photo_num;
    public String scenery_name;
    public long start_shoot_time;

    public stPhotoPoiArea() {
        this.description = "";
        this.scenery_name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photo_num = jceInputStream.read(this.photo_num, 0, true);
        this.poi_photo_num = jceInputStream.read(this.poi_photo_num, 1, true);
        this.start_shoot_time = jceInputStream.read(this.start_shoot_time, 2, true);
        this.end_shoot_time = jceInputStream.read(this.end_shoot_time, 3, true);
        this.poi_info = (stPoi) jceInputStream.read((JceStruct) cache_poi_info, 4, true);
        this.description = jceInputStream.readString(5, true);
        this.scenery_name = jceInputStream.readString(6, true);
        this.is_userconfirmed = jceInputStream.read(this.is_userconfirmed, 7, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.photo_num, 0);
        jceOutputStream.write(this.poi_photo_num, 1);
        jceOutputStream.write(this.start_shoot_time, 2);
        jceOutputStream.write(this.end_shoot_time, 3);
        jceOutputStream.write((JceStruct) this.poi_info, 4);
        jceOutputStream.write(this.description, 5);
        jceOutputStream.write(this.scenery_name, 6);
        jceOutputStream.write(this.is_userconfirmed, 7);
    }

    public stPhotoPoiArea(long j3, long j16, long j17, long j18, stPoi stpoi, String str, String str2, long j19) {
        this.photo_num = j3;
        this.poi_photo_num = j16;
        this.start_shoot_time = j17;
        this.end_shoot_time = j18;
        this.poi_info = stpoi;
        this.description = str;
        this.scenery_name = str2;
        this.is_userconfirmed = j19;
    }
}
