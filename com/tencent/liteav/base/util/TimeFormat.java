package com.tencent.liteav.base.util;

import com.tencent.liteav.base.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimeFormat {
    public static String format(long j3, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(j3));
        } catch (Exception e16) {
            Log.i("TimeFormat", "toString: Date conversion failed.", e16);
            return "";
        }
    }

    public static long fromString(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat(str2).parse(str);
            if (parse == null) {
                return 0L;
            }
            return parse.getTime();
        } catch (Exception e16) {
            Log.i("TimeFormat", "formString: Date conversion failed.", e16);
            return 0L;
        }
    }
}
