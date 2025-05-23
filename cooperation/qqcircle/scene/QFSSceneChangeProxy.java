package cooperation.qqcircle.scene;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.mobileqq.perf.tracker.callback.a;
import com.tencent.mobileqq.qcircle.api.event.QFSSceneChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.scene.QFSSceneChangeProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class QFSSceneChangeProxy extends a {
    public static final AtomicBoolean REGISTER_SCENE_EVENT = new AtomicBoolean(false);
    private static final String TAG = "QFSSceneChangeProxy";

    private void beginScene(String str) {
        if (!REGISTER_SCENE_EVENT.get()) {
            return;
        }
        final QFSSceneChangeEvent qFSSceneChangeEvent = new QFSSceneChangeEvent(str, 0);
        if (ProcessUtil.isMainProcess(MobileQQ.sMobileQQ)) {
            updateSceneChangeEvent(qFSSceneChangeEvent);
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: t05.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSceneChangeProxy.lambda$beginScene$0(QFSSceneChangeEvent.this);
                }
            });
        }
    }

    private void endScene(String str) {
        if (!REGISTER_SCENE_EVENT.get()) {
            return;
        }
        final QFSSceneChangeEvent qFSSceneChangeEvent = new QFSSceneChangeEvent(str, 1);
        if (ProcessUtil.isMainProcess(MobileQQ.sMobileQQ)) {
            updateSceneChangeEvent(qFSSceneChangeEvent);
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: t05.a
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSceneChangeProxy.lambda$endScene$1(QFSSceneChangeEvent.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$beginScene$0(QFSSceneChangeEvent qFSSceneChangeEvent) {
        try {
            SimpleEventBus.getInstance().dispatchEvent(qFSSceneChangeEvent, true);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[beginScene] dispatch error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$endScene$1(QFSSceneChangeEvent qFSSceneChangeEvent) {
        try {
            SimpleEventBus.getInstance().dispatchEvent(qFSSceneChangeEvent, true);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[endScene] dispatch error: ", th5);
        }
    }

    public static void setRegisterSceneChangeEvent(boolean z16) {
        REGISTER_SCENE_EVENT.set(z16);
    }

    private void updateSceneChangeEvent(QFSSceneChangeEvent qFSSceneChangeEvent) {
        com.tencent.mobileqq.qcircle.api.a sceneChangeCallback = QCircleListenerProxyManager.getInstance().getSceneChangeCallback();
        if (sceneChangeCallback == null) {
            return;
        }
        sceneChangeCallback.a(qFSSceneChangeEvent);
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        super.onActivityPaused(activity);
        endScene(activity.getClass().getName());
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        super.onActivityResumed(activity);
        beginScene(activity.getClass().getName());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        endScene(fragment.getClass().getName());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        beginScene(fragment.getClass().getName());
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void onQFragmentPaused(@NonNull Fragment fragment) {
        super.onQFragmentPaused(fragment);
        endScene(fragment.getClass().getName());
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void onQFragmentResumed(@NonNull Fragment fragment) {
        super.onQFragmentResumed(fragment);
        beginScene(fragment.getClass().getName());
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void traceEnd(@NonNull String str) {
        super.traceEnd(str);
        endScene(str);
    }

    @Override // com.tencent.mobileqq.perf.tracker.callback.a
    public void traceStart(@NonNull String str, boolean z16) {
        super.traceStart(str, z16);
        beginScene(str);
    }
}
