package com.tencent.mobileqq.minigame.data;

import android.text.TextUtils;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class BannerAdPosInfo {
    public static final int BANNER_MIN_WIDTH = GameWnsUtils.getBannerAdMinWidth();
    public static final int BANNER_UPDATE_SIZE_LEFT = 1;
    public static final int BANNER_UPDATE_SIZE_NO = -1;
    public static final int BANNER_UPDATE_SIZE_TOP = 2;
    public static final int BANNER_UPDATE_SIZE_WIDTH = 3;
    private static final String TAG = "BannerAdPosInfo";
    public int mAdHeight;
    public int mAdLeft;
    public int mAdRealHeight;
    public int mAdRealWidth;
    public int mAdTop;
    public String mAdUnitId;
    public int mAdWidth;

    BannerAdPosInfo(String str, int i3, int i16, int i17, int i18) {
        this.mAdUnitId = str;
        this.mAdLeft = i3;
        this.mAdTop = i16;
        this.mAdWidth = i17;
        this.mAdHeight = i18;
        this.mAdRealWidth = i17;
        this.mAdRealHeight = i18;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0078 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BannerAdPosInfo parseBannerAdPosInfoFromJson(String str) {
        int i3;
        int i16;
        int i17;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "";
        int i18 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            str3 = jSONObject.getString("adUnitId");
            i3 = jSONObject.getJSONObject("style").getInt("left");
            try {
                i16 = jSONObject.getJSONObject("style").getInt("top");
                try {
                    i17 = jSONObject.getJSONObject("style").getInt("width");
                    try {
                        i18 = jSONObject.getJSONObject("style").getInt("height");
                    } catch (Exception e16) {
                        e = e16;
                        QLog.i(TAG, 2, "parseBannerAdPosInfoFromJson error " + str, e);
                        str2 = str3;
                        int i19 = i18;
                        int i26 = i3;
                        int i27 = i16;
                        int i28 = i17;
                        if (TextUtils.isEmpty(str2)) {
                        }
                        return null;
                    }
                } catch (Exception e17) {
                    e = e17;
                    i17 = 0;
                }
            } catch (Exception e18) {
                e = e18;
                i16 = 0;
                i17 = i16;
                QLog.i(TAG, 2, "parseBannerAdPosInfoFromJson error " + str, e);
                str2 = str3;
                int i192 = i18;
                int i262 = i3;
                int i272 = i16;
                int i282 = i17;
                if (TextUtils.isEmpty(str2)) {
                }
                return null;
            }
        } catch (Exception e19) {
            e = e19;
            i3 = 0;
            i16 = 0;
        }
        str2 = str3;
        int i1922 = i18;
        int i2622 = i3;
        int i2722 = i16;
        int i2822 = i17;
        if (!TextUtils.isEmpty(str2) || i2622 < 0 || i2722 < 0 || i2822 <= 0) {
            return null;
        }
        return new BannerAdPosInfo(str2, i2622, i2722, i2822, i1922);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mAdUnitId) && this.mAdRealWidth > 0 && this.mAdRealHeight > 0;
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
        if (i16 == 0) {
            if (round2 < round) {
                round2 = round;
                round = round2;
            }
            if (i19 > round) {
                i19 = round;
            }
        } else if (i16 == 90) {
            if (round < round2) {
                round2 = round;
                round = round2;
            }
            int i26 = round / 2;
            if (i19 > i26) {
                i19 = i26;
            }
        }
        QLog.i(TAG, 2, "buildFormatInfo\uff0cdeviceOrientation = " + i16 + ", density = " + f16 + ", screeWpx = " + i17 + ", screeHpx = " + i18 + ", screenW = " + round + ", screenH = " + round2 + ", originWidth = " + i3 + ", realWidth = " + i19);
        return i19;
    }

    public BannerAdPosInfo(String str, int i3, int i16, int i17, int i18, int i19, int i26) {
        this.mAdUnitId = str;
        this.mAdLeft = i3;
        this.mAdTop = i16;
        this.mAdWidth = i17;
        this.mAdHeight = i18;
        this.mAdRealWidth = i19;
        this.mAdRealHeight = i26;
    }

    public static BannerAdPosInfo buildFormatInfo(BannerAdPosInfo bannerAdPosInfo, int i3, float f16, int i16, int i17) {
        if (bannerAdPosInfo == null || f16 == 0.0f) {
            return null;
        }
        int calculateLegalWidth = calculateLegalWidth(bannerAdPosInfo.mAdWidth, i3, f16, i16, i17);
        return new BannerAdPosInfo(bannerAdPosInfo.mAdUnitId, bannerAdPosInfo.mAdLeft, bannerAdPosInfo.mAdTop, bannerAdPosInfo.mAdWidth, bannerAdPosInfo.mAdHeight, calculateLegalWidth, GdtBannerViewBuilder.getHeight(calculateLegalWidth));
    }
}
