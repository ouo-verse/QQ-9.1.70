package com.tencent.biz.richframework.layoutinflater;

import android.app.Activity;
import android.content.Context;
import android.util.LruCache;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B\u0015\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\t\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R-\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00150\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R1\u0010\u001e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00150\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R-\u0010&\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u001f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWPreloadStoreOwner;", "", "", "clearAll", "checkValid", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "preloadRequest", "Lcom/tencent/biz/richframework/layoutinflater/PreloadResult;", "preloadResult", "storePreloadView", "", "Landroid/view/View;", "views", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;", "rFInflater", "Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;", "getRFInflater", "()Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;", "setRFInflater", "(Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflater;)V", "Landroid/util/LruCache;", "Ljava/util/concurrent/ArrayBlockingQueue;", "preloadViewsByLayoutId$delegate", "Lkotlin/Lazy;", "getPreloadViewsByLayoutId", "()Landroid/util/LruCache;", "preloadViewsByLayoutId", "Ljava/lang/Class;", "preloadViewsByClass$delegate", "getPreloadViewsByClass", "preloadViewsByClass", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader$RequestPreloadViewListener;", "preloadListener$delegate", "getPreloadListener", "()Ljava/util/concurrent/ConcurrentHashMap;", "preloadListener", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "storeContextWrf", "Ljava/lang/ref/WeakReference;", "getStoreContextWrf", "()Ljava/lang/ref/WeakReference;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "Companion", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWPreloadStoreOwner {

    /* renamed from: preloadListener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadListener;

    /* renamed from: preloadViewsByClass$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadViewsByClass;

    /* renamed from: preloadViewsByLayoutId$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadViewsByLayoutId;

    @Nullable
    private RFWAsyncLayoutInflater rFInflater;

    @NotNull
    private final WeakReference<Context> storeContextWrf;

    public RFWPreloadStoreOwner(@NotNull WeakReference<Context> storeContextWrf) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(storeContextWrf, "storeContextWrf");
        this.storeContextWrf = storeContextWrf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LruCache<PreloadRequest, ArrayBlockingQueue<PreloadResult>>>() { // from class: com.tencent.biz.richframework.layoutinflater.RFWPreloadStoreOwner$preloadViewsByLayoutId$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LruCache<PreloadRequest, ArrayBlockingQueue<PreloadResult>> invoke() {
                return new LruCache<>(LayoutPreloadConfigManager.INSTANCE.getPreloadConfig().getLayoutTypeCacheCount());
            }
        });
        this.preloadViewsByLayoutId = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LruCache<Class<?>, ArrayBlockingQueue<View>>>() { // from class: com.tencent.biz.richframework.layoutinflater.RFWPreloadStoreOwner$preloadViewsByClass$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LruCache<Class<?>, ArrayBlockingQueue<View>> invoke() {
                return new LruCache<>(LayoutPreloadConfigManager.INSTANCE.getPreloadConfig().getViewClassTypeCount());
            }
        });
        this.preloadViewsByClass = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<Integer, CopyOnWriteArrayList<RFWLayoutPreLoader.RequestPreloadViewListener>>>() { // from class: com.tencent.biz.richframework.layoutinflater.RFWPreloadStoreOwner$preloadListener$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<RFWLayoutPreLoader.RequestPreloadViewListener>> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.preloadListener = lazy3;
    }

    public final void checkValid() {
        Context context = this.storeContextWrf.get();
        if (context == null) {
            RFWLog.i("RFWPreloadContextHelper", RFWLog.USR, "checkStoreOwnerValid failed, hostContext is null, currentStoreOwner: " + hashCode());
            return;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                if (activity.getWindow() == null) {
                    RFWLog.i("RFWPreloadContextHelper", RFWLog.USR, "checkStoreOwnerValid success, hostActivity " + context + TokenParser.SP + "hash:" + context.hashCode() + " window is empty is preload activity");
                    return;
                }
            } else {
                RFWLog.i("RFWPreloadContextHelper", RFWLog.USR, "checkStoreOwnerValid failed, hostActivity " + context + TokenParser.SP + "hash:" + context.hashCode() + " is isDestroyed or finishing");
                return;
            }
        }
        RFWLog.i("RFWPreloadContextHelper", RFWLog.USR, "checkStoreOwnerValid success, context type is " + context);
    }

    public final void clearAll() {
        getPreloadViewsByLayoutId().evictAll();
        getPreloadViewsByClass().evictAll();
        getPreloadListener().clear();
        RFWAsyncLayoutInflater rFWAsyncLayoutInflater = this.rFInflater;
        if (rFWAsyncLayoutInflater != null) {
            rFWAsyncLayoutInflater.cancel();
        }
        this.rFInflater = null;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<RFWLayoutPreLoader.RequestPreloadViewListener>> getPreloadListener() {
        return (ConcurrentHashMap) this.preloadListener.getValue();
    }

    @NotNull
    public final LruCache<Class<?>, ArrayBlockingQueue<View>> getPreloadViewsByClass() {
        return (LruCache) this.preloadViewsByClass.getValue();
    }

    @NotNull
    public final LruCache<PreloadRequest, ArrayBlockingQueue<PreloadResult>> getPreloadViewsByLayoutId() {
        return (LruCache) this.preloadViewsByLayoutId.getValue();
    }

    @Nullable
    public final RFWAsyncLayoutInflater getRFInflater() {
        return this.rFInflater;
    }

    public final void setRFInflater(@Nullable RFWAsyncLayoutInflater rFWAsyncLayoutInflater) {
        this.rFInflater = rFWAsyncLayoutInflater;
    }

    public final void storePreloadView(@NotNull PreloadRequest preloadRequest, @NotNull PreloadResult preloadResult) {
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        Intrinsics.checkNotNullParameter(preloadResult, "preloadResult");
        ArrayBlockingQueue<PreloadResult> arrayBlockingQueue = getPreloadViewsByLayoutId().get(preloadRequest);
        if (arrayBlockingQueue == null) {
            arrayBlockingQueue = new ArrayBlockingQueue<>(LayoutPreloadConfigManager.INSTANCE.getPreloadConfig().getEachCacheCount());
        }
        arrayBlockingQueue.offer(preloadResult);
        getPreloadViewsByLayoutId().put(preloadRequest, arrayBlockingQueue);
    }

    public final void storePreloadView(@NotNull List<? extends View> views) {
        Intrinsics.checkNotNullParameter(views, "views");
        Class<?> cls = views.get(0).getClass();
        ArrayBlockingQueue<View> arrayBlockingQueue = getPreloadViewsByClass().get(cls);
        if (arrayBlockingQueue == null) {
            arrayBlockingQueue = new ArrayBlockingQueue<>(LayoutPreloadConfigManager.INSTANCE.getPreloadConfig().getEachCacheCount());
        }
        Iterator<T> it = views.iterator();
        while (it.hasNext()) {
            arrayBlockingQueue.offer((View) it.next());
        }
        getPreloadViewsByClass().put(cls, arrayBlockingQueue);
    }
}
