package com.tencent.sqshow.zootopia.utils;

import android.text.format.Time;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/t;", "", "", "number", "", tl.h.F, "timeSeconds", "b", "c", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "a", "timeStampMillis", "f", "e", "d", "g", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f373300a = new t();

    t() {
    }

    public final String a(long timeStamp) {
        Object valueOf;
        int i3;
        int i16;
        String str;
        String e16 = e(timeStamp);
        Time time = new Time();
        time.set(timeStamp);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Time time2 = new Time();
        time2.set(serverTimeMillis);
        int i17 = time2.yearDay - 1;
        int i18 = time.hour;
        int i19 = time.minute;
        if (i19 < 10) {
            valueOf = "0" + i19;
        } else {
            valueOf = Integer.valueOf(i19);
        }
        String str2 = " " + i18 + ":" + valueOf;
        if (time.year != time2.year || (i3 = time2.yearDay) < (i16 = time.yearDay)) {
            return e16;
        }
        if (i3 == i16) {
            str = BaseApplication.context.getString(R.string.f169839xw1) + str2;
        } else if (i16 == i17) {
            str = BaseApplication.context.getString(R.string.f169840xw2) + str2;
        } else if (i16 + 1 == i17) {
            str = BaseApplication.context.getString(R.string.f169838xw0) + str2;
        } else {
            str = (time.month + 1) + "-" + time.monthDay + str2;
        }
        return str;
    }

    public final String d(long timeStamp) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5", Locale.getDefault());
        if (timeStamp == 0) {
            date = new Date();
        } else {
            date = new Date(timeStamp);
        }
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(if (timeStamp\u2026e() else Date(timeStamp))");
        return format;
    }

    public final String e(long timeStamp) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
        if (timeStamp == 0) {
            date = new Date();
        } else {
            date = new Date(timeStamp);
        }
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(if (timeStamp\u2026e() else Date(timeStamp))");
        return format;
    }

    public final String f(long timeStampMillis) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(timeStampMillis));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\n      \u2026at(Date(timeStampMillis))");
        return format;
    }

    public final long g() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - ((TimeZone.getDefault().getRawOffset() + currentTimeMillis) % 86400000);
    }

    private final String h(long number) {
        if (number > 9) {
            return String.valueOf(number);
        }
        return "0" + number;
    }

    public final String b(long timeSeconds) {
        if (timeSeconds < 60) {
            return "1min";
        }
        if (timeSeconds < 3600) {
            return (timeSeconds / 60) + Element.ELEMENT_NAME_MIN;
        }
        long j3 = 3600;
        return (timeSeconds / j3) + tl.h.F + ((timeSeconds % j3) / 60) + Element.ELEMENT_NAME_MIN;
    }

    public final String c(long timeSeconds) {
        if (timeSeconds > 86400) {
            long j3 = 86400;
            long j16 = timeSeconds / j3;
            long j17 = (timeSeconds % j3) / 3600;
            if (j17 > 0) {
                return j16 + "\u5929" + j17 + "\u5c0f\u65f6";
            }
            return j16 + "\u5929";
        }
        long j18 = 3600;
        long j19 = 60;
        return h(timeSeconds / j18) + ":" + h((timeSeconds % j18) / j19) + ":" + h(timeSeconds % j19);
    }
}
