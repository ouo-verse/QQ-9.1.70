package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ViewAnimator;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ExtendViewFlipper extends ViewAnimator implements IScreenCallback {
    private static final int DEFAULT_INTERVAL = 4000;
    private static final int FLIP_MSG = 1;
    private static final String TAG = "ExtendViewFlipper";
    private static boolean hasRegisterBroadcast = false;
    private boolean hasRegisterCallback;
    private boolean mAutoStart;
    private int mFlipInterval;
    private ViewFlipperHandler mHandler;
    private boolean mRunning;
    private boolean mStarted;
    private boolean mVisible;
    private static final Set<WeakReference<IScreenCallback>> callBacks = new HashSet();
    private static final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.mini.entry.desktop.widget.ExtendViewFlipper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                Iterator it = ExtendViewFlipper.callBacks.iterator();
                while (it.hasNext()) {
                    IScreenCallback iScreenCallback = (IScreenCallback) ((WeakReference) it.next()).get();
                    if (iScreenCallback != null) {
                        iScreenCallback.onScreenOff();
                    }
                }
                return;
            }
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                Iterator it5 = ExtendViewFlipper.callBacks.iterator();
                while (it5.hasNext()) {
                    IScreenCallback iScreenCallback2 = (IScreenCallback) ((WeakReference) it5.next()).get();
                    if (iScreenCallback2 != null) {
                        iScreenCallback2.onUserPresent();
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ViewFlipperHandler extends Handler {
        private final WeakReference<ExtendViewFlipper> flipper;

        public ViewFlipperHandler(ExtendViewFlipper extendViewFlipper) {
            this.flipper = new WeakReference<>(extendViewFlipper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ExtendViewFlipper extendViewFlipper = this.flipper.get();
            if (extendViewFlipper == null) {
                QLog.e(ExtendViewFlipper.TAG, 1, "ExtendViewFlipper is null!");
            } else if (message.what == 1 && extendViewFlipper.mRunning) {
                extendViewFlipper.showNext();
                sendMessageDelayed(obtainMessage(1), extendViewFlipper.mFlipInterval);
            }
        }
    }

    public ExtendViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlipInterval = 4000;
        this.mAutoStart = false;
        this.mRunning = false;
        this.mStarted = false;
        this.mVisible = false;
        this.hasRegisterCallback = false;
        init();
    }

    private void init() {
        this.mHandler = new ViewFlipperHandler(this);
        setFlipInterval(this.mFlipInterval);
    }

    private static void registerCallback(IScreenCallback iScreenCallback) {
        callBacks.add(new WeakReference<>(iScreenCallback));
    }

    private void removeMsgOnDestroy() {
        this.mHandler.removeMessages(1);
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
        try {
            if (!hasRegisterBroadcast) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                getContext().registerReceiver(mReceiver, intentFilter);
                QLog.d(TAG, 1, NodeProps.ON_ATTACHED_TO_WINDOW);
                hasRegisterBroadcast = true;
            }
            if (!this.hasRegisterCallback) {
                registerCallback(this);
                this.hasRegisterCallback = true;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
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

    public void removeFlipBroadcast() {
        this.mVisible = false;
        try {
            if (this.hasRegisterCallback) {
                unregisterCallback(this);
                this.hasRegisterCallback = false;
            }
            if (hasRegisterBroadcast && callBacks.size() == 0) {
                getContext().unregisterReceiver(mReceiver);
                QLog.d(TAG, 1, "removeFlipBroadcast");
                hasRegisterBroadcast = false;
            }
            updateRunning();
            removeMsgOnDestroy();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public void setAutoStart(boolean z16) {
        this.mAutoStart = z16;
    }

    public void setFlipInterval(int i3) {
        this.mFlipInterval = i3;
    }

    private void updateRunning(boolean z16) {
        boolean z17 = this.mVisible && this.mStarted;
        if (z17 != this.mRunning) {
            if (z17) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mFlipInterval);
            } else {
                this.mHandler.removeMessages(1);
            }
            this.mRunning = z17;
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.widget.IScreenCallback
    public void onScreenOff() {
        this.mVisible = false;
        updateRunning();
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.widget.IScreenCallback
    public void onUserPresent() {
        this.mVisible = true;
        updateRunning(false);
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
