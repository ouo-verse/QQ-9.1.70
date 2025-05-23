package com.tencent.mobileqq.guild.base.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/base/preload/WebProcessPreloader;", "", "", "d", "g", "", "b", "J", "activePreloadTime", "Lcom/tencent/mobileqq/guild/util/IQQGuildUtilApi;", "c", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/util/IQQGuildUtilApi;", "preloadApi", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class WebProcessPreloader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WebProcessPreloader f214762a = new WebProcessPreloader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long activePreloadTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy preloadApi;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQGuildUtilApi>() { // from class: com.tencent.mobileqq.guild.base.preload.WebProcessPreloader$preloadApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQQGuildUtilApi invoke() {
                return (IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class);
            }
        });
        preloadApi = lazy;
    }

    WebProcessPreloader() {
    }

    private final IQQGuildUtilApi c() {
        return (IQQGuildUtilApi) preloadApi.getValue();
    }

    private final void d() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.base.preload.b
                @Override // java.lang.Runnable
                public final void run() {
                    WebProcessPreloader.e();
                }
            });
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.guild.base.preload.c
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean f16;
                f16 = WebProcessPreloader.f();
                return f16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        f214762a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f() {
        f214762a.c().preloadWebProcess();
        return false;
    }

    public final void g() {
        if (SystemClock.uptimeMillis() - activePreloadTime < 2000) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.comm.WebProcessPreloader", "triggerPreload");
        }
        activePreloadTime = SystemClock.uptimeMillis();
        d();
    }
}
