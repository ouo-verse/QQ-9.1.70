package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.detection.DetectionPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes22.dex */
public class PageSwitchObserver extends DefaultEventListener implements AppEventReporter.IAppEventListener {
    private static final long FORCE_DETECTION_DELAY = 80;
    private static final String TAG = "page." + PageSwitchObserver.class.getSimpleName();
    private DelayedIdleHandler mDelayedIdleHandler;
    private DetectionTask mDetectionTask;
    private boolean mIsAppForeground;
    private final ListenerMgr<IPageSwitchListener> mListenerMgr;
    private Set<Activity> mResumedActivities;
    private ViewActivityMap mViewActivityMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class DetectionTask extends DelayedIdleHandler.DelayedRunnable {
        private WeakReference<Activity> mActivityRef;

        DetectionTask() {
            this.mActivityRef = new WeakReference<>(null);
        }

        Activity getActivity() {
            WeakReference<Activity> weakReference = this.mActivityRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.DelayedRunnable
        public void run(int i3) {
            Activity activity;
            WeakReference<Activity> weakReference = this.mActivityRef;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(PageSwitchObserver.TAG, "PendingTask.run: -------------------------------------------------------------------");
                Log.d(PageSwitchObserver.TAG, "PendingTask.run: activity = " + activity + ", mIsAppForeground = " + PageSwitchObserver.this.mIsAppForeground);
            }
            if (PageSwitchObserver.this.mIsAppForeground && activity != null && !activity.isFinishing()) {
                PageSwitchObserver.this.detectActivePage(activity, i3);
                this.mActivityRef = null;
            }
        }

        void setActivity(Activity activity) {
            this.mActivityRef = new WeakReference<>(activity);
        }
    }

    /* loaded from: classes22.dex */
    public interface IPageSwitchListener {
        void onPageAppear(@NonNull PageInfo pageInfo, int i3);

        boolean onPageDestroyed(@NonNull View view);

        void onPageDisappear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final PageSwitchObserver INSTANCE;

        static {
            PageSwitchObserver pageSwitchObserver = new PageSwitchObserver();
            INSTANCE = pageSwitchObserver;
            pageSwitchObserver.init();
        }

        InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class PageDestroyCallback implements ListenerMgr.INotifyCallback<IPageSwitchListener> {
        private View disappearView;
        private boolean hasNewPageOut;

        PageDestroyCallback(@NonNull View view) {
            this.disappearView = view;
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
        public void onNotify(IPageSwitchListener iPageSwitchListener) {
            this.hasNewPageOut = iPageSwitchListener.onPageDestroyed(this.disappearView);
        }
    }

    private void checkActivity(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "onActivityResume: activity = " + activity + ", null getView()");
                return;
            }
            return;
        }
        laidOutAppear(activity, decorView);
    }

    private boolean checkPageDisappear(Window window) {
        if (window != null) {
            return checkPageDisappear(window.getDecorView());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectActivePage(Activity activity, int i3) {
        String str = "PageSwitchObserver.detectActivity(" + activity.getClass().getSimpleName() + ")";
        SimpleTracer.begin(str);
        List<WeakReference<Dialog>> dialogList = DialogListUtil.getDialogList(activity);
        for (int size = BaseUtils.size(dialogList) - 1; size >= 0; size--) {
            WeakReference<Dialog> weakReference = dialogList.get(size);
            Dialog dialog = weakReference == null ? null : weakReference.get();
            if (dialog != null && detectActivePage(dialog.getWindow(), i3)) {
                return;
            }
        }
        detectActivePage(activity.getWindow(), i3);
        SimpleTracer.end(str);
    }

    public static PageSwitchObserver getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        EventCollector.getInstance().registerEventListener(this);
        AppEventReporter.getInstance().register(this);
    }

    private void laidOutAppear(Activity activity, View view) {
        boolean isLaidOut = ViewCompatUtils.isLaidOut(view);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "laidOutAppear: activity = " + activity + ", isLaidOut = " + isLaidOut);
        }
        if (isLaidOut) {
            postAppearDetectionTask(activity);
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final WeakReference weakReference2 = new WeakReference(view);
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PageSwitchObserver.this.postAppearDetectionTask((Activity) weakReference.get());
                View view2 = (View) weakReference2.get();
                if (view2 != null) {
                    view2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        };
        view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                View view3 = (View) weakReference2.get();
                if (view3 != null) {
                    view3.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }
        });
    }

    private void notifyPageAppear(final PageInfo pageInfo, final int i3) {
        if (pageInfo != null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "notifyPageAppear: page = " + pageInfo + ", view = " + pageInfo.getPageView());
            }
            this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IPageSwitchListener>() { // from class: com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.3
                @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
                public void onNotify(IPageSwitchListener iPageSwitchListener) {
                    iPageSwitchListener.onPageAppear(pageInfo, i3);
                }
            });
        }
    }

    private boolean notifyPageDestroyed(@NonNull View view) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "notifyPageDestroyed");
        }
        PageDestroyCallback pageDestroyCallback = new PageDestroyCallback(view);
        this.mListenerMgr.startNotify(pageDestroyCallback);
        return pageDestroyCallback.hasNewPageOut;
    }

    private void notifyPageDisappear() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "notifyPageDisappear");
        }
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IPageSwitchListener>() { // from class: com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.4
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IPageSwitchListener iPageSwitchListener) {
                iPageSwitchListener.onPageDisappear();
            }
        });
    }

    private void onActivePageFound(PageInfo pageInfo, int i3) {
        notifyPageAppear(pageInfo, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAppearDetectionTask(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "postAppearDetectionTask: activity = " + activity);
        }
        if (activity != null && DetectionPolicy.isAbleToDetect(activity)) {
            if (!this.mResumedActivities.contains(activity)) {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.d(TAG, "postAppearDetectionTask: activity is not resumed, skip detection");
                    return;
                }
                return;
            } else {
                this.mDelayedIdleHandler.remove(this.mDetectionTask);
                this.mDetectionTask.setActivity(activity);
                this.mDelayedIdleHandler.post(this.mDetectionTask, 80L);
                return;
            }
        }
        Log.e(TAG, "postAppearDetectionTask: unable to detect activity");
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onActivityConfigurationChanged: activity = " + activity);
        }
        checkActivity(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityDestroyed(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onActivityDestroyed: activity = " + activity);
        }
        checkPageDisappear(activity.getWindow());
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityPause(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onActivityPause: activity = " + activity);
        }
        if (this.mDetectionTask.getActivity() == activity) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "onActivityPause: activity matched, remove idle handler");
            }
            this.mDelayedIdleHandler.remove(this.mDetectionTask);
        }
        this.mResumedActivities.remove(activity);
        if (VideoReportInner.getInstance().getConfiguration().isIndependentPageOut()) {
            checkPageDisappear(activity.getWindow());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityResume(Activity activity) {
        this.mResumedActivities.add(activity);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onActivityResume: activity = " + activity);
        }
        checkActivity(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppIn() {
        this.mIsAppForeground = true;
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppOut(boolean z16) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onAppOut: ");
        }
        this.mIsAppForeground = false;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDialogHide(Activity activity, Dialog dialog) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onDialogHide: activity = " + activity + "dialog =" + dialog);
        }
        postAppearDetectionTask(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onDialogShow(Activity activity, Dialog dialog) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onDialogShow: activity = " + activity + ", dialog = " + dialog);
        }
        postAppearDetectionTask(DialogListUtil.getDialogActivity(dialog));
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onFragmentDestroyView(FragmentCompat fragmentCompat) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onFragmentDestroyView: fragment = " + fragmentCompat);
        }
        if (fragmentCompat.getView() == null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "onFragmentDestroyView: Fragment = " + fragmentCompat + ", null getView()");
                return;
            }
            return;
        }
        checkPageDisappear(fragmentCompat.getView());
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onFragmentPause(FragmentCompat fragmentCompat) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onFragmentPause: fragment=" + fragmentCompat);
        }
        postAppearDetectionTask(fragmentCompat.getActivity());
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onFragmentResume(FragmentCompat fragmentCompat) {
        View view = fragmentCompat.getView();
        if (view == null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "onFragmentResume: fragment = " + fragmentCompat + ", null getView()");
                return;
            }
            return;
        }
        laidOutAppear(fragmentCompat.getActivity(), view);
    }

    public void onPageReport(Object obj) {
        if (obj == null) {
            return;
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onPageReport: object=" + obj);
        }
        if (obj instanceof Activity) {
            postAppearDetectionTask((Activity) obj);
        } else if (obj instanceof Dialog) {
            postAppearDetectionTask(DialogListUtil.getDialogActivity((Dialog) obj));
        } else if (obj instanceof View) {
            onPageViewVisible((View) obj);
        }
    }

    public void onPageViewInvisible(View view) {
        if (view == null) {
            return;
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onPageViewInvisible: view = " + view);
        }
        checkPageDisappear(view);
    }

    public void onPageViewVisible(View view) {
        if (view == null) {
            return;
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onPageViewVisible: view = " + view);
        }
        postAppearDetectionTask(UIUtils.findAttachedActivity(view));
    }

    public void register(IPageSwitchListener iPageSwitchListener) {
        this.mListenerMgr.register(iPageSwitchListener);
    }

    public void unregister(IPageSwitchListener iPageSwitchListener) {
        this.mListenerMgr.unregister(iPageSwitchListener);
    }

    PageSwitchObserver() {
        this.mListenerMgr = new ListenerMgr<>();
        this.mIsAppForeground = true;
        this.mResumedActivities = Collections.newSetFromMap(new WeakHashMap());
        this.mDelayedIdleHandler = new DelayedIdleHandler();
        this.mDetectionTask = new DetectionTask();
        this.mViewActivityMap = new ViewActivityMap();
    }

    private boolean checkPageDisappear(View view) {
        if (view == null) {
            return false;
        }
        return notifyPageDestroyed(view);
    }

    private boolean detectActivePage(Window window, int i3) {
        return window != null && detectActivePage(window.getDecorView(), i3);
    }

    private boolean detectActivePage(View view, int i3) {
        PageInfo findExposurePage = PageFinder.findExposurePage(view);
        if (findExposurePage == null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "detectActivePage: no active page found");
            }
            if (!VideoReportInner.getInstance().getConfiguration().isIndependentPageOut()) {
                return false;
            }
            notifyPageDisappear();
            return false;
        }
        Log.i(TAG, "detectActivePage: active page found, view = " + view + ", page = " + findExposurePage);
        onActivePageFound(findExposurePage, i3);
        return true;
    }
}
