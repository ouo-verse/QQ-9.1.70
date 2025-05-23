package com.tencent.mobileqq.partner.signin;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Calendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/j;", "", "", "a", "", "c", "b", "Ljava/lang/Runnable;", "r", "", "d", "", "Ljava/util/Map;", "monthNameMap", "dayOfWeekNameMap", "<init>", "()V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f257255a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, String> monthNameMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, String> dayOfWeekNameMap;

    static {
        Map<Integer, String> mapOf;
        Map<Integer, String> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, "\u4e00\u6708"), TuplesKt.to(1, "\u4e8c\u6708"), TuplesKt.to(2, "\u4e09\u6708"), TuplesKt.to(3, "\u56db\u6708"), TuplesKt.to(4, "\u4e94\u6708"), TuplesKt.to(5, "\u516d\u6708"), TuplesKt.to(6, "\u4e03\u6708"), TuplesKt.to(7, "\u516b\u6708"), TuplesKt.to(8, "\u4e5d\u6708"), TuplesKt.to(9, "\u5341\u6708"), TuplesKt.to(10, "\u5341\u4e00\u6708"), TuplesKt.to(11, "\u5341\u4e8c\u6708"));
        monthNameMap = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(2, "\u661f\u671f\u4e00"), TuplesKt.to(3, "\u661f\u671f\u4e8c"), TuplesKt.to(4, "\u661f\u671f\u4e09"), TuplesKt.to(5, "\u661f\u671f\u56db"), TuplesKt.to(6, "\u661f\u671f\u4e94"), TuplesKt.to(7, "\u661f\u671f\u516d"), TuplesKt.to(1, "\u661f\u671f\u65e5"));
        dayOfWeekNameMap = mapOf2;
    }

    j() {
    }

    public final int a() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        return calendar.get(5);
    }

    public final String b() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        String str = dayOfWeekNameMap.get(Integer.valueOf(calendar.get(7)));
        return str == null ? "" : str;
    }

    public final String c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        String str = monthNameMap.get(Integer.valueOf(calendar.get(2)));
        return str == null ? "" : str;
    }

    public final void d(Runnable r16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            r16.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(r16);
        }
    }
}
