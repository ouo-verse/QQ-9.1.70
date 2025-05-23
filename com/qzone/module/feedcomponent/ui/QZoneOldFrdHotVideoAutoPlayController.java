package com.qzone.module.feedcomponent.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.module.feedcomponent.ui.QZoneOldFrdHotVideoListAdapter;
import com.qzone.module.feedcomponent.util.RecycleExtKt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\rH\u0002J\f\u0010\u0017\u001a\u00020\u0006*\u00020\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoAutoPlayController;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "needCheckOnRefresh", "", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCurrentPlayVideoView", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView;", "getNextPlayVideoView", "onBindViewHolder", "", "holder", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoListAdapter$FrdHotVideoViewHolder;", "position", "", "onPagePause", "onScrollStateChanged", "newState", "onStartRefreshData", "onStopScroll", "isHorizontalCompleteVisible", "Landroid/view/View;", "Companion", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneOldFrdHotVideoAutoPlayController extends RecyclerView.OnScrollListener {
    private static final String TAG = "QZoneOldFrdHotVideoAutoPlayController";
    private boolean needCheckOnRefresh;
    private final RecyclerView recyclerView;

    public QZoneOldFrdHotVideoAutoPlayController(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        recyclerView.addOnScrollListener(this);
    }

    private final boolean isHorizontalCompleteVisible(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int i3 = rect.left;
        return i3 > 0 && rect.right - i3 >= QZoneOldFrdHotVideoItemView.INSTANCE.getItemWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(QZoneOldFrdHotVideoAutoPlayController this$0, QZoneOldFrdHotVideoItemView this_with, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        if (this$0.needCheckOnRefresh && this$0.isHorizontalCompleteVisible(this_with)) {
            this$0.needCheckOnRefresh = false;
            QLog.i(TAG, 1, "start play video after refresh, position=" + i3);
            if (!this_with.hasVideoView()) {
                this_with.addVideoView();
            }
            FeedVideoView feedVideoView = this_with.getFeedVideoView();
            if (feedVideoView != null) {
                feedVideoView.onStateIdle();
            }
        }
    }

    private final void onStopScroll() {
        List mutableList;
        FeedVideoView feedVideoView;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) RecycleExtKt.getAllItemViewList(this.recyclerView));
        QZoneOldFrdHotVideoItemView nextPlayVideoView = getNextPlayVideoView();
        if (nextPlayVideoView != null && !nextPlayVideoView.hasVideoView()) {
            QLog.i(TAG, 1, "start play video after scroll, position=" + nextPlayVideoView.get_position());
            nextPlayVideoView.addVideoView();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            if (!Intrinsics.areEqual((QZoneOldFrdHotVideoItemView) obj, nextPlayVideoView)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((QZoneOldFrdHotVideoItemView) it.next()).removeVideoView();
        }
        if (nextPlayVideoView == null || (feedVideoView = nextPlayVideoView.getFeedVideoView()) == null) {
            return;
        }
        feedVideoView.onStateIdle();
    }

    public final QZoneOldFrdHotVideoItemView getCurrentPlayVideoView() {
        Object obj;
        Iterator it = RecycleExtKt.getAllItemViewList(this.recyclerView).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((QZoneOldFrdHotVideoItemView) obj).hasVideoView()) {
                break;
            }
        }
        return (QZoneOldFrdHotVideoItemView) obj;
    }

    public final QZoneOldFrdHotVideoItemView getNextPlayVideoView() {
        Object obj;
        Iterator it = RecycleExtKt.getVisibleItemViewList(this.recyclerView).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView = (QZoneOldFrdHotVideoItemView) obj;
            if (isHorizontalCompleteVisible(qZoneOldFrdHotVideoItemView) && qZoneOldFrdHotVideoItemView.canAutoPlay()) {
                break;
            }
        }
        return (QZoneOldFrdHotVideoItemView) obj;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void onBindViewHolder(QZoneOldFrdHotVideoListAdapter.FrdHotVideoViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final QZoneOldFrdHotVideoItemView videoItemView = holder.getVideoItemView();
        if (this.needCheckOnRefresh && videoItemView.canAutoPlay()) {
            videoItemView.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.c
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneOldFrdHotVideoAutoPlayController.onBindViewHolder$lambda$1$lambda$0(QZoneOldFrdHotVideoAutoPlayController.this, videoItemView, position);
                }
            });
        }
    }

    public final void onPagePause() {
        FeedAutoVideo autoVideoView;
        List visibleItemViewList = RecycleExtKt.getVisibleItemViewList(this.recyclerView);
        ArrayList<QZoneOldFrdHotVideoItemView> arrayList = new ArrayList();
        for (Object obj : visibleItemViewList) {
            if (((QZoneOldFrdHotVideoItemView) obj).hasVideoView()) {
                arrayList.add(obj);
            }
        }
        for (QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView : arrayList) {
            QLog.i(TAG, 1, "pause video, position=" + qZoneOldFrdHotVideoItemView.get_position());
            FeedVideoView feedVideoView = qZoneOldFrdHotVideoItemView.getFeedVideoView();
            if (feedVideoView != null && (autoVideoView = feedVideoView.getAutoVideoView()) != null) {
                autoVideoView.onPause();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            onStopScroll();
        }
    }

    public final void onStartRefreshData() {
        QLog.i(TAG, 1, "onStartRefreshData");
        this.needCheckOnRefresh = true;
    }
}
