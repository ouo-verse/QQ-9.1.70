package com.tencent.mobileqq.profilecard.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.ttpic.openapi.filter.LightConstants;

/* loaded from: classes35.dex */
public class ZPlanProfileAvatarUtils {
    private static final int GENDER_NO_CARD_INFO = -888;
    private static final String GENDER_NO_CARD_INFO_URL = "transparent_drawable_url";
    private static final String SERVER_UNAVAILABLE_FEMALE = "https://image.superqqshow.qq.com/qq/downqq/zplan_stop_serving_female.png";
    private static final String SERVER_UNAVAILABLE_MALE = "https://image.superqqshow.qq.com/qq/downqq/zplan_stop_serving_male.png";
    private static final String TAG = "ZPlanProfileViewUtils";

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r7 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (r7 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDefaultUrl(ProfileCardInfo profileCardInfo, boolean z16, boolean z17) {
        String str;
        String staticDefaultUrlFromConfig;
        int gender = getGender(profileCardInfo);
        if (gender == GENDER_NO_CARD_INFO) {
            str = GENDER_NO_CARD_INFO_URL;
        } else if (gender == 0) {
            str = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getStaticDefaultUrlFromConfig(LightConstants.MALE, MiniAppConst.MENU_STYLE_LIGHT);
            staticDefaultUrlFromConfig = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getStaticDefaultUrlFromConfig(LightConstants.MALE, MiniAppConst.MENU_STYLE_DARK);
            if (z16) {
                str = SERVER_UNAVAILABLE_MALE;
            }
        } else if (gender != 1) {
            str = "";
        } else {
            str = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getStaticDefaultUrlFromConfig(LightConstants.FEMALE, MiniAppConst.MENU_STYLE_LIGHT);
            staticDefaultUrlFromConfig = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getStaticDefaultUrlFromConfig(LightConstants.FEMALE, MiniAppConst.MENU_STYLE_DARK);
            if (z16) {
                str = SERVER_UNAVAILABLE_FEMALE;
            }
        }
        QLog.d(TAG, 1, "[getDefaultUrl] url=" + str);
        return str;
    }

    public static Drawable getDrawable(String str, boolean z16) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (GENDER_NO_CARD_INFO_URL.equals(str)) {
            QLog.d(TAG, 1, "[getDrawable] return transparent url");
            return colorDrawable;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        URLDrawable uRLDrawable = null;
        try {
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getDrawable: " + str, th5);
        }
        if (z16) {
            return URLDrawable.getFileDrawable(str, obtain);
        }
        uRLDrawable = URLDrawable.getDrawable(str, obtain);
        if (uRLDrawable.getStatus() == 2) {
            uRLDrawable.restartDownload();
        }
        return uRLDrawable;
    }

    public static int getGender(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo == null || (card = profileCardInfo.card) == null) {
            return GENDER_NO_CARD_INFO;
        }
        short s16 = card.shGender;
        if (s16 == 1 || s16 == 0) {
            return s16;
        }
        return 1;
    }

    public static String getZplanUrl(ProfileCardInfo profileCardInfo, boolean z16) {
        Card card;
        if (profileCardInfo == null || (card = profileCardInfo.card) == null) {
            return null;
        }
        if (z16) {
            String str = card.strZPlanNightUrl;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return profileCardInfo.card.strZplanDayUrl;
    }
}
