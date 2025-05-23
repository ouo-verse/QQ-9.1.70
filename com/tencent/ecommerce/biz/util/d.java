package com.tencent.ecommerce.biz.util;

import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/util/d;", "", "", "timestamp", "", "pattern", "b", "Lcom/tencent/ecommerce/biz/util/DateFormat;", "format", "c", "a", "dateStr", "d", "e", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f104866a = new d();

    d() {
    }

    private final String b(long timestamp, String pattern) {
        return new SimpleDateFormat(pattern, Locale.CHINA).format(new Date(timestamp));
    }

    private final String c(DateFormat format) {
        int i3 = c.f104865a[format.ordinal()];
        if (i3 == 1) {
            return TuxDateStringUtils.TUX_COMMON_DATE_FORMAT;
        }
        if (i3 == 2) {
            return TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT;
        }
        if (i3 == 3) {
            return "yyyy-MM-dd HH:mm:ss";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String a(long timestamp, DateFormat format) {
        return b(timestamp, c(format));
    }

    public final long d(String dateStr, DateFormat format) {
        return e(dateStr, c(format));
    }

    public final long e(String dateStr, String pattern) {
        try {
            Date parse = new SimpleDateFormat(pattern, Locale.CHINA).parse(dateStr);
            if (parse != null) {
                return parse.getTime();
            }
            return 0L;
        } catch (ParseException e16) {
            cg0.a.a("ECDateFormatUtils", "parseDateStrToTimestamp", "dataStr: " + dateStr + ", exception: " + e16);
            return 0L;
        }
    }
}
