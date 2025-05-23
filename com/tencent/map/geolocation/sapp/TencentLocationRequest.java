package com.tencent.map.geolocation.sapp;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class TencentLocationRequest {
    public static final int REQUEST_DOMAIN_MODE_COMMON = 0;
    public static final int REQUEST_DOMAIN_MODE_FOREGIN = 1;
    public static final int REQUEST_DOMAIN_MODE_IOT = 2;
    public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
    public static final int REQUEST_LEVEL_GEO = 0;
    public static final int REQUEST_LEVEL_NAME = 1;
    public static final int REQUEST_LEVEL_POI = 4;
    private boolean mAllowCache;
    private boolean mAllowDirection;
    private boolean mAllowGps;
    private long mExpirationTime;
    private Bundle mExtras;
    private boolean mIndoorLocationMode;
    private long mInterval;
    private int mNumUpdates;
    private String mOpenId;
    private String mQQ;
    private int mRequestDomainMode;
    private int mRequestLevel;
    private String mSmallAppKey;

    TencentLocationRequest() {
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        tencentLocationRequest.mInterval = tencentLocationRequest2.mInterval;
        tencentLocationRequest.mRequestLevel = tencentLocationRequest2.mRequestLevel;
        tencentLocationRequest.mAllowCache = tencentLocationRequest2.mAllowCache;
        tencentLocationRequest.mAllowDirection = tencentLocationRequest2.mAllowDirection;
        tencentLocationRequest.mExpirationTime = tencentLocationRequest2.mExpirationTime;
        tencentLocationRequest.mNumUpdates = tencentLocationRequest2.mNumUpdates;
        tencentLocationRequest.mIndoorLocationMode = tencentLocationRequest2.mIndoorLocationMode;
        tencentLocationRequest.mRequestDomainMode = tencentLocationRequest2.mRequestDomainMode;
        tencentLocationRequest.mAllowGps = tencentLocationRequest2.mAllowGps;
        tencentLocationRequest.mQQ = tencentLocationRequest2.mQQ;
        tencentLocationRequest.mSmallAppKey = tencentLocationRequest2.mSmallAppKey;
        tencentLocationRequest.mOpenId = tencentLocationRequest2.mOpenId;
        tencentLocationRequest.mExtras.clear();
        tencentLocationRequest.mExtras.putAll(tencentLocationRequest2.mExtras);
    }

    public static TencentLocationRequest create() {
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.mInterval = 10000L;
        tencentLocationRequest.mRequestLevel = 1;
        tencentLocationRequest.mAllowCache = true;
        tencentLocationRequest.mAllowDirection = false;
        tencentLocationRequest.mIndoorLocationMode = false;
        tencentLocationRequest.mRequestDomainMode = 0;
        tencentLocationRequest.mExpirationTime = 0L;
        tencentLocationRequest.mNumUpdates = Integer.MAX_VALUE;
        tencentLocationRequest.mAllowGps = true;
        tencentLocationRequest.mQQ = "";
        tencentLocationRequest.mOpenId = "";
        tencentLocationRequest.mSmallAppKey = "";
        tencentLocationRequest.mExtras = new Bundle();
        return tencentLocationRequest;
    }

    private boolean isAllowedLevel(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 3 || i3 == 4 || i3 == 7) {
            return true;
        }
        return false;
    }

    public String getAndroidId() {
        String string = this.mExtras.getString("androidId");
        if (string == null) {
            return "";
        }
        return string;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getInterval() {
        return this.mInterval;
    }

    public String getOpenId() {
        return this.mOpenId;
    }

    public String getQQ() {
        return this.mQQ;
    }

    public int getRequestDomainMode() {
        return this.mRequestDomainMode;
    }

    public int getRequestLevel() {
        return this.mRequestLevel;
    }

    public String getSmallAppKey() {
        return this.mSmallAppKey;
    }

    public long getmExpirationTime() {
        return this.mExpirationTime;
    }

    public boolean isAllowCache() {
        return this.mAllowCache;
    }

    public boolean isAllowDirection() {
        return this.mAllowDirection;
    }

    public boolean isAllowGPS() {
        return this.mAllowGps;
    }

    public boolean isIndoorLocationMode() {
        return this.mIndoorLocationMode;
    }

    public TencentLocationRequest setAllowCache(boolean z16) {
        this.mAllowCache = z16;
        return this;
    }

    public TencentLocationRequest setAllowDirection(boolean z16) {
        this.mAllowDirection = z16;
        return this;
    }

    public TencentLocationRequest setAllowGPS(boolean z16) {
        this.mAllowGps = z16;
        return this;
    }

    public TencentLocationRequest setAndroidId(String str) {
        if (str == null) {
            str = "";
        }
        this.mExtras.putString("androidId", str);
        return this;
    }

    public TencentLocationRequest setIndoorLocationMode(boolean z16) {
        this.mIndoorLocationMode = z16;
        return this;
    }

    public TencentLocationRequest setInterval(long j3) {
        if (j3 >= 0) {
            this.mInterval = j3;
            return this;
        }
        throw new IllegalArgumentException("interval should >= 0");
    }

    public TencentLocationRequest setLocationDomainMode(int i3) {
        this.mRequestDomainMode = i3;
        return this;
    }

    public TencentLocationRequest setOpenId(String str) {
        this.mOpenId = str;
        return this;
    }

    public TencentLocationRequest setQQ(String str) {
        this.mQQ = str;
        return this;
    }

    public TencentLocationRequest setRequestLevel(int i3) {
        if (isAllowedLevel(i3)) {
            this.mRequestLevel = i3;
            return this;
        }
        throw new IllegalArgumentException("request_level: " + i3 + " not supported!");
    }

    public TencentLocationRequest setSmallAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mSmallAppKey = str;
        }
        return this;
    }

    public void setmExpirationTime(long j3) {
        this.mExpirationTime = j3;
    }

    public String toString() {
        return "TencentLocationRequest {interval=" + this.mInterval + "ms,level=" + this.mRequestLevel + ",allowCache=" + this.mAllowCache + ",allowGps=" + this.mAllowGps + ",allowDirection=" + this.mAllowDirection + ",QQ=" + this.mQQ + ",DomainMode=" + this.mRequestDomainMode + ",openId=" + this.mOpenId + "}";
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        this.mInterval = tencentLocationRequest.mInterval;
        this.mRequestLevel = tencentLocationRequest.mRequestLevel;
        this.mAllowCache = tencentLocationRequest.mAllowCache;
        this.mAllowDirection = tencentLocationRequest.mAllowDirection;
        this.mExpirationTime = tencentLocationRequest.mExpirationTime;
        this.mNumUpdates = tencentLocationRequest.mNumUpdates;
        this.mAllowGps = tencentLocationRequest.mAllowGps;
        this.mIndoorLocationMode = tencentLocationRequest.mIndoorLocationMode;
        this.mRequestDomainMode = tencentLocationRequest.mRequestDomainMode;
        this.mQQ = tencentLocationRequest.mQQ;
        this.mSmallAppKey = tencentLocationRequest.mSmallAppKey;
        this.mOpenId = tencentLocationRequest.mOpenId;
        Bundle bundle = new Bundle();
        this.mExtras = bundle;
        bundle.putAll(tencentLocationRequest.mExtras);
    }
}
