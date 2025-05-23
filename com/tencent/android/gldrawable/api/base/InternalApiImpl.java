package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.ILoaderCallback;
import com.tencent.android.gldrawable.api.ILoaderSucessCallback;
import com.tencent.android.gldrawable.api.IReporter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u000e\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\r\u0010\u0012\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0000\u00a2\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/InternalApiImpl;", "Lcom/tencent/android/gldrawable/api/base/AbsApi;", "()V", "fistCallTime", "", "loaderSucessCallbacks", "Ljava/util/ArrayList;", "Lcom/tencent/android/gldrawable/api/ILoaderSucessCallback;", "logger", "Lcom/tencent/android/gldrawable/api/IReporter;", "getLogger$api_release", "()Lcom/tencent/android/gldrawable/api/IReporter;", "logger$delegate", "Lkotlin/Lazy;", "loadDynamicSync", "", "loadDynamicSync$api_release", "notifyLoaderCallbacksIfNeed", "realLoadApk", "realLoadApk$api_release", "registerLoadSucessCallback", "callback", "registerLoadSucessCallback$api_release", "waitAndTryLoad", "waitAndTryLoad$api_release", "Companion", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public abstract class InternalApiImpl extends AbsApi {
    public static final long TIME_WAIT = 500;
    private long fistCallTime;
    private final ArrayList<ILoaderSucessCallback> loaderSucessCallbacks;

    /* renamed from: logger$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy logger;

    public InternalApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IReporter>() { // from class: com.tencent.android.gldrawable.api.base.InternalApiImpl$logger$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IReporter invoke() {
                return InternalApiImpl.this.getLoader().getLoaderUtils().getReport();
            }
        });
        this.logger = lazy;
        this.loaderSucessCallbacks = new ArrayList<>();
    }

    private final void notifyLoaderCallbacksIfNeed() {
        if (this.loaderSucessCallbacks.size() > 0) {
            synchronized (this.loaderSucessCallbacks) {
                Iterator<ILoaderSucessCallback> it = this.loaderSucessCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onLoadSucceed();
                }
                this.loaderSucessCallbacks.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @NotNull
    public final IReporter getLogger$api_release() {
        return (IReporter) this.logger.getValue();
    }

    public final void loadDynamicSync$api_release() {
        if (getLoader().getIsStatic()) {
            return;
        }
        if (isDynamicReady()) {
            notifyLoaderCallbacksIfNeed();
            return;
        }
        waitAndTryLoad$api_release();
        if (isDynamicReady()) {
            notifyLoaderCallbacksIfNeed();
        }
    }

    public final void realLoadApk$api_release() {
        try {
            getLoader().loadSync(new ILoaderCallback() { // from class: com.tencent.android.gldrawable.api.base.InternalApiImpl$realLoadApk$callback$1
                @Override // com.tencent.android.gldrawable.api.ILoaderCallback
                public void onLoadSucceed() {
                    if (!InternalApiImpl.this.getLoader().getIsLoaded()) {
                        return;
                    }
                    synchronized (AbsApi.class) {
                        if (!InternalApiImpl.this.isDynamicReady()) {
                            InternalApiImpl internalApiImpl = InternalApiImpl.this;
                            internalApiImpl.setDynamicReady(internalApiImpl.getLoader().getClassLoader());
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }

                @Override // com.tencent.android.gldrawable.api.ILoaderCallback
                public void onLoadFailed() {
                }
            });
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public final void registerLoadSucessCallback$api_release(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.loaderSucessCallbacks) {
            this.loaderSucessCallbacks.add(callback);
        }
    }

    public final void waitAndTryLoad$api_release() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new BaseThread(new Runnable() { // from class: com.tencent.android.gldrawable.api.base.InternalApiImpl$waitAndTryLoad$1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (InternalApiImpl.this) {
                    if (!InternalApiImpl.this.isDynamicReady()) {
                        InternalApiImpl.this.realLoadApk$api_release();
                    }
                    Unit unit = Unit.INSTANCE;
                }
                countDownLatch.countDown();
            }
        }).start();
        if (this.fistCallTime == 0) {
            this.fistCallTime = System.currentTimeMillis();
        }
        long abs = Math.abs(System.currentTimeMillis() - this.fistCallTime);
        if (abs < 500) {
            try {
                countDownLatch.await(500 - abs, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }
}
