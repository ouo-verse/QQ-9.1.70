package com.tencent.ad.tangram.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdExposureChecker {
    private static final double AD_REPORT_SATISFIED_VISIBLE_AREA = 0.5d;
    private static final long CHECK_EXPOSURE_TOTAL_MILLIS = 1000;
    private static final String TAG = "AdExposureChecker";

    /* renamed from: ad, reason: collision with root package name */
    private Ad f61335ad;

    @Nullable
    private WeakReference<View> mViewRef;

    @Nullable
    private ViewStatusChangeListener statusChangeListener;

    @Nullable
    private Runnable internalTask = null;

    @NonNull
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Nullable
    private WeakReference<ExposureCallback> mCallback = null;
    private long durationMillis = 200;
    private boolean isViewOnForeground = true;
    private boolean isViewDestroyed = false;

    @NonNull
    private ViewStatus status = ViewStatus.NONE;

    @NonNull
    private final TimesControlScrollChangedListener scrollChangedListener = new TimesControlScrollChangedListener(200) { // from class: com.tencent.ad.tangram.util.AdExposureChecker.6
        @Override // com.tencent.ad.tangram.util.AdExposureChecker.TimesControlScrollChangedListener
        void onScrollChangedOverDuration() {
            AdExposureChecker adExposureChecker = AdExposureChecker.this;
            if (!adExposureChecker.isVisible((View) adExposureChecker.mViewRef.get())) {
                AdLog.e(AdExposureChecker.TAG, "onScrollChangedOverDuration view invisible");
                AdExposureChecker.this.stopCheck();
            }
        }
    };

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface ExposureCallback {
        void onExposure(WeakReference<View> weakReference);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class InternalTask implements Runnable {
        private static final int CHECK_CONTINUE = 0;
        private static final int CHECK_STOP = 1;
        private long mStartCheckTime;

        private int checkInternal() {
            View view;
            ExposureCallback exposureCallback;
            long currentTimeMillis = System.currentTimeMillis() - this.mStartCheckTime;
            AdLog.d(AdExposureChecker.TAG, " status: " + AdExposureChecker.this.status + " totalExposureTime " + currentTimeMillis + " thread :" + Thread.currentThread());
            if (AdExposureChecker.this.f61335ad != null && AdExposureListHolder.getInstance().inCheckedList(AdExposureChecker.this.f61335ad.getTraceId())) {
                AdLog.e(AdExposureChecker.TAG, "trace id is already exposured " + AdExposureChecker.this.f61335ad.getTraceId());
                return 1;
            }
            String str = null;
            if (AdExposureChecker.this.mViewRef != null) {
                view = (View) AdExposureChecker.this.mViewRef.get();
            } else {
                view = null;
            }
            if (AdExposureChecker.this.mCallback != null) {
                exposureCallback = (ExposureCallback) AdExposureChecker.this.mCallback.get();
            } else {
                exposureCallback = null;
            }
            if (view != null && exposureCallback != null && !AdExposureChecker.this.isViewDestroyed && AdExposureChecker.this.isViewOnForeground && AdExposureChecker.this.status == ViewStatus.CHECKING) {
                if (!AdExposureChecker.isVisibleAreaSatisfied(view)) {
                    reset();
                    return 0;
                }
                if (currentTimeMillis < 1000) {
                    return 0;
                }
                Context context = view.getContext();
                AdExposureListHolder adExposureListHolder = AdExposureListHolder.getInstance();
                if (AdExposureChecker.this.f61335ad != null) {
                    str = AdExposureChecker.this.f61335ad.getTraceId();
                }
                adExposureListHolder.putExternalReportData(context, str);
                exposureCallback.onExposure(AdExposureChecker.this.mViewRef);
                AdExposureChecker.this.status = ViewStatus.CHECKED;
                AdAnalysisHelperForUtil.reportForExposureCallback(context, AdExposureChecker.this.f61335ad, 0);
                AdLog.d(AdExposureChecker.TAG, "exposure success stop check");
                return 1;
            }
            AdLog.e(AdExposureChecker.TAG, "check failed : isViewDestroyed " + AdExposureChecker.this.isViewDestroyed + " isViewOnForeground " + AdExposureChecker.this.isViewOnForeground + " status " + AdExposureChecker.this.status + " no callback :" + exposureCallback);
            return 1;
        }

        private long getNextDelayTime() {
            return Math.max(0L, Math.min(AdExposureChecker.this.durationMillis, 1000 - (System.currentTimeMillis() - this.mStartCheckTime)));
        }

        private void reset() {
            this.mStartCheckTime = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            int checkInternal = checkInternal();
            if (checkInternal != 0) {
                if (checkInternal == 1) {
                    AdExposureChecker.this.stopCheck();
                    return;
                }
                return;
            }
            long nextDelayTime = getNextDelayTime();
            AdLog.d(AdExposureChecker.TAG, "postDelay: " + nextDelayTime);
            Runnable runnable = AdExposureChecker.this.internalTask;
            if (runnable != null) {
                AdExposureChecker.this.mainHandler.postDelayed(runnable, nextDelayTime);
            } else {
                AdLog.e(AdExposureChecker.TAG, "checkInternal failed!");
            }
        }

        InternalTask() {
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public abstract class TimesControlScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        private long duration;
        private volatile long lastActionTime;

        TimesControlScrollChangedListener(long j3) {
            this.duration = j3;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (this.lastActionTime == 0) {
                this.lastActionTime = System.currentTimeMillis();
                onScrollChangedOverDuration();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastActionTime >= this.duration) {
                onScrollChangedOverDuration();
                this.lastActionTime = currentTimeMillis;
            }
        }

        abstract void onScrollChangedOverDuration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public enum ViewStatus {
        NONE,
        CHECKING,
        CHECKED,
        END
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ViewStatusChangeListener implements View.OnAttachStateChangeListener {
        ViewStatusChangeListener() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onViewAttachedToWindow ");
            if (view != null) {
                i3 = view.hashCode();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            AdLog.i(AdExposureChecker.TAG, sb5.toString());
            AdExposureChecker.this.setViewResume();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onViewDetachedFromWindow ");
            if (view != null) {
                i3 = view.hashCode();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            AdLog.i(AdExposureChecker.TAG, sb5.toString());
            AdExposureChecker.this.setViewPause();
        }
    }

    public AdExposureChecker(Ad ad5, @Nullable WeakReference<View> weakReference) {
        this.statusChangeListener = null;
        this.f61335ad = ad5;
        this.mViewRef = weakReference;
        if (this.statusChangeListener == null) {
            this.statusChangeListener = new ViewStatusChangeListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVisible(@Nullable View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isVisibleAreaSatisfied(@Nullable View view) {
        if (view == null || view.getVisibility() != 0 || !view.isShown() || AdUIUtils.getPercentageOfGlobalVisibleRect(view) < 0.5d) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listenViewStateChange(@Nullable View view) {
        if (view != null && view.getViewTreeObserver() != null) {
            view.getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            view.addOnAttachStateChangeListener(this.statusChangeListener);
        }
    }

    public static void onClick(@Nullable final Context context, @Nullable final Ad ad5, @Nullable final WeakReference<ExposureCallback> weakReference) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdExposureChecker.5
            @Override // java.lang.Runnable
            public void run() {
                Ad ad6;
                if (context != null && weakReference != null && (ad6 = ad5) != null && ad6.isValid() && !TextUtils.isEmpty(ad5.getTraceId())) {
                    if (!AdExposureListHolder.getInstance().inCheckedList(ad5.getTraceId())) {
                        AdExposureListHolder.getInstance().putExternalReportData(context, ad5.getTraceId());
                        ExposureCallback exposureCallback = (ExposureCallback) weakReference.get();
                        if (exposureCallback != null) {
                            exposureCallback.onExposure(null);
                        }
                        AdAnalysisHelperForUtil.reportForExposureCallback(context, ad5, 1);
                        return;
                    }
                    return;
                }
                AdLog.e(AdExposureChecker.TAG, "onClick error");
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewDestroyed() {
        View view;
        WeakReference<View> weakReference = this.mViewRef;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            stopCheck();
            this.mViewRef = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPause() {
        View view;
        WeakReference<View> weakReference = this.mViewRef;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            stopCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewResume() {
        View view;
        WeakReference<View> weakReference = this.mViewRef;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            startCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCheck() {
        View view;
        Runnable runnable = this.internalTask;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
            this.internalTask = null;
        }
        WeakReference<View> weakReference = this.mViewRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.removeOnAttachStateChangeListener(this.statusChangeListener);
            view.getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        }
        this.status = ViewStatus.END;
    }

    public void onActivityDestroy() {
        this.mainHandler.post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdExposureChecker.4
            @Override // java.lang.Runnable
            public void run() {
                AdLog.e(AdExposureChecker.TAG, "onActivityDestroy");
                AdExposureChecker.this.isViewDestroyed = true;
                AdExposureChecker.this.setViewDestroyed();
            }
        });
    }

    public void onActivityPause() {
        this.mainHandler.post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdExposureChecker.3
            @Override // java.lang.Runnable
            public void run() {
                AdLog.e(AdExposureChecker.TAG, "onActivityPause");
                AdExposureChecker.this.isViewOnForeground = false;
                AdExposureChecker.this.setViewPause();
            }
        });
    }

    public void onActivityResume() {
        this.mainHandler.post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdExposureChecker.2
            @Override // java.lang.Runnable
            public void run() {
                AdLog.d(AdExposureChecker.TAG, "onActivityResume");
                AdExposureChecker.this.isViewOnForeground = true;
                AdExposureChecker.this.setViewResume();
            }
        });
    }

    public void setCallback(WeakReference<ExposureCallback> weakReference) {
        this.mCallback = weakReference;
    }

    public void startCheck() {
        AdLog.i(TAG, "startCheck:" + hashCode());
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdExposureChecker.1
            @Override // java.lang.Runnable
            public void run() {
                View view;
                if (AdExposureChecker.this.mViewRef != null) {
                    view = (View) AdExposureChecker.this.mViewRef.get();
                } else {
                    view = null;
                }
                if (view != null && AdExposureChecker.this.f61335ad != null) {
                    ViewStatus viewStatus = AdExposureChecker.this.status;
                    ViewStatus viewStatus2 = ViewStatus.CHECKING;
                    if (viewStatus != viewStatus2) {
                        if (!AdExposureListHolder.getInstance().containsTraceIdForAnalysis(AdExposureChecker.this.f61335ad.getTraceId())) {
                            AdAnalysisHelperForUtil.reportForExposureApiInvoked(view.getContext(), AdExposureChecker.this.f61335ad);
                            AdExposureListHolder.getInstance().addTraceIdForAnalysis(AdExposureChecker.this.f61335ad.getTraceId());
                        }
                        AdExposureChecker.this.listenViewStateChange(view);
                        if (AdExposureChecker.this.internalTask == null) {
                            AdExposureChecker adExposureChecker = AdExposureChecker.this;
                            adExposureChecker.internalTask = new InternalTask();
                        }
                        AdExposureChecker.this.status = viewStatus2;
                        AdExposureChecker.this.mainHandler.post(AdExposureChecker.this.internalTask);
                        return;
                    }
                }
                AdLog.e(AdExposureChecker.TAG, "startCheck: " + AdExposureChecker.this.status);
            }
        }, 0);
    }
}
