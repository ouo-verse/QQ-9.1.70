package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0000\u00a2\u0006\u0002\b\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0007JK\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112*\u0010\u0012\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00140\u0013\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u00a2\u0006\u0002\u0010\u0015J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H\u0007JK\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112*\u0010\u0012\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00140\u0013\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u00a2\u0006\u0002\u0010\u0015JD\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/VasStatisticCollector;", "", "()V", "APP_KEY", "", "TAG", "hit", "", "calculateHit", "i", "", "calculateHit$vas_temp_api_release", "isHit", "report", "", "eventCode", "elapse", "", "params", "", "Lkotlin/Pair;", "(Ljava/lang/String;J[Lkotlin/Pair;)V", "", "reportReal", "isReal", "isImmediately", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasStatisticCollector {

    @NotNull
    public static final String APP_KEY = "00000TEDPU36RWUZ";

    @NotNull
    public static final VasStatisticCollector INSTANCE;

    @NotNull
    private static final String TAG = "VasStatisticCollector";
    private static final boolean hit;

    static {
        VasStatisticCollector vasStatisticCollector = new VasStatisticCollector();
        INSTANCE = vasStatisticCollector;
        hit = vasStatisticCollector.calculateHit$vas_temp_api_release(1000);
    }

    VasStatisticCollector() {
    }

    @JvmStatic
    public static final boolean isHit() {
        return hit;
    }

    @JvmStatic
    @JvmOverloads
    public static final void report(@NotNull String eventCode, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        report$default(eventCode, 0L, map, 2, (Object) null);
    }

    public static /* synthetic */ void report$default(String str, long j3, Pair[] pairArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        report(str, j3, (Pair<String, String>[]) pairArr);
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportReal(@NotNull String eventCode, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        reportReal$default(eventCode, map, 0L, false, false, 28, null);
    }

    public static /* synthetic */ void reportReal$default(String str, long j3, Pair[] pairArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        reportReal(str, j3, (Pair<String, String>[]) pairArr);
    }

    public final boolean calculateHit$vas_temp_api_release(int i3) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.floor(i3 * Math.random()));
        if (roundToInt == i3 / 2) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @JvmOverloads
    public static final void report(@NotNull String eventCode, @NotNull Pair<String, String>... params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        report$default(eventCode, 0L, params, 2, (Object) null);
    }

    public static /* synthetic */ void report$default(String str, long j3, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        report(str, j3, (Map<String, String>) map);
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportReal(@NotNull String eventCode, @Nullable Map<String, String> map, long j3) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        reportReal$default(eventCode, map, j3, false, false, 24, null);
    }

    public static /* synthetic */ void reportReal$default(String str, Map map, long j3, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        reportReal(str, map, j3, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? false : z17);
    }

    @JvmStatic
    @JvmOverloads
    public static final void report(@NotNull String eventCode, long elapse, @NotNull Pair<String, String>... params) {
        Map map;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        if (hit) {
            map = MapsKt__MapsKt.toMap(params);
            mutableMap = MapsKt__MapsKt.toMutableMap(map);
            report(eventCode, elapse, (Map<String, String>) mutableMap);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportReal(@NotNull String eventCode, @Nullable Map<String, String> map, long j3, boolean z16) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        reportReal$default(eventCode, map, j3, z16, false, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportReal(@NotNull String eventCode, @NotNull Pair<String, String>... params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        reportReal$default(eventCode, 0L, params, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void report(@NotNull String eventCode, long elapse, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        if (hit) {
            reportReal$default(eventCode, params, elapse, false, false, 24, null);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportReal(@NotNull String eventCode, long elapse, @NotNull Pair<String, String>... params) {
        Map map;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        map = MapsKt__MapsKt.toMap(params);
        mutableMap = MapsKt__MapsKt.toMutableMap(map);
        reportReal$default(eventCode, mutableMap, elapse, false, false, 24, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportReal(@NotNull String eventCode, @Nullable Map<String, String> params, long elapse, boolean isReal, boolean isImmediately) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "eventCode=" + eventCode + ", elapse=" + elapse + ", params=" + params);
        }
        if (params == null) {
            params = new HashMap<>();
            String currentUin = VasUtil.getCurrentUin(false);
            Intrinsics.checkNotNullExpressionValue(currentUin, "getCurrentUin(false)");
            params.put("qquin", currentUin);
            params.put("cost_time", String.valueOf(elapse));
            params.put("consume_time", String.valueOf(elapse));
        } else {
            String currentUin2 = VasUtil.getCurrentUin(false);
            Intrinsics.checkNotNullExpressionValue(currentUin2, "getCurrentUin(false)");
            params.put("qquin", currentUin2);
            params.put("cost_time", String.valueOf(elapse));
            params.put("consume_time", String.valueOf(elapse));
        }
        QQBeaconReport.reportWithAppKey(APP_KEY, "", eventCode, params);
    }
}
