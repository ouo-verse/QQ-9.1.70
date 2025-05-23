package com.tencent.qcircle.tavcut.util;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TimeFormatUtil {
    public static String getDuration(long j3) {
        long round = Math.round(((float) j3) / 1000.0f);
        long j16 = round % 60;
        long j17 = (round / 60) % 60;
        long j18 = (round / 3600) % 24;
        if (j18 > 0) {
            return String.format(Locale.getDefault(), "%d:%02d:%02d", Long.valueOf(j18), Long.valueOf(j17), Long.valueOf(j16));
        }
        if (j3 < 1000 && j3 > 0) {
            j16 = 1;
        }
        return String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(j17), Long.valueOf(j16));
    }

    public static String getDurationSecondsChinese(long j3) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(((float) j3) / 1000.0f) + "\u79d2";
    }

    public static String getDurationSecondsEnglish(long j3) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(((float) j3) / 1000.0f) + ReportConstant.COSTREPORT_PREFIX;
    }
}
