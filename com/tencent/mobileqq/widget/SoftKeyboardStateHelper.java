package com.tencent.mobileqq.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SoftKeyboardStateHelper implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final String TAG = "SoftKeyboardStateHelper";
    private final View activityRootView;
    private int activityRootViewInitHeight;
    private boolean isSoftKeyboardOpened;
    private int lastSoftKeyboardHeightInPx;
    private final List<SoftKeyboardStateListener> listeners;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface SoftKeyboardStateListener {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public SoftKeyboardStateHelper(View view) {
        this(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHeightDiff() {
        try {
            if (this.activityRootView == null) {
                return 0;
            }
            Rect rect = new Rect();
            this.activityRootView.getWindowVisibleDisplayFrame(rect);
            if (this.activityRootViewInitHeight == 0) {
                this.activityRootViewInitHeight = rect.height();
            }
            int i3 = this.activityRootViewInitHeight - (rect.bottom - rect.top);
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                QLog.d("SoftKeyboardStateHelper", 4, "onGlobalLayout , activityRootView.Height = " + this.activityRootViewInitHeight + " heightDiff = " + i3 + " (r.bottom - r.top) = " + (rect.bottom - rect.top));
            }
            return i3;
        } catch (Throwable th5) {
            QLog.e("SoftKeyboardStateHelper", 1, "getHeightDiff error=" + th5);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnSoftKeyboardClosed() {
        for (SoftKeyboardStateListener softKeyboardStateListener : this.listeners) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardClosed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnSoftKeyboardOpened(int i3) {
        this.lastSoftKeyboardHeightInPx = i3;
        for (SoftKeyboardStateListener softKeyboardStateListener : this.listeners) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardOpened(i3);
            }
        }
    }

    public void addSoftKeyboardStateListener(SoftKeyboardStateListener softKeyboardStateListener) {
        this.listeners.add(softKeyboardStateListener);
    }

    public int getLastSoftKeyboardHeightInPx() {
        return this.lastSoftKeyboardHeightInPx;
    }

    public boolean isSoftKeyboardOpened() {
        return this.isSoftKeyboardOpened;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.activityRootView == null) {
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                QLog.d("SoftKeyboardStateHelper", 4, "onGlobalLayout activityRootView is null");
                return;
            }
            return;
        }
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.widget.SoftKeyboardStateHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    int i3 = ScreenUtil.SCREEN_HIGHT / 4;
                    final int heightDiff = SoftKeyboardStateHelper.this.getHeightDiff();
                    if (!SoftKeyboardStateHelper.this.isSoftKeyboardOpened && heightDiff >= i3) {
                        SoftKeyboardStateHelper.this.isSoftKeyboardOpened = true;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.widget.SoftKeyboardStateHelper.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SoftKeyboardStateHelper.this.notifyOnSoftKeyboardOpened(heightDiff);
                            }
                        });
                    } else if (SoftKeyboardStateHelper.this.isSoftKeyboardOpened && heightDiff < i3) {
                        SoftKeyboardStateHelper.this.isSoftKeyboardOpened = false;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.widget.SoftKeyboardStateHelper.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SoftKeyboardStateHelper.this.notifyOnSoftKeyboardClosed();
                            }
                        });
                    }
                }
            }, 16, null, true);
        } catch (Throwable th5) {
            QLog.e("SoftKeyboardStateHelper", 1, "onGlobalLayout error=" + th5);
        }
    }

    public void removeAllSoftKeyboardStateListeners() {
        this.listeners.clear();
        View view = this.activityRootView;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public void removeSoftKeyboardStateListener(SoftKeyboardStateListener softKeyboardStateListener) {
        this.listeners.remove(softKeyboardStateListener);
    }

    public void setIsSoftKeyboardOpened(boolean z16) {
        this.isSoftKeyboardOpened = z16;
    }

    public SoftKeyboardStateHelper(View view, boolean z16) {
        this.listeners = new LinkedList();
        this.activityRootView = view;
        this.isSoftKeyboardOpened = z16;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
