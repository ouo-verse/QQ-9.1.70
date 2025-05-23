package com.huya.huyasdk.api;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaLoginResult {
    public static final int ERROR_ACCESS_TOKEN_EMPTY = -6;
    public static final int ERROR_CODE_CONFIG_NULL = -7;
    public static final int ERROR_CODE_EMPTY = -1;
    public static final int ERROR_OPEN_ID_EMPTY = -5;
    public static final int ERROR_OP_CMD = -4;
    public static final int ERROR_RET_DATA_NULL = -2;
    public static final int ERROR_RET_DATA_TYPE_ERROR = -3;
    public final String accessToken;
    public final boolean isSucceed;
    public final String openID;
    public final int resCode;
    public final long uid;

    public HuyaLoginResult(boolean z16, int i3, String str, String str2, long j3) {
        this.isSucceed = z16;
        this.resCode = i3;
        this.openID = str;
        this.accessToken = str2;
        this.uid = j3;
    }

    public static HuyaLoginResult failWithResCode(int i3) {
        return new HuyaLoginResult(false, i3, "", "", 0L);
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getOpenID() {
        return this.openID;
    }

    public int getResCode() {
        return this.resCode;
    }

    public long getUid() {
        return this.uid;
    }

    public boolean isSucceed() {
        return this.isSucceed;
    }

    public String toString() {
        return "HuyaLoginResult{isSucceed=" + this.isSucceed + ", resCode=" + this.resCode + ", openID='" + this.openID + "', accessToken='" + this.accessToken + "', uid='" + this.uid + "'}";
    }
}
