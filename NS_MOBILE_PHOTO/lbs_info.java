package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class lbs_info extends JceStruct {
    public int category_id;
    public String city;
    public int city_id;
    public String continent;
    public String country;
    public String district;
    public int eType;
    public String geoDesc;
    public int iAlt;
    public int iLat;
    public int iLon;
    public int isInland;
    public String poiDesc;
    public String province;
    public String road;
    public String scenery;
    public int source;
    public String town;

    public lbs_info() {
        this.iLat = 0;
        this.iLon = 0;
        this.eType = 0;
        this.iAlt = 0;
        this.isInland = 0;
        this.continent = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.district = "";
        this.town = "";
        this.road = "";
        this.scenery = "";
        this.category_id = 0;
        this.city_id = 0;
        this.geoDesc = "";
        this.poiDesc = "";
        this.source = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iLat = jceInputStream.read(this.iLat, 0, true);
        this.iLon = jceInputStream.read(this.iLon, 1, true);
        this.eType = jceInputStream.read(this.eType, 2, true);
        this.iAlt = jceInputStream.read(this.iAlt, 3, false);
        this.isInland = jceInputStream.read(this.isInland, 4, false);
        this.continent = jceInputStream.readString(5, false);
        this.country = jceInputStream.readString(6, false);
        this.province = jceInputStream.readString(7, false);
        this.city = jceInputStream.readString(8, false);
        this.district = jceInputStream.readString(9, false);
        this.town = jceInputStream.readString(10, false);
        this.road = jceInputStream.readString(11, false);
        this.scenery = jceInputStream.readString(12, false);
        this.category_id = jceInputStream.read(this.category_id, 13, false);
        this.city_id = jceInputStream.read(this.city_id, 14, false);
        this.geoDesc = jceInputStream.readString(15, false);
        this.poiDesc = jceInputStream.readString(16, false);
        this.source = jceInputStream.read(this.source, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iLat, 0);
        jceOutputStream.write(this.iLon, 1);
        jceOutputStream.write(this.eType, 2);
        jceOutputStream.write(this.iAlt, 3);
        jceOutputStream.write(this.isInland, 4);
        String str = this.continent;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.country;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.province;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.city;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.district;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.town;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        String str7 = this.road;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
        String str8 = this.scenery;
        if (str8 != null) {
            jceOutputStream.write(str8, 12);
        }
        jceOutputStream.write(this.category_id, 13);
        jceOutputStream.write(this.city_id, 14);
        String str9 = this.geoDesc;
        if (str9 != null) {
            jceOutputStream.write(str9, 15);
        }
        String str10 = this.poiDesc;
        if (str10 != null) {
            jceOutputStream.write(str10, 16);
        }
        jceOutputStream.write(this.source, 17);
    }

    public lbs_info(int i3, int i16, int i17, int i18, int i19, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i26, int i27, String str9, String str10, int i28) {
        this.iLat = i3;
        this.iLon = i16;
        this.eType = i17;
        this.iAlt = i18;
        this.isInland = i19;
        this.continent = str;
        this.country = str2;
        this.province = str3;
        this.city = str4;
        this.district = str5;
        this.town = str6;
        this.road = str7;
        this.scenery = str8;
        this.category_id = i26;
        this.city_id = i27;
        this.geoDesc = str9;
        this.poiDesc = str10;
        this.source = i28;
    }
}
