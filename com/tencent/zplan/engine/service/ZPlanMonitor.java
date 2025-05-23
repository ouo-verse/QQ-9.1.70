package com.tencent.zplan.engine.service;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.epicgames.ue4.UE4;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.utils.ZLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/zplan/engine/service/ZPlanMonitor;", "Landroid/os/Handler$Callback;", "", "b", "d", "e", "c", "Landroid/os/Message;", "msg", "", "handleMessage", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "monitorHandlerThread", "Landroid/os/Handler;", "Landroid/os/Handler;", "monitorHandle", "f", "uiHandle", "Lzx4/d;", h.F, "Lkotlin/Lazy;", "getConfigProxy", "()Lzx4/d;", "configProxy", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanMonitor implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static HandlerThread monitorHandlerThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Handler monitorHandle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Handler uiHandle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Lazy configProxy;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final ZPlanMonitor f385621i = new ZPlanMonitor();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<zx4.d>() { // from class: com.tencent.zplan.engine.service.ZPlanMonitor$configProxy$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final zx4.d invoke() {
                return (zx4.d) mx4.a.f417748a.a(zx4.d.class);
            }
        });
        configProxy = lazy;
    }

    ZPlanMonitor() {
    }

    public static final /* synthetic */ Handler a(ZPlanMonitor zPlanMonitor) {
        return uiHandle;
    }

    private final void b() {
        Handler a16;
        Handler handler = monitorHandle;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1001, 10000L);
        }
        if (UE4.hasEnginePause()) {
            ZLog.f386189b.k("ZPlanMonitor", "handleEngineLifeCycleCheck, zplan engine pause, return");
            return;
        }
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        if (zPlanServiceHelper.R()) {
            ZLog.f386189b.k("ZPlanMonitor", "handleEngineLifeCycleCheck, zplan using, return");
        } else if (!zPlanServiceHelper.R() && (a16 = a(this)) != null) {
            final String str = "pauseEngine";
            a16.post(new Runnable() { // from class: com.tencent.zplan.engine.service.ZPlanMonitor$handleEngineLifeCycleCheck$$inlined$doOnEngineNotUse$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZLog zLog = ZLog.f386189b;
                    zLog.k("ZPlanMonitor", "doOnEngineNotUse, before " + str);
                    Context context = UE4.getContext();
                    if (context != null) {
                        UE4.pauseEngine(context);
                    }
                    zLog.k("ZPlanMonitor", "doOnEngineNotUse, after " + str);
                }
            });
        }
    }

    public final void c() {
        ZLog.f386189b.k("ZPlanMonitor", "startCheckEngineLifeCycle");
        Handler handler = monitorHandle;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1001, 10000L);
        }
    }

    public final void d() {
        ZLog.f386189b.k("ZPlanMonitor", "startMonitor");
        if (monitorHandlerThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("zplan_monitor");
            monitorHandlerThread = baseHandlerThread;
            Intrinsics.checkNotNull(baseHandlerThread);
            baseHandlerThread.start();
        }
        if (monitorHandle == null) {
            HandlerThread handlerThread = monitorHandlerThread;
            Intrinsics.checkNotNull(handlerThread);
            monitorHandle = new Handler(handlerThread.getLooper(), this);
        }
        if (uiHandle == null) {
            uiHandle = new Handler(Looper.getMainLooper());
        }
    }

    public final void e() {
        ZLog.f386189b.k("ZPlanMonitor", "stopMonitor");
        Handler handler = monitorHandle;
        if (handler != null) {
            handler.removeMessages(1001);
        }
        HandlerThread handlerThread = monitorHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        monitorHandle = null;
        monitorHandlerThread = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1001) {
            b();
            return true;
        }
        return true;
    }
}
