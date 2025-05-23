package cooperation.qzone;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetGeoInfoRsp_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import NS_MOBILE_OPERATION.LbsInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LbsDataV2 {
    public static int GPS_DEFAULT_VALUE = 900000000;
    public static int LBS_REQUEST_APPID = 12103;
    public static int POI_DEFAULT_DISTANCE = 500;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class GeoInfo implements Parcelable {
        public static final Parcelable.Creator<GeoInfo> CREATOR = new Parcelable.Creator<GeoInfo>() { // from class: cooperation.qzone.LbsDataV2.GeoInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GeoInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GeoInfo createFromParcel(Parcel parcel) {
                GeoInfo geoInfo = new GeoInfo();
                if (parcel != null) {
                    geoInfo.address = parcel.readString();
                    geoInfo.iDistrictCode = parcel.readInt();
                    geoInfo.iRange = parcel.readInt();
                    geoInfo.strCountry = parcel.readString();
                    geoInfo.strProvince = parcel.readString();
                    geoInfo.strCity = parcel.readString();
                    geoInfo.strDistrict = parcel.readString();
                    geoInfo.strTown = parcel.readString();
                    geoInfo.strVillage = parcel.readString();
                    geoInfo.strRoad = parcel.readString();
                    geoInfo.strDefaultName = parcel.readString();
                    geoInfo.gpsInfo = (GpsInfo) parcel.readParcelable(GpsInfo.class.getClassLoader());
                }
                return geoInfo;
            }
        };
        public String address;
        public GpsInfo gpsInfo;
        public int iDistrictCode;
        public int iRange;
        public String strCity;
        public String strCountry;
        public String strDefaultName;
        public String strDistrict;
        public String strProvince;
        public String strRoad;
        public String strTown;
        public String strVillage;

        public GeoInfo() {
            this.iDistrictCode = 0;
            this.iRange = -1;
            this.strCountry = "";
            this.strProvince = "";
            this.strCity = "";
            this.strDistrict = "";
            this.strTown = "";
            this.strVillage = "";
            this.strRoad = "";
            this.strDefaultName = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isValid() {
            if (TextUtils.isEmpty(this.strCountry) && TextUtils.isEmpty(this.strProvince) && TextUtils.isEmpty(this.strCity) && TextUtils.isEmpty(this.strDistrict)) {
                return false;
            }
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.address);
            parcel.writeInt(this.iDistrictCode);
            parcel.writeInt(this.iRange);
            parcel.writeString(this.strCountry);
            parcel.writeString(this.strProvince);
            parcel.writeString(this.strCity);
            parcel.writeString(this.strDistrict);
            parcel.writeString(this.strTown);
            parcel.writeString(this.strVillage);
            parcel.writeString(this.strRoad);
            parcel.writeString(this.strDefaultName);
            parcel.writeParcelable(this.gpsInfo, i3);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public GeoInfo m467clone() {
            GeoInfo geoInfo = new GeoInfo();
            geoInfo.address = this.address;
            geoInfo.iDistrictCode = this.iDistrictCode;
            geoInfo.iRange = this.iRange;
            geoInfo.strCountry = this.strCountry;
            geoInfo.strProvince = this.strProvince;
            geoInfo.strCity = this.strCity;
            geoInfo.strDistrict = this.strDistrict;
            geoInfo.strTown = this.strTown;
            geoInfo.strVillage = this.strVillage;
            geoInfo.strRoad = this.strRoad;
            geoInfo.strDefaultName = this.strDefaultName;
            GpsInfo gpsInfo = this.gpsInfo;
            if (gpsInfo != null) {
                geoInfo.gpsInfo = gpsInfo.m468clone();
            }
            return geoInfo;
        }

        public GeoInfo(int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.iDistrictCode = i3;
            this.iRange = i16;
            this.strCountry = str;
            this.strProvince = str2;
            this.strCity = str3;
            this.strDistrict = str4;
            this.strTown = str5;
            this.strVillage = str6;
            this.strRoad = str7;
            this.strDefaultName = str8;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class GpsInfo implements Parcelable {
        public static final Parcelable.Creator<GpsInfo> CREATOR = new Parcelable.Creator<GpsInfo>() { // from class: cooperation.qzone.LbsDataV2.GpsInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GpsInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GpsInfo createFromParcel(Parcel parcel) {
                GpsInfo gpsInfo = new GpsInfo();
                if (parcel != null) {
                    gpsInfo.lat = parcel.readInt();
                    gpsInfo.lon = parcel.readInt();
                    gpsInfo.alt = parcel.readInt();
                    gpsInfo.gpsType = parcel.readInt();
                    gpsInfo.accuracy = parcel.readInt();
                }
                return gpsInfo;
            }
        };
        public int accuracy;
        public int alt;
        public int gpsType;
        public int lat;
        public int lon;

        public GpsInfo() {
            int i3 = LbsDataV2.GPS_DEFAULT_VALUE;
            this.lat = i3;
            this.lon = i3;
            this.alt = -10000000;
            this.gpsType = 0;
            reset();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isValid() {
            int i3 = this.lat;
            int i16 = LbsDataV2.GPS_DEFAULT_VALUE;
            if (i3 != i16 && this.lon != i16) {
                return true;
            }
            return false;
        }

        public void reset() {
            int i3 = LbsDataV2.GPS_DEFAULT_VALUE;
            this.lat = i3;
            this.lon = i3;
            this.alt = -10000000;
            this.gpsType = 0;
            this.accuracy = -1;
        }

        public String toString() {
            return "lat: " + this.lat + ", lon: " + this.lon + ", alt: " + this.alt + ", gpsType: " + this.gpsType + ", accuracy: " + this.accuracy;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.lat);
            parcel.writeInt(this.lon);
            parcel.writeInt(this.alt);
            parcel.writeInt(this.gpsType);
            parcel.writeInt(this.accuracy);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public GpsInfo m468clone() {
            return new GpsInfo(this.lat, this.lon, this.alt, this.gpsType, this.accuracy);
        }

        public GpsInfo(int i3, int i16, int i17, int i18, int i19) {
            int i26 = LbsDataV2.GPS_DEFAULT_VALUE;
            this.lat = i3;
            this.lon = i16;
            this.alt = i17;
            this.gpsType = i18;
            this.accuracy = i19;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class PoiInfo implements Parcelable {
        public static final Parcelable.Creator<PoiInfo> CREATOR = new Parcelable.Creator<PoiInfo>() { // from class: cooperation.qzone.LbsDataV2.PoiInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PoiInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PoiInfo createFromParcel(Parcel parcel) {
                PoiInfo poiInfo = new PoiInfo();
                if (parcel != null) {
                    poiInfo.poiId = parcel.readString();
                    poiInfo.poiName = parcel.readString();
                    poiInfo.poiType = parcel.readInt();
                    poiInfo.poiTypeName = parcel.readString();
                    poiInfo.poiDefaultName = parcel.readString();
                    poiInfo.address = parcel.readString();
                    poiInfo.districtCode = parcel.readInt();
                    poiInfo.distance = parcel.readInt();
                    poiInfo.hotValue = parcel.readInt();
                    poiInfo.phoneNumber = parcel.readString();
                    poiInfo.poiOrderType = parcel.readInt();
                    poiInfo.poiNum = parcel.readInt();
                    poiInfo.dianPingId = parcel.readString();
                    poiInfo.gpsInfo = (GpsInfo) parcel.readParcelable(GpsInfo.class.getClassLoader());
                    poiInfo.show_poi = parcel.readInt();
                    poiInfo.country = parcel.readString();
                    poiInfo.province = parcel.readString();
                    poiInfo.city = parcel.readString();
                    poiInfo.district = parcel.readString();
                    poiInfo.isRecomm = parcel.readByte() == 1;
                }
                return poiInfo;
            }
        };
        public String address;
        public int distance;
        public String poiDefaultName;
        public String poiId;
        public String poiName;
        public int poiNum;
        public int poiOrderType;
        public int poiType;
        public String poiTypeName;
        public int districtCode = 0;
        public int hotValue = 0;
        public String phoneNumber = "";
        public String dianPingId = "";
        public String country = "";
        public String province = "";
        public String city = "";
        public String district = "";
        public GpsInfo gpsInfo = new GpsInfo();
        public int show_poi = 0;
        public boolean isRecomm = false;

        public static PoiInfo clone(PoiInfo poiInfo) {
            GpsInfo gpsInfo = null;
            if (poiInfo == null) {
                return null;
            }
            PoiInfo poiInfo2 = new PoiInfo();
            poiInfo2.address = poiInfo.address;
            poiInfo2.dianPingId = poiInfo.dianPingId;
            poiInfo2.distance = poiInfo.distance;
            poiInfo2.districtCode = poiInfo.districtCode;
            GpsInfo gpsInfo2 = poiInfo.gpsInfo;
            if (gpsInfo2 != null) {
                gpsInfo = gpsInfo2.m468clone();
            }
            poiInfo2.gpsInfo = gpsInfo;
            poiInfo2.hotValue = poiInfo.hotValue;
            poiInfo2.phoneNumber = poiInfo.phoneNumber;
            poiInfo2.poiDefaultName = poiInfo.poiDefaultName;
            poiInfo2.poiId = poiInfo.poiId;
            poiInfo2.poiName = poiInfo.poiName;
            poiInfo2.poiNum = poiInfo.poiNum;
            poiInfo2.poiOrderType = poiInfo.poiOrderType;
            poiInfo2.poiType = poiInfo.poiType;
            poiInfo2.poiTypeName = poiInfo.poiTypeName;
            poiInfo2.show_poi = poiInfo.show_poi;
            poiInfo2.city = poiInfo.city;
            poiInfo2.province = poiInfo.province;
            poiInfo2.country = poiInfo.country;
            poiInfo2.district = poiInfo.district;
            poiInfo2.isRecomm = poiInfo.isRecomm;
            return poiInfo2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return ((PoiInfo) obj).poiId.equals(this.poiId);
        }

        public String toString() {
            if (this.gpsInfo != null) {
                return " poiId: " + this.poiId + " poiName: " + this.poiName + " poiType: " + this.poiType + " poiTypeName: " + this.poiTypeName + " address: " + this.address + " districtCode: " + this.districtCode + " distance: " + this.distance + " phoneNumber: " + this.phoneNumber + "poiOrderType: " + this.poiOrderType + "poiNum: " + this.poiNum + " gpsInfo: " + this.gpsInfo.toString() + " ";
            }
            return "poiId: " + this.poiId + "poiName: " + this.poiName + "poiType: " + this.poiType + "poiTypeName: " + this.poiTypeName + "address: " + this.address + "districtCode: " + this.districtCode + "distance: " + this.distance + "phoneNumber: " + this.phoneNumber + "poiOrderType: " + this.poiOrderType + "poiNum: " + this.poiNum + " dianPingId:" + this.dianPingId;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.poiId);
            parcel.writeString(this.poiName);
            parcel.writeInt(this.poiType);
            parcel.writeString(this.poiTypeName);
            parcel.writeString(this.poiDefaultName);
            parcel.writeString(this.address);
            parcel.writeInt(this.districtCode);
            parcel.writeInt(this.distance);
            parcel.writeInt(this.hotValue);
            parcel.writeString(this.phoneNumber);
            parcel.writeInt(this.poiOrderType);
            parcel.writeInt(this.poiNum);
            parcel.writeString(this.dianPingId);
            parcel.writeParcelable(this.gpsInfo, i3);
            parcel.writeInt(this.show_poi);
            parcel.writeString(this.country);
            parcel.writeString(this.province);
            parcel.writeString(this.city);
            parcel.writeString(this.district);
            parcel.writeByte(this.isRecomm ? (byte) 1 : (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class PoiList {
        public GetGeoInfoRsp_V2 geoInfo;
        public ArrayList<PoiInfo> poiInfos = new ArrayList<>();
        public GpsInfo userGpsInfo;
    }

    public static GpsInfo convertFromSoso(SosoLocation sosoLocation) {
        if (sosoLocation == null) {
            return null;
        }
        GpsInfo gpsInfo = new GpsInfo();
        gpsInfo.accuracy = (int) sosoLocation.accuracy;
        gpsInfo.alt = (int) sosoLocation.altitude;
        double d16 = sosoLocation.mLon84;
        if (d16 == 0.0d && sosoLocation.mLat84 == 0.0d) {
            gpsInfo.gpsType = 1;
            gpsInfo.lat = (int) (sosoLocation.mLat02 * 1000000.0d);
            gpsInfo.lon = (int) (sosoLocation.mLon02 * 1000000.0d);
        } else {
            gpsInfo.gpsType = 0;
            gpsInfo.lat = (int) (sosoLocation.mLat84 * 1000000.0d);
            gpsInfo.lon = (int) (d16 * 1000000.0d);
        }
        return gpsInfo;
    }

    public static PoiInfo convertPoiInfoFromSoso(SosoLocation sosoLocation) {
        if (sosoLocation == null) {
            return null;
        }
        PoiInfo poiInfo = new PoiInfo();
        poiInfo.gpsInfo = convertFromSoso(sosoLocation);
        poiInfo.province = sosoLocation.province;
        poiInfo.city = sosoLocation.city;
        poiInfo.district = sosoLocation.district;
        return poiInfo;
    }

    public static Cell_V2 convertToCell_V2(CellInfo cellInfo) {
        if (cellInfo == null) {
            return null;
        }
        Cell_V2 cell_V2 = new Cell_V2();
        cell_V2.shMcc = (short) cellInfo.mcc;
        cell_V2.shMnc = (short) cellInfo.mnc;
        cell_V2.iLac = cellInfo.lac;
        cell_V2.iCellId = cellInfo.cellId;
        cell_V2.iRssi = cellInfo.rssi;
        cell_V2.dStationLat = cellInfo.stationLat;
        cell_V2.dStationLon = cellInfo.stationLon;
        return cell_V2;
    }

    public static GPS_V2 convertToGPS_V2(GpsInfo gpsInfo) {
        GPS_V2 gps_v2 = new GPS_V2();
        if (gpsInfo != null) {
            gps_v2.eType = gpsInfo.gpsType;
            gps_v2.iAlt = gpsInfo.alt;
            gps_v2.iLat = gpsInfo.lat;
            gps_v2.iLon = gpsInfo.lon;
        }
        return gps_v2;
    }

    public static GeoInfo convertToGeoInfo(GeoInfo_V2 geoInfo_V2) {
        GeoInfo geoInfo = new GeoInfo();
        if (geoInfo_V2 != null) {
            geoInfo.iDistrictCode = geoInfo_V2.iDistrictCode;
            geoInfo.iRange = geoInfo_V2.iRange;
            geoInfo.strCountry = geoInfo_V2.strCountry;
            geoInfo.strProvince = geoInfo_V2.strProvince;
            geoInfo.strCity = geoInfo_V2.strCity;
            geoInfo.strDistrict = geoInfo_V2.strDistrict;
            geoInfo.strTown = geoInfo_V2.strTown;
            geoInfo.strVillage = geoInfo_V2.strVillage;
            geoInfo.strRoad = geoInfo_V2.strRoad;
            geoInfo.strDefaultName = geoInfo_V2.strDefaultName;
        }
        return geoInfo;
    }

    public static GeoInfo_V2 convertToGeoInfo_V2(GeoInfo geoInfo) {
        GeoInfo_V2 geoInfo_V2 = new GeoInfo_V2();
        if (geoInfo != null) {
            geoInfo_V2.iDistrictCode = geoInfo.iDistrictCode;
            geoInfo_V2.iRange = geoInfo.iRange;
            geoInfo_V2.strCountry = geoInfo.strCountry;
            geoInfo_V2.strProvince = geoInfo.strProvince;
            geoInfo_V2.strCity = geoInfo.strCity;
            geoInfo_V2.strDistrict = geoInfo.strDistrict;
            geoInfo_V2.strTown = geoInfo.strTown;
            geoInfo_V2.strVillage = geoInfo.strVillage;
            geoInfo_V2.strRoad = geoInfo.strRoad;
            geoInfo_V2.strDefaultName = geoInfo.strDefaultName;
        }
        return geoInfo_V2;
    }

    public static GpsInfo convertToGpsInfo(GPS_V2 gps_v2) {
        GpsInfo gpsInfo = new GpsInfo();
        if (gps_v2 != null) {
            gpsInfo.gpsType = gps_v2.eType;
            gpsInfo.alt = gps_v2.iAlt;
            gpsInfo.lat = gps_v2.iLat;
            gpsInfo.lon = gps_v2.iLon;
        }
        return gpsInfo;
    }

    public static PoiInfo convertToPoiInfo(PoiInfo_V2 poiInfo_V2) {
        PoiInfo poiInfo = new PoiInfo();
        if (poiInfo_V2 != null) {
            poiInfo.address = poiInfo_V2.strAddress;
            poiInfo.gpsInfo = convertToGpsInfo(poiInfo_V2.stGps);
            String str = poiInfo_V2.strCity;
            poiInfo.city = str;
            poiInfo.country = str;
            poiInfo.districtCode = poiInfo_V2.iDistrictCode;
            poiInfo.district = poiInfo_V2.strDistrict;
            poiInfo.province = poiInfo_V2.strProvince;
            poiInfo.distance = poiInfo_V2.iDistance;
            poiInfo.poiId = poiInfo_V2.strPoiId;
            poiInfo.poiName = poiInfo_V2.strName;
            poiInfo.poiOrderType = poiInfo_V2.iPoiOrderType;
            poiInfo.poiNum = poiInfo_V2.iPoiNum;
            poiInfo.hotValue = poiInfo_V2.iHotValue;
            poiInfo.phoneNumber = poiInfo_V2.strPhone;
            poiInfo.poiDefaultName = poiInfo_V2.strDefaultName;
            poiInfo.dianPingId = poiInfo_V2.strDianPingId;
        }
        return poiInfo;
    }

    public static Wifi_V2 convertToWifi_V2(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        Wifi_V2 wifi_V2 = new Wifi_V2();
        wifi_V2.strMac = wifiInfo.mac;
        wifi_V2.iRssi = wifiInfo.rssi;
        return wifi_V2;
    }

    public static CellInfo covertToCellInfo(Cell_V2 cell_V2) {
        if (cell_V2 == null) {
            return null;
        }
        CellInfo cellInfo = new CellInfo();
        cellInfo.mcc = cell_V2.shMcc;
        cellInfo.mnc = cell_V2.shMnc;
        cellInfo.lac = cell_V2.iLac;
        cellInfo.cellId = cell_V2.iCellId;
        cellInfo.rssi = cell_V2.iRssi;
        cellInfo.stationLat = cell_V2.dStationLat;
        cellInfo.stationLon = cell_V2.dStationLon;
        return cellInfo;
    }

    public static ArrayList<PoiInfo> fromSosoLocation(SosoLocation sosoLocation) {
        List<TencentPoi> list;
        ArrayList<PoiInfo> arrayList = new ArrayList<>();
        if (sosoLocation != null && (list = sosoLocation.poi) != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < sosoLocation.poi.size(); i3++) {
                PoiInfo fromTencentPoi = fromTencentPoi(sosoLocation.poi.get(i3));
                fromTencentPoi.country = sosoLocation.nation;
                fromTencentPoi.province = sosoLocation.province;
                fromTencentPoi.city = sosoLocation.city;
                fromTencentPoi.district = sosoLocation.district;
                arrayList.add(fromTencentPoi);
            }
        }
        return arrayList;
    }

    public static PoiInfo fromTencentPoi(TencentPoi tencentPoi) {
        PoiInfo poiInfo = new PoiInfo();
        if (tencentPoi != null) {
            poiInfo.address = tencentPoi.getAddress();
            try {
                double latitude = tencentPoi.getLatitude();
                double longitude = tencentPoi.getLongitude();
                GpsInfo gpsInfo = new GpsInfo();
                poiInfo.gpsInfo = gpsInfo;
                gpsInfo.lat = (int) (latitude * 1000000.0d);
                gpsInfo.lon = (int) (longitude * 1000000.0d);
                gpsInfo.accuracy = -1;
            } catch (NumberFormatException unused) {
                poiInfo.gpsInfo = null;
            }
            poiInfo.poiTypeName = tencentPoi.getCatalog();
            poiInfo.distance = (int) tencentPoi.getDistance();
            poiInfo.poiId = tencentPoi.getUid();
            poiInfo.poiName = tencentPoi.getName();
            poiInfo.poiDefaultName = tencentPoi.getName();
        }
        return poiInfo;
    }

    public static LbsInfo parceToLbsInfo(PoiInfo poiInfo) {
        if (poiInfo == null) {
            return null;
        }
        LbsInfo lbsInfo = new LbsInfo();
        if (poiInfo.gpsInfo != null) {
            lbsInfo.lbs_x = String.valueOf(r1.lon / 1000000.0d);
            lbsInfo.lbs_y = String.valueOf(poiInfo.gpsInfo.lat / 1000000.0d);
        }
        String str = poiInfo.poiDefaultName;
        lbsInfo.lbs_idnm = str;
        if (TextUtils.isEmpty(str)) {
            lbsInfo.lbs_idnm = poiInfo.poiName;
        }
        lbsInfo.lbs_nm = poiInfo.address;
        String str2 = poiInfo.poiId;
        lbsInfo.s_lbs_id = str2;
        lbsInfo.i_poi_num = poiInfo.poiNum;
        lbsInfo.i_poi_order_type = poiInfo.poiOrderType;
        lbsInfo.i_poi_type = poiInfo.poiType;
        try {
            lbsInfo.lbs_id = Integer.parseInt(str2);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return lbsInfo;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class GetGeoInfoRsp implements Parcelable {
        public static final Parcelable.Creator<GetGeoInfoRsp> CREATOR = new Parcelable.Creator<GetGeoInfoRsp>() { // from class: cooperation.qzone.LbsDataV2.GetGeoInfoRsp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GetGeoInfoRsp[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GetGeoInfoRsp createFromParcel(Parcel parcel) {
                GetGeoInfoRsp getGeoInfoRsp = new GetGeoInfoRsp();
                if (parcel != null) {
                    getGeoInfoRsp.stGps = (GpsInfo) parcel.readParcelable(GpsInfo.class.getClassLoader());
                    getGeoInfoRsp.stGeoInfo = (GeoInfo) parcel.readParcelable(GeoInfo.class.getClassLoader());
                }
                return getGeoInfoRsp;
            }
        };
        public GeoInfo stGeoInfo;
        public GpsInfo stGps;

        public GetGeoInfoRsp() {
            this.stGps = null;
            this.stGeoInfo = null;
        }

        public static GetGeoInfoRsp_V2 convertTo(GetGeoInfoRsp getGeoInfoRsp) {
            GetGeoInfoRsp_V2 getGeoInfoRsp_V2 = new GetGeoInfoRsp_V2();
            if (getGeoInfoRsp != null) {
                getGeoInfoRsp_V2.stGeoInfo = LbsDataV2.convertToGeoInfo_V2(getGeoInfoRsp.stGeoInfo);
                getGeoInfoRsp_V2.stGps = LbsDataV2.convertToGPS_V2(getGeoInfoRsp.stGps);
            }
            return getGeoInfoRsp_V2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "GetGeoInfoRsp:{" + this.stGps + ", " + this.stGeoInfo + "}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.stGps, i3);
            parcel.writeParcelable(this.stGeoInfo, i3);
        }

        public GetGeoInfoRsp(GpsInfo gpsInfo, GeoInfo geoInfo) {
            this.stGps = gpsInfo;
            this.stGeoInfo = geoInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class WifiInfo implements Parcelable {
        public static final Parcelable.Creator<WifiInfo> CREATOR = new Parcelable.Creator<WifiInfo>() { // from class: cooperation.qzone.LbsDataV2.WifiInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WifiInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WifiInfo createFromParcel(Parcel parcel) {
                WifiInfo wifiInfo = new WifiInfo();
                if (parcel != null) {
                    wifiInfo.mac = parcel.readString();
                    wifiInfo.rssi = parcel.readInt();
                }
                return wifiInfo;
            }
        };
        public String mac;
        public int rssi;

        public WifiInfo() {
            this.mac = "";
            this.rssi = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "WifiInfo [mac=" + this.mac + ", rssi=" + this.rssi + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.mac);
            parcel.writeInt(this.rssi);
        }

        public WifiInfo(String str, int i3) {
            this.mac = str;
            this.rssi = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class CellInfo implements Parcelable {
        public static final Parcelable.Creator<CellInfo> CREATOR = new Parcelable.Creator<CellInfo>() { // from class: cooperation.qzone.LbsDataV2.CellInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CellInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CellInfo createFromParcel(Parcel parcel) {
                CellInfo cellInfo = new CellInfo();
                if (parcel != null) {
                    cellInfo.mcc = parcel.readInt();
                    cellInfo.mnc = parcel.readInt();
                    cellInfo.lac = parcel.readInt();
                    cellInfo.cellId = parcel.readInt();
                    cellInfo.rssi = parcel.readInt();
                    cellInfo.stationLat = parcel.readDouble();
                    cellInfo.stationLon = parcel.readDouble();
                }
                return cellInfo;
            }
        };
        public int cellId;
        public int lac;
        public int mcc;
        public int mnc;
        public int rssi;
        public double stationLat;
        public double stationLon;

        public CellInfo() {
            this.mcc = -1;
            this.mnc = -1;
            this.lac = -1;
            this.cellId = -1;
            this.rssi = 0;
            this.stationLat = 0.0d;
            this.stationLon = 0.0d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isValid() {
            if (this.cellId != -1) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "CellInfo [mcc=" + this.mcc + ", mnc=" + this.mnc + ", lac=" + this.lac + ", cellId=" + this.cellId + ", rssi=" + this.rssi + ", stationLat=" + this.stationLat + ", stationLon=" + this.stationLon + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.mcc);
            parcel.writeInt(this.mnc);
            parcel.writeInt(this.lac);
            parcel.writeInt(this.cellId);
            parcel.writeInt(this.rssi);
            parcel.writeDouble(this.stationLat);
            parcel.writeDouble(this.stationLon);
        }

        public CellInfo(int i3, int i16, int i17, int i18, int i19, double d16, double d17) {
            this.mcc = i3;
            this.mnc = i16;
            this.lac = i17;
            this.cellId = i18;
            this.rssi = i19;
            this.stationLat = d16;
            this.stationLon = d17;
        }
    }

    public static GeoInfo convertToGeoInfo(GeoInfo_V2 geoInfo_V2, GPS_V2 gps_v2) {
        GeoInfo geoInfo = new GeoInfo();
        if (geoInfo_V2 != null) {
            geoInfo.iDistrictCode = geoInfo_V2.iDistrictCode;
            geoInfo.iRange = geoInfo_V2.iRange;
            geoInfo.strCountry = geoInfo_V2.strCountry;
            geoInfo.strProvince = geoInfo_V2.strProvince;
            geoInfo.strCity = geoInfo_V2.strCity;
            geoInfo.strDistrict = geoInfo_V2.strDistrict;
            geoInfo.strTown = geoInfo_V2.strTown;
            geoInfo.strVillage = geoInfo_V2.strVillage;
            geoInfo.strRoad = geoInfo_V2.strRoad;
            geoInfo.strDefaultName = geoInfo_V2.strDefaultName;
        }
        geoInfo.gpsInfo = convertToGpsInfo(gps_v2);
        return geoInfo;
    }

    public static LbsInfo parceToLbsInfo(LocalImageShootInfo localImageShootInfo) {
        if (localImageShootInfo == null) {
            return null;
        }
        LbsInfo lbsInfo = new LbsInfo();
        GpsInfo4LocalImage gpsInfo4LocalImage = localImageShootInfo.gpsInfo;
        if (gpsInfo4LocalImage != null) {
            lbsInfo.lbs_x = String.valueOf(gpsInfo4LocalImage.longtitude);
            lbsInfo.lbs_y = String.valueOf(localImageShootInfo.gpsInfo.latitude);
        }
        return lbsInfo;
    }
}
