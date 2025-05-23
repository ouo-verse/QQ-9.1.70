package com.tencent.kuikly.core.render.android.scheduler;

import android.os.Handler;
import android.os.Looper;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import d01.n;
import d01.u;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J:\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\fJ\u001e\u0010\u0012\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0002J\u001c\u0010\u0013\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderThreadManager;", "", "", "d", "Lcom/tencent/kuikly/core/render/android/g;", "contextParams", "Lkotlin/Function0;", "", "task", "g", "e", "f", "", "delayMs", "sync", "syncTimeoutMs", h.F, "isSerial", "k", "j", "c", "a", "Landroid/os/Handler;", "Lkotlin/Lazy;", "b", "()Landroid/os/Handler;", "uiHandler", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderThreadManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy uiHandler;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final KuiklyRenderThreadManager f118203b = new KuiklyRenderThreadManager();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        uiHandler = lazy;
    }

    KuiklyRenderThreadManager() {
    }

    private final Handler b() {
        return (Handler) uiHandler.getValue();
    }

    public static /* synthetic */ void i(KuiklyRenderThreadManager kuiklyRenderThreadManager, KuiklyContextParams kuiklyContextParams, Function0 function0, long j3, boolean z16, long j16, int i3, Object obj) {
        long j17;
        boolean z17;
        long j18;
        if ((i3 & 4) != 0) {
            j17 = 0;
        } else {
            j17 = j3;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        if ((i3 & 16) != 0) {
            j18 = 500;
        } else {
            j18 = j16;
        }
        kuiklyRenderThreadManager.h(kuiklyContextParams, function0, j17, z17, j18);
    }

    public final void a(@Nullable KuiklyContextParams contextParams) {
        if (contextParams != null) {
            c(contextParams);
        }
    }

    public final boolean c(@NotNull KuiklyContextParams contextParams) {
        Intrinsics.checkNotNullParameter(contextParams, "contextParams");
        if (contextParams.d() || KuiklyRenderCoreContextScheduler.f118178c.e()) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        return KuiklyRenderCoreContextScheduler.f118178c.e();
    }

    public final void e(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        KuiklyRenderCoreContextScheduler.g(KuiklyRenderCoreContextScheduler.f118178c, task, 0L, false, 0L, 10, null);
    }

    public final void f(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        KuiklyRenderCoreKmpScheduler.e(KuiklyRenderCoreKmpScheduler.f118182c, task, 0L, false, 0L, 10, null);
    }

    public final void g(@NotNull KuiklyContextParams contextParams, @NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(contextParams, "contextParams");
        Intrinsics.checkNotNullParameter(task, "task");
        i(this, contextParams, task, 0L, false, 0L, 28, null);
    }

    public final void h(@NotNull KuiklyContextParams contextParams, @NotNull Function0<Unit> task, long delayMs, boolean sync, long syncTimeoutMs) {
        Intrinsics.checkNotNullParameter(contextParams, "contextParams");
        Intrinsics.checkNotNullParameter(task, "task");
        if (contextParams.d()) {
            KuiklyRenderCoreKmpScheduler.f118182c.d(task, delayMs, sync, syncTimeoutMs);
        } else {
            KuiklyRenderCoreContextScheduler.f118178c.f(task, delayMs, sync, syncTimeoutMs);
        }
    }

    public final void j(@NotNull final Function0<Unit> task, boolean sync) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (sync) {
            if (com.tencent.kuikly.core.render.android.css.ktx.b.l()) {
                task.invoke();
                return;
            } else {
                b().post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager$sam$java_lang_Runnable$0
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                    }
                });
                return;
            }
        }
        b().post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        });
    }

    public final void k(@NotNull Function0<Unit> task, boolean isSerial) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (isSerial) {
            n k3 = u.f392615m.k();
            if (k3 != null) {
                k3.b(task);
                return;
            }
            return;
        }
        n k16 = u.f392615m.k();
        if (k16 != null) {
            k16.a(task);
        }
    }
}
