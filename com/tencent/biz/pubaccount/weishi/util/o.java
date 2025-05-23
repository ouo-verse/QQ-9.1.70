package com.tencent.biz.pubaccount.weishi.util;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/o;", "", "", "day", "", "b", "a", "dateTimeMillis", "", "c", HippyTKDListViewAdapter.X, "d", "timestampMs", "e", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f81781a = new o();

    o() {
    }

    @JvmStatic
    public static final long a() {
        return System.currentTimeMillis();
    }

    @JvmStatic
    public static final long b(int day) {
        return day * 24 * 60 * 60 * 1000;
    }

    @JvmStatic
    public static final String c(long dateTimeMillis) {
        long a16 = a();
        long j3 = a16 - dateTimeMillis;
        if (j3 < 60000) {
            return ag.c(R.string.x_e);
        }
        if (j3 < 3600000) {
            return (j3 / 60000) + ag.c(R.string.x_i);
        }
        if (j3 < 86400000) {
            return (j3 / 3600000) + ag.c(R.string.x_h);
        }
        if (dateTimeMillis >= d(1)) {
            String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date(dateTimeMillis));
            return ag.c(R.string.x_f) + format;
        }
        if (j3 < QzoneConfig.DefaultValue.DEFAULT_OTHERENTITY_DELEATE_INTERVAL_TIME) {
            return (j3 / 86400000) + ag.c(R.string.x_g);
        }
        if (bb.Y(new SimpleDateFormat(DateUtil.DATE_FORMAT_YEAR).format(Long.valueOf(dateTimeMillis)), 0) >= bb.Y(new SimpleDateFormat(DateUtil.DATE_FORMAT_YEAR).format(Long.valueOf(a16)), 0)) {
            String format2 = new SimpleDateFormat("MM-dd").format(Long.valueOf(dateTimeMillis));
            Intrinsics.checkNotNullExpressionValue(format2, "SimpleDateFormat(DATES_D\u2026T).format(dateTimeMillis)");
            return format2;
        }
        String format3 = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(Long.valueOf(dateTimeMillis));
        Intrinsics.checkNotNullExpressionValue(format3, "SimpleDateFormat(YEARS_D\u2026T).format(dateTimeMillis)");
        return format3;
    }

    @JvmStatic
    public static final long d(int x16) {
        long a16 = a() - b(x16);
        return a16 - ((28800000 + a16) % b(1));
    }

    @JvmStatic
    public static final String e(long timestampMs) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestampMs));
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(date)");
        return format;
    }
}
