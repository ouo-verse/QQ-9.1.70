package com.tencent.richframework.preload.activity;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.hook.instrumentation.HookedInstrumentation;
import com.tencent.biz.richframework.hook.instrumentation.InnerInstrumentationDelegate;
import com.tencent.richframework.preload.activity.BaseActivityPreloadTask;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ2\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/richframework/preload/activity/ActivityPreloadManager;", "Lcom/tencent/biz/richframework/hook/instrumentation/InnerInstrumentationDelegate;", "Landroid/os/MessageQueue$IdleHandler;", "", "initHookInstrumentation", "Ljava/lang/Runnable;", "runnable", "runInMain", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask;", "task", "executeTask", "removePreloadTask", "addPreloadTask", "Landroid/content/Context;", "context", "Landroid/app/Instrumentation;", "instrumentation", "Ljava/lang/ClassLoader;", "cl", "", PushClientConstants.TAG_CLASS_NAME, "Landroid/content/Intent;", "intent", "Landroid/app/Activity;", "newActivity", "", "queueIdle", "", "preloadTask", "Ljava/util/Map;", "activityStore", "", "targetClassName", "Ljava/util/Set;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "initSuccess", "Z", "<init>", "()V", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ActivityPreloadManager implements InnerInstrumentationDelegate, MessageQueue.IdleHandler {

    @NotNull
    public static final ActivityPreloadManager INSTANCE;
    private static final Map<String, Activity> activityStore;
    private static final Handler handler;
    private static boolean initSuccess;
    private static final Map<String, BaseActivityPreloadTask> preloadTask;
    private static final Set<String> targetClassName;

    static {
        ActivityPreloadManager activityPreloadManager = new ActivityPreloadManager();
        INSTANCE = activityPreloadManager;
        preloadTask = new HashMap();
        activityStore = new HashMap();
        targetClassName = new HashSet();
        handler = new Handler(Looper.getMainLooper());
        activityPreloadManager.initHookInstrumentation();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        mainLooper.getQueue().addIdleHandler(activityPreloadManager);
    }

    ActivityPreloadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeTask(final BaseActivityPreloadTask task) {
        runInMain(new Runnable() { // from class: com.tencent.richframework.preload.activity.ActivityPreloadManager$executeTask$1
            @Override // java.lang.Runnable
            public final void run() {
                Map map;
                Map map2;
                try {
                    ActivityPreloadManager activityPreloadManager = ActivityPreloadManager.INSTANCE;
                    map = ActivityPreloadManager.activityStore;
                    Activity activity = (Activity) map.get(BaseActivityPreloadTask.this.getActivityKey());
                    if (activity != null) {
                        BaseActivityPreloadTask.this.getIsReady().set(true);
                        BaseActivityPreloadTask.this.doAfterActivityCreate(activity);
                        return;
                    }
                    Activity activity2 = BaseActivityPreloadTask.this.getActivityClass().newInstance();
                    map2 = ActivityPreloadManager.activityStore;
                    map2.put(BaseActivityPreloadTask.this.getActivityKey(), activity2);
                    BaseActivityPreloadTask.this.getIsReady().set(true);
                    BaseActivityPreloadTask baseActivityPreloadTask = BaseActivityPreloadTask.this;
                    Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                    baseActivityPreloadTask.doAfterActivityCreate(activity2);
                } catch (Exception e16) {
                    RFWLog.e("ActivityPreloadManager", RFWLog.USR, " executeFailed", e16);
                }
            }
        });
    }

    private final void initHookInstrumentation() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        Application application = RFWApplication.getApplication();
        if (application != null) {
            initSuccess = HookedInstrumentation.hookInstrumentation(application.getBaseContext(), arrayList);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ContextWrapper");
    }

    private final void runInMain(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public final void addPreloadTask(@NotNull final BaseActivityPreloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        runInMain(new Runnable() { // from class: com.tencent.richframework.preload.activity.ActivityPreloadManager$addPreloadTask$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                Map map;
                Map map2;
                Set set;
                ActivityPreloadManager activityPreloadManager = ActivityPreloadManager.INSTANCE;
                z16 = ActivityPreloadManager.initSuccess;
                if (z16) {
                    map = ActivityPreloadManager.preloadTask;
                    if (!map.containsKey(BaseActivityPreloadTask.this.getTaskKey())) {
                        map2 = ActivityPreloadManager.preloadTask;
                        map2.put(BaseActivityPreloadTask.this.getTaskKey(), BaseActivityPreloadTask.this);
                        RFWLog.i("ActivityPreloadManager", RFWLog.USR, "add task:" + BaseActivityPreloadTask.this);
                        if (BaseActivityPreloadTask.this.getExecuteMode() == BaseActivityPreloadTask.ExecuteMode.AT_ONCE) {
                            activityPreloadManager.executeTask(BaseActivityPreloadTask.this);
                        }
                        set = ActivityPreloadManager.targetClassName;
                        String name = BaseActivityPreloadTask.this.getActivityClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "task.activityClass.getName()");
                        set.add(name);
                        return;
                    }
                    RFWLog.e("ActivityPreloadManager", RFWLog.USR, "exist same preload task, can't add same type preload task twice. task key:" + BaseActivityPreloadTask.this.getTaskKey());
                    return;
                }
                RFWLog.e("ActivityPreloadManager", RFWLog.USR, "initFailed");
            }
        });
    }

    @Override // com.tencent.biz.richframework.hook.instrumentation.InnerInstrumentationDelegate
    @Nullable
    public Activity newActivity(@NotNull Context context, @NotNull Instrumentation instrumentation, @NotNull ClassLoader cl5, @NotNull String className, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instrumentation, "instrumentation");
        Intrinsics.checkNotNullParameter(cl5, "cl");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(intent, "intent");
        long nanoTime = System.nanoTime();
        if (!targetClassName.contains(className)) {
            return null;
        }
        Iterator<BaseActivityPreloadTask> it = preloadTask.values().iterator();
        Activity activity = null;
        String str = null;
        while (it.hasNext()) {
            BaseActivityPreloadTask next = it.next();
            if (activity != null && !TextUtils.isEmpty(str) && TextUtils.equals(next.getActivityKey(), str)) {
                if (next.getPreloadMode() == BaseActivityPreloadTask.PreloadMode.ONCE) {
                    it.remove();
                } else if (next.getPreloadMode() == BaseActivityPreloadTask.PreloadMode.RECYCLE) {
                    next.getIsReady().set(false);
                }
            } else if (next.getIsReady().get() && next.isTarget(cl5, className, intent)) {
                activity = activityStore.remove(next.getActivityKey());
                if (activity == null) {
                    return null;
                }
                str = next.getActivityKey();
                if (next.getPreloadMode() == BaseActivityPreloadTask.PreloadMode.ONCE) {
                    it.remove();
                } else if (next.getPreloadMode() == BaseActivityPreloadTask.PreloadMode.RECYCLE) {
                    next.getIsReady().set(false);
                }
                next.doBeforeActivityBeUse(activity);
            }
        }
        if (activity != null) {
            RFWLog.i("ActivityPreloadManager", RFWLog.USR, "hit cost:" + (System.nanoTime() - nanoTime));
        }
        return activity;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        Object obj;
        Iterator<T> it = preloadTask.values().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (!((BaseActivityPreloadTask) obj).getIsReady().get()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        BaseActivityPreloadTask baseActivityPreloadTask = (BaseActivityPreloadTask) obj;
        if (baseActivityPreloadTask != null) {
            RFWLog.i("ActivityPreloadManager", RFWLog.USR, "idle execute task:" + baseActivityPreloadTask.getClass().getName());
            INSTANCE.executeTask(baseActivityPreloadTask);
        }
        return true;
    }

    public final void removePreloadTask(@NotNull final BaseActivityPreloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        runInMain(new Runnable() { // from class: com.tencent.richframework.preload.activity.ActivityPreloadManager$removePreloadTask$1
            @Override // java.lang.Runnable
            public final void run() {
                Map map;
                Map map2;
                try {
                    ActivityPreloadManager activityPreloadManager = ActivityPreloadManager.INSTANCE;
                    map = ActivityPreloadManager.preloadTask;
                    BaseActivityPreloadTask baseActivityPreloadTask = (BaseActivityPreloadTask) map.remove(BaseActivityPreloadTask.this.getTaskKey());
                    if (baseActivityPreloadTask != null) {
                        map2 = ActivityPreloadManager.activityStore;
                        Activity activity = (Activity) map2.remove(baseActivityPreloadTask.getActivityKey());
                        if (activity != null) {
                            baseActivityPreloadTask.clear(activity);
                        }
                        baseActivityPreloadTask.getIsReady().set(false);
                        return;
                    }
                    RFWLog.e("ActivityPreloadManager", RFWLog.USR, " preloadTask is not exist\uff0cremove nothing");
                } catch (Exception e16) {
                    RFWLog.e("ActivityPreloadManager", RFWLog.USR, e16);
                }
            }
        });
    }
}
