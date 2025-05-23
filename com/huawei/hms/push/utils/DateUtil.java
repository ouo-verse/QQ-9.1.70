package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DateUtil {
    public static String parseMilliSecondToString(Long l3) {
        if (l3 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(l3);
        } catch (Exception e16) {
            HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", e16);
            return null;
        }
    }

    public static long parseUtcToMillisecond(String str) throws ParseException, StringIndexOutOfBoundsException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.parse(str.substring(0, str.indexOf(".")) + (str.substring(str.indexOf(".")).substring(0, 4) + "Z")).getTime();
    }
}
