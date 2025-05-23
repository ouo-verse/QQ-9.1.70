package com.qzone.business.lbsv2.business.protocol;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetLbsCombinReq_V2;
import LBS_V2_PROTOCOL.GetLbsCombinRsp_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.qzone.common.protocol.request.QZoneRequest;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.util.QZLog;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GetCombinInfoRequest extends QZoneRequest {
    private static final String CMD_STRING = "getLbsCombin";
    private int appId;
    public int eventId;
    private LbsDataV2.GeoInfo geo;
    private LbsDataV2.GpsInfo gps;
    public LocalImageShootInfo gpsImageInfo;
    private int mode;

    public GetCombinInfoRequest(GPS_V2 gps_v2, GeoInfo_V2 geoInfo_V2, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, int i3, int i16, int i17, int i18, ArrayList<String> arrayList3) {
        super(CMD_STRING);
        this.appId = i17;
        this.mode = i18;
        this.eventId = i16;
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
            for (int i19 = 0; i19 < arrayList3.size(); i19++) {
                if (i19 != arrayList3.size() - 1) {
                    sb5.append(arrayList3.get(i19));
                    sb5.append(",");
                } else {
                    sb5.append(arrayList3.get(i19));
                }
            }
            QZLog.d("GetCombinInfoRequest", 1, "GetCombinInfoRequest... label:", sb5.toString());
            HashMap hashMap = new HashMap();
            getLbsCombinReq_V2.map_ext = hashMap;
            hashMap.put("recomTags", sb5.toString());
        }
        this.req = getLbsCombinReq_V2;
    }

    public int getAppId() {
        return this.appId;
    }

    public LbsDataV2.GeoInfo getGeoBody() {
        return this.geo;
    }

    public LbsDataV2.GpsInfo getGps() {
        return this.gps;
    }

    public int getMode() {
        return this.mode;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    public GetLbsCombinRsp_V2 getResp() {
        return (GetLbsCombinRsp_V2) this.rsp;
    }

    public void setGepsImageInfo(LocalImageShootInfo localImageShootInfo) {
        this.gpsImageInfo = localImageShootInfo;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public GetCombinInfoRequest(LbsDataV2.GpsInfo gpsInfo, LbsDataV2.GeoInfo geoInfo, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, int i3, int i16, int i17, int i18, ArrayList<String> arrayList3) {
        this(LbsDataV2.convertToGPS_V2(gpsInfo), LbsDataV2.convertToGeoInfo_V2(geoInfo), arrayList, arrayList2, i3, i16, i17, i18, arrayList3);
        this.gps = gpsInfo;
        this.geo = geoInfo;
    }

    public GetCombinInfoRequest(LbsDataV2.GpsInfo gpsInfo, LbsDataV2.GeoInfo geoInfo, long j3, int i3, int i16, int i17, ArrayList<String> arrayList) {
        super(CMD_STRING);
        this.gps = gpsInfo;
        this.geo = geoInfo;
        this.appId = i16;
        this.mode = i17;
        this.eventId = i3;
        GetLbsCombinReq_V2 getLbsCombinReq_V2 = new GetLbsCombinReq_V2();
        ReqCommon_V2 reqCommon_V2 = new ReqCommon_V2();
        reqCommon_V2.iDeviceType = 1;
        reqCommon_V2.iAppId = i16;
        getLbsCombinReq_V2.stCommon = reqCommon_V2;
        GPS_V2 convertToGPS_V2 = LbsDataV2.convertToGPS_V2(gpsInfo);
        getLbsCombinReq_V2.stGps = convertToGPS_V2;
        if (convertToGPS_V2 == null) {
            getLbsCombinReq_V2.stGps = new GPS_V2();
        }
        getLbsCombinReq_V2.iReqNum = 16;
        getLbsCombinReq_V2.iMood = i17;
        getLbsCombinReq_V2.iUserTime = ((int) (System.currentTimeMillis() / 1000)) + TimeZone.getDefault().getRawOffset();
        if (geoInfo != null) {
            GeoInfo_V2 convertToGeoInfo_V2 = LbsDataV2.convertToGeoInfo_V2(geoInfo);
            getLbsCombinReq_V2.stGeoInfo = convertToGeoInfo_V2;
            if (convertToGeoInfo_V2.strCountry == null) {
                convertToGeoInfo_V2.strCountry = "";
            }
            if (convertToGeoInfo_V2.strProvince == null) {
                convertToGeoInfo_V2.strProvince = "";
            }
            if (convertToGeoInfo_V2.strCity == null) {
                convertToGeoInfo_V2.strCity = "";
            }
            if (convertToGeoInfo_V2.strDistrict == null) {
                convertToGeoInfo_V2.strDistrict = "";
            }
            if (convertToGeoInfo_V2.strTown == null) {
                convertToGeoInfo_V2.strTown = "";
            }
            if (convertToGeoInfo_V2.strVillage == null) {
                convertToGeoInfo_V2.strVillage = "";
            }
            if (convertToGeoInfo_V2.strRoad == null) {
                convertToGeoInfo_V2.strRoad = "";
            }
            if (convertToGeoInfo_V2.strDefaultName == null) {
                convertToGeoInfo_V2.strDefaultName = "";
            }
        }
        if (j3 != 0) {
            Date date = new Date(j3);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            LBS_V2_PROTOCOL.Date date2 = new LBS_V2_PROTOCOL.Date();
            getLbsCombinReq_V2.stUserDate = date2;
            date2._year = (short) calendar.get(1);
            getLbsCombinReq_V2.stUserDate._mon = (short) (calendar.get(2) + 1);
            getLbsCombinReq_V2.stUserDate._day = (short) calendar.get(5);
        }
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i18 = 0; i18 < arrayList.size(); i18++) {
                if (i18 != arrayList.size() - 1) {
                    sb5.append(arrayList.get(i18));
                    sb5.append(",");
                } else {
                    sb5.append(arrayList.get(i18));
                }
            }
            QZLog.d("GetCombinInfoRequest", 1, "GetCombinInfoRequest... label:", sb5.toString());
            HashMap hashMap = new HashMap();
            getLbsCombinReq_V2.map_ext = hashMap;
            hashMap.put("recomTags", sb5.toString());
        }
        this.req = getLbsCombinReq_V2;
    }
}
