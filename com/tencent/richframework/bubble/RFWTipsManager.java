package com.tencent.richframework.bubble;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.bubble.controller.RFWTipsBaseController;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
public class RFWTipsManager {
    private static final Comparator<RFWTipsBaseController> TIPS_COMPARATOR = new Comparator<RFWTipsBaseController>() { // from class: com.tencent.richframework.bubble.RFWTipsManager.1
        @Override // java.util.Comparator
        public int compare(RFWTipsBaseController rFWTipsBaseController, RFWTipsBaseController rFWTipsBaseController2) {
            return rFWTipsBaseController2.getPriority() - rFWTipsBaseController.getPriority();
        }
    };
    private static volatile RFWTipsManager mInstance;
    private RFWTipsBaseController mCurrentController;
    private Queue<RFWTipsBaseController> sCurrentTipsQueue;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Map<Integer, Queue<RFWTipsBaseController>> sTipsMap = new HashMap();

    public RFWTipsManager() {
        Application application = RFWApplication.getApplication();
        if (application instanceof Application) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.richframework.bubble.RFWTipsManager.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    RFWTipsManager.this.onDestroyed(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    RFWTipsManager.this.onStop(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    RFWTipsManager.this.changeCurrentTips(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCurrentTips(Activity activity) {
        if (activity != null && this.sTipsMap.containsKey(Integer.valueOf(activity.hashCode()))) {
            this.sCurrentTipsQueue = this.sTipsMap.get(Integer.valueOf(activity.hashCode()));
            this.mCurrentController = null;
            startShowTips();
        }
    }

    public static RFWTipsManager getInstance() {
        if (mInstance == null) {
            synchronized (RFWTipsManager.class) {
                if (mInstance == null) {
                    mInstance = new RFWTipsManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasTip(Queue<RFWTipsBaseController> queue, RFWTipsBaseController rFWTipsBaseController) {
        boolean z16;
        while (true) {
            for (RFWTipsBaseController rFWTipsBaseController2 : queue) {
                z16 = z16 || hasTip(rFWTipsBaseController, rFWTipsBaseController2);
            }
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroyed(Activity activity) {
        Map<Integer, Queue<RFWTipsBaseController>> map;
        if (activity != null && (map = this.sTipsMap) != null && map.size() != 0 && this.sTipsMap.containsKey(Integer.valueOf(activity.hashCode()))) {
            RFWTipsBaseController rFWTipsBaseController = this.mCurrentController;
            if (rFWTipsBaseController != null && rFWTipsBaseController.getContext() != null && this.mCurrentController.getContext().hashCode() == activity.hashCode()) {
                this.mCurrentController.dismiss();
                this.mCurrentController = null;
            }
            this.sTipsMap.remove(Integer.valueOf(activity.hashCode()));
            if (this.sTipsMap.size() == 0) {
                this.sCurrentTipsQueue = null;
                mInstance = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShowTips() {
        Queue<RFWTipsBaseController> queue = this.sCurrentTipsQueue;
        if (queue != null && queue.size() != 0) {
            RFWTipsBaseController rFWTipsBaseController = this.mCurrentController;
            if (rFWTipsBaseController != null && !rFWTipsBaseController.isEnded()) {
                QLog.d("RFWTipsManager", 1, "current tip is not ended");
                return;
            }
            RFWTipsBaseController poll = this.sCurrentTipsQueue.poll();
            if (poll == null) {
                this.mCurrentController = null;
                startShowTips();
            } else {
                this.mCurrentController = poll;
                poll.addTipsStatusCallBack(new RFWTipsBaseController.TipsStatusCallBack() { // from class: com.tencent.richframework.bubble.RFWTipsManager.5
                    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
                    public void dismiss() {
                        RFWTipsManager.this.mCurrentController = null;
                        RFWTipsManager.this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.richframework.bubble.RFWTipsManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RFWTipsManager.this.startShowTips();
                            }
                        }, 500L);
                    }

                    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
                    public void show() {
                    }

                    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
                    public void click(View view) {
                    }
                });
                this.mCurrentController.startShowTip();
            }
        }
    }

    public void addTips(final RFWTipsBaseController rFWTipsBaseController) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.richframework.bubble.RFWTipsManager.3
            @Override // java.lang.Runnable
            public void run() {
                RFWTipsManager.this.addTips(rFWTipsBaseController, false);
            }
        });
    }

    public void onStop(Activity activity) {
        Map<Integer, Queue<RFWTipsBaseController>> map;
        if (activity != null && (map = this.sTipsMap) != null && map.size() != 0 && this.sTipsMap.containsKey(Integer.valueOf(activity.hashCode()))) {
            this.sCurrentTipsQueue = null;
            RFWTipsBaseController rFWTipsBaseController = this.mCurrentController;
            if (rFWTipsBaseController != null && rFWTipsBaseController.getContext() != null && this.mCurrentController.getContext().hashCode() == activity.hashCode()) {
                this.mCurrentController.dismiss();
                this.mCurrentController = null;
                this.sCurrentTipsQueue = null;
            }
        }
    }

    public <T extends RFWTipsBaseController> void addTips(final T t16, final boolean z16) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.richframework.bubble.RFWTipsManager.4
            @Override // java.lang.Runnable
            public void run() {
                RFWTipsBaseController rFWTipsBaseController = t16;
                if (rFWTipsBaseController != null && rFWTipsBaseController.getContext() != null) {
                    if (RFWTipsManager.this.sTipsMap.containsKey(Integer.valueOf(t16.getContext().hashCode()))) {
                        RFWTipsManager rFWTipsManager = RFWTipsManager.this;
                        rFWTipsManager.sCurrentTipsQueue = (Queue) rFWTipsManager.sTipsMap.get(Integer.valueOf(t16.getContext().hashCode()));
                    } else {
                        RFWTipsManager.this.sTipsMap.put(Integer.valueOf(t16.getContext().hashCode()), new PriorityQueue(10, RFWTipsManager.TIPS_COMPARATOR));
                        RFWTipsManager rFWTipsManager2 = RFWTipsManager.this;
                        rFWTipsManager2.sCurrentTipsQueue = (Queue) rFWTipsManager2.sTipsMap.get(Integer.valueOf(t16.getContext().hashCode()));
                    }
                    RFWTipsManager rFWTipsManager3 = RFWTipsManager.this;
                    if (!rFWTipsManager3.hasTip(t16, rFWTipsManager3.mCurrentController)) {
                        RFWTipsManager rFWTipsManager4 = RFWTipsManager.this;
                        if (!rFWTipsManager4.hasTip((Queue<RFWTipsBaseController>) rFWTipsManager4.sCurrentTipsQueue, t16)) {
                            RFWTipsManager.this.sCurrentTipsQueue.offer(t16);
                            if (z16) {
                                RFWTipsManager.this.startShowTips();
                            } else {
                                RFWTipsManager.this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.richframework.bubble.RFWTipsManager.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        RFWTipsManager.this.startShowTips();
                                    }
                                }, 500L);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasTip(RFWTipsBaseController rFWTipsBaseController, RFWTipsBaseController rFWTipsBaseController2) {
        if (rFWTipsBaseController2 == null || rFWTipsBaseController == null || rFWTipsBaseController2.getConfig() == null || rFWTipsBaseController.getConfig() == null || TextUtils.isEmpty(rFWTipsBaseController2.getConfig().getTitle())) {
            return false;
        }
        return rFWTipsBaseController2.getConfig().getTitle().equals(rFWTipsBaseController.getConfig().getTitle());
    }
}
