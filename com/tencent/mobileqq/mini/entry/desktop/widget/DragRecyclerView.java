package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DragRecyclerView extends RecyclerView {
    int SCROLL_OFFSET;
    boolean autoScrollEnable;
    int autoScrollOffsetX;
    boolean autoScrollStatus;
    protected List<DragRecyclerView> children;
    private RecyclerView.ViewHolder currDragViewHolder;
    int hasScrolledOffsetX;
    protected boolean isDragging;
    private int lastDragX;
    private int lastDragY;
    private boolean mAutoScrollEnable;
    private boolean mCanAutoScroll;
    private DragDeleteListenerWrapper mDeleteDragListener;
    private DragMiniAppBgListener mDragMiniAppBgListener;
    private boolean mIsDeletePrepared;
    private OnItemChangeListener mOnItemChangeListener;
    private int mPositionInParent;
    boolean oritationRight;
    private ScaleAnimation revertAnimation;
    int startAutoScrollOffset;
    ItemTouchHelper touchHelper;
    private ScaleAnimation zoomAnimation;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface DragDeleteListener {
        void onDeleteDragComplete();

        void onDeleteDragFinish();

        void onDeleteDragStart();
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class DragDeleteListenerWrapper implements DragDeleteListener {
        private WeakReference<DragDeleteListener> mRealListener;

        public DragDeleteListenerWrapper(DragDeleteListener dragDeleteListener) {
            this.mRealListener = new WeakReference<>(dragDeleteListener);
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener
        public void onDeleteDragComplete() {
            DragDeleteListener dragDeleteListener = this.mRealListener.get();
            if (dragDeleteListener != null) {
                dragDeleteListener.onDeleteDragComplete();
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener
        public void onDeleteDragFinish() {
            DragDeleteListener dragDeleteListener = this.mRealListener.get();
            if (dragDeleteListener != null) {
                dragDeleteListener.onDeleteDragFinish();
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener
        public void onDeleteDragStart() {
            DragDeleteListener dragDeleteListener = this.mRealListener.get();
            if (dragDeleteListener != null) {
                dragDeleteListener.onDeleteDragStart();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface DragMiniAppBgListener {
        void onDragFinish();

        void onDragMove(int i3, int i16);

        void onDragStart(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface OnItemChangeListener {
        boolean isItemDeleteable(int i3);

        boolean isItemDragable(int i3);

        boolean isItemDropable(int i3);

        boolean isMoveToDeleteArea(int i3, int i16);

        void onDragFinish(RecyclerView.ViewHolder viewHolder, int i3);

        void onDragMove(int i3, int i16);

        void onDragStart(RecyclerView.ViewHolder viewHolder, int i3);

        void onItemDelete(int i3);

        void onItemDraw(RecyclerView.ViewHolder viewHolder, float f16, float f17);

        void onItemMoved(int i3, int i16);

        void onItemPrepared(int i3);
    }

    public DragRecyclerView(Context context) {
        super(context.getApplicationContext());
        this.isDragging = false;
        this.currDragViewHolder = null;
        this.lastDragX = 0;
        this.lastDragY = 0;
        this.mIsDeletePrepared = false;
        this.mAutoScrollEnable = false;
        this.mCanAutoScroll = false;
        this.startAutoScrollOffset = 0;
        this.children = new ArrayList();
        this.touchHelper = new MiniItemTouchHelper(new ItemTouchHelper.Callback() { // from class: com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.4
            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                if (DragRecyclerView.this.mOnItemChangeListener != null) {
                    return DragRecyclerView.this.mOnItemChangeListener.isItemDropable(viewHolder2.getAdapterPosition());
                }
                return super.canDropOver(recyclerView, viewHolder, viewHolder2);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                QLog.i("DragRecycleView", 1, "clearView");
                super.clearView(recyclerView, viewHolder);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public long getAnimationDuration(RecyclerView recyclerView, int i3, float f16, float f17) {
                return super.getAnimationDuration(recyclerView, i3, f16, f17);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return false;
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
                if (i3 == 1) {
                    viewHolder.itemView.setAlpha(1.0f - (Math.abs(f16) / viewHolder.itemView.getWidth()));
                    viewHolder.itemView.setTranslationX(f16);
                    return;
                }
                super.onChildDraw(canvas, recyclerView, viewHolder, f16, f17, i3, z16);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                int adapterPosition = viewHolder.getAdapterPosition();
                int adapterPosition2 = viewHolder2.getAdapterPosition();
                if (adapterPosition >= 0 && adapterPosition2 >= 0 && DragRecyclerView.this.mOnItemChangeListener != null) {
                    DragRecyclerView.this.mOnItemChangeListener.onItemMoved(adapterPosition, adapterPosition2);
                    return false;
                }
                return false;
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
                super.onSelectedChanged(viewHolder, i3);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
            }
        });
        this.zoomAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        this.revertAnimation = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.SCROLL_OFFSET = ViewUtils.dip2px(20.0f);
        this.autoScrollOffsetX = 0;
        this.hasScrolledOffsetX = 0;
        this.autoScrollStatus = false;
        this.autoScrollEnable = false;
        this.oritationRight = true;
        init(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAutoScroolToBottom() {
        if (this.mAutoScrollEnable) {
            if (this.mCanAutoScroll && !isSlideToBottom()) {
                if (this.startAutoScrollOffset <= 0) {
                    this.startAutoScrollOffset = computeVerticalScrollExtent() + computeVerticalScrollOffset();
                }
                smoothScrollBy(0, 100);
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.3
                @Override // java.lang.Runnable
                public void run() {
                    DragRecyclerView.this.doAutoScroolToBottom();
                }
            }, 50L);
        }
    }

    private void init(Context context) {
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                super.onScrollStateChanged(recyclerView, i3);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
                super.onScrolled(recyclerView, i3, i16);
            }
        });
        this.touchHelper.attachToRecyclerView(this);
        addOnItemTouchListener(new OnRecyclerItemClickListener(this) { // from class: com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.2
            @Override // com.tencent.mobileqq.mini.entry.desktop.widget.OnRecyclerItemClickListener
            public void onItemLongPress(RecyclerView.ViewHolder viewHolder) {
                boolean z16;
                if (viewHolder == null) {
                    return;
                }
                if (DragRecyclerView.this.mOnItemChangeListener != null) {
                    z16 = DragRecyclerView.this.mOnItemChangeListener.isItemDragable(viewHolder.getAdapterPosition());
                } else {
                    z16 = false;
                }
                if (z16) {
                    DragRecyclerView.this.onDragStart(viewHolder);
                }
            }

            @Override // com.tencent.mobileqq.mini.entry.desktop.widget.OnRecyclerItemClickListener
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
            }
        });
    }

    private void onDragFinish() {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView.ViewHolder viewHolder2;
        if (!this.isDragging) {
            return;
        }
        QLog.i("DragRecycleView", 1, "onDragFinish");
        try {
            DragDeleteListenerWrapper dragDeleteListenerWrapper = this.mDeleteDragListener;
            if (dragDeleteListenerWrapper != null) {
                dragDeleteListenerWrapper.onDeleteDragFinish();
            }
            DragMiniAppBgListener dragMiniAppBgListener = this.mDragMiniAppBgListener;
            if (dragMiniAppBgListener != null) {
                dragMiniAppBgListener.onDragFinish();
            }
        } catch (Throwable th5) {
            QLog.e("DragRecycleView", 1, th5, new Object[0]);
        }
        try {
            if (this.mIsDeletePrepared && this.mOnItemChangeListener != null && (viewHolder2 = this.currDragViewHolder) != null && viewHolder2.getAdapterPosition() >= 0) {
                this.mOnItemChangeListener.onItemDelete(this.currDragViewHolder.getAdapterPosition());
            }
        } catch (Throwable th6) {
            QLog.e("DragRecycleView", 1, th6, new Object[0]);
        }
        try {
            OnItemChangeListener onItemChangeListener = this.mOnItemChangeListener;
            if (onItemChangeListener != null && (viewHolder = this.currDragViewHolder) != null) {
                onItemChangeListener.onDragFinish(viewHolder, viewHolder.getAdapterPosition());
            }
        } catch (Throwable th7) {
            QLog.e("DragRecycleView", 1, th7, new Object[0]);
        }
        this.mAutoScrollEnable = false;
        this.startAutoScrollOffset = 0;
        this.isDragging = false;
        this.mIsDeletePrepared = false;
        this.lastDragX = 0;
        this.lastDragY = 0;
        this.currDragViewHolder = null;
    }

    private void onDragMove(int i3, int i16) {
        boolean z16;
        boolean z17;
        if (!this.isDragging) {
            return;
        }
        if (Math.abs(this.lastDragX - i3) < ViewUtils.dpToPx(3.0f) && Math.abs(this.lastDragY - i16) < ViewUtils.dpToPx(3.0f)) {
            return;
        }
        this.lastDragX = i3;
        this.lastDragY = i16;
        OnItemChangeListener onItemChangeListener = this.mOnItemChangeListener;
        if (onItemChangeListener != null) {
            onItemChangeListener.onDragMove(i3, i16);
        }
        if (i16 >= getHeight() - getResources().getDimensionPixelSize(R.dimen.f158724ne)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mCanAutoScroll = z16;
        OnItemChangeListener onItemChangeListener2 = this.mOnItemChangeListener;
        if (onItemChangeListener2 != null) {
            z17 = onItemChangeListener2.isItemDeleteable(this.currDragViewHolder.getAdapterPosition());
        } else {
            z17 = false;
        }
        if (z17 && this.mDeleteDragListener != null) {
            OnItemChangeListener onItemChangeListener3 = this.mOnItemChangeListener;
            if (onItemChangeListener3 != null && onItemChangeListener3.isMoveToDeleteArea(i3, i16)) {
                if (!this.mIsDeletePrepared) {
                    this.mIsDeletePrepared = true;
                    this.mDeleteDragListener.onDeleteDragComplete();
                    OnItemChangeListener onItemChangeListener4 = this.mOnItemChangeListener;
                    if (onItemChangeListener4 != null) {
                        onItemChangeListener4.onItemPrepared(this.currDragViewHolder.getAdapterPosition());
                    }
                }
            } else if (this.mIsDeletePrepared) {
                this.mIsDeletePrepared = false;
                this.mDeleteDragListener.onDeleteDragStart();
                OnItemChangeListener onItemChangeListener5 = this.mOnItemChangeListener;
                if (onItemChangeListener5 != null) {
                    onItemChangeListener5.onItemPrepared(-1);
                }
            }
        }
        DragMiniAppBgListener dragMiniAppBgListener = this.mDragMiniAppBgListener;
        if (dragMiniAppBgListener != null) {
            dragMiniAppBgListener.onDragMove(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDragStart(RecyclerView.ViewHolder viewHolder) {
        boolean z16;
        DragDeleteListenerWrapper dragDeleteListenerWrapper;
        this.isDragging = true;
        this.currDragViewHolder = viewHolder;
        if (viewHolder != null) {
            QLog.i("DragRecycleView", 1, "onDragStart index:" + viewHolder.getAdapterPosition());
            OnItemChangeListener onItemChangeListener = this.mOnItemChangeListener;
            if (onItemChangeListener != null) {
                onItemChangeListener.onDragStart(viewHolder, viewHolder.getAdapterPosition());
            }
            OnItemChangeListener onItemChangeListener2 = this.mOnItemChangeListener;
            if (onItemChangeListener2 != null) {
                z16 = onItemChangeListener2.isItemDeleteable(viewHolder.getAdapterPosition());
            } else {
                z16 = false;
            }
            if (z16 && (dragDeleteListenerWrapper = this.mDeleteDragListener) != null) {
                dragDeleteListenerWrapper.onDeleteDragStart();
            }
            DragMiniAppBgListener dragMiniAppBgListener = this.mDragMiniAppBgListener;
            if (dragMiniAppBgListener != null) {
                dragMiniAppBgListener.onDragStart(this.mPositionInParent);
            }
        }
        this.mAutoScrollEnable = true;
        doAutoScroolToBottom();
    }

    private void zoomView(View view) {
        view.setAnimation(this.zoomAnimation);
        this.zoomAnimation.setFillAfter(true);
        this.zoomAnimation.setDuration(200L);
        this.zoomAnimation.start();
    }

    public void addChildDragRecycleView(DragRecyclerView dragRecyclerView) {
        if (!this.children.contains(dragRecyclerView)) {
            this.children.add(dragRecyclerView);
        }
    }

    public List<DragRecyclerView> getChildRecycleView() {
        return new ArrayList(this.children);
    }

    public DragDeleteListener getDragDeleteListener() {
        return this.mDeleteDragListener;
    }

    public DragMiniAppBgListener getDragMiniAppBgListener() {
        return this.mDragMiniAppBgListener;
    }

    protected boolean isSlideToBottom() {
        if (computeVerticalScrollExtent() + computeVerticalScrollOffset() >= computeVerticalScrollRange()) {
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrollStateChanged(int i3) {
        super.onScrollStateChanged(i3);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrolled(int i3, int i16) {
        super.onScrolled(i3, i16);
        if (this.autoScrollEnable && this.autoScrollStatus) {
            this.hasScrolledOffsetX += i3;
            if (Math.abs(i3) <= Math.abs(this.autoScrollOffsetX)) {
                this.hasScrolledOffsetX = 0;
                smoothScrollBy(this.autoScrollOffsetX, 0);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isDragging) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    onDragMove((int) motionEvent.getX(), (int) motionEvent.getY());
                }
            } else {
                onDragFinish();
            }
            return true;
        }
        for (DragRecyclerView dragRecyclerView : this.children) {
            if (dragRecyclerView.isDragging) {
                dragRecyclerView.onTouchEventFromParent(motionEvent, 0);
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return true;
                }
                return super.onTouchEvent(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onTouchEventFromParent(MotionEvent motionEvent, int i3) {
        boolean z16 = false;
        if (this.isDragging) {
            this.mAutoScrollEnable = false;
            int action = motionEvent.getAction();
            z16 = true;
            if (action != 1) {
                if (action == 2) {
                    onDragMove(((int) motionEvent.getX()) - getLeft(), (((int) motionEvent.getY()) - getTop()) - i3);
                }
            } else {
                onDragFinish();
            }
        }
        return z16;
    }

    public void setAutoScrollEnable(boolean z16) {
        this.autoScrollEnable = z16;
    }

    public DragRecyclerView setDragChangeListener(OnItemChangeListener onItemChangeListener) {
        this.mOnItemChangeListener = onItemChangeListener;
        return this;
    }

    public void setDragDeleteListener(DragDeleteListener dragDeleteListener) {
        this.mDeleteDragListener = new DragDeleteListenerWrapper(dragDeleteListener);
    }

    public void setDragMiniAppBgListener(DragMiniAppBgListener dragMiniAppBgListener) {
        this.mDragMiniAppBgListener = dragMiniAppBgListener;
    }

    public void setPositionInParent(int i3) {
        this.mPositionInParent = i3;
    }

    public void startAutoScrollX(boolean z16) {
        int i3;
        if (!this.autoScrollEnable) {
            return;
        }
        if (!this.autoScrollStatus || this.oritationRight != z16) {
            this.autoScrollStatus = true;
            this.oritationRight = z16;
            if (z16) {
                i3 = this.SCROLL_OFFSET;
            } else {
                i3 = this.SCROLL_OFFSET * (-1);
            }
            this.autoScrollOffsetX = i3;
            smoothScrollBy(i3, 0);
        }
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        this.touchHelper.startDrag(viewHolder);
    }

    public void stopAutoScroll() {
        this.autoScrollStatus = false;
        this.autoScrollOffsetX = 0;
        this.hasScrolledOffsetX = 0;
    }

    public void startDrag(int i3) {
        this.touchHelper.startDrag(getChildViewHolder(getChildAt(i3)));
    }

    public DragRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.isDragging = false;
        this.currDragViewHolder = null;
        this.lastDragX = 0;
        this.lastDragY = 0;
        this.mIsDeletePrepared = false;
        this.mAutoScrollEnable = false;
        this.mCanAutoScroll = false;
        this.startAutoScrollOffset = 0;
        this.children = new ArrayList();
        this.touchHelper = new MiniItemTouchHelper(new ItemTouchHelper.Callback() { // from class: com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.4
            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                if (DragRecyclerView.this.mOnItemChangeListener != null) {
                    return DragRecyclerView.this.mOnItemChangeListener.isItemDropable(viewHolder2.getAdapterPosition());
                }
                return super.canDropOver(recyclerView, viewHolder, viewHolder2);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                QLog.i("DragRecycleView", 1, "clearView");
                super.clearView(recyclerView, viewHolder);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public long getAnimationDuration(RecyclerView recyclerView, int i3, float f16, float f17) {
                return super.getAnimationDuration(recyclerView, i3, f16, f17);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return false;
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
                if (i3 == 1) {
                    viewHolder.itemView.setAlpha(1.0f - (Math.abs(f16) / viewHolder.itemView.getWidth()));
                    viewHolder.itemView.setTranslationX(f16);
                    return;
                }
                super.onChildDraw(canvas, recyclerView, viewHolder, f16, f17, i3, z16);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                int adapterPosition = viewHolder.getAdapterPosition();
                int adapterPosition2 = viewHolder2.getAdapterPosition();
                if (adapterPosition >= 0 && adapterPosition2 >= 0 && DragRecyclerView.this.mOnItemChangeListener != null) {
                    DragRecyclerView.this.mOnItemChangeListener.onItemMoved(adapterPosition, adapterPosition2);
                    return false;
                }
                return false;
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
                super.onSelectedChanged(viewHolder, i3);
            }

            @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
            }
        });
        this.zoomAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        this.revertAnimation = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.SCROLL_OFFSET = ViewUtils.dip2px(20.0f);
        this.autoScrollOffsetX = 0;
        this.hasScrolledOffsetX = 0;
        this.autoScrollStatus = false;
        this.autoScrollEnable = false;
        this.oritationRight = true;
        init(context.getApplicationContext());
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class MiniItemTouchHelper extends ItemTouchHelper {
        public MiniItemTouchHelper(ItemTouchHelper.Callback callback) {
            super(callback);
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper, android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
        }
    }
}
