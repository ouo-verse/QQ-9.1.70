package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserDetailLocalInfo extends JceStruct {
    static byte[] cache_SOSOUrl;
    static byte[] cache_cityId;
    public byte[] SOSOUrl;
    public byte[] cityId;
    public String strCity;
    public String strDistrict;
    public String strPremises;
    public String strProvince;
    public String strRoad;
    public String strTown;

    public UserDetailLocalInfo() {
        this.strProvince = "";
        this.strCity = "";
        this.strDistrict = "";
        this.strTown = "";
        this.strRoad = "";
        this.strPremises = "";
        this.SOSOUrl = null;
        this.cityId = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strProvince = jceInputStream.readString(0, true);
        this.strCity = jceInputStream.readString(1, true);
        this.strDistrict = jceInputStream.readString(2, true);
        this.strTown = jceInputStream.readString(3, true);
        this.strRoad = jceInputStream.readString(4, true);
        this.strPremises = jceInputStream.readString(5, true);
        if (cache_SOSOUrl == null) {
            cache_SOSOUrl = r2;
            byte[] bArr = {0};
        }
        this.SOSOUrl = jceInputStream.read(cache_SOSOUrl, 6, false);
        if (cache_cityId == null) {
            cache_cityId = r1;
            byte[] bArr2 = {0};
        }
        this.cityId = jceInputStream.read(cache_cityId, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strProvince, 0);
        jceOutputStream.write(this.strCity, 1);
        jceOutputStream.write(this.strDistrict, 2);
        jceOutputStream.write(this.strTown, 3);
        jceOutputStream.write(this.strRoad, 4);
        jceOutputStream.write(this.strPremises, 5);
        byte[] bArr = this.SOSOUrl;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        byte[] bArr2 = this.cityId;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 7);
        }
    }

    public UserDetailLocalInfo(String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr, byte[] bArr2) {
        this.strProvince = str;
        this.strCity = str2;
        this.strDistrict = str3;
        this.strTown = str4;
        this.strRoad = str5;
        this.strPremises = str6;
        this.SOSOUrl = bArr;
        this.cityId = bArr2;
    }
}
