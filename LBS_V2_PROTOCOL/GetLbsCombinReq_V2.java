package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetLbsCombinReq_V2 extends JceStruct {
    static Map<String, String> cache_map_ext;
    static GeoInfo_V2 cache_stGeoInfo;
    static Date cache_stUserDate;
    static ArrayList<Wifi_V2> cache_vWifiData;
    public int iAccuracy;
    public int iAppID;
    public int iLocateCostTime;
    public int iMood;
    public int iReqNum;
    public long iUserTime;
    public Map<String, String> map_ext;
    public ReqCommon_V2 stCommon;
    public GeoInfo_V2 stGeoInfo;
    public GPS_V2 stGps;
    public Date stUserDate;
    public String strClientIP;
    public ArrayList<Cell_V2> vCellData;
    public ArrayList<Wifi_V2> vWifiData;
    static ReqCommon_V2 cache_stCommon = new ReqCommon_V2();
    static GPS_V2 cache_stGps = new GPS_V2();
    static ArrayList<Cell_V2> cache_vCellData = new ArrayList<>();

    static {
        cache_vCellData.add(new Cell_V2());
        cache_vWifiData = new ArrayList<>();
        cache_vWifiData.add(new Wifi_V2());
        cache_stGeoInfo = new GeoInfo_V2();
        cache_stUserDate = new Date();
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
    }

    public GetLbsCombinReq_V2() {
        this.stCommon = null;
        this.strClientIP = "";
        this.stGps = null;
        this.vCellData = null;
        this.vWifiData = null;
        this.iReqNum = 10;
        this.iAccuracy = 0;
        this.iLocateCostTime = 0;
        this.iMood = 0;
        this.stGeoInfo = null;
        this.iUserTime = 0L;
        this.iAppID = 0;
        this.stUserDate = null;
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stCommon = (ReqCommon_V2) jceInputStream.read((JceStruct) cache_stCommon, 0, true);
        this.strClientIP = jceInputStream.readString(1, true);
        this.stGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stGps, 2, true);
        this.vCellData = (ArrayList) jceInputStream.read((JceInputStream) cache_vCellData, 3, true);
        this.vWifiData = (ArrayList) jceInputStream.read((JceInputStream) cache_vWifiData, 4, true);
        this.iReqNum = jceInputStream.read(this.iReqNum, 5, true);
        this.iAccuracy = jceInputStream.read(this.iAccuracy, 6, false);
        this.iLocateCostTime = jceInputStream.read(this.iLocateCostTime, 7, false);
        this.iMood = jceInputStream.read(this.iMood, 8, false);
        this.stGeoInfo = (GeoInfo_V2) jceInputStream.read((JceStruct) cache_stGeoInfo, 9, false);
        this.iUserTime = jceInputStream.read(this.iUserTime, 10, false);
        this.iAppID = jceInputStream.read(this.iAppID, 11, false);
        this.stUserDate = (Date) jceInputStream.read((JceStruct) cache_stUserDate, 12, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stCommon, 0);
        jceOutputStream.write(this.strClientIP, 1);
        jceOutputStream.write((JceStruct) this.stGps, 2);
        jceOutputStream.write((Collection) this.vCellData, 3);
        jceOutputStream.write((Collection) this.vWifiData, 4);
        jceOutputStream.write(this.iReqNum, 5);
        jceOutputStream.write(this.iAccuracy, 6);
        jceOutputStream.write(this.iLocateCostTime, 7);
        jceOutputStream.write(this.iMood, 8);
        GeoInfo_V2 geoInfo_V2 = this.stGeoInfo;
        if (geoInfo_V2 != null) {
            jceOutputStream.write((JceStruct) geoInfo_V2, 9);
        }
        jceOutputStream.write(this.iUserTime, 10);
        jceOutputStream.write(this.iAppID, 11);
        Date date = this.stUserDate;
        if (date != null) {
            jceOutputStream.write((JceStruct) date, 12);
        }
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
    }

    public GetLbsCombinReq_V2(ReqCommon_V2 reqCommon_V2, String str, GPS_V2 gps_v2, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, int i3, int i16, int i17, int i18, GeoInfo_V2 geoInfo_V2, long j3, int i19, Date date, Map<String, String> map) {
        this.stCommon = reqCommon_V2;
        this.strClientIP = str;
        this.stGps = gps_v2;
        this.vCellData = arrayList;
        this.vWifiData = arrayList2;
        this.iReqNum = i3;
        this.iAccuracy = i16;
        this.iLocateCostTime = i17;
        this.iMood = i18;
        this.stGeoInfo = geoInfo_V2;
        this.iUserTime = j3;
        this.iAppID = i19;
        this.stUserDate = date;
        this.map_ext = map;
    }
}
