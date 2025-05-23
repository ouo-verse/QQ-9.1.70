package com.tencent.qqnt.qbasealbum.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/f;", "", "Ljava/util/Calendar;", "curCal", "", "d", "", "time", "", "c", "", "bReadAble", "e", "ms", "b", "a", "", "D", "TIME_FORMAT_THRESHOLD", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f361654a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final double TIME_FORMAT_THRESHOLD;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45278);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f361654a = new f();
            TIME_FORMAT_THRESHOLD = Math.pow(10.0d, 12.0d);
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String d(Calendar curCal) {
        switch (curCal.get(7)) {
            case 1:
                return "\u661f\u671f\u65e5";
            case 2:
                return "\u661f\u671f\u4e00";
            case 3:
                return "\u661f\u671f\u4e8c";
            case 4:
                return "\u661f\u671f\u4e09";
            case 5:
                return "\u661f\u671f\u56db";
            case 6:
                return "\u661f\u671f\u4e94";
            case 7:
                return "\u661f\u671f\u516d";
            default:
                return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        if (r6 != false) goto L19;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(long ms5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, ms5);
        }
        long j3 = ms5 / 1000;
        long j16 = 60;
        int i3 = (int) (j3 % j16);
        long j17 = j3 / j16;
        int i16 = (int) (j17 % j16);
        int i17 = (int) (j17 / j16);
        StringBuilder sb5 = new StringBuilder();
        if (i17 > 0) {
            sb5.append(i17 + "\u65f6");
        }
        if (i16 > 0) {
            sb5.append(i16 + "\u5206");
        }
        if (i3 <= 0) {
            if (sb5.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        sb5.append(i3 + "\u79d2");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @NotNull
    public final String b(long ms5) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, ms5);
        }
        int i3 = (int) (ms5 / 1000);
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + i16;
        }
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + i17;
        }
        String str3 = str2 + ":" + str;
        Intrinsics.checkNotNullExpressionValue(str3, "sb.toString()");
        return str3;
    }

    public final int c(long time) {
        LocalDate now;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, time)).intValue();
        }
        if (time <= 0) {
            return 0;
        }
        long j3 = time * 1000;
        if (Build.VERSION.SDK_INT >= 26) {
            now = LocalDate.now();
            now.atTime(0, 0, 0);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(1);
    }

    @SuppressLint({"SimpleDateFormat"})
    @NotNull
    public final String e(long time, boolean bReadAble) {
        String str;
        String str2;
        LocalDate now;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Long.valueOf(time), Boolean.valueOf(bReadAble));
        }
        if (time <= TIME_FORMAT_THRESHOLD) {
            time *= 1000;
        }
        long serverTimeMillis = com.tencent.qqnt.qbasealbum.inject.g.f361234b.getServerTimeMillis();
        long j3 = 86400000;
        int i3 = (int) (serverTimeMillis / j3);
        int i16 = (int) (time / j3);
        if (Build.VERSION.SDK_INT >= 26) {
            now = LocalDate.now();
            now.atTime(0, 0, 0);
        }
        Calendar inputCal = Calendar.getInstance();
        inputCal.setTimeInMillis(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(serverTimeMillis);
        if (i3 == i16) {
            return "\u4eca\u5929";
        }
        if (i3 == i16 + 1) {
            return "\u6628\u5929";
        }
        if (i3 >= i16 + 2 && i3 < i16 + 9) {
            Intrinsics.checkNotNullExpressionValue(inputCal, "inputCal");
            return d(inputCal);
        }
        if (inputCal.get(1) == calendar.get(1)) {
            if (bReadAble) {
                str2 = "M\u6708d\u65e5";
            } else {
                str2 = "MM-dd";
            }
            String format = new SimpleDateFormat(str2).format(inputCal.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "sdf.format(inputCal.time)");
            return format;
        }
        if (bReadAble) {
            str = "yyyy\u5e74M\u6708d\u65e5";
        } else {
            str = TuxDateStringUtils.TUX_COMMON_DATE_FORMAT;
        }
        String format2 = new SimpleDateFormat(str).format(inputCal.getTime());
        Intrinsics.checkNotNullExpressionValue(format2, "sdf.format(inputCal.time)");
        return format2;
    }
}
