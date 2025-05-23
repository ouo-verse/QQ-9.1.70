package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.widget.itemtouchhelper.GestureDetectorCompat;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat mGestureDetector;
    private DragRecyclerView recyclerView;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        ItemTouchHelperGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildViewUnder = OnRecyclerItemClickListener.this.recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                OnRecyclerItemClickListener.this.onItemLongPress(OnRecyclerItemClickListener.this.recyclerView.getChildViewHolder(findChildViewUnder));
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View findChildViewUnder = OnRecyclerItemClickListener.this.recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                OnRecyclerItemClickListener.this.onItemClick(OnRecyclerItemClickListener.this.recyclerView.getChildViewHolder(findChildViewUnder));
                return false;
            }
            return false;
        }
    }

    public OnRecyclerItemClickListener(DragRecyclerView dragRecyclerView) {
        this.recyclerView = dragRecyclerView;
        this.mGestureDetector = new GestureDetectorCompat(dragRecyclerView.getContext(), new ItemTouchHelperGestureListener());
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        if (this.recyclerView.isDragging && motionEvent.getAction() == 1) {
            this.recyclerView.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public abstract void onItemClick(RecyclerView.ViewHolder viewHolder);

    public abstract void onItemLongPress(RecyclerView.ViewHolder viewHolder);

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z16) {
    }
}
