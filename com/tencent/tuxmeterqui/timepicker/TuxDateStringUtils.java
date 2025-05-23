package com.tencent.tuxmeterqui.timepicker;

import android.os.Build;
import android.text.format.DateFormat;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/TuxDateStringUtils;", "", "()V", "TUX_COMMON_DATE_FORMAT", "", "TUX_COMMON_MINUTES_FORMAT", "TUX_COMMON_TIME_FORMAT", "conversionTime", "time", "", "format", "formatDateTimeWith00", "inputTime", "getDateFormat", "timeStyle", "getTimeDisplays", "", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TuxDateStringUtils {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final TuxDateStringUtils INSTANCE;

    @NotNull
    public static final String TUX_COMMON_DATE_FORMAT = "yyyy-MM-dd";

    @NotNull
    public static final String TUX_COMMON_MINUTES_FORMAT = "yyyy-MM-dd HH:mm";

    @NotNull
    public static final String TUX_COMMON_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new TuxDateStringUtils();
        }
    }

    TuxDateStringUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ long conversionTime$default(TuxDateStringUtils tuxDateStringUtils, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        return tuxDateStringUtils.conversionTime(str, str2);
    }

    public final long conversionTime(@NotNull String time, @NotNull String format) {
        DateTimeFormatter ofPattern;
        LocalDateTime parse;
        ZoneOffset ofHours;
        long epochMilli;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) time, (Object) format)).longValue();
        }
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(format, "format");
        if (Build.VERSION.SDK_INT >= 26) {
            ofPattern = DateTimeFormatter.ofPattern(format);
            parse = LocalDateTime.parse(time, ofPattern);
            ofHours = ZoneOffset.ofHours(8);
            epochMilli = parse.toInstant(ofHours).toEpochMilli();
            return epochMilli;
        }
        try {
            Date parse2 = new SimpleDateFormat(format, Locale.getDefault()).parse(time);
            if (parse2 != null) {
                return parse2.getTime();
            }
            return 0L;
        } catch (ParseException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    @NotNull
    public final String formatDateTimeWith00(@NotNull String inputTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputTime);
        }
        Intrinsics.checkNotNullParameter(inputTime, "inputTime");
        if (new Regex("\\d{4}-\\d{2}-\\d{2}").matches(inputTime)) {
            return inputTime + " 00:00:00";
        }
        if (new Regex("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}").matches(inputTime)) {
            return inputTime + ":00";
        }
        return inputTime;
    }

    @NotNull
    public final String getDateFormat(@NotNull String timeStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) timeStyle);
        }
        Intrinsics.checkNotNullParameter(timeStyle, "timeStyle");
        if (Intrinsics.areEqual(timeStyle, "date")) {
            return TUX_COMMON_DATE_FORMAT;
        }
        if (Intrinsics.areEqual(timeStyle, TuxTimeView.TUX_TIME_STYLE_MINUTES)) {
            return TUX_COMMON_MINUTES_FORMAT;
        }
        return "yyyy-MM-dd HH:mm:ss";
    }

    @Nullable
    public final int[] getTimeDisplays(@NotNull String timeStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) timeStyle);
        }
        Intrinsics.checkNotNullParameter(timeStyle, "timeStyle");
        if (Intrinsics.areEqual(timeStyle, "date")) {
            return new int[]{0, 1, 2};
        }
        if (Intrinsics.areEqual(timeStyle, TuxTimeView.TUX_TIME_STYLE_MINUTES)) {
            return new int[]{0, 1, 2, 3, 4};
        }
        return null;
    }

    public static /* synthetic */ String conversionTime$default(TuxDateStringUtils tuxDateStringUtils, long j3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return tuxDateStringUtils.conversionTime(j3, str);
    }

    @NotNull
    public final String conversionTime(long time, @NotNull String format) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, Long.valueOf(time), format);
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return DateFormat.format(format, time).toString();
    }
}
