package androidx.fragment.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Argus;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.argus.WindowCallbackWrapper;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.page.PageInfo;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0019"}, d2 = {"androidx/fragment/app/Argus$startMonitor$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "doAfterCreated", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "doAfterResumed", "decorView", "Landroid/view/View;", "doOnActivityDestroyed", "generatePageInfo", "onActivityCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPostCreated", "onActivityPostResumed", "onActivityPostStopped", "onActivityPreDestroyed", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class Argus$startMonitor$1 implements Application.ActivityLifecycleCallbacks {
    /* JADX INFO: Access modifiers changed from: private */
    public final void generatePageInfo(View decorView, Activity activity) {
        Map map;
        Map map2;
        Map map3;
        ArgusNode<?> node = Argus.INSTANCE.getNode(decorView, activity, true);
        if (node != null) {
            if (activity.getParent() != null) {
                RFWLog.i(Argus.TAG, RFWLog.USR, "generatePageInfo: is localActivity " + activity);
                return;
            }
            if (!Intrinsics.areEqual(node.getContainer(), activity)) {
                RFWLog.e(Argus.TAG, RFWLog.USR, "generatePageInfo: container is not the same " + node.getContainer() + TokenParser.SP + activity);
            }
            View peekDecorView = activity.getWindow().peekDecorView();
            Intrinsics.checkNotNullExpressionValue(peekDecorView, "activity.window.peekDecorView()");
            int hashCode = peekDecorView.getWindowToken().hashCode();
            map = Argus.allPages;
            PageInfo pageInfo = (PageInfo) map.get(Integer.valueOf(hashCode));
            if (pageInfo == null) {
                PageInfo pageInfo2 = new PageInfo(hashCode, node, new LinkedHashSet());
                map3 = Argus.allPages;
                map3.put(Integer.valueOf(hashCode), pageInfo2);
                RFWLog.i(Argus.TAG, RFWLog.USR, "generatePageInfo: page " + pageInfo2);
                return;
            }
            RFWLog.i(Argus.TAG, RFWLog.USR, "already exist page " + pageInfo.getRootNode());
            if (!Intrinsics.areEqual(pageInfo.getRootNode().getContainer(), activity)) {
                RFWLog.i(Argus.TAG, RFWLog.USR, "but page root is not the same, replace it " + pageInfo.getRootNode().getContainer());
                PageInfo pageInfo3 = new PageInfo(hashCode, node, new LinkedHashSet());
                map2 = Argus.allPages;
                map2.put(Integer.valueOf(hashCode), pageInfo3);
            }
        }
    }

    public final void doAfterCreated(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityCreated " + activity);
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        WindowCallbackWrapper windowCallbackWrapper = new WindowCallbackWrapper(activity, window.getCallback());
        Window window2 = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "activity.window");
        window2.setCallback(windowCallbackWrapper);
        Argus argus = Argus.INSTANCE;
        Window window3 = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window3, "activity.window");
        View decorView = window3.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        argus.getNode(decorView, activity, true);
    }

    public final void doAfterResumed(@NotNull final Activity activity, @NotNull final View decorView) {
        Object obj;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        Lifecycle.State state = null;
        if (!(activity instanceof LifecycleOwner)) {
            obj = null;
        } else {
            obj = activity;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) obj;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            state = lifecycle.getCurrentState();
        }
        if (state == Lifecycle.State.RESUMED && decorView.isAttachedToWindow()) {
            Argus.INSTANCE.updatePage(decorView);
        } else {
            decorView.post(new Runnable() { // from class: androidx.fragment.app.Argus$startMonitor$1$doAfterResumed$1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle lifecycle2;
                    if (!activity.isDestroyed() && !activity.isFinishing()) {
                        ComponentCallbacks2 componentCallbacks2 = activity;
                        Lifecycle.State state2 = null;
                        if (!(componentCallbacks2 instanceof LifecycleOwner)) {
                            componentCallbacks2 = null;
                        }
                        LifecycleOwner lifecycleOwner2 = (LifecycleOwner) componentCallbacks2;
                        if (lifecycleOwner2 != null && (lifecycle2 = lifecycleOwner2.getLifecycle()) != null) {
                            state2 = lifecycle2.getCurrentState();
                        }
                        if (state2 == Lifecycle.State.RESUMED) {
                            Argus$startMonitor$1.this.generatePageInfo(decorView, activity);
                            Argus.INSTANCE.updatePage(decorView);
                            return;
                        } else {
                            RFWLog.i(Argus.TAG, RFWLog.USR, "is not resumed activity return");
                            return;
                        }
                    }
                    RFWLog.i(Argus.TAG, RFWLog.USR, "activity is destroyed or finishing do not generate page info");
                }
            });
        }
    }

    public final void doOnActivityDestroyed(@NotNull Activity activity) {
        Map map;
        Intrinsics.checkNotNullParameter(activity, "activity");
        View peekDecorView = activity.getWindow().peekDecorView();
        if (peekDecorView != null && peekDecorView.getWindowToken() != null) {
            peekDecorView.setTag(R.id.t8x, null);
            if (activity.getParent() == null) {
                Argus argus = Argus.INSTANCE;
                map = Argus.allPages;
                PageInfo pageInfo = (PageInfo) map.remove(Integer.valueOf(peekDecorView.getWindowToken().hashCode()));
                RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityPreDestroyed " + activity + " remove:" + pageInfo);
                return;
            }
            return;
        }
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityPreDestroyed getWindow token failed" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull final Activity activity, @Nullable Bundle savedInstanceState) {
        OperationChangeListener operationChangeListener;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Argus.INSTANCE.updateConfig();
        if (activity instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            supportFragmentManager.registerFragmentLifecycleCallbacks(new Argus.RouteFragmentLifecycleCallback(), true);
            operationChangeListener = Argus.operationChangeListener;
            FragmentManagerControllerFactoryHelper.setSpecialEffectsControllerFactory(supportFragmentManager, new RFWSpecialEffectsControllerFactory(operationChangeListener));
        } else {
            RFWLog.i(Argus.TAG, RFWLog.USR, "is not fragmentActivity " + activity);
        }
        if (Build.VERSION.SDK_INT < 29) {
            activity.runOnUiThread(new Runnable() { // from class: androidx.fragment.app.Argus$startMonitor$1$onActivityCreated$1
                @Override // java.lang.Runnable
                public final void run() {
                    Argus$startMonitor$1.this.doAfterCreated(activity);
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            doOnActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityPaused " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 29) {
            doAfterCreated(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityResumed:" + activity);
        View decorView = activity.getWindow().peekDecorView();
        if (Build.VERSION.SDK_INT >= 29) {
            Intrinsics.checkNotNullExpressionValue(decorView, "decorView");
            doAfterResumed(activity, decorView);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityPostStopped " + activity);
        Argus argus = Argus.INSTANCE;
        View peekDecorView = activity.getWindow().peekDecorView();
        Intrinsics.checkNotNullExpressionValue(peekDecorView, "activity.window.peekDecorView()");
        argus.updatePage(peekDecorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 29) {
            doOnActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityResumed:" + activity);
        View decorView = activity.getWindow().peekDecorView();
        if (Build.VERSION.SDK_INT < 29) {
            Intrinsics.checkNotNullExpressionValue(decorView, "decorView");
            doAfterResumed(activity, decorView);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityStarted:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.i(Argus.TAG, RFWLog.USR, "onActivityStopped " + activity);
    }
}
