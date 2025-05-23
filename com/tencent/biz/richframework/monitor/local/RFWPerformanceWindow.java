package com.tencent.biz.richframework.monitor.local;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public abstract class RFWPerformanceWindow {
    private boolean isViewAttachToWindow = false;
    private View mContainerView = null;
    private SoftReference<Context> mContext;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;

    /* loaded from: classes5.dex */
    private static final class MonitorInfoTask implements Runnable {
        private WeakReference<RFWPerformanceWindow> mMonitorWindowWeak;

        public MonitorInfoTask(RFWPerformanceWindow rFWPerformanceWindow) {
            this.mMonitorWindowWeak = new WeakReference<>(rFWPerformanceWindow);
        }

        @Override // java.lang.Runnable
        public void run() {
            RFWPerformanceWindow rFWPerformanceWindow;
            WeakReference<RFWPerformanceWindow> weakReference = this.mMonitorWindowWeak;
            if (weakReference == null) {
                rFWPerformanceWindow = null;
            } else {
                rFWPerformanceWindow = weakReference.get();
            }
            if (rFWPerformanceWindow != null) {
                rFWPerformanceWindow.attachContainerToWindow();
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class MonitorInfoTouchListener implements View.OnTouchListener {
        private float mInitialTouchX;
        private float mInitialTouchY;
        private int mInitialX;
        private int mInitialY;
        private WeakReference<RFWPerformanceWindow> mMonitorWindowWeak;

        public MonitorInfoTouchListener(RFWPerformanceWindow rFWPerformanceWindow) {
            this.mMonitorWindowWeak = new WeakReference<>(rFWPerformanceWindow);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RFWPerformanceWindow rFWPerformanceWindow;
            WindowManager windowManager;
            WeakReference<RFWPerformanceWindow> weakReference = this.mMonitorWindowWeak;
            WindowManager.LayoutParams layoutParams = null;
            if (weakReference == null) {
                rFWPerformanceWindow = null;
            } else {
                rFWPerformanceWindow = weakReference.get();
            }
            if (rFWPerformanceWindow != null) {
                windowManager = rFWPerformanceWindow.mWindowManager;
            } else {
                windowManager = null;
            }
            if (rFWPerformanceWindow != null) {
                layoutParams = rFWPerformanceWindow.mLayoutParams;
            }
            if (windowManager != null && layoutParams != null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 2) {
                        layoutParams.x = this.mInitialX + ((int) (this.mInitialTouchX - motionEvent.getRawX()));
                        layoutParams.y = this.mInitialY + ((int) (motionEvent.getRawY() - this.mInitialTouchY));
                        windowManager.updateViewLayout(view, layoutParams);
                    }
                } else {
                    this.mInitialX = layoutParams.x;
                    this.mInitialY = layoutParams.y;
                    this.mInitialTouchX = motionEvent.getRawX();
                    this.mInitialTouchY = motionEvent.getRawY();
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachContainerToWindow() {
        if (this.mWindowManager == null) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[attachContainerToWindow] window manager should not be null.");
            return;
        }
        if (this.mContainerView == null) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[attachContainerToWindow] container view should not be null.");
            return;
        }
        if (this.mLayoutParams == null) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[attachContainerToWindow] layout params should not be null.");
            return;
        }
        if (isInvalidWindow(getCurrentContext())) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[attachContainerToWindow] context status is invalid...");
            return;
        }
        try {
            removeViewImmediate();
            this.mWindowManager.addView(this.mContainerView, this.mLayoutParams);
            this.isViewAttachToWindow = true;
        } catch (Exception e16) {
            RFWLog.e("FAM-RFWPerformanceWindow", RFWLog.USR, e16);
        }
    }

    private Context getCurrentContext() {
        SoftReference<Context> softReference = this.mContext;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    private boolean isContextEquals(Context context) {
        if (getCurrentContext() == context) {
            return true;
        }
        return false;
    }

    private boolean isInvalidWindow(Context context) {
        if (!(context instanceof Activity)) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[isInvalidWindow] current context not is activity.");
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    private void removeViewImmediate() {
        WindowManager windowManager = this.mWindowManager;
        if (windowManager == null) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[removeViewImmediate] window manager should not be null.");
            return;
        }
        View view = this.mContainerView;
        if (view == null) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[removeViewImmediate] container view should not be null.");
        } else if (!this.isViewAttachToWindow) {
            RFWLog.d("FAM-RFWPerformanceWindow", RFWLog.USR, "[removeViewImmediate] current not attach to window.");
        } else {
            this.isViewAttachToWindow = false;
            windowManager.removeViewImmediate(view);
        }
    }

    public void deattch() {
        removeViewImmediate();
    }

    @SuppressLint({"WrongConstant"})
    public void init(Context context) {
        if (isContextEquals(context)) {
            return;
        }
        this.mContext = new SoftReference<>(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hnc, (ViewGroup) null);
        this.mContainerView = inflate;
        inflate.setOnTouchListener(new MonitorInfoTouchListener(this));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 1000, 8, -3);
        this.mLayoutParams = layoutParams;
        layoutParams.gravity = 53;
        layoutParams.y = 250;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        onCreateView(this.mContainerView);
        new Handler(Looper.getMainLooper()).post(new MonitorInfoTask(this));
    }

    protected abstract void onCreateView(View view);

    public void release() {
        SoftReference<Context> softReference = this.mContext;
        if (softReference != null) {
            softReference.clear();
        }
    }
}
