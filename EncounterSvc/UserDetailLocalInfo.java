package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserDetailLocalInfo extends JceStruct {
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
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strProvince = jceInputStream.readString(0, true);
        this.strCity = jceInputStream.readString(1, true);
        this.strDistrict = jceInputStream.readString(2, true);
        this.strTown = jceInputStream.readString(3, true);
        this.strRoad = jceInputStream.readString(4, true);
        this.strPremises = jceInputStream.readString(5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strProvince, 0);
        jceOutputStream.write(this.strCity, 1);
        jceOutputStream.write(this.strDistrict, 2);
        jceOutputStream.write(this.strTown, 3);
        jceOutputStream.write(this.strRoad, 4);
        jceOutputStream.write(this.strPremises, 5);
    }

    public UserDetailLocalInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.strProvince = str;
        this.strCity = str2;
        this.strDistrict = str3;
        this.strTown = str4;
        this.strRoad = str5;
        this.strPremises = str6;
    }
}
