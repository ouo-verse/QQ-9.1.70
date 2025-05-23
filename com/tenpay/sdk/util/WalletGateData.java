package com.tenpay.sdk.util;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WalletGateData {
    private static final String TAG = "WalletGateData";
    private static WalletGateData sIntance = new WalletGateData();
    private long mSysTimeStamp;
    private long mTimeStamp;
    private String mUin;
    private JSONObject mWalletGateObj;
    private long mValidTimeWindow = 5000;
    private boolean mIsDataCleared = false;

    WalletGateData() {
    }

    public static WalletGateData getInstance() {
        return sIntance;
    }

    private void setData(String str, JSONObject jSONObject) {
        this.mUin = str;
        this.mWalletGateObj = jSONObject;
        this.mIsDataCleared = false;
    }

    public void clear() {
        this.mWalletGateObj = null;
        this.mTimeStamp = 0L;
        this.mIsDataCleared = true;
    }

    public JSONObject getData() {
        if (isDataValid()) {
            return this.mWalletGateObj;
        }
        return null;
    }

    public long getSysTimeStamp() {
        return this.mSysTimeStamp;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getUin() {
        return this.mUin;
    }

    public long getValidTimeWindow() {
        return this.mValidTimeWindow;
    }

    public boolean hasRealName() {
        JSONObject jSONObject = this.mWalletGateObj;
        if (jSONObject == null) {
            return false;
        }
        int optInt = jSONObject.optInt("user_attr");
        if (optInt != 1 && optInt != 2) {
            return false;
        }
        return true;
    }

    public boolean isDataCleared() {
        return this.mIsDataCleared;
    }

    public boolean isDataValid() {
        if (System.currentTimeMillis() - this.mTimeStamp <= this.mValidTimeWindow) {
            return true;
        }
        return false;
    }

    public void setData(String str, JSONObject jSONObject, long j3) {
        setData(str, jSONObject);
        this.mTimeStamp = j3;
        this.mSysTimeStamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
        int optInt = jSONObject.optInt("time_window", -1);
        if (optInt != -1) {
            this.mValidTimeWindow = optInt * 1000;
        }
    }
}
