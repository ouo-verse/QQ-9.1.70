package com.tencent.state.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/utils/SoftKeyboardStateWatcher;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activityRootView", "Landroid/view/View;", "isSoftKeyboardOpened", "", "(Landroid/view/View;Z)V", "()Z", "setSoftKeyboardOpened", "(Z)V", "lastSoftKeyboardHeightInPx", "", "listeners", "", "Lcom/tencent/state/utils/ISoftKeyboardStateListener;", "addSoftKeyboardStateListener", "", "listener", "dispose", "notifyOnSoftKeyboardClosed", "notifyOnSoftKeyboardOpened", "keyboardHeightInPx", "onGlobalLayout", "removeSoftKeyboardStateListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SoftKeyboardStateWatcher implements ViewTreeObserver.OnGlobalLayoutListener {
    private final View activityRootView;
    private boolean isSoftKeyboardOpened;
    private int lastSoftKeyboardHeightInPx;
    private final List<ISoftKeyboardStateListener> listeners;

    public SoftKeyboardStateWatcher(View activityRootView, boolean z16) {
        Intrinsics.checkNotNullParameter(activityRootView, "activityRootView");
        this.activityRootView = activityRootView;
        this.isSoftKeyboardOpened = z16;
        this.listeners = new LinkedList();
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private final void notifyOnSoftKeyboardClosed() {
        Iterator<ISoftKeyboardStateListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSoftKeyboardClosed();
        }
    }

    private final void notifyOnSoftKeyboardOpened(int keyboardHeightInPx) {
        this.lastSoftKeyboardHeightInPx = keyboardHeightInPx;
        Iterator<ISoftKeyboardStateListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSoftKeyboardOpened(keyboardHeightInPx);
        }
    }

    public final void addSoftKeyboardStateListener(ISoftKeyboardStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void dispose() {
        this.activityRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    /* renamed from: isSoftKeyboardOpened, reason: from getter */
    public final boolean getIsSoftKeyboardOpened() {
        return this.isSoftKeyboardOpened;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.activityRootView.getWindowVisibleDisplayFrame(rect);
        View rootView = this.activityRootView.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "activityRootView.rootView");
        int height = (rootView.getHeight() - rect.bottom) - rect.top;
        boolean z16 = this.isSoftKeyboardOpened;
        if (!z16 && height > 200) {
            this.isSoftKeyboardOpened = true;
            notifyOnSoftKeyboardOpened(height);
        } else {
            if (!z16 || height >= 200) {
                return;
            }
            this.isSoftKeyboardOpened = false;
            notifyOnSoftKeyboardClosed();
        }
    }

    public final void removeSoftKeyboardStateListener(ISoftKeyboardStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void setSoftKeyboardOpened(boolean z16) {
        this.isSoftKeyboardOpened = z16;
    }

    public /* synthetic */ SoftKeyboardStateWatcher(View view, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i3 & 2) != 0 ? false : z16);
    }
}
