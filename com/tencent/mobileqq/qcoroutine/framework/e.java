package com.tencent.mobileqq.qcoroutine.framework;

import android.util.Log;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qcoroutine.api.LogLever;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a8\u0006\r"}, d2 = {"", "name", "Lkotlinx/coroutines/CoroutineName;", "c", "Lkotlinx/coroutines/CoroutineScope;", "scope", "a", "", "b", "msg", "Lcom/tencent/mobileqq/qcoroutine/api/LogLever;", HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE, "d", "QCoroutine_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class e {
    @NotNull
    public static final CoroutineName a(@NotNull String name, @Nullable CoroutineScope coroutineScope) {
        CoroutineContext coroutineContext;
        Intrinsics.checkNotNullParameter(name, "name");
        CoroutineName c16 = c(name);
        if (c16 == null) {
            if (coroutineScope != null && (coroutineContext = coroutineScope.getCoroutineContext()) != null) {
                c16 = (CoroutineName) coroutineContext.get(CoroutineName.INSTANCE);
            } else {
                c16 = null;
            }
        }
        if (c16 != null) {
            return c16;
        }
        throw new QThreadAndCoroutineException("Top task need name");
    }

    public static final void b(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (((CoroutineName) scope.getCoroutineContext().get(CoroutineName.INSTANCE)) != null) {
        } else {
            throw new QThreadAndCoroutineException("Top task need name");
        }
    }

    @Nullable
    public static final CoroutineName c(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!"".equals(name)) {
            return new CoroutineName(name);
        }
        return null;
    }

    public static final void d(@NotNull String msg2, @NotNull LogLever lever) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(lever, "lever");
        d dVar = d.f261833c;
        if (dVar.d() == null) {
            if (lever.equals(LogLever.ERROR)) {
                Log.e("QCoroutine_Log", msg2);
                return;
            } else {
                Log.d("QCoroutine_Log", msg2);
                return;
            }
        }
        com.tencent.mobileqq.qcoroutine.api.e d16 = dVar.d();
        if (d16 != null) {
            d16.a(msg2, lever);
        }
    }

    public static /* synthetic */ void e(String str, LogLever logLever, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            logLever = LogLever.INFO;
        }
        d(str, logLever);
    }
}
