package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RspGetPositionAndPoiApi extends JceStruct {
    static GPS cache_stUsrLoc;
    static ArrayList<PoiInfo> cache_vPoiList;
    public int iDistrictCode;
    public int iRange;
    public int iTotalNum;
    public GPS stUsrLoc;
    public String strCity;
    public String strDistrict;
    public String strPremises;
    public String strProvince;
    public String strRoad;
    public String strTown;
    public ArrayList<PoiInfo> vPoiList;

    public RspGetPositionAndPoiApi() {
        this.stUsrLoc = null;
        this.iRange = -1;
        this.strProvince = "";
        this.strCity = "";
        this.strDistrict = "";
        this.strTown = "";
        this.strRoad = "";
        this.strPremises = "";
        this.iDistrictCode = 0;
        this.iTotalNum = 0;
        this.vPoiList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stUsrLoc == null) {
            cache_stUsrLoc = new GPS();
        }
        this.stUsrLoc = (GPS) jceInputStream.read((JceStruct) cache_stUsrLoc, 0, true);
        this.iRange = jceInputStream.read(this.iRange, 1, true);
        this.strProvince = jceInputStream.readString(2, true);
        this.strCity = jceInputStream.readString(3, true);
        this.strDistrict = jceInputStream.readString(4, true);
        this.strTown = jceInputStream.readString(5, true);
        this.strRoad = jceInputStream.readString(6, true);
        this.strPremises = jceInputStream.readString(7, true);
        this.iDistrictCode = jceInputStream.read(this.iDistrictCode, 8, true);
        this.iTotalNum = jceInputStream.read(this.iTotalNum, 9, true);
        if (cache_vPoiList == null) {
            cache_vPoiList = new ArrayList<>();
            cache_vPoiList.add(new PoiInfo());
        }
        this.vPoiList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPoiList, 10, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stUsrLoc, 0);
        jceOutputStream.write(this.iRange, 1);
        jceOutputStream.write(this.strProvince, 2);
        jceOutputStream.write(this.strCity, 3);
        jceOutputStream.write(this.strDistrict, 4);
        jceOutputStream.write(this.strTown, 5);
        jceOutputStream.write(this.strRoad, 6);
        jceOutputStream.write(this.strPremises, 7);
        jceOutputStream.write(this.iDistrictCode, 8);
        jceOutputStream.write(this.iTotalNum, 9);
        jceOutputStream.write((Collection) this.vPoiList, 10);
    }

    public RspGetPositionAndPoiApi(GPS gps, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i16, int i17, ArrayList<PoiInfo> arrayList) {
        this.stUsrLoc = gps;
        this.iRange = i3;
        this.strProvince = str;
        this.strCity = str2;
        this.strDistrict = str3;
        this.strTown = str4;
        this.strRoad = str5;
        this.strPremises = str6;
        this.iDistrictCode = i16;
        this.iTotalNum = i17;
        this.vPoiList = arrayList;
    }
}
