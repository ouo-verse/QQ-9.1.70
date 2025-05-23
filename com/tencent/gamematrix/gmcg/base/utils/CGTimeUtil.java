package com.tencent.gamematrix.gmcg.base.utils;

import com.heytap.databaseengine.utils.DateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGTimeUtil {
    public static String getCurrentInString() {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date());
    }

    public static long getSecondsFromFormatString(String str) {
        long j3 = 0;
        if (CGStringUtil.isEmpty(str)) {
            return 0L;
        }
        long j16 = 0;
        int i3 = 0;
        long j17 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (Character.isDigit(charAt)) {
                int numericValue = Character.getNumericValue(charAt);
                if (i3 == 0) {
                    j16 += numericValue;
                }
                if (i3 == 1) {
                    j16 += numericValue * 10;
                }
                if (i3 == 2) {
                    j17 += numericValue;
                }
                if (i3 == 3) {
                    j17 += numericValue * 10;
                }
                if (i3 == 4) {
                    j3 += numericValue;
                }
                if (i3 == 5) {
                    j3 += numericValue * 10;
                }
                i3++;
            }
        }
        return (j3 * 60 * 60) + (j17 * 60) + j16;
    }
}
