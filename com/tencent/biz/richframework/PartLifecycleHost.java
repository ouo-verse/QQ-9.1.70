package com.tencent.biz.richframework;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.tencent.biz.richframework.PartLifecycleHost;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.richframework.lifecycle.RFWViewLifecycleUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ne0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/richframework/PartLifecycleHost;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "Landroid/content/ComponentCallbacks;", "()V", "contentView", "Landroid/view/View;", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "partManager", "Lcom/tencent/biz/richframework/part/PartManager;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getHostActivity", "Landroid/app/Activity;", "getHostContext", "Landroid/content/Context;", "getHostLifecycleOwner", "getViewModelStore", "init", "", "view", "initPartManager", "hostView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "PartViewLifecycleObserver", "lifecycle-host_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class PartLifecycleHost implements IPartHost, ComponentCallbacks {
    private View contentView;
    private boolean hasInit;
    private LifecycleOwner lifecycleOwner;
    private PartManager partManager;
    private ViewModelStore viewModelStore;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/PartLifecycleHost$PartViewLifecycleObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "activityWrf", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "partManagerWrf", "Lcom/tencent/biz/richframework/part/PartManager;", "componentCallbacksWrf", "Landroid/content/ComponentCallbacks;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-host_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class PartViewLifecycleObserver implements LifecycleEventObserver {
        private final WeakReference<Activity> activityWrf;
        private final WeakReference<ComponentCallbacks> componentCallbacksWrf;
        private final WeakReference<PartManager> partManagerWrf;

        public PartViewLifecycleObserver(@NotNull WeakReference<Activity> activityWrf, @NotNull WeakReference<PartManager> partManagerWrf, @NotNull WeakReference<ComponentCallbacks> componentCallbacksWrf) {
            Intrinsics.checkNotNullParameter(activityWrf, "activityWrf");
            Intrinsics.checkNotNullParameter(partManagerWrf, "partManagerWrf");
            Intrinsics.checkNotNullParameter(componentCallbacksWrf, "componentCallbacksWrf");
            this.activityWrf = activityWrf;
            this.partManagerWrf = partManagerWrf;
            this.componentCallbacksWrf = componentCallbacksWrf;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            PartManager partManager = this.partManagerWrf.get();
            if (partManager != null) {
                Intrinsics.checkNotNullExpressionValue(partManager, "partManagerWrf.get() ?: return");
                Activity activity = this.activityWrf.get();
                if (activity != null) {
                    Intrinsics.checkNotNullExpressionValue(activity, "activityWrf.get() ?: return");
                    Application application = null;
                    if (event == Lifecycle.Event.ON_CREATE) {
                        partManager.onPartCreate(activity, null);
                        return;
                    }
                    if (event == Lifecycle.Event.ON_START) {
                        partManager.onPartStart(activity);
                        return;
                    }
                    if (event == Lifecycle.Event.ON_RESUME) {
                        partManager.onPartResume(activity);
                        return;
                    }
                    if (event == Lifecycle.Event.ON_PAUSE) {
                        partManager.onPartPause(activity);
                        return;
                    }
                    if (event == Lifecycle.Event.ON_STOP) {
                        partManager.onPartStop(activity);
                        return;
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        partManager.onPartDestroy(activity);
                        ComponentCallbacks componentCallbacks = this.componentCallbacksWrf.get();
                        if (componentCallbacks != null) {
                            Application application2 = RFWApplication.getApplication();
                            if (application2 instanceof Application) {
                                application = application2;
                            }
                            if (application != null) {
                                application.unregisterComponentCallbacks(componentCallbacks);
                            }
                        }
                        source.getLifecycle().removeObserver(this);
                    }
                }
            }
        }
    }

    public static final /* synthetic */ View access$getContentView$p(PartLifecycleHost partLifecycleHost) {
        View view = partLifecycleHost.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        return view;
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner$p(PartLifecycleHost partLifecycleHost) {
        LifecycleOwner lifecycleOwner = partLifecycleHost.lifecycleOwner;
        if (lifecycleOwner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        }
        return lifecycleOwner;
    }

    public static final /* synthetic */ PartManager access$getPartManager$p(PartLifecycleHost partLifecycleHost) {
        PartManager partManager = partLifecycleHost.partManager;
        if (partManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
        }
        return partManager;
    }

    public static final /* synthetic */ ViewModelStore access$getViewModelStore$p(PartLifecycleHost partLifecycleHost) {
        ViewModelStore viewModelStore = partLifecycleHost.viewModelStore;
        if (viewModelStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
        }
        return viewModelStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPartManager(View hostView) {
        PartManager partManager = new PartManager(this, hostView);
        partManager.setRootView(hostView);
        partManager.registerPart(assembleParts());
        Unit unit = Unit.INSTANCE;
        this.partManager = partManager;
    }

    public final boolean getHasInit() {
        return this.hasInit;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    @Nullable
    public Activity getHostActivity() {
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        Context context = view.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        return (Activity) context;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public Context getHostContext() {
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
        return context;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public LifecycleOwner getHostLifecycleOwner() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        }
        return lifecycleOwner;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        ViewModelStore viewModelStore = this.viewModelStore;
        if (viewModelStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
        }
        return viewModelStore;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Object getViewTagData() {
        return a.d(this);
    }

    public final void init(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.contentView = view;
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.richframework.PartLifecycleHost$init$initTask$1
            @Override // java.lang.Runnable
            public final void run() {
                ViewModelStore viewModelStore;
                PartLifecycleHost partLifecycleHost = PartLifecycleHost.this;
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(PartLifecycleHost.access$getContentView$p(partLifecycleHost));
                if (viewModelStoreOwner != null && (viewModelStore = viewModelStoreOwner.get_viewModelStore()) != null) {
                    partLifecycleHost.viewModelStore = viewModelStore;
                    PartLifecycleHost partLifecycleHost2 = PartLifecycleHost.this;
                    LifecycleOwner viewLifecycleOwner = RFWViewLifecycleUtil.getViewLifecycleOwner(PartLifecycleHost.access$getContentView$p(partLifecycleHost2), true);
                    if (viewLifecycleOwner != null) {
                        partLifecycleHost2.lifecycleOwner = viewLifecycleOwner;
                        PartLifecycleHost partLifecycleHost3 = PartLifecycleHost.this;
                        partLifecycleHost3.initPartManager(PartLifecycleHost.access$getContentView$p(partLifecycleHost3));
                        PartLifecycleHost.access$getLifecycleOwner$p(PartLifecycleHost.this).getLifecycle().addObserver(new PartLifecycleHost.PartViewLifecycleObserver(new WeakReference(PartLifecycleHost.this.getHostActivity()), new WeakReference(PartLifecycleHost.access$getPartManager$p(PartLifecycleHost.this)), new WeakReference(PartLifecycleHost.this)));
                        Application application = RFWApplication.getApplication();
                        if (!(application instanceof Application)) {
                            application = null;
                        }
                        if (application != null) {
                            application.registerComponentCallbacks(PartLifecycleHost.this);
                        }
                        PartLifecycleHost.this.setHasInit(true);
                    }
                }
            }
        };
        View view2 = this.contentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        if (view2.isAttachedToWindow() && !(!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            runnable.run();
            return;
        }
        View view3 = this.contentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        view3.post(runnable);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        PartManager partManager = this.partManager;
        if (partManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
        }
        partManager.onConfigurationChanged(newConfig);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    public final void setHasInit(boolean z16) {
        this.hasInit = z16;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }
}
