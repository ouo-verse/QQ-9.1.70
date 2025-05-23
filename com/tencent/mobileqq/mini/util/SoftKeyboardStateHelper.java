package com.tencent.mobileqq.mini.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SoftKeyboardStateHelper implements ViewTreeObserver.OnGlobalLayoutListener {
    private int KEY_BOARD_HIGH_DIFF;
    private final View activityRootView;
    private boolean isSoftKeyboardOpened;
    private int lastSoftKeyboardHeightInPx;
    private final List<SoftKeyboardStateListener> listeners;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface SoftKeyboardStateListener {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public SoftKeyboardStateHelper(View view) {
        this(view, false);
    }

    private void notifyOnSoftKeyboardClosed() {
        for (SoftKeyboardStateListener softKeyboardStateListener : this.listeners) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardClosed();
            }
        }
    }

    private void notifyOnSoftKeyboardOpened(int i3) {
        this.lastSoftKeyboardHeightInPx = i3;
        for (SoftKeyboardStateListener softKeyboardStateListener : this.listeners) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardOpened(i3);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.activityRootView.getWindowVisibleDisplayFrame(rect);
        int height = (this.activityRootView.getRootView().getHeight() - (rect.bottom - rect.top)) - ImmersiveUtils.getStatusBarHeight(this.activityRootView.getContext());
        if (QLog.isDevelopLevel()) {
            QLog.d(com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.TAG, 2, "onGlobalLayout , activityRootView.Height = " + this.activityRootView.getRootView().getHeight() + " heightDiff = " + height + " (r.bottom - r.top) = " + (rect.bottom - rect.top));
        }
        boolean z16 = this.isSoftKeyboardOpened;
        if (!z16 && height > this.KEY_BOARD_HIGH_DIFF) {
            this.isSoftKeyboardOpened = true;
            notifyOnSoftKeyboardOpened(height);
        } else {
            if (!z16 || height >= this.KEY_BOARD_HIGH_DIFF) {
                return;
            }
            this.isSoftKeyboardOpened = false;
            notifyOnSoftKeyboardClosed();
        }
    }

    public SoftKeyboardStateHelper(View view, boolean z16) {
        this.listeners = new LinkedList();
        this.KEY_BOARD_HIGH_DIFF = 200;
        this.activityRootView = view;
        this.isSoftKeyboardOpened = z16;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
