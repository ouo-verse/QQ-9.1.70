package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J(\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpDesktopWrapLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "assertNotInLayoutOrScroll", "", "message", "", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopWrapLinearLayoutManager extends LinearLayoutManager {
    private static final String TAG = "MiniAppExpDesktopWrapLinearLayoutManager";

    public MiniAppExpDesktopWrapLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String message) {
        try {
            super.assertNotInLayoutOrScroll(message);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "assertNotInLayoutOrScroll throw e:", e16);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onLayoutChildren throw e:", e16);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollHorizontallyBy(dx5, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            QLog.e(TAG, 1, "scrollHorizontallyBy throw e:", e16);
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(dy5, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            QLog.e(TAG, 1, "scrollVerticallyBy throw e:", e16);
            return 0;
        }
    }

    public MiniAppExpDesktopWrapLinearLayoutManager(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    public MiniAppExpDesktopWrapLinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }
}
