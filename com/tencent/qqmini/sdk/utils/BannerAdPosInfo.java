package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class BannerAdPosInfo {
    public static final int BANNER_MIN_WIDTH = WnsUtil.getBannerAdMinWidth();
    public static final int BANNER_UPDATE_SIZE_LEFT = 1;
    public static final int BANNER_UPDATE_SIZE_NO = -1;
    public static final int BANNER_UPDATE_SIZE_TOP = 2;
    public static final int BANNER_UPDATE_SIZE_WIDTH = 3;
    private static final String TAG = "BannerAdPosInfo";
    public int mAdHeight;
    public int mAdIntervals;
    public int mAdLeft;
    public int mAdRealHeight;
    public int mAdRealWidth;
    public int mAdTop;
    public String mAdUnitId;
    public int mAdWidth;

    BannerAdPosInfo(String str, int i3, int i16, int i17, int i18, int i19) {
        this.mAdUnitId = str;
        this.mAdLeft = i3;
        this.mAdTop = i16;
        this.mAdWidth = i17;
        this.mAdHeight = i18;
        this.mAdRealWidth = i17;
        this.mAdRealHeight = i18;
        this.mAdIntervals = i19;
    }

    public static BannerAdPosInfo buildFormatInfo(BannerAdPosInfo bannerAdPosInfo, int i3, float f16, int i16, int i17) {
        if (bannerAdPosInfo != null && f16 != 0.0f) {
            int calculateLegalWidth = calculateLegalWidth(bannerAdPosInfo.mAdWidth, i3, f16, i16, i17);
            return new BannerAdPosInfo(bannerAdPosInfo.mAdUnitId, bannerAdPosInfo.mAdLeft, bannerAdPosInfo.mAdTop, bannerAdPosInfo.mAdWidth, bannerAdPosInfo.mAdHeight, calculateLegalWidth, Double.valueOf(((calculateLegalWidth * 1.0d) / 1026.0d) * 249.0d).intValue(), bannerAdPosInfo.mAdIntervals);
        }
        return null;
    }

    public static int calculateLegalWidth(int i3, int i16, float f16, int i17, int i18) {
        if (f16 == 0.0f) {
            return i3;
        }
        int i19 = BANNER_MIN_WIDTH;
        if (i3 >= i19) {
            i19 = i3;
        }
        int round = Math.round((i17 * 1.0f) / f16);
        int round2 = Math.round((i18 * 1.0f) / f16);
        if (i16 != 1) {
            if (i16 == 2) {
                if (round < round2) {
                    round2 = round;
                    round = round2;
                }
                int i26 = round / 2;
                if (i19 > i26) {
                    i19 = i26;
                }
            }
        } else {
            if (round2 < round) {
                round2 = round;
                round = round2;
            }
            if (i19 > round) {
                i19 = round;
            }
        }
        QMLog.i(TAG, "buildFormatInfo\uff0cdeviceOrientation = " + i16 + ", density = " + f16 + ", screeWpx = " + i17 + ", screeHpx = " + i18 + ", screenW = " + round + ", screenH = " + round2 + ", originWidth = " + i3 + ", realWidth = " + i19);
        return i19;
    }

    public static int getHeight(int i3) {
        return Double.valueOf(((i3 * 1.0d) / 1026.0d) * 249.0d).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BannerAdPosInfo parseBannerAdPosInfoFromJson(String str) {
        int i3;
        int i16;
        int i17;
        int i18;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "";
        int i19 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            str3 = jSONObject.getString("adUnitId");
            i16 = jSONObject.getJSONObject("style").getInt("left");
            try {
                i17 = jSONObject.getJSONObject("style").getInt("top");
                try {
                    i18 = jSONObject.getJSONObject("style").getInt("width");
                    try {
                        if (jSONObject.getJSONObject("style").has("height")) {
                            i3 = jSONObject.getJSONObject("style").getInt("height");
                        } else {
                            i3 = 0;
                        }
                        try {
                            if (jSONObject.has("adIntervals") && jSONObject.getInt("adIntervals") > 0) {
                                i19 = jSONObject.getInt("adIntervals");
                            }
                        } catch (Exception e16) {
                            e = e16;
                            QMLog.i(TAG, "parseBannerAdPosInfoFromJson error " + str, e);
                            int i26 = i3;
                            str2 = str3;
                            int i27 = i19;
                            int i28 = i16;
                            int i29 = i17;
                            int i36 = i18;
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            return null;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        i3 = 0;
                    }
                } catch (Exception e18) {
                    e = e18;
                    i3 = 0;
                    i18 = 0;
                }
            } catch (Exception e19) {
                e = e19;
                i3 = 0;
                i17 = 0;
                i18 = i17;
                QMLog.i(TAG, "parseBannerAdPosInfoFromJson error " + str, e);
                int i262 = i3;
                str2 = str3;
                int i272 = i19;
                int i282 = i16;
                int i292 = i17;
                int i362 = i18;
                if (!TextUtils.isEmpty(str2)) {
                }
                return null;
            }
        } catch (Exception e26) {
            e = e26;
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        int i2622 = i3;
        str2 = str3;
        int i2722 = i19;
        int i2822 = i16;
        int i2922 = i17;
        int i3622 = i18;
        if (!TextUtils.isEmpty(str2) || i2822 < 0 || i2922 < 0 || i3622 <= 0) {
            return null;
        }
        return new BannerAdPosInfo(str2, i2822, i2922, i3622, i2622, i2722);
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.mAdUnitId) && this.mAdRealWidth > 0 && this.mAdRealHeight > 0) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.mAdUnitId = "";
        this.mAdLeft = 0;
        this.mAdTop = 0;
        this.mAdWidth = 0;
        this.mAdHeight = 0;
        this.mAdRealWidth = 0;
        this.mAdRealHeight = 0;
    }

    public String toString() {
        return "mAdUnitId = " + this.mAdUnitId + ", left = " + this.mAdLeft + ", top = " + this.mAdTop + ", width = " + this.mAdWidth + ", height = " + this.mAdHeight + ", realWidth = " + this.mAdRealWidth + ", realHeight = " + this.mAdRealHeight;
    }

    public BannerAdPosInfo(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        this.mAdUnitId = str;
        this.mAdLeft = i3;
        this.mAdTop = i16;
        this.mAdWidth = i17;
        this.mAdHeight = i18;
        this.mAdRealWidth = i19;
        this.mAdRealHeight = i26;
        this.mAdIntervals = i27;
    }
}
