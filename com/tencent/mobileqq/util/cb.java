package com.tencent.mobileqq.util;

import android.text.TextUtils;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J&\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0013\u001a\u00020\u0002R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/util/cb;", "", "", "TValue", "", "g", "r3", "r4", tl.h.F, "a", "TFinishValue", "TStartValue", "", "result", "f", "r2", "e", "d", "i", "c", "", "", "b", "Ljava/util/Map;", "mStartTimeMap", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class cb {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cb f306645a = new cb();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Long> mStartTimeMap = new LinkedHashMap();

    cb() {
    }

    private final void a(String TValue, String r36, String r46) {
        mStartTimeMap.put(TValue, Long.valueOf(System.currentTimeMillis()));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ao.Companion companion = com.tencent.mobileqq.loginregister.ao.INSTANCE;
        String d16 = companion.d();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            ReportController.o(peekAppRuntime, "dc00898", "", d16, TValue, TValue, companion.c(), 0, "", r36, r46, companion.a());
        } else {
            ReportController.r(peekAppRuntime, "dc00898", "", d16, TValue, TValue, companion.c(), 0, "", r36, r46, companion.a());
        }
    }

    static /* synthetic */ void b(cb cbVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        cbVar.a(str, str2, str3);
    }

    @JvmStatic
    public static final void d(@Nullable String TValue) {
        e(TValue, "", "");
    }

    @JvmStatic
    public static final void e(@Nullable String TValue, @NotNull String r26, @NotNull String r46) {
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r46, "r4");
        ao.Companion companion = com.tencent.mobileqq.loginregister.ao.INSTANCE;
        String d16 = companion.d();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            ReportController.o(peekAppRuntime, "dc00898", "", d16, TValue, TValue, companion.c(), 0, r26, "", r46, "");
        } else {
            ReportController.r(peekAppRuntime, "dc00898", "", d16, TValue, TValue, companion.c(), 0, r26, "", r46, "");
        }
    }

    @JvmStatic
    public static final void f(@NotNull String TFinishValue, @NotNull String TStartValue, int result, @NotNull String r36) {
        long j3;
        Intrinsics.checkNotNullParameter(TFinishValue, "TFinishValue");
        Intrinsics.checkNotNullParameter(TStartValue, "TStartValue");
        Intrinsics.checkNotNullParameter(r36, "r3");
        long currentTimeMillis = System.currentTimeMillis();
        Long remove = mStartTimeMap.remove(TStartValue);
        if (remove != null) {
            j3 = remove.longValue();
        } else {
            j3 = 0;
        }
        String valueOf = String.valueOf(currentTimeMillis - j3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ao.Companion companion = com.tencent.mobileqq.loginregister.ao.INSTANCE;
        String d16 = companion.d();
        String c16 = f306645a.c();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            ReportController.o(peekAppRuntime, "dc00898", "", d16, TFinishValue, TFinishValue, companion.c(), result, valueOf, r36, c16, companion.a());
        } else {
            ReportController.r(peekAppRuntime, "dc00898", "", d16, TFinishValue, TFinishValue, companion.c(), result, valueOf, r36, c16, companion.a());
        }
    }

    @JvmStatic
    public static final void g(@NotNull String TValue) {
        Intrinsics.checkNotNullParameter(TValue, "TValue");
        cb cbVar = f306645a;
        b(cbVar, TValue, null, cbVar.c(), 2, null);
    }

    @JvmStatic
    public static final void h(@NotNull String TValue, @NotNull String r36, @NotNull String r46) {
        Intrinsics.checkNotNullParameter(TValue, "TValue");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        f306645a.a(TValue, r36, r46);
    }

    @NotNull
    public final String c() {
        if (!TextUtils.isEmpty(com.tencent.mobileqq.loginregister.ao.INSTANCE.d())) {
            return "1";
        }
        return "0";
    }

    public final void i(@Nullable String TValue) {
        String c16 = com.tencent.mobileqq.statistics.o.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
        e(TValue, "", c16);
    }
}
