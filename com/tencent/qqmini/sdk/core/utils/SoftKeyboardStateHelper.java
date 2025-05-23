package com.tencent.qqmini.sdk.core.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SoftKeyboardStateHelper implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int KEY_BOARD_HIGH_DIFF = 200;
    public static final String TAG = "SoftKeyboardStateHelper";
    private final View activityRootView;
    private boolean isSoftKeyboardOpened;
    private int lastSoftKeyboardHeightInPx;
    private final List<SoftKeyboardStateListener> listeners;

    /* compiled from: P */
    /* loaded from: classes23.dex */
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
        int i3;
        Rect rect = new Rect();
        this.activityRootView.getWindowVisibleDisplayFrame(rect);
        int height = this.activityRootView.getRootView().getHeight() - (rect.bottom - rect.top);
        if (Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && (i3 = rect.top) > 0) {
            height -= i3;
        }
        if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick(TAG, 200L)) {
            QMLog.d(TAG, "onGlobalLayout , activityRootView.Height = " + this.activityRootView.getRootView().getHeight() + " r.top = " + rect.top + " r.bottom = " + rect.bottom + " (r.bottom - r.top) = " + (rect.bottom - rect.top) + " heightDiff = " + height);
        }
        boolean z16 = this.isSoftKeyboardOpened;
        if (!z16 && height > 200) {
            this.isSoftKeyboardOpened = true;
            notifyOnSoftKeyboardOpened(height);
        } else if (z16 && height < 200) {
            this.isSoftKeyboardOpened = false;
            notifyOnSoftKeyboardClosed();
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

    public void removeSoftKeyboardStateListener() {
        this.listeners.clear();
        View view = this.activityRootView;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
}
