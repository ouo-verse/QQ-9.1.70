package com.tencent.mobileqq.vas.profilecard.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconBusiness;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LevelUtil {
    public static final String PROFILE_CARD_TAG = "Q.profilecard.FrdProfileCard";
    public static int QQ_LEVEL_TYPE_CROWN = 4;
    public static int QQ_LEVEL_TYPE_HALF_STAR = 0;
    public static int QQ_LEVEL_TYPE_MOON = 2;
    public static int QQ_LEVEL_TYPE_STAR = 1;
    public static int QQ_LEVEL_TYPE_SUN = 3;

    public static String getQQLevelIconPathByType(int i3, int i16) {
        String savePath = ((QQLevelIconBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(QQLevelIconBusiness.class)).getSavePath(i3);
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 != 5) {
                                return "_";
                            }
                            return savePath + "/more.png";
                        }
                        return savePath + "/crown.png";
                    }
                    return savePath + "/sun.png";
                }
                return savePath + "/moon.png";
            }
            return savePath + "/star.png";
        }
        return savePath + "/half.png";
    }

    private static String parseLevelSerialString(int i3, int i16, int i17, int i18) {
        String str;
        int i19;
        String str2 = "";
        for (int i26 = 0; i26 < 4; i26++) {
            if (i26 != 0) {
                if (i26 != 1) {
                    if (i26 != 2) {
                        if (i26 != 3) {
                            str = "";
                            i19 = 0;
                        } else {
                            str = "%";
                            i19 = i18;
                        }
                    } else {
                        str = "#";
                        i19 = i17;
                    }
                } else {
                    str = "@";
                    i19 = i16;
                }
            } else {
                str = "!";
                i19 = i3;
            }
            for (int i27 = 0; i27 < i19; i27++) {
                str2 = str2 + str;
            }
        }
        return str2;
    }

    public static SpannableString parseQQLevel(Context context, int i3, int i16, int i17, boolean z16) {
        return parseQQLevel(context, i3, i16, i17, z16, (int) context.getResources().getDimension(R.dimen.f159035ui));
    }

    private static void transCharToIconDrawable(Context context, int i3, String str, SpannableString spannableString, int i16) {
        for (int i17 = 0; i17 < str.length(); i17++) {
            Drawable transEachIcon = transEachIcon(context, i3, str, i17);
            if (transEachIcon != null) {
                transEachIcon.setBounds(0, 0, i16, i16);
                transEachIcon.clearColorFilter();
                spannableString.setSpan(new ImageSpan(transEachIcon), i17, i17 + 1, 33);
            }
        }
    }

    private static Drawable transEachIcon(Context context, int i3, String str, int i16) {
        Drawable drawable = null;
        try {
            int i17 = i16 + 1;
            if ("!".equalsIgnoreCase(str.substring(i16, i17))) {
                drawable = VasApngUtil.getOptimizedApngDrawable(getQQLevelIconPathByType(i3, QQ_LEVEL_TYPE_CROWN), context.getResources().getDrawable(R.drawable.hav), VasApngUtil.VIP_APNG_TAGS, "crown");
            }
            if ("@".equalsIgnoreCase(str.substring(i16, i17))) {
                drawable = VasApngUtil.getOptimizedApngDrawable(getQQLevelIconPathByType(i3, QQ_LEVEL_TYPE_SUN), context.getResources().getDrawable(R.drawable.haz), VasApngUtil.VIP_APNG_TAGS, "sun");
            }
            if ("#".equalsIgnoreCase(str.substring(i16, i17))) {
                drawable = VasApngUtil.getOptimizedApngDrawable(getQQLevelIconPathByType(i3, QQ_LEVEL_TYPE_MOON), context.getResources().getDrawable(R.drawable.haw), VasApngUtil.VIP_APNG_TAGS, "moon");
            }
            if ("%".equalsIgnoreCase(str.substring(i16, i17))) {
                return VasApngUtil.getOptimizedApngDrawable(getQQLevelIconPathByType(i3, QQ_LEVEL_TYPE_STAR), context.getResources().getDrawable(R.drawable.hay), VasApngUtil.VIP_APNG_TAGS, "star");
            }
            return drawable;
        } catch (Error e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(PROFILE_CARD_TAG, 2, e16.toString());
            return null;
        } catch (Exception e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(PROFILE_CARD_TAG, 2, e17.toString());
            return null;
        }
    }

    public static SpannableString parseQQLevel(Context context, int i3, int i16, int i17, boolean z16, int i18) {
        QQLevelIconBusiness qQLevelIconBusiness = (QQLevelIconBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(QQLevelIconBusiness.class);
        if (!qQLevelIconBusiness.isFileExists(i16)) {
            qQLevelIconBusiness.startDownload(i16);
        }
        if (i17 == 0) {
            SpannableString spannableString = new SpannableString("*");
            Drawable optimizedApngDrawable = VasApngUtil.getOptimizedApngDrawable(getQQLevelIconPathByType(i16, QQ_LEVEL_TYPE_HALF_STAR), context.getResources().getDrawable(R.drawable.hax), VasApngUtil.VIP_APNG_TAGS, "halfstar");
            optimizedApngDrawable.setBounds(0, 0, i18, i18);
            optimizedApngDrawable.clearColorFilter();
            spannableString.setSpan(new ImageSpan(optimizedApngDrawable), 0, 1, 33);
            return spannableString;
        }
        int i19 = i17 / 64;
        int i26 = i17 % 64;
        int i27 = i26 / 16;
        int i28 = i26 % 16;
        String parseLevelSerialString = parseLevelSerialString(i19, i27, i28 / 4, i28 % 4);
        if (z16) {
            try {
                if (parseLevelSerialString.length() > i3) {
                    parseLevelSerialString = parseLevelSerialString.substring(0, i3);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        SpannableString spannableString2 = new SpannableString(parseLevelSerialString);
        transCharToIconDrawable(context, i16, parseLevelSerialString, spannableString2, i18);
        return spannableString2;
    }
}
