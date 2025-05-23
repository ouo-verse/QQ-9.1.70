package com.tencent.qcircle.weseevideo.model.template.light;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.publisher.interfaces.XffectsDownloadListener;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes22.dex */
public class LightPatterHelper {
    public static final float DEFAULT_LATITUDE = 9.0E8f;
    public static final float DEFAULT_LONGITUDE = 9.0E8f;
    public static final String DEFAULT_NICKNAME = "\u5fae\u89c6\u7528\u6237";
    public static final String FORMAT_DAY_IN_CHINESE = "date.d.zh_Hans";
    public static final String FORMAT_WEEK_IN_CHINESE = "date.EEE.zh_Hans";
    public static final String FORMAT_YEAR_IN_CHINESE = "date.yyyy.zh_Hans";
    public static final String KEY_AVATAR = "user.avatar";
    public static final String KEY_DATE = "date";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_LOCATION_CITY = "location.city";
    public static final String KEY_LOCATION_COUNTRY = "location.country";
    public static final String KEY_LOCATION_LATITUDE = "location.latitude";
    public static final String KEY_LOCATION_LONGITUDE = "location.longitude";
    public static final String KEY_LOCATION_PROVINCE = "location.province";
    public static final String KEY_NICKNAME = "user.nickname";
    public static final String KEY_WATERMARK = "watermark";
    public static final String KEY_WEATHER = "weather";
    public static final String KEY_WEATHER_NAME = "weather.name";
    public static final String KEY_WEATHER_TEMPERATURE = "weather.temperature";
    private static final String TAG = "LightPatterHelper";
    private static String[] numbs = {"\u96f6", "\u4e00", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d"};
    private static String[] pos_units = {"", "\u5341", "\u767e", "\u5343"};
    private static String[] weight_units = {"", "\u4e07", "\u4ebf"};

    @VisibleForTesting
    protected static HashMap<String, String> mDownloadImageMap = new HashMap<>();

    public static void fillAvatar(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, XffectsDownloadListener xffectsDownloadListener) {
        if (hashMap != null) {
            hashMap.containsKey(KEY_AVATAR);
        }
    }

    public static void fillDate(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        if (hashMap != null && !hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                if (str.startsWith("date")) {
                    String dateValueByKey = getDateValueByKey(str);
                    if (!TextUtils.isEmpty(dateValueByKey)) {
                        hashMap2.put(str, dateValueByKey);
                    }
                }
            }
        }
    }

    private static String format(Date date, String str, String str2) {
        try {
            Logger.d(TAG, "Date format: " + str + ", locale : " + str2);
            return new SimpleDateFormat(str, LocaleUtils.getLocale(str2)).format(date);
        } catch (Exception e16) {
            Logger.e(TAG, "", e16);
            return null;
        }
    }

    @VisibleForTesting
    protected static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    private static String getDateValueByKey(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            Logger.i(TAG, "fillDate >> presetData\u4e2d\u6ca1\u6709date\u4fe1\u606f.");
            return null;
        }
        if (FORMAT_YEAR_IN_CHINESE.equals(str)) {
            return getYearInChinese(getDateValueByKey("date.yyyy"));
        }
        if (FORMAT_WEEK_IN_CHINESE.equals(str)) {
            return getWeekChinese(getCurrentDate());
        }
        if (FORMAT_DAY_IN_CHINESE.equals(str)) {
            return numberToChinese(Integer.parseInt(getDateValueByKey("date.d")));
        }
        String[] split = str.split("\\.");
        if (split.length < 2) {
            Logger.e(TAG, "fillDate >> \u65e5\u671fkey\u683c\u5f0f\u4e0d\u5bf9. dateKey\uff1a" + str + ". spiltFormats:" + split);
            return null;
        }
        String str3 = split[1];
        if (split.length >= 3) {
            str2 = split[2];
        } else {
            str2 = "";
        }
        return format(getCurrentDate(), str3, str2);
    }

    public static String getWeekChinese(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (calendar.get(7)) {
            case 1:
                return "\u5468\u65e5";
            case 2:
                return "\u5468\u4e00";
            case 3:
                return "\u5468\u4e8c";
            case 4:
                return "\u5468\u4e09";
            case 5:
                return "\u5468\u56db";
            case 6:
                return "\u5468\u4e94";
            default:
                return "\u5468\u516d";
        }
    }

    private static String getYearInChinese(String str) {
        try {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < str.length(); i3++) {
                sb5.append(numbs[Integer.parseInt(String.valueOf(str.charAt(i3)))]);
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String numberToChinese(int i3) {
        if (i3 == 0) {
            return "\u96f6";
        }
        String str = "";
        boolean z16 = false;
        int i16 = 0;
        while (i3 > 0) {
            int i17 = i3 % 10000;
            if (z16) {
                str = numbs[0] + str;
            }
            String sectionTrans = sectionTrans(i17);
            if (i17 != 0) {
                sectionTrans = sectionTrans + weight_units[i16];
            }
            str = sectionTrans + str;
            Logger.d(TAG, "");
            if (i17 < 1000 && i17 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            i3 /= 10000;
            i16++;
        }
        if ((str.length() == 2 || str.length() == 3) && str.contains("\u4e00\u5341")) {
            str = str.substring(1, str.length());
        }
        if (str.indexOf("\u4e00\u5341") == 0) {
            return str.replaceFirst("\u4e00\u5341", "\u5341");
        }
        return str;
    }

    public static String sectionTrans(int i3) {
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        boolean z16 = true;
        while (i3 > 0) {
            int i17 = i3 % 10;
            if (i17 == 0) {
                if (!z16) {
                    sb5.insert(0, numbs[0]);
                    z16 = true;
                }
            } else {
                sb5.insert(0, pos_units[i16]);
                sb5.insert(0, numbs[i17]);
                z16 = false;
            }
            i16++;
            i3 /= 10;
        }
        return sb5.toString();
    }

    public static void fillLocation(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
    }

    public static void fillNickName(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
    }

    public static void fillWatermark(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
    }

    public static void fillWeather(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
    }
}
