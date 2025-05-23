package com.tencent.mobileqq.vas;

import androidx.collection.ArrayMap;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010\f\u001a\n \u0003*\u0004\u0018\u00010\t0\tJ\u0012\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007R\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTraceLogProxy;", "", "Lcom/tencent/mobileqq/tianjige/i;", "kotlin.jvm.PlatformType", "getVasTracer", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "", "start", "", "event", "report", "getTraceInfo", "", "isSuccess", "end", "taskName", "Ljava/lang/String;", "parentTaskName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasTraceLogProxy {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "VasOpenTelemetry";

    @NotNull
    private static final ArrayMap<String, String> defaultParams;
    private static final boolean isHit;

    @NotNull
    private static final AtomicBoolean mHasInitConfig;

    @Nullable
    private final String parentTaskName;

    @NotNull
    private final String taskName;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTraceLogProxy$Companion;", "", "()V", "TAG", "", "defaultParams", "Landroidx/collection/ArrayMap;", "getDefaultParams", "()Landroidx/collection/ArrayMap;", "isHit", "", "()Z", "mHasInitConfig", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getMHasInitConfig", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayMap<String, String> getDefaultParams() {
            return VasTraceLogProxy.defaultParams;
        }

        @NotNull
        public final AtomicBoolean getMHasInitConfig() {
            return VasTraceLogProxy.mHasInitConfig;
        }

        public final boolean isHit() {
            return VasTraceLogProxy.isHit;
        }

        Companion() {
        }
    }

    static {
        int roundToInt;
        boolean z16;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        mHasInitConfig = atomicBoolean;
        defaultParams = new ArrayMap<>();
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.floor(1000 * Math.random()));
        if (roundToInt == 500) {
            z16 = true;
        } else {
            z16 = false;
        }
        isHit = z16;
        if (z16 && atomicBoolean.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.tencent.mobileqq.tianjige.f.e(7, new a.C8649a().o("qq").m(1.0d).l(AppSetting.n()).n(true).k());
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.toString());
            }
            QLog.d(TAG, 2, "initTelemetryConfig cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public VasTraceLogProxy(@NotNull String taskName, @Nullable String str) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        this.taskName = taskName;
        this.parentTaskName = str;
    }

    public static /* synthetic */ void end$default(VasTraceLogProxy vasTraceLogProxy, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        vasTraceLogProxy.end(z16);
    }

    private final com.tencent.mobileqq.tianjige.i getVasTracer() {
        return com.tencent.mobileqq.tianjige.f.d(7);
    }

    public static /* synthetic */ void report$default(VasTraceLogProxy vasTraceLogProxy, String str, ToServiceMsg toServiceMsg, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            toServiceMsg = null;
        }
        vasTraceLogProxy.report(str, toServiceMsg);
    }

    public static /* synthetic */ void start$default(VasTraceLogProxy vasTraceLogProxy, ToServiceMsg toServiceMsg, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            toServiceMsg = null;
        }
        vasTraceLogProxy.start(toServiceMsg);
    }

    @JvmOverloads
    public final void end() {
        end$default(this, false, 1, null);
    }

    public final String getTraceInfo() {
        return getVasTracer().e(this.taskName);
    }

    @JvmOverloads
    public final void report(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        report$default(this, event, null, 2, null);
    }

    @JvmOverloads
    public final void start() {
        start$default(this, null, 1, null);
    }

    public /* synthetic */ VasTraceLogProxy(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2);
    }

    @JvmOverloads
    public final void end(boolean isSuccess) {
        QLog.i(TAG, 1, this.taskName + "-" + this.parentTaskName + " : end");
        if (isHit) {
            getVasTracer().b(this.taskName, !isSuccess ? 1 : 0, defaultParams);
        }
    }

    @JvmOverloads
    public final void report(@NotNull String event, @Nullable ToServiceMsg req) {
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.i(TAG, 1, this.taskName + "-" + this.parentTaskName + " : report " + event);
        if (isHit) {
            if (req != null) {
                getVasTracer().k(this.taskName, event, req, defaultParams);
            } else {
                getVasTracer().h(this.taskName, event, defaultParams);
            }
        }
    }

    @JvmOverloads
    public final void start(@Nullable ToServiceMsg req) {
        QLog.i(TAG, 1, this.taskName + "-" + this.parentTaskName + " : start");
        if (isHit) {
            getVasTracer().s(this.taskName, req, defaultParams, this.parentTaskName);
        }
    }
}
