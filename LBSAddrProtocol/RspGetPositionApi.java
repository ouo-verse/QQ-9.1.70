package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RspGetPositionApi extends JceStruct {
    static GPS cache_stUsrLoc;
    static ArrayList<Cell> cache_vCells;
    static ArrayList<Long> cache_vMacs;
    public int iDistrictCode;
    public int iRange;
    public GPS stUsrLoc;
    public String strCity;
    public String strDistrict;
    public String strPremises;
    public String strProvince;
    public String strRoad;
    public String strTown;
    public ArrayList<Cell> vCells;
    public ArrayList<Long> vMacs;

    public RspGetPositionApi() {
        this.stUsrLoc = null;
        this.iRange = -1;
        this.strProvince = "";
        this.strCity = "";
        this.strDistrict = "";
        this.strTown = "";
        this.strRoad = "";
        this.strPremises = "";
        this.iDistrictCode = 0;
        this.vMacs = null;
        this.vCells = null;
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
        if (cache_vMacs == null) {
            cache_vMacs = new ArrayList<>();
            cache_vMacs.add(0L);
        }
        this.vMacs = (ArrayList) jceInputStream.read((JceInputStream) cache_vMacs, 9, false);
        if (cache_vCells == null) {
            cache_vCells = new ArrayList<>();
            cache_vCells.add(new Cell());
        }
        this.vCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vCells, 10, false);
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
        ArrayList<Long> arrayList = this.vMacs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
        ArrayList<Cell> arrayList2 = this.vCells;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 10);
        }
    }

    public RspGetPositionApi(GPS gps, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i16, ArrayList<Long> arrayList, ArrayList<Cell> arrayList2) {
        this.stUsrLoc = gps;
        this.iRange = i3;
        this.strProvince = str;
        this.strCity = str2;
        this.strDistrict = str3;
        this.strTown = str4;
        this.strRoad = str5;
        this.strPremises = str6;
        this.iDistrictCode = i16;
        this.vMacs = arrayList;
        this.vCells = arrayList2;
    }
}
