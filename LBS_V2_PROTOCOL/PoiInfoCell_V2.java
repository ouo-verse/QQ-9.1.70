package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PoiInfoCell_V2 extends JceStruct {
    static GPS_V2 cache_stClientGps;
    static GPS_V2 cache_stGps = new GPS_V2();
    static ArrayList<PoiInfo_V2> cache_vPoiList = new ArrayList<>();
    public int iRet;
    public String stCityName;
    public GPS_V2 stClientGps;
    public GPS_V2 stGps;
    public ArrayList<PoiInfo_V2> vPoiList;

    static {
        cache_vPoiList.add(new PoiInfo_V2());
        cache_stClientGps = new GPS_V2();
    }

    public PoiInfoCell_V2() {
        this.stGps = null;
        this.vPoiList = null;
        this.iRet = 0;
        this.stClientGps = null;
        this.stCityName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stGps, 0, false);
        this.vPoiList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPoiList, 1, false);
        this.iRet = jceInputStream.read(this.iRet, 2, false);
        this.stClientGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stClientGps, 3, false);
        this.stCityName = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        GPS_V2 gps_v2 = this.stGps;
        if (gps_v2 != null) {
            jceOutputStream.write((JceStruct) gps_v2, 0);
        }
        ArrayList<PoiInfo_V2> arrayList = this.vPoiList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.iRet, 2);
        GPS_V2 gps_v22 = this.stClientGps;
        if (gps_v22 != null) {
            jceOutputStream.write((JceStruct) gps_v22, 3);
        }
        String str = this.stCityName;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public PoiInfoCell_V2(GPS_V2 gps_v2, ArrayList<PoiInfo_V2> arrayList, int i3, GPS_V2 gps_v22, String str) {
        this.stGps = gps_v2;
        this.vPoiList = arrayList;
        this.iRet = i3;
        this.stClientGps = gps_v22;
        this.stCityName = str;
    }
}
