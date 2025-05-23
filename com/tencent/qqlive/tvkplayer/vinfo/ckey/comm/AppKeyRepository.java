package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppKeyRepository {
    private static AppKeyRepository instance;
    private Map<String, Map<String, String>> mMapAppKey = new HashMap();
    private String mBsGuid = "";
    private String mAppKey = "";
    private String mVsKey = "";
    private String mPlatfrom = "";
    private String mSdtfrom = "";
    private boolean isAdd = false;

    AppKeyRepository() {
    }

    public static synchronized AppKeyRepository getInstance() {
        AppKeyRepository appKeyRepository;
        synchronized (AppKeyRepository.class) {
            if (instance == null) {
                instance = new AppKeyRepository();
            }
            appKeyRepository = instance;
        }
        return appKeyRepository;
    }

    public void addAppKey(String str, Map<String, String> map) {
        if (!this.isAdd) {
            this.mBsGuid = map.get("bsguid");
            this.mVsKey = map.get("vskey");
            this.mPlatfrom = map.get("platform");
            this.mSdtfrom = map.get("sdtfrom");
            this.mAppKey = map.get("appkey");
        }
        this.mMapAppKey.put(str, map);
        this.isAdd = true;
    }

    public String getAppKey(String str) {
        return this.mMapAppKey.get(str).get("appkey");
    }

    public String getBsGuid(String str) {
        return this.mMapAppKey.get(str).get("bsguid");
    }

    public String getPlatform(String str) {
        return this.mMapAppKey.get(str).get(QCircleAlphaUserReporter.KEY_PLATFORM);
    }

    public String getSdtfrom(String str) {
        return this.mMapAppKey.get(str).get("sdtfrom");
    }

    public String getVsKey(String str) {
        return this.mMapAppKey.get(str).get("vskey");
    }

    public String getmAppKey() {
        return this.mAppKey;
    }

    public String getmBsGuid() {
        return this.mBsGuid;
    }

    public String getmPlatfrom() {
        return this.mPlatfrom;
    }

    public String getmSdtfrom() {
        return this.mSdtfrom;
    }

    public String getmVsKey() {
        return this.mVsKey;
    }
}
