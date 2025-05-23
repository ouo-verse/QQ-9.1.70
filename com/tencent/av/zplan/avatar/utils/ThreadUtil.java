package com.tencent.av.zplan.avatar.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\b\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/av/zplan/avatar/utils/ThreadUtil;", "", "Ljava/lang/Runnable;", "job", "", "c", "d", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "a", "()Landroid/os/Handler;", "subHandler", "uiHander", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class ThreadUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ThreadUtil f77341a = new ThreadUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy subHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy uiHander;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.av.zplan.avatar.utils.ThreadUtil$subHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("filament_sub");
                baseHandlerThread.start();
                return new Handler(baseHandlerThread.getLooper());
            }
        });
        subHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.av.zplan.avatar.utils.ThreadUtil$uiHander$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        uiHander = lazy2;
    }

    ThreadUtil() {
    }

    private final Handler a() {
        return (Handler) subHandler.getValue();
    }

    private final Handler b() {
        return (Handler) uiHander.getValue();
    }

    public final void c(@NotNull Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        a().post(job);
    }

    public final void d(@NotNull Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        b().post(job);
    }
}
