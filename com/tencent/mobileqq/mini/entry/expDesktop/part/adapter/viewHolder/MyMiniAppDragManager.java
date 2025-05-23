package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import android.view.DragEvent;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/MyMiniAppDragManager;", "", "miniAppRv", "Landroidx/recyclerview/widget/RecyclerView;", "miniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "dataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;Ljava/util/List;)V", "mDataList", "mLocationFromPosition", "", "mLocationTime", "", "mLocationToPosition", "mMiniAppDesktopViewModel", "mMiniAppRv", "myMiniAppDragDrop", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/DragEvent;", "myMiniAppDragEvent", "", "view", "myMiniAppDragLocation", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MyMiniAppDragManager {
    private static final String TAG = "MyMiniAppDragManager";
    private List<DesktopAppInfo> mDataList;
    private int mLocationFromPosition;
    private long mLocationTime;
    private int mLocationToPosition;
    private MiniAppExpDesktopViewModel mMiniAppDesktopViewModel;
    private RecyclerView mMiniAppRv;

    public MyMiniAppDragManager(RecyclerView recyclerView, MiniAppExpDesktopViewModel miniAppExpDesktopViewModel, List<DesktopAppInfo> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        new ArrayList();
        this.mLocationToPosition = -1;
        this.mLocationFromPosition = -1;
        this.mMiniAppRv = recyclerView;
        this.mMiniAppDesktopViewModel = miniAppExpDesktopViewModel;
        this.mDataList = dataList;
    }

    private final void myMiniAppDragDrop(View itemView, DragEvent event) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        RecyclerView recyclerView = this.mMiniAppRv;
        View findChildViewUnder = recyclerView != null ? recyclerView.findChildViewUnder(event.getX(), event.getY()) : null;
        if (findChildViewUnder != null) {
            RecyclerView recyclerView2 = this.mMiniAppRv;
            if ((recyclerView2 != null ? recyclerView2.getChildViewHolder(findChildViewUnder) : null) != null) {
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
                int fromPosition = ((MiniAppExpDragData) localState).getFromPosition();
                RecyclerView recyclerView3 = this.mMiniAppRv;
                Intrinsics.checkNotNull(recyclerView3);
                int adapterPosition = recyclerView3.getChildViewHolder(findChildViewUnder).getAdapterPosition();
                if (fromPosition >= 0 && fromPosition < this.mDataList.size() && adapterPosition >= 0 && adapterPosition < this.mDataList.size() && (lifecycleOwner = ViewTreeLifecycleOwner.get(itemView)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                    BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MyMiniAppDragManager$myMiniAppDragDrop$1(this, fromPosition, adapterPosition, null), 3, null);
                }
                QLog.i(TAG, 1, "actionDrop fromPosition" + fromPosition + " toPosition:" + adapterPosition);
                return;
            }
        }
        QLog.i(TAG, 1, "view == null or holder == null!");
    }

    private final void myMiniAppDragLocation(View itemView, DragEvent event) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (System.currentTimeMillis() - this.mLocationTime <= 800) {
            return;
        }
        RecyclerView recyclerView = this.mMiniAppRv;
        View findChildViewUnder = recyclerView != null ? recyclerView.findChildViewUnder(event.getX(), event.getY()) : null;
        if (findChildViewUnder != null) {
            RecyclerView recyclerView2 = this.mMiniAppRv;
            if ((recyclerView2 != null ? recyclerView2.getChildViewHolder(findChildViewUnder) : null) != null) {
                Object localState = event.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
                int fromPosition = ((MiniAppExpDragData) localState).getFromPosition();
                RecyclerView recyclerView3 = this.mMiniAppRv;
                RecyclerView.ViewHolder childViewHolder = recyclerView3 != null ? recyclerView3.getChildViewHolder(findChildViewUnder) : null;
                Intrinsics.checkNotNull(childViewHolder);
                int adapterPosition = childViewHolder.getAdapterPosition();
                if (fromPosition >= 0 && fromPosition < this.mDataList.size() && adapterPosition >= 0 && adapterPosition < this.mDataList.size() && (lifecycleOwner = ViewTreeLifecycleOwner.get(itemView)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                    BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MyMiniAppDragManager$myMiniAppDragLocation$1(this, fromPosition, adapterPosition, null), 3, null);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "holder.adapterPosition" + fromPosition + " dragData.fromPosition\uff1a" + adapterPosition);
                }
                this.mLocationTime = System.currentTimeMillis();
                return;
            }
        }
        QLog.i(TAG, 1, "view == null or holder == null!");
    }

    public final boolean myMiniAppDragEvent(View view, DragEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.i(TAG, 1, "myMiniAppDragEvent DragEvent:" + event);
        switch (event.getAction()) {
            case 1:
                this.mLocationTime = System.currentTimeMillis();
                return true;
            case 2:
                myMiniAppDragLocation(view, event);
                return true;
            case 3:
                myMiniAppDragDrop(view, event);
                return true;
            case 4:
                this.mLocationToPosition = -1;
                this.mLocationFromPosition = -1;
                return true;
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }
}
