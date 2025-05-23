package com.tencent.hippy.qq.view.gridview;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQDragGridView extends HippyRecyclerView {
    private static final String TAG = "HippyQQDragGridView";
    private int mFixedCount;
    private boolean mIsDragEnable;
    ItemTouchHelper.Callback mTouchCallback;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface EventName {
        public static final String ON_DRAG_END = "onDragEnd";
    }

    public HippyQQDragGridView(Context context) {
        super(context);
        this.mTouchCallback = new ItemTouchHelper.SimpleCallback(15, 0) { // from class: com.tencent.hippy.qq.view.gridview.HippyQQDragGridView.1
            private int mFromPosition = -1;
            private int mToPosition = -1;

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                HippyQQDragGridView.this.sendDragEvent(this.mFromPosition, this.mToPosition);
                this.mFromPosition = -1;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                if (viewHolder.getAdapterPosition() < HippyQQDragGridView.this.mFixedCount) {
                    return 0;
                }
                return super.getMovementFlags(recyclerView, viewHolder);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return true;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                int adapterPosition = viewHolder2.getAdapterPosition();
                if (adapterPosition < HippyQQDragGridView.this.mFixedCount) {
                    return false;
                }
                if (recyclerView != null) {
                    recyclerView.getAdapter().notifyItemMoved(viewHolder.getAdapterPosition(), adapterPosition);
                    return true;
                }
                return true;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull RecyclerView.ViewHolder viewHolder2, int i16, int i17, int i18) {
                super.onMoved(recyclerView, viewHolder, i3, viewHolder2, i16, i17, i18);
                if (recyclerView != null && (recyclerView instanceof HippyRecyclerView)) {
                    ((HippyRecyclerView) recyclerView).dispatchLayout();
                    if (this.mFromPosition == -1) {
                        this.mFromPosition = i3;
                    }
                    this.mToPosition = i16;
                }
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDragEvent(int i3, int i16) {
        QLog.d(TAG, 1, "sendDragEvent, fromPosition=", Integer.valueOf(i3), ", toPosition=", Integer.valueOf(i16));
        if (i3 != i16) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("from", i3);
            hippyMap.pushInt("to", i16);
            new HippyViewEvent("onDragEnd").send((View) getParent(), hippyMap);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public boolean isLayoutRequested() {
        return false;
    }

    public void setColumn(int i3) {
        QLog.d(TAG, 1, "setColumn, column=", Integer.valueOf(i3));
        setLayoutManager(new GridLayoutManager(getContext(), i3, 1, false));
    }

    public void setDragEnable(boolean z16) {
        QLog.d(TAG, 1, "setDragEnable, enableDrag=", Boolean.valueOf(z16));
        if (z16 && !this.mIsDragEnable) {
            new ItemTouchHelper(this.mTouchCallback).attachToRecyclerView(this);
            this.mIsDragEnable = true;
        }
    }

    public void setFixedCount(int i3) {
        QLog.d(TAG, 1, "setFixedCount, fixedCount=", Integer.valueOf(i3));
        this.mFixedCount = i3;
    }
}
