package com.tencent.ecommerce.base.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0014\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\"\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000f\"\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lkotlin/Function0;", "", "runnable", "f", "", "delay", "block", "e", "c", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "uiHandler", "", "b", "I", "CPU_COUNT", "NET_MAX_POOL_SIZE", "Ljava/util/concurrent/ThreadPoolExecutor;", "d", "Lkotlin/Lazy;", "()Ljava/util/concurrent/ThreadPoolExecutor;", "subThreadPoolExecutor", "ecommerce_api_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ECThreadUtilKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f101278a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private static final int f101279b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f101280c;

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f101281d;

    static {
        Lazy lazy;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f101279b = availableProcessors;
        f101280c = availableProcessors * 2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.ecommerce.base.utils.ECThreadUtilKt$subThreadPoolExecutor$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ThreadPoolExecutor invoke() {
                int i3;
                int i16;
                i3 = ECThreadUtilKt.f101279b;
                i16 = ECThreadUtilKt.f101280c;
                return new BaseThreadPoolExecutor(i3, i16, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
            }
        });
        f101281d = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.ecommerce.base.utils.ECThreadUtilKt$sam$java_lang_Runnable$0] */
    public static final void c(@NotNull Function0<Unit> function0) {
        ThreadPoolExecutor d16 = d();
        if (function0 != null) {
            function0 = new ECThreadUtilKt$sam$java_lang_Runnable$0(function0);
        }
        d16.execute((Runnable) function0);
    }

    private static final ThreadPoolExecutor d() {
        return (ThreadPoolExecutor) f101281d.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.ecommerce.base.utils.ECThreadUtilKt$sam$java_lang_Runnable$0] */
    public static final void e(long j3, @NotNull Function0<Unit> function0) {
        Handler handler = f101278a;
        if (function0 != null) {
            function0 = new ECThreadUtilKt$sam$java_lang_Runnable$0(function0);
        }
        handler.postDelayed((Runnable) function0, j3);
    }

    public static final void f(@NotNull final Function0<Unit> function0) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            function0.invoke();
        } else {
            f101278a.post(new Runnable() { // from class: com.tencent.ecommerce.base.utils.ECThreadUtilKt$uiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function0.this.invoke();
                }
            });
        }
    }
}
