package com.tencent.qqlive.module.videoreport.traversal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewTraverser implements IViewTraverser {
    private static final String TAG = "ViewTraverser";
    private OnViewTraverseListener mOnTraverseListener;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final ViewTraverser INSTANCE = new ViewTraverser();

        InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTraverser() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "ViewTraverser.<init>: ");
        }
    }

    @Nullable
    private View fetchChildAt(ViewGroup viewGroup, View[] viewArr, int i3) {
        if (viewArr == null) {
            return viewGroup.getChildAt(i3);
        }
        if (i3 < viewArr.length) {
            return viewArr[i3];
        }
        Log.e(TAG, "Attention: get child errorrrrrrrrr!");
        return null;
    }

    public static ViewTraverser getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void performInternal(@NonNull View view, int i3, @NonNull IViewTraverseCallback iViewTraverseCallback) {
        OnViewTraverseListener onViewTraverseListener = this.mOnTraverseListener;
        if (onViewTraverseListener != null) {
            onViewTraverseListener.onViewVisited(view);
        }
        if (iViewTraverseCallback.onEnter(view, i3) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() != 0) {
                View[] childrenByDrawingOrder = ViewGroupDrawingCompat.getChildrenByDrawingOrder(viewGroup);
                int childStartIndex = getChildStartIndex(viewGroup);
                int childEndIndex = getChildEndIndex(viewGroup);
                while (childStartIndex != childEndIndex) {
                    View fetchChildAt = fetchChildAt(viewGroup, childrenByDrawingOrder, childStartIndex);
                    if (fetchChildAt != null) {
                        performInternal(fetchChildAt, i3 + 1, iViewTraverseCallback);
                    }
                    childStartIndex = getNextChildIndex(childStartIndex);
                }
            }
        }
        iViewTraverseCallback.onLeave(view, i3);
    }

    protected int getChildEndIndex(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    protected int getChildStartIndex(ViewGroup viewGroup) {
        return 0;
    }

    protected int getNextChildIndex(int i3) {
        return i3 + 1;
    }

    @Override // com.tencent.qqlive.module.videoreport.traversal.IViewTraverser
    public void perform(View view, IViewTraverseCallback iViewTraverseCallback) {
        if (view != null && iViewTraverseCallback != null) {
            performInternal(view, 1, iViewTraverseCallback);
        }
    }

    public void setListener(OnViewTraverseListener onViewTraverseListener) {
        this.mOnTraverseListener = onViewTraverseListener;
    }
}
