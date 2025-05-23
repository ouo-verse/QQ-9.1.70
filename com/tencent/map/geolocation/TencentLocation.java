package com.tencent.map.geolocation;

import android.os.Bundle;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface TencentLocation {
    public static final String CELL_PROVIDER = "cell";
    public static final String COARSE_PROVIDER = "coarse";
    public static final int ERROR_BAD_JSON = 2;
    public static final int ERROR_NETWORK = 1;
    public static final int ERROR_OK = 0;
    public static final int ERROR_UNKNOWN = 404;
    public static final int ERROR_WGS84 = 4;
    public static final String EXTRA_ADDRDESP_LANDMARK = "addrdesp.landmark";
    public static final String EXTRA_ADDRDESP_OTHERS_RESULTS = "addrdesp.results";
    public static final String EXTRA_ADDRDESP_SECOND_LANDMARK = "addrdesp.second_landmark";
    public static final String EXTRA_DIRECTION = "direction";
    public static final String EXTRA_RESP_JSON = "resp_json";
    public static final String FAKE = "fake";
    public static final String GPS_PROVIDER = "gps";
    public static final String NETWORK_PROVIDER = "network";
    public static final String PEDESTRIAN_MODE = "pedestrian";
    public static final String RUN_MODE = "run";
    public static final String STATIC_MODE = "static";
    public static final String UNKNOWN = "unknown";
    public static final String VEHICLE_MODE = "vehicle";
    public static final int VERIFYKEY_ERROR_NETWORK = 5;
    public static final String WIFI_PROVIDER = "wifi";

    float getAccuracy();

    String getAddress();

    double getAltitude();

    Integer getAreaStat();

    float getBearing();

    String getCity();

    String getCityCode();

    int getCoordinateType();

    double getDirection();

    String getDistrict();

    long getElapsedRealtime();

    Bundle getExtra();

    int getFakeReason();

    String getIndoorBuildingFloor();

    String getIndoorBuildingId();

    int getIndoorLocationType();

    double getLatitude();

    double getLongitude();

    String getMotion();

    String getName();

    String getNation();

    List<TencentPoi> getPoiList();

    @Deprecated
    String getProvider();

    String getProvince();

    String getRawData();

    int getRssi();

    String getSourceProvider();

    float getSpeed();

    String getStreet();

    String getStreetNo();

    long getTime();

    String getTown();

    String getVerifyKey();

    String getVillage();

    int isMockGps();
}
