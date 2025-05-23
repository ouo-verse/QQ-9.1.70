package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaGeoInfo extends JceStruct {
    public float altitude;
    public String city;
    public String country;
    public int distance;
    public String district;
    public float latitude;
    public float longitude;
    public String name;
    public String polyGeoID;
    public String province;

    public stMetaGeoInfo() {
        this.country = "";
        this.province = "";
        this.city = "";
        this.latitude = 9.0E8f;
        this.longitude = 9.0E8f;
        this.altitude = -1.0E7f;
        this.district = "";
        this.name = "";
        this.distance = 0;
        this.polyGeoID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.country = jceInputStream.readString(0, false);
        this.province = jceInputStream.readString(1, false);
        this.city = jceInputStream.readString(2, false);
        this.latitude = jceInputStream.read(this.latitude, 3, false);
        this.longitude = jceInputStream.read(this.longitude, 4, false);
        this.altitude = jceInputStream.read(this.altitude, 5, false);
        this.district = jceInputStream.readString(6, false);
        this.name = jceInputStream.readString(7, false);
        this.distance = jceInputStream.read(this.distance, 8, false);
        this.polyGeoID = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.country;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.province;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.city;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.latitude, 3);
        jceOutputStream.write(this.longitude, 4);
        jceOutputStream.write(this.altitude, 5);
        String str4 = this.district;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.name;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.distance, 8);
        String str6 = this.polyGeoID;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
    }

    public stMetaGeoInfo(String str, String str2, String str3, float f16, float f17, float f18, String str4, String str5, int i3, String str6) {
        this.country = str;
        this.province = str2;
        this.city = str3;
        this.latitude = f16;
        this.longitude = f17;
        this.altitude = f18;
        this.district = str4;
        this.name = str5;
        this.distance = i3;
        this.polyGeoID = str6;
    }
}
