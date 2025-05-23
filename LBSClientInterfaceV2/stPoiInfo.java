package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPoiInfo extends JceStruct {
    static stGPS cache_stGps;
    public int iDistance;
    public int iDistrictCode;
    public int iHotValue;
    public int iType;
    public int sorttype;
    public stGPS stGps;
    public String strAddress;
    public String strCity;
    public String strCountry;
    public String strName;
    public String strPhone;
    public String strPoiId;
    public String strProvince;
    public String strTypeName;

    public stPoiInfo() {
        this.strPoiId = "";
        this.strName = "";
        this.iType = 0;
        this.strTypeName = "";
        this.strAddress = "";
        this.iDistrictCode = 0;
        this.stGps = null;
        this.iDistance = 0;
        this.iHotValue = 0;
        this.strPhone = "";
        this.strCountry = "";
        this.strProvince = "";
        this.strCity = "";
        this.sorttype = 1;
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
            cache_stGps = new stGPS();
        }
        this.stGps = (stGPS) jceInputStream.read((JceStruct) cache_stGps, 6, true);
        this.iDistance = jceInputStream.read(this.iDistance, 7, true);
        this.iHotValue = jceInputStream.read(this.iHotValue, 8, false);
        this.strPhone = jceInputStream.readString(9, false);
        this.strCountry = jceInputStream.readString(10, false);
        this.strProvince = jceInputStream.readString(11, false);
        this.strCity = jceInputStream.readString(12, false);
        this.sorttype = jceInputStream.read(this.sorttype, 13, false);
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
        jceOutputStream.write(this.sorttype, 13);
    }

    public stPoiInfo(String str, String str2, int i3, String str3, String str4, int i16, stGPS stgps, int i17, int i18, String str5, String str6, String str7, String str8, int i19) {
        this.strPoiId = str;
        this.strName = str2;
        this.iType = i3;
        this.strTypeName = str3;
        this.strAddress = str4;
        this.iDistrictCode = i16;
        this.stGps = stgps;
        this.iDistance = i17;
        this.iHotValue = i18;
        this.strPhone = str5;
        this.strCountry = str6;
        this.strProvince = str7;
        this.strCity = str8;
        this.sorttype = i19;
    }
}
