package com.tencent.rmonitor.looper.provider;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.looper.MonitorInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 22\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b0\u00101J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\nH&J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH&J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\nH&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0004J\b\u0010\u001b\u001a\u00020\u001aH\u0004J\b\u0010\u001c\u001a\u00020\u001aH\u0004J\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010$R\u0016\u0010&\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010'R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010)R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/rmonitor/looper/provider/a;", "Lcom/tencent/rmonitor/looper/provider/c;", "Ljava/lang/Thread;", MosaicConstants$JsProperty.PROP_THREAD, "Lcom/tencent/rmonitor/looper/provider/b;", "lagParam", "Lc14/a;", "callback", "", "a", "", "stop", "", "startTime", "c", "endTime", "duration", "b", "l", DomainData.DOMAIN_NAME, "Lcom/tencent/rmonitor/looper/c;", "monitorInfo", "g", "f", "e", "i", "", "k", "j", "o", "normal", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Lcom/tencent/rmonitor/looper/provider/b;", h.F, "()Lcom/tencent/rmonitor/looper/provider/b;", "Ljava/lang/String;", "looperThreadName", "looperThreadId", "Ljava/lang/Thread;", "looperThread", "Z", "isInit", "Lcom/tencent/rmonitor/looper/c;", "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStackTraceNormal", "<init>", "()V", "D", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class a implements c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String looperThreadName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String looperThreadId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile Thread looperThread;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isInit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MonitorInfo monitorInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b lagParam = new b();

    /* renamed from: C, reason: from kotlin metadata */
    private AtomicBoolean isStackTraceNormal = new AtomicBoolean(true);

    @Override // com.tencent.rmonitor.looper.provider.c
    public boolean a(@NotNull Thread thread, @NotNull b lagParam, @NotNull c14.a callback) {
        Intrinsics.checkParameterIsNotNull(thread, "thread");
        Intrinsics.checkParameterIsNotNull(lagParam, "lagParam");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        String name = thread.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "thread.name");
        this.looperThreadName = name;
        this.looperThreadId = String.valueOf(thread.getId());
        this.looperThread = thread;
        this.lagParam.a(lagParam);
        this.isInit = l(callback);
        Logger.f365497g.i("RMonitor_looper_StackProvider", "prepare stack provider, isInit: " + this.isInit + ", lagParam: " + lagParam);
        return this.isInit;
    }

    @Override // com.tencent.rmonitor.looper.provider.c
    public void b(long endTime, long duration) {
        if (!this.isInit) {
            Logger.f365497g.i("RMonitor_looper_StackProvider", "dispatch end fail because provide is not prepared.");
            return;
        }
        MonitorInfo monitorInfo = this.monitorInfo;
        if (monitorInfo != null) {
            monitorInfo.t(duration);
            f(monitorInfo, endTime, duration);
            MonitorInfo.INSTANCE.c(monitorInfo);
        }
        this.monitorInfo = null;
    }

    @Override // com.tencent.rmonitor.looper.provider.c
    public void c(long startTime) {
        if (!this.isInit) {
            Logger.f365497g.d("RMonitor_looper_StackProvider", "dispatch start fail because provide is not prepared.");
            return;
        }
        if (!this.isStackTraceNormal.get()) {
            e();
            Logger.f365497g.d("RMonitor_looper_StackProvider", "dispatch start fail because stack trace not normal.");
            return;
        }
        MonitorInfo monitorInfo = this.monitorInfo;
        if (monitorInfo != null) {
            Logger.f365497g.w("RMonitor_looper_StackProvider", "last msg not call dispatchEnd, key: " + monitorInfo.getLastStackRequestTime());
            MonitorInfo.INSTANCE.c(monitorInfo);
        }
        MonitorInfo b16 = MonitorInfo.INSTANCE.b();
        this.monitorInfo = b16;
        if (b16 != null) {
            b16.v(System.currentTimeMillis());
            g(b16, startTime);
        }
    }

    public final void d(@NotNull MonitorInfo monitorInfo) {
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
        if (monitorInfo.getScene() == null) {
            monitorInfo.o(LifecycleCallback.G.m());
            monitorInfo.x(com.tencent.rmonitor.common.lifecycle.a.f());
            monitorInfo.y(j());
            monitorInfo.z(k());
            monitorInfo.getLagParam().a(this.lagParam);
        }
    }

    public abstract void e();

    public abstract void f(@NotNull MonitorInfo monitorInfo, long endTime, long duration);

    public abstract void g(@NotNull MonitorInfo monitorInfo, long startTime);

    @NotNull
    /* renamed from: h, reason: from getter */
    public final b getLagParam() {
        return this.lagParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: i, reason: from getter */
    public final Thread getLooperThread() {
        return this.looperThread;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String j() {
        String str = this.looperThreadId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("looperThreadId");
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String k() {
        String str = this.looperThreadName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("looperThreadName");
        }
        return str;
    }

    public abstract boolean l(@NotNull c14.a callback);

    public final void m(boolean normal) {
        boolean z16 = this.isStackTraceNormal.get();
        if (z16 != normal) {
            this.isStackTraceNormal.compareAndSet(z16, normal);
            Logger.f365497g.d("RMonitor_looper_StackProvider", "markStackTrace, pre: " + z16 + ", new: " + normal);
        }
    }

    public abstract void n();

    public final boolean o() {
        return this.lagParam.f365687e;
    }

    @Override // com.tencent.rmonitor.looper.provider.c
    public void stop() {
        this.isInit = false;
        n();
        this.looperThread = null;
        Logger.f365497g.i("RMonitor_looper_StackProvider", "stop");
    }
}
