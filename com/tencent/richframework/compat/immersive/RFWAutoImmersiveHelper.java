package com.tencent.richframework.compat.immersive;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.UiThread;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.richframework.compat.immersive.task.NavigatorUpdateTask;
import com.tencent.richframework.compat.immersive.task.StatusBarUpdateTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\bH\u0007R\"\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWAutoImmersiveHelper;", "", "", "key", "Ljava/lang/Runnable;", "runnable", "", "removeTask", "Landroid/view/Window;", "detectWindow", "adjustStatusBarTextColor", "startStatusTask", "adjustNavigatorBarColor", "startNavigatorTask", "", "delayTime", "runInMain", "window", "Lcom/tencent/richframework/compat/immersive/WindowColorFetcherState;", "getColorFetcherState", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "skipClass", "Ljava/util/List;", "", "Lcom/tencent/richframework/compat/immersive/task/StatusBarUpdateTask;", "waitingStatusUpdateTask", "Ljava/util/Map;", "Lcom/tencent/richframework/compat/immersive/task/NavigatorUpdateTask;", "waitingNavigatorUpdateTask", "updateState", "", "observedWindows", "Ljava/util/Set;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "<init>", "()V", "InnerOnPreDrawListener", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWAutoImmersiveHelper {

    @NotNull
    public static final RFWAutoImmersiveHelper INSTANCE = new RFWAutoImmersiveHelper();
    private static final List<Class<? extends Activity>> skipClass = new ArrayList();
    private static final Map<Integer, StatusBarUpdateTask> waitingStatusUpdateTask = new ConcurrentHashMap();
    private static final Map<Integer, NavigatorUpdateTask> waitingNavigatorUpdateTask = new ConcurrentHashMap();
    private static final Map<Integer, WindowColorFetcherState> updateState = new ConcurrentHashMap();
    private static final Set<Integer> observedWindows = new HashSet();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/compat/immersive/RFWAutoImmersiveHelper$InnerOnPreDrawListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Ljava/lang/Runnable;", "Landroid/view/Window;", "window", "", "updateColor", "", "onPreDraw", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "windowWrf", "Ljava/lang/ref/WeakReference;", "updateStatusBarTextColor", "Z", "updateNavigationBarColor", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    private static final class InnerOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener, Runnable {
        private final boolean updateNavigationBarColor;
        private final boolean updateStatusBarTextColor;
        private final WeakReference<Window> windowWrf;

        private final void updateColor(Window window) {
            if (this.updateNavigationBarColor) {
                RFWAutoImmersiveHelper.INSTANCE.adjustNavigatorBarColor(window);
            }
            if (this.updateStatusBarTextColor) {
                RFWAutoImmersiveHelper.INSTANCE.adjustStatusBarTextColor(window);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Window window = this.windowWrf.get();
            if (window != null) {
                Intrinsics.checkNotNullExpressionValue(window, "windowWrf.get() ?: return true");
                View decorView = window.getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
                decorView.getViewTreeObserver().removeOnPreDrawListener(this);
                updateColor(window);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            Window window = this.windowWrf.get();
            if (window != null) {
                Intrinsics.checkNotNullExpressionValue(window, "windowWrf.get() ?: return");
                updateColor(window);
            }
        }
    }

    RFWAutoImmersiveHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustNavigatorBarColor(Window detectWindow) {
        if (!AutoImmersiveConfig.isEnableAdjustNavigationBar()) {
            return;
        }
        if (!RFWImmersiveUtils.isNavigationBarExist(detectWindow)) {
            RFWLog.e("RFWAutoImmersiveHelper", RFWLog.USR, "adjustNavigatorBarColor but navigatorBar is not exist");
        } else {
            startNavigatorTask(detectWindow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustStatusBarTextColor(Window detectWindow) {
        if (!AutoImmersiveConfig.isEnableAutoStatusBarTextColor() || !RFWImmersiveUtils.isStatusBarTextShow(detectWindow)) {
            return;
        }
        startStatusTask(detectWindow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeTask(int key, Runnable runnable) {
        Map<Integer, NavigatorUpdateTask> map = waitingNavigatorUpdateTask;
        if (Intrinsics.areEqual(map.get(Integer.valueOf(key)), runnable)) {
            map.remove(Integer.valueOf(key));
            return;
        }
        Map<Integer, StatusBarUpdateTask> map2 = waitingStatusUpdateTask;
        if (map2.get(Integer.valueOf(key)) == runnable) {
            map2.remove(Integer.valueOf(key));
        }
    }

    public static /* synthetic */ void runInMain$default(RFWAutoImmersiveHelper rFWAutoImmersiveHelper, Runnable runnable, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            j3 = 0;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        rFWAutoImmersiveHelper.runInMain(runnable, j3, i3);
    }

    private final void startNavigatorTask(Window detectWindow) {
        if (AutoImmersiveConfig.isOpenFrequencyControl()) {
            Map<Integer, NavigatorUpdateTask> map = waitingNavigatorUpdateTask;
            if (map.get(Integer.valueOf(detectWindow.hashCode())) == null) {
                NavigatorUpdateTask navigatorUpdateTask = new NavigatorUpdateTask(detectWindow);
                map.put(Integer.valueOf(detectWindow.hashCode()), navigatorUpdateTask);
                runInMain(navigatorUpdateTask, 50L, detectWindow.hashCode());
                return;
            }
            return;
        }
        new NavigatorUpdateTask(detectWindow).run();
    }

    private final void startStatusTask(Window detectWindow) {
        Map<Integer, StatusBarUpdateTask> map = waitingStatusUpdateTask;
        StatusBarUpdateTask statusBarUpdateTask = map.get(Integer.valueOf(detectWindow.hashCode()));
        if (AutoImmersiveConfig.isOpenFrequencyControl()) {
            if (statusBarUpdateTask == null) {
                StatusBarUpdateTask statusBarUpdateTask2 = new StatusBarUpdateTask(detectWindow);
                map.put(Integer.valueOf(detectWindow.hashCode()), statusBarUpdateTask2);
                runInMain(statusBarUpdateTask2, 50L, detectWindow.hashCode());
                return;
            }
            return;
        }
        if (statusBarUpdateTask != null) {
            detectWindow.getDecorView().removeCallbacks(statusBarUpdateTask);
            statusBarUpdateTask.setCancel(true);
        }
        StatusBarUpdateTask statusBarUpdateTask3 = new StatusBarUpdateTask(detectWindow);
        statusBarUpdateTask3.run();
        map.put(Integer.valueOf(detectWindow.hashCode()), statusBarUpdateTask3);
    }

    @UiThread
    @NotNull
    public final WindowColorFetcherState getColorFetcherState(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        Map<Integer, WindowColorFetcherState> map = updateState;
        WindowColorFetcherState windowColorFetcherState = map.get(Integer.valueOf(window.hashCode()));
        if (windowColorFetcherState == null) {
            WindowColorFetcherState windowColorFetcherState2 = new WindowColorFetcherState();
            map.put(Integer.valueOf(window.hashCode()), windowColorFetcherState2);
            return windowColorFetcherState2;
        }
        return windowColorFetcherState;
    }

    @JvmOverloads
    public final void runInMain(@NotNull final Runnable runnable, long delayTime, final int key) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) && delayTime == 0) {
            runnable.run();
        } else {
            mainHandler.postDelayed(new Runnable() { // from class: com.tencent.richframework.compat.immersive.RFWAutoImmersiveHelper$runInMain$1
                @Override // java.lang.Runnable
                public final void run() {
                    runnable.run();
                    RFWAutoImmersiveHelper.INSTANCE.removeTask(key, runnable);
                }
            }, delayTime);
        }
    }
}
