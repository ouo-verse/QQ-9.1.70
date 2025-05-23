package com.tencent.ecommerce.biz.util;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.MiniConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/util/ECDateUtil;", "", "", "past", "", "b", "c", "currentTimeStamp", "a", "Landroid/content/Context;", "context", "timeMs", "", "f", "roundType", "d", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "g", "<init>", "()V", "RoundType", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDateUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ECDateUtil f104850a = new ECDateUtil();

    /* compiled from: P */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/ecommerce/biz/util/ECDateUtil$RoundType;", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public @interface RoundType {
    }

    ECDateUtil() {
    }

    @JvmStatic
    public static final long a(long currentTimeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeStamp);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTimeInMillis();
    }

    @JvmStatic
    public static final long b(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, calendar.get(6) - past);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    @JvmStatic
    public static final long c(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2, calendar.get(2) - past);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    public final String g(long second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second * 1000);
        return new SimpleDateFormat("MM\u6708dd\u65e5 HH:mm").format(calendar.getTime());
    }

    public final String f(Context context, long timeMs) {
        long j3 = timeMs / 1000;
        long j16 = 3600;
        long j17 = j3 / j16;
        long j18 = j3 - (j16 * j17);
        long j19 = 60;
        long j26 = j18 / j19;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j26)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
        String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j18 - (j19 * j26))}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
        return context.getString(R.string.wtr, format, format2, format3);
    }

    public final int d(long timeMs, @RoundType int roundType) {
        long j3 = 86400000;
        int i3 = (int) (timeMs / j3);
        return (roundType != 1 || timeMs % j3 <= 0) ? i3 : i3 + 1;
    }

    public static /* synthetic */ int e(ECDateUtil eCDateUtil, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return eCDateUtil.d(j3, i3);
    }
}
