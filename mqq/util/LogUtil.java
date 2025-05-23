package mqq.util;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LogUtil {
    public static String getSafePrintUin(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 3) {
            return str.substring(0, 3);
        }
        return "invalid uin";
    }

    public static String wrapLogUin(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 4) {
            return str.substring(0, 4) + "*";
        }
        return str;
    }
}
