package com.tencent.mobileqq.nearbypro.base.config;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH\u0016R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/config/NearbyProThreadPoolImpl;", "Lcom/tencent/mobileqq/nearbypro/base/g;", "Lkotlin/Function0;", "", "Lcom/tencent/mobileqq/nearbypro/base/Task;", "task", "postOnUi", "postOnFileThread", "Ljava/lang/Runnable;", "a", "b", "Landroid/os/Handler;", "Lkotlin/Lazy;", "e", "()Landroid/os/Handler;", "commonHandler", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProThreadPoolImpl implements com.tencent.mobileqq.nearbypro.base.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy commonHandler;

    public NearbyProThreadPoolImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.nearbypro.base.config.NearbyProThreadPoolImpl$commonHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManagerV2.getQQCommonThreadLooper());
            }
        });
        this.commonHandler = lazy;
    }

    private final Handler e() {
        return (Handler) this.commonHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.g
    public void a(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        e().post(task);
    }

    @Override // com.tencent.mobileqq.nearbypro.base.g
    public void b(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        e().removeCallbacks(task);
    }

    @Override // com.tencent.mobileqq.nearbypro.base.g
    public void postOnFileThread(@NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.base.config.g
            @Override // java.lang.Runnable
            public final void run() {
                NearbyProThreadPoolImpl.f(Function0.this);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.nearbypro.base.g
    public void postOnUi(@NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.base.config.f
            @Override // java.lang.Runnable
            public final void run() {
                NearbyProThreadPoolImpl.g(Function0.this);
            }
        });
    }
}
