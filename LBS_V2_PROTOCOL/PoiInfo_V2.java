package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PoiInfo_V2 extends JceStruct {
    static GPS_V2 cache_stGps;
    public int iDistance;
    public int iDistrictCode;
    public int iHotValue;
    public int iPoiNum;
    public int iPoiOrderType;
    public int iType;
    public GPS_V2 stGps;
    public String strAddress;
    public String strCity;
    public String strCountry;
    public String strDefaultName;
    public String strDianPingId;
    public String strDistrict;
    public String strName;
    public String strPhone;
    public String strPoiId;
    public String strProvince;
    public String strTypeName;

    public PoiInfo_V2() {
        this.strPoiId = "";
        this.strName = "";
        this.strTypeName = "";
        this.strAddress = "";
        this.strPhone = "";
        this.strCountry = "";
        this.strProvince = "";
        this.strCity = "";
        this.strDefaultName = "";
        this.strDistrict = "";
        this.strDianPingId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPoiId = jceInputStream.readString(0, true);
        this.strName = jceInputStream.readString(1, true);
        this.iType = jceInputStream.read(this.iType, 2, true);
        this.strTypeName = jceInputStream.readString(3, true);
        this.strAddress = jceInputStream.readString(4, true);
        this.iDistrictCode = jceInputStream.read(this.iDistrictCode, 5, true);
        if (cache_stGps == null) {
            cache_stGps = new GPS_V2();
        }
        this.stGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stGps, 6, true);
        this.iDistance = jceInputStream.read(this.iDistance, 7, true);
        this.iHotValue = jceInputStream.read(this.iHotValue, 8, false);
        this.strPhone = jceInputStream.readString(9, false);
        this.strCountry = jceInputStream.readString(10, false);
        this.strProvince = jceInputStream.readString(11, false);
        this.strCity = jceInputStream.readString(12, false);
        this.iPoiNum = jceInputStream.read(this.iPoiNum, 13, false);
        this.iPoiOrderType = jceInputStream.read(this.iPoiOrderType, 14, false);
        this.strDefaultName = jceInputStream.readString(15, false);
        this.strDistrict = jceInputStream.readString(16, false);
        this.strDianPingId = jceInputStream.readString(17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strPoiId, 0);
        jceOutputStream.write(this.strName, 1);
        jceOutputStream.write(this.iType, 2);
        jceOutputStream.write(this.strTypeName, 3);
        jceOutputStream.write(this.strAddress, 4);
        jceOutputStream.write(this.iDistrictCode, 5);
        jceOutputStream.write((JceStruct) this.stGps, 6);
        jceOutputStream.write(this.iDistance, 7);
        jceOutputStream.write(this.iHotValue, 8);
        String str = this.strPhone;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        String str2 = this.strCountry;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        String str3 = this.strProvince;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
        String str4 = this.strCity;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        jceOutputStream.write(this.iPoiNum, 13);
        jceOutputStream.write(this.iPoiOrderType, 14);
        String str5 = this.strDefaultName;
        if (str5 != null) {
            jceOutputStream.write(str5, 15);
        }
        String str6 = this.strDistrict;
        if (str6 != null) {
            jceOutputStream.write(str6, 16);
        }
        String str7 = this.strDianPingId;
        if (str7 != null) {
            jceOutputStream.write(str7, 17);
        }
    }

    public PoiInfo_V2(String str, String str2, int i3, String str3, String str4, int i16, GPS_V2 gps_v2, int i17, int i18, String str5, String str6, String str7, String str8, int i19, int i26, String str9, String str10, String str11) {
        this.strPoiId = str;
        this.strName = str2;
        this.iType = i3;
        this.strTypeName = str3;
        this.strAddress = str4;
        this.iDistrictCode = i16;
        this.stGps = gps_v2;
        this.iDistance = i17;
        this.iHotValue = i18;
        this.strPhone = str5;
        this.strCountry = str6;
        this.strProvince = str7;
        this.strCity = str8;
        this.iPoiNum = i19;
        this.iPoiOrderType = i26;
        this.strDefaultName = str9;
        this.strDistrict = str10;
        this.strDianPingId = str11;
    }
}
