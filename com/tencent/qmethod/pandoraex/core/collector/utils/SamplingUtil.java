package com.tencent.qmethod.pandoraex.core.collector.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qmethod.pandoraex.core.s;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SamplingUtil {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum SamplingResult {
        REPORT,
        REPEAT_LIMIT,
        SAMPLING_LIMIT,
        DEBUG_LIMIT,
        PROCESS_LIMIT,
        USER_ALLOW_LIMIT,
        OTHER_LIMIT
    }

    private static void a(Context context) {
        context.getSharedPreferences("sp_app_report", 4).edit().putBoolean("is_first_startup", false).apply();
    }

    private static SamplingResult b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_app_report", 4);
        if (sharedPreferences == null) {
            return SamplingResult.OTHER_LIMIT;
        }
        if (!sharedPreferences.getBoolean("is_first_startup", true)) {
            return SamplingResult.REPEAT_LIMIT;
        }
        return SamplingResult.REPORT;
    }

    public static SamplingResult c(Context context, int i3) {
        SamplingResult b16 = b(context);
        SamplingResult samplingResult = SamplingResult.REPORT;
        if (b16 != samplingResult) {
            return b16;
        }
        if (!s.b()) {
            return SamplingResult.USER_ALLOW_LIMIT;
        }
        if (!a.j(context)) {
            return SamplingResult.PROCESS_LIMIT;
        }
        if (a.i(context)) {
            return SamplingResult.DEBUG_LIMIT;
        }
        Random random = new Random();
        if (random.nextInt(i3) >= 1) {
            return SamplingResult.SAMPLING_LIMIT;
        }
        if (i3 < 100 && random.nextInt(100) >= 1) {
            return SamplingResult.SAMPLING_LIMIT;
        }
        a(context);
        return samplingResult;
    }
}
