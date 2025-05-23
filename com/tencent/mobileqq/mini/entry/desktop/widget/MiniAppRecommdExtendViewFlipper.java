package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ViewAnimator;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppRecommdExtendViewFlipper extends ViewAnimator {
    private static final int DEFAULT_INTERVAL = 4000;
    private static final int FLIP_MSG = 1;
    private static final String TAG = "MiniAppRecommdExtendViewFlipper";
    private static final Set<WeakReference<IScreenCallback>> callBacks = new HashSet();
    private boolean mAutoStart;
    private int mFlipInterval;
    public ViewFlipperHandler mHandler;
    private boolean mRunning;
    private boolean mStarted;
    private boolean mVisible;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ViewFlipperHandler extends Handler {
        private final WeakReference<MiniAppRecommdExtendViewFlipper> flipper;

        public ViewFlipperHandler(MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper) {
            this.flipper = new WeakReference<>(miniAppRecommdExtendViewFlipper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper = this.flipper.get();
            if (miniAppRecommdExtendViewFlipper == null) {
                QLog.e(MiniAppRecommdExtendViewFlipper.TAG, 1, "ExtendViewFlipper is null!");
            } else if (message.what == 1 && miniAppRecommdExtendViewFlipper.mRunning) {
                miniAppRecommdExtendViewFlipper.showNext();
                sendMessageDelayed(obtainMessage(1), miniAppRecommdExtendViewFlipper.mFlipInterval);
            }
        }
    }

    public MiniAppRecommdExtendViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlipInterval = 4000;
        this.mAutoStart = false;
        this.mRunning = false;
        this.mStarted = false;
        this.mVisible = false;
        init();
    }

    private void init() {
        setFlipInterval(this.mFlipInterval);
    }

    private static void registerCallback(IScreenCallback iScreenCallback) {
        callBacks.add(new WeakReference<>(iScreenCallback));
    }

    private void removeMsgOnDestroy() {
        ViewFlipperHandler viewFlipperHandler = this.mHandler;
        if (viewFlipperHandler != null) {
            viewFlipperHandler.removeMessages(1);
        }
    }

    private static void unregisterCallback(IScreenCallback iScreenCallback) {
        callBacks.remove(new WeakReference(iScreenCallback));
    }

    private void updateRunning() {
        updateRunning(true);
    }

    public boolean isAutoStart() {
        return this.mAutoStart;
    }

    public boolean isFlipping() {
        return this.mStarted;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mAutoStart) {
            startFlipping();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeFlipBroadcast();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.mVisible = i3 == 0;
        updateRunning(false);
    }

    public void setAutoStart(boolean z16) {
        this.mAutoStart = z16;
    }

    public void setFlipInterval(int i3) {
        this.mFlipInterval = i3;
    }

    private void updateRunning(boolean z16) {
        ViewFlipperHandler viewFlipperHandler;
        boolean z17 = this.mVisible && this.mStarted;
        if (z17 == this.mRunning || (viewFlipperHandler = this.mHandler) == null) {
            return;
        }
        if (z17) {
            this.mHandler.sendMessageDelayed(viewFlipperHandler.obtainMessage(1), this.mFlipInterval);
        } else {
            viewFlipperHandler.removeMessages(1);
        }
        this.mRunning = z17;
    }

    public void removeFlipBroadcast() {
        this.mVisible = false;
        try {
            updateRunning();
            removeMsgOnDestroy();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public void startFlipping() {
        this.mStarted = true;
        updateRunning();
    }

    public void stopFlipping() {
        this.mStarted = false;
        updateRunning();
    }
}
