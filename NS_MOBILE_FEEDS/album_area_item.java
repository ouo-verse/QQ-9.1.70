package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class album_area_item extends JceStruct {
    static stPoi cache_poi_info = new stPoi();
    public String description;
    public long end_shoot_time;
    public long is_userconfirmed;
    public long photo_num;
    public stPoi poi_info;
    public long poi_photo_num;
    public String scenery_name;
    public long start_shoot_time;

    public album_area_item() {
        this.photo_num = 0L;
        this.poi_photo_num = 0L;
        this.start_shoot_time = 0L;
        this.end_shoot_time = 0L;
        this.poi_info = null;
        this.description = "";
        this.scenery_name = "";
        this.is_userconfirmed = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photo_num = jceInputStream.read(this.photo_num, 0, false);
        this.poi_photo_num = jceInputStream.read(this.poi_photo_num, 1, false);
        this.start_shoot_time = jceInputStream.read(this.start_shoot_time, 2, false);
        this.end_shoot_time = jceInputStream.read(this.end_shoot_time, 3, false);
        this.poi_info = (stPoi) jceInputStream.read((JceStruct) cache_poi_info, 4, false);
        this.description = jceInputStream.readString(5, false);
        this.scenery_name = jceInputStream.readString(6, false);
        this.is_userconfirmed = jceInputStream.read(this.is_userconfirmed, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.photo_num, 0);
        jceOutputStream.write(this.poi_photo_num, 1);
        jceOutputStream.write(this.start_shoot_time, 2);
        jceOutputStream.write(this.end_shoot_time, 3);
        stPoi stpoi = this.poi_info;
        if (stpoi != null) {
            jceOutputStream.write((JceStruct) stpoi, 4);
        }
        String str = this.description;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.scenery_name;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.is_userconfirmed, 7);
    }

    public album_area_item(long j3, long j16, long j17, long j18, stPoi stpoi, String str, String str2, long j19) {
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
