package com.tencent.raft.measure.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.measure.config.RAFTComConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class SamplingUtil {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_APP_REPORT_COUNT = 25;
    private static final int MAX_COM_REPORT_COUNT = 10;
    private static final int MAX_KEY_REPORT_COUNT = 5;
    private static final String SPLIT_SHARE = "&";
    private static final String SP_APP_REPORT = "SP_APP_REPORT";
    private static final String SP_DATE = "SP_DATE";
    private static final List<String> START_UP_LIST;
    public static final int START_UP_SAMPLING_RATE = 5;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class SamplingResult {
        private static final /* synthetic */ SamplingResult[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SamplingResult APP_LIMIT;
        public static final SamplingResult COM_LIMIT;
        public static final SamplingResult COM_RATE_LIMIT;
        public static final SamplingResult KEY_LIMIT;
        public static final SamplingResult REPEAT_LIMIT;
        public static final SamplingResult REPORT;
        public static final SamplingResult SLI_LIMIT;
        public static final SamplingResult START_UP_RATE_LIMIT;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12080);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            SamplingResult samplingResult = new SamplingResult("REPORT", 0);
            REPORT = samplingResult;
            SamplingResult samplingResult2 = new SamplingResult("APP_LIMIT", 1);
            APP_LIMIT = samplingResult2;
            SamplingResult samplingResult3 = new SamplingResult("SLI_LIMIT", 2);
            SLI_LIMIT = samplingResult3;
            SamplingResult samplingResult4 = new SamplingResult("COM_LIMIT", 3);
            COM_LIMIT = samplingResult4;
            SamplingResult samplingResult5 = new SamplingResult("KEY_LIMIT", 4);
            KEY_LIMIT = samplingResult5;
            SamplingResult samplingResult6 = new SamplingResult("COM_RATE_LIMIT", 5);
            COM_RATE_LIMIT = samplingResult6;
            SamplingResult samplingResult7 = new SamplingResult("START_UP_RATE_LIMIT", 6);
            START_UP_RATE_LIMIT = samplingResult7;
            SamplingResult samplingResult8 = new SamplingResult("REPEAT_LIMIT", 7);
            REPEAT_LIMIT = samplingResult8;
            $VALUES = new SamplingResult[]{samplingResult, samplingResult2, samplingResult3, samplingResult4, samplingResult5, samplingResult6, samplingResult7, samplingResult8};
        }

        SamplingResult(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static SamplingResult valueOf(String str) {
            return (SamplingResult) Enum.valueOf(SamplingResult.class, str);
        }

        public static SamplingResult[] values() {
            return (SamplingResult[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12107);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            START_UP_LIST = Collections.synchronizedList(new ArrayList());
        }
    }

    SamplingUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addLimitToSP(Context context, RAFTComConfig rAFTComConfig, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SLIReport", 4);
        checkSPDate(sharedPreferences);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(SP_APP_REPORT, sharedPreferences.getInt(SP_APP_REPORT, 0) + 1);
        edit.putInt(rAFTComConfig.getUniKey(), sharedPreferences.getInt(rAFTComConfig.getUniKey(), 0) + 1);
        edit.putInt(rAFTComConfig.getUniKey() + "&" + str, sharedPreferences.getInt(rAFTComConfig.getUniKey() + "&" + str, 0) + 1);
        edit.apply();
    }

    private static SamplingResult checkLimitFormSP(Context context, RAFTComConfig rAFTComConfig, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SLIReport", 4);
        if (sharedPreferences == null) {
            return SamplingResult.APP_LIMIT;
        }
        checkSPDate(sharedPreferences);
        if (sharedPreferences.getInt(SP_APP_REPORT, 0) >= 25) {
            return SamplingResult.APP_LIMIT;
        }
        if (sharedPreferences.getInt(rAFTComConfig.getUniKey(), 0) >= 10) {
            return SamplingResult.COM_LIMIT;
        }
        if (sharedPreferences.getInt(rAFTComConfig.getUniKey() + "&" + str, 0) >= 5) {
            return SamplingResult.KEY_LIMIT;
        }
        return SamplingResult.REPORT;
    }

    private static void checkSPDate(SharedPreferences sharedPreferences) {
        Date date = new Date();
        Date date2 = new Date(sharedPreferences.getLong(SP_DATE, 0L));
        if (date.getDate() != date2.getDate() || date.getMonth() != date2.getMonth()) {
            SharedPreferences.Editor clear = sharedPreferences.edit().clear();
            clear.putLong(SP_DATE, System.currentTimeMillis());
            clear.apply();
        }
    }

    public static SamplingResult getSLISamplingResult(@NonNull Context context, RAFTComConfig rAFTComConfig, String str, @IntRange(from = 0, to = 100) int i3) {
        SamplingResult checkLimitFormSP = checkLimitFormSP(context, rAFTComConfig, str);
        SamplingResult samplingResult = SamplingResult.REPORT;
        if (checkLimitFormSP != samplingResult) {
            return checkLimitFormSP;
        }
        if (Math.random() * 100.0d > i3) {
            return SamplingResult.COM_RATE_LIMIT;
        }
        if (i3 > 1 && Math.random() * 100.0d > 1.0d) {
            return SamplingResult.SLI_LIMIT;
        }
        addLimitToSP(context, rAFTComConfig, str);
        return samplingResult;
    }

    public static SamplingResult startUpSampling(@NotNull RAFTComConfig rAFTComConfig) {
        List<String> list = START_UP_LIST;
        if (list.contains(rAFTComConfig.getUniKey())) {
            return SamplingResult.REPEAT_LIMIT;
        }
        if ((Math.random() * 100.0d) + 1.0d > 5.0d) {
            return SamplingResult.START_UP_RATE_LIMIT;
        }
        list.add(rAFTComConfig.getUniKey());
        return SamplingResult.REPORT;
    }
}
