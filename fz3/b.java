package fz3;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetLbsCombinReq_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends QZoneCommonRequest {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private LbsDataV2.GpsInfo f400979d;

    /* renamed from: e, reason: collision with root package name */
    private LbsDataV2.GeoInfo f400980e;

    /* renamed from: f, reason: collision with root package name */
    private int f400981f;

    /* renamed from: h, reason: collision with root package name */
    private int f400982h;

    /* renamed from: i, reason: collision with root package name */
    public int f400983i;

    /* renamed from: m, reason: collision with root package name */
    public JceStruct f400984m;

    public b(GPS_V2 gps_v2, GeoInfo_V2 geoInfo_V2, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, int i3, int i16, int i17, int i18, ArrayList<String> arrayList3, int i19) {
        this.C = i19;
        this.f400981f = i17;
        this.f400982h = i18;
        this.f400983i = i16;
        GetLbsCombinReq_V2 getLbsCombinReq_V2 = new GetLbsCombinReq_V2();
        ReqCommon_V2 reqCommon_V2 = new ReqCommon_V2();
        reqCommon_V2.iDeviceType = 1;
        reqCommon_V2.iAppId = i17;
        getLbsCombinReq_V2.stCommon = reqCommon_V2;
        getLbsCombinReq_V2.stGps = gps_v2;
        if (gps_v2 == null) {
            getLbsCombinReq_V2.stGps = new GPS_V2();
        }
        getLbsCombinReq_V2.vCellData = arrayList;
        getLbsCombinReq_V2.vWifiData = arrayList2;
        getLbsCombinReq_V2.iReqNum = 16;
        getLbsCombinReq_V2.iAccuracy = 0;
        getLbsCombinReq_V2.iMood = i18;
        getLbsCombinReq_V2.iUserTime = ((int) (System.currentTimeMillis() / 1000)) + TimeZone.getDefault().getRawOffset();
        getLbsCombinReq_V2.iLocateCostTime = i3;
        if (geoInfo_V2 != null) {
            getLbsCombinReq_V2.stGeoInfo = geoInfo_V2;
            if (geoInfo_V2.strCountry == null) {
                geoInfo_V2.strCountry = "";
            }
            if (geoInfo_V2.strProvince == null) {
                geoInfo_V2.strProvince = "";
            }
            if (geoInfo_V2.strCity == null) {
                geoInfo_V2.strCity = "";
            }
            if (geoInfo_V2.strDistrict == null) {
                geoInfo_V2.strDistrict = "";
            }
            if (geoInfo_V2.strTown == null) {
                geoInfo_V2.strTown = "";
            }
            if (geoInfo_V2.strVillage == null) {
                geoInfo_V2.strVillage = "";
            }
            if (geoInfo_V2.strRoad == null) {
                geoInfo_V2.strRoad = "";
            }
            if (geoInfo_V2.strDefaultName == null) {
                geoInfo_V2.strDefaultName = "";
            }
        }
        if (arrayList3 != null && arrayList3.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i26 = 0; i26 < arrayList3.size(); i26++) {
                if (i26 != arrayList3.size() - 1) {
                    sb5.append(arrayList3.get(i26));
                    sb5.append(",");
                } else {
                    sb5.append(arrayList3.get(i26));
                }
            }
            QLog.d("GetCombinInfoRequest", 1, "GetCombinInfoRequest... label:", sb5.toString());
            HashMap hashMap = new HashMap();
            getLbsCombinReq_V2.map_ext = hashMap;
            hashMap.put("recomTags", sb5.toString());
        }
        this.f400984m = getLbsCombinReq_V2;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.getLbsCombin";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.f400984m;
    }

    @Override // cooperation.qzone.QZoneCommonRequest
    public int getType() {
        return this.C;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getLbsCombin";
    }

    public b(LbsDataV2.GpsInfo gpsInfo, LbsDataV2.GeoInfo geoInfo, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, int i3, int i16, int i17, int i18, ArrayList<String> arrayList3, int i19) {
        this(LbsDataV2.convertToGPS_V2(gpsInfo), LbsDataV2.convertToGeoInfo_V2(geoInfo), arrayList, arrayList2, i3, i16, i17, i18, arrayList3, i19);
        this.f400979d = gpsInfo;
        this.f400980e = geoInfo;
    }
}
