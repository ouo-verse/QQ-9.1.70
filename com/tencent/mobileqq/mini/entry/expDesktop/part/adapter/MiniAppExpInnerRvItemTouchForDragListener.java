package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpInnerRvItemTouchForDragListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rvItemLongClickListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpInnerRvItemLongClickForDragListener;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpInnerRvItemLongClickForDragListener;)V", "mGestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getRvItemLongClickListener", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpInnerRvItemLongClickForDragListener;", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "rv", "e", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "disallowIntercept", "onTouchEvent", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpInnerRvItemTouchForDragListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat mGestureDetector;
    private final RecyclerView recyclerView;
    private final MiniAppExpInnerRvItemLongClickForDragListener rvItemLongClickListener;

    public MiniAppExpInnerRvItemTouchForDragListener(RecyclerView recyclerView, MiniAppExpInnerRvItemLongClickForDragListener rvItemLongClickListener) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(rvItemLongClickListener, "rvItemLongClickListener");
        this.recyclerView = recyclerView;
        this.rvItemLongClickListener = rvItemLongClickListener;
        this.mGestureDetector = new GestureDetectorCompat(recyclerView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemTouchForDragListener$mGestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e16) {
                View findChildViewUnder;
                if (e16 == null || (findChildViewUnder = MiniAppExpInnerRvItemTouchForDragListener.this.getRecyclerView().findChildViewUnder(e16.getX(), e16.getY())) == null) {
                    return;
                }
                RecyclerView.ViewHolder vh5 = MiniAppExpInnerRvItemTouchForDragListener.this.getRecyclerView().getChildViewHolder(findChildViewUnder);
                int adapterPosition = vh5.getAdapterPosition();
                MiniAppExpInnerRvItemLongClickForDragListener rvItemLongClickListener2 = MiniAppExpInnerRvItemTouchForDragListener.this.getRvItemLongClickListener();
                RecyclerView recyclerView2 = MiniAppExpInnerRvItemTouchForDragListener.this.getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(vh5, "vh");
                rvItemLongClickListener2.onItemLongClick(recyclerView2, vh5, adapterPosition, e16.getRawX(), e16.getRawY());
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e16) {
                View findChildViewUnder;
                if (e16 == null || (findChildViewUnder = MiniAppExpInnerRvItemTouchForDragListener.this.getRecyclerView().findChildViewUnder(e16.getX(), e16.getY())) == null) {
                    return false;
                }
                RecyclerView.ViewHolder vh5 = MiniAppExpInnerRvItemTouchForDragListener.this.getRecyclerView().getChildViewHolder(findChildViewUnder);
                int adapterPosition = vh5.getAdapterPosition();
                MiniAppExpInnerRvItemLongClickForDragListener rvItemLongClickListener2 = MiniAppExpInnerRvItemTouchForDragListener.this.getRvItemLongClickListener();
                RecyclerView recyclerView2 = MiniAppExpInnerRvItemTouchForDragListener.this.getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(vh5, "vh");
                rvItemLongClickListener2.onItemClick(recyclerView2, vh5, adapterPosition);
                return true;
            }
        });
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final MiniAppExpInnerRvItemLongClickForDragListener getRvItemLongClickListener() {
        return this.rvItemLongClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView rv5, MotionEvent e16) {
        Intrinsics.checkNotNullParameter(rv5, "rv");
        Intrinsics.checkNotNullParameter(e16, "e");
        return this.mGestureDetector.onTouchEvent(e16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView rv5, MotionEvent e16) {
        Intrinsics.checkNotNullParameter(rv5, "rv");
        Intrinsics.checkNotNullParameter(e16, "e");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
