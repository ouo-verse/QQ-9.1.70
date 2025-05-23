package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GeoInfo_V2 extends JceStruct {
    public int iDistrictCode;
    public int iRange;
    public String strCity;
    public String strCountry;
    public String strDefaultName;
    public String strDistrict;
    public String strProvince;
    public String strRoad;
    public String strTown;
    public String strVillage;

    public GeoInfo_V2() {
        this.iRange = -1;
        this.strCountry = "";
        this.strProvince = "";
        this.strCity = "";
        this.strDistrict = "";
        this.strTown = "";
        this.strVillage = "";
        this.strRoad = "";
        this.strDefaultName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iDistrictCode = jceInputStream.read(this.iDistrictCode, 0, true);
        this.iRange = jceInputStream.read(this.iRange, 1, true);
        this.strCountry = jceInputStream.readString(2, true);
        this.strProvince = jceInputStream.readString(3, true);
        this.strCity = jceInputStream.readString(4, true);
        this.strDistrict = jceInputStream.readString(5, true);
        this.strTown = jceInputStream.readString(6, true);
        this.strVillage = jceInputStream.readString(7, true);
        this.strRoad = jceInputStream.readString(8, true);
        this.strDefaultName = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iDistrictCode, 0);
        jceOutputStream.write(this.iRange, 1);
        jceOutputStream.write(this.strCountry, 2);
        jceOutputStream.write(this.strProvince, 3);
        jceOutputStream.write(this.strCity, 4);
        jceOutputStream.write(this.strDistrict, 5);
        jceOutputStream.write(this.strTown, 6);
        jceOutputStream.write(this.strVillage, 7);
        jceOutputStream.write(this.strRoad, 8);
        String str = this.strDefaultName;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
    }

    public GeoInfo_V2(int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.iDistrictCode = i3;
        this.iRange = i16;
        this.strCountry = str;
        this.strProvince = str2;
        this.strCity = str3;
        this.strDistrict = str4;
        this.strTown = str5;
        this.strVillage = str6;
        this.strRoad = str7;
        this.strDefaultName = str8;
    }
}
