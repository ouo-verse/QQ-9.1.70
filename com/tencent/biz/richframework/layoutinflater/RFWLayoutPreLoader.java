package com.tencent.biz.richframework.layoutinflater;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.argus.ContextWrapperFactory;
import com.tencent.webbundle.sdk.WebBundleConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0003CDEB\u000f\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\bA\u0010BJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\"\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010,\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u000bH\u0007J\"\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u000bH\u0017J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u001a\u0010.\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020\u000bR \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001e028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\"\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u000105028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "Lcom/tencent/biz/richframework/layoutinflater/IViewProvider;", "Landroid/content/Context;", "context", "", "layoutId", "Landroid/view/ViewGroup;", "parentView", "preloadCount", "", WebBundleConstants.EVENT_TYPE_OF_PRELOAD_VIEW, "", "isInValidRequestParent", "isValidContext", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader$RequestPreloadViewListener;", "listener", "registerEachListener", "getHeadValidListener", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "preloadRequest", "Lcom/tencent/biz/richframework/layoutinflater/PreloadResult;", "preloadResult", "storePreloadView", "Landroid/view/ViewStub;", "viewStub", "Landroid/view/View;", "preloadViewListener", "replaceViewStub", "", "getContextUniKey", "Lcom/tencent/biz/richframework/layoutinflater/RFWPreloadStoreOwner;", "getPreloadStoreOwner", "initStoreOwner", "view", HippyNestedScrollComponent.PRIORITY_PARENT, "replaceSelfWithView", "clearBlackIds", "clearAll", "clearPagePreLoaders", "requestContext", "getPreloadContext", "requireCount", "fillPreloadView", "inflateIfNotExist", "getPreloadView", "getPreloadResult", "requestPreloadViewForViewStub", "getViewCountInCache", "isPending", "setPreloadPending", "", "preloadStoreOwner", "Ljava/util/Map;", "", "blackLayoutIds", "Ljava/util/concurrent/atomic/AtomicBoolean;", "preloadPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/biz/richframework/layoutinflater/PendingBatchPreloadRequest;", "pendingRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutLoaderStrategy;", "mLoaderStrategy", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutLoaderStrategy;", "<init>", "(Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutLoaderStrategy;)V", "Companion", "RequestPreloadViewListener", "ViewStubPreloadViewListener", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWLayoutPreLoader implements IViewProvider {

    @JvmField
    @NotNull
    public static final Set<Integer> globalBlackLayoutIds = new HashSet();
    private final Map<Integer, Throwable> blackLayoutIds;
    private final RFWLayoutLoaderStrategy mLoaderStrategy;
    private final ConcurrentLinkedQueue<PendingBatchPreloadRequest> pendingRequests;
    private final AtomicBoolean preloadPending;
    private final Map<String, RFWPreloadStoreOwner> preloadStoreOwner;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader$RequestPreloadViewListener;", "", "onPreloadResult", "", "requestView", "Landroid/view/View;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface RequestPreloadViewListener {
        void onPreloadResult(@NotNull View requestView);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader$ViewStubPreloadViewListener;", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader$RequestPreloadViewListener;", "mViewStub", "Landroid/view/ViewStub;", "mOutPreloadViewListener", "(Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;Landroid/view/ViewStub;Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader$RequestPreloadViewListener;)V", "onPreloadResult", "", "requestView", "Landroid/view/View;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    private final class ViewStubPreloadViewListener implements RequestPreloadViewListener {
        private final RequestPreloadViewListener mOutPreloadViewListener;
        private final ViewStub mViewStub;
        final /* synthetic */ RFWLayoutPreLoader this$0;

        public ViewStubPreloadViewListener(@NotNull RFWLayoutPreLoader rFWLayoutPreLoader, @Nullable ViewStub mViewStub, RequestPreloadViewListener requestPreloadViewListener) {
            Intrinsics.checkNotNullParameter(mViewStub, "mViewStub");
            this.this$0 = rFWLayoutPreLoader;
            this.mViewStub = mViewStub;
            this.mOutPreloadViewListener = requestPreloadViewListener;
        }

        @Override // com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
        public void onPreloadResult(@NotNull View requestView) {
            Intrinsics.checkNotNullParameter(requestView, "requestView");
            this.this$0.replaceViewStub(this.mViewStub, requestView, this.mOutPreloadViewListener);
        }
    }

    public RFWLayoutPreLoader(@NotNull RFWLayoutLoaderStrategy mLoaderStrategy) {
        Intrinsics.checkNotNullParameter(mLoaderStrategy, "mLoaderStrategy");
        this.mLoaderStrategy = mLoaderStrategy;
        this.preloadStoreOwner = new ConcurrentHashMap();
        this.blackLayoutIds = new ConcurrentHashMap();
        this.preloadPending = new AtomicBoolean(false);
        this.pendingRequests = new ConcurrentLinkedQueue<>();
        RFWApplication.getApplication().registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(@NotNull Configuration newConfig) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                RFWLog.d("RFWLayoutPreLoader", RFWLog.USR, "clearPagePreLoaders onLowMemory");
                RFWLayoutPreLoader.this.clearAll(false);
                ParentViewGroupPool.INSTANCE.release();
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int level) {
                RFWLog.d("RFWLayoutPreLoader", RFWLog.USR, "clearPagePreLoaders onTrimMemory:", Integer.valueOf(level));
            }
        });
        RFWApplication.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                RFWLayoutPreLoader.this.clearPagePreLoaders(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        });
        ContextWrapperFactory.INSTANCE.addOperationListener(new ContextWrapperFactory.IContextWrapperOperationListener() { // from class: com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.3
            @Override // com.tencent.richframework.argus.ContextWrapperFactory.IContextWrapperOperationListener
            public void onRemove(@NotNull Context context, @NotNull Map<Class<?>, FragmentActivity> wrapperContext) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(wrapperContext, "wrapperContext");
                Iterator<T> it = wrapperContext.values().iterator();
                while (it.hasNext()) {
                    RFWLayoutPreLoader.this.clearPagePreLoaders((FragmentActivity) it.next());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getContextUniKey(Context context) {
        return context.getClass().getName() + "_" + context.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestPreloadViewListener getHeadValidListener(Context context, int layoutId) {
        CopyOnWriteArrayList<RequestPreloadViewListener> copyOnWriteArrayList = getPreloadStoreOwner(context).getPreloadListener().get(Integer.valueOf(layoutId));
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            return copyOnWriteArrayList.remove(0);
        }
        return null;
    }

    private final RFWPreloadStoreOwner getPreloadStoreOwner(Context context) {
        RFWPreloadStoreOwner rFWPreloadStoreOwner = this.preloadStoreOwner.get(getContextUniKey(context));
        if (rFWPreloadStoreOwner == null) {
            synchronized (this) {
                rFWPreloadStoreOwner = this.preloadStoreOwner.get(getContextUniKey(context));
                if (rFWPreloadStoreOwner == null) {
                    rFWPreloadStoreOwner = initStoreOwner(context);
                    this.preloadStoreOwner.put(getContextUniKey(context), rFWPreloadStoreOwner);
                }
            }
        }
        return rFWPreloadStoreOwner;
    }

    private final RFWPreloadStoreOwner initStoreOwner(Context context) {
        RFWPreloadStoreOwner rFWPreloadStoreOwner = new RFWPreloadStoreOwner(new WeakReference(context));
        rFWPreloadStoreOwner.setRFInflater(new RFWAsyncLayoutInflater(context));
        return rFWPreloadStoreOwner;
    }

    private final boolean isInValidRequestParent(ViewGroup parentView) {
        if ((parentView instanceof RecyclerView) && ((RecyclerView) parentView).getLayoutManager() == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidContext(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    private final void registerEachListener(Context context, int layoutId, RequestPreloadViewListener listener) {
        if (listener == null) {
            return;
        }
        RFWPreloadStoreOwner preloadStoreOwner = getPreloadStoreOwner(context);
        CopyOnWriteArrayList<RequestPreloadViewListener> copyOnWriteArrayList = preloadStoreOwner.getPreloadListener().get(Integer.valueOf(layoutId));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        RFWLog.d("RFWLayoutPreLoader", RFWLog.USR, "register: context:" + context + " layoutId:" + layoutId);
        copyOnWriteArrayList.add(listener);
        preloadStoreOwner.getPreloadListener().put(Integer.valueOf(layoutId), copyOnWriteArrayList);
    }

    private final void replaceSelfWithView(View view, ViewGroup parent, ViewStub viewStub) {
        int indexOfChild = parent.indexOfChild(viewStub);
        parent.removeViewInLayout(viewStub);
        ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
        if (layoutParams != null) {
            parent.addView(view, indexOfChild, layoutParams);
        } else {
            parent.addView(view, indexOfChild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceViewStub(ViewStub viewStub, View preloadView, RequestPreloadViewListener preloadViewListener) {
        if (viewStub.getParent() instanceof ViewGroup) {
            if (viewStub.getInflatedId() != -1) {
                preloadView.setId(viewStub.getInflatedId());
            }
            ViewParent parent = viewStub.getParent();
            if (parent != null) {
                replaceSelfWithView(preloadView, (ViewGroup) parent, viewStub);
                if (preloadViewListener != null) {
                    RFWLog.d("RFWLayoutPreLoader", RFWLog.USR, "requestPreloadViewSuccess: viewStub.getLayoutResource:" + viewStub.getLayoutResource());
                    preloadViewListener.onPreloadResult(preloadView);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void storePreloadView(Context context, PreloadRequest preloadRequest, PreloadResult preloadResult) {
        if (context != preloadResult.getView().getContext()) {
            RFWLog.e("RFWLayoutPreLoader", RFWLog.USR, "contextHashCode:" + context + "view.contextHashCode" + preloadResult.getView().getContext());
            RFWReporter.report("MESS_INFLATE", new HashMap());
        }
        getPreloadStoreOwner(context).storePreloadView(preloadRequest, preloadResult);
    }

    public final void clearAll(boolean clearBlackIds) {
        try {
            if (RFWConfig.getConfigValue("CLEAR_ALL_LAYOUT_LOADER", true)) {
                RFWLog.d("RFWLayoutPreLoader", RFWLog.USR, "CLEAR_ALL_LAYOUT_LOADER");
                this.preloadStoreOwner.clear();
                if (clearBlackIds) {
                    this.blackLayoutIds.clear();
                }
                this.pendingRequests.clear();
            }
        } catch (Exception e16) {
            RFWLog.e("RFWLayoutPreLoader", RFWLog.USR, "clearAll catch exception", e16);
        }
    }

    public final void clearPagePreLoaders(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RFWPreloadStoreOwner remove = this.preloadStoreOwner.remove(getContextUniKey(context));
        if (remove != null) {
            RFWLog.d("RFWLayoutPreLoader", RFWLog.USR, "clearPagePreLoaders:" + getContextUniKey(context) + " ownerSize:" + this.preloadStoreOwner.size() + " storeOwner:" + remove.hashCode());
            remove.clearAll();
            if (RFWApplication.isDebug()) {
                Iterator<T> it = this.preloadStoreOwner.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    RFWLog.d("RFWLayoutPreLoader", RFWLog.USR, "checkValid key:" + ((String) entry.getKey()));
                    ((RFWPreloadStoreOwner) entry.getValue()).checkValid();
                }
                return;
            }
            return;
        }
        RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "can't find storeOwner in this preloader");
    }

    public final int fillPreloadView(@NotNull Context context, @NotNull PreloadRequest preloadRequest, int requireCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        int min = (int) Math.min(requireCount, 50);
        Context preloadContext = getPreloadContext(context, preloadRequest);
        int viewCountInCache = min - getViewCountInCache(preloadContext, preloadRequest);
        if (viewCountInCache > 0) {
            preloadView(preloadContext, preloadRequest, viewCountInCache);
        }
        return viewCountInCache;
    }

    @NotNull
    public final Context getPreloadContext(@NotNull Context requestContext, @NotNull PreloadRequest preloadRequest) {
        Context contextWrapper;
        Intrinsics.checkNotNullParameter(requestContext, "requestContext");
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        Class<?> customContextClass = preloadRequest.getCustomContextClass();
        if (customContextClass != null && (!Intrinsics.areEqual(requestContext.getClass(), preloadRequest.getCustomContextClass())) && (contextWrapper = ContextWrapperFactory.INSTANCE.getContextWrapper(customContextClass, requestContext)) != null) {
            RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "generate contextWrapper: from " + getContextUniKey(requestContext) + TokenParser.SP + " to " + getContextUniKey(contextWrapper));
            return contextWrapper;
        }
        return requestContext;
    }

    @Override // com.tencent.biz.richframework.layoutinflater.IViewProvider
    @UiThread
    @Nullable
    public PreloadResult getPreloadResult(@NotNull Context context, @NotNull PreloadRequest preloadRequest, boolean inflateIfNotExist) {
        PreloadResult poll;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        RFWPreloadStoreOwner preloadStoreOwner = getPreloadStoreOwner(context);
        synchronized (this) {
            ArrayBlockingQueue<PreloadResult> arrayBlockingQueue = preloadStoreOwner.getPreloadViewsByLayoutId().get(preloadRequest);
            if (arrayBlockingQueue != null && !arrayBlockingQueue.isEmpty() && (poll = arrayBlockingQueue.poll()) != null) {
                RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "preloadSuccess: layoutId:" + preloadRequest.getResId());
                return poll;
            }
            Unit unit = Unit.INSTANCE;
            if (inflateIfNotExist) {
                if (RFWApplication.isDebug()) {
                    RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "preloadFailed: inflate layoutId:" + preloadRequest.getResId());
                }
                View inflate = LayoutInflater.from(context).inflate(preloadRequest.getResId(), (ViewGroup) null, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont\u2026quest.resId, null, false)");
                return new PreloadResult(inflate, false);
            }
            if (RFWApplication.isDebug()) {
                RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "getPreloadView null: inflate layoutId:" + preloadRequest.getResId());
            }
            return null;
        }
    }

    @UiThread
    @Nullable
    public final View getPreloadView(@NotNull Context context, int layoutId, boolean inflateIfNotExist) {
        Intrinsics.checkNotNullParameter(context, "context");
        PreloadResult preloadResult = getPreloadResult(context, new PreloadRequest(layoutId, "", null, 4, null), inflateIfNotExist);
        if (preloadResult != null) {
            return preloadResult.getView();
        }
        return null;
    }

    public final int getViewCountInCache(@NotNull Context context, int layoutId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getViewCountInCache(context, new PreloadRequest(layoutId, "", null, 4, null));
    }

    public final void preloadView(@NotNull Context context, int layoutId, int preloadCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        preloadView(context, new PreloadRequest(layoutId, "", null, 4, null), preloadCount);
    }

    public final void requestPreloadViewForViewStub(@Nullable ViewStub viewStub, @Nullable RequestPreloadViewListener listener) {
        if (viewStub == null) {
            return;
        }
        Context context = viewStub.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewStub.context");
        View preloadView = getPreloadView(context, viewStub.getLayoutResource(), false);
        if (preloadView != null && (viewStub.getParent() instanceof ViewGroup)) {
            RFWLog.d("RFWLayoutPreLoader", RFWLog.DEV, "preloadSuccess: layoutId:" + viewStub.getLayoutResource());
            replaceViewStub(viewStub, preloadView, listener);
            return;
        }
        if (this.mLoaderStrategy.getInflateMode() == RFWInflateType.ASYNC_LAYOUT_INFLATER_SUB_THREAD_FIRST) {
            RFWLog.d("RFWLayoutPreLoader", RFWLog.DEV, "not preload start subTread load: layoutId:" + viewStub.getLayoutResource());
            Context context2 = viewStub.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "viewStub.context");
            registerEachListener(context2, viewStub.getLayoutResource(), new ViewStubPreloadViewListener(this, viewStub, listener));
            Context context3 = viewStub.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "viewStub.context");
            preloadView(context3, viewStub.getLayoutResource());
            return;
        }
        if (listener != null) {
            try {
                RFWLog.d("RFWLayoutPreLoader", RFWLog.DEV, "not preload: ui thread load: layoutId:" + viewStub.getLayoutResource());
                View inflate = viewStub.inflate();
                Intrinsics.checkNotNullExpressionValue(inflate, "viewStub.inflate()");
                listener.onPreloadResult(inflate);
            } catch (Throwable th5) {
                RFWLog.fatal("RFWLayoutPreLoader", RFWLog.USR, th5);
            }
        }
    }

    public final void setPreloadPending(boolean isPending) {
        RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "setPreloadPending:" + isPending);
        if (this.preloadPending.getAndSet(isPending) && !isPending) {
            RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "consume pendingRequests:" + this.pendingRequests.size());
            while (true) {
                PendingBatchPreloadRequest poll = this.pendingRequests.poll();
                if (poll != null) {
                    Context context = poll.getContextWrf().get();
                    if (context != null) {
                        Intrinsics.checkNotNullExpressionValue(context, "pendingRequest.contextWrf.get() ?: continue");
                        preloadView(context, poll.getPreloadRequest(), poll.getPreloadCount());
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final int getViewCountInCache(@NotNull Context context, @NotNull PreloadRequest preloadRequest) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        RFWPreloadStoreOwner preloadStoreOwner = getPreloadStoreOwner(getPreloadContext(context, preloadRequest));
        preloadStoreOwner.getPreloadViewsByLayoutId();
        ArrayBlockingQueue<PreloadResult> arrayBlockingQueue = preloadStoreOwner.getPreloadViewsByLayoutId().get(preloadRequest);
        if (arrayBlockingQueue != null) {
            return arrayBlockingQueue.size();
        }
        return 0;
    }

    public final void preloadView(@NotNull Context context, @NotNull PreloadRequest preloadRequest, int preloadCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preloadRequest, "preloadRequest");
        Context preloadContext = getPreloadContext(context, preloadRequest);
        if (this.preloadPending.get()) {
            this.pendingRequests.add(new PendingBatchPreloadRequest(new WeakReference(preloadContext), preloadRequest, preloadCount));
            return;
        }
        ViewGroup parentViewGroup = ParentViewGroupPool.INSTANCE.getParentViewGroup(preloadRequest);
        if (parentViewGroup != null || TextUtils.isEmpty(preloadRequest.getParentViewClassName())) {
            preloadView(preloadContext, preloadRequest.getResId(), parentViewGroup, preloadCount);
        }
    }

    @Deprecated(message = "")
    @NotNull
    public final View getPreloadView(@NotNull ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        Context context = viewStub.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewStub.context");
        View preloadView = getPreloadView(context, viewStub.getLayoutResource(), false);
        if (preloadView != null && (viewStub.getParent() instanceof ViewGroup)) {
            if (viewStub.getInflatedId() != -1) {
                preloadView.setId(viewStub.getInflatedId());
            }
            ViewParent parent = viewStub.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            replaceSelfWithView(preloadView, (ViewGroup) parent, viewStub);
            return preloadView;
        }
        View inflate = viewStub.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "viewStub.inflate()");
        return inflate;
    }

    private final void preloadView(Context context, int layoutId, ViewGroup parentView, int preloadCount) {
        int min = (int) Math.min(preloadCount, 50);
        do {
            preloadView(context, layoutId, parentView);
            min--;
        } while (min > 0);
    }

    public final void preloadView(@NotNull Context context, int layoutId) {
        Intrinsics.checkNotNullParameter(context, "context");
        preloadView(context, layoutId, (ViewGroup) null);
    }

    private final void preloadView(final Context context, final int layoutId, final ViewGroup parentView) {
        RFWPreloadStoreOwner preloadStoreOwner = getPreloadStoreOwner(context);
        if (preloadStoreOwner.getRFInflater() == null) {
            return;
        }
        if (isInValidRequestParent(parentView)) {
            RFWLog.e("RFWLayoutPreLoader", RFWLog.USR, "isInValidRequestParent");
            return;
        }
        if (!globalBlackLayoutIds.contains(Integer.valueOf(layoutId)) && !this.blackLayoutIds.containsKey(Integer.valueOf(layoutId))) {
            LayoutPreloadConfigManager layoutPreloadConfigManager = LayoutPreloadConfigManager.INSTANCE;
            if (!layoutPreloadConfigManager.getPreloadConfig().getPreloadEnable()) {
                RFWLog.e("RFWLayoutPreLoader", RFWLog.USR, "is preloadConfig not enable");
                return;
            }
            if (layoutPreloadConfigManager.getPreloadConfig().getBlackLayoutIds().contains(Integer.valueOf(layoutId))) {
                RFWLog.e("RFWLayoutPreLoader", RFWLog.USR, "is in preloadConfig.blackLayoutIds");
                return;
            }
            RFWAsyncLayoutInflater rFInflater = preloadStoreOwner.getRFInflater();
            if (rFInflater != null) {
                rFInflater.inflate(layoutId, parentView, new RFWAsyncLayoutInflater.OnInflateFinishedListener() { // from class: com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader$preloadView$1
                    @Override // com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater.OnInflateFinishedListener
                    public void onInflateError(@Nullable Throwable e16) {
                        Map map;
                        String str;
                        map = RFWLayoutPreLoader.this.blackLayoutIds;
                        map.put(Integer.valueOf(layoutId), e16);
                        if (!RFWApplication.isPublicVersion()) {
                            try {
                                HashMap hashMap = new HashMap();
                                Application application = RFWApplication.getApplication();
                                Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                                hashMap.put("layoutResName", application.getResources().getResourceName(layoutId));
                                if (e16 == null || (str = e16.getMessage()) == null) {
                                    str = "";
                                }
                                hashMap.put("error", str);
                                Unit unit = Unit.INSTANCE;
                                RFWReporter.reportCommonEvent("preload_inflate_error", hashMap);
                            } catch (Exception e17) {
                                RFWLog.e("RFWLayoutPreLoader", RFWLog.USR, e17);
                            }
                        }
                    }

                    @Override // com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater.OnInflateFinishedListener
                    public void onInflateFinished(@NotNull View view, int resId, @Nullable ViewGroup parent, boolean isMerge) {
                        boolean isValidContext;
                        RFWLayoutPreLoader.RequestPreloadViewListener headValidListener;
                        String str;
                        RecyclerView.LayoutManager layoutManager;
                        String contextUniKey;
                        Intrinsics.checkNotNullParameter(view, "view");
                        isValidContext = RFWLayoutPreLoader.this.isValidContext(context);
                        if (!isValidContext) {
                            return;
                        }
                        if (RFWApplication.isDebug()) {
                            int i3 = RFWLog.USR;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("storeWith: ");
                            contextUniKey = RFWLayoutPreLoader.this.getContextUniKey(context);
                            sb5.append(contextUniKey);
                            RFWLog.i("RFWLayoutPreLoader", i3, sb5.toString());
                        }
                        headValidListener = RFWLayoutPreLoader.this.getHeadValidListener(context, layoutId);
                        if (headValidListener != null) {
                            if (RFWApplication.isDebug()) {
                                RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "headValidListener is " + headValidListener.hashCode() + " resId:" + resId);
                            }
                            headValidListener.onPreloadResult(view);
                            return;
                        }
                        if (RFWApplication.isDebug()) {
                            RFWLog.i("RFWLayoutPreLoader", RFWLog.USR, "headValidListener is null storeView resId:" + resId);
                        }
                        ViewGroup viewGroup = parentView;
                        String str2 = "";
                        if (viewGroup == null) {
                            str = "";
                        } else {
                            String name = viewGroup.getClass().getName();
                            Intrinsics.checkNotNullExpressionValue(name, "parentView.javaClass.name");
                            ViewGroup viewGroup2 = parentView;
                            if ((viewGroup2 instanceof RecyclerView) && ((RecyclerView) viewGroup2).getLayoutManager() != null && (layoutManager = ((RecyclerView) parentView).getLayoutManager()) != null) {
                                str2 = layoutManager.getClass().getName();
                            }
                            String str3 = str2;
                            str2 = name;
                            str = str3;
                        }
                        RFWLayoutPreLoader.this.storePreloadView(context, new PreloadRequest(resId, str2, str), new PreloadResult(view, isMerge));
                    }
                });
                return;
            }
            return;
        }
        RFWLog.e("RFWLayoutPreLoader", RFWLog.USR, "is blackLayoutId:" + layoutId);
    }
}
