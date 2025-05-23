package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GetPoiInfoReq_V2 extends JceStruct {
    static ReqCommon_V2 cache_stCommon;
    static GPS_V2 cache_stGps;
    static ArrayList<Cell_V2> cache_vCellData;
    static ArrayList<Wifi_V2> cache_vWifiData;
    public int iAccuracy;
    public int iDistance;
    public int iLocateCostTime;
    public ReqCommon_V2 stCommon;
    public GPS_V2 stGps;
    public String strAttachInfo;
    public String strClientIP;
    public String strKeyWord;
    public ArrayList<Cell_V2> vCellData;
    public ArrayList<Wifi_V2> vWifiData;

    public GetPoiInfoReq_V2() {
        this.strClientIP = "";
        this.strKeyWord = "";
        this.iDistance = 100;
        this.strAttachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stCommon == null) {
            cache_stCommon = new ReqCommon_V2();
        }
        this.stCommon = (ReqCommon_V2) jceInputStream.read((JceStruct) cache_stCommon, 0, true);
        if (cache_stGps == null) {
            cache_stGps = new GPS_V2();
        }
        this.stGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stGps, 1, true);
        if (cache_vCellData == null) {
            cache_vCellData = new ArrayList<>();
            cache_vCellData.add(new Cell_V2());
        }
        this.vCellData = (ArrayList) jceInputStream.read((JceInputStream) cache_vCellData, 2, true);
        if (cache_vWifiData == null) {
            cache_vWifiData = new ArrayList<>();
            cache_vWifiData.add(new Wifi_V2());
        }
        this.vWifiData = (ArrayList) jceInputStream.read((JceInputStream) cache_vWifiData, 3, true);
        this.strClientIP = jceInputStream.readString(4, true);
        this.strKeyWord = jceInputStream.readString(5, true);
        this.iDistance = jceInputStream.read(this.iDistance, 6, true);
        this.iAccuracy = jceInputStream.read(this.iAccuracy, 7, false);
        this.iLocateCostTime = jceInputStream.read(this.iLocateCostTime, 8, false);
        this.strAttachInfo = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stCommon, 0);
        jceOutputStream.write((JceStruct) this.stGps, 1);
        jceOutputStream.write((Collection) this.vCellData, 2);
        jceOutputStream.write((Collection) this.vWifiData, 3);
        jceOutputStream.write(this.strClientIP, 4);
        jceOutputStream.write(this.strKeyWord, 5);
        jceOutputStream.write(this.iDistance, 6);
        jceOutputStream.write(this.iAccuracy, 7);
        jceOutputStream.write(this.iLocateCostTime, 8);
        String str = this.strAttachInfo;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
    }

    public GetPoiInfoReq_V2(ReqCommon_V2 reqCommon_V2, GPS_V2 gps_v2, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, String str, String str2, int i3, int i16, int i17, String str3) {
        this.stCommon = reqCommon_V2;
        this.stGps = gps_v2;
        this.vCellData = arrayList;
        this.vWifiData = arrayList2;
        this.strClientIP = str;
        this.strKeyWord = str2;
        this.iDistance = i3;
        this.iAccuracy = i16;
        this.iLocateCostTime = i17;
        this.strAttachInfo = str3;
    }
}
