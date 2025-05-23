package com.tencent.mobileqq.qqguildsdk.api.impl;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.impl.GProSessionImpl;
import com.tencent.mobileqq.qqguildsdk.internal.CallMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010+\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R$\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b#\u0010'\"\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "", "com/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent$a", "j", "()Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent$a;", "", "e", "", "k", "Lmqq/util/WeakReference;", "Lmqq/app/AppRuntime;", "a", "Lmqq/util/WeakReference;", "mAppRef", "", "b", "Ljava/lang/String;", "appUin", "Lcom/tencent/mobileqq/qqguildsdk/internal/CallMonitor;", "c", "Lcom/tencent/mobileqq/qqguildsdk/internal/CallMonitor;", tl.h.F, "()Lcom/tencent/mobileqq/qqguildsdk/internal/CallMonitor;", "setMCallMonitor", "(Lcom/tencent/mobileqq/qqguildsdk/internal/CallMonitor;)V", "mCallMonitor", "d", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Landroid/os/HandlerThread;", "Lkotlin/Lazy;", "g", "()Landroid/os/HandlerThread;", "handlerThread", "Landroid/os/Handler;", "f", "i", "()Landroid/os/Handler;", "mHandler", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "curSessionId", "app", "<init>", "(Lmqq/app/AppRuntime;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ServiceContent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AppRuntime> mAppRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CallMonitor mCallMonitor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object lock = new Object();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy handlerThread;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String curSessionId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent$a", "Lcom/tencent/mobileqq/qqguildsdk/internal/CallMonitor;", "", BdhLogUtil.LogTag.Tag_Req, "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends CallMonitor {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.internal.CallMonitor
        public boolean R() {
            AppRuntime appRuntime;
            WeakReference weakReference = ServiceContent.this.mAppRef;
            if (weakReference != null) {
                appRuntime = (AppRuntime) weakReference.get();
            } else {
                appRuntime = null;
            }
            if (appRuntime == null) {
                U("mApp is null, error!");
                return false;
            }
            if (ServiceContent.this.getCurSessionId() != null) {
                String str = ServiceContent.this.appUin;
                GProSessionImpl.Companion companion = GProSessionImpl.INSTANCE;
                if (!Intrinsics.areEqual(str, companion.b())) {
                    U("Service(" + ServiceContent.this.appUin + ") and Wrapper(" + companion.b() + ") is not match\uff0cerror!");
                    return false;
                }
                return true;
            }
            U("curSessionId is null, error!");
            return false;
        }
    }

    public ServiceContent(@Nullable AppRuntime appRuntime) {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HandlerThread>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ServiceContent$handlerThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HandlerThread invoke() {
                return new BaseHandlerThread("GProServiceContent");
            }
        });
        this.handlerThread = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ServiceContent$mHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                Object obj;
                HandlerThread g16;
                Handler handler;
                HandlerThread g17;
                obj = ServiceContent.this.lock;
                ServiceContent serviceContent = ServiceContent.this;
                synchronized (obj) {
                    g16 = serviceContent.g();
                    g16.start();
                    g17 = serviceContent.g();
                    handler = new Handler(g17.getLooper());
                }
                return handler;
            }
        });
        this.mHandler = lazy2;
        if (appRuntime != null) {
            this.mAppRef = new WeakReference<>(appRuntime);
            this.appUin = appRuntime.getCurrentUin();
        }
        this.mCallMonitor = j();
        QLog.i("GProServiceContent", 1, "create this=" + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread g() {
        return (HandlerThread) this.handlerThread.getValue();
    }

    private final a j() {
        return new a();
    }

    public final boolean e() {
        return this.mCallMonitor.R();
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getCurSessionId() {
        return this.curSessionId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final CallMonitor getMCallMonitor() {
        return this.mCallMonitor;
    }

    @NotNull
    public final Handler i() {
        return (Handler) this.mHandler.getValue();
    }

    public final void k() {
        synchronized (this.lock) {
            if (g().isAlive()) {
                g().quitSafely();
            }
            Unit unit = Unit.INSTANCE;
        }
        QLog.i("GProServiceContent", 1, "release handlerThread this=" + hashCode());
    }

    public final void l(@Nullable String str) {
        this.curSessionId = str;
    }
}
